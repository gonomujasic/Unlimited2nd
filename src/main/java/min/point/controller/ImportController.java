package min.point.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import min.point.dto.PointChargeDTO;
import min.point.service.PointService;

@Controller
@RequestMapping("/import")
public class ImportController {
	@Autowired
	PointService pointService;
	
	
	//포인트 충전폼에서 받은 값들 아임포트 api에 넣어주기
	@RequestMapping("/charge")
	public String PointChargeimport(PointChargeDTO pointChargeDTO, Model model){
		model.addAttribute("param",pointChargeDTO);
		return "point/point_charge_import";
	}
	

}
