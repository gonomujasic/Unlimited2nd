package kjy.rating_history.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kjy.rating_history.dao.RatingHistoryDAOImpl;
import kjy.rating_history.dto.AvgDTO;

@Service
public class AvgService {
	RatingHistoryDAOImpl dao = new RatingHistoryDAOImpl();
	public List<AvgDTO> execute() {
		return dao.getAvg();
	}
}
