package hs.login.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.login.dao.LoginDAO;
import hs.login.dto.LoginDTO;

/*
 * 20170802 정해선 
 * 발생오류 :Cannot call sendRedirect() after the response has been committed
 * 로그인 성공시 노상관이지만 실패시 오류발생
 * 	 원인 : service에서 response로인해 발생
 * 해결 : service의 response 삭제하고 loginService 컨트롤러 수정
 * */

@Service
public class LoginService {

	@Inject
	private LoginDAO loginDAO;

	public Model execute(Model model, HttpServletRequest request) throws IOException {

		// 로그인 입력된 값을 세션에 저장한다.
		// 세션이 유지되는 동안에는 값이 있도록!
		HttpSession session = request.getSession();
		LoginDTO loginDTO = new LoginDTO();

		loginDTO.setId(request.getParameter("id"));
		loginDTO.setPassword(request.getParameter("password"));
		loginDTO = loginDAO.loginProcess(loginDTO);
		System.out.println("LoginService : " + loginDTO);

		if (loginDTO != null) {
			// 저장된 세션이름이 id, 나중에 세션을 불러쓸때 이 이름을 사용함

			loginDTO.getName();

			session.setAttribute("id", loginDTO.getId());
			session.setAttribute("name", loginDTO.getName());
			session.setAttribute("nickName", loginDTO.getNickName());
			session.setAttribute("point", loginDTO.getPoint());
			session.setAttribute("grade_number", loginDTO.getGrade_number());
			System.out.println("로그인후 세션 값 확인= id: " + loginDTO.getId() + ",name: " + loginDTO.getName() + ", nickName: "
					+ loginDTO.getNickName() + ", point: " + loginDTO.getPoint() + ", grade_number: "
					+ session.getAttribute("grade_number"));			
			//등급번호로 로그인시 관리자 여부를 확인하기 위해 세션에 있는 등급번호를 가져옴
			int gradeNumber = (int) session.getAttribute("grade_number");
			System.out.println("LoginService.gradeNumber : "+gradeNumber);
			//등급번호가 3이면 관리자 아니면 일반회원
			if (gradeNumber == 3) {
				System.out.println("관리자입니다.");
				//controller로 보내주기 위해 request에 담아줌. 
				request.setAttribute("grade_number", "yes");
			} else {
				System.out.println("멘토/멘티 회원 입니다.");
			}
			return model;
		} else {
			System.out.println("로그인 실패");
			// 로그인 실패시 reqeust 에 담아서 controller 로 넘겨줌
			request.setAttribute("failLogin", "yes");
			return null;
		}
	}
}
