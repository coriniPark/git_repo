package member.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.bean.MemberDTO;

@Repository
public class MemberDAO { // Data 'Access' Object
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public int write(MemberDTO memberDTO) {
		return sst.insert("mybatis.memberMapper.write", memberDTO);
	}
	public MemberDTO memeberView(String id) {
		return sst.selectOne("mybatis.memberMapper.memberView", id);
	}
	
	public int modify(MemberDTO memberDTO) { //정보수정
		return sst.update("mybatis.memberMapper.modify", memberDTO);
	}
	
	// login 작업
	public String login(String id, String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		return sst.selectOne("mybatis.memberMapper.login", map);
	}
	
	// ID 중복체크 하는 method; checkId.jsp와 연동
	public boolean isExistId(String id) {
		boolean exist = false;
		if(sst.selectOne("mybatis.memberMapper.isExistId", id) != null) {
			exist = true;
		}
		return exist;
	}
	
}
















