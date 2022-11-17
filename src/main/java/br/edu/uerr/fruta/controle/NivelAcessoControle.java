package br.edu.uerr.fruta.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.fruta.modelo.NivelAcesso;
import br.edu.uerr.fruta.repositorio.NivelAcessoRepositorio;

@Controller
public class NivelAcessoControle {

	@Autowired
	NivelAcessoRepositorio nivelAcessoRepositorio;

	@GetMapping("/nivelAcesso")
	public String abrenivelAcesso(Model modelo) {
		modelo.addAttribute("listaNivelAcesso", nivelAcessoRepositorio.findAll());
		return "nivelAcesso";
		}
	
	
	@PostMapping("/salvarNivelAcesso")
	public String salvarNivelAcesso(@ModelAttribute("nivelAcesso")NivelAcesso nivelAcesso, Model modelo) {
		
		nivelAcessoRepositorio.save(nivelAcesso);
		
		modelo.addAttribute("listaNivelAcesso", nivelAcessoRepositorio.findAll());
		return "redirect:nivelAcesso";
}
	
	@GetMapping("/cadastroNivelAcesso")
	public String abreformNivelAcesso(Model modelo) {
		NivelAcesso nivelAcesso = new NivelAcesso();
		modelo.addAttribute("nivelAcesso", nivelAcesso);
		return "formnivelAcesso";
		}
	
	@GetMapping("/deletarNivelAcesso/{id}")
	public String deletarNivelAcesso(@PathVariable("id") Integer id, Model modelo) {
		
		NivelAcesso nivelAcesso = nivelAcessoRepositorio.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Nivel de acesso inválido: "+id));
		nivelAcessoRepositorio.delete(nivelAcesso);
				
		modelo.addAttribute("listaNivelAcesso", nivelAcessoRepositorio.findAll());
		return "redirect:/nivelAcesso";
	}


}