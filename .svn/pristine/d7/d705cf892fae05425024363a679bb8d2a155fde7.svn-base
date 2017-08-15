package hs.member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.member.dao.MemberDAO;
import hs.member.dto.MemberDTO;

@Service
public class PersonalInfoChkService {

	@Inject
	private MemberDAO memberDAO;

	public String execute(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		MemberDTO memberDTO = new MemberDTO();
		// ID는 세션에 있는 아이디를, 비밀번호는 입력받은 비밀번호를
		String id = (String) session.getAttribute("id");
		// 세션에 있는 아이디를 가져와 memberDTO에 저장
		memberDTO.setId(id);
		// 사용자가 입력한 비밀번호를 파라미터로 가져와 memberDTO 에 저장
		memberDTO.setPassword(request.getParameter("password"));
		// boolean chkPw = memberDAO.chkPw(id,
		// request.getParameter("password"));
		memberDTO = memberDAO.chkPw(memberDTO);
		System.out.println("PersonalInfoChkService 의 memberDTO : " + memberDTO);

		// memberDTO 정보가 있으면 비밀번호 일치!
		if (memberDTO != null) {
			// if (chkPw == true) {
			System.out.println("비밀번호 일치-> 개인정보 수정 폼으로 이동");
			return "redirect:./MemberInfoModify";
		} else {
			// 비밀번호 불일치시 원래 있던 폼을 보여줌
			System.out.println("비밀번호 불일치");
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter writer = response.getWriter();
//			writer.println("<script type='text/javascript'>");
//			writer.println("alert('비밀번호가 맞지 않습니다.');");
//			writer.println("history.back();");
//			writer.println("</script>");
//			writer.flush();
//			writer.println("<a href=./member/PersonalChkForm.jsp></a>");
			model.addAttribute("chk","as");
			return "./member/PersonalInfoChkForm";
		}
	}
}