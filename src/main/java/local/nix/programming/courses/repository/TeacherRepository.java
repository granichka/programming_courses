package local.nix.programming.courses.repository;


import local.nix.programming.courses.entity.Group;
import local.nix.programming.courses.hibernate.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.math.BigInteger;
import java.util.List;

public class TeacherRepository {

    private static SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public static void getInformationAboutTheMostSuccessfulGroup(Long id) {
        String query = "select groups.id as group_id, courses.name as course_name\n" +
                "from ((grades inner join lessons on grades.lesson_id = lessons.id) inner\n" +
                "join groups on lessons.group_id = groups.id) inner join courses\n" +
                "on groups.course_id = courses.id\n" +
                "where topic_id = 5 and teacher_id = (?) \n" +
                "group by groups.id, courses.name\n" +
                "order by percentile_cont(0.5) WITHIN GROUP (ORDER BY value) desc\n" +
                "limit 1\n" +
                ";";

        StringBuilder sb = new StringBuilder();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query q = session.createNativeQuery(query);
            q.setParameter(1, id);

            List<Object[]> result = q.getResultList();
            result.stream().forEach((record) -> {
                Long ident = ((BigInteger) record[0]).longValue();
                String coursetName = (String) record[1];
                sb.append("Group_id: " + ident + "\n" +
                        "Course_name: " + coursetName);
            });
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        System.out.println(sb);


    }
}
