package com.hospitalportal.hospitalportal.Repository;

import com.hospitalportal.hospitalportal.Entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends CrudRepository<Doctor,Integer>{

    @Query("Select s from Doctor s where s.id=:id")
    Doctor findByIdDoctor(@Param("id") Integer id);

    @Query("Update Doctor set doctorfees=:doctorfees")
    void modify(@Param("doctorfees") Integer doctorfees);
}
