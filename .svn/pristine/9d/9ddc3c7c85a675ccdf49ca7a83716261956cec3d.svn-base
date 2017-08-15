package hs.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hs.login.service.IdFindService;
import hs.login.service.InputNewPwService;
import hs.login.service.LoginService;
import hs.login.service.PwFindService;

/*
 * 2017-07-31~ 
 * 정해선 작성
 * 
 * */
@Controller
@RequestMapping("/login/*")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private IdFindService idFindService;
	@Autowired
	private PwFindService pwFindService;
	@Autowired
	private InputNewPwService inputNewPwService;

	// 경로 앞에 일일이 login을 붙여두는 대신 path를 붙여줄 것임
	String path = "login/";

	/*
	 * 발생오류 : No mapping found for HTTP request with URI
	 * [/Unlimited2nd/login/Login] in DispatcherServlet with name 'appServlet'
	 * 원인 : 매핑 실패, servlet-context.xml에 넣어주지 않았음 해결방안 : servlet-context.xml에
	 * <context:component-scan base-package="hs.member.controller"/> 추가
	 * 
	 * 발생오류 : 로그인 후 마이페이지로 이동시 경로가 바뀌지 않음 원인 : 매핑때문에 해결방안: redirect로 매핑을 다시 해줌
	 * return "redirect:../member/MemberInfoList";
	 */

	// 로그인 폼
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String loginServiceForm() {
		System.out.println("LoginController.loginServiceForm() : 로그인 폼으로 이동");
		return path + "LoginForm";
	}

	// 로그인 처리(로그인이 하면 메인 페이지로 넘어감)
	// 데이터를 담기위해 model 필요, 데이터를 가져오기 위해 request필요, 처리한 데이터를 보내주기 위해 response 필요!
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String loginService(Model model, HttpServletRequest request) throws IOException {
		System.out.println("LoginController.loginServiceForm() : 로그인 처리");
		loginService.execute(model, request);
		// LoginService에서 넘겨받음
		String failLogin = (String) request.getAttribute("failLogin");
		System.out.println("LoginController.loginServiceForm().failLogin:" + failLogin);
		String gradeNumber = (String) request.getAttribute("grade_number");
		System.out.println("LoginController.loginServiceForm().gradeNumber:  " + gradeNumber);
		// failLogin 값이 null이면 로그인 성공한거니까 마이페이지로 이동
		// gradeNumber가 null이면 일반회원. 둘다 만족해야 로그인이 성공
		if (failLogin == null && gradeNumber == null) {
			return "redirect:../main/home";
			// 로그인은 성공하고 등급번호에 값이 있으면 관리자 페이지로 이동
		} else if (failLogin == null && gradeNumber != null) {
			return "redirect:../admin/AdminMain";
		} else {
			// 로그인 실패시 alert창이 띄우고 싶음.
			// jsp 파일을 새로 만들어서 거기로 넘겨버림
			return path + "PwAlert";
			// 그게 아니라면 실패니까 다시 로그인 폼으로!
			// return "redirect:../login/Login";
		}
	}
	// 로그아웃 폼
	@RequestMapping(value = "/LogOut" )
	public String logOutForm() {
		System.out.println("LoginController.logOutForm() : 로그아웃 ");
		return path + "LogoutForm";
	}
	// ID/PW 찾으로 가는 폼
	@RequestMapping(value = "/IdPwFind")
	public String IdPwFindForm() {
		System.out.println("LoginController.IdPwFindForm() :아이디/패스워드 찾는 폼으로 이동");
		return path + "IdPwFindForm";
	}

	// id 찾기 처리
	@RequestMapping("IdFindService")
	public String idFindService(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("LoginController.idFindService() : 아이디 찾기 처리");
		idFindService.execute(model, request, response);
		return path + "IdFindSuccess";
	}

	// PW 찾기 처리 - 인증메일 발송
	@RequestMapping("PwFindService")
	public String pwFindService(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("LoginController.pwFindService() : 비밀번호 찾기 처리");
		pwFindService.execute(model, request, response);
		return path + "EmailChkForm";
	}

	// 비밀번호 변경 폼으로 감
	@RequestMapping(value = "/InputNewPw", method = RequestMethod.GET)
	public String inputNewPwForm() {
		System.out.println("LoginController.inputNewPwForm :비밀번호 변경 폼으로 이동");
		return path + "inputNewPw";
	}

	// 비밀번호 변경 처리(변경이 완료되면 로그인 페이지로 감)
	@RequestMapping(value = "/InputNewPw", method = RequestMethod.POST)
	public String inputNewPwService(Model model, HttpServletRequest request) throws IOException {
		System.out.println("LoginController.inputNewPwForm :비밀번호 변경 처리");
		inputNewPwService.execute(model, request);
		return loginServiceForm();
	}
}
