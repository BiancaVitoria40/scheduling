package br.com.scheduling.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scheduling.demo.entity.Cliente;

public interface ICliente extends JpaRepository<Cliente, Integer>{

}
