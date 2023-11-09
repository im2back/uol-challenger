package im2back.com.github.uolchallenger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import im2back.com.github.uolchallenger.model.codinomes.CodinomesInUse;

public interface CodinomesInUseRepository extends JpaRepository<CodinomesInUse, Long> {

	
	public CodinomesInUse findByCodinome(String name);
}
