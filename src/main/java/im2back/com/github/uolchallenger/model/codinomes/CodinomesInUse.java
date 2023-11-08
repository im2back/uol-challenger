package im2back.com.github.uolchallenger.model.codinomes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@Entity
@Table(name="codinomes_indisponiveis")
public class CodinomesInUse {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codinome;
	
	public CodinomesInUse(String codinome) {
		super();
		this.codinome = codinome;
	}
	
	
	
}
