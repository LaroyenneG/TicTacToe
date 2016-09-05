/**
 * Created by guillaume on 05/09/16.
 */
public class Model {

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

    public int getPlayer(){
        return player;
    }
}
