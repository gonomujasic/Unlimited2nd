package ryu.qna.controller;

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

import ryu.qna.commentmodel.PageMaker;
import ryu.qna.commentmodel.SearchCriteria;
import ryu.qna.model.QnaDTO;
import ryu.qna.service.QnaService;

@Controller
@RequestMapping("/sqna/*")
public class SearchQnaController {

  @Inject
  private QnaService qnaservice;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
    model.addAttribute("list", qnaservice.listSearchCriteria(cri));

    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);
    pageMaker.setTotalCount(qnaservice.listSearchCount(cri));

    model.addAttribute("pageMaker", pageMaker);
  }

  @RequestMapping(value = "/readPage", method = RequestMethod.GET)
  public void read(@RequestParam("qna_number") int qna_number, @ModelAttribute("cri") SearchCriteria cri, Model model)
      throws Exception {

    model.addAttribute(qnaservice.read(qna_number));
  }

  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
  public String remove(@RequestParam("qna_number") int qna_number, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

    qnaservice.remove(qna_number);

    rttr.addAttribute("page", cri.getPage());
    rttr.addAttribute("perPageNum", cri.getPerPageNum());
    rttr.addAttribute("searchType", cri.getSearchType());
    rttr.addAttribute("keyword", cri.getKeyword());

    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:./list";
  }

  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
  public void modifyPagingGET(int qna_number, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

    model.addAttribute(qnaservice.read(qna_number));
  }

  @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
  public String modifyPagingPOST(QnaDTO qnaDTO, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

    qnaservice.modify(qnaDTO);

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
  public String registPOST(QnaDTO qnaDTO, RedirectAttributes rttr) throws Exception {

    qnaservice.regist(qnaDTO);

    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:./list";
  }
  
  @RequestMapping("/getAttach/{qna_number}")
  @ResponseBody
  public List<String> getAttach(@PathVariable("qna_number") Integer qna_number) throws Exception{
	  return qnaservice.getAttach(qna_number);
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
