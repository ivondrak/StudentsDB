import java.util.ArrayList;
import java.util.List;

public class StudentsClass {
    private List<Student> students;

    public StudentsClass() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    public int getStudentCount() {
        return students.size();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstName() + " " + student.getLastName() + ", Email: " + student.getEmail() + ", Java: " + student.getJavaExam());
        }
    }
}
