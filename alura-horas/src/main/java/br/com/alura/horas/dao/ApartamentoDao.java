package br.com.alura.horas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.horas.modelos.Apartamento;

public class ApartamentoDao {

	private EntityManager manager;
	
	@Inject
	public ApartamentoDao(EntityManager manager) {
		this.manager = manager;
	}

	ApartamentoDao() { }
	
	public void adiciona(Apartamento apartamento){
		manager.getTransaction().begin();
		manager.persist(apartamento);
		manager.getTransaction().commit();
	}
//cavalo
	public List<Apartamento> lista(){
		TypedQuery<Apartamento> query =	manager.createQuery("select u from Apartamento u",Apartamento.class);
		return query.getResultList();
	}
	
    public Apartamento busca(int numeroPorta){
        TypedQuery<Apartamento> query =  manager.createQuery("select u from Apartamento u where u.numeroPorta = :numeroPorta" ,Apartamento.class);
        
        query.setParameter("numeroPorta", numeroPorta);
        return query.getSingleResult();
    }

   
	public void deleta(int id) {
		manager.remove(manager.getReference(Apartamento.class, id));
	}

}
