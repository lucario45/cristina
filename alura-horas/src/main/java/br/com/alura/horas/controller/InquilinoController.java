package br.com.alura.horas.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.InquilinoDao;
import br.com.alura.horas.dao.PropietarioDao;
import br.com.alura.horas.modelos.Inquilino;
import br.com.alura.horas.modelos.Propietario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class InquilinoController {
	private InquilinoDao inquilinoDao;
	private Result result;
	private Validator validator;
	
	InquilinoController() { }
	
	@Inject
	public InquilinoController(InquilinoDao inquilinoDao, Result result,
			Validator validator) {
		this.inquilinoDao = inquilinoDao;
		this.result = result;
		this.validator = validator;
	}

	public void form() {
	}

	@IncludeParameters
	@Post
	public void adiciona(@Valid Inquilino inquilino) {	
		validator.onErrorRedirectTo(this).form();
		inquilinoDao.adiciona(inquilino);
		result.redirectTo(this).lista();
	}

	public void lista() {
		List<Inquilino> inquilino = inquilinoDao.lista();
		result.include("usuarios",inquilino);

	}
	@Delete("/inquilino/{id}")
	public void apaga(int id) {
		inquilinoDao.deleta(id);
		result.redirectTo(this).lista();
	}
}
