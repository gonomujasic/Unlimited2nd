package hs.admin.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import hs.admin.service.AdminMemberAllList;
import hs.admin.service.AdminMemberDeleteService;
import hs.admin.service.AdminSearchMemberService;
import hs.mentor.service.MentorInfoExistChkService;
import hs.mentor.service.MentorModifyDetailService;
import hs.mentor.service.MentorModifyService;
import hs.mentor.service.MentorRegistService;
import hs.studypage.service.MemberHistoryStudyInfo;
import hs.studypage.service.MentorHistoryTechService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	private AdminMemberAllList adminMemberAllList;
	@Autowired
	private AdminSearchMemberService adminSearchMemberService;
	@Autowired
	private AdminMemberDeleteService adminMemberDeleteService;

	String path = "admin/";

	// 관리자 계정으로 로그인시 관리자 메인페이지로 이동
	@RequestMapping(value = "/AdminMain")
	public String adminMainForm() throws IOException {
		System.out.println("AdminController.adminMainForm() : 관리자 메인 페이지로 이동");
		return path + "AdminMain";
	}

	// 관리자-회원 전체 목록으로 이동.
	@RequestMapping(value = "/AdminMemberAllList")
	public String adminMemberAllListFrom(Model model, HttpServletRequest request) throws IOException {
		System.out.println("AdminController.adminSearchMemberForm() : 관리자 -회원 전체 목록으로 이동");
		adminMemberAllList.execute(model, request);
		return path + "AdminMemberAllList";
	}

	// 관리자-회원 검색 폼으로 이동.
	@RequestMapping(value = "/AdminSearchMember", method = RequestMethod.GET)
	public String adminSearchMemberFrom(Model model, HttpServletRequest request) throws IOException {
		System.out.println("AdminController.adminSearchMemberForm() : 관리자 - 회원 검색 폼으로 이동");
		return path + "AdminSearchMember";
	}

	// 회원 검색 처리
	@RequestMapping(value = "/AdminSearchMemberView", method = RequestMethod.POST)
	public String adminSearchMember(Model model, HttpServletRequest request) throws IOException {
		System.out.println("AdminController.adminSearchMemberForm() : 관리자 - 회원 검색 처리");
		adminSearchMemberService.execute(model, request);
		return path + "AdminSearchMemberView";
	}

	// 관리자-회원 강퇴 폼으로 이동
	// @RequestParam("id")String id 아이디를 넘겨받음
	@RequestMapping(value = "/AdminMemberDeleteForm", method = RequestMethod.GET)
	public String adminMemberDeleteForm(Model model, HttpServletRequest request, @RequestParam("id") String id)
			throws IOException {
		System.out.println("AdminController.adminMemberDeleteForm() : 관리자 - 회원 강퇴폼으로 이동");
		// 넘겨받은 아이디를 model에 addAttribute로 저장. 이건 한번만 쓸 수 있음
		model.addAttribute("id", id);
		return path + "AdminMemberDelete";
	}

	// 회원 강퇴 처리
	@RequestMapping(value = "/AdminMemberDelete", method = RequestMethod.POST)
	public String adminMemberDelete(Model model, HttpServletRequest request) throws IOException {
		System.out.println("AdminController.adminMemberDelete() : 관리자 - 강퇴 처리");

		adminMemberDeleteService.execute(model, request);
		return path + "AdminMemberDeleteSuccess";
	}
}
