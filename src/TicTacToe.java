import Controller.ControlGroup;
import Model.Model;

import javax.swing.*;



public class TicTacToe {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            model.setSize(3);
            new ControlGroup(model);
        });
    }
}