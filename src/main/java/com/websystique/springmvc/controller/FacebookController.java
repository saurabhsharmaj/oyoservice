package com.websystique.springmvc.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserService;
import com.websystique.springmvc.utils.FacebookUtil;
import com.websystique.springmvc.utils.OAuthServiceProvider;

@RequestMapping(value = "/social/facebook")
@Component
public class FacebookController<FacebookApi> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FacebookController.class);
	private static final String FACEBOOK = "facebook";
	private static final String PUBLISH_SUCCESS = "success";
	private static final String PUBLISH_ERROR = "error";

	@Autowired
	UserService userService;
	
	@Autowired
	private ConnectionFactoryLocator connectionFactoryLocator;

	@Autowired
	private OAuth2Parameters oAuth2Parameters;

	@Autowired
	FacebookUtil facebookUtil;

	@Autowired
	@Qualifier("facebookServiceProvider")
	private OAuthServiceProvider<FacebookApi> facebookServiceProvider;

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		FacebookConnectionFactory facebookConnectionFactory = (FacebookConnectionFactory) connectionFactoryLocator
				.getConnectionFactory(FACEBOOK);
		OAuth2Operations oauthOperations = facebookConnectionFactory
				.getOAuthOperations();
		oAuth2Parameters.setState("recivedfromfacebooktoken");
		String authorizeUrl = oauthOperations.buildAuthorizeUrl(
				GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
		RedirectView redirectView = new RedirectView(authorizeUrl, true, true,
				true);

		return new ModelAndView(redirectView);
	}

	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String postOnWall(@RequestParam("code") String code,
			@RequestParam("state") String state, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		OAuthService oAuthService = facebookServiceProvider.getService();

		Verifier verifier = new Verifier(code);
		Token accessToken = oAuthService
				.getAccessToken(Token.empty(), verifier);

		FacebookTemplate template = new FacebookTemplate(accessToken.getToken());
		String [] fields = { "id", "email",  "first_name", "last_name" };
		
		org.springframework.social.facebook.api.User facebookProfile = template.fetchObject("me", org.springframework.social.facebook.api.User.class, fields);

		String userId = facebookProfile.getId();
		User user = userService.findBySSO(facebookProfile.getId());
		if(user != null){			
			//existing user.
			user.setUserProfiles(getDefaultProfile());
		} else {
			//register new user;
			user = new User();
			user.setFirstName(facebookProfile.getFirstName());
			user.setLastName(facebookProfile.getLastName());
			user.setEmail(facebookProfile.getEmail());
			user.setPassword("");
			user.setSsoId(facebookProfile.getId());
			user.setUserProfiles(getDefaultProfile());
			userService.saveUser(user);
		}
		
		Authentication auth =   new UsernamePasswordAuthenticationToken(user, null, user.getDefaultAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		LOGGER.info("Logged in User Id : {}", userId);

		return "redirect:/userHome";
	}

	private Set<UserProfile> getDefaultProfile() {
		Set<UserProfile> userProfiles = new HashSet<UserProfile>();
		UserProfile profile = new UserProfile();
		profile.setId(1);
		profile.setType("USER");
		userProfiles.add(profile);
		return userProfiles;
	}

	@RequestMapping(value = "/callback", params = "error_reason", method = RequestMethod.GET)
	@ResponseBody
	public void error(@RequestParam("error_reason") String errorReason,
			@RequestParam("error") String error,
			@RequestParam("error_description") String description,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			LOGGER.error(
					"Error occurred while validating user, reason is : {}",
					errorReason);
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
