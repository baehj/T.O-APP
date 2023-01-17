package com.ch.toapp.controller;



import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.toapp.model.Member;
import com.ch.toapp.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MemberService ms;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("loginForm")
	public String loginForm(Member member, Locale locale, Model model, HttpSession session, HttpServletRequest request) {
		
		/*
		
		int result = 0;
		Member member2 = ms.select(request.getParameter("email"));
		
		System.out.println(member2.toString());
		
		String path = "";
		if (member2 == null) {
			result = -1; // 없는 아이디
			model.addAttribute("result", result);
			path = "loginForm";
		} else if (member.getPw().equals(member2.getPw())) {
			result = 1;
			session.setAttribute("member_no", member2.getMember_no());
			session.setAttribute("email", member2.getEmail());
			session.setAttribute("type_no", member2.getType_no());
			path = "loginForm2";
		}
		
		*/
		
		return "loginForm";
	}

	
	// 이메일 중복 체크
	@RequestMapping(value = "login", produces = "text/html;charset=utf-8")
	@ResponseBody  // jsp를 통하지 않고 직접 문자를 전달해
	public String login(String email, String pw) {
		
		String result = "";
		Member member2 = ms.select(email);
		
		if (member2 == null) {
			result = "n"; // 없는 아이디
		} else if (pw.equals(member2.getPw())) {
			result = "y";
		} else {
			result = "n";
		}
		return result;
	}
	
	@RequestMapping("toAdd")
	public String toAdd(Locale locale, Model model) {
		return "toAdd";
	}
	
	@RequestMapping("check")
	public String check(Locale locale, Model model) {
		
		return "check";
	}
	
}
