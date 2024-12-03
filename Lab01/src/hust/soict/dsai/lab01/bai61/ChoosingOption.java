package hust.soict.dsai.lab01.bai61;

import javax.swing.JOptionPane;

public class ChoosingOption {

    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
        
        // Code tra loi 6.1.2

        // Object[] options = {"I do", "I don’t"};
        // int option = JOptionPane.showOptionDialog(null, "Do you agree?", "Custom Options",
        //         JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        //         null, options, options[0]);

        // if (option == 0) {
        //     JOptionPane.showMessageDialog(null, "You chose: I do");
        // } else if (option == 1) {
        //     JOptionPane.showMessageDialog(null, "You chose: I don’t");
        // }
    }
}

