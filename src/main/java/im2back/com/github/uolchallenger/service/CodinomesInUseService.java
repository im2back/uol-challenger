package im2back.com.github.uolchallenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import im2back.com.github.uolchallenger.model.codinomes.CodinomesInUse;
import im2back.com.github.uolchallenger.model.codinomes.validacoes.ValidadorCodinome;
import im2back.com.github.uolchallenger.repositories.CodinomesInUseRepository;

@Service
public class CodinomesInUseService {
	
	@Autowired
	private CodinomesInUseRepository repository;
	
	@Autowired
	private XmlService xmlservice;
	
	@Autowired
	private JsonService jsonservice;
	
	@Autowired
	private List<ValidadorCodinome> validadoresCodinome;
	
	public void saveCodinome(String codinomeParam) {
		CodinomesInUse codinome = new CodinomesInUse(codinomeParam);
		repository.save(codinome);
	}
	
	public void deleteCodinome(String name) {
		var codinome = repository.findByCodinome(name);
		repository.deleteById(codinome.getId());
		
	}
	
	public List<String> findAllCodinamesInUse(){
		List<CodinomesInUse> list = repository.findAll();
		List<String> codinomesInUseList = new ArrayList<>();
		
		for(CodinomesInUse element: list) {
			codinomesInUseList.add(element.getCodinome());
		}	
		
		return codinomesInUseList;
	}
	
	public String sortearCodinome(String grupo) {
		
		List<String> listaCodinomesDisponiveis = pegarListaSelecionada(grupo);		
		List<String> listaCodinomesEmUso = findAllCodinamesInUse();	
		
		listaCodinomesDisponiveis.removeAll(listaCodinomesEmUso);
		
		validadoresCodinome.forEach(v -> v.validar(listaCodinomesEmUso,listaCodinomesDisponiveis));
	
		Random random = new Random();
		int indiceSorteado = random.nextInt(listaCodinomesDisponiveis.size());
			return listaCodinomesDisponiveis.get(indiceSorteado);
	}
	
	public List<String> pegarListaSelecionada(String grupo){
		
		List<String> listaCodinomes = new ArrayList<>();
		  if(grupo.equals("Vingadores")){
			listaCodinomes = jsonservice.fetchJsonData();
		} if(grupo.equals("Liga da Justiça")) {
			listaCodinomes = xmlservice.getCodinomesDaLigaDaJustica();
		}
		return listaCodinomes;
	}
	
}
