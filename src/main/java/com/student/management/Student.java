package com.student.management;

public class Student {
	
	

	private int studentId;
	private String stundetName;
	private String studentAddress;
	private String studentClass;
	private long contactNO;

	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int studentId, String stundetName, String studentAddress, String studentClass,
			long contactNO) {
		super();
		this.studentId = studentId;
		this.stundetName = stundetName;
		this.studentAddress = studentAddress;
		this.studentClass = studentClass;
		this.contactNO = contactNO;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStundetName() {
		return stundetName;
	}


	public void setStundetName(String stundetName) {
		this.stundetName = stundetName;
	}


	public String getStudentAddress() {
		return studentAddress;
	}


	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}



	public String getStudentClass() {
		return studentClass;
	}


	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}


	public long getContactNO() {
		return contactNO;
	}


	public void setContactNO(long contactNO) {
		this.contactNO = contactNO;
	}
	

}
