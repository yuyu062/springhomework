package com.mycompany.springhomework.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.springhomework.dto.Ch13Member;

@Mapper
public interface Ch13MemberDao {
	//menabled:기본값으로 1
	//mrole:기본값으로 'ROLE_USER'
	public int insert(Ch13Member member);
	public Ch13Member selectByMid(String mid);
	//mpassword, memail만 수정
	public int update(Ch13Member member); 
}
