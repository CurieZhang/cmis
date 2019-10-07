package cn.lut.curiezhang.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import cn.lut.curiezhang.model.Users;
import cn.lut.curiezhang.util.SecurityFunctions;
import junit.framework.TestCase;

/**
 * Illustrates use of Hibernate native APIs.
 *
 * @author Curie Zhang
 */
public class UserTest extends TestCase {
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
		// create a couple of user...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save( new Users( "1111", "1111", SecurityFunctions.sha3("111111", 512) ) );
		session.save( new Users( "2222", "2222", SecurityFunctions.sha3("111111", 512) ) );
		session.getTransaction().commit();
		session.close();

		// now lets pull users from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();
		List<Users> result = session.createQuery( "from Users" ).list();
		for ( Users user : result ) {
			System.out.println( "User (" + user.getUserId() + ", " + user.getUserName() + ") : " + user.getUserPassword() );
		}
		session.getTransaction().commit();
		session.close();
	}
}
