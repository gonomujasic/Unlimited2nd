package ryu.qna.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ryu.qna.commentmodel.Criteria;
import ryu.qna.commentmodel.SearchCriteria;
import ryu.qna.model.QnaDTO;

@Repository
public class QnaDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "ryu.qna.mapper.mapper";

  public void create(QnaDTO qnaDTO) throws Exception {
    session.insert(namespace + ".create", qnaDTO);
  }

  public QnaDTO read(Integer qna_number) throws Exception {
	session.update(namespace + ".cntup", qna_number);
    return session.selectOne(namespace + ".read", qna_number);
  }

  public void update(QnaDTO qnaDTO) throws Exception {
    session.update(namespace + ".update", qnaDTO);
  }

  public void delete(Integer qna_number) throws Exception {
    session.delete(namespace + ".delete", qna_number);
  }

  public List<QnaDTO> listAll() throws Exception {
    return session.selectList(namespace + ".listAll");
  }

  public List<QnaDTO> listPage(int page) throws Exception {

    if (page <= 0) {
      page = 1;
    }

    page = (page - 1) * 10;

    return session.selectList(namespace + ".listPage", page);
  }

  public List<QnaDTO> listCriteria(Criteria cri) throws Exception {

    return session.selectList(namespace + ".listCriteria", cri);
  }

  public int countPaging(Criteria cri) throws Exception {

    return session.selectOne(namespace + ".countPaging", cri);
  }

  public List<QnaDTO> listSearch(SearchCriteria cri) throws Exception {

    return session.selectList(namespace + ".listSearch", cri);
  }

  public int listSearchCount(SearchCriteria cri) throws Exception {

    return session.selectOne(namespace + ".listSearchCount", cri);
  }
  public void addAttach(String fullName)throws Exception {
	session.insert(namespace + ".addAttach", fullName);
}
  public List<String> getAttach(Integer qna_number) throws Exception {
	return session.selectList(namespace + ".getAttach", qna_number);
}
  public void deleteAttach(Integer qna_number) throws Exception{
	  session.delete(namespace + ".deleteAttach", qna_number);
  }
  public void replaceAttach(String fullName, Integer qna_number) throws Exception {
	Map<String, Object> paramMap = new HashMap<String, Object>();
	paramMap.put("qna_number", qna_number);
	paramMap.put("fullName", fullName);
	session.insert(namespace + ".replaceAttach", paramMap);
	
}
}