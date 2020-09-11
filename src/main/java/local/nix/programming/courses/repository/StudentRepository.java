package local.nix.programming.courses.repository;


import local.nix.programming.courses.hibernate.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TemporalType;
import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class StudentRepository {

        private static SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

        public static void getInformationAboutNearestLesson(Long id) {
                String query = "select lessons.id as lesson_id, date, time, topics.name as topic, teachers.name as teacher\n" +
                        "from (((lessons inner join groups on lessons.group_id = groups.id)\n" +
                        "inner join students on groups.id = students.group_id) inner join \n" +
                        "topics on lessons.topic_id = topics.id) inner join teachers \n" +
                        "on groups.teacher_id = teachers.id\n" +
                        "where date > (?) and students.id = (?)\n" +
                        "order by date\n" +
                        "limit 1;";

                StringBuilder sb = new StringBuilder();

                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();

                try {
                        Query q = session.createNativeQuery(query);
                        LocalDate currentDate = LocalDate.now();
                        q.setParameter(1, Date.valueOf(currentDate), TemporalType.DATE);
                        q.setParameter(2, id);

                        List<Object[]> result = q.getResultList();
                        result.stream().forEach((record) -> {
                                Long ident = ((BigInteger) record[0]).longValue();
                                Date date = (Date) record[1];
                                Time time = (Time) record[2];
                                String topic = (String) record[3];
                                String teacher = (String) record[4];

                                sb.append("Lesson_id: " + ident + "\n" +
                                                "Date: " + date + "\n" +
                                                "Time: " + time + "\n" +
                                                "Topic: " + topic + "\n" +
                                                "Teacher: " + teacher);


                        });
                        transaction.commit();

                } catch (Exception e) {
                        transaction.rollback();
                        e.printStackTrace();
                }

                System.out.println(sb);


        }


}
