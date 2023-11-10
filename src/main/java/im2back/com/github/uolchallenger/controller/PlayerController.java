package im2back.com.github.uolchallenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import im2back.com.github.uolchallenger.model.player.PlayerRequestDTO;
import im2back.com.github.uolchallenger.service.PlayerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Controller
@RequestMapping(value = "/player")
public class PlayerController {

	@Autowired
	private PlayerService service;
	
	@GetMapping("/editar")
	public String editarUsuario(@RequestParam String idParam, Model model){
		Long id = Long.parseLong(idParam);
			var player = service.editarJogador(id);
				model.addAttribute("usuario",player);
					return "player/alterarJogador";	
	}
	
	@GetMapping("/formulario")
	public String paginaDecadastroFormulario(Model model){
		var x =model.getAttribute("errorMessages");
			model.addAttribute("errorMessages", x);	
				return "player/formulario";	
	}
		

	@PostMapping("/formulario")
	@Transactional
	public String insertNewUser(@Valid PlayerRequestDTO playerDTO, Model model){	
		
		var response =	service.insertNewPlayerAvenger(playerDTO);
			model.addAttribute("lista",response);
				return "player/jogadorCadastradoResponse";
		}
	

	@GetMapping("/listar")
	public String findAllUsers(Model model){
		var response = service.findAll();
			model.addAttribute("lista",response);
				return "player/listarJogadores";
	}
	
	@PostMapping("/editar")
	@Transactional
	public String updateUser(@Valid PlayerRequestDTO playerDTO, Model model, @RequestParam String idParam){		
		Long id = Long.parseLong(idParam);
		service.updatePlayer(playerDTO, id);
		
		return "redirect:/player/listar";
	}
	
	@Transactional
	@PostMapping("/excluir")
	public String excluirUsuario(@RequestParam String idParam){
		Long id = Long.parseLong(idParam);	
		service.deleteUser(id);
		
		return "redirect:/player/listar";
	}
	
}
