package kitchen.app.exception;

public class AppException extends Exception {

	private static final long serialVersionUID = -8808439716838601130L;

	public AppException(String msg){
		super(msg);
	}
	
	public AppException(String msg, Throwable cause){
		super(msg, cause);
	}
}
