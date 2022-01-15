package com.br.dao;

import com.br.entidades.Movimentacao;
import javax.persistence.EntityManager;
import com.br.utils.Singleton;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

public class MovimentacaoDao {
    
   //Métodos para conexão com o banco de dados:

    private EntityManager em;

    public MovimentacaoDao() {
        em = Singleton.getConection();
    }

    //Métodos que alteram as informações do banco de dados:
    
    public void inserir(Movimentacao cat) {
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();

    }

    public void alterar(Movimentacao cat) {
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();

    }

    public void excluir(Movimentacao cat) {
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();

    }

    public List getLista(String cat) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Movimentacao e ");
        List<Movimentacao> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
    }

    //Método para pesquisar usando DataInicial e DataFinal
    public List getListaData(String cat,
            Date data01, Date data02) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Movimentacao e where e.data BETWEEN :data01 and :data02");
        query.setParameter("data01", data01);
        query.setParameter("data02", data02);
        List<Movimentacao> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
    }

    public List<Movimentacao> getListaData(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
