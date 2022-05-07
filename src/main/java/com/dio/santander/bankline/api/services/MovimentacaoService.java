package com.dio.santander.bankline.api.services;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.TipoMovimentacao;
import com.dio.santander.bankline.api.repository.Correntista_repository;
import com.dio.santander.bankline.api.repository.Movimentacao_repository;

@Service
public class MovimentacaoService {
	@Autowired
	private Movimentacao_repository repositorio;
	
	@Autowired
	private Correntista_repository correntistarepositorio;
	
	public void save(NovaMovimentacao novo) {
		Movimentacao mov = new Movimentacao();
		
		Double valor = novo.getValor();
		if (novo.getTipo() == TipoMovimentacao.DESPESA) {
			valor=valor*-1;
		}
		
		mov.setDataHora(LocalDateTime.now());
		mov.setDescricao(novo.getDescricao());
		mov.setIdConta(novo.getIdConta());
		mov.setTipo(novo.getTipo());
		mov.setIdConta(novo.getIdConta());
		mov.setValor(valor);
		
		Correntista cor = correntistarepositorio.findById(novo.getIdConta()).orElse(null);
		if (cor != null) {
			cor.getConta().setSaldo(cor.getConta().getSaldo()+valor);
			correntistarepositorio.save(cor);
		}
		repositorio.save(mov);
		
	}
}
