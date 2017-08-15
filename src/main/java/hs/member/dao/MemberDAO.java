package hs.member.dao;



import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import hs.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Inject
	SqlSessionTemplate template;

	// 회원 등록
	public boolean memberRegist(MemberDTO memberDTO) {
		System.out.println("memberDAO.memberRegist().memberDTO:" + memberDTO);
		template.insert("memberRegist", memberDTO);
		return true;
	}

	// 아이디 중복 확인
//	public MemberDTO idCheckProcess(MemberDTO memberDTO) {
//		return template.selectOne("idCheckProcess", memberDTO);
//	}
	public MemberDTO idCheckProcess(String id) {
		return template.selectOne("idCheckProcess", id);
	}

	// 개인정보수정 폼으로 가기전 비밀번호 확인
	// public boolean chkPw(String id, String password) {
	// Map<String, Object> map = new HashMap();
	// map.put("id", id);
	// map.put("password", password);
	// MemberDTO memberDTO = template.selectOne("chkPw", map);
	// if (memberDTO == null) {
	// return false;
	// }
	// return true;
	// }

	// 개인정보수정 폼으로 가기전 비밀번호 확인
	public MemberDTO chkPw(MemberDTO memberDTO) {
		return template.selectOne("chkPw", memberDTO);
	}

	// 수정시 회원 상세정보 가져옴
	public MemberDTO memberDetailInfo(MemberDTO memberDTO) {
		return template.selectOne("memberDetailInfo", memberDTO);
	}

	// 회원 정보 수정
	public boolean memberInfoModify(MemberDTO memberDTO) {
		template.update("memberInfoModify", memberDTO);
		return true;
	}
	
	//비밀번호 변경
	public boolean pwChange(MemberDTO memberDTO) {
		template.update("pwChange", memberDTO);
		return true;
	}
	public boolean updateNumber(String id) {
		template.update("updateGradeNumber", id);
		return true;
	}
	

// 등급번호 업데이트 -- 널포인트 오류남
	public void updateGradeNumber(String id) {
		//System.out.println("MemberDAO.updateGradeNumber(). id: " + id);
		System.out.println("MemberDAO.updateGradeNumber(). template: " + template);
		template.update("updateGradeNumber", id);
	}
	// 회원 탈퇴
	public boolean memberInfoDelete(String id) {
		template.delete("memberInfoDelete", id);
		return true;
	}	
}
