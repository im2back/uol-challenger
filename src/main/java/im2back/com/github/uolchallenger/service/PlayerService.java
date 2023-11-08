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

	public PlayerResponseDTO insertNewPlayerAvenger(PlayerRequestDTO playerDTO, String grupo) {

		if (grupo.equals("Vingadores") == false && grupo.equals("Liga da Justiça") == false) {
			throw new ServiceExeptions("Selecione um Grupo Válido : Liga da Justiça ou Vingadores.");
		}

		String codinomeLivre = codinomeService.sortearCodinome(grupo);

		Player player = new Player(playerDTO, codinomeLivre, grupo);
		repository.save(player);

		codinomeService.saveCodinome(player.getCodinome());

		var response = new PlayerResponseDTO(player);
		return response;

	}

}
