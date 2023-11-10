package im2back.com.github.uolchallenger.model.player;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PlayerRequestDTO(
		
		@NotBlank
		String name, 
		
		@NotBlank @Email
		String email,
		
	
		String telefone,
		
		@NotBlank
		String grupo
		
		) {

}
