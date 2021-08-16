package hbmAnnotationConfig.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hbmAnnotationConfig.config.HibernateUtil;
import hbmAnnotationConfig.model.Student;

public class StudentRepo {
	
	public void saveStudent(Student st) {

		Transaction trans=null;
		
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			session.save(st);
			trans.commit();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		
	}
	
	
	
	public List<Student>getStudents() {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Student",Student.class).list();
		
		}
		
	}

}
