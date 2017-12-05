package com.cooksys.exception;

import javax.servlet.http.HttpServletResponse;

public class FlightBookingException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public static int NOT_FOUND = HttpServletResponse.SC_NOT_FOUND;           // Status code (404)
	public static int NOT_ACCEPTABLE = HttpServletResponse.SC_NOT_ACCEPTABLE; // Status code (406)
	public static int NOT_AUTHORIZED = HttpServletResponse.SC_UNAUTHORIZED;   // Status code (401)
	public static int INTERNAL_ERROR = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

}
