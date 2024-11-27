public class Student {
    private String id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String javaExam;

    public Student(String id, String firstName, String lastName, String email, String javaExam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.javaExam = javaExam;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getJavaExam() {
        return javaExam;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJavaExam(String javaExam) {
        this.javaExam = javaExam;
    }

    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", javaExam=" + javaExam + "]";
    }
}
