package com.dio.santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.Correntista_repository;
import com.dio.santander.bankline.api.services.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	@Autowired
	private Correntista_repository repositorio;
	
	@Autowired
	private CorrentistaService service;
	
	
	@GetMapping
	public List<Correntista> findAll(){
		
		
		return repositorio.findAll();
		
	}
	@PostMapping
	public void save(@RequestBody NovoCorrentista c) {
		service.save(c);
	}

}
