package reports;

import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class Report {

   /* public List<ExamResult> getExamResults(String firstName, String lastName, Session session) {
        String query = "select new reports.ExamResult(s.lastName, sj.name, e.grade) " +
                "from Exam e, Student s, Subject sj " +
                "where e.student.id = s.id and e.subject.id = sj.id " +
                "and s.firstName = :fisrtName and s.lastName = :lastName";

        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("fisrtName", firstName);
        hibernateQuery.setParameter("lastName", lastName);

        return hibernateQuery.getResultList();
    }*/

    public List<ExamResult> getExamResultsLight(String firstName, String lastName, Session session) {
        String query = "select new reports.ExamResult(e.student.lastName, e.subject.name, e.grade) " +
                "from Exam e " +
                "where e.student.firstName = :fisrtName and e.student.lastName = :lastName";

        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("fisrtName", firstName);
        hibernateQuery.setParameter("lastName", lastName);

        return hibernateQuery.getResultList();
    }
}
