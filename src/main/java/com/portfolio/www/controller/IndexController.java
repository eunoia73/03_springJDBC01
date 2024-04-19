package com.portfolio.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	public IndexController() {
		System.out.println("============================생성됨============================");
	}
	
	@RequestMapping("/index.do")
	public String indexPage() {
		return "index";
	}
	
}
