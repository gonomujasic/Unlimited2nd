package ryu.notice.commentdao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ryu.notice.commentmodel.Criteria;
import ryu.notice.commentmodel.NoticeCommentDTO;
@Repository
public class NoticeCommentDAO {
	  @Inject
	  private SqlSession session;
	  private static String namespace = "ryu.notice.mapper.Noticereplymapper";

	// 댓글 목록
	public List<NoticeCommentDTO> list(Integer notice_number) {
		return session.selectList(namespace + ".list", notice_number);
	}
	// 댓글 작성
	public void create(NoticeCommentDTO noticeCommentDTO) {
		session.insert(namespace + ".create", noticeCommentDTO);
	}
	// 댓글 수정
	public void update(NoticeCommentDTO noticeCommentDTO) {
		session.update(namespace + ".update", noticeCommentDTO);
	}
	public void delete(Integer notice_reply_number) {
		session.delete(namespace + ".delete", notice_reply_number);
			}
	public List<NoticeCommentDTO> listPage(Integer notice_number, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("notice_number", notice_number);
		paramMap.put("cri", cri);
		return session.selectList(namespace + ".listPage", paramMap);
	}
	public int count(Integer notice_number) throws Exception {
		return session.selectOne(namespace + ".count", notice_number);
		
	}
}