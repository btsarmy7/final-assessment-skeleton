package com.cooksys.exception;

import javax.servlet.http.HttpServletResponse;

public class FlightBookingException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public static int NOT_FOUND = HttpServletResponse.SC_NOT_FOUND;
	public static int NOT_ACCEPTABLE = HttpServletResponse.SC_NOT_ACCEPTABLE;
	public static int INTERNAL_ERROR = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

}
