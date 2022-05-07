package com.dio.santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.Correntista_repository;
import com.dio.santander.bankline.api.repository.Movimentacao_repository;
import com.dio.santander.bankline.api.services.CorrentistaService;
import com.dio.santander.bankline.api.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	@Autowired
	private Movimentacao_repository repositorio;
	
	@Autowired
	private MovimentacaoService service;
	
	
	@GetMapping
	public List<Movimentacao> findAll(){	
		return repositorio.findAll();
		
	}
	@PostMapping
	public void save(@RequestBody NovaMovimentacao c) {
		service.save(c);
	}

}
