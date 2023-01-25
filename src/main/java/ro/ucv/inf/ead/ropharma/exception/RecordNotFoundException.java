package ro.ucv.inf.ead.ropharma.exception;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7209736459709661895L;

	public RecordNotFoundException() {
	    super();
	  }

	  public RecordNotFoundException(final String message, final Throwable cause) {
	    super(message, cause);
	  }

	  public RecordNotFoundException(final String message) {
	    super(message);
	  }

	  public RecordNotFoundException(final Throwable cause) {
	    super(cause);
	  }
	}
