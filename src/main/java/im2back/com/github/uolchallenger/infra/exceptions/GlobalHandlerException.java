package im2back.com.github.uolchallenger.infra.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalHandlerException {

	@Autowired
	private MessageSource messageSource;
	@ResponseStatus(HttpStatus.FOUND)
	@ExceptionHandler(ServiceExeptions.class)
	public String handleServiceExeptions(ServiceExeptions ex, HttpServletRequest request,RedirectAttributes redirectAttributes) {
	
		 List<String> list = new ArrayList<>();
		 	list.add(ex.getMessage());
		 		redirectAttributes.addFlashAttribute("errorMessages", list);
		 			return "redirect:/player/formulario";
	 }
	 
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.FOUND)
	public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,HttpServletRequest request, BindingResult bindingResult
			,RedirectAttributes redirectAttributes) {
			
		var x = criarListaDeErros(bindingResult);
	    	redirectAttributes.addFlashAttribute("errorMessages", x);
	    		return "redirect:/player/formulario"; 
	}

	private List<String> criarListaDeErros(BindingResult bindingResult) {
		List<String> erros = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) { // laco for que pede todos os erros que ocorreram
																		// nos campos dos atributos que foram validados
			String mensagemUsuario = fieldError.getField() + ":"
					+ messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			erros.add(mensagemUsuario);

		}
		return erros;
	}

}
