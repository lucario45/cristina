package br.com.alura.horas.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.PropietarioDao;
import br.com.alura.horas.modelos.Apartamento;
import br.com.alura.horas.modelos.Propietario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PropietarioController {
	private PropietarioDao propietarioDao;
	private Result result;
	private Validator validator;
	
	

	PropietarioController() { }
	
	@Inject
	public PropietarioController(PropietarioDao propietarioDao, Result result,
			Validator validator) {
		this.propietarioDao = propietarioDao;
		this.result = result;
		this.validator = validator;
	}

	public void form() {
	}

	@IncludeParameters
	@Post
	public void adiciona(@Valid Propietario propietario) {	
		validator.onErrorRedirectTo(this).form();
		propietarioDao.adiciona(propietario);
		result.redirectTo(this).lista();
	}

	public void lista() {
		List<Propietario> propietario = propietarioDao.lista();
		result.include("usuarios",propietario);

	}
	@Delete("/propietario/{id}")
	public void apaga(int id) {
		propietarioDao.deleta(id);
		result.redirectTo(this).lista();
	}
}
