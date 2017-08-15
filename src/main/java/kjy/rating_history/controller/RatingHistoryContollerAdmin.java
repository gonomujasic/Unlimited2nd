package kjy.rating_history.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kjy.rating_history.dto.AvgDTO;
import kjy.rating_history.service.AvgService;
import kjy.rating_history.service.RatingHistoryAdmin;
import kjy.rating_history.service.RatingHistoryEnrollment;


public class RatingHistoryContollerAdmin {
@Inject
private RatingHistoryEnrollment enrollment;
@Inject
private RatingHistoryAdmin service;
@Autowired
private AvgService avgService;

@RequestMapping(value = "/read", method = RequestMethod.GET)
public String read(Model model) throws Exception {
  List<AvgDTO>list = enrollment.getAvg();
  model.addAttribute("list", list);
  return "/rating_history/admin";
}
}
