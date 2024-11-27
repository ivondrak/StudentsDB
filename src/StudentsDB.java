import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentsDB {
    public static final String URL = "jdbc:mysql://localhost:3306/students_db";
    public static final String USER = "root";
    public static final String PASSWORD = "MajSQL-0293";

    private StudentsClass studentsClass;

    public StudentsDB() {
        studentsClass = new StudentsClass();
    }

    public void loadStudents() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            System.out.println(URL);
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

    public StudentsClass getStudentsClass() {
        return studentsClass;
    }
}