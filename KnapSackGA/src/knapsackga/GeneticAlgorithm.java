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
public class GeneticAlgorithm {

    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int tournamentSize;
    private int elitismCount;
    //{3,4}, {3,4}, {3,4}, {3,4}, {3,4},
//        {4,5}, {4,5}, {4,5},
//        {7,10},{7,10},{8,11},{8,11},{9,13}};
   private int val[] = new int[]{15, 1, 10, 6, 3, 9, 11, 8, 13, 14, 4, 7, 12, 5, 2};//1,2,7,9,10,14  15+1+11+13+14+5
   private int wt[] = new int[]{1, 2, 13, 4, 5, 6, 7, 8, 9, 10, 12, 11, 14, 3, 15};
   private int knapSackWeightCapacity = 32; // i.e 5 elements
   // private int val[] = new int[]{4,4,4,4,4,5,5,5,10,10,11,11,13};
  //  private int wt[] = new int[]{3,3,3,3,3,4,4,4,7,7,8,8,9};
//    private int knapSackWeightCapacity = 32; // i.e 5 elements
  //  private int knapSackWeightCapacity = 17;
    private double optimumValue = 79.00; //79.00 actual
  //  private double optimumValue =  24.00;
    private static double bestSolution = 0.0;  //
    private static Individual bestSolutionInd;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount, int tournamentSize) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
        this.tournamentSize = tournamentSize;
    }

    public Population initPopulation(int chromosomeLength) {
        Population population = new Population(this.populationSize, chromosomeLength);
        return population;
    }

    //Evaluate Population
    public void evalPopulation(Population population) {
        double populationFitness = 0;
        for (Individual individual : population.getIndividuals()) {
            populationFitness += calcFitness(individual);
        }
        population.setPopulationFitness(populationFitness);
    }

//    //Calculate Fitness.
//    public double calcFitness(Individual individual) {
//        // Track number of correct genes
//        int correctGenes = 0;
//        // Loop over individual's genes
//        for (int geneIndex = 0; geneIndex < individual.getChromosomeLength();
//                geneIndex++) {
//            // Add one fitness point for each "1" found
//            if (individual.getGene(geneIndex) == 1) {
//                correctGenes += 1;
//            }
//        }
//
//        double fitness = (double) correctGenes / individual.
//                getChromosomeLength();
//        // Store fitness
//        individual.setFitness(fitness);
//        return fitness;
//    }
    public double calcFitness(Individual individual) {

        double total_weight = 0.0;
        double total_value = 0.0;
        double difference;
        double fitness = 0.0;
        for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
            if (individual.getGene(geneIndex) == 1) {
                total_weight = total_weight + wt[geneIndex];
                total_value = total_value + val[geneIndex];
            }
        }

        difference = knapSackWeightCapacity - total_weight;

        if (difference >= 0) {
            fitness = total_value;
        } else {
            fitness = 0.0; // individual will be remove from population
        }

        // Store fitness
        individual.setFitness(fitness);

        return fitness;

    }

    //Check termination condition
    public boolean isTerminationConditionMet(Population population) {
        for (Individual individual : population.getIndividuals()) {
            System.out.println(individual.getFitness() + " : " + optimumValue);
            if (individual.getFitness() == optimumValue) {
//                System.out.println(individual.getFitness() + " : " + optimumValue);
                return true;
            }
        }
        return false;
    }

    // Roullette method to select parent for crossover.
    public Individual selectParent(Population population) {
        // Get individuals
        Individual individuals[] = population.getIndividuals();
        // Spin roulette wheel
        double populationFitness = population.getPopulationFitness();
        double rouletteWheelPosition = Math.random() * populationFitness;
        // Find parent
        double spinWheel = 0;
        for (Individual individual : individuals) {
            spinWheel += individual.getFitness();
            if (spinWheel >= rouletteWheelPosition) {
                return individual;
            }
        }
        return individuals[population.size() - 1];
    }

    //
    public Individual selectParentTournament(Population population) {
        // Create tournament
        Population tournament = new Population(this.tournamentSize);
        // Add random individuals to the tournament
        population.shuffle();
        for (int i = 0; i < this.tournamentSize; i++) {
            Individual tournamentIndividual = population.getIndividual(i);
            tournament.setIndividual(i, tournamentIndividual);
        }
        // Return the best
        return tournament.getFittest(0);
    }

    //Crossover 
    public Population crossoverPopulation(Population population) {
        int crossoverYescount =0;
        int crossoverNocount =0;
        // Create new population
        Population newPopulation = new Population(population.size());
        // Loop over current population by fitness
        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Individual parent1 = population.getFittest(populationIndex);
            // Apply crossover to this individual?
            if (this.crossoverRate > Math.random() && populationIndex > this.elitismCount) {
                crossoverYescount++;
                // Initialize offspring
                Individual offspring = new Individual(parent1.getChromosomeLength());
                // Find second parent
                Individual parent2 = selectParentTournament(population);
                // Loop over genome
                for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++) {
                    // Use half of parent1's genes and half ofparent2's genes
                    if (0.5 > Math.random()) {
                        offspring.setGene(geneIndex, parent1.getGene(geneIndex));
                    } else {
                        offspring.setGene(geneIndex, parent2.getGene(geneIndex));
                    }
                }
                // Add offspring to new population
                newPopulation.setIndividual(populationIndex, offspring);
            } else {
                crossoverNocount++;
                // Add individual to new population without applying crossover
                newPopulation.setIndividual(populationIndex, parent1);
            }
        }
        
        System.out.println("Yes" + crossoverYescount);
        System.out.println("No" + crossoverNocount);
//        System.exit(0);
        return newPopulation;
    }

    public Population mutatePopulation(Population population) {
        // Initialize new population
        Population newPopulation = new Population(this.populationSize);
        // Loop over current population by fitness
        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Individual individual = population.
                    getFittest(populationIndex);
            // Loop over individual's genes
            for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
                // Skip mutation if this is an elite individual
                if (populationIndex >= this.elitismCount) {
                    // Does this gene need mutation?
                    if (this.mutationRate > Math.random()) {
                        // Get new gene
                        int newGene = 1;
                        if (individual.getGene(geneIndex) == 1) {
                            newGene = 0;
                        }
                        // Mutate gene
                        individual.setGene(geneIndex, newGene);
                    }
                }
            }
            // Add individual to population
            newPopulation.setIndividual(populationIndex, individual);
        }
        // Return mutated population
        return newPopulation;
    }

}
