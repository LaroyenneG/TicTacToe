/**
 * Created by guillaume on 07/09/16.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ControlMenu extends Control implements ActionListener {
    private static int taille;

    public ControlMenu(Model model, Windows vue) {
        super(model, vue);
        vue.setMenuControler(this);
    }

    public void actionPerformed(ActionEvent e) {

        if(((JMenuItem)e.getSource())==vue.getReset()) {
            vue.visible(false);
            vue.controlFalse();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Model model = new Model();
                    model.setTaille(3);
                    new ControlGroup(model);
                }
            });
        }

        if(((JMenuItem)e.getSource())==vue.getInfo()) {
            JOptionPane dialog = new JOptionPane();
            JOptionPane.showMessageDialog(dialog, "Create by : LAROYENNE Guillaume", "Information", 1);
        }

    }
}
