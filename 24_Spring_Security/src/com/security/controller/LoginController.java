package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		//return "plain-login";
		
		// spring frameworkun <form:form> tag kulland���m�z i�in csrf otomotik olarak tan�ml�yor
		return "fancy-login";
		
		// form tag kullanacak forum i�ine csrf tan�mlamam�z gerekiyor.
		//return "fancy-login-csrf";
	}
	
	// add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}

}
