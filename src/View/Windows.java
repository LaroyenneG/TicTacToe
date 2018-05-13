package View;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Windows extends JFrame {

    private static final Color COLOR_TEXT_BUTTON = Color.DARK_GRAY;
    private static final Font J_BUTTON_FONT = new Font("Helvetica", Font.BOLD, 35);
    private static final Color COLOR_CASE = Color.WHITE;
    private static final String SIDLE_J1 = "X";
    private static final String SIDLE_J2 = "O";

    private Model model;
    private JLabel dispPlayer;
    private JButton[][] tabJButton;
    private JPanel theGrid;
    private JMenuItem info;
    private JMenuItem reset;


    public Windows(Model model) {
        this.model = model;
        this.initAttribute();
        this.createWidget();
        this.setTitle("TicTacToe");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setFocusableWindowState(false);
        this.setDefaultCloseOperation(3);
    }

    private void initAttribute() {
        this.tabJButton = new JButton[this.model.getSize()][this.model.getSize()];
        this.theGrid = new JPanel(new GridLayout(this.model.getSize(), this.model.getSize(), 3, 3));
        dispPlayer = new JLabel("Le joueur 1 doit jouer");
        reset = new JMenuItem("New game");
        info = new JMenuItem("Info");
    }

    private void createWidget() {
        JPanel panoPrincipal = new JPanel(new BorderLayout());
        JPanel cadre = new JPanel();
        JMenuBar barMenu = new JMenuBar();
        JMenu menu = new JMenu("Options");
        panoPrincipal.setBackground(Color.white);
        theGrid.setBackground(Color.black);
        cadre.setLayout(new BorderLayout(10, 10));
        cadre.setBackground(Color.white);
        cadre.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        dispPlayer.setHorizontalAlignment(0);
        menu.add(reset);
        menu.add(info);

        barMenu.add(menu);
        setJMenuBar(barMenu);
        panoPrincipal.add(dispPlayer, "North");
        cadre.add(theGrid);
        panoPrincipal.add(cadre, "Center");
        setContentPane(panoPrincipal);
        createGrid();
        showGrid();
    }

    public void setButtonControler(ActionListener listener) {
        for (JButton[] aTabJButton : this.tabJButton) {
            for (JButton anATabJButton : aTabJButton) {
                anATabJButton.addActionListener(listener);
            }
        }

    }

    public void setMenuController(ActionListener listener) {
        reset.addActionListener(listener);
        info.addActionListener(listener);
    }

    private void createGrid() {

        int[][] modelGrid = model.getGrid();
        tabJButton = new JButton[model.getSize()][model.getSize()];

        for (int y = 0; y < model.getSize(); ++y) {
            for (int x = 0; x < model.getSize(); ++x) {
                if (modelGrid[y][x] == 0) {
                    tabJButton[y][x] = new JButton("");
                    tabJButton[y][x].setBackground(COLOR_CASE);
                } else {
                    if (modelGrid[y][x] == 1) {
                        tabJButton[y][x] = new JButton(SIDLE_J1);
                    }
                    if (modelGrid[y][x] == 2) {
                        tabJButton[y][x] = new JButton(SIDLE_J2);
                    }
                }
                tabJButton[y][x].setBorderPainted(false);
                tabJButton[y][x].setRequestFocusEnabled(false);
                tabJButton[y][x].setFont(J_BUTTON_FONT);
                tabJButton[y][x].setForeground(COLOR_TEXT_BUTTON);
            }
        }

        controlTrue();
    }

    private void showGrid() {
        for (JButton[] aTabJButton : tabJButton) {
            for (JButton anATabJButton : aTabJButton) {
                theGrid.add(anATabJButton);
            }
        }

    }

    public void actualizeGrid() {

        int[][] modelGrid = model.getGrid();

        for (int y = 0; y < tabJButton.length; ++y) {
            for (int x = 0; x < tabJButton[y].length; ++x) {
                if (modelGrid[y][x] == 0) {
                    tabJButton[y][x].setText("");
                } else {
                    if (modelGrid[y][x] == 1) {
                        tabJButton[y][x].setText(SIDLE_J1);
                    }
                    if (modelGrid[y][x] == 2) {
                        tabJButton[y][x].setText(SIDLE_J2);
                    }

                }
            }
        }

    }

    public void controlFalse() {

        for (JButton[] aTabJButton : tabJButton)
            for (JButton anATabJButton : aTabJButton) {
                anATabJButton.setEnabled(false);
            }

    }

    public void displayMessage(int i) {

        JOptionPane dialog = new JOptionPane();

        if (i == 0) {
            JOptionPane.showMessageDialog(dialog, "Match null", "OK", 1);
        } else if (1 == i) {
            JOptionPane.showMessageDialog(dialog, "Tu as gagné !!", "Bravo joueur 1", 1);
        } else if (2 == i) {
            JOptionPane.showMessageDialog(dialog, "Tu as gagné !!", "Bravo joueur 2", 1);
        }

    }

    public void controlTrue() {

        for (JButton[] aTabJButton : tabJButton) {
            for (JButton anATabJButton : aTabJButton) {
                anATabJButton.setEnabled(true);
            }
        }

    }

    public void showPlayer() {

        if (model.getPlayer()) {
            dispPlayer.setText("Le joueur 1 doit jouer");
        } else {
            dispPlayer.setText("Le joueur 2 doit jouer");
        }

    }

    public JButton[][] getTabJButton() {
        return tabJButton;
    }

    public JMenuItem getReset() {
        return this.reset;
    }

    public JMenuItem getInfo() {
        return info;
    }

    public void visible(boolean b) {
        setVisible(b);
    }
}