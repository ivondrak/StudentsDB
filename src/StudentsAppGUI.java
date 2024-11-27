import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentsAppGUI extends JFrame {
    private JTextField idField, firstNameField, lastNameField, emailField, javaExamField;
    private JButton prevButton, nextButton, firstButton, lastButton;
    private StudentsClass students;
    private int currentIndex = 0;

    public StudentsAppGUI() {
        setTitle("Students Database");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        JPanel panel = (JPanel) getContentPane();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(new JLabel("ID:"));
        idField = new JTextField();
        idField.setEditable(false);
        add(idField);

        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        firstNameField.setEditable(false);
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        lastNameField.setEditable(false);
        add(lastNameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        emailField.setEditable(false);
        add(emailField);

        add(new JLabel("Java Exam:"));
        javaExamField = new JTextField();
        javaExamField.setEditable(false);
        add(javaExamField);

        JPanel leftButtonsPanel = new JPanel();
        firstButton = new JButton("<<");
        firstButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = 0;
                displayStudent();
            }
        });
        leftButtonsPanel.add(firstButton);

        prevButton = new JButton("<");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    displayStudent();
                }
            }
        });
        leftButtonsPanel.add(prevButton);

        JPanel rightButtonsPanel = new JPanel();
        nextButton = new JButton(">");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < students.getStudentCount() - 1) {
                    currentIndex++;
                    displayStudent();
                }
            }
        });
        rightButtonsPanel.add(nextButton);

        lastButton = new JButton(">>");
        lastButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = students.getStudentCount() - 1;
                displayStudent();
            }
        });
        rightButtonsPanel.add(lastButton);
        add(leftButtonsPanel);
        add(rightButtonsPanel);

        loadStudents();
        displayStudent();
    }

    private void loadStudents() {
        StudentsDB studentsDB = new StudentsDB();
        studentsDB.loadStudents();
        students = studentsDB.getStudentsClass();
    }

    private void displayStudent() {
        if (students.getStudentCount() > 0) {
            Student student = students.getStudent(currentIndex);
            idField.setText(student.getId());
            firstNameField.setText(student.getFirstName());
            lastNameField.setText(student.getLastName());
            emailField.setText(student.getEmail());
            javaExamField.setText(student.getJavaExam());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentsAppGUI().setVisible(true);
            }
        });
    }
}


