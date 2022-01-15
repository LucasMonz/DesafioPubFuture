package com.br.dao;

import com.br.entidades.Categoria;
import javax.persistence.EntityManager;
import com.br.utils.Singleton;
import java.util.List;
import javax.persistence.Query;

public class CategoriaDao {

    //Métodos para conexão com o banco de dados:
    
    private EntityManager em;

    public CategoriaDao() {
        em = Singleton.getConection();
    }

    //Métodos que alteram as informações do banco de dados:
    
    public void inserir(Categoria cat) {
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();

    }

    public void alterar(Categoria cat) {
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();

    }

    public void excluir(Categoria cat) {
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();

    }

    public List getLista(String cat) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Categoria e where e.descricao LIKE:likes");
        query.setParameter("likes", "%" + cat.trim() + "");
        List<Categoria> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
    }

    public List getListaFiltro(String cat) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Categoria e where e.tipo =:likes");
        query.setParameter("likes", cat);
        List<Categoria> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
    }
}
