package com.mycompany.springhomework.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.springhomework.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Ch13BoardDaoOldImpl implements BoardDaoOld{
   @Resource
   private SqlSessionTemplate sst;
   
   @Override
   public void insert(Ch13Board board) {
      sst.insert("com.mycompany.springhomework.dao.mybatis.Ch13BoardDao.insert", board);
   }
   @Override
   public List<Ch13Board> selectAll() {
      List<Ch13Board> list = sst.selectList(
            "com.mycompany.springhomework.dao.mybatis.Ch13BoardDao.selectAll"
      );
      for(Ch13Board board : list) {
       log.info(board.toString());  
         
      }
      return list;
   }
   @Override
   public void updateByBno() {
	   List<Ch13Board> list = selectAll();
	   Ch13Board board = list.get(0);
	   board.setBtitle("변경된 제목");
	   board.setBcontent("변경된 내용");
	   
	   sst.update(
			   "com.mycompany.springhomework.dao.mybatis.Ch13BoardDao.updateByBno",
			   board
	   );
   }
   @Override
   public void deleteByBno() {
	   int bno = 42;
	   sst.delete(
			   "com.mycompany.springhomework.dao.mybatis.Ch13BoardDao.deleteByBno", 
			   bno
	   );
   }
}
