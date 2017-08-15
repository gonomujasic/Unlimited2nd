package ryu.study.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ryu.study.commentmodel.Criteria;
import ryu.study.commentmodel.SearchCriteria;
import ryu.study.dao.StudyDAO;
import ryu.study.model.StudyDTO;

@Service
public class StudyService {
	@Inject
	  private StudyDAO studydao;
@Transactional
	  public void regist(StudyDTO studyDTO) throws Exception {
	    studydao.create(studyDTO);
	    String[] files = studyDTO.getFiles();
	    if(files == null){return;}
	    for(String fileName : files){
	    	studydao.addAttach(fileName);
	    }
	  }
public StudyDTO read(Integer study_number) throws Exception {
    return studydao.read(study_number);
  }
@Transactional
public void modify(StudyDTO studyDTO) throws Exception {
  studydao.update(studyDTO);
  Integer study_number = studyDTO.getStudy_number();
  studydao.deleteAttach(study_number);
  String[] files = studyDTO.getFiles();
  if(files == null){return;}
  for(String fileName : files){
  	studydao.replaceAttach(fileName, study_number);
  }
}
public void remove(Integer study_number) throws Exception {
	studydao.deleteAttach(study_number);
  studydao.delete(study_number);
}

public List<StudyDTO> listAll() throws Exception {
  return studydao.listAll();
}

public List<StudyDTO> listCriteria(Criteria cri) throws Exception {

  return studydao.listCriteria(cri);
}

public int listCountCriteria(Criteria cri) throws Exception {

  return studydao.countPaging(cri);
}

public List<StudyDTO> listSearchCriteria(SearchCriteria cri) throws Exception {

  return studydao.listSearch(cri);
}

public int listSearchCount(SearchCriteria cri) throws Exception {
  return studydao.listSearchCount(cri);
}
public List<String> getAttach(Integer study_number) throws Exception {
	return studydao.getAttach(study_number);
}
	}
