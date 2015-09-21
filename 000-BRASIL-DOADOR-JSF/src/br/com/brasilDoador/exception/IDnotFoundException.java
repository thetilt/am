package br.com.brasilDoador.exception;

public class IDnotFoundException extends Exception{
	
	public IDnotFoundException(){super();}
	
	public IDnotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public IDnotFoundException(String message, Throwable cause){
		super(message, cause);
	}
	
	public IDnotFoundException(String message){
		super(message);
	}
	
	public IDnotFoundException(Throwable cause){
		super(cause);
	}
	
	
	
	
}
