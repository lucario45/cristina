package br.com.alura.horas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.horas.modelos.Apartamento;
import br.com.alura.horas.modelos.Propietario;

public class PropietarioDao {
private EntityManager manager;
	
	@Inject
	public PropietarioDao(EntityManager manager) {
		this.manager = manager;
	}

	PropietarioDao() { }
	
	public void adiciona(Propietario propietario){
		manager.getTransaction().begin();
		manager.persist(propietario);
		manager.getTransaction().commit();
	}
//cavalo
	public List<Propietario> lista(){
		TypedQuery<Propietario> query =	manager.createQuery("select u from Propietario u",Propietario.class);
		return query.getResultList();
	}
	
    public Propietario busca(String nome){
        TypedQuery<Propietario> query =  manager.createQuery("select u from Propietario u where u.nome = :nome" ,Propietario.class);
        
        query.setParameter("nome", nome);
        return query.getSingleResult();
    }

   
	public void deleta(int id) {
		manager.remove(manager.getReference(Propietario.class, id));
	}
}
