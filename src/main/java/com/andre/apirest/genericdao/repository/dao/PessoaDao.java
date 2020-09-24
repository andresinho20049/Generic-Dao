package com.andre.apirest.genericdao.repository.dao;

import org.springframework.stereotype.Repository;

import com.andre.apirest.genericdao.models.Pessoa;
import com.andre.apirest.genericdao.repository.PessoaRepository;

@Repository
public class PessoaDao extends GenericDao<Pessoa> implements PessoaRepository{

}
