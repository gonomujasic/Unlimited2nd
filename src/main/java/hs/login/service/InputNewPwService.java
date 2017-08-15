package hs.login.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.login.dao.LoginDAO;
import hs.login.dto.LoginDTO;
/*
 * 20170801 정해선 작성
 * [Request processing failed; nested exception is java.lang.IllegalStateException: getAttribute: Session already invalidated] 
 * java.lang.IllegalStateException: getAttribute: Session already invalidated
 *	세션을 초기화 한 후에 세션에 있는 정보를 가져오라고 하니 오류가 발생.
 *  
 * */
@Service
public class InputNewPwService {
	
	@Inject
	private LoginDAO loginDAO;
	
	public Model execute(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		LoginDTO loginDTO = (LoginDTO) session.getAttribute("loginDTO");

		System.out.println("세션에서 가져온 정보 : " + session.getAttribute("loginDTO"));
		String id = loginDTO.getId();
		String newPw=null;
		loginDTO.setPassword(request.getParameter("password"));
		newPw=loginDTO.getPassword();
		System.out.println("inputNewPwService의 새 비밀번호" + newPw);
	

		if (loginDAO.setPw(loginDTO) != 0) {
			System.out.println("변경 완료 -> 로그인 폼으로 이동");
			// 세션 초기화시킴
			session.invalidate();
			//System.out.println("초기화 후세션__" + session.getAttribute("loginDTO"));

			return model;

		}
		return null;
	}
}