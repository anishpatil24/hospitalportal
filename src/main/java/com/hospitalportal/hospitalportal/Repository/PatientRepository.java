package com.hospitalportal.hospitalportal.Repository;

import com.hospitalportal.hospitalportal.Entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends CrudRepository<Patient,Integer> {

    @Query("Select s from Patient s where s.id=:id")
    Patient findByIdPatient(@Param("id") Integer id);
}
