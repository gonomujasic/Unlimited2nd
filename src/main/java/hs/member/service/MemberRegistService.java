package hs.member.service;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hs.member.dao.MemberDAO;
import hs.member.dto.MemberDTO;
/*
 * 발생오류 : No qualifying bean of type [hs.member.service.MemberRegistService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. 
 * 원인 : Bean생성시 예외가 발생하여 생긴 에러
 * 해결방안 : @service 어노테이션을 지정해주고 root-context.xml 에 <context:component-scan base-package="hs"/>추가
 * 오류:MyBatisSystemException: nested exception is org.apache.ibatis.type.TypeException: Could not set parameters for mapping: ParameterMapping,java.sql.SQLException: 부적합한 열 유형: 1111
 * 원인 : myBatis에서 오라클 사용시 null에 대한 처리가 필요. profilePicture는 null이 어도 상관없어서 값을 지정 안했더니 오류 발생
 * 해결방안 : MemberMapper.xml에서 ,jdbcType=VARCHAR을 추가해줌 
 * */

@Service
public class MemberRegistService {

	@Inject
	private MemberDAO memberDAO;

	public Model execute(Model model, MemberDTO memberDTO, HttpServletRequest request) throws IOException {
//		MemberDTO memberDTO = new MemberDTO();

//		String realFolder = "";
//		String saveFolder = "./memberPicture";
//		int fileSize = 5 * 1024 * 1024;
//		realFolder = request.getSession().getServletContext().getRealPath(saveFolder);
//		System.out.println(realFolder);
		boolean result = false;

//		MultipartRequest multipartRequest = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
//		memberDTO.setId(multipartRequest.getParameter("id"));
//		// System.out.println(multipartRequest.getParameter("id"));
//		memberDTO.setPassword(multipartRequest.getParameter("password"));
//		memberDTO.setName(multipartRequest.getParameter("name"));
//		memberDTO.setNickName(multipartRequest.getParameter("nickName"));
//		memberDTO.setBirth(multipartRequest.getParameter("birth"));
//		memberDTO.setHp(multipartRequest.getParameter("hp"));
//		memberDTO.setEmail(multipartRequest.getParameter("email"));
//		memberDTO.setGender(multipartRequest.getParameter("gender"));
//		memberDTO.setProfilePicture(
//				multipartRequest.getFilesystemName((String) multipartRequest.getFileNames().nextElement()));

		System.out.println("MemberRegistService__" + memberDTO);
		result = memberDAO.memberRegist(memberDTO);
		if (result == true) {
			System.out.println("회원 등록 성공");
			return null;
		}
		System.out.println("회원가입 실패");
		return null;
	}
}
