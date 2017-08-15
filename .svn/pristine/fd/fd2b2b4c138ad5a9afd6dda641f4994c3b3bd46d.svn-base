package ryu.notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ryu.notice.commentmodel.Criteria;
import ryu.notice.commentmodel.SearchCriteria;
import ryu.notice.model.NoticeDTO;

@Repository
public class NoticeDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "ryu.notice.mapper.Noticemapper";

  public void create(NoticeDTO noticeDTO) throws Exception {
    session.insert(namespace + ".create", noticeDTO);
  }

  public NoticeDTO read(Integer notice_number) throws Exception {
	session.update(namespace + ".cntup", notice_number);
    return session.selectOne(namespace + ".read", notice_number);
  }

  public void update(NoticeDTO noticeDTO) throws Exception {
    session.update(namespace + ".update", noticeDTO);
  }

  public void delete(Integer notice_number) throws Exception {
    session.delete(namespace + ".delete", notice_number);
  }

  public List<NoticeDTO> listAll() throws Exception {
    return session.selectList(namespace + ".listAll");
  }

  public List<NoticeDTO> listPage(int page) throws Exception {

    if (page <= 0) {
      page = 1;
    }

    page = (page - 1) * 10;

    return session.selectList(namespace + ".listPage", page);
  }

  public List<NoticeDTO> listCriteria(Criteria cri) throws Exception {

    return session.selectList(namespace + ".listCriteria", cri);
  }

  public int countPaging(Criteria cri) throws Exception {

    return session.selectOne(namespace + ".countPaging", cri);
  }

  public List<NoticeDTO> listSearch(SearchCriteria cri) throws Exception {

    return session.selectList(namespace + ".listSearch", cri);
  }

  public int listSearchCount(SearchCriteria cri) throws Exception {

    return session.selectOne(namespace + ".listSearchCount", cri);
  }
  public void addAttach(String fullName)throws Exception {
	session.insert(namespace + ".addAttach", fullName);
}
  public List<String> getAttach(Integer notice_number) throws Exception {
	return session.selectList(namespace + ".getAttach", notice_number);
}
  public void deleteAttach(Integer notice_number) throws Exception{
	  session.delete(namespace + ".deleteAttach", notice_number);
  }
  public void replaceAttach(String fullName, Integer notice_number) throws Exception {
	Map<String, Object> paramMap = new HashMap<String, Object>();
	paramMap.put("notice_number", notice_number);
	paramMap.put("fullName", fullName);
	session.insert(namespace + ".replaceAttach", paramMap);
	
}
}