package lee.chatting.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import lee.chatting.dto.ChatRoomDTO;

@Service
@LoadListAnno
public class LoadListService implements ChatService{

	@Autowired
	private ArrayList<ChatRoomDTO> list;

	@Override
	public Model execute(Model model, Object object) {
		model.addAttribute("chatRoomsList",list);
		return model;
	}
	
}
