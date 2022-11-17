package br.edu.uerr.fruta.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.uerr.fruta.modelo.Fornecedor;
import br.edu.uerr.fruta.repositorio.FornecedorRepositorio;

@Controller
public class FornecedorControle {

	@Autowired
	FornecedorRepositorio fornecedorRepositorio;
		
	@GetMapping("/fornecedor")
	public String abreFornecedor(Model modelo) {
		modelo.addAttribute("listaFornecedor", fornecedorRepositorio.findAll());
		return "fornecedor";
	}
	
	
	@GetMapping("/cadastroFornecedor")
	public String abreformFornecedor(Model modelo) {
		Fornecedor fornecedor = new Fornecedor();
		modelo.addAttribute("fornecedor", fornecedor);
		return "formFornecedor";
	}
	
	@GetMapping("/deletarFornecedor/{id}")
	public String deletarFornecedor(@PathVariable("id") Integer id, Model modelo) {
		
		Fornecedor fornecedor = fornecedorRepositorio.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Fornecedor inválido: "+id));
		fornecedorRepositorio.delete(fornecedor);
				
		modelo.addAttribute("listaFornecedor", fornecedorRepositorio.findAll());
		return "redirect:/fornecedor";
	}
	
}