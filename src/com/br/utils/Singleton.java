//Classe para estabelecer uma conexão somente ao inicializar o sistema
package com.br.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
    
    private static EntityManager conection;
    private static EntityManagerFactory emf;

    public static EntityManager getConection() {
        if(conection==null){
setConection();
}
        return conection;
    }

    public static void setConection() {
        emf = Persistence.createEntityManagerFactory("JPA");

        conection = emf.createEntityManager();
    }
    
}
