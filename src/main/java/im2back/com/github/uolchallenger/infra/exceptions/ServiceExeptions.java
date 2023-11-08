package im2back.com.github.uolchallenger.infra.exceptions;

public class ServiceExeptions extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	public ServiceExeptions(String mensagem) {
		super(mensagem);
	}
}
