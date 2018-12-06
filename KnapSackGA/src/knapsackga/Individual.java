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
public class Individual {

    private int[] chromosome;
    private double fitness = -1;

    public Individual(int[] chromosome) {
// Create individual chromosome
        this.chromosome = chromosome;
    }
    
    
    //Adding values to Knapsack
    //If gene is 1 corresponding value and weight index is added to knapsack.
    public Individual(int chromosomeLength) {
        this.chromosome = new int[chromosomeLength];
        for (int geneIndex = 0; geneIndex < chromosomeLength; geneIndex++) {
            if (0.5 < Math.random()) {
                this.setGene(geneIndex, 1);
            } else {
                this.setGene(geneIndex, 0);
            }
        }
    }

    public int[] getChromosome() {
        return this.chromosome;
    }

    public int getChromosomeLength() {
        return this.chromosome.length;
    }

    public void setGene(int geneIndex, int gene) {
        this.chromosome[geneIndex] = gene;
    }

    public int getGene(int geneIndex) {
        return this.chromosome[geneIndex];
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }

    public String toString() {
        String output = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            output += this.chromosome[gene];
        }
        return output;
    }

}
