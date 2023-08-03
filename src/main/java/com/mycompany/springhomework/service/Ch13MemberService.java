package com.mycompany.springhomework.service;

import com.mycompany.springhomework.dto.Ch13Member;

public interface Ch13MemberService {
	public static enum LoginResult{
		SUCCESS,
		FAIL_MID,
		FAIL_MPASSWORD,
		FAIL_ENABLED
	}
	public static enum JoinResult{
		SUCCESS,
		FAIL_DUPLICATED_MID
	}
	public JoinResult join(Ch13Member member);
	public  LoginResult login(Ch13Member member);
	public void modify(Ch13Member member);
	public void unjoin(String mid);
	public void logout(String mid);
	public Ch13Member getMember(String mid);
}
