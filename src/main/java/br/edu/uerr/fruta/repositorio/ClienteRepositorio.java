package br.edu.uerr.fruta.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uerr.fruta.modelo.Cliente;


@Repository
public interface ClienteRepositorio extends JpaRepository <Cliente, Integer> {

}
