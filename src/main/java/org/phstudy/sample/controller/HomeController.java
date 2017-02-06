package org.phstudy.sample.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.phstudy.sample.model.ServiceCenter;
import org.phstudy.sample.service.ServiceCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net._01001111.text.LoremIpsum;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ServiceCenterService serviceCenterService; 	

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Resource
	private ElasticsearchTemplate elasticsearchTemplate;

	private static final int MINCOUNT = 100;
	private static final int MAXCOUNT = 10;

	@PostConstruct
	private void initData() {
		List<IndexQuery> indexQueries = new ArrayList<IndexQuery>();
		LoremIpsum lorem = new LoremIpsum();
		for (int i = MINCOUNT; i < MAXCOUNT; i++) {/*
			String documentId = UUID.randomUUID().toString();
			Book book = new Book();
			book.setId(documentId);
			book.setName(lorem.randomWord());
			book.setMessage(lorem.sentence());
			book.setPrice(RandomUtils.nextDouble());
			IndexQuery indexQuery = new IndexQueryBuilder()
					.withId(book.getId()).withObject(book).build();
			indexQueries.add(indexQuery);
		*/}
		
		
		List<ServiceCenter> serviceCenters = serviceCenterService.listServiceCenters();
		for (ServiceCenter servicecenter : serviceCenters) {
			System.out.println(servicecenter);
			IndexQuery indexQuery = new IndexQueryBuilder()
					.withId(servicecenter.getId().toString()).withObject(servicecenter).build();
			indexQueries.add(indexQuery);
		}
		
		// bulk index
				elasticsearchTemplate.bulkIndex(indexQueries);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("url", "./rest/servicecenter");
		return "homePage";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("adminPage");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("loginPage");

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403Page");
		return model;

	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String traditional(Locale locale, Model model,
			@RequestParam(value = "query", required = false) String query,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page, @RequestParam(value = "size", required = false, defaultValue = "10") int size) {/*

		page -= 1;

		Pageable pageable = new PageRequest(page, size);

		Page<Book> pageObj;
		if (StringUtils.isBlank(query)) {
			pageObj = bookRepository.findAll(pageable);
		} else {
			pageObj = bookRepository.findByMessage(query, pageable);
		}
		
		model.addAttribute("total", pageObj.getTotalPages());
		model.addAttribute("books", pageObj.getContent());
		model.addAttribute("page", page + 1);
		
	*/	return "traditionalPage";
	}	
}
