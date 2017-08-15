package ryu.qna.commentdao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ryu.qna.commentmodel.Criteria;
import ryu.qna.commentmodel.QnaCommentDTO;
@Repository
public class QnaCommentDAO {
	  @Inject
	  private SqlSession session;
	  private static String namespace = "ryu.qna.mapper.replymapper";

	// 댓글 목록
	public List<QnaCommentDTO> list(Integer qna_number) {
		return session.selectList(namespace + ".list", qna_number);
	}
	// 댓글 작성
	public void create(QnaCommentDTO qnaCommentDTO) {
		session.insert(namespace + ".create", qnaCommentDTO);
	}
	// 댓글 수정
	public void update(QnaCommentDTO qnaCommentDTO) {
		session.update(namespace + ".update", qnaCommentDTO);
	}
	public void delete(Integer qna_reply_number) {
		session.delete(namespace + ".delete", qna_reply_number);
			}
	public List<QnaCommentDTO> listPage(Integer qna_number, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("qna_number", qna_number);
		paramMap.put("cri", cri);
		return session.selectList(namespace + ".listPage", paramMap);
	}
	public int count(Integer qna_number) throws Exception {
		return session.selectOne(namespace + ".count", qna_number);
		
	}
}