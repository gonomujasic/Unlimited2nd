package hs.login.service;
/*
 *20170801 정해선
 * 발생오류 : 찾은 아이디를 IdFindSuccess.jsp로 넘겨줘야 jsp에서 아이디를 출력해주는데 출력을 못해주고있음
 * 원인 : jsp 로 넘겨주지 못하고 있음
 * 해결 : request.setAttribute("loginDTO", loginDTO); 추가
 * */

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.login.dao.LoginDAO;
import hs.login.dto.LoginDTO;
@Service
public class IdFindService {
	@Inject
	private LoginDAO loginDAO;
	
	public Model execute(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException{
		LoginDTO loginDTO = new LoginDTO();

		loginDTO.setName(request.getParameter("name"));
		loginDTO.setEmail(request.getParameter("email"));
		System.out.println("idFindService의 loginDTO___" + loginDTO);
		loginDTO = loginDAO.idFindProcess(loginDTO);
		
		if (loginDTO != null) {
			// 정보가 있으면 회원의 아이디를 보여줄것.
			System.out.println("id 찾기 성공");
			System.out.println("찾은 아이디 : " +loginDTO.getId());
			request.setAttribute("loginDTO", loginDTO);
			return model;
		} else {
			System.out.println("id 찾기 실패");
			// 정보가 없으면 입력된 정보가 없다는 alert 창을 띄워줄것.
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script type='text/javascript'>");
			writer.println("alert('일치하는 회원의 정보가 없습니다.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			return null;
		}

	}
}
