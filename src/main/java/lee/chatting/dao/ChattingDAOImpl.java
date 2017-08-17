package lee.chatting.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lee.chatting.dto.ChatRoomDTO;
import lee.chatting.dto.MentorInfo;
import lee.chatting.dto.UserPoint;

@Repository
public class ChattingDAOImpl implements ChattingDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "lee.chatting.mapper.ChattingMapper";

	@Override
	public MentorInfo loadInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mentorID = (String) session.getAttribute("id");

		return sqlSession.selectOne(namespace + ".loadInfo", mentorID);
	}

	@Override
	public boolean historyOfStartCheck(int roomNum) {
		boolean canRegist = false;
		int count = sqlSession.selectOne(namespace + ".historyOfStartCheck", roomNum);
		if (count == 0) {
			canRegist = true;
		}
		return canRegist;
	}

	@Override
	public boolean historyOfEndCheck(int roomNum) {
		boolean canEnd = false;
		String endTime = sqlSession.selectOne(namespace + ".historyOfEndCheck", roomNum);
		System.out.println(endTime);
		if (endTime == null) {
			canEnd = true;
		}
		return canEnd;
	}

	@Override
	public boolean registerHistory(ChatRoomDTO chatRoom) {
		try {
			sqlSession.insert(namespace + ".registHistory", chatRoom);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean endHistory(int roomNum) {
		try {
			sqlSession.insert(namespace + ".endHistory", roomNum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int getUserPoint(String id) {

		return sqlSession.selectOne(namespace + ".userPoint", id);
	}

	@Override
	public boolean updateUserPoint(UserPoint userPoint) {
		try {
			sqlSession.update(namespace + ".updateUserPoint", userPoint);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
