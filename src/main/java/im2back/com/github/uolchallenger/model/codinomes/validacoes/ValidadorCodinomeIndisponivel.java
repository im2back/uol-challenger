package im2back.com.github.uolchallenger.model.codinomes.validacoes;

import java.util.List;

import org.springframework.stereotype.Component;

import im2back.com.github.uolchallenger.infra.exceptions.ServiceExeptions;

@Component
public class ValidadorCodinomeIndisponivel implements ValidadorCodinome {

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void validar(List<String> listaCodinomesEmUso,List<String> listaCodinomes) {
		
		listaCodinomes.remove(listaCodinomesEmUso);
		
		if (listaCodinomes.isEmpty()) {
			throw new ServiceExeptions("Não existem mais codinomes disponiveis, por favor selecione outro grupo");
		}
		
	}



	

}
