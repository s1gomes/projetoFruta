package br.edu.uerr.fruta.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.fruta.modelo.Compras;
import br.edu.uerr.fruta.repositorio.ComprasRepositorio;

@Controller
public class ComprasControle {

	@Autowired
	ComprasRepositorio comprasRepositorio;
	
	@GetMapping("/compras")
	public String abreCompras(Model modelo) {
		modelo.addAttribute("listaCompras", comprasRepositorio.findAll());
		return "compras";
		}
	
	
	@PostMapping("/salvarCompras")
	public String salvarCompras(@ModelAttribute("compras")Compras compras, Model modelo) {
		
		comprasRepositorio.save(compras);
		
		modelo.addAttribute("listaCompras", comprasRepositorio.findAll());
		return "redirect:compras";
}
	
	@GetMapping("/cadastroCompras")
	public String formCompras(Model modelo) {
		Compras compras = new Compras();
		modelo.addAttribute("compras", compras);
		return "formCompras";
		}

	@GetMapping("/deletarCompras/{id}")
	public String deletarCompras(@PathVariable("id") Integer id, Model modelo) {
		
		Compras compras = comprasRepositorio.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Compras inválidas: "+id));
		comprasRepositorio.delete(compras);
				
		modelo.addAttribute("listaCompras", comprasRepositorio.findAll());
		return "redirect:/compras";
	}
	

}