package br.edu.uerr.fruta.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.fruta.modelo.ClienteFisico;
import br.edu.uerr.fruta.repositorio.ClienteFisicoRepositorio;

@Controller
public class ClienteFisicoControle {

	@Autowired
	ClienteFisicoRepositorio clienteFisicoRepositorio;
	
	@GetMapping("/clienteF")
	public String abreClienteF(Model modelo) {
		modelo.addAttribute("listaClienteFisico", clienteFisicoRepositorio.findAll());
		return "clienteF";
		}
	
	@GetMapping("/cadastroclienteF")
	public String formClienteF(Model modelo) {
		ClienteFisico clienteFisico = new ClienteFisico();
		modelo.addAttribute("clienteFisico", clienteFisico);
		return "formClienteF";
		}
	
	@PostMapping("/salvarClienteF")
	public String salvarClienteF(@ModelAttribute("clienteF")ClienteFisico clienteFisico, Model modelo) {
		
		clienteFisicoRepositorio.save(clienteFisico);
		
		modelo.addAttribute("listaClientesFisico", clienteFisicoRepositorio.findAll());
		return "redirect:clienteF";
	}
	@GetMapping("/deletarClienteF/{id}")
	public String deletarClienteF(@PathVariable("id") Integer id, Model modelo) {
		
		ClienteFisico clienteFisico = clienteFisicoRepositorio.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Cliente inválido: "+id));
		clienteFisicoRepositorio.delete(clienteFisico);
				
		modelo.addAttribute("listaClintesF", clienteFisicoRepositorio.findAll());
		return "redirect:/clienteF";
	}
	
}

