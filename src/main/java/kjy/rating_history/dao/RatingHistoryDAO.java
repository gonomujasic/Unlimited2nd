package kjy.rating_history.dao;

import java.util.List;

import kjy.rating_history.dto.AvgDTO;
import kjy.rating_history.dto.RatingHistoryDTO;

public interface RatingHistoryDAO {

	
	public void Enrollment(RatingHistoryDTO dto) throws Exception;

	public List<AvgDTO> getAvg();  //admin dao를 이쪽으로 옮겼
    	
	
}
