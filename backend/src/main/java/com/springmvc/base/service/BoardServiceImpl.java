package com.springmvc.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.base.mapper.BoardMapper;
import com.springmvc.base.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> resultmap = boardMapper.getBoardList();
		return resultmap;
	}
	
}
