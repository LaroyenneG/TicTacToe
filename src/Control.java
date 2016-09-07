/**
 * Created by guillaume on 07/09/16.
 */
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public abstract class Control {
    Model model;
    Windows vue;

    public Control(Model model, Windows vue) {
        this.model = model;
        this.vue = vue;
    }

    public void checkWinner() {
        if(model.playerWin(1)||model.playerWin(2)||(!model.canPlay())){
            if (model.playerWin(1)) {
                this.vue.controlFalse();
                JOptionPane dialog = new JOptionPane();
                JOptionPane.showMessageDialog(dialog, "Tu as gagné !!", "Bravo joueur 1", 1);
            }else {
                if (model.playerWin(2)) {
                    this.vue.controlFalse();
                    JOptionPane dialog = new JOptionPane();
                    JOptionPane.showMessageDialog(dialog, "Tu as gagné !!", "Bravo joueur 2", 1);
                }else {
                    this.vue.controlFalse();
                    JOptionPane dialog = new JOptionPane();
                    JOptionPane.showMessageDialog(dialog, "Match null", "Ok", 1);
                }
            }
        }


    }
}