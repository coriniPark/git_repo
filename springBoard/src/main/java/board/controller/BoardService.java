package board.controller;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	int boardWrite(BoardDTO boardDTO);
	int boardModify(BoardDTO boardDTO);
	List<BoardDTO> boardList(int startNum, int endNum);
	BoardDTO boardView(int seq);
	int updateHit(int seq);
	int getTotalA();
	int boardDelete(int seq);
}
