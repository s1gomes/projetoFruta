package br.edu.uerr.fruta.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.edu.uerr.fruta.modelo.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository <Produto, Integer> {

		public List<Produto> findByEmpresaId(Integer empresaId);
}