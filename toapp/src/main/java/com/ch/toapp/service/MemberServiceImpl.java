package com.ch.toapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.toapp.dao.MemberDao;
import com.ch.toapp.model.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao md;
	
	@Override
	public Member select(String email) {
		return md.select(email);
	}

}
