package smith.larkin.exceptions;

public class CompanyNotFoundException extends Exception {
	
	private static final long serialVersionUID =  (long) 1;
	public CompanyNotFoundException(String message) {
        super("--------------------------------" + message );
    }
	
	
    public CompanyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

