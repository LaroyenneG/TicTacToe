package Controller;

import Model.Model;
import View.Windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlButton extends Control implements ActionListener{

        public ControlButton(Model model, Windows vue) {
            super(model, vue);
            vue.setButtonControler(this);
        }

        public void actionPerformed(ActionEvent e) {

            int x=0;
            int y=0;

            if(((JButton)e.getSource()).getText().equals("")) {
                this.windows.actualizeGrid();

                for (int l = 0; l < windows.getTabJButton().length; l++) {
                    for (int m = 0; m < windows.getTabJButton()[l].length; m++) {
                        if (windows.getTabJButton()[l][m] == e.getSource()) {
                            y=l;
                            x=m;
                        }
                    }
                }

                model.play(model.getPlayer(), x, y);
                windows.actualizeGrid();
                checkWinner();
                windows.showPlayer();

            }

        }
}

