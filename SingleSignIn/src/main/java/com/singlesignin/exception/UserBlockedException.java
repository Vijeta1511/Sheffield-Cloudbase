package com.singlesignin.exception;

public class UserBlockedException extends Exception {
	
	/**
	 * Creates User object without error description
	 */
	public UserBlockedException() {
		
	}

	/**
	 * Creates User object with error description
	 * @param errDesc
	 */
	public UserBlockedException(String errDesc) {
		super(errDesc);
		// TODO Auto-generated constructor stub
	}

}
