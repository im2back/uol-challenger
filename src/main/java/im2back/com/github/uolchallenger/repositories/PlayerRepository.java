package im2back.com.github.uolchallenger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import im2back.com.github.uolchallenger.model.player.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
