package hs.studypage.dao;

/*
 * 20170802 정해선 작성
 * */
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import hs.studypage.dto.StudyPageDTO;

@Repository
public class StudyPageDAO {

	@Inject
	SqlSessionTemplate template;

	
	// 멘토 강의 내역 가저옴
	public List<StudyPageDTO> mentorHistoryTech(String mentor_id) {
		return template.selectList("mentorHistoryTech", mentor_id);
	}

	// 멘티 수강 내역 가저옴
	public List<StudyPageDTO> historyStudyInfo(StudyPageDTO studyPageDTO) {
		return template.selectList("historyStudyInfo", studyPageDTO);
	}
}
