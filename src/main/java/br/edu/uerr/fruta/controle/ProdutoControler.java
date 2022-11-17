package br.edu.uerr.fruta.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.uerr.fruta.modelo.Empresa;
import br.edu.uerr.fruta.modelo.Produto;
import br.edu.uerr.fruta.repositorio.EmpresaRepositorio;
import br.edu.uerr.fruta.repositorio.FornecedorRepositorio;
import br.edu.uerr.fruta.repositorio.ProdutoRepositorio;

@Controller
public class ProdutoControler {

	@Autowired
	ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	EmpresaRepositorio empresaRepositorio;
	
	@Autowired
	FornecedorRepositorio fornecedorRepositorio;

	@GetMapping("/produto")
	public String produto(Model model) {
		
		model.addAttribute("listaProdutos", produtoRepositorio.findAll());	
		return "produtos";
	}
	
	//From
	@GetMapping("/cadastroProduto")
	public String novoProduto(Model model) {
		Produto produto = new Produto();
		
		model.addAttribute("listaEmpresas", empresaRepositorio.findAll());		
		model.addAttribute("listaFornecedores", fornecedorRepositorio.findAll());
		
		
		model.addAttribute("produto",produto);
		return "formProduto";
	}
	
	//Salvar/Alterar
	
	@PostMapping("/salvarFornecedor")
	public String salvar(@ModelAttribute("fornecedor")Empresa empresa , Model modelo,
		@RequestParam Integer empresaId,
		@RequestParam String nome,
		@RequestParam Integer fornecedorId,
		@RequestParam String unidade,
		@RequestParam Integer quantidade,
		@RequestParam String preco
	) { 

		var emp = empresaRepositorio.findById(empresaId);
		emp.get().getNome();
		Produto produtos = new Produto();
		produtos.setEmpresa_id(empresaId);
		produtos.setNome(nome);
		produtos.setFornecedor_id(fornecedorId);
		produtos.setUnidade(unidade);
		produtos.setQuantidade(quantidade);
		produtos.setPreco(preco);


		
		produtoRepositorio.save(produtos);
		
		modelo.addAttribute("listaFornecedor", fornecedorRepositorio.findAll());
		modelo.addAttribute("listaEmpresas", empresaRepositorio.findAll());
		return "redirect:produtos";
	}
	//Deletar

	@GetMapping("/deletarProdutos/{id}")
	public String delProduto(@PathVariable("id") Integer id, Model modelo) {
		
		Produto produto = produtoRepositorio.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Produto inexistente "+id));
		produtoRepositorio.delete(produto);
				
		modelo.addAttribute("listaFornecedor", fornecedorRepositorio.findAll());
		modelo.addAttribute("listaEmpresas", empresaRepositorio.findAll());
		return "redirect:/produtos";

	}

	@GetMapping("/listaProdutosEmpresa/{id}")
	public String abreListaProdutosEmpresa(Model model, @PathVariable(name = "id") int id) {
		Optional<Empresa> emp = empresaRepositorio.findById(id);
		model.addAttribute("emp", emp);
		model.addAttribute("listaProduto", produtoRepositorio.findByEmpresaId(id));
		
		return "empresaProdutos";
		
	}




}


