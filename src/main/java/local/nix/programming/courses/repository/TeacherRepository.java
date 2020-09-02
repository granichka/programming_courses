package local.nix.programming.courses.repository;

import local.nix.programming.courses.jdbc.util.JdbcConnectionUtil;

import java.sql.*;

public class TeacherRepository {

    private static Connection connection = JdbcConnectionUtil.getConnection();

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

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    sb.append("Group_id: " + rs.getLong("group_id") + "\n" +
                            "Course_name: " + rs.getString("course_name"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(sb);
    }
}
