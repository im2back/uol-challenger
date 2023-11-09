package im2back.com.github.uolchallenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import im2back.com.github.uolchallenger.infra.exceptions.ServiceExeptions;
import im2back.com.github.uolchallenger.model.player.Player;
import im2back.com.github.uolchallenger.model.player.PlayerRequestDTO;
import im2back.com.github.uolchallenger.model.player.PlayerResponseDTO;
import im2back.com.github.uolchallenger.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository repository;

	@Autowired
	private CodinomesInUseService codinomeService;

	public List<Player> findAll() {
		return repository.findAll();
	}
	
	public void deleteUser(Long id) {
		Player user = findById(id);
		codinomeService.deleteCodinome(user.getCodinome());
		repository.deleteById(id);
		
	}
	
	public  Player editarJogador(Long id) {
		Player player = findById(id);
		return player;
	}
	
	public Player findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void updatePlayer(PlayerRequestDTO playerDTO, Long id) {
		Player player = findById(id);
		player.setName(playerDTO.name());
		player.setEmail(playerDTO.email());
		player.setTelefone(playerDTO.telefone());
		
		repository.save(player);
	}

	public PlayerResponseDTO insertNewPlayerAvenger(PlayerRequestDTO playerDTO) {

		if (playerDTO.grupo().equals("Vingadores") == false && playerDTO.grupo().equals("Liga da Justiça") == false) {
			throw new ServiceExeptions("Selecione um Grupo Válido : Liga da Justiça ou Vingadores.");
		}

		String codinomeLivre = codinomeService.sortearCodinome(playerDTO.grupo());

		Player player = new Player(playerDTO, codinomeLivre, playerDTO.grupo());
		repository.save(player);

		codinomeService.saveCodinome(player.getCodinome());

		var response = new PlayerResponseDTO(player);
		return response;

	}

}
