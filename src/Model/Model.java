package Model;

/**
 * Created by guillaume on 05/09/16.
 */
public class Model {

    private int taille;
    private int grid[][];
    private int player;

    public Model(){
        grid=new int[3][3];

        int x,y;
        for (y=0;y<grid.length;y++){
            for (x=0;x<grid[y].length;x++){
                grid[y][x]=0;
            }
        }
        player=1;
    }

    public void showGrid(){
        int x,y;

        for (y=0;y<grid.length;y++){
            System.out.println("");
            for (x=0;x<grid[y].length;x++){
                System.out.print(String.valueOf(grid[y][x])+" ");
            }
        }
        System.out.println("");
    }

    public boolean playerWin(int j){
        if((j!=1)&&(j!=2)){
            return false;
        }

        int x,y,z,q;
        int count;

        for (y=0;y<grid.length;y++){
            for (x=0;x<grid[y].length;x++){
                if(grid[y][x]==j){
                    //Teste des colones
                    z=y;
                    count=0;
                    while ((z<grid.length)&&(grid[z][x]==j)){
                        count++;
                        z++;

                        if (count == 3){
                            return true;
                        }
                    }
                    //Teste des lignes
                    z=x;
                    count=0;
                    while ((z<grid[y].length)&&(grid[y][z]==j)){
                        count++;
                        z++;

                        if (count == 3){
                            return true;
                        }
                    }

                    //Teste diagonal droit
                    z=y;
                    q=x;
                    count=0;
                    while ((z<grid[y].length)&&(q<grid.length)&&(grid[z][q]==j)){
                        count++;
                        z++;
                        q++;

                        if (count == 3){
                            return true;
                        }
                    }
                    //Teste diagonal gauche
                    z=y;
                    q=x;
                    count=0;
                    while ((z<grid[y].length)&&(q>=0)&&(grid[z][q]==j)){
                        count++;
                        z++;
                        q--;

                        if (count == 3){
                            return true;
                        }
                    }

                }
            }
        }


        return false;
    }

    private void changePlayer(){
        if (player==1){
            player=2;
        }else {
            player=1;
        }
    }

    public boolean play(int player, int x, int y){

        if (this.player==player){
            if (x>=0 && x<3 && y>=0 && y<3){
                if (grid[y][x]==0){
                    grid[y][x]=player;
                    changePlayer();
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canPlay(){
        int x,y,count;

        count=0;
        for(y=0;y<grid.length;y++){
            for(x=0;x<grid[y].length;x++){
                if (grid[y][x]!=0){
                    count++;
                }
            }
        }
        if (count==grid.length*grid.length){
            return false;
        }
        return true;
    }

    public void setGrid(int grid[][]){
        if((grid.length==3)&&(grid[0].length==3)){
            this.grid=grid;
        }else {
            System.out.println("Error");
        }
    }


    static int[][] GridStringToInt(String string){
        int[][] newGrid=new int[3][3];

        if ((string.charAt(0)=='{')&&(string.charAt(1)=='{')&&(string.charAt(3)==',')&&(string.charAt(5)==',')&&(string.charAt(7)=='}')&&(string.charAt(8)==',')&&(string.charAt(9)=='{')&&(string.charAt(11)==',')&&(string.charAt(13)==',')&&(string.charAt(15)=='}')&&(string.charAt(16)==',') &&(string.charAt(17)=='{')&&(string.charAt(19)==',')&&(string.charAt(21)==',')&&(string.charAt(23)=='}') &&(string.charAt(24)=='}')){

            newGrid[0][0]=Character.getNumericValue(string.charAt(2));
            newGrid[0][1]=Character.getNumericValue(string.charAt(4));
            newGrid[0][2]=Character.getNumericValue(string.charAt(6));

            newGrid[1][0]=Character.getNumericValue(string.charAt(10));
            newGrid[1][1]=Character.getNumericValue(string.charAt(12));
            newGrid[1][2]=Character.getNumericValue(string.charAt(14));

            newGrid[2][0]=Character.getNumericValue(string.charAt(18));
            newGrid[2][1]=Character.getNumericValue(string.charAt(20));
            newGrid[2][2]=Character.getNumericValue(string.charAt(22));
        }

        return newGrid;
    }

    public int[][] getGrid(){
        return grid;
    }

    public int getTaille(){
        return taille;
    }

    public void setTaille(int taille){
        this.taille=taille;
    }

    public int getPlayer(){
        return player;
    }
}
