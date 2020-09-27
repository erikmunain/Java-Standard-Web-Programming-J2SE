package ar.com.educacionit.dao.exceptions;

public class DuplicatedException extends Exception {

	private static final long serialVersionUID = -5828170856731719916L;

	public DuplicatedException(String message, Throwable cause) {
		super(message, cause);

	}

	public DuplicatedException(String message) {
		super(message);
	
	}
	
	

}
