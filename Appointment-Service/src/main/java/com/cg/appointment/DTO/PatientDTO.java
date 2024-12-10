package com.cg.appointment.DTO;


public class PatientDTO {
	private int pid;
	private String pname;
    private String address;
	public PatientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDTO(int pid, String pname, String address) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.address = address;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PatientDTO [pid=" + pid + ", pname=" + pname + ", address=" + address + "]";
	}
	
	
    
}
