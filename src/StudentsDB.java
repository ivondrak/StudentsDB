import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentsDB {
    //public static final String URL = "jdbc:mysql://localhost:3306/students_db";
    public static final String URL = "jdbc:mysql://vsrvfeia0h-64.vsb.cz:3306/students_db";
    public static final String USER = "student";
    public static final String PASSWORD = "we_love_java";

    private StudentsClass studentsClass;

    public StudentsDB() {
        studentsClass = new StudentsClass();
    }

    // Load all students from the database
    public void loadStudents() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                int java = resultSet.getInt("java_exam");

                String javaExam = String.valueOf(java);

                Student student = new Student(id, firstName, lastName, email, javaExam);
                studentsClass.addStudent(student);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update the student's Java exam score
    public void updateJavaExam(String id, int javaExam) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE students SET java_exam = " + javaExam + " WHERE id = '" + id + "'");
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StudentsClass getStudentsClass() {
        return studentsClass;
    }
}