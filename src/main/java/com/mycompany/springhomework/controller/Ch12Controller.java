package com.mycompany.springhomework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch12")
public class Ch12Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch12/content";
	}
}
