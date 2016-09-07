package Model;

import Model.Model;

import java.util.Scanner;

/**
 * Created by guillaume on 05/09/16.
 */
public class Test {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);


        Model model = new Model();

        //int grid[][] ={{2,2,1},{0,1,2},{1,2,1}};

        int w;
        while ((!model.playerWin(1))&&!(model.playerWin(2))&&(model.canPlay())){
            int x,y,j;
            j=model.getPlayer();

            System.out.println("joueur "+j);
            model.showGrid();
            System.out.println("x=");
            x=scanner.nextInt();
            System.out.println("y=");
            y=scanner.nextInt();

            model.play(j,x-1,y-1);
            w=j;

        }
        if (model.playerWin(1)) {
            System.out.println("Le joueur 1 à gagné");
        }else {
            if (model.playerWin(2)) {
                System.out.println("Le joueur 2 à gagné");
            }else {
                System.out.println("Match null");
            }
        }
        System.exit(0);
    }
}
