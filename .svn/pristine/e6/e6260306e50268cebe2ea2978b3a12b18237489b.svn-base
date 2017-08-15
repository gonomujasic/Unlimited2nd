package ryu.notice.commentcontroller;
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

import ryu.notice.commentmodel.Criteria;
import ryu.notice.commentmodel.PageMaker;
import ryu.notice.commentmodel.NoticeCommentDTO;
import ryu.notice.commentservice.NoticeCommentService;


// 컨트롤러 어노테이션
@RestController
@RequestMapping("/noticereplies")
public class NoticeCommentController {
	@Inject
	private NoticeCommentService noticeCommentservice;
	
	//댓글 입력
	@RequestMapping(value = "", method = RequestMethod.POST)
	   public ResponseEntity<String> register(@RequestBody NoticeCommentDTO noticeCommentDTO){
		ResponseEntity<String> entity = null;
		try{
			noticeCommentservice.addComment(noticeCommentDTO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
    }
    
    // 댓글 목록(@RestController Json방식으로 처리 : 데이터를 리턴)
    @RequestMapping(value = "/all/{notice_number}", method = RequestMethod.GET)
    public ResponseEntity<List<NoticeCommentDTO>> list(@PathVariable("notice_number") Integer notice_number){
        ResponseEntity<List<NoticeCommentDTO>> entity = null;
        try{
        	entity = new ResponseEntity<>(
        			noticeCommentservice.listComment(notice_number), HttpStatus.OK);
        } catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
        return entity;
    }
    // 댓글 수정
    @RequestMapping(value = "/{notice_reply_number}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<String> update(@PathVariable("notice_reply_number") Integer notice_reply_number,
    		@RequestBody NoticeCommentDTO noticeCommentDTO){
    	System.out.println(noticeCommentDTO);
    	ResponseEntity<String> entity = null;
    	try{
    		noticeCommentDTO.setNotice_reply_number(notice_reply_number);
    		noticeCommentservice.modifyComment(noticeCommentDTO);
    		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    	} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    	return entity;
    }
    // 댓글 삭제
    @RequestMapping(value = "/{notice_reply_number}", method = RequestMethod.DELETE)
    public ResponseEntity<String> remove(@PathVariable("notice_reply_number") Integer notice_reply_number){
    	ResponseEntity<String> entity = null;
    	try{
    		noticeCommentservice.removeComment(notice_reply_number);
    		entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    	} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    	return entity;
    }
    // 페이징 처리
    @RequestMapping(value = "/{notice_number}/{page}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> listPage(
    		@PathVariable("notice_number") Integer notice_number, @PathVariable("page") Integer page){
    	ResponseEntity<Map<String, Object>> entity = null;
    	try{
    		Criteria cri = new Criteria();
    		cri.setPage(page);
    		PageMaker pageMaker = new PageMaker();
    		pageMaker.setCri(cri);
    		Map<String, Object> map = new HashMap<String, Object>();
    		List<NoticeCommentDTO> list = noticeCommentservice.listCommentPage(notice_number, cri);
    		map.put("list", list);
    		int replyCount = noticeCommentservice.count(notice_number);
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
