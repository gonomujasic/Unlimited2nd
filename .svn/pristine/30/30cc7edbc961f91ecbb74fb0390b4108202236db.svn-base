package kjy.rating_history.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kjy.rating_history.dto.AvgDTO;
import kjy.rating_history.dto.RatingHistoryDTO;
import kjy.rating_history.service.RatingHistoryEnrollment;

@Controller

@RequestMapping("/rating/*") //views 폴더 
public class RatingHistoryController {
 private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RatingHistoryController.class);
//주입
@Inject
private RatingHistoryEnrollment enrollment;
//post  ,    리퀘스트 맵핑  ENROLLMENT 
@RequestMapping(value = "/Enrollment", method = RequestMethod.POST)
public String registerPOST(RatingHistoryDTO dto, Model model) throws Exception{
	LOGGER.info("Enro"
			+ "llment get ..........");
	System.out.println(dto); //찍기
 	enrollment.Enrollment(dto); 
 	return "redirect: ../studypage/MemberHistoryStudyInfo";
}

@RequestMapping(value = "/Enrollment", method = RequestMethod.GET)
public String registerGET(Model model, @RequestParam("mentor") String mentor, @RequestParam String mentee) throws Exception{
	LOGGER.info("Enrollment get ..........");
//service
	model.addAttribute("mentor_id",mentor);
	model.addAttribute("buyer",mentee);
	
	return "rating_history/ratingwrite";
}

@RequestMapping(value = "/read", method = RequestMethod.GET)
public String read(Model model) throws Exception {
  List<AvgDTO>list = enrollment.getAvg();
  model.addAttribute("list", list);
  return "/rating_history/admin";
}




}
