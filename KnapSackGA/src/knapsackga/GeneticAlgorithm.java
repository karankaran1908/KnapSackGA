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
    private double bestSolution = 0.0;
    private KnapSack ks;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount, int tournamentSize, KnapSack ks) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
        this.tournamentSize = tournamentSize;
        this.ks = ks;
    }

    public Population initializePopulation(int chromosomeLength) {
        Population population = new Population(this.populationSize, chromosomeLength);
        return population;
    }

    //Evaluate Population
    public void evaluatePopulation(Population population) {
        double populationFitness = 0;
        for (Individual individual : population.getIndividuals()) {
            populationFitness += individualFitnessCalculations(individual);
        }
        population.setPopulationFitness(populationFitness);
    }

    public double individualFitnessCalculations(Individual individual) {
        double total_weight = 0.0;
        double total_value = 0.0;
        double difference;
        double fitness = 0.0;
        for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
            if (individual.getGene(geneIndex) == 1) {
                int wt[] = ks.getWt();
                int val[] = ks.getVal();
                total_weight = total_weight + wt[geneIndex];
                total_value = total_value + val[geneIndex];
            }
        }
        int knapSackWeightCapacity = ks.getKnapSackWeightCapacity();
        difference = knapSackWeightCapacity - total_weight;
        
        //If fitness exceeds knapsack capacity then fitness is 0;
        if (difference >= 0) {
            fitness = total_value;
        } else {
            fitness = 0.0;
        }
        individual.setFitness(fitness);
        return fitness;
    }

    /**
     * Gets mean fitness of generation
     */
    public double getMeanFitness(Population population) {
        double total_weight = 0.0;
        double total_value = 0.0;
        double difference;
        double total_fitness = 0.0;
        double meanFitness = 0.0;
        meanFitness = population.getPopulationFitness()/population.size();
        return meanFitness;
    }

    //Check termination condition
    public boolean isTerminationConditionMet(Population population) {
        for (Individual individual : population.getIndividuals()) {
            if (individual.getFitness() == ks.getOptimumValue()) {
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
    public Population crossover(Population population) {
        // Create new population
        Population newPopulation = new Population(population.size());
        // Loop over current population by fitness
        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Individual parent1 = population.getFittest(populationIndex);
            // Apply crossover to this individual?
            if (this.crossoverRate > Math.random() && populationIndex > this.elitismCount) {
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
                // Add individual to new population without applying crossover
                newPopulation.setIndividual(populationIndex, parent1);
            }
        }

        return newPopulation;
    }

    public Population mutate(Population population) {
        // Initialize new population
        Population nextPopulationSet = new Population(this.populationSize);
        // Loop over current population by fitness
        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Individual individual = population.getFittest(populationIndex);
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
            nextPopulationSet.setIndividual(populationIndex, individual);
        }
        // Return mutated population
        return nextPopulationSet;
    }

}
