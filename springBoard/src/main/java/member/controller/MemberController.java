package member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/main/index.do")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:../main/index.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/writeForm.do")
	public ModelAndView writeForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("writeForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/write.do")
	public ModelAndView write(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //post 방식일 때 한글깨짐 방지
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("repwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		// 2. DB에 저장
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setAddr(addr);
		
		//MemberDAO memberDAO = new MemberDAO();
		int su = memberService.write(memberDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("write.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/loginForm.do")
	public ModelAndView loginForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginForm.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/member/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		// MemberDAO memberDAO = new MemberDAO();
		String name = memberService.login(id, pwd);
		ModelAndView modelAndView = new ModelAndView();

		if (name != null) { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			modelAndView.setViewName("loginOk.jsp");

		} else { // 로그인 실패
			modelAndView.setViewName("loginFail.jsp"); // 페이지 이동
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request) {
		//MemberDAO memberDAO = new MemberDAO();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		MemberDTO memberDTO = memberService.memeberView(id);
		
		if(memberDTO==null){
			return null;
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memberDTO", memberDTO);
		modelAndView.addObject("memId", id);
		modelAndView.setViewName("modifyForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/modify.do")
	public ModelAndView modify(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //post 방식일 때 한글깨짐 방지
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		String logtime = request.getParameter("logtime");
		
		// 2. DB에 저장
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setAddr(addr);
		memberDTO.setLogtime(logtime);
		
		//MemberDAO memberDAO = new MemberDAO();
		HttpSession session = request.getSession();
		String memId = (String)session.getAttribute("memId");
		int su = memberService.modify(memberDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("memberDTO", memberDTO);
		modelAndView.addObject("memId", memId);
		modelAndView.setViewName("modify.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		// session 제거
		HttpSession session = request.getSession();
		session.removeAttribute("memId");    // 개별 삭제
		session.removeAttribute("memName");	 // 개별 삭제
		
		session.invalidate(); // 무효화(모두 지우기)
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("logout.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/checkId.do")
	public ModelAndView checkId(HttpServletRequest request) {
		// data
		String id = request.getParameter("id");
		// DB
		//MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberService.isExistId(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.addObject("exist", exist);
		modelAndView.setViewName("checkId.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/checkId2.do")
	public ModelAndView checkId2(HttpServletRequest request) {
		// data
		String id = request.getParameter("id");
		// DB
		//MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberService.isExistId(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.addObject("exist", exist);
		modelAndView.setViewName("checkId2.jsp");
		return modelAndView;
	}
}











