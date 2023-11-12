package im2back.com.github.uolchallenger.model.player.validacoes;

import org.springframework.stereotype.Component;

import im2back.com.github.uolchallenger.infra.exceptions.ServiceExeptions;
import im2back.com.github.uolchallenger.model.player.PlayerRequestDTO;

@Component
public class ValidadorGrupoEscolhido implements ValidadorCadastroPlayer {

	@Override
	public void validar(PlayerRequestDTO playerDTO) {
		
		if (playerDTO.grupo().equals("Vingadores") == false && playerDTO.grupo().equals("Liga da Justiça") == false) {
			throw new ServiceExeptions("Selecione um Grupo Válido : Liga da Justiça ou Vingadores.");
		}
		
	}

}
