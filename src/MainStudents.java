import javax.swing.SwingUtilities;

public class MainStudents {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentsAppGUI("Students Database").setVisible(true);
            }
        });
    }
}
