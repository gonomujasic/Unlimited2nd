package hs.mentor.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.mentor.dao.MentorDAO;
import hs.mentor.dto.MentorDTO;

@Service
public class MentorModifyDetailService {
	
	@Inject
	private MentorDAO mentorDAO;
	
	public Model execute(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();

		MentorDTO mentorDTO = new MentorDTO();

		String id = (String) session.getAttribute("id");
		mentorDTO.setId(id);
		mentorDTO = mentorDAO.mentorDetailInfo(mentorDTO);
		//System.out.println("MentorModifyDetailService" + mentorDTO);

		if (mentorDTO == null) {
			System.out.println("멘토 정보 상세보기 실패");
			return null;
		}
		System.out.println("멘토 정보 상세보기 성공");
		// 수정 페이지로 이동할 때 원래 있던 정보를 보여주기 위해 사용

		request.setAttribute("mentorDTO", mentorDTO);
		// System.out.println("MentorModifyDetailService" + mentorDTO);

		return model;
	}

}
