package min.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ryu.notice.model.NoticeDTO;
import ryu.notice.service.NoticeService;
import ryu.study.model.StudyDTO;
import ryu.study.service.StudyService;


@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	NoticeService noticeService;
	@Autowired
	StudyService studyService;
	
//	@Autowired
//	RatingHistoryEnrollment ra;
	
	
		@RequestMapping("/home")
		public String GoHome(Model model) throws Exception{
			List<NoticeDTO>list = noticeService.listAll();
			List<StudyDTO>list3 = studyService.listAll();
//			System.out.println(list);
			model.addAttribute("noticelist",list);

			model.addAttribute("studylist",list3);
			return "main/home";
	}
		@RequestMapping("/personalInfoProcessingPolicy")
		public String PersonalInfoProcessingPolicy(){
			return "main/personalinfoprocessingpolicy";
		}
		
		@RequestMapping("/accessterms")
		public String AccessTerms(){
			return "main/accessterms";
		}
		

}
