package com.mycompany.springhomework.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Ch01Util {
	public Ch01Util() {
		log.info("실행");
	}
}
