package ryu.qna.commentservice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ryu.qna.commentdao.QnaCommentDAO;
import ryu.qna.commentmodel.Criteria;
import ryu.qna.commentmodel.QnaCommentDTO;

@Service
public class QnaCommentService {
	@Inject
    QnaCommentDAO qnaCommentDAO;
    
    // 댓글 목록
    public List<QnaCommentDTO> listComment(Integer qna_number) {
        return qnaCommentDAO.list(qna_number);
    }
    // 댓글 작성
    public void addComment(QnaCommentDTO qnaCommentDTO) {
        qnaCommentDAO.create(qnaCommentDTO);
    }
    // 댓글 수정
    public void modifyComment(QnaCommentDTO qnaCommentDTO) {
    	qnaCommentDAO.update(qnaCommentDTO);
    }
    // 댓글 삭제
    public void removeComment(Integer qna_reply_number) {
    	qnaCommentDAO.delete(qna_reply_number);
    }
    public List<QnaCommentDTO> listCommentPage(Integer qna_number, Criteria cri) throws Exception {
		return qnaCommentDAO.listPage(qna_number, cri);
	}
    public int count(Integer qna_number) throws Exception {
		return qnaCommentDAO.count(qna_number);
	}
}