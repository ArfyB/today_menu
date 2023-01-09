package com.today.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.today.mapper.BoardMapper;
import com.today.vo.Attach;
import com.today.vo.BoardDTO;
import com.today.vo.CommentDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService
{
	@Autowired
	BoardMapper bm;
	
	@Override
	@Transactional
	public List<BoardDTO> selectBoardList() 
	{		
		return bm.selectBoardList();	
	}

	public static java.sql.Timestamp convert(java.util.Date date) 
	{
        return new java.sql.Timestamp(date.getTime());
    }
	
	@Override
	public void insertBoard(BoardDTO board) 
	{
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sqlTimeStamp = convert(utilDate);
		
		board.setCreatedDate(sqlTimeStamp);
		board.setUpdatedDate(sqlTimeStamp);
		bm.insertBoard(board);
	}
	
	@Override
	@Transactional
	public void insertComment(CommentDTO c, int num)
	{
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sqlTimeStamp = convert(utilDate);
		
		c.setCOM_CREATEDDATE(sqlTimeStamp);
		c.setUpdatedDate(sqlTimeStamp);
		bm.insertComment(c, num);
	}
	
	@Override
	@Transactional
	public BoardDTO selectBoardDetail(BoardDTO b, int num) throws Exception 
	{
		bm.updateHitCount(num);            
		return bm.selectBoardDetail(b, num);
	}
	
	@Override
	@Transactional 
	public void updateBoard(BoardDTO board) throws Exception
	{
        bm.updateBoard(board);
    }

	@Override
	@Transactional
    public void deleteBoard(int num) throws Exception
	{
        bm.deleteBoard(num);
    }
	
	@Override
	@Transactional
	public List<CommentDTO> commentList()
	{
		return bm.commentList();
	}
	
	
	
	
	public List<BoardDTO> boardList()
	{
		//dao.boardList();
		
		 
		 // Map 한개에 포함된 게시글 정보, 첨부파일 정보를 Board, Attach에 저장
		 List<Map<String,Object>> mlist = bm.boardList();
		 
		 System.out.println(mlist.toString());
		 
		 List<BoardDTO> list = new ArrayList<>();
		 
		 for(int i = 0; i<mlist.size(); i++)
		 {
		 Map<String, Object> m = mlist.get(i);	// 한행
		 
		 BigDecimal big = (java.math.BigDecimal) m.get("NUM");
		 BoardDTO board = new BoardDTO(big.intValue());
		 
		 boolean found = false;
		 
		 if(list.contains(board))
		 {
			 board = list.get(list.indexOf(board));
			 found = true;
		 }
		 	board.setTitle((String)m.get("TITLE"));
		 	board.setAuthor((String)m.get("AUTHOR"));
		 if((BigDecimal)m.get("CNT") != null)
		 {
			big = (BigDecimal)m.get("CNT");
		 	board.setCnt(big.intValue());
		 }
		 	Object objFname = m.get("FNAME");
		 if(objFname==null) 
		 {
		 	if(!found) list.add(board);
		 	continue;
		 }
		 
		 Attach att = new Attach();
		 att.setFname((String) objFname);
		 big = (BigDecimal)m.get("FNUM");
		 att.setNum(big.intValue());
		 big = (BigDecimal)m.get("FSIZE");
		 att.setFsize(big.intValue());
		 
		 board.getAttList().add(att);	// Board에 Attach 연결
		 if(!found) list.add(board);
		 }
		 
		 return list; 
				
 		
	}
	
	public Map<String,Object> pages(PageInfo pageinfo)
	{
		Map<String,Object> map = new HashMap<>();
		
		 System.out.println();
		
		int begin = pageinfo.getPageNum()-2;
		
		if(begin<=0)
		{
			begin = 1;
		}
		
		int end = pageinfo.getPageNum()+2;
		if(end>=pageinfo.getNavigateLastPage())
		{
			end = pageinfo.getNavigateLastPage();
		}
		
		
		map.put("begin", begin);
		map.put("end", end);
		return map;
	}
}
