package hbmAnnotationConfig.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hbmAnnotationConfig.config.HibernateUtil;
import hbmAnnotationConfig.model.Student;
import hbmAnnotationConfig.repo.StudentRepo;

public class Main {

	public static void main(String[] args) {
		
		StudentRepo sr=new StudentRepo();
		Student s=new Student();
		s.setFullname("Dada");
		
		sr.saveStudent(s);
		
		List <Student> students=sr.getStudents();
		
		students.forEach(stu -> System.out.println(stu.getFullname()));
		

	}

}
