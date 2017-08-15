package ryu.study.commentdao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ryu.study.commentmodel.Criteria;
import ryu.study.commentmodel.StudyCommentDTO;
@Repository
public class StudyCommentDAO {
	  @Inject
	  private SqlSession session;
	  private static String namespace = "ryu.study.mapper.Studyreplymapper";

	// 댓글 목록
	public List<StudyCommentDTO> list(Integer study_number) {
		return session.selectList(namespace + ".list", study_number);
	}
	// 댓글 작성
	public void create(StudyCommentDTO studyCommentDTO) {
		session.insert(namespace + ".create", studyCommentDTO);
	}
	// 댓글 수정
	public void update(StudyCommentDTO studyCommentDTO) {
		session.update(namespace + ".update", studyCommentDTO);
	}
	public void delete(Integer study_reply_number) {
		session.delete(namespace + ".delete", study_reply_number);
			}
	public List<StudyCommentDTO> listPage(Integer study_number, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("study_number", study_number);
		paramMap.put("cri", cri);
		return session.selectList(namespace + ".listPage", paramMap);
	}
	public int count(Integer study_number) throws Exception {
		return session.selectOne(namespace + ".count", study_number);
		
	}
}