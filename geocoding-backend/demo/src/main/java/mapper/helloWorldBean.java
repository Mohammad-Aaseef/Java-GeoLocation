package mapper;

public class helloWorldBean {
 
	private String message;
	

	public helloWorldBean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "helloWorldBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
