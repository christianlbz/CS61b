package hw2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

public class PercolationStats {
    private double[] fraction;

    public PercolationStats(int N, int T, PercolationFactory pf){
        if (N <= 0 | T <= 0){
            throw new IllegalArgumentException("The N or T should not be negative or zero");
        }
        fraction = new double[T];
        for (int i = 0; i < T; i++){
            Percolation p = pf.make(N);
            while(!p.percolates()){
                int x = StdRandom.uniform(N);
                int y = StdRandom.uniform(N);
                p.open(x,y);
            }
            fraction[i] = ((double) p.numberOfOpenSites())/((double) N*N);
        }

    }   // perform T independent experiments on an N-by-N grid

    public double mean(){
        double sum = 0.0;
        for (double item: fraction){
            sum = sum + item;
        }
        return sum/fraction.length;
    }                                           // sample mean of percolation threshold

    public double stddev(){
        if (fraction.length == 1){
            return Double.NaN;
        } else {
            double sum = 0.0;
            double avg = mean();
            for (double item: fraction){
                sum = sum + (item - avg)*(item - avg);
            }
            return Math.sqrt(sum/(fraction.length-1));
        }

    }                                         // sample standard deviation of percolation threshold

    public double confidenceLow(){
        return mean() - 1.96*stddev()/Math.sqrt(fraction.length);
    }                                  // low endpoint of 95% confidence interval

    public double confidenceHigh(){
        return mean() + 1.96*stddev()/Math.sqrt(fraction.length);
    }                                 // high endpoint of 95% confidence interval

//    public static void main(String[] args) {
//        PercolationFactory pf = new PercolationFactory();
//        PercolationStats ps = new PercolationStats(20,20,pf);
//        System.out.println(ps.mean());
//    }
}
