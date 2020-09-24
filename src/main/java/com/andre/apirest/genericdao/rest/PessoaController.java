package com.andre.apirest.genericdao.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.apirest.genericdao.models.Pessoa;
import com.andre.apirest.genericdao.repository.PessoaRepository;

@RestController
@RequestMapping(value = "/api")
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/pessoas/{id}")
	public Pessoa findById(@PathVariable(value="id") Integer id){
		return pessoaRepository.findById(id);
	}
	
	@PostMapping("/pessoas")
	public void save(@RequestBody @Valid Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/pessoas")
	public void delete(@RequestBody @Valid Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
	
	@PutMapping("/pessoas")
	public void update(@RequestBody @Valid Pessoa pessoa) {
		pessoaRepository.update(pessoa);
	}
	

}
