import entity.Exam;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import reports.ExamResult;
import reports.Report;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class HibernateExample {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        /*Student student = new Student();

        student.setFirstName("Katty");
        student.setLastName("White");
        student.setAge(26);

        session.save(student);*/

        /*Student student = session.get(Student.class, 1);
        Set<Exam> exams = student.getExams();
        System.out.println(exams);*/

       /* Query query = session.createQuery("from Student ");
        List<Student> students = query.getResultList();
        System.out.println(students);
*/
        Report reports = new Report();
        List<ExamResult> results = reports.getExamResultsLight("John", "Wayne", session);
        System.out.println(results );

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
