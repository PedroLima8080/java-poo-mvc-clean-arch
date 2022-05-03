package exceptions;

public class ErrorMessage extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ErrorMessage(){
        super();
    }

    public ErrorMessage(String message){
        super(message);
    }
}
