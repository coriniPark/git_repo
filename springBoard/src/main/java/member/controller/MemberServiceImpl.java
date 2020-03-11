package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public int write(MemberDTO memberDTO) {
		return memberDAO.write(memberDTO);
	}

	@Override
	public MemberDTO memeberView(String id) {
		return memberDAO.memeberView(id);
	}

	@Override
	public int modify(MemberDTO memberDTO) {
		return memberDAO.modify(memberDTO);
	}

	@Override
	public String login(String id, String pwd) {
		return memberDAO.login(id, pwd);
	}

	@Override
	public boolean isExistId(String id) {
		return memberDAO.isExistId(id);
	}

}
