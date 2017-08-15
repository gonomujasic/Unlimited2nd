package hs.studypage.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.studypage.dao.StudyPageDAO;
import hs.studypage.dto.StudyPageDTO;
/*
 * 20170802 정해선 작성
 * 발생오류 : rror creating bean with name 'studyPageController': Injection of autowired dependencies failed
 * 원인 : 어노테이션 지정 안해줌
 * 해결방안 : @service와 @inject 어노테이션을 지정해줌
  * */

@Service
public class MemberHistoryStudyInfo {

	@Inject
	private StudyPageDAO studyPageDAO;

	public Model execute(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		StudyPageDTO studyPageDTO = new StudyPageDTO();
		List<?> studyPageList = new ArrayList<Object>();

		String id = (String) session.getAttribute("id");
		studyPageDTO.setId(id);
		studyPageList = studyPageDAO.historyStudyInfo(studyPageDTO);
		System.out.println(studyPageList);
		if (studyPageList == null) {
			System.out.println("지난 수강 내역 상세보기 실패 ");
			return null;
		}
		System.out.println("지난 수강 내역 상세보기 성공");

		request.setAttribute("studyPageList", studyPageList);
		System.out.println("MemberHistoryDetailService___" + studyPageList);
		return model;
	}

}
