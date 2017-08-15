package hs.studypage.controller;

/*
 * 2017-08-01~
 * */
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hs.mentor.service.MentorInfoExistChkService;
import hs.mentor.service.MentorModifyDetailService;
import hs.mentor.service.MentorModifyService;
import hs.mentor.service.MentorRegistService;
import hs.studypage.service.MemberHistoryStudyInfo;
import hs.studypage.service.MentorHistoryTechService;

@Controller
@RequestMapping("/studypage/*")
public class StudyPageController {

	@Autowired
	private MentorHistoryTechService mentorHistoryTechService;
	@Autowired
	private MemberHistoryStudyInfo memberHistoryStudyInfo;

	String path = "studypage/";

	// 마이페이지에서 학습페이지 클릭시 이동
	@RequestMapping(value = "/StudyPage")
	public String studyPageMainForm() throws IOException {
		System.out.println("StudyPageController.studyPageMainForm() : 학습페이지 메인 폼으로 이동");
		return path + "StudyPageMain";
	}

	// 멘토 지난 강좌 내역 확인
	@RequestMapping(value = "/MentorHistoryTeach")
	public String mentorHistoryTeach(Model model, HttpServletRequest request)
			throws IOException {
		System.out.println("StudyPageController.mentorHistoryTeach() : 멘토 지난 강좌 내역 확인");
		mentorHistoryTechService.execute(model, request);
		return path + "MentorHistoryTechForm";
	}

	// 멘티 지난 수강 내역 확인
	@RequestMapping(value = "/MemberHistoryStudyInfo")
	public String memberHistoryStudyInfo(Model model, HttpServletRequest request)
			throws IOException {
		System.out.println("StudyPageController.memberHistoryStudyInfo() : 멘티 지난 수강 내역 확인");
		memberHistoryStudyInfo.execute(model, request);
		return path + "MemberHistoryStudyInfoForm";
	}
}
