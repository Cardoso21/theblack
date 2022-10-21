package br.com.theblack.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RegraNegocioException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public RegraNegocioException(){
        super();
    }
    public RegraNegocioException(String message){
        super(message);
    }
    public RegraNegocioException(Throwable cause){
        super(cause);
    }
    public RegraNegocioException(String message, Throwable cause){
        super(message, cause);
    }
}

