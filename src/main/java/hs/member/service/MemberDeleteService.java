package hs.member.service;

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
public class MemberDeleteService {

	@Inject
	private MentorDAO mentorDAO;
	@Inject
	private MemberDAO memberDAO;

	public Model execute(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean result = false;
		boolean result2 = false;

		int gradeNumber = (int) session.getAttribute("grade_number");
		String id = (String) session.getAttribute("id");
		// 멘토 회원일 경우 멘토 정보부터 지워줌.
		if (gradeNumber == 2) {
			result2 = mentorDAO.mentorInfoDelete(id);
			System.out.println("result2 : " + result2);
			if (result2 == true) {
				System.out.println("멘토 정보 삭제 성공");
			} else {
				System.out.println("멘토 정보 삭제 실패");
			}
		}
		// 멘토 회원이 아닐경우 일반 회원 정보만 삭제
		result = memberDAO.memberInfoDelete(id);
		if (result == true) {
			session.invalidate();
			System.out.println("회원 탈퇴 성공");
			return null;
		} else {
			System.out.println("회원 탈퇴 실패");
		}
		return model;
	}
}
