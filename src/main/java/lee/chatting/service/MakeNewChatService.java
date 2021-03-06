package lee.chatting.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import lee.chatting.dto.ChatRoomDTO;

@Service
@MakeNewChatAnno
public class MakeNewChatService implements ChatService {

	/*
	 * @Autowired private ChatRoomDTO chatRoomDTO;
	 */
	// ChatRoomDTO를 protoType으로 설정하면 다른 클래스에서 호출할 경우 새로운 인스턴스가 만들어지지만
	// 현재 클래스에서 여러번 호출하면 같은 놈이 나옴. 그래서 DL로 해결해야 함.

	@Autowired
	private ArrayList<ChatRoomDTO> list;

	@Autowired
	private WebApplicationContext context;

	// DL(dependency lookup으로 해결)
	public ChatRoomDTO getChatRoom() {
		return (ChatRoomDTO) context.getBean("chatRoomDTO");
	}

	int roomNumber = 0;

	@Override
	public Model execute(Model model, Object object) {

		HttpServletRequest request = (HttpServletRequest) object;
		HttpSession session = request.getSession();

		String mentorID = (String) session.getAttribute("id");
		String mentorNick = (String) session.getAttribute("nickName");

		ChatRoomDTO chatRoomDTO = getChatRoom();
		chatRoomDTO.setChatRoomNum(roomNumber);
		chatRoomDTO.setLanguage(request.getParameter("language"));
		chatRoomDTO.setMentorID(mentorID);
		chatRoomDTO.setMentorNick(mentorNick);
		chatRoomDTO.setNationality(request.getParameter("nationality"));
		chatRoomDTO.setRoomTitle(request.getParameter("title"));
		chatRoomDTO.setStudypoint(request.getParameter("studypoint"));
		chatRoomDTO.setStudytime(request.getParameter("studytime"));
		model.addAttribute(chatRoomDTO);
		System.out.println(chatRoomDTO.toString());
		list.add(chatRoomDTO);
		roomNumber++;

		return model;
	}
}
