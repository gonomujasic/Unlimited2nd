package ryu.qna.controller;


import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ryu.qna.commentmodel.Criteria;
import ryu.qna.commentmodel.PageMaker;
import ryu.qna.model.QnaDTO;
import ryu.qna.service.QnaService;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	@Inject
	private QnaService qnaservice;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(QnaDTO qnaDTO, Model model) throws Exception {
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(QnaDTO qnaDTO, RedirectAttributes rttr) throws Exception {
		qnaservice.regist(qnaDTO);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:./listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("list", qnaservice.listAll());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("qna_number") int qnanumber, Model model) throws Exception {

		model.addAttribute(qnaservice.read(qnanumber));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("qna_number") int qna_number, RedirectAttributes rttr) throws Exception {

		qnaservice.remove(qna_number);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:./listAll";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int qna_number, Model model) throws Exception {

		model.addAttribute(qnaservice.read(qna_number));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(QnaDTO qnaDTO, RedirectAttributes rttr) throws Exception {
		System.out.println(qnaDTO);
		qnaservice.modify(qnaDTO);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:./listAll";
	}

	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		model.addAttribute("list", qnaservice.listCriteria(cri));
	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("list", qnaservice.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(qnaservice.listCountCriteria(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("qna_number") int qna_number, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {

		model.addAttribute(qnaservice.read(qna_number));
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("qna_number") int qna_number, Criteria cri, RedirectAttributes rttr) throws Exception {

		qnaservice.remove(qna_number);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:./listPage";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(@RequestParam("qna_number") int qna_number, @ModelAttribute("cri") Criteria cri, Model model)
			throws Exception {

		model.addAttribute(qnaservice.read(qna_number));
	}
}