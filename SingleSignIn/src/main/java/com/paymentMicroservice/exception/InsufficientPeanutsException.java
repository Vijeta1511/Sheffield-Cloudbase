package com.paymentMicroservice.exception;

/**
 * 
 * @author vijetaagrawal
 *
 */
public class InsufficientPeanutsException extends Exception {
	
	/**
	 * Creates User object without error description
	 */
	public InsufficientPeanutsException() {
		
	}
	/**
	 * Creates User object with error description
	 * @param errDesc
	 */
	public InsufficientPeanutsException(String errDesc) {
		super(errDesc);
	}
	

}
