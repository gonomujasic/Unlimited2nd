package hs.mentor.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MentorInfoExistChkService {
	public String execute(Model model, HttpServletRequest request) throws IOException{
	HttpSession session = request.getSession();

	int gradeNumber = (int) session.getAttribute("grade_number");

	if (gradeNumber==2) {
		 System.out.println("멘토회원임");
		return "redirect:./MentorInfoList";
	} else {
		 System.out.println("멘토 회원아님");
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter writer = response.getWriter();
//		writer.println("<script type='text/javascript'>");
//		writer.println("alert('멘토 회원이 아닙니다. 멘토 정보를 등록해주세요.');");
//		writer.println(" location.href='./MentorInfoRegist'");
//		writer.println("</script>");
//		writer.flush();
		 model.addAttribute("chk","as");
		return "./mentor/MentorRegistForm";
	}
}

}
