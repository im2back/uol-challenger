package im2back.com.github.uolchallenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import im2back.com.github.uolchallenger.model.player.Player;
import im2back.com.github.uolchallenger.model.player.PlayerRequestDTO;
import im2back.com.github.uolchallenger.model.player.PlayerResponseDTO;
import im2back.com.github.uolchallenger.service.PlayerService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "player")
public class PlayerController {

	@Autowired
	private PlayerService service;
	
	
	@GetMapping
	ResponseEntity<List<Player>> findAll(){
		var list = service.findAll();
		return ResponseEntity.ok(list);	
	}
	
	@PostMapping("/cadastrar")
	@Transactional
	ResponseEntity<PlayerResponseDTO> insertNewUser(@RequestBody PlayerRequestDTO playerDTO, @RequestParam String grupo,UriComponentsBuilder uriBuilder){
		var response = service.insertNewPlayerAvenger(playerDTO, grupo);

		var uri = uriBuilder.path("/player/{id}").buildAndExpand(response.id()).toUri();
		
		return ResponseEntity.created(uri).body(response);
			
	}
}
