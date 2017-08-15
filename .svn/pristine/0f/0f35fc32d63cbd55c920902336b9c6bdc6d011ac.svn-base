package hs.studypage.service;
/*
 * 20170802 정해선
 * 발생오류 : 부적합한 열이름 : 1111
 * 원인 :  StudyPageDao의 mentorHistoryTech에서 StudyPageDTO에서 오류발생
 * 해결방안 :  StudyPageDTO->String mentor_id 하나로 바꿔 줬음
 * 
 * 발생오류: TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 3
 * 원인 : StudyPageDao.mentorHistoryTech()에서 mapper를 이용해 값을 가져올 때 값은 많은데 하나만 가져오라고 해서 오류 발생
 * 해결방안 : selectOne->selectList로 변경
 * */
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.studypage.dao.StudyPageDAO;
import hs.studypage.dto.StudyPageDTO;
@Service
public class MentorHistoryTechService {
	
	@Inject
	private StudyPageDAO studyPageDAO;
		
	public Model execute(Model model, HttpServletRequest request){
		
	HttpSession session = request.getSession();
	List<?> studyPageList = new ArrayList<Object>();

	String mentor_id = (String) session.getAttribute("id");
	System.out.println("MentorHistoryTechService의 mentod_id :" +mentor_id);
    //	studyPageDTO.setMentor_id(mentor_id);
    //	System.out.println("MentorHistoryTechService.studyPageDTO: "+studyPageDTO);
    //	studyPageList = studyPageDAO.mentorHistoryTech(studyPageDTO);
	studyPageList= studyPageDAO.mentorHistoryTech(mentor_id);
	System.out.println("MentorHistoryTechService의 studyPageList :"+studyPageList);
	if (studyPageList == null) {
		System.out.println("지난 강의 내역 상세보기 실패 ");
		return null;
	}
	System.out.println("지난 강의 내역 상세보기 성공");

	request.setAttribute("studyPageList", studyPageList);
	System.out.println("MentorHistoryTechService : " + studyPageList);

	return model;
}

}
