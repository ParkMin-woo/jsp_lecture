package com.javalec.ex.dto;

public class LoginMemberDTO {

	private int seq;
	private String id;
	private String pwd;
	private String name;
	private String address;
	private String graduatedAcademy;
	private String major;
	private String hobby;
	private String gender;
	
	public LoginMemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGraduatedAcademy() {
		return graduatedAcademy;
	}

	public void setGraduatedAcademy(String graduatedAcademy) {
		this.graduatedAcademy = graduatedAcademy;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "LoginMemberDTO [seq=" + seq + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", address=" + address
				+ ", graduatedAcademy=" + graduatedAcademy + ", major=" + major + ", hobby=" + hobby + ", gender="
				+ gender + "]";
	}
	
}
