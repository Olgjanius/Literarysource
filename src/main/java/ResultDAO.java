/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 *
 * @author olgadakischew
 */
public class ResultDAO {
	private EntityManagerFactory emf = null;

	EntityManager em = null;


	public List<Result> findAll() {
		if (em==null) {
			emf = Persistence.createEntityManagerFactory("literarysource");
			em = emf.createEntityManager();
		}
		Query abfrage = em.createQuery("select r from Result r");
		List<Result> alleResult = abfrage.getResultList();
		return alleResult;
	}
}
