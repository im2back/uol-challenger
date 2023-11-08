package im2back.com.github.uolchallenger.model.player;

public record PlayerResponseDTO(Long id,String name, String email, String telefone, String codinome, String grupo) {
	

	
	
	
	public PlayerResponseDTO(Player player) {
		this(player.getId(),player.getName(),player.getEmail(),player.getTelefone(),player.getCodinome(),player.getGrupo());
	}

	
	
	
	
}
