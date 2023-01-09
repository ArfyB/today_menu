package com.today.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.ModelAndView;

import com.today.mapper.BoardMapper;
import com.today.service.BoardService;
import com.today.vo.BoardDTO;
import com.today.vo.CommentDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController 
{
    @Autowired
    BoardService svc;
    
    @Autowired
	BoardMapper bm;
    
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter()
    {
    	return new HiddenHttpMethodFilter();
    }
    
    
    
    @RequestMapping("/list")
    public ModelAndView openBoardList()
    {
		ModelAndView mv = new ModelAndView("thymeleaf/board/boardList");   
		List<BoardDTO> list = svc.selectBoardList();
		mv.addObject("list",list);                            
			
		return mv;
    }
    
    @RequestMapping("/add")
    public String add() 
    {
    	return "thymeleaf/board/boardWrite";
    }

    @RequestMapping("/insertBoard")
    public String insertBoard(BoardDTO board)throws Exception 
    {
    	System.out.println(board);
    	svc.insertBoard(board);
    	return "redirect:/board/list";
    }
   
    @RequestMapping("/cList")
    public ModelAndView cList()
    {
    	ModelAndView mv = new ModelAndView("thymeleaf/board/boardDetail");
    	List<CommentDTO> cList = svc.commentList();
    	mv.addObject("cList", cList);
    	
    	return mv;
    }
    
    @PostMapping("/insertC")
    public String insertC(CommentDTO c, int num)
    {
    	svc.insertComment(c, num);
    	return "forward:/board/boardDetail";
    }
    
    @RequestMapping("/boardDetail")
    public ModelAndView boardDetail(BoardDTO b, int num) throws Exception 
    {   
	    ModelAndView mv = new ModelAndView("thymeleaf/board/boardDetail");
	    BoardDTO board = svc.selectBoardDetail(b, num);
	    mv.addObject("board",board);
	    return mv;
    }
    
    @PutMapping("/update")
    public String updateBoard(BoardDTO board) throws Exception
    {
    	svc.updateBoard(board);
    	return "forward:/board/boardDetail";
    }
    
    @DeleteMapping("/delete")
    public String delete(int num) throws Exception 
    {
        svc.deleteBoard(num);
        return "redirect:/board/list";
    }
    
    
   /* 
    @RequestMapping("/update")
    public ModelAndView update(BoardDTO ) throws Exception 
    {
    	ModelAndView mv = new ModelAndView("thymeleaf/board/boardEdit");
	    BoardDTO b = svc.selectBoardDetail(num);
	    mv.addObject("board",b);
	    return mv;
    }
    
    @RequestMapping("/updateBoard/{num}")
    public String update(BoardDTO board)throws Exception 
    {    	
    	svc.updateBoard(board);
    	System.out.println(board);
    	return "forward:/board/boardDetail";
    }
    
        @GetMapping("/list/{page}/{row}")
	public String list(@PathVariable("page")int page,@PathVariable("row")int row, Model model)
	{		 
		 PageHelper.startPage(page,row);	
		 PageInfo <Map<String,Object>> pageinfo = new PageInfo<>(bm.boardList());	// List<Board>
		 log.info(pageinfo.toString());
		 
		 model.addAttribute("pageinfo", pageinfo);
		 model.addAttribute("pages", svc.pages(pageinfo));
		 
		 return  "/board/list";	 
	 }
    */

    

    

    
    
}
