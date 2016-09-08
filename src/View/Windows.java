package View;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by guillaume on 07/09/16.
 */

public class Windows extends JFrame {

    private static final Color colorTextButton = Color.DARK_GRAY;
    private static final Font jButttonFont = new Font("Helvetica", 1, 35);
    private static final ImageIcon img = new ImageIcon("src/icon.png");
    private static final Color colorcase = Color.WHITE;
    private static final String sigleJ1 = new String("X");
    private static final String sigleJ2 = new String("O");

    private Model model;
    private JLabel dispPlayer;
    private JButton[][] tabJButton;
    public JPanel theGrid;
    private JMenuItem info;
    private JMenuItem reset;


    public Windows(Model model) {
        this.model = model;
        this.initAttribut();
        this.creerWidget();
        this.setTitle("TicTacToe");
        this.setSize(300, 300);
        this.setLocationRelativeTo((Component) null);
        this.setVisible(true);
        this.setResizable(false);
        this.setFocusableWindowState(false);
        this.setDefaultCloseOperation(3);
    }

    private void initAttribut() {
        this.tabJButton = new JButton[this.model.getTaille()][this.model.getTaille()];
        this.theGrid = new JPanel(new GridLayout(this.model.getTaille(), this.model.getTaille(), 3, 3));
        dispPlayer = new JLabel("Le joueur 1 doit jouer");
        reset = new JMenuItem("New game");
        info = new JMenuItem("Info");


    }

    private void creerWidget() {
        JPanel panoPrincipal = new JPanel(new BorderLayout());
        JPanel cadre = new JPanel();
        JMenuBar barMenu = new JMenuBar();
        JMenu menu = new JMenu("Options");
        panoPrincipal.setBackground(Color.white);
        this.theGrid.setBackground(Color.black);
        cadre.setLayout(new BorderLayout(10, 10));
        cadre.setBackground(Color.white);
        cadre.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.dispPlayer.setHorizontalAlignment(0);
        menu.add(reset);
        menu.add(info);

        barMenu.add(menu);
        this.setJMenuBar(barMenu);
        panoPrincipal.add(this.dispPlayer, "North");
        cadre.add(this.theGrid);
        panoPrincipal.add(cadre, "Center");
        this.setContentPane(panoPrincipal);
        this.createGrid();
        this.showGrid();
    }

    public void setButtonControler(ActionListener listener) {
        for (int y = 0; y < this.tabJButton.length; ++y) {
            for (int x = 0; x < this.tabJButton[y].length; ++x) {
                this.tabJButton[y][x].addActionListener(listener);
            }
        }

    }

    public void setMenuControler(ActionListener listener) {
            reset.addActionListener(listener);
        info.addActionListener(listener);
    }

    private void createGrid() {
        int[][] modelGrid = this.model.getGrid();
        this.tabJButton = new JButton[this.model.getTaille()][this.model.getTaille()];

        for (int y = 0; y < this.model.getTaille(); ++y) {
            for (int x = 0; x < this.model.getTaille(); ++x) {
                if (modelGrid[y][x] == 0) {
                    this.tabJButton[y][x] = new JButton("");
                    this.tabJButton[y][x].setBackground(colorcase);
                } else {
                    if (modelGrid[y][x] == 1) {
                        this.tabJButton[y][x] = new JButton(sigleJ1);
                    }
                    if (modelGrid[y][x] == 2) {
                        this.tabJButton[y][x] = new JButton(sigleJ2);
                    }
                }
                this.tabJButton[y][x].setBorderPainted(false);
                this.tabJButton[y][x].setRequestFocusEnabled(false);
                this.tabJButton[y][x].setFont(jButttonFont);
                this.tabJButton[y][x].setForeground(colorTextButton);
            }
        }

        this.controlTrue();
    }

    private void showGrid() {
        for (int y = 0; y < this.tabJButton.length; ++y) {
            for (int x = 0; x < this.tabJButton[y].length; ++x) {
                this.theGrid.add(this.tabJButton[y][x]);
            }
        }

    }

    public void actualizeGrid() {
        int[][] modelGrid = this.model.getGrid();

        for (int y = 0; y < this.tabJButton.length; ++y) {
            for (int x = 0; x < this.tabJButton[y].length; ++x) {
                if (modelGrid[y][x] == 0) {
                    this.tabJButton[y][x].setText("");
                } else {
                    if (modelGrid[y][x] == 1) {
                        this.tabJButton[y][x].setText(sigleJ1);
                    }
                    if (modelGrid[y][x] == 2) {
                        this.tabJButton[y][x].setText(sigleJ2);
                    }

                }
                //this.tabJButton[y][x].setBackground(colorcase);
            }
        }

    }

    public void controlFalse() {
        int[][] modelGrid = this.model.getGrid();

        for (int y = 0; y < this.tabJButton.length; ++y) {
            for (int x = 0; x < this.tabJButton[y].length; ++x) {
                this.tabJButton[y][x].setEnabled(false);
            }
        }

    }

    public void dispMessage(int i){
        JOptionPane dialog = new JOptionPane();

        if(i==0){
            JOptionPane.showMessageDialog(dialog, "Match null", "Ok", 1);
        }else if(1==i){
            JOptionPane.showMessageDialog(dialog, "Tu as gagné !!", "Bravo joueur 1", 1);
        }else if(2==i){
            JOptionPane.showMessageDialog(dialog, "Tu as gagné !!", "Bravo joueur 2", 1);
        }

    }

    public void controlTrue() {
        int[][] modelGrid = this.model.getGrid();

        for (int y = 0; y < this.tabJButton.length; ++y) {
            for (int x = 0; x < this.tabJButton[y].length; ++x) {
                this.tabJButton[y][x].setEnabled(true);
            }
        }

    }

    public void showPlayer() {

        if (model.getPlayer() == 1) {
            dispPlayer.setText("Le joueur 1 doit jouer");
        }
        if (model.getPlayer() == 2) {
            dispPlayer.setText("Le joueur 2 doit jouer");
        }

    }

    public JButton[][] getTabJButton() {
        return tabJButton;
    }

    public JMenuItem getReset() {
        return this.reset;
    }

    public JMenuItem getInfo(){
        return this.info;
    }

    public void visible(boolean b) {
        this.setVisible(b);
    }

}