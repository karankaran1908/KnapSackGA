/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackga;

/**
 *
 * @author Ritesh
 */
public class KnapSack {

    private int val[] = {};
    private int wt[] = {};
    private int knapSackWeightCapacity;
    private double optimumValue;

    public KnapSack() {
        this.val = new int[]{4, 4, 4, 4, 4, 5, 5, 5, 10, 10, 11, 11, 13};
        this.wt = new int[]{3, 3, 3, 3, 3, 4, 4, 4, 7, 7, 8, 8, 9};
        this.knapSackWeightCapacity = 32;
        this.optimumValue = 24.00;
    }

    public int[] getVal() {
        return val;
    }

    public void setVal(int[] val) {
        this.val = val;
    }

    public int[] getWt() {
        return wt;
    }

    public void setWt(int[] wt) {
        this.wt = wt;
    }

    public int getKnapSackWeightCapacity() {
        return knapSackWeightCapacity;
    }

    public void setKnapSackWeightCapacity(int knapSackWeightCapacity) {
        this.knapSackWeightCapacity = knapSackWeightCapacity;
    }

    public double getOptimumValue() {
        return optimumValue;
    }

    public void setOptimumValue(double optimumValue) {
        this.optimumValue = optimumValue;
    }
    

}
