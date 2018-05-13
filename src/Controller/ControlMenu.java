package Controller;

import Model.Model;
import View.Windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu extends Control implements ActionListener {

    public ControlMenu(Model model, Windows vue) {
        super(model, vue);
        vue.setMenuController(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == windows.getReset()) {
            windows.visible(false);
            windows.controlFalse();
            SwingUtilities.invokeLater(() -> {
                Model model = new Model();
                model.setSize(3);
                new ControlGroup(model);
            });
        }

        if (e.getSource() == windows.getInfo()) {
            JOptionPane dialog = new JOptionPane();
            JOptionPane.showMessageDialog(dialog, "Create by : LAROYENNE Guillaume", "Information", 1);
        }
    }
}
