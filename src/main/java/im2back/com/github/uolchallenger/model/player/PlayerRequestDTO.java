package im2back.com.github.uolchallenger.model.player;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PlayerRequestDTO(
		
		@NotBlank
		String name, 
		
		@NotBlank @Email
		String email,
		
		@Pattern(regexp = "\\d{2}\\d\\d{9}")
		String telefone,
		
		@NotBlank
		String grupo
		
		) {

}
