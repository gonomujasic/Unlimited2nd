package ryu.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ryu.notice.commentmodel.Criteria;
import ryu.notice.commentmodel.SearchCriteria;
import ryu.notice.dao.NoticeDAO;
import ryu.notice.model.NoticeDTO;

@Service
public class NoticeService {
	@Inject
	  private NoticeDAO noticedao;
@Transactional
	  public void regist(NoticeDTO noticeDTO) throws Exception {
	    noticedao.create(noticeDTO);
	    String[] files = noticeDTO.getFiles();
	    if(files == null){return;}
	    for(String fileName : files){
	    	noticedao.addAttach(fileName);
	    }
	  }
public NoticeDTO read(Integer notice_number) throws Exception {
    return noticedao.read(notice_number);
  }
@Transactional
public void modify(NoticeDTO noticeDTO) throws Exception {
  noticedao.update(noticeDTO);
  Integer notice_number = noticeDTO.getNotice_number();
  noticedao.deleteAttach(notice_number);
  String[] files = noticeDTO.getFiles();
  if(files == null){return;}
  for(String fileName : files){
  	noticedao.replaceAttach(fileName, notice_number);
  }
}
public void remove(Integer notice_number) throws Exception {
	noticedao.deleteAttach(notice_number);
  noticedao.delete(notice_number);
}

public List<NoticeDTO> listAll() throws Exception {
  return noticedao.listAll();
}

public List<NoticeDTO> listCriteria(Criteria cri) throws Exception {

  return noticedao.listCriteria(cri);
}

public int listCountCriteria(Criteria cri) throws Exception {

  return noticedao.countPaging(cri);
}

public List<NoticeDTO> listSearchCriteria(SearchCriteria cri) throws Exception {

  return noticedao.listSearch(cri);
}

public int listSearchCount(SearchCriteria cri) throws Exception {
  return noticedao.listSearchCount(cri);
}
public List<String> getAttach(Integer notice_number) throws Exception {
	return noticedao.getAttach(notice_number);
}
	}
