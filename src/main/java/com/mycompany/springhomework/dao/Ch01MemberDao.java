package com.mycompany.springhomework.dao;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class Ch01MemberDao {
	public Ch01MemberDao() {
		log.info("실행");
	}
}
