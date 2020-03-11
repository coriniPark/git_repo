package board.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board/boardWriteForm.do")
	public ModelAndView boardWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");
		
		//DB처리
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardWrite(boardDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("boardWrite.jsp");
		
		return modelAndView;
	}

	@RequestMapping(value = "/board/boardModifyForm.do")
	public ModelAndView boardModifyForm(HttpServletRequest request) {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// Form에 기존 내용을 표시하기 위해, 다시 DB에서 데이터 얻어오기(전체 데이터가 필요한거죠)
		//BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = boardService.boardView(seq); 
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardModifyForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardModify.do")
	public ModelAndView boardModify(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		//DB처리
		BoardDTO boardDTO = new BoardDTO();
		//DTO에 담는것
		boardDTO.setSeq(seq);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardModify(boardDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("seq", seq);
		
		modelAndView.setViewName("boardModify.jsp");
		return modelAndView;
		
	}
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) {
		//Data
		int pg = Integer.parseInt(request.getParameter("pg"));
		/* DB */
		// 1page당 다섯개씩 보여주기
		// pg = 1, rn>=1 and rn <=5
		// pg = 2, rn>=6 and rn <=10
		// pg = 3, rn>=10 and rn <=15
		int endNum = pg*5;
		int startNum = endNum-4;
		
		//BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> list = boardService.boardList(startNum, endNum);
		
		// paging 처리 [1][2][3]->이거
		// 총 글수: 12개라고 가정하면 총 페이지수는 3.(다섯개씩 보여주는 경우) ; (총글수+4)/5; 만일 10개씩 보여주면 총글수+9겠지?
		int totalA = boardService.getTotalA(); //총 글수 가져오기
		int totalP = (totalA + 4)/5; //총 페이지수 구하기
		
		//만약 총 페이지수가 8페이지 일 때, 3페이지씩만 출력; [1][2][3][다음] / [이전][4][5][6][다음] / [이전][7][8]
		int startPage = (pg-1)/3*3+1; // 여기서 3은 보여주고 싶은 페이지 수.
		int endPage = startPage + 2;
		if(endPage > totalP) {
			endPage = totalP;
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		
		modelAndView.setViewName("boardList.jsp");
		
		return modelAndView;
	}

	@RequestMapping(value = "/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		//BoardDAO boardDAO = new BoardDAO();
		// 조회수 증가 기능 추가
		boardService.updateHit(seq);
		// 목록의 1줄 데이터 얻어오기.
		
		BoardDTO boardDTO = boardService.boardView(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("boardDTO", boardDTO);
		
		modelAndView.setViewName("boardView.jsp");
		return modelAndView;
		
	}
	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		// data
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		//DB
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardDelete(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("su", su);
		
		modelAndView.setViewName("boardDelete.jsp");
		
		return modelAndView;
	}
}








