package ryu.study.commentcontroller;
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

import ryu.study.commentmodel.Criteria;
import ryu.study.commentmodel.PageMaker;
import ryu.study.commentmodel.StudyCommentDTO;
import ryu.study.commentservice.StudyCommentService;


// 컨트롤러 어노테이션
@RestController
@RequestMapping("/studyreplies")
public class StudyCommentController {
	@Inject
	private StudyCommentService studyCommentservice;
	
	//댓글 입력
	@RequestMapping(value = "", method = RequestMethod.POST)
	   public ResponseEntity<String> register(@RequestBody StudyCommentDTO studyCommentDTO){
		ResponseEntity<String> entity = null;
		try{
			studyCommentservice.addComment(studyCommentDTO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
    }
    
    // 댓글 목록(@RestController Json방식으로 처리 : 데이터를 리턴)
    @RequestMapping(value = "/all/{study_number}", method = RequestMethod.GET)
    public ResponseEntity<List<StudyCommentDTO>> list(@PathVariable("study_number") Integer study_number){
        ResponseEntity<List<StudyCommentDTO>> entity = null;
        try{
        	entity = new ResponseEntity<>(
        			studyCommentservice.listComment(study_number), HttpStatus.OK);
        } catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
        return entity;
    }
    // 댓글 수정
    @RequestMapping(value = "/{study_reply_number}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<String> update(@PathVariable("study_reply_number") Integer study_reply_number,
    		@RequestBody StudyCommentDTO studyCommentDTO){
    	System.out.println(studyCommentDTO);
    	ResponseEntity<String> entity = null;
    	try{
    		studyCommentDTO.setStudy_reply_number(study_reply_number);
    		studyCommentservice.modifyComment(studyCommentDTO);
    		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    	} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    	return entity;
    }
    // 댓글 삭제
    @RequestMapping(value = "/{study_reply_number}", method = RequestMethod.DELETE)
    public ResponseEntity<String> remove(@PathVariable("study_reply_number") Integer study_reply_number){
    	ResponseEntity<String> entity = null;
    	try{
    		studyCommentservice.removeComment(study_reply_number);
    		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    	} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    	return entity;
    }
    // 페이징 처리
    @RequestMapping(value = "/{study_number}/{page}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> listPage(
    		@PathVariable("study_number") Integer study_number, @PathVariable("page") Integer page){
    	ResponseEntity<Map<String, Object>> entity = null;
    	try{
    		Criteria cri = new Criteria();
    		cri.setPage(page);
    		PageMaker pageMaker = new PageMaker();
    		pageMaker.setCri(cri);
    		Map<String, Object> map = new HashMap<String, Object>();
    		List<StudyCommentDTO> list = studyCommentservice.listCommentPage(study_number, cri);
    		map.put("list", list);
    		int replyCount = studyCommentservice.count(study_number);
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
