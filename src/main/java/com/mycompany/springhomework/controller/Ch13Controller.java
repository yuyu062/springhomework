package com.mycompany.springhomework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springhomework.dao.Ch13BoardDaoOldImpl;
import com.mycompany.springhomework.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch13/content";
	}
	
	@Resource
	private Ch13BoardDaoOldImpl ch13BoardDaoOld;
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		Ch13Board board = new Ch13Board();
		board.setBtitle("괴롭지?");
	    board.setBcontent("한번만 성공해, 그 뒤로는 쉬워~");
	    board.setMid("user");
		ch13BoardDaoOld.insert(board);
		return "redirect:/ch13/content";
	}
	  
   @GetMapping("/getBoardList")
   public String getBoardList() {
	   ch13BoardDaoOld.selectAll();
	   return "redirect:/ch13/content";
   }
   @GetMapping("/updateBoard")
   public String updateBoard() {
	   ch13BoardDaoOld.updateByBno();
	   return "redirect:/ch13/content";
   }
   @GetMapping("/deleteBoard")
   public String deleletBoard() {
	   ch13BoardDaoOld.deleteByBno();
	   return "redirect:/ch13/content";
   }
	 
}
