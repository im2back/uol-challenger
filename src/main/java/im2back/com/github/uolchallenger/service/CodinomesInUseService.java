package im2back.com.github.uolchallenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import im2back.com.github.uolchallenger.infra.exceptions.ServiceExeptions;
import im2back.com.github.uolchallenger.model.codinomes.CodinomesInUse;
import im2back.com.github.uolchallenger.repositories.CodinomesInUseRepository;

@Service
public class CodinomesInUseService {
	
	@Autowired
	private CodinomesInUseRepository repository;
	
	@Autowired
	private XmlService xmlservice;
	
	@Autowired
	private JsonService jsonservice;
	
	public void saveCodinome(String codinomeParam) {
		CodinomesInUse codinome = new CodinomesInUse(codinomeParam);
		repository.save(codinome);
	}
	
	public void deleteCodinome(String name) {
		var codinome = repository.findByCodinome(name);
		repository.deleteById(codinome.getId());
		
	}
	
	public List<String> findall(){
		List<CodinomesInUse> list = repository.findAll();
		List<String> codinomesInUseList = new ArrayList<>();
		
		for(CodinomesInUse element: list) {
			codinomesInUseList.add(element.getCodinome());
		}	
		
		return codinomesInUseList;
	}
	
	public String sortearCodinome(String grupo) {
		
		List<String> listaCodinomes = new ArrayList<>();
		  if(grupo.equals("Vingadores")){
			listaCodinomes = jsonservice.fetchJsonData();
		} if(grupo.equals("Liga da Justiça")) {
			listaCodinomes = xmlservice.getCodinomesDaLigaDaJustica();
		}
					
		List<String> listaCodinomesEmUso = findall();
		
		listaCodinomes.removeAll(listaCodinomesEmUso);

		if (listaCodinomes.isEmpty()) {
			throw new ServiceExeptions("Não existem mais codinomes disponiveis, por favor selecione outro grupo");
		}
		
		Random random = new Random();
		int indiceSorteado = random.nextInt(listaCodinomes.size());
		return listaCodinomes.get(indiceSorteado);
	}
	
	
}
