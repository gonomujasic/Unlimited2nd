package kjy.rating_history.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kjy.rating_history.dto.AvgDTO;
import kjy.rating_history.dto.RatingHistoryDTO;
@Repository
public class RatingHistoryDAOImpl implements RatingHistoryDAO {

	 @Inject
	  private SqlSessionTemplate session;

	  private static String namespace = "kjy.rating_history.mapper.EnrollmentMapper"; //   mapper 
	
	@Override
	public void Enrollment(RatingHistoryDTO dto) throws Exception {
		session.insert(namespace + ".Enrollment", dto); //session
		System.out.println(session);
		System.out.println("asdfzxcvqwer");

	}

	
	@Override
	public List<AvgDTO> getAvg() {  //admin
		System.out.println(session);  //찍
		return session.selectList(namespace + ".Admin"); 
		
	}

}






