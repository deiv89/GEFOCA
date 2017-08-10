package it.synclab.stage.exceptions;

public class OfficeAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;
	public OfficeAlreadyExistException(String message){
		super(message);
}
}
