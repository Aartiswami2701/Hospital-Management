package com.cg.doctor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="Doctor_table")
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int did;
	@Column
	@NotBlank(message="dname should not be blank")
	private String dname;
	@Column
    private String qualification;
	
	
	
	
	public Doctor(int did, String dname, String qualification) {
		super();
		this.did = did;
		this.dname = dname;
		this.qualification = qualification;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	
	
	



}
