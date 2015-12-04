package org.hibernate.tutorial.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by coupang on 15. 12. 4..
 */
public class NativeApiIllustrationTest {

	private SessionFactory sf;

	@Before
	public void setUp() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure()
			.build();

		sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	@Test
	public void test_savingEntity() {
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(new Event("Our very first event!", new Date()));
		session.save(new Event("A follow up event!", new Date()));

		session.getTransaction().commit();
		session.close();
	}
}
