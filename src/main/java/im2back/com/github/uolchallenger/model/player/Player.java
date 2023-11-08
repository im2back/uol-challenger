package im2back.com.github.uolchallenger.model.player;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
@Table(name = "tb_player")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String telefone;
	private String codinome;
	private String grupo;
	
	
	public Player(String name, String email, String telefone, String grupo, String codinome) {
		super();
		this.name = name;
		this.email = email;
		this.telefone = telefone;
		this.grupo = grupo;
		this.codinome = codinome;
	}
	
	public Player(PlayerRequestDTO playerDTO,String codinomeSortiado, String grupoParam) {
		super();
		this.name = playerDTO.name();
		this.email = playerDTO.email();
		this.telefone = playerDTO.telefone();
		this.grupo = grupoParam;
		this.codinome = codinomeSortiado;
	}
	
	
}
