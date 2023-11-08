package im2back.com.github.uolchallenger.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalHandlerException {
	@ExceptionHandler(ServiceExeptions.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<StandardError> handleValidacaoException(ServiceExeptions ex, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(status.value(), ex.getMessage(), request.getRequestURI());
		return ResponseEntity.badRequest().body(error);
	}
	
}
