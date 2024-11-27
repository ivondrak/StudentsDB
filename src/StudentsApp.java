public class StudentsApp {
    public static void main(String[] args) throws Exception {
        StudentsDB studentsDB = new StudentsDB();
        studentsDB.loadStudents();
        studentsDB.getStudentsClass().printStudents();
    }
}