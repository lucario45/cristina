package br.com.alura.horas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.horas.modelos.Inquilino;
import br.com.alura.horas.modelos.Propietario;

public class InquilinoDao {

	
private EntityManager manager;
	
	@Inject
	public InquilinoDao(EntityManager manager) {
		this.manager = manager;
	}

	InquilinoDao() { }
	
	public void adiciona(Inquilino inquilino){
		manager.getTransaction().begin();
		manager.persist(inquilino);
		manager.getTransaction().commit();
	}
//cavalo
	public List<Inquilino> lista(){
		TypedQuery<Inquilino> query =	manager.createQuery("select u from Inquilino u",Inquilino.class);
		return query.getResultList();
	}
	
    public Inquilino busca(String nome){
        TypedQuery<Inquilino> query =  manager.createQuery("select u from Inquilino u where u.nome = :nome" ,Inquilino.class);
        
        query.setParameter("nome", nome);
        return query.getSingleResult();
    }

   
	public void deleta(int id) {
		manager.remove(manager.getReference(Inquilino.class, id));
	}
}

