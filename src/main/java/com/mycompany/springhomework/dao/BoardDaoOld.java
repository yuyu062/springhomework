package com.mycompany.springhomework.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.springhomework.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Repository
public interface BoardDaoOld {   
	   public void insert(Ch13Board board);
	   public List<Ch13Board> selectAll();
	   public void updateByBno(); 
	   public void deleteByBno();
}
