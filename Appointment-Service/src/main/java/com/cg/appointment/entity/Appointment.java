package com.cg.appointment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Appointment_table")
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	@Column
	private int did;
	@Column
    private int pid;
	@Column
	private String Date;
	@Column
	private String issue;
	@Column
	private String status;
	@Column
	private double fees;
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Appointment(int aid, int did, int pid, String date, String issue, String status, double fees) {
		super();
		this.aid = aid;
		this.did = did;
		this.pid = pid;
		Date = date;
		this.issue = issue;
		this.status = status;
		this.fees = fees;
	}



	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}



	
	



}