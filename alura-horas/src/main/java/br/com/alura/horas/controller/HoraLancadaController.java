package br.com.alura.horas.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.horas.dao.HoraLancadaDao;
import br.com.alura.horas.modelos.HoraLancada;
import br.com.alura.horas.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class HoraLancadaController {
	private HoraLancadaDao horaLancadaDao; 
	private Validator validator; 
	private Result result;
	private UsuarioLogado usuarioLogado;
	
	@Inject
	public HoraLancadaController(HoraLancadaDao dao, Validator validator,
			Result result, UsuarioLogado usuarioLogado) {
		this.horaLancadaDao = dao;
		this.validator = validator;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}

	public HoraLancadaController() {}
	
	public void form() {}
	
	@IncludeParameters
    public void adiciona(@Valid HoraLancada horaLancada){
        validator.onErrorRedirectTo(this).form();
        horaLancada.setUsuario(usuarioLogado.getUsuario());
        horaLancadaDao.adiciona(horaLancada);
        result.redirectTo(this).lista();
    }
    public void lista(){
        result.include("horas", horaLancadaDao.lista(usuarioLogado.getUsuario().getId()));
    }
	
	
	
}
