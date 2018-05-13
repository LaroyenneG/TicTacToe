package Model;


public class Model {

    private int size;
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

    public boolean playerWin(int j){

        if((j!=1)&&(j!=2)){
            return false;
        }

        int x,y,z,q;
        int count;

        for (y=0;y<grid.length;y++){
            for (x=0;x<grid[y].length;x++){
                if(grid[y][x]==j){
                    z=y;
                    count=0;
                    while ((z<grid.length)&&(grid[z][x]==j)){
                        count++;
                        z++;

                        if (count == 3){
                            return true;
                        }
                    }
                    z=x;
                    count=0;
                    while ((z<grid[y].length)&&(grid[y][z]==j)){
                        count++;
                        z++;

                        if (count == 3){
                            return true;
                        }
                    }

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

    public void play(int player, int x, int y) {

        if (this.player==player){
            if (x>=0 && x<3 && y>=0 && y<3){
                if (grid[y][x]==0){
                    grid[y][x]=player;
                    changePlayer();
                }
            }
        }

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
        return count != grid.length * grid.length;
    }

    public int[][] getGrid(){
        return grid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int taille) {
        this.size = taille;
    }

    public int getPlayer(){
        return player;
    }
}
