package hs.member.controller;

/*
 * 2017-07-31~ 
 * 정해선 작성
 * 
 * */
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hs.member.dto.MemberDTO;
import hs.member.service.IdCheckService;
import hs.member.service.MemberDeleteService;
import hs.member.service.MemberInfoModifyDetailService;
import hs.member.service.MemberInfoModifyService;
import hs.member.service.MemberRegistService;
import hs.member.service.PersonalInfoChkService;
import hs.member.service.PwChangeService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberRegistService memberRegistService;
	@Autowired
	private IdCheckService IdCheckService;
	@Autowired
	private PersonalInfoChkService personalInfoChkService;
	@Autowired
	private MemberInfoModifyDetailService memberInfoModifyDetailService;
	@Autowired
	private MemberInfoModifyService memberInfoModifyService;
	@Autowired
	private MemberDeleteService memberDeleteService;
	@Autowired
	private PwChangeService pwChangeService;

	String path = "member/";

	// 회원 등록 폼
	@RequestMapping(value = "/MemberRegist", method = RequestMethod.GET)
	public String memberRegistForm() {
		System.out.println("MemberController.memberRegistForm() : 회원 등록폼으로 이동");
		return path + "MemberRegistForm";
	}

	// 회원 등록 처리(회원 등록이 완료되면 로그인 페이지로 넘어감)
	@RequestMapping(value = "/MemberRegist", method = RequestMethod.POST)
	public String memberRegist(Model model, MemberDTO memberDTO, HttpServletRequest request) throws IOException {
		System.out.println("MemberController.memberRegist() : 회원 등록처");
		memberRegistService.execute(model, memberDTO, request);
		return "redirect:../login/Login";
	}
	// 아이디 중복확인 처리

	@RequestMapping(value = "/IdCheck", method = RequestMethod.POST)
	public ResponseEntity<String> idCheck(@RequestBody String id, HttpServletRequest request) {
		ResponseEntity<String> result = null;
		try {
			IdCheckService.execute(id, request);
			MemberDTO memberDTO = (MemberDTO) request.getAttribute("memberDTO");
			System.out.println("memberdto" + memberDTO);
			if (memberDTO!= null) {
				result = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				System.out.println("중복");
			} else {				
				System.out.println("중복x 사용가능");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}

	// @RequestMapping(value = "/IdCheck", method = RequestMethod.POST)
	// public String idCheck( @RequestBody Model model, HttpServletRequest
	// request, HttpServletResponse response) throws IOException {
	// System.out.println("MemberController.idCheck() : 아이디 중복 확인 처리");
	// IdCheckService.execute(model, request, response);
	// return model;
	// }
	// 회원 마이페이지
	@RequestMapping(value = "/MemberInfoList")
	public String memberInfoListForm() {
		System.out.println("MemberController.memberInfoListForm() : 회원 리스트 폼으로 이동");
		return path + "MemberInfoList";
	}

	// 개인정보 관리 클릭시 비밀번호 확인하는 폼으로 이동
	@RequestMapping(value = "/PersonalInfoChk", method = RequestMethod.GET)
	public String PersonalInfoChkForm() {
		System.out.println("MemberController.PersonalInfoChkForm  : 비밀번호 확인 폼으로 이동");
		return path + "PersonalInfoChkForm";
	}

	// 개인정보관리 -> 비밀번호 확인 처리
	@RequestMapping(value = "/PersonalInfoChk", method = RequestMethod.POST)
	public String PersonalInfoChk(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("MemberController.PersonalInfoChk :  비밀번호 확인 처리");
		String result = personalInfoChkService.execute(model, request, response);
		return result;
	}

	// 개인정보 수정 폼 - 기존에 있던 정보도 출력
	@RequestMapping(value = "/MemberInfoModify", method = RequestMethod.GET)
	public String memberInfoModifyForm(Model model, HttpServletRequest request) {
		System.out.println("MemberController.memberInfoModifyForm() : 개인정보 수정 폼으로 이동, 기존에 있던 정보 출력");
		memberInfoModifyDetailService.execute(model, request);
		return path + "MemberInfoModify";
	}

	// 개인정보 수정 처리 - 완료시 마이페이지로 이동
	@RequestMapping(value = "/MemberInfoModify", method = RequestMethod.POST)
	public String memberInfoModify(Model model, HttpServletRequest request, MemberDTO memberDTO) throws IOException {
		
		System.out.println("MemberController.memberInfoModify() : 개인정보 수정 처리. 완료시 마이페이지로 이동"+memberDTO);
		memberInfoModifyService.execute(model, request, memberDTO);
		return memberInfoListForm();
	}

	// 개인정보 수정 - 비밀번호 변경 클릭시 변경 창으로 이동
	@RequestMapping(value = "/ChangePw", method = RequestMethod.GET)
	public String changePwForm() {
		System.out.println("MemberController.changePwForm  : 비밀번호 변경 폼으로 이동");
		return path + "MemberChangePw";
	}

	// 개인정보 수정 - 비밀번호 변경 처리
	@RequestMapping(value = "/ChangePw", method = RequestMethod.POST)
	public String changePw(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("MemberController.changePw :  비밀번호 변경 처리");
		pwChangeService.execute(model, request, response);
		return path + "MemberChangePwSuccess";
	}

	// 회원 탈퇴 폼으로 이동
	@RequestMapping(value = "/MemberDelete", method = RequestMethod.GET)
	public String memberDeleteForm() {
		System.out.println("MemberController. memberDeleteForm()  : 회원 탈퇴 폼으로 이동");
		return path + "MemberInfoDelete";
	}

	// 회원 탈퇴 처리
	@RequestMapping(value = "/MemberDelete", method = RequestMethod.POST)
	public String memberDelete(Model model, HttpServletRequest request) throws IOException {
		System.out.println("MemberController. memberDelete() :  회원 탈퇴 처리");
		memberDeleteService.execute(model, request);
		return path + "MemberInfoDeleteSuccess";
	}
}
