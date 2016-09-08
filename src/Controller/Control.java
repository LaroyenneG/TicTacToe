package Controller; /**
 * Created by guillaume on 07/09/16.
 */
import View.Windows;
import Model.Model;
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
                vue.dispMessage(1);
            }else {
                if (model.playerWin(2)) {
                    this.vue.controlFalse();
                    vue.dispMessage(2);
                }else {
                    this.vue.controlFalse();
                    vue.dispMessage(0);
                }
            }
        }


    }
}