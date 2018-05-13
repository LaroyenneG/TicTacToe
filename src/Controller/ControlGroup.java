package Controller;

import Model.Model;
import View.Windows;

public class ControlGroup {

    private Model model;
    private Windows windows;
    private ControlButton controlButton;
    private ControlMenu controlMenu;


    public ControlGroup(Model model) {

        this.model = model;

        windows = new Windows(model);

        controlButton = new ControlButton(model, windows);
        controlMenu = new ControlMenu(model, windows);
    }
}
