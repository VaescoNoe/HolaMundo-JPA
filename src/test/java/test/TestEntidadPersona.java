package test;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.dominio.Persona;

public class TestEntidadPersona {
	static EntityManager em = null;
	static EntityTransaction tx = null;
	static EntityManagerFactory emf = null;
	Logger log = Logger.getLogger("TestEntidadPersona");
	
	@BeforeClass
	public static void init() throws Exception{
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}
	
	@Before
	public void setUp(){
		try {
			em = emf.createEntityManager();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPersonaEntity() {
		
		log.debug("Iniciando test Persona Entity con JPA");
		
		assertTrue(em != null);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Persona persona1 = new Persona("Alejandra","Pastrana","Guzman","pastrana@gmail.com","5598765432");
		
		log.debug("Objeto a persistir: ".concat(persona1.toString()));
		
		em.persist(persona1);
		tx.commit();
		
		log.debug("Objeto persistido: ".concat(persona1.toString()));
		log.debug("Fin Test Persona Entity con JPA");
	}
}
