import javax.swing.SwingUtilities;

public class MainProfessor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProfessorAppGUI("Professor Application").setVisible(true);
            }
        });
    }
}
