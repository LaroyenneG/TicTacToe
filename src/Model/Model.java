package Model;


public class Model {

    private static final int J1 = 1;
    private static final int J2 = 2;
    private static final int NONE = 0;

    private int size;
    private int grid[][];
    private boolean player;

    public Model(int size) {

        grid = new int[size][size];

        int x, y;
        for (y = 0; y < grid.length; y++) {
            for (x = 0; x < grid[y].length; x++) {
                grid[y][x] = NONE;
            }
        }

        this.size = size;

        player = true;
    }

    public boolean playerWin(int j) {


        int x, y, z, q;
        int count;

        for (y = 0; y < grid.length; y++) {
            for (x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == j) {
                    z = y;
                    count = 0;
                    while ((z < grid.length) && (grid[z][x] == j)) {
                        count++;
                        z++;

                        if (count == 3) {
                            return true;
                        }
                    }
                    z = x;
                    count = 0;
                    while ((z < grid[y].length) && (grid[y][z] == j)) {
                        count++;
                        z++;

                        if (count == 3) {
                            return true;
                        }
                    }

                    z = y;
                    q = x;
                    count = 0;
                    while ((z < grid[y].length) && (q < grid.length) && (grid[z][q] == j)) {
                        count++;
                        z++;
                        q++;

                        if (count == 3) {
                            return true;
                        }
                    }
                    z = y;
                    q = x;
                    count = 0;
                    while ((z < grid[y].length) && (q >= 0) && (grid[z][q] == j)) {
                        count++;
                        z++;
                        q--;

                        if (count == 3) {
                            return true;
                        }
                    }

                }
            }
        }

        return false;
    }

    private void changePlayer() {
        player = !player;
    }

    public void play(int x, int y) {

        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            if (grid[y][x] == 0) {
                grid[y][x] = player ? J1 : J2;
                changePlayer();
            }
        }
    }

    public boolean canPlay() {

        int x, y, count;

        count = 0;

        for (y = 0; y < grid.length; y++) {
            for (x = 0; x < grid[y].length; x++) {
                if (grid[y][x] != NONE) {
                    count++;
                }
            }
        }

        return count != grid.length * grid.length;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }

    public boolean getPlayer() {
        return player;
    }
}
