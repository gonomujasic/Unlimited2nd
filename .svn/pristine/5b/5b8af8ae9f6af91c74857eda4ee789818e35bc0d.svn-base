package hs.admin.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.member.dao.MemberDAO;
import hs.member.dto.MemberDTO;
import hs.mentor.dao.MentorDAO;
import hs.mentor.dto.MentorDTO;

@Service
public class AdminMemberDeleteService {

	@Inject
	private MentorDAO mentorDAO;
	@Inject
	private MemberDAO memberDAO;
	
	public Model execute(Model model, HttpServletRequest request) {
		
		boolean result1=false;
		boolean result2=false;
		
		String	id=request.getParameter("id");
		System.out.println(id);
		
		result2 = mentorDAO.mentorInfoDelete(id);
		System.out.println("result2 : " + result2);
		if (result2 == true) {
			System.out.println("멘토 정보 삭제 성공");
		} else {
			System.out.println("멘토 정보 삭제 실패");
		}
		
		result1=memberDAO.memberInfoDelete(id);
		if (result1 == true) {
			System.out.println("회원 탈퇴 성공");
			return null;
		} else {
			System.out.println("회원 탈퇴 실패");
		}
		
		return model;
	}
}
