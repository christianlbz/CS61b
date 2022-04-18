package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] grid;    //The grid is used to express if the status of element in the grid.If its value equals to
                            //BlockStatus, then the element is blocked, while if not, the element is open.
    private int size;
    private int BlockStatus;
    private int OpenNum = 0;
    private WeightedQuickUnionUF DS;          //The QuickUnion set contains an array with its length equals to
                                              //size*size+2, in which the item with index equals to size*size represent
                                              //the top row, and the item with index equals to size*size+1 represent the
                                              //the bottom row.The other correspond with the grid items.

    public Percolation(int N){
        if (N < 0){
            throw new IllegalArgumentException("The grid size should not be negative");
        } else {
            this.grid = new int[N][N];
            this.size = N;
            this.BlockStatus = N*N + 1;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    grid[i][j] = this.BlockStatus;
                }
            }
            DS = new WeightedQuickUnionUF(N*N + 2);
            for (int i = 0; i < size; i++){
                DS.union(N*N, convert(0,i)); //The N*N item in QuickUnion connect to the top row.
                DS.union(N*N+1,convert(size-1,i));  //The N*N item in QuickUnion connects to the bottom row.
            }
        }
    }                // create N-by-N grid, with all sites initially blocked

    public void open(int row, int col){
        if (Math.min(row, col) < 0 | Math.max(row, col) > size - 1){
            throw new IndexOutOfBoundsException("The index of out Bound of the grid.");
        } else {
            if (!isOpen(row,col)){
            grid[row][col] = convert(row, col);
            OpenNum += 1;
            for (int[] each: surround(row,col)){
                if (each != null && isOpen(each[0],each[1])) {
                    DS.union(convert(row, col), convert(each[0], each[1]));
                    }
                }
            }
        }
    }       // open the site (row, col) if it is not open already

    public boolean isOpen(int row, int col){
        if (Math.min(row, col) < 0 | Math.max(row, col) > size - 1){
            throw new IndexOutOfBoundsException("The index of out Bound of the grid.");
        } else{
        return !(grid[row][col] == this.BlockStatus);
        }
    }  // is the site (row, col) open?

    public boolean isFull(int row, int col){
        if (Math.min(row, col) < 0 | Math.max(row, col) > size - 1){
            throw new IndexOutOfBoundsException("The index of out Bound of the grid.");
        } else {
            return DS.connected(convert(row,col),size*size);
        }
    }  // is the site (row, col) full?

    public int numberOfOpenSites(){
        return OpenNum;
    }        // number of open sites

    public boolean percolates(){
        return DS.connected(size*size, size*size+1);
    }              // does the system percolate?

    private int convert(int row,int column){
        return row*this.size + column;
    }


    private int[][] surround(int row, int col){
        int[][] sur = new int[4][];
        if (row != 0 & row != size-1){
            if (col != 0 & col != size-1){
                sur[0] = new int[] {row+1,col};
                sur[1] = new int[] {row,col+1};
                sur[2] = new int [] {row,col-1};
                sur[3] = new int [] {row-1,col};
            }
            if (col == 0){
                sur[0] = new int[] {row+1,col};
                sur[1] = new int[] {row,col+1};
                sur[2] = new int [] {row-1,col};
            }
            if (col == size - 1){
                sur[0] = new int[] {row+1,col};
                sur[1] = new int [] {row,col-1};
                sur[2] = new int [] {row-1,col};
            }
        }
        if (row == 0){
            if (col != 0 & col != size-1){
                sur[0] = new int[] {row+1,col};
                sur[1] = new int[] {row,col+1};
                sur[2] = new int [] {row,col-1};
            }
            if (col == 0){
                sur[0] = new int[] {row+1,col};
                sur[1] = new int[] {row,col+1};
            }
            if (col == size-1){
                sur[0] = new int[] {row+1,col};
                sur[1] = new int [] {row,col-1};
            }
        }
        if (row == size - 1){
            if (col != 0 & col != size-1){
                sur[0] = new int[] {row-1,col};
                sur[1] = new int[] {row,col+1};
                sur[2] = new int [] {row,col-1};
            }
            if (col == 0){
                sur[0] = new int[] {row-1,col};
                sur[1] = new int[] {row,col+1};
            }
            if (col == size-1){
                sur[0] = new int[] {row-1,col};
                sur[1] = new int [] {row,col-1};
            }
        }
        return sur;
    }


}
