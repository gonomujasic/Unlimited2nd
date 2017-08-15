package hs.member.service;
import javax.inject.Inject;
/*
 * 2017-08-01 정해선 작성
 * 발생오류: A query was run and no Result Maps were found for the Mapped Statement 'Member.memberDetailInfo'. 
 * 원인 : resutlt Type을 안넣었음
 * 해결방안 : MemberMapper.xml에 resultType을 추가 
 * 
 * */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.member.dao.MemberDAO;
import hs.member.dto.MemberDTO;
@Service
public class MemberInfoModifyDetailService {
	
	@Inject
	private MemberDAO memberDAO;
	
	public Model execute(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		MemberDTO memberDTO = new MemberDTO();

		String id = (String) session.getAttribute("id");
		memberDTO.setId(id);
		memberDTO = memberDAO.memberDetailInfo(memberDTO);
		 System.out.println("MemberModifyDetailService" + memberDTO);
		if (memberDTO == null) {
			 System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		// 수정 페이지로 이동할 때 원래 있던 정보를 보여주기 위해 사용

		request.setAttribute("memberDTO", memberDTO);

		return model;
	}

}
