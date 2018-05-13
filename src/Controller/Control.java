package Controller;

import Model.Model;
import View.Windows;

public abstract class Control {
    Model model;
    Windows windows;

    public Control(Model model, Windows vue) {
        this.model = model;
        this.windows = vue;
    }

    public void checkWinner() {

        if(model.playerWin(1)||model.playerWin(2)||(!model.canPlay())){
            if (model.playerWin(1)) {
                windows.controlFalse();
                windows.displayMessage(1);
            }else {
                if (model.playerWin(2)) {
                    windows.controlFalse();
                    windows.displayMessage(2);
                }else {
                    windows.controlFalse();
                    windows.displayMessage(0);
                }
            }
        }


    }
}