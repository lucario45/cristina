package br.com.alura.horas.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.ApartamentoDao;
import br.com.alura.horas.dao.UsuarioDao;
import br.com.alura.horas.modelos.Apartamento;
import br.com.alura.horas.modelos.Usuario;
import br.com.alura.horas.seguranca.Open;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.Path;

@Controller
public class ApartamentoController {
	private ApartamentoDao apartamentoDao;
	private Result result;
	private Validator validator;
	
	

	ApartamentoController() { }
	
	@Inject
	public ApartamentoController(ApartamentoDao apartamentoDao, Result result,
			Validator validator) {
		this.apartamentoDao = apartamentoDao;
		this.result = result;
		this.validator = validator;
	}

	@Open
	@Path("/")
	public void form() {
	}

	@IncludeParameters
	@Post
	public void adiciona(@Valid Apartamento apartamento) {	
		validator.onErrorRedirectTo(this).form();
		apartamentoDao.adiciona(apartamento);
		result.redirectTo(this).lista();
	}

	public void lista() {
		List<Apartamento> apartamentos = apartamentoDao.lista();
		result.include("usuarios", apartamentos);

	}
	@Delete("/apartamento/{id}")
	public void apaga(int id) {
		apartamentoDao.deleta(id);
		result.redirectTo(this).lista();
	}
}
