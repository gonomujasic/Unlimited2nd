package ryu.notice.controller;


import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ryu.notice.commentmodel.Criteria;
import ryu.notice.commentmodel.PageMaker;
import ryu.notice.model.NoticeDTO;
import ryu.notice.service.NoticeService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Inject
	private NoticeService noticeservice;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(NoticeDTO noticeDTO, Model model) throws Exception {
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(NoticeDTO noticeDTO, RedirectAttributes rttr) throws Exception {
		noticeservice.regist(noticeDTO);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:./listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("list", noticeservice.listAll());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("notice_number") int noticenumber, Model model) throws Exception {

		model.addAttribute(noticeservice.read(noticenumber));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("notice_number") int notice_number, RedirectAttributes rttr) throws Exception {

		noticeservice.remove(notice_number);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:./listAll";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int notice_number, Model model) throws Exception {

		model.addAttribute(noticeservice.read(notice_number));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(NoticeDTO noticeDTO, RedirectAttributes rttr) throws Exception {
		System.out.println(noticeDTO);
		noticeservice.modify(noticeDTO);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:./listAll";
	}

	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		model.addAttribute("list", noticeservice.listCriteria(cri));
	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("list", noticeservice.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(noticeservice.listCountCriteria(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("notice_number") int notice_number, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {

		model.addAttribute(noticeservice.read(notice_number));
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("notice_number") int notice_number, Criteria cri, RedirectAttributes rttr) throws Exception {

		noticeservice.remove(notice_number);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:./listPage";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(@RequestParam("notice_number") int notice_number, @ModelAttribute("cri") Criteria cri, Model model)
			throws Exception {

		model.addAttribute(noticeservice.read(notice_number));
	}
}