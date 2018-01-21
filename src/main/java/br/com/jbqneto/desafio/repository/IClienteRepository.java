package br.com.jbqneto.desafio.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.jbqneto.desafio.model.ClienteModel;

public interface IClienteRepository extends Repository<ClienteModel, Integer> {
	
	void save(ClienteModel cliente);	 
	void delete(ClienteModel cliente); 
	List<ClienteModel> findAll(); 
	ClienteModel findOne(Integer id);
	ClienteModel findOneByCpf(String cpf);
	
}
