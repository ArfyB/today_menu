package com.today.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.today.vo.BoardDTO;
import com.today.vo.CommentDTO;

public interface BoardService 
{	
	List<BoardDTO> selectBoardList();
	void insertBoard(BoardDTO board);
	BoardDTO selectBoardDetail(BoardDTO b, int num)throws Exception;
	void updateBoard(BoardDTO board) throws Exception;
	void deleteBoard(int num) throws Exception;
	public Map<String,Object> pages(PageInfo pageinfo);
	List<CommentDTO> commentList();
	void insertComment(CommentDTO c, int num);
}
