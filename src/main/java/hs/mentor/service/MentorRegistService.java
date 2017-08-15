package hs.mentor.service;

/*
 * 20170801 정해선 작성
 * 발생오류 : updateGradeNumber에서 java.lang.NullPointerException 발생
 * 원인 : 
 * 해결방안 : 
 * */
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import hs.member.dao.MemberDAO;
import hs.member.dto.MemberDTO;
import hs.mentor.dao.MentorDAO;
import hs.mentor.dto.MentorDTO;

@Service
public class MentorRegistService {
	@Inject
	private MentorDAO mentorDAO;

	@Transactional
	public Model execute(Model model, HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		MentorDTO mentorDTO = new MentorDTO();

		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();

		boolean result = false;

		try {
			// id는 세션에 있는 값을 가져오고 나머지는 입력받은 값들을 가져옴
			String id = (String) session.getAttribute("id");
			mentorDTO.setId(id);
			// System.out.println("MentorRegistService ___memberDTO에서 가져온 id =
			// "+mentorDTO.getId());
			mentorDTO.setNation(request.getParameter("nation"));
			mentorDTO.setEdu_language1(request.getParameter("edu_language1"));
			mentorDTO.setEdu_language2(request.getParameter("edu_language2"));
			mentorDTO.setEdu_language3(request.getParameter("edu_language3"));
			System.out.println("MentorRegistService.mentorDTO:" + mentorDTO);
			result = mentorDAO.mentorInfoRegist(mentorDTO);
			System.out.println("MentorRegistService.result" + result);
			if (result == true) {
				// memberDTO.setId(id);
				// System.out.println("MentorRegistService.memberDTO의 아이디
				// :"+memberDTO);
				
				
				memberDAO.updateGradeNumber(id);
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script type='text/javascript'>");
				writer.println("alert('멘토 정보가 등록되었습니다. 다시 로그인 해주세요.');");
				
				writer.println(" location.href='./LoginForm.do'");
				writer.println("</script>");
				writer.flush();
				
			} else {
				System.out.println("멘토 정보 등록 실패");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}
}