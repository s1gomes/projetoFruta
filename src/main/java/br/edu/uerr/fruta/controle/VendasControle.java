package br.edu.uerr.fruta.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.fruta.modelo.Vendas;
import br.edu.uerr.fruta.repositorio.VendasRepositorio;

@Controller
public class VendasControle {

	@Autowired
	VendasRepositorio vendasRepositorio;
	
	@GetMapping("/vendas")
	public String abrevendas(Model modelo) {
		modelo.addAttribute("listavendas", vendasRepositorio.findAll());
		return "vendas";
		}
	
	
	@PostMapping("/salvarVendas")
	public String salvarVendas(@ModelAttribute("vendas")Vendas vendas, Model modelo) {
		
		vendasRepositorio.save(vendas);
		
		modelo.addAttribute("listaVendas", vendasRepositorio.findAll());
		return "redirect:vendas";
}
	
	@GetMapping("/cadastroVendas")
	public String abreformVendas(Model modelo) {
		Vendas vendas = new Vendas();
		modelo.addAttribute("vendas", vendas);
		return "formVendas";
		}
	
	@GetMapping("/deletarVendas/{id}")
	public String deletarVendas(@PathVariable("id") Integer id, Model modelo) {
		
		Vendas vendas = vendasRepositorio.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Venda inválida: "+id));
		vendasRepositorio.delete(vendas);
				
		modelo.addAttribute("listaVendas", vendasRepositorio.findAll());
		return "redirect:/vendas";
	}
	
}