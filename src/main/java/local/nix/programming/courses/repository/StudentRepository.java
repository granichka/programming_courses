package local.nix.programming.courses.repository;


import local.nix.programming.courses.jdbc.util.JdbcConnectionUtil;

import java.sql.*;
import java.time.LocalDate;

public class StudentRepository {

        private static Connection connection = JdbcConnectionUtil.getConnection();

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

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        LocalDate currentDate = LocalDate.now();
                        preparedStatement.setDate(1, Date.valueOf(currentDate));
                        preparedStatement.setLong(2, id);
                        ResultSet rs = preparedStatement.executeQuery();

                        if (rs != null) {
                                while (rs.next()) {
                                        sb.append("Lesson_id: " + rs.getLong("lesson_id") + "\n" +
                                                "Date: " + rs.getDate("date") + "\n" +
                                                "Time: " + rs.getTime("time") + "\n" +
                                                "Topic: " + rs.getString("topic") + "\n" +
                                                "Teacher: " + rs.getString("teacher"));
                                }
                        }
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                }

                System.out.println(sb);
        }


}
