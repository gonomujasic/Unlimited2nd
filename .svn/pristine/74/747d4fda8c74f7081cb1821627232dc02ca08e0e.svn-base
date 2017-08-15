package hs.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hs.member.dao.MemberDAO;
import hs.member.dto.MemberDTO;

@Service
public class MemberInfoModifyService {

	@Inject
	private MemberDAO memberDAO;

	public Model execute(Model model, HttpServletRequest request, MemberDTO memberDTO) {
		HttpSession session = request.getSession();
//		MemberDTO memberDTO = new MemberDTO();

		boolean result = false;

		// System.out.println("MemberModifyService:" + memberDTO);
//		String realFolder = "";
//		String saveFolder = "./memberPicture";
//		int fileSize = 5 * 1024 * 1024;
//		realFolder = request.getSession().getServletContext().getRealPath(saveFolder);
		try {

//			MultipartRequest multipartRequest = null;
//			multipartRequest = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
//					new DefaultFileRenamePolicy());

//			memberDTO.setName(multipartRequest.getParameter("name"));
//			memberDTO.setNickName(multipartRequest.getParameter("nickName"));
//			// System.out.println("사용자 입력시 가져온 값__" +
//			// multipartRequest.getParameter("nickName"));
//			// System.out.println("MemberDTO에 넣어둔 값__ : " +
//			// memberDTO.getNickName());
//			memberDTO.setBirth(multipartRequest.getParameter("birth"));
//			memberDTO.setHp(multipartRequest.getParameter("hp"));
//			memberDTO.setEmail(multipartRequest.getParameter("email"));
//			// memberDTO.setGender(multipartRequest.getParameter("gender"));
//			memberDTO.setProfilePicture(
//					multipartRequest.getFilesystemName((String) multipartRequest.getFileNames().nextElement()));
//			memberDTO.setTempFile(multipartRequest.getParameter("tempFile"));
//
//			memberDTO.setIntroduceMySelf(multipartRequest.getParameter("introduceMySelf"));
//			System.out.println("MemberInfoModifyService__" + memberDTO);
			result = memberDAO.memberInfoModify(memberDTO);

			if (result == true) {
				session.setAttribute("name", memberDTO.getName());
				session.setAttribute("nickName", memberDTO.getNickName());
				System.out.println("수정 후 session 값 name: " + memberDTO.getName() + ", nickName: " + memberDTO.getNickName());
				System.out.println("MemberModifyService:" + memberDTO);
				System.out.println("회원정보 수정 완료");
				return model;
			}
			System.out.println("회원정보 수정 실패");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("회원정보 수정 실패");
		return null;
	}
}