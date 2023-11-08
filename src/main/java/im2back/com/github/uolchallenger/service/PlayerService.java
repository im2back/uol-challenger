package im2back.com.github.uolchallenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	private JsonService jsonservice;
	
	@Autowired
	private XmlService xmlservice;


	private static List<String> vingadoresCodinomesemUso = new ArrayList<>();
	private static List<String> ligaCodinomesemUso = new ArrayList<>();

	public List<Player> findAll() {
		return repository.findAll();
	}

	public PlayerResponseDTO insertNewPlayerAvenger(PlayerRequestDTO playerDTO, String grupo) {
		
		if(grupo.equals("Vingadores")) {
				List<String> avengerCondinomesList = jsonservice.fetchJsonData();
				String codinomeLivre = sortearCodinome(avengerCondinomesList,vingadoresCodinomesemUso);
				Player player = new Player(playerDTO, codinomeLivre, grupo);
				vingadoresCodinomesemUso.add(player.getCodinome());
				repository.save(player);
				var response = new PlayerResponseDTO(player);
				return response;
			}
			if(grupo.equals("liga-da-justiça")) {
				List<String> listaCodinomesLiga =xmlservice.getCodinomesDaLigaDaJustica();
				String codinomeLivre = sortearCodinome(listaCodinomesLiga,ligaCodinomesemUso);
				Player player = new Player(playerDTO, codinomeLivre, "Liga da Justiça");
				ligaCodinomesemUso.add(player.getCodinome());
				repository.save(player);
				var response = new PlayerResponseDTO(player);
				return response;
		} else throw new ServiceExeptions("Selecione um Grupo Válido : Liga da Justiça ou Vingadores.");
	}

	private String sortearCodinome(List<String> listaCompleta, List<String> listaCodinomesEmUso) {
		
		listaCompleta.removeAll(listaCodinomesEmUso);

		if (listaCompleta.isEmpty()) {
			throw new ServiceExeptions("Não existem mais codinomes disponiveis, por favor selecione outro grupo");
		}
		
		Random random = new Random();
		int indiceSorteado = random.nextInt(listaCompleta.size());
		return listaCompleta.get(indiceSorteado);
	}

}
