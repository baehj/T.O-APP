package com.ch.toapp.controller;



import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.toapp.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	/* private MemberService ms; */
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("loginForm")
	/*public String loginForm(Locale locale, Model model, HttpSession session, HttpServletRequest request) {*/
	public String loginForm(Locale locale, Model model) {
		
		/*
		int result = 0;
		Member member2 = ms.select(request.getParameter("email"));
		
		
		System.out.println(member2.toString());
		
		
		if (member2 == null) {
			result = -1; // 없는 아이디
			model.addAttribute("result", result);
		} else if (member.getPw().equals(member2.getPw())) {
			result = 1;
			session.setAttribute("member_no", member2.getMember_no());
			session.setAttribute("email", member2.getEmail());
			session.setAttribute("type_no", member2.getType_no());
			return "loginForm";
		}
		*/
		return "loginForm";
	}

	
	@RequestMapping("loginForm2")
	
	public String loginForm2(Locale locale, Model model) {
		return "loginForm2";
	}

}
