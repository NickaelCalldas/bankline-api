package com.dio.santander.bankline.api.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.Correntista_repository;

@Service
public class CorrentistaService {
	@Autowired
	private Correntista_repository repositorio;
	
	public void save(NovoCorrentista novo) {
		Correntista corr = new Correntista();
		corr.setCpf(novo.getCpf());
		corr.setNome(novo.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		corr.setConta(conta);
		repositorio.save(corr);
		
	}
}
