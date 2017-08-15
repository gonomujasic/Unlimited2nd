package ryu.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ryu.study.commentmodel.Criteria;
import ryu.study.commentmodel.SearchCriteria;
import ryu.study.model.StudyDTO;

@Repository
public class StudyDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "ryu.study.mapper.Studymapper";

  public void create(StudyDTO studyDTO) throws Exception {
    session.insert(namespace + ".create", studyDTO);
  }

  public StudyDTO read(Integer study_number) throws Exception {
	session.update(namespace + ".cntup", study_number);
    return session.selectOne(namespace + ".read", study_number);
  }

  public void update(StudyDTO studyDTO) throws Exception {
    session.update(namespace + ".update", studyDTO);
  }

  public void delete(Integer study_number) throws Exception {
    session.delete(namespace + ".delete", study_number);
  }

  public List<StudyDTO> listAll() throws Exception {
    return session.selectList(namespace + ".listAll");
  }

  public List<StudyDTO> listPage(int page) throws Exception {

    if (page <= 0) {
      page = 1;
    }

    page = (page - 1) * 10;

    return session.selectList(namespace + ".listPage", page);
  }

  public List<StudyDTO> listCriteria(Criteria cri) throws Exception {

    return session.selectList(namespace + ".listCriteria", cri);
  }

  public int countPaging(Criteria cri) throws Exception {

    return session.selectOne(namespace + ".countPaging", cri);
  }

  public List<StudyDTO> listSearch(SearchCriteria cri) throws Exception {

    return session.selectList(namespace + ".listSearch", cri);
  }

  public int listSearchCount(SearchCriteria cri) throws Exception {

    return session.selectOne(namespace + ".listSearchCount", cri);
  }
  public void addAttach(String fullName)throws Exception {
	session.insert(namespace + ".addAttach", fullName);
}
  public List<String> getAttach(Integer study_number) throws Exception {
	return session.selectList(namespace + ".getAttach", study_number);
}
  public void deleteAttach(Integer study_number) throws Exception{
	  session.delete(namespace + ".deleteAttach", study_number);
  }
  public void replaceAttach(String fullName, Integer study_number) throws Exception {
	Map<String, Object> paramMap = new HashMap<String, Object>();
	paramMap.put("study_number", study_number);
	paramMap.put("fullName", fullName);
	session.insert(namespace + ".replaceAttach", paramMap);
	
}
}