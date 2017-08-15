package hs.mentor.controller;

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

@Controller
@RequestMapping("/mentor/*")
public class MentorController {

	@Autowired
	private MentorInfoExistChkService mentorInfoExistChkService;
	@Autowired
	private MentorRegistService mentorRegistService;
	@Autowired
	private MentorModifyDetailService mentorModifyDetailService;
	@Autowired
	private MentorModifyService mentorModifyService;

	String path = "mentor/";

	// 멘토 마이페이지
	@RequestMapping(value = "/MentorInfoList")
	public String mentorInfoListForm() {
		System.out.println("MentorController.mentorInfoListForm() : 멘토 메인 리스트 폼으로 이동");
		return path + "MentorInfoList";
	}

	// 멘토인지 아닌지 등급번호로 확인
	@RequestMapping(value = "/MentorInfoExistChk")
	public String mentorInfoExistChk(Model model, HttpServletRequest request)
			throws IOException {
		System.out.println("MentorController.torInfoExistChk() : 멘토 정보 여부 확인");
		String result=mentorInfoExistChkService.execute(model, request);
		return result;
	}

	// 멘토 회원 정보 등록 폼
	@RequestMapping(value = "/MentorInfoRegist", method = RequestMethod.GET)
	public String memberRegistForm() {
		System.out.println("MentorController.memberRegistForm() : 멘토 정보 등록폼으로 이동");
		return path + "MentorRegistForm";
	}

	// 멘토 회원 정보 등록 처리
	@RequestMapping(value = "/MentorInfoRegist", method = RequestMethod.POST)
	public String memberRegist(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("MentorController.memberRegist() : 멘토 정보 등록 처리");
		mentorRegistService.execute(model, request, response);
		return mentorInfoListForm();
	}

	// 멘토 정보 수정 폼 - 기존에 있던 정보도 출력
	@RequestMapping(value = "/MentorInfoModify", method = RequestMethod.GET)
	public String mentorInfoModifyForm(Model model, HttpServletRequest request) {
		System.out.println("MentorController.mentorInfoModifyForm() : 멘토정보 수정 폼으로 이동, 기존에 있던 정보 출력");
		mentorModifyDetailService.execute(model, request);
		return path + "MentorInfoModify";
	}

	// 멘토 정보 수정 처리 - 완료시 멘토 메인 페이지로 이동
	@RequestMapping(value = "/MentorInfoModify", method = RequestMethod.POST)
	public String mentorInfoModify(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("MentorController.mentorInfoModify() : 멘토정보 수정 처리. 완료시 마이페이지로 이동");
		mentorModifyService.execute(model, request,response);
		return mentorInfoListForm();
	}

}
