package com.cg.appointment.DTO;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Data
@Getter     
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
	private int did;
	private String dname;
    private String qualification;
    
    
    public DoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	public DoctorDTO(int did, String dname, String qualification) {
		super();
		this.did = did;
		this.dname = dname;
		this.qualification = qualification;
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