package ryu.qna.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ryu.qna.commentmodel.Criteria;
import ryu.qna.commentmodel.SearchCriteria;
import ryu.qna.dao.QnaDAO;
import ryu.qna.model.QnaDTO;

@Service
public class QnaService {
	@Inject
	  private QnaDAO qnadao;
@Transactional
	  public void regist(QnaDTO qnaDTO) throws Exception {
	    qnadao.create(qnaDTO);
	    String[] files = qnaDTO.getFiles();
	    if(files == null){return;}
	    for(String fileName : files){
	    	qnadao.addAttach(fileName);
	    }
	  }
public QnaDTO read(Integer qna_number) throws Exception {
    return qnadao.read(qna_number);
  }
@Transactional
public void modify(QnaDTO qnaDTO) throws Exception {
  qnadao.update(qnaDTO);
  Integer qna_number = qnaDTO.getQna_number();
  qnadao.deleteAttach(qna_number);
  String[] files = qnaDTO.getFiles();
  if(files == null){return;}
  for(String fileName : files){
  	qnadao.replaceAttach(fileName, qna_number);
  }
}
public void remove(Integer qna_number) throws Exception {
	qnadao.deleteAttach(qna_number);
  qnadao.delete(qna_number);
}

public List<QnaDTO> listAll() throws Exception {
  return qnadao.listAll();
}

public List<QnaDTO> listCriteria(Criteria cri) throws Exception {

  return qnadao.listCriteria(cri);
}

public int listCountCriteria(Criteria cri) throws Exception {

  return qnadao.countPaging(cri);
}

public List<QnaDTO> listSearchCriteria(SearchCriteria cri) throws Exception {

  return qnadao.listSearch(cri);
}

public int listSearchCount(SearchCriteria cri) throws Exception {
  return qnadao.listSearchCount(cri);
}
public List<String> getAttach(Integer qna_number) throws Exception {
	return qnadao.getAttach(qna_number);
}
	}
