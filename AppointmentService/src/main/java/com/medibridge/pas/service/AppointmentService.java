package com.medibridge.pas.service;

import java.time.LocalDate;
import java.util.List;

import com.medibridge.pas.entity.Appointment;

public interface AppointmentService {
	public Appointment saveDetails(Appointment appointment);
	public boolean deleteDetails(String appointmentId);
	public Appointment updateDetails(Appointment appointment ,String appointmentId);
	public List<Appointment> getAppointment(String patientId);
	public List<Appointment> showAvailability(String physicianEmail , LocalDate date , String acceptance);
	public List<Appointment> showAppointment(String acceptance);
	public List<Appointment> showAppointmentByRejected(String physicianEmail ,String acceptance);
	public List<Appointment> showAllAppointments();
}
