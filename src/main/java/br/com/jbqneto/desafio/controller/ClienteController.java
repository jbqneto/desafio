package br.com.jbqneto.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbqneto.desafio.model.ClienteModel;
import br.com.jbqneto.desafio.repository.IClienteRepository;
import br.com.jbqneto.desafio.util.JsonUtil;
import br.com.jbqneto.desafio.util.ProjectException;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteRepository clienteRepository;
	
	@CrossOrigin
	@RequestMapping(value="/edit", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody JsonUtil edit(@RequestBody ClienteModel cliente) {	
		try {
			
			if(cliente.getId()<1) {
				throw new ProjectException("ID do cliente não informado.");
			}
			
			this.clienteRepository.save(cliente);
			
			String message = String.format("Cliente '%s'(%d) salvo com sucesso.", cliente.getNome(), cliente.getId());
			
			return new JsonUtil(1, message);
		}catch(ProjectException p) {
			return new JsonUtil(0, p.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonUtil(-1, "Erro ao editar cliente: " + e.getMessage());
		}		
	}
	
	@CrossOrigin
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody JsonUtil add(@RequestBody ClienteModel cliente) {		
		try {
			
			String cpf = cliente.getCpf();
			ClienteModel clienteExistente = this.clienteRepository.findOneByCpf(cpf);
			
			if(clienteExistente!=null) {
				throw new ProjectException("CPF '" + cpf + "' já cadastrado ");
			}
			
			this.clienteRepository.save(cliente);
			
			return new JsonUtil(1, "Usuário salvo com sucesso!");
			
		} catch(ProjectException e) {
			return new JsonUtil(0, e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
			return new JsonUtil(-1, "Erro ao cadastrar usuário: " + e.getMessage());
		}
	}
	
	@CrossOrigin(origins  = "http://localhost:4200")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody JsonUtil delete(@PathVariable Integer id){ 
		try {
			ClienteModel cliente = this.clienteRepository.findOne(id);
			
			if(cliente==null) {
				throw new Exception("Cliente inexistente.");
			}
			
			this.clienteRepository.delete(cliente);
			
			String mensagemRetorno = String.format("Cliente '%s'('%d') excluído com sucesso.", cliente.getNome(), id);
			
			return new JsonUtil(1, mensagemRetorno);
		} catch(Exception e) {
			return new JsonUtil(0, String.format("Erro ao excluir cliente de ID:%d : '%s' ", id, e.getMessage()));
		}
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ClienteModel get(@PathVariable Integer id){ 
		return this.clienteRepository.findOne(id);
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<ClienteModel> get(){ 
		return this.clienteRepository.findAll();
	}
	
}
