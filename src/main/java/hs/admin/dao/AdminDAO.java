package hs.admin.dao;

/*
 * 20170802 정해선 작성
 * */
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import hs.member.dto.MemberDTO;

@Repository
public class AdminDAO {

	@Inject
	SqlSessionTemplate template;
	
	// 관리자 - 회원 검색 클릭시 회원 전체 리스트 가져옴
	public List<MemberDTO> adminMemberAllList(MemberDTO memberDTO) {
		//System.out.println("AdminDAO.adminMemberAllList().memberDTO:"+memberDTO);
		return template.selectList("adminMemberAllList",memberDTO);
	}
	
	// 관리자 - 회원 검색 조건대로 검색
	public List<MemberDTO> adminSearchMember(MemberDTO memberDTO) {
		System.out.println("AdminDAO.adminSearchMember().memberDTO:"+memberDTO);
		return template.selectList("adminSearchMember", memberDTO);
	}

}
