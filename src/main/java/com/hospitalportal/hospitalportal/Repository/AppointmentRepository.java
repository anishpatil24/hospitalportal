package com.hospitalportal.hospitalportal.Repository;

import com.hospitalportal.hospitalportal.Entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    @Query("Select s from Appointment s where s.patientname=(Select Patient.patientname from Patient where Patient.id=:id)")
    List<Appointment> findAllAppointments(@Param("id") Integer id);

    @Query("Select s from Appointment s where s.patientname=(Select Patient.patientname from Patient where Patient.id=:id)" +
            " and " +
            "s.date=:date")
    List<Appointment> findAllAppointmentsDate(@Param("id") Integer id, @Param("date") Date date);

    @Query("Select s from Appointment s where s.doctorname=(Select Doctor.doctorname from Doctor where Doctor.hospitalid=:id)")
    List<Appointment> findAllAppointmentsForHospital(@Param("id") Integer id);

    @Query("Select s from Appointment s where s.doctorname=(Select Doctor.doctorname from Doctor where Doctor.hospitalid=:id) and s.date=:date")
    List<Appointment> findAllAppointmentsForHospitalDate(@Param("id") Integer id, @Param("date") Date date);

    @Query("Select s from Appointment s where s.doctorname=(Select Doctor.doctorname from Doctor where Doctor.doctorname=:doctorname and Doctor.hospitalid=:id)")
    List<Appointment> findAllAppointmentsForDoctor(@Param("id") Integer id, @Param("doctorname") String doctorname);

    @Query("Select  sum(doctorfees) from Doctor where Doctor.doctorname=(Select Appointment.doctorname from Appointment )")
    Integer findTotalEarningsForDate(@Param("date") Date date);
}
