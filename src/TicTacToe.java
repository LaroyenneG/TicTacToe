import javax.swing.*;

/**
 * Created by guillaume on 07/09/16.
 */

public class TicTacToe {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model model = new Model();
                model.setTaille(3);
                new ControlGroup(model);
            }
        });
    }
}