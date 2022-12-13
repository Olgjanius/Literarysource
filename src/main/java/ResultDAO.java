/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author olgadakischew
 */
public class ResultDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("webApplTh");

	public List<Result> findAll() {
		EntityManager entityManager = emf.createEntityManager();
		Query abfrage = entityManager.createQuery("select r from Result r");
		List<Result> alleResult = abfrage.getResultList();
		entityManager.close();
		return alleResult;
	}
}
