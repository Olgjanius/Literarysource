/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 * @author olgadakischew
 */
@Named
@ApplicationScoped
public class Library
{
    private List<Result> source = new ArrayList<Result>();

    private static Library instance = new Library();

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("literarysource");

    public Library()
    {
    }

    public List<Result> getSource()
    {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select r from Result r");
        List<Result> result = q.getResultList();
        return result;
    }

    public static Library getInstance()
    {
        return instance;
    }

    void saveResult(Result result)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(result);
        //em.persist(result);
        t.commit();
    }

    public Result getResult(Result result)
    {
        EntityManager em = emf.createEntityManager();
        return em.merge(result);
        //em.refresh(r);
    }
}
