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
import org.springframework.web.bind.annotation.RestController;

import com.andre.apirest.genericdao.models.Pessoa;
import com.andre.apirest.genericdao.repository.dao.PessoaDao;

@RestController
public class PessoaController {
	
	@Autowired
	PessoaDao pessoaDao;
	
	@GetMapping("/pessoas")
	public List<Pessoa> listaProdutos(){
		return pessoaDao.findAll();
	}
	
	@GetMapping("/pessoas/{id}")
	public Pessoa listaProdutoUnico(@PathVariable(value="id") Integer id){
		return pessoaDao.findById(id);
	}
	
	@PostMapping("/pessoas")
	public void salvaProduto(@RequestBody @Valid Pessoa pessoa) {
		pessoaDao.save(pessoa);
	}
	
	@DeleteMapping("/pessoas")
	public void deletaProduto(@RequestBody @Valid Pessoa pessoa) {
		pessoaDao.delete(pessoa);
	}
	
	@PutMapping("/pessoas")
	public void atualizaProduto(@RequestBody @Valid Pessoa pessoa) {
		pessoaDao.save(pessoa);
	}
	

}
