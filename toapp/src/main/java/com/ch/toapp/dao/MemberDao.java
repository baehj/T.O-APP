package com.ch.toapp.dao;
import com.ch.toapp.model.Member;

public interface MemberDao {

	Member select(String email);

}
