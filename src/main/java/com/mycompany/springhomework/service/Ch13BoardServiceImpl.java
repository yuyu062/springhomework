package com.mycompany.springhomework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springhomework.dao.Ch13BoardDao;
import com.mycompany.springhomework.dto.Ch13Board;
import com.mycompany.springhomework.dto.Ch13Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch13BoardServiceImpl implements Ch13BoardService{
	@Autowired
	private Ch13BoardDao boardDao;
	
	/*@Autowired
	private Ch13BoardDao boardDaoOld;*/
	
	@Override
	public void write(Ch13Board board) {
		boardDao.insert(board);
	}

	@Override
	public void remove(int bno) {
		boardDao.deleteByBno(bno);
	}

	@Override
	public void modify(Ch13Board board) {
		boardDao.updateByBno(board);
	}

	@Override
	public List<Ch13Board> getList(Ch13Pager pager) {
		List<Ch13Board> boardList = boardDao.selectByPage(pager);
	    return boardList;
	}

	@Override
	public Ch13Board getBoard(int bno) {
		Ch13Board board = boardDao.selectByBno(bno);
		return board;
	}

	@Override
	public void addHitcount(int bno) {
		Ch13Board board = boardDao.selectByBno(bno);
		board.setBhitcount(board.getBhitcount() + 1);
		boardDao.updateByBno(board);
		
	}
	@Override
	public int getTotalBoardNum() {
		int totalBoardNum = boardDao.count();
		return totalBoardNum;
	}
	
}
