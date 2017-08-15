package hs.admin.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.admin.dao.AdminDAO;
import hs.member.dto.MemberDTO;

@Service
public class AdminMemberAllList {

	@Inject
	private AdminDAO adminDAO;

	public Model execute(Model model, HttpServletRequest request) {

		 HttpSession session = request.getSession();
		
		
		List<?> memberAllList = new ArrayList<Object>();
		MemberDTO memberDTO = new MemberDTO();
		//System.out.println("AdminMemberAllList.memberDTO:" + memberDTO);	
		
		memberAllList = adminDAO.adminMemberAllList(memberDTO);
		//System.out.println("AdminMemberAllList.memberDTO:" + memberDTO);
		System.out.println("AdminMemberAllList의 memberAllList :" + memberAllList);

		if (memberAllList == null) {
			System.out.println("관리자모드 - 회원 정보 전체보기 실패 ");
			return null;
		}
		System.out.println("관리자모드 - 회원 정보 전체보기 성공");

		request.setAttribute("memberAllList", memberAllList);
		System.out.println("AdminMemberAllList.request.getAttribute(memberAllList)" + request.getAttribute("memberAllList"));
		return model;
	}

}
