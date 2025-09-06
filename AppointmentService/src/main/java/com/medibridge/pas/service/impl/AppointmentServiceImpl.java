package com.medibridge.pas.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibridge.pas.entity.Appointment;
import com.medibridge.pas.respository.AppointmentRepository;
import com.medibridge.pas.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentRepository appointmentrepository;

	@Autowired
	private Appointment app;

	@Override
	public Appointment saveDetails(Appointment appointment) {
		app.setAcceptance("Pending");
		Appointment result;
		result = appointmentrepository.save(appointment);

		if (result == null) {
//			throw new AppointmentServiceException("Appointment didn't booked");
			throw new NullPointerException("Appointment didn't booked");
		}
		return result;
	}

	@Override
	public boolean deleteDetails(String appointmentId) {
		boolean isExist = appointmentrepository.existsById(appointmentId);

		if (!isExist) {
			throw new NullPointerException("Given appointment Id is not valid " + appointmentId);//AppointmentServiceException("Given appointment Id is not valid " + appointmentId);
		}

		appointmentrepository.deleteById(appointmentId);
		System.out.println("item deleted");
		return isExist;
	}

	@Override
	public Appointment updateDetails(Appointment appointment, String appointmentId) {
		Appointment app = appointmentrepository.findByAppointmentId(appointmentId);

		if (app == null) {
			throw new NullPointerException("Given appointment Id is not valid " + appointmentId);//AppointmentServiceException("Given appointment Id is not valid " + appointmentId);
		}

		app.setAcceptance(appointment.getAcceptance());
//			app.setAppointmentDate(appointment.getAppointmentDate());
//			app.setPhysicianEmail(appointment.getPhysicianEmail());
//			app.setReason(appointment.getReason());
//			app.setSubmissionDate(appointment.getSubmissionDate());
		return appointmentrepository.saveAndFlush(app);
	}

	@Override
	public List<Appointment> getAppointment(String patientId) {
		List<Appointment> appointmentList = (List<Appointment>) appointmentrepository.findByPatientId(patientId);

		if (appointmentList == null) {
			throw new NullPointerException("Given patient Id doesn`t exist " + patientId);//AppointmentServiceException("Given patient Id is not valid " + patientId);
		}
		return appointmentList;
	}

	@Override
	public List<Appointment> showAvailability(String physicianEmail, LocalDate date, String acceptance) {
		List<Appointment> appointmentList = (List<Appointment>) this.appointmentrepository.findAppointment(physicianEmail, date,acceptance);
		if (appointmentList == null) {
			throw new NullPointerException("Given physician email or date or acceptance are not valid " + physicianEmail+" "+date+" "+acceptance);//AppointmentServiceException("Given physician email or date or acceptance are not valid " + physicianEmail+" "+date+" "+acceptance);
		}

		return appointmentList;
	}

	@Override
	public List<Appointment> showAppointment(String acceptance) {
		List<Appointment> appointmentList = (List<Appointment>) this.appointmentrepository.findByAcceptance(acceptance);
		if (appointmentList == null) {
			throw new NullPointerException("Given appointment acceptance is not exists  " + acceptance);//AppointmentServiceException("Given appointment acceptance is not exists  " + acceptance);
		}
		return appointmentList;
	}

	@Override
	public List<Appointment> showAppointmentByRejected(String physicianEmail, String acceptance) {
		List<Appointment> appointmentList = null;
		appointmentList = (List<Appointment>) this.appointmentrepository.findByPending(physicianEmail, acceptance);
		if(appointmentList == null) {
			throw new NullPointerException("Given Physician email or acceptence are not valid "+acceptance+" "+physicianEmail);//AppointmentServiceException("Given Physician email or acceptence are not valid "+acceptance+" "+physicianEmail);
		}
		return appointmentList;
	}

	@Override
	public List<Appointment> showAllAppointments() {
		List<Appointment> list = (List<Appointment>) this.appointmentrepository.findAll();		
		if(list == null)
			throw new NullPointerException("Appointments does not exist ");//AppointmentServiceException("Appointments does not exist ");		
		return list;
	}

}
