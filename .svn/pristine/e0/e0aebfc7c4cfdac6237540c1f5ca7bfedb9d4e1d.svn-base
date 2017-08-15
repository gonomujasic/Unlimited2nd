package min.point.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import min.point.dao.PointDAO;
import min.point.dto.PointHistoryDTO;
import min.point.dto.PointSearching;
import min.point.dto.RefundRequestDTO;
import min.util.Paging;

@Service
public class PointService {
	
	@Autowired
	PointDAO pointdao;
	
	public Map<String, Object> getBuyHistory(int page){
		int historycount = pointdao.getBuyHistoryCount();
		Paging paging = new Paging(page,historycount);
//		System.out.println(paging);
		List<Object>list = pointdao.getBuyHistory(paging);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("paging", paging);
		return map;
	}
	public Map<String, Object> getSellHistory(int page){
		int historycount = pointdao.getSellHistoryCount();
		Paging paging = new Paging(page,historycount);
		List<Object>list = pointdao.getSellHistory(paging);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("paging", paging);
		return map;
	}
	public Map<String, Object> getCRHistory(int page){
		int historycount = pointdao.getCRHistoryCount();
		Paging paging = new Paging(page,historycount);
		List<Object>list = pointdao.getCRHistory(paging);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("paging", paging);
		return map;
	}

	public Map<String, Object> getPointHistory(int page, String id) {
		// TODO Auto-generated method stub
//		System.out.println(id);
		int historycount = pointdao.getMBHistoryCount(id);
		Paging paging = new Paging(page,historycount);
		System.out.println(paging);
		List<Object>list = pointdao.getPointHistory(id,paging);
//		System.out.println(list);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("paging", paging);
		return map;
	}

	public Map<String, Object> getRefundRequestList(int page) {
		// TODO Auto-generated method stub
		int refundrequestcount = pointdao.getRefundRequestCount();
		System.out.println(refundrequestcount);
		Paging paging = new Paging(page, refundrequestcount);
		System.out.println(paging);
		List<Object>list = pointdao.getRefundRequestList(paging);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("paging", paging);
		return map;
	}

	public void pointCharge(String id, double dealing_point) {
		// TODO Auto-generated method stub
		int point_before = pointdao.getPoint(id);
		Map<String, Object> map = new HashMap<String, Object>();
		String why = "충전";
		map.put("id", id);
		map.put("dealing_point", dealing_point);
		map.put("point_before", point_before);
		map.put("why", why);
		pointdao.pointChange(map);
		pointdao.updateCR(map);
		//id랑 dealingpoint를 맵에넣어서 dao에 넘겨준다.
		//pointChange는 더블값을 받아서 포인트 추가 혹은 삭감? 해주는 dao 메서드
		
		//바뀐 포인트 세션에 넣어줘야 되는 부분?
		
		
		
		
	}

	public void pointExchange(String buyer, String seller, double dealing_point) {
		// TODO Auto-generated method stub
		int buyer_point = pointdao.getPoint(buyer);
//		System.out.println(buyer_point);
		int seller_point = pointdao.getPoint(seller);
//		System.out.println(seller_point);
		
		PointHistoryDTO buyerPointHistoryDTO = new PointHistoryDTO();
		buyerPointHistoryDTO.setId(buyer);
		buyerPointHistoryDTO.setDealing_point(-dealing_point);
		buyerPointHistoryDTO.setOpponent(seller);
		buyerPointHistoryDTO.setPoint_before(buyer_point);
		System.out.println(buyerPointHistoryDTO);
		pointdao.insertBuyHistory(buyerPointHistoryDTO);
		//구매 내역 여주고
		PointHistoryDTO sellerPointHistoryDTO = new PointHistoryDTO();
		sellerPointHistoryDTO.setId(seller);
		sellerPointHistoryDTO.setDealing_point(dealing_point);
		sellerPointHistoryDTO.setOpponent(buyer);
		sellerPointHistoryDTO.setPoint_before(seller_point);
		System.out.println(sellerPointHistoryDTO);
		pointdao.insertSellHistory(sellerPointHistoryDTO);
		//판매 내역 여주고
		Map<String, Object> bmap = new HashMap<String, Object>();
		bmap.put("id", buyer);
		bmap.put("dealing_point", -dealing_point);
		pointdao.pointChange(bmap);
		//구매자 포인트 수정해주고
		Map<String, Object> smap = new HashMap<String, Object>();
		smap.put("id", seller);
		smap.put("dealing_point", dealing_point);
		pointdao.pointChange(smap);
		//판매자 포인트 수정하고
		
		//킁 수정된 포인트 세션에 여줘야 되나
	}

	public void refundRequest(RefundRequestDTO refundRequestDTO) {
		// TODO Auto-generated method stub
		pointdao.refundRequest(refundRequestDTO);
		
	}

	public void refundRequestCheck(int no, String id, double dealing_point) {
		// TODO Auto-generated method stub
		Map<String, Object>map = new HashMap<>();
		map.put("id", id);
		map.put("dealing_point", -dealing_point);
		map.put("point_before", pointdao.getPoint(id));
		map.put("why", "환전");
		pointdao.pointChange(map);
		pointdao.updateCR(map);
		pointdao.refundRequestCheck(no);
		
	}

	public int getPoint(String id) {
		// TODO Auto-generated method stub
		return pointdao.getPoint(id);
	}
	public Map<String, Object> pointHistorySearch(int page, PointSearching pointSearching) {
		// TODO Auto-generated method stub
		int historyCount = pointdao.getSearchPointHistoryCount(pointSearching);
		System.out.println(historyCount);
		Paging paging = new Paging(page, historyCount);
		List<PointHistoryDTO> list = pointdao.getSearchPointHistory(paging, pointSearching);
		System.out.println(list);
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("list", list);
		return map;
	}
	public Map<String, Object> buyHistorySearch(int page, PointSearching pointSearching) {
		// TODO Auto-generated method stub
		int historyCount = pointdao.getSearchBuyHistoryCount(pointSearching);
		Paging paging = new Paging(page, historyCount);
		List<PointHistoryDTO>list = pointdao.getSearchBuyHistory(paging, pointSearching);
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("list", list);
		return map;
	}
	public Map<String, Object> sellHistorySearch(int page, PointSearching pointSearching) {
		// TODO Auto-generated method stub
		int historyCount = pointdao.getSearchSellHistoryCount(pointSearching);
		Paging paging = new Paging(page, historyCount);
		List<PointHistoryDTO>list = pointdao.getSearchSellHistory(paging, pointSearching);
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("list", list);
		return map;
	}
	public Map<String, Object> crHistorySearch(int page, PointSearching pointSearching) {
		// TODO Auto-generated method stub
//		System.out.println(pointSearching);
		int historyCount = pointdao.getSearchCRHistoryCount(pointSearching);
		Paging paging = new Paging(page, historyCount);
		List<PointHistoryDTO>list = pointdao.getSearchCRHistory(paging, pointSearching);
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("list", list);
		return map;
	}
	public Map<String, Object> refundRequestSearch(int page, PointSearching pointSearching) {
		// TODO Auto-generated method stub
		int historyCount = pointdao.getSearchRefundRequestCount(pointSearching);
		Paging paging = new Paging(page, historyCount);
		List<PointHistoryDTO>list = pointdao.getSearchRefundRequest(paging, pointSearching);
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("list", list);
		return map;
	}

}
