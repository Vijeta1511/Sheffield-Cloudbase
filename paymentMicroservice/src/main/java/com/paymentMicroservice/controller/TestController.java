package com.paymentMicroservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/test/helloWorld")
	public String helloWorld() {
		return "hello"; // -> /WEB-INF/view/hello.jsp (prefix/viewName/Suffix)
	}

}
