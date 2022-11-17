package br.edu.uerr.fruta.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.fruta.modelo.ClienteJuridico;
import br.edu.uerr.fruta.repositorio.ClienteJuridicoRepositorio;

@Controller
public class ClienteJuridicoControle {

	@Autowired
	ClienteJuridicoRepositorio clienteJuridicoRepositorio;
	
	@GetMapping("/clienteJ")
	public String abreClienteJ(Model modelo) {
		modelo.addAttribute("listaClienteJuridico", clienteJuridicoRepositorio.findAll());
		return "clienteJ";
		}
	
	
	@PostMapping("/salvarClienteJ")
	public String salvarClienteJ(@ModelAttribute("clienteJ")ClienteJuridico ClienteJ, Model modelo) {
		
		clienteJuridicoRepositorio.save(ClienteJ);
		
		modelo.addAttribute("listaClienteJ", clienteJuridicoRepositorio.findAll());
		return "redirect:clienteJ";
}
	
	@GetMapping("/cadastrocClienteJ")
	public String abreformClienteJ(Model modelo) {
		ClienteJuridico clienteJ = new ClienteJuridico();
		modelo.addAttribute("ClienteJ", clienteJ);
		return "formClienteJ";
		}
	

	@GetMapping("/deletarClienteJ/{id}")
	public String deletarClienteJ(@PathVariable("id") Integer id, Model modelo) {
		
		ClienteJuridico clienteJuridico = clienteJuridicoRepositorio.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Cliente inválido: "+id));
		clienteJuridicoRepositorio.delete(clienteJuridico);
				
		modelo.addAttribute("listaClienteJ", clienteJuridicoRepositorio.findAll());
		return "redirect:/clienteJ";
	}
	

}

