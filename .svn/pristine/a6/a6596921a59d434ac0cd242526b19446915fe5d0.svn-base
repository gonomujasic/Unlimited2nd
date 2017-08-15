package hs.mentor.service;
/*
 * 20170802 정해선
 * 발생오류 : 멘토정보 수정 완료시 alert창을 띄우고 멘토메인페이지로 와야하는데 수정페이지로 반복
 * 원인 : writer.println("history.back();");
 * 해결방안:  writer.println("history.back();"); 없애줌
 * */
import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.mentor.dao.MentorDAO;
import hs.mentor.dto.MentorDTO;

@Service
public class MentorModifyService {

	@Inject
	private MentorDAO mentorDAO;

	public Model execute(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		// System.out.println("session:"+session);
		MentorDTO mentorDTO = new MentorDTO();

		boolean result = false;

		String id = (String) session.getAttribute("id");

		mentorDTO.setId(id);
		mentorDTO.setNation(request.getParameter("nation"));
		mentorDTO.setEdu_language1(request.getParameter("edu_language1"));
		mentorDTO.setEdu_language2(request.getParameter("edu_language2"));
		mentorDTO.setEdu_language3(request.getParameter("edu_language3"));
		System.out.println("MentorModifyService:" + mentorDTO);

		result = mentorDAO.mentorInfoModify(mentorDTO);
		if (result == true) {
			System.out.println("멘토 정보 수정 완료");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script type='text/javascript'>");
			writer.println("alert('멘토 정보가 수정 되었습니다.');");
			//writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			writer.println("<a href=./MentorInfoList></a>");
			return model;
		} else {
			System.out.println("멘토 정보 수정 실패");
			return null;
		}
	}
}