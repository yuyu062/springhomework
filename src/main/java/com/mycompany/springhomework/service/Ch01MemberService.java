package com.mycompany.springhomework.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch01MemberService {
	public Ch01MemberService() {
		log.info("실행");
	}
}
