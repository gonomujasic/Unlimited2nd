package ryu.study.commentservice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ryu.study.commentdao.StudyCommentDAO;
import ryu.study.commentmodel.Criteria;
import ryu.study.commentmodel.StudyCommentDTO;

@Service
public class StudyCommentService {
	@Inject
    StudyCommentDAO studyCommentDAO;
    
    // 댓글 목록
    public List<StudyCommentDTO> listComment(Integer study_number) {
        return studyCommentDAO.list(study_number);
    }
    // 댓글 작성
    public void addComment(StudyCommentDTO studyCommentDTO) {
        studyCommentDAO.create(studyCommentDTO);
    }
    // 댓글 수정
    public void modifyComment(StudyCommentDTO studyCommentDTO) {
    	studyCommentDAO.update(studyCommentDTO);
    }
    // 댓글 삭제
    public void removeComment(Integer study_reply_number) {
    	studyCommentDAO.delete(study_reply_number);
    }
    public List<StudyCommentDTO> listCommentPage(Integer study_number, Criteria cri) throws Exception {
		return studyCommentDAO.listPage(study_number, cri);
	}
    public int count(Integer study_number) throws Exception {
		return studyCommentDAO.count(study_number);
	}
}