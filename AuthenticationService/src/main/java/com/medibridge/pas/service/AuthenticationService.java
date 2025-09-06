package com.medibridge.pas.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.medibridge.pas.entity.PatientInfo;
import com.medibridge.pas.exception.AuthenticationServiceException;

import jakarta.servlet.http.HttpSession;

public interface AuthenticationService {
	public boolean register(PatientInfo patientInfo)throws AuthenticationServiceException;
	public PatientInfo login(PatientInfo patientInfo)throws AuthenticationServiceException;
	public boolean getOTP(@RequestParam("email") String email, HttpSession session) throws AuthenticationServiceException;
	public boolean verifyOTP(@RequestParam("otp") int otp, HttpSession session)throws AuthenticationServiceException;
	public boolean changePassword(@RequestParam("newPassword") String newPassword, HttpSession session)throws AuthenticationServiceException;
}
