package com.mycompany.springhomework.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.springhomework.dto.Ch02Dto;
import com.mycompany.springhomework.dto.Ch02FileInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
	 @RequestMapping("/content")
	 public String content() {
		 return "ch02/content";
	 }
	 
	 //@GetMapping("/method")
	 @RequestMapping(value="/method", method=RequestMethod.GET)
	 public String method1(String bkind, int bno) {
		 log.info("bkind: " + bkind);
		 log.info("bno: " + bno);
		 return "ch02/content";
	 }
	 //@PostMapping("/method")
	 @RequestMapping(value="/method", method=RequestMethod.POST)
	 public String method2(String bkind, int bno) {
		 log.info("bkind: " + bkind);
		 log.info("bno: " + bno);
		 return "ch02/content";
	 }
	 
	 //@PutMapping("/method")
	 @RequestMapping(value="/method", method=RequestMethod.PUT)
	 public void method3(Ch02Dto dto, HttpServletResponse response) throws Exception{
		 log.info("bkind: " + dto.getBkind());
		 log.info("bno: " + dto.getBno());
		 JSONObject root = new JSONObject();
		 root.put("result", "success");
		 String responseJson = root.toString(); // {"result":"success"}
		 
		 response.setContentType("application/json; charset=UTF-8");
		 PrintWriter pw = response.getWriter();
		 pw.print(responseJson);
		 pw.flush();
		 pw.close();
		 
		 
	 }
	 //@DeleteMapping("/method")
	 @RequestMapping(value="/method", method=RequestMethod.DELETE)
	 public void method4(@RequestBody String json, HttpServletResponse response) throws Exception {
		 JSONObject jsonObject = new JSONObject(json);
		 int bno = jsonObject.getInt("bno");
		 log.info("bno: " + bno);
		 
		 JSONObject root = new JSONObject();
		 root.put("result", "success");
		 String responseJson = root.toString(); // {"result":"success"}
		 
		 response.setContentType("application/json; charset=UTF-8");
		 PrintWriter pw = response.getWriter();
		 pw.print(responseJson);
		 pw.flush();
		 pw.close();
	 }
	 
	 @GetMapping("/ajax1")
	 public String ajax1(){
		 return "ch02/fragmentHtml";
	 }
	 
	 @GetMapping("/ajax2")
	 public void ajax2(HttpServletResponse response) throws Exception{
		 JSONObject root = new JSONObject();
		 root.put("fileName", "photo10.jpg");
		 String responseJson = root.toString(); // {"result":"success"}
		 
		 //직접 응답을 생성
		 response.setContentType("application/json; charset=UTF-8");
		 PrintWriter pw = response.getWriter();
		 pw.print(responseJson);
		 pw.flush();
		 pw.close();
	 }
	 
	 @GetMapping(value="/ajax3", produces="application/json; charset=UTF-8")
	 @ResponseBody //ajax3에 응답을 할 때  produces로 응답을 하고 응답 바디에 바로 들어감(jsp로 forward되지 않고 리턴값을 응답 본문에 바로 싣기)
	 public String ajax3() {
		 JSONObject root = new JSONObject();
		 root.put("fileName", "photo6.jpg");
		 String responseJson = root.toString(); 
		 return responseJson;
	 }
	 
	 @GetMapping(value="/ajax4", produces="application/json; charset=UTF-8")
	 @ResponseBody //리턴값을 JSON으로 변환(Jackson-databind 라이브러리가 필요함)해서 응답본문에 바로 싣기
	 public Ch02FileInfo ajax4() {
		 Ch02FileInfo fileinfo = new Ch02FileInfo();
		 fileinfo.setFileName("photo9.jpg");
		 return fileinfo;
	 }
}


