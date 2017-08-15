package ryu.study.controller;


import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ryu.study.commentmodel.Criteria;
import ryu.study.commentmodel.PageMaker;
import ryu.study.model.StudyDTO;
import ryu.study.service.StudyService;

@Controller
@RequestMapping("/study/*")
public class StudyController {
	@Inject
	private StudyService studyservice;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(StudyDTO studyDTO, Model model) throws Exception {
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(StudyDTO studyDTO, RedirectAttributes rttr) throws Exception {
		studyservice.regist(studyDTO);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:./listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("list", studyservice.listAll());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("study_number") int studynumber, Model model) throws Exception {

		model.addAttribute(studyservice.read(studynumber));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("study_number") int study_number, RedirectAttributes rttr) throws Exception {

		studyservice.remove(study_number);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:./listAll";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int study_number, Model model) throws Exception {

		model.addAttribute(studyservice.read(study_number));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(StudyDTO studyDTO, RedirectAttributes rttr) throws Exception {
		System.out.println(studyDTO);
		studyservice.modify(studyDTO);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:./listAll";
	}

	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		model.addAttribute("list", studyservice.listCriteria(cri));
	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("list", studyservice.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(studyservice.listCountCriteria(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("study_number") int study_number, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {

		model.addAttribute(studyservice.read(study_number));
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("study_number") int study_number, Criteria cri, RedirectAttributes rttr) throws Exception {

		studyservice.remove(study_number);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:./listPage";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(@RequestParam("study_number") int study_number, @ModelAttribute("cri") Criteria cri, Model model)
			throws Exception {

		model.addAttribute(studyservice.read(study_number));
	}
}