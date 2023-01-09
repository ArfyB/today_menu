package com.today.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.PageInfo;
import com.today.vo.BoardDTO;
import com.today.vo.CommentDTO;


@Mapper
public interface BoardMapper 
{
	List<BoardDTO> selectBoardList();	
	void insertBoard(BoardDTO board);
	void updateHitCount(int num) throws Exception;
	BoardDTO selectBoardDetail(BoardDTO b, int num) throws Exception;
	void updateBoard(BoardDTO board) throws Exception;
	void deleteBoard(int num) throws Exception;
	List<Map<String, Object>> boardList();
	public Map<String,Object> pages(PageInfo pageinfo);
	List<CommentDTO> commentList();
	void insertComment(CommentDTO c, int num);
}
