import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProfessorAppGUI extends StudentsAppGUI {
    JButton updateButton;

    public ProfessorAppGUI(String title) {
        super(title);
    }

    protected void createGUI() {
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

        JPanel associatedPanel = new JPanel();
        associatedPanel.setLayout(new GridLayout(1, 2));
        javaExamField = new JTextField();
        javaExamField.setEditable(true);
        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student student = students.getStudent(currentIndex);
                try {
                    int javaExamScore = Integer.parseInt(javaExamField.getText());
                    if (javaExamScore < 0 || javaExamScore > 100) {
                        JOptionPane.showMessageDialog(panel, "Java Exam score must be between 0 and 100.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid integer for Java Exam score.");
                    return;
                }
                student.setJavaExam(javaExamField.getText());
                database.updateJavaExam(student.getId(), Integer.parseInt(javaExamField.getText()));
                JOptionPane.showMessageDialog(panel, "Data updated successfully.");
            }
        });
        updateButton.requestFocusInWindow();

        associatedPanel.add(javaExamField);
        associatedPanel.add(updateButton);
        add(associatedPanel);

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

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                updateButton.requestFocus();
            }
        });
    }
    
}

