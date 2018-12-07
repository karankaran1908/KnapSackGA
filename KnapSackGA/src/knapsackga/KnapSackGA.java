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
public class KnapSackGA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KnapSack ks =new KnapSack();
        // Create GA object
        GeneticAlgorithm ga = new GeneticAlgorithm(6, 0.2, 0.1, 4,4,ks);
        // Initialize population
        Population population = ga.initPopulation(13);
        // Evaluate population
        ga.evalPopulation(population);
        // Keep track of current generation
        int generationCount = 1;
        while (ga.isTerminationConditionMet(population) == false && generationCount<1000) {
            // Print fittest individual from population
            System.out.println("Best solution: " + population.getFittest(0).toString());
            // Apply crossover
            population = ga.crossoverPopulation(population);
            // Apply mutation
            population = ga.mutatePopulation(population);
            // Evaluate population
            ga.evalPopulation(population);
            Individual individuals[] = population.getIndividuals();
            System.out.println("Generation Count : "+generationCount);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Individual    | Fitness");
            for(Individual individual : individuals){
                System.out.println(individual +" | "+individual.getFitness());
            }
//            ga.getMeanFitness(population);
            System.out.println("Mean fitnesss for generation :"+generationCount+" is : "+ga.getMeanFitness(population));
            // Increment the current generation
            generationCount++;
            
        }
        System.out.println("Found solution in " + generationCount + "generations");
        System.out.println("Best solution: " + population.getFittest(0).toString());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    }

}
