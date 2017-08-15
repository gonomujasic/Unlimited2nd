package ryu.qna.commentcontroller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ryu.qna.commentmodel.Criteria;
import ryu.qna.commentmodel.PageMaker;
import ryu.qna.commentmodel.QnaCommentDTO;
import ryu.qna.commentservice.QnaCommentService;


// 컨트롤러 어노테이션
@RestController
@RequestMapping("/qnareplies")
public class QnaCommentController {
	@Inject
	private QnaCommentService qnaCommentservice;
	
	//댓글 입력
	@RequestMapping(value = "", method = RequestMethod.POST)
	   public ResponseEntity<String> register(@RequestBody QnaCommentDTO qnaCommentDTO){
		ResponseEntity<String> entity = null;
		try{
			qnaCommentservice.addComment(qnaCommentDTO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
    }
    
    // 댓글 목록(@RestController Json방식으로 처리 : 데이터를 리턴)
    @RequestMapping(value = "/all/{qna_number}", method = RequestMethod.GET)
    public ResponseEntity<List<QnaCommentDTO>> list(@PathVariable("qna_number") Integer qna_number){
        ResponseEntity<List<QnaCommentDTO>> entity = null;
        try{
        	entity = new ResponseEntity<>(
        			qnaCommentservice.listComment(qna_number), HttpStatus.OK);
        } catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
        return entity;
    }
    // 댓글 수정
    @RequestMapping(value = "/{qna_reply_number}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<String> update(@PathVariable("qna_reply_number") Integer qna_reply_number,
    		@RequestBody QnaCommentDTO qnaCommentDTO){
    	System.out.println(qnaCommentDTO);
    	ResponseEntity<String> entity = null;
    	try{
    		qnaCommentDTO.setQna_reply_number(qna_reply_number);
    		qnaCommentservice.modifyComment(qnaCommentDTO);
    		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    	} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    	return entity;
    }
    // 댓글 삭제
    @RequestMapping(value = "/{qna_reply_number}", method = RequestMethod.DELETE)
    public ResponseEntity<String> remove(@PathVariable("qna_reply_number") Integer qna_reply_number){
    	ResponseEntity<String> entity = null;
    	try{
    		qnaCommentservice.removeComment(qna_reply_number);
    		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    	} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    	return entity;
    }
    // 페이징 처리
    @RequestMapping(value = "/{qna_number}/{page}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> listPage(
    		@PathVariable("qna_number") Integer qna_number, @PathVariable("page") Integer page){
    	ResponseEntity<Map<String, Object>> entity = null;
    	try{
    		Criteria cri = new Criteria();
    		cri.setPage(page);
    		PageMaker pageMaker = new PageMaker();
    		pageMaker.setCri(cri);
    		Map<String, Object> map = new HashMap<String, Object>();
    		List<QnaCommentDTO> list = qnaCommentservice.listCommentPage(qna_number, cri);
    		map.put("list", list);
    		int replyCount = qnaCommentservice.count(qna_number);
    		pageMaker.setTotalCount(replyCount);
    		map.put("pageMaker", pageMaker);
    		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    		entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
    	return entity;
    }
}
