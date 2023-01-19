package com.ch.toapp.dao;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.toapp.model.Member;
@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Override
	public Member select(String email) {
		return sst.selectOne("memberns.select", email); 
	}
	
}
