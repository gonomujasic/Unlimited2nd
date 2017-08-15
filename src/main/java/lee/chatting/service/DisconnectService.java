package lee.chatting.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lee.chatting.dto.ChatRoomDTO;

@Service
public class DisconnectService {

	@Autowired
	private ArrayList<ChatRoomDTO> list;

	public String disconnect(String roomNumber, String nickName) {

		int roomNum = Integer.parseInt(roomNumber);

		for (ChatRoomDTO selectChatRoom : list) {
			System.out.println(selectChatRoom.toString());
			if (roomNum == selectChatRoom.getChatRoomNum()) {

				if (nickName.equals(selectChatRoom.getMenteeNick())) {

					selectChatRoom.setMenteeNick(null);
					selectChatRoom.setMenteeID(null);
					return "mentee";
				} else {

					list.remove(selectChatRoom);
					return "mentor";
				}
			}

		}
		return null;
	}

}
