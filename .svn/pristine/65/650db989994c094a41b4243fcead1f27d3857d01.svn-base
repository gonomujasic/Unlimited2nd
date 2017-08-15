package lee.chatting.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import lee.chatting.dto.ChatRoomDTO;

@Service
public class EnterChatService {

	@Autowired
	private ArrayList<ChatRoomDTO> list;
	
	
	public Model execute(Model model, Object object, String roomNumber) {
		HttpServletRequest request = (HttpServletRequest) object;
		HttpSession session = request.getSession();
		int roomNum = Integer.parseInt(roomNumber);
		for(ChatRoomDTO chatRoom:list){
			
			if(chatRoom.getChatRoomNum() == roomNum && chatRoom.getMenteeID() == null){
								
				chatRoom.setMenteeID((String)session.getAttribute("id"));
				chatRoom.setMenteeNick((String)session.getAttribute("nickName"));
				model.addAttribute(chatRoom);
					
			}
		}
		return model;
	}


	
}
