package ryu.study.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ryu.study.commentmodel.PageMaker;
import ryu.study.commentmodel.SearchCriteria;
import ryu.study.model.StudyDTO;
import ryu.study.service.StudyService;

@Controller
@RequestMapping("/sstudy/*")
public class SearchStudyController {

  @Inject
  private StudyService studyservice;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
    model.addAttribute("list", studyservice.listSearchCriteria(cri));

    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);
    pageMaker.setTotalCount(studyservice.listSearchCount(cri));

    model.addAttribute("pageMaker", pageMaker);
  }

  @RequestMapping(value = "/readPage", method = RequestMethod.GET)
  public void read(@RequestParam("study_number") int study_number, @ModelAttribute("cri") SearchCriteria cri, Model model)
      throws Exception {

    model.addAttribute(studyservice.read(study_number));
  }

  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
  public String remove(@RequestParam("study_number") int study_number, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

    studyservice.remove(study_number);

    rttr.addAttribute("page", cri.getPage());
    rttr.addAttribute("perPageNum", cri.getPerPageNum());
    rttr.addAttribute("searchType", cri.getSearchType());
    rttr.addAttribute("keyword", cri.getKeyword());

    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:./list";
  }

  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
  public void modifyPagingGET(int study_number, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

    model.addAttribute(studyservice.read(study_number));
  }

  @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
  public String modifyPagingPOST(StudyDTO studyDTO, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

    studyservice.modify(studyDTO);

    rttr.addAttribute("page", cri.getPage());
    rttr.addAttribute("perPageNum", cri.getPerPageNum());
    rttr.addAttribute("searchType", cri.getSearchType());
    rttr.addAttribute("keyword", cri.getKeyword());

    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:./list";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void registGET() throws Exception {
  }
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String registPOST(StudyDTO studyDTO, RedirectAttributes rttr) throws Exception {

    studyservice.regist(studyDTO);

    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:./list";
  }
  
  @RequestMapping("/getAttach/{study_number}")
  @ResponseBody
  public List<String> getAttach(@PathVariable("study_number") Integer study_number) throws Exception{
	  return studyservice.getAttach(study_number);
  }

  // @RequestMapping(value = "/list", method = RequestMethod.GET)
  // public void listPage(@ModelAttribute("cri") SearchCriteria cri,
  // Model model) throws Exception {
  //
  // logger.info(cri.toString());
  //
  // model.addAttribute("list", service.listCriteria(cri));
  //
  // PageMaker pageMaker = new PageMaker();
  // pageMaker.setCri(cri);
  //
  // pageMaker.setTotalCount(service.listCountCriteria(cri));
  //
  // model.addAttribute("pageMaker", pageMaker);
  // }
}
