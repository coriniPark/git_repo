package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
		
	@Autowired
	private SqlSessionTemplate sst;
	
	public int boardWrite(BoardDTO boardDTO) {
		return sst.insert("mybatis.boardMapper.boardWrite", boardDTO);
	}
	
	public int boardModify(BoardDTO boardDTO) { //글 수정
		return sst.update("mybatis.boardMapper.boardModify", boardDTO);
	}
	
	//목록 보기
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sst.selectList("mybatis.boardMapper.boardList", map);
	}
	
	//상세 보기
	public BoardDTO boardView(int seq) {
		return sst.selectOne("mybatis.boardMapper.boardView", seq);		
	}
	
	// 조회수 증가
	public int updateHit(int seq) {
		return sst.update("mybatis.boardMapper.updateHit", seq);
	}
	// 전체 글 목록 수 구하기
	public int getTotalA() {
		return sst.selectOne("mybatis.boardMapper.getTotalA");
		
	}
	//글 1개 삭제
	public int boardDelete(int seq) {
		return sst.delete("mybatis.boardMapper.boardDelete", seq);
		
	}
}
























