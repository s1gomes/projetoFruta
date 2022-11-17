package br.edu.uerr.fruta.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.fruta.modelo.Cliente;
import br.edu.uerr.fruta.repositorio.ClienteRepositorio;

@Controller
public class ClienteControle {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	
	@GetMapping("/cliente")
	public String abreCliente(Model modelo) {
		modelo.addAttribute("listaCliente", clienteRepositorio.findAll());
		return "cliente";
		}
	
	@PostMapping("/salvarCliente")
	public String salvarCliente(@ModelAttribute("cliente")Cliente cliente, Model modelo) {
		
		clienteRepositorio.save(cliente);
		
		modelo.addAttribute("listaCliente", clienteRepositorio.findAll());
		return "redirect:cliente";
}
	
	@GetMapping("/cadastroCliente")
	public String formCliente(Model modelo) {
		Cliente cliente = new Cliente();
		modelo.addAttribute("cliente", cliente);
		return "formCliente";
		}
	
	@GetMapping("/deletarCliente/{id}")
	public String deletarCliente(@PathVariable("id") Integer id, Model modelo) {
		
		Cliente cliente = clienteRepositorio.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Cliente inválido: "+id));
		clienteRepositorio.delete(cliente);
				
		modelo.addAttribute("listaCliente", clienteRepositorio.findAll());
		return "redirect:/cliente";
	}
		
}