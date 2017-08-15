package hs.mentor.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import hs.mentor.dto.MentorDTO;

@Repository
public class MentorDAO {

	@Inject
	SqlSessionTemplate template;

	// 멘토 정보 등록
	public boolean mentorInfoRegist(MentorDTO mentorDTO) {
		template.insert("mentorInfoRegist", mentorDTO);
		return true;
	}

	// 멘토 회원 수정시 기존 상세정보 가져옴
	public MentorDTO mentorDetailInfo(MentorDTO mentorDTO) {
		return template.selectOne("mentorDetailInfo", mentorDTO);
	}

	// 멘토 정보 수정
	public boolean mentorInfoModify(MentorDTO mentorDTO) {
		template.update("mentorInfoModify", mentorDTO);
		return true;
	}

	// 멘토 정보 삭제
	public boolean mentorInfoDelete(String id) {
		template.delete("mentorInfoDelete", id);
		return true;
	}

}
