package br.com.scheduling.demo.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.scheduling.demo.entity.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer>{

}
