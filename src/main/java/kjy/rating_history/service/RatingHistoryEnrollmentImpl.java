package kjy.rating_history.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kjy.rating_history.dao.RatingHistoryDAO;
import kjy.rating_history.dto.AvgDTO;
import kjy.rating_history.dto.RatingHistoryDTO;
@Service
public class RatingHistoryEnrollmentImpl implements RatingHistoryEnrollment {
  @Inject
   private RatingHistoryDAO dao;

   
@Override
public void Enrollment(RatingHistoryDTO dto) throws Exception {
	// TODO Auto-generated method stub
	dao.Enrollment(dto);
	
	
}

public List<AvgDTO> getAvg() {
	System.out.println(dao.getAvg());
	return dao.getAvg();
	
	
}
   
	
//	public void Enrollment (RatingHistoryDTO views) throws Exception {
//	dao.Enrollment(views);	
//	}

}
