/**
 * Created by guillaume on 07/09/16.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControlButton extends Control implements ActionListener{

        public ControlButton(Model model, Windows vue) {
            super(model, vue);
            vue.setButtonControler(this);
        }

        public void actionPerformed(ActionEvent e) {
            int x=0;
            int y=0;

            if(((JButton)e.getSource()).getText().equals("")) {
                this.vue.actualizeGrid();

                int l,m;
                for (l=0;l<vue.getTabJButton().length;l++){
                    for (m=0;m<vue.getTabJButton()[l].length;m++){
                        if (vue.getTabJButton()[l][m]==((JButton)e.getSource())){
                            y=l;
                            x=m;
                        }
                    }
                }

                this.model.play(model.getPlayer(),x,y);
                this.vue.actualizeGrid();
                checkWinner();
                vue.showPlayer();

            }

        }
}

