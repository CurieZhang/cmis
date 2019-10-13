package cn.lut.curiezhang.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import cn.lut.curiezhang.model.Examinee;
import junit.framework.TestCase;

/**
 * Illustrates use of Hibernate native APIs.
 *
 * @author Curie Zhang
 */
public class ExamineeTest extends TestCase {
	private SessionFactory sessionFactory;

	@Override
	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	@Override
	protected void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	@SuppressWarnings("unchecked")
	public void testBasicUsage() {
		// create a couple of examinee...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save( new Examinee( "1111") );
		session.save( new Examinee( "2222") );
		session.getTransaction().commit();
		session.close();

		// now lets pull examinees from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();
		List<Examinee> result = session.createQuery( "from Examinee" ).list();
		for ( Examinee examinee : result ) {
			System.out.println( "Examinee (" + examinee.getExamineeId() + ") : " + examinee.getExamineeName() );
		}
		session.getTransaction().commit();
		session.close();
	}
}
