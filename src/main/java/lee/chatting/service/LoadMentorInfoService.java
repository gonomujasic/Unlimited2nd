package lee.chatting.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import lee.chatting.dao.ChattingDAO;
import lee.chatting.dto.MentorInfo;

@Service
@LoadMentorInfoAnno
public class LoadMentorInfoService implements ChatService {

	@Autowired
	private ChattingDAO chatDAO;
	
	@Override
	public Model execute(Model model, Object object) {
		
		MentorInfo mentorInfo = chatDAO.loadInfo((HttpServletRequest) object);
		
		return model.addAttribute(mentorInfo);
	}

}
