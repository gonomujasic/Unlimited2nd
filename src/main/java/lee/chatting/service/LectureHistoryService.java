package lee.chatting.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lee.chatting.dao.ChattingDAO;
import lee.chatting.dto.ChatRoomDTO;

@Service
public class LectureHistoryService {

	@Autowired
	private ChattingDAO chatDAO;

	@Autowired
	private ArrayList<ChatRoomDTO> list;

	public boolean registHistory(String roomNumber) {

		boolean isSuccess;
		ChatRoomDTO chatRoom = null;
		int roomNum = Integer.parseInt(roomNumber);
		for (ChatRoomDTO selectChatRoom : list) {

			if (roomNum == selectChatRoom.getChatRoomNum()) {

				chatRoom = selectChatRoom;
			}

		}

		isSuccess = chatDAO.registerHistory(chatRoom);
		return isSuccess;

	}

	public boolean historyOfStartCheck(String roomNumber) {
		boolean canRegist = chatDAO.historyOfStartCheck(Integer.parseInt(roomNumber));
		return canRegist;
	}

	public boolean endHistory(String roomNumber) {
		boolean isSuccess = false;

		isSuccess = chatDAO.endHistory(Integer.parseInt(roomNumber));

		return isSuccess;
	}

	public boolean historyOfEndCheck(String roomNumber) {
		boolean canEnd = chatDAO.historyOfEndCheck(Integer.parseInt(roomNumber));
		return canEnd;
	}

}
