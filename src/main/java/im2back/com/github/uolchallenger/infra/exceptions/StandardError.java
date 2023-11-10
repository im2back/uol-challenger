package im2back.com.github.uolchallenger.infra.exceptions;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
	private List<String> message;
	private String path;
	
	public StandardError(Integer status, List<String> message, String path) {
		super();
		this.status = status;
		this.message = message;
		this.path = path;
	}
	
	
	
	
	
}
