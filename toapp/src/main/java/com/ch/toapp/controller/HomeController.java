package com.ch.toapp.controller;



import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

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
	public String check(Locale locale, Model model, HttpServletRequest request, @RequestParam("p_plus_file") MultipartFile[] files) {
		String name = request.getParameter("p_name");
		/* String[] titleArray = request.getParameterValues("p1[]"); */
		
		String titleArrayString = request.getParameter("p1[]");
		String title[] = titleArrayString.split(",");
		
		for(int i=0; i<files.length; i++) {
			String orginName = files[i].getOriginalFilename();
			String newName = title[i] +"_"+ orginName;
			System.out.println(newName);
		}
		
		return "check";
	}
	
}
