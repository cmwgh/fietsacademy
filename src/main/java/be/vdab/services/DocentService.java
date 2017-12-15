package be.vdab.services;

import java.math.BigDecimal;
import java.util.Optional;

//import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
//import javax.servlet.jsp.tagext.TryCatchFinally;

import be.vdab.entities.Docent;
//import be.vdab.filters.JPAFilter;
import be.vdab.repositories.DocentRepository;

public class DocentService extends AbstractService {
	private final DocentRepository docentRepository = new DocentRepository();
	
	public Optional<Docent> read(long id) {
		return docentRepository.read(id);
		}
		public void create(Docent docent) {
		beginTransaction();
		try {
		docentRepository.create(docent);
		commit();
		} catch (PersistenceException ex) {
		rollback();
		throw ex;
		}
		}
		public void delete(long id) {
			beginTransaction();
			try {
			docentRepository.delete(id);
			commit();
			}
			catch (PersistenceException ex) {
			rollback();
			throw ex;
			}
			}
			public void opslag(long id, BigDecimal percentage) {
			beginTransaction();
			try {
			docentRepository.read(id).ifPresent(docent -> docent.opslag(percentage));
			commit();
			} catch (PersistenceException ex) {
			rollback();
			throw ex;
			}
			}
}
	
	
//	public Optional<Docent> read(long id) {
//		EntityManager entityManager = JPAFilter.getEntityManager();
//		try {
//			return docentRepository.read(id, entityManager);
//		} finally {
//			entityManager.close();
//		}
//	}
//	public void create(Docent docent) {
//		EntityManager entityManager = JPAFilter.getEntityManager();
//		entityManager.getTransaction().begin();
//		try {
//		docentRepository.create(docent, entityManager);
//		entityManager.getTransaction().commit();
//		} catch (PersistenceException ex) {
//			entityManager.getTransaction().rollback();
//			throw ex;
//			} finally {
//			entityManager.close();
//			}
//			}
//	public void delete(long id){
//		EntityManager entityManager = JPAFilter.getEntityManager();
//		entityManager.getTransaction().begin();
//		try {
//			docentRepository.delete(id, entityManager);
//			entityManager.getTransaction().commit();
//		} catch (PersistenceException ex) {
//			entityManager.getTransaction().rollback();
//			throw ex;
//		} finally {
//			entityManager.close();
//		}
//	}
//	public void opslag(long id, BigDecimal percentage){
//		EntityManager entityManager = JPAFilter.getEntityManager();
//		entityManager.getTransaction().begin();
//		try {
//			docentRepository.read(id, entityManager)
//			.ifPresent(docent -> docent.opslag(percentage));
//			entityManager.getTransaction().commit();
//		} catch (PersistenceException ex) {
//			entityManager.getTransaction().rollback();
//			throw ex;
//		} finally {
//			entityManager.close();
//		}
//	}
//	}
