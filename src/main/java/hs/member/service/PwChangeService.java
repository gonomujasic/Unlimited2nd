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
public class PwChangeService {
	
	@Inject
	private MemberDAO memberDAO;
	
	public Model execute(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		MemberDTO memberDTO = new MemberDTO();
		String id = (String) session.getAttribute("id");

		memberDTO.setId(id);
		memberDTO.setPassword(request.getParameter("password"));
		System.out.println("PwChangeService" + memberDTO);
		memberDTO = memberDAO.chkPw(memberDTO);

		boolean result = false;
		
		if (memberDTO != null) {
			System.out.println("현재 비밀번호와 일치. 변경해주기");
			memberDTO.setPassword(request.getParameter("newPassword"));
			System.out.println("변경하는 비밀번호" + memberDTO.getPassword());
			result = memberDAO.pwChange(memberDTO);
			if (result == false) {
				System.out.println("비밀번호 변경 등록 실패");
				return null;
			} else {
				System.out.println("비밀번호 변경 등록 성공");				
				return model;
			}
		} else {
			 System.out.println("현재 비밀번호와 불일치");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script type='text/javascript'>");
			writer.println("alert('현재 비밀번호가 맞지 않습니다. 다시 입력해주세요');");
			writer.println(" location.href='./ChangePw'");
			writer.println("</script>");
			writer.flush();
			return null;
		}
	}
}
