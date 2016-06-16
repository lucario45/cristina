package br.com.alura.horas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.horas.modelos.HoraLancada;
import br.com.alura.horas.modelos.Usuario;
import br.com.alura.horas.seguranca.UsuarioLogado;


public class HoraLancadaDao  {

	private EntityManager manager;
	private UsuarioLogado usuarioLogado;
	
	@Inject
	public HoraLancadaDao (EntityManager manager, UsuarioLogado usuarioLogado){
		this.manager = manager;
		this.usuarioLogado = usuarioLogado;
	}
		
	public HoraLancadaDao() {}

	public void adiciona(HoraLancada horaLancada) {
		manager.getTransaction().begin();
		manager.persist(horaLancada);
		manager.getTransaction().commit();	
	}

	public List<HoraLancada>  lista(int id) {
		  /* TypedQuery<Usuario> query =  manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha",Usuario.class);
	        query.setParameter("login", login);
	        query.setParameter("senha", senha);*/
		
		String jpql= "select h from HoraLancada h where h.usuario.id = :id";
		TypedQuery<HoraLancada> query = manager.createQuery(jpql, HoraLancada.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
