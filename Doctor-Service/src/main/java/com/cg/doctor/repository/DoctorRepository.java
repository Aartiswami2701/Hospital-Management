package com.cg.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.doctor.entity.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	@Query("select count(*) from Doctor where dname=:dname")
		public int getCountByDoctordname(String dname);//dname property of doctor

}