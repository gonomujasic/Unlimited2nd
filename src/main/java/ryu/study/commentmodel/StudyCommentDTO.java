package ryu.study.commentmodel;

import java.sql.Date;

public class StudyCommentDTO {
	private int study_reply_number;
	private int study_number;
	private String study_reply_id;
	private String study_reply_contents;
	private Date study_reply_wdate;
	private Date study_reply_udate;
	public int getStudy_reply_number() {
		return study_reply_number;
	}
	public void setStudy_reply_number(int study_reply_number) {
		this.study_reply_number = study_reply_number;
	}
	public int getStudy_number() {
		return study_number;
	}
	public void setStudy_number(int study_number) {
		this.study_number = study_number;
	}
	public String getStudy_reply_id() {
		return study_reply_id;
	}
	public void setStudy_reply_id(String study_reply_id) {
		this.study_reply_id = study_reply_id;
	}
	public String getStudy_reply_contents() {
		return study_reply_contents;
	}
	public void setStudy_reply_contents(String study_reply_contents) {
		this.study_reply_contents = study_reply_contents;
	}
	public Date getStudy_reply_wdate() {
		return study_reply_wdate;
	}
	public void setStudy_reply_wdate(Date study_reply_wdate) {
		this.study_reply_wdate = study_reply_wdate;
	}
	public Date getStudy_reply_udate() {
		return study_reply_udate;
	}
	public void setStudy_reply_udate(Date study_reply_udate) {
		this.study_reply_udate = study_reply_udate;
	}
	@Override
	public String toString() {
		return "StudyCommentDTO [study_reply_number=" + study_reply_number + ", study_number=" + study_number
				+ ", study_reply_id=" + study_reply_id + ", study_reply_contents=" + study_reply_contents
				+ ", study_reply_wdate=" + study_reply_wdate + ", study_reply_udate=" + study_reply_udate + "]";
	}
}
