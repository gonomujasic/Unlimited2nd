package min.util;

public class Paging {
	private int totalPage, page, historyCount, startRow, endRow, startPage, endPage;

	public Paging(int page, int historyCount) {
		this.page = page;
		this.historyCount = historyCount;
		this.totalPage = (int) (((double)historyCount/10) +0.9);
		this.startRow = 10*(page-1)+1;
		this.endRow = 10*(page-1)+10;
		if(endRow>=historyCount){
			this.endRow = historyCount;
		}
		this.startPage=page-5;
		if(startPage<=1){
			this.startPage = 1;
		}
		this.endPage=page+5;
		if(endPage>=totalPage){
			this.endPage = totalPage;
		}
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getHistoryCount() {
		return historyCount;
	}
	public void setHistoryCount(int historyCount) {
		this.historyCount = historyCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "Paging [totalPage=" + totalPage + ", page=" + page + ", historyCount=" + historyCount + ", startRow="
				+ startRow + ", endRow=" + endRow + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
	
}
