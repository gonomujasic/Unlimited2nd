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

@Service
public class PwFindService {
	
	@Inject
	private LoginDAO loginDAO;
	
	public Model execute(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		LoginDTO loginDTO = new LoginDTO();

		loginDTO.setId(request.getParameter("id"));
		loginDTO.setName(request.getParameter("name"));
		// 이메일은 변경될 수 있기 때문에 입력받은 이메일 사용
		String email = request.getParameter("email");

		loginDTO = loginDAO.pwFindProcess(loginDTO);
		System.out.println("pwFindService의 loginDTO___" + loginDTO);
		if (loginDTO != null) {
			// 정보가 있으면 이메일 인증 단계로 넘어가기
			// System.out.println("id 찾기 성공");
			SendEmailService sendEmailService = new SendEmailService();
			String num = sendEmailService.RandomNum();
			System.out.println("랜덤 숫자 생성 : "+num);
			sendEmailService.sendMail(null, email, num);
			System.out.println(num+"번호로 입력한 이메일에 인증번호 발송");
			
			session.setAttribute("num", num);
			session.setAttribute("loginDTO", loginDTO);
			System.out.println(session.getAttribute("loginDTO"));

			System.out.println("세션에 저장된 인증번호 : "+session.getAttribute("num"));

			return model;
		} else {
			// 정보가 없으면 입력된 정보가 없다는 alert 창을 띄워줄것.
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script type='text/javascript'>");
			writer.println("alert('일치하는 회원의 정보가 없습니다.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			// writer.println("<a href=./PwFindService.do></a>");
			return null;
		}

	}
}
