package hbmAnnotationConfig.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import hbmAnnotationConfig.model.Student;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			try {
				Configuration  configuration =new Configuration();
				Properties settings= new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/testDB?useSSL=false");
				settings.put(Environment.USER,"root");
				settings.put(Environment.PASS,"root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.HBM2DDL_AUTO,"update");
				settings.put(Environment.SHOW_SQL, "true");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Student.class);
				
				
			
				ServiceRegistry sr=new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory=configuration.buildSessionFactory(sr);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
		
	}

}
