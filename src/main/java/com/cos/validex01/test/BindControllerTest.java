package com.cos.validex01.test;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BindControllerTest {
	
	
	@GetMapping("/test/before")
	public void testBefore( HttpServletRequest request) {
		request.setAttribute("before", "안녕");
		System.out.println(request.getRequestURL());
		System.out.println("testBefore 실행됨");
	}

}
