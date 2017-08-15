package lee.chatting.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface ChatService {

	Model execute(Model model, Object object);
	
}
