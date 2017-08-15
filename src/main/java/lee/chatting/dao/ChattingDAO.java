package lee.chatting.dao;

import javax.servlet.http.HttpServletRequest;

import lee.chatting.dto.ChatRoomDTO;
import lee.chatting.dto.MentorInfo;
import lee.chatting.dto.UserPoint;

public interface ChattingDAO {

	public MentorInfo loadInfo(HttpServletRequest request);
	
	public boolean historyOfStartCheck(int roomNum);
	
	public boolean registerHistory(ChatRoomDTO chatRoom);
	
	public boolean historyOfEndCheck(int roomNum);
	
	public boolean endHistory(int roomNum);
	
	public int getUserPoint(String id);
	
	public boolean updateUserPoint(UserPoint userPoint);
}
