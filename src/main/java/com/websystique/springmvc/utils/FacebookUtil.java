package com.websystique.springmvc.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FacebookUtil {

	@Value("${app.config.oauth.facebook.apikey}")
	private String apikey;

}
