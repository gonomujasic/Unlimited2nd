package ryu.notice.commentservice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ryu.notice.commentdao.NoticeCommentDAO;
import ryu.notice.commentmodel.Criteria;
import ryu.notice.commentmodel.NoticeCommentDTO;

@Service
public class NoticeCommentService {
	@Inject
    NoticeCommentDAO noticeCommentDAO;
    
    // 댓글 목록
    public List<NoticeCommentDTO> listComment(Integer notice_number) {
        return noticeCommentDAO.list(notice_number);
    }
    // 댓글 작성
    public void addComment(NoticeCommentDTO noticeCommentDTO) {
        noticeCommentDAO.create(noticeCommentDTO);
    }
    // 댓글 수정
    public void modifyComment(NoticeCommentDTO noticeCommentDTO) {
    	noticeCommentDAO.update(noticeCommentDTO);
    }
    // 댓글 삭제
    public void removeComment(Integer notice_reply_number) {
    	noticeCommentDAO.delete(notice_reply_number);
    }
    public List<NoticeCommentDTO> listCommentPage(Integer notice_number, Criteria cri) throws Exception {
		return noticeCommentDAO.listPage(notice_number, cri);
	}
    public int count(Integer notice_number) throws Exception {
		return noticeCommentDAO.count(notice_number);
	}
}