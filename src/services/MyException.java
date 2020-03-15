package services;

@SuppressWarnings("serial")
public class MyException extends Exception{
	
	MyException (Throwable exception){
		super(exception);
	}
	
	MyException (String exception){
		super(exception);
	}
	
	MyException (){
		super();
	}

}
