package im2back.com.github.uolchallenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import im2back.com.github.uolchallenger.model.codinomes.CodinomesInUse;
import im2back.com.github.uolchallenger.repositories.CodinomesInUseRepository;

@Service
public class CodinomesInUseService {
	
	@Autowired
	private CodinomesInUseRepository repository;
	
	public void saveCodinome(String codinomeParam) {
		CodinomesInUse codinome = new CodinomesInUse(codinomeParam);
		repository.save(codinome);
	}
}
