package com.javalec.ex.dto;

import java.sql.Timestamp;
import java.util.Date;

public class BoardDTO {

	private int bId;
	private String bName;
	private String bTitle;
	private String bContent;
	/*
	private Date bRegistDate;
	private Date bUpdateDate;
	*/
	private Timestamp bRegistDate;
	private Timestamp bUpdateDate;
	private int bHit;
	private int bGroup;
	private int bStep;
	private int bIndent;
	
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbRegistDate() {
		return bRegistDate;
	}

	public void setbRegistDate(Timestamp bRegistDate) {
		this.bRegistDate = bRegistDate;
	}

	public Timestamp getbUpdateDate() {
		return bUpdateDate;
	}

	public void setbUpdateDate(Timestamp bUpdateDate) {
		this.bUpdateDate = bUpdateDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}

	@Override
	public String toString() {
		return "BoardDTO [bId=" + bId + ", bName=" + bName + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", bRegistDate=" + bRegistDate + ", bUpdateDate=" + bUpdateDate + ", bHit=" + bHit + ", bGroup="
				+ bGroup + ", bStep=" + bStep + ", bIndent=" + bIndent + "]";
	}
	
}
