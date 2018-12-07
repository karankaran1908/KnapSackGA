/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackgaTest;

import java.math.BigDecimal;
import knapsackga.GeneticAlgorithm;
import knapsackga.Individual;
import knapsackga.KnapSack;
import knapsackga.Population;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ritesh
 */
public class KnapsackgaTest {

    @Test
    public void testSolveKnapSack1() {
        try {
            KnapSack ks = new KnapSack();
            int wt[] = new int[]{23,31,29,44,53,38,63,85,89,82};
            int val[] = new int[]{92,57,49,68,60,43,67,84,87,72};
            String solution = "1111010000";
            double optVal = 309.00;
            ks.setWt(wt);
            ks.setVal(val);
            ks.setKnapSackWeightCapacity(165);
            ks.setOptimumValue(optVal);
            ks.setChromosomeLength(val.length);
            GeneticAlgorithm ga = new GeneticAlgorithm(6, 0.2, 0.1, 4, 4,ks);
            // Initialize population
            Population population = ga.initPopulation(ks.getChromosomeLength());
            // Evaluate population
            ga.evalPopulation(population);
            // Keep track of current generation
            int generationCount = 1;
            System.out.println("Initial count"+generationCount);
            while (ga.isTerminationConditionMet(population) == false && generationCount < 1000) {
                // Print fittest individual from population
                System.out.println("Best solution: " + population.getFittest(0).toString());
                // Apply crossover
                population = ga.crossoverPopulation(population);
                // Apply mutation
                population = ga.mutatePopulation(population);
                // Evaluate population
                ga.evalPopulation(population);
                // Increment the current generation
                generationCount++;
            }
            System.out.println("Found solution in " + generationCount + "generations");
            System.out.println("Best solution: " + population.getFittest(0).toString());
            double fittestValue = ga.calcFitness(population.getFittest(0));
//           assertEquals(population.getFittest(0).toString(), solution);
            assertEquals(fittestValue, optVal,2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSolveKnapSack2() {
        try {
            KnapSack ks = new KnapSack();
            int wt[] = new int[]{12, 7,11, 8, 9};
            int val[] = new int[]{24,13 ,23,15,16};
            double optVal = 51.00;
            ks.setWt(wt);
            ks.setVal(val);
            ks.setKnapSackWeightCapacity(26);
            ks.setOptimumValue(optVal);
            ks.setChromosomeLength(val.length);
            GeneticAlgorithm ga = new GeneticAlgorithm(6, 0.2, 0.1, 4, 4,ks);
            // Initialize population
            Population population = ga.initPopulation(ks.getChromosomeLength());
            // Evaluate population
            ga.evalPopulation(population);
            // Keep track of current generation
            int generationCount = 1;
            System.out.println("Initial count"+generationCount);
            while (ga.isTerminationConditionMet(population) == false && generationCount < 1000) {
                // Print fittest individual from population
                System.out.println("Best solution: " + population.getFittest(0).toString());
                // Apply crossover
                population = ga.crossoverPopulation(population);
                // Apply mutation
                population = ga.mutatePopulation(population);
                // Evaluate population
                ga.evalPopulation(population);
                // Increment the current generation
                generationCount++;
            }
            System.out.println("Found solution in " + generationCount + "generations");
            System.out.println("Best solution: " + population.getFittest(0).toString());
            double fittestValue = ga.calcFitness(population.getFittest(0));
//            assertEquals(population.getFittest(0).toString(), solution);
            assertEquals(fittestValue, optVal,2.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSolveKnapSack3() {
        try {
            KnapSack ks = new KnapSack();
            int wt[] = new int[]{56 ,59 ,80 ,64 ,75 ,17};
            int val[] = new int[]{50 ,50 ,64 ,46 ,50 , 5};
            double optVal = 150.00;
            ks.setWt(wt);
            ks.setVal(val);
            ks.setKnapSackWeightCapacity(190);
            ks.setOptimumValue(optVal);
            ks.setChromosomeLength(val.length);
            GeneticAlgorithm ga = new GeneticAlgorithm(6, 0.2, 0.1, 4, 4,ks);
            // Initialize population
            Population population = ga.initPopulation(ks.getChromosomeLength());
            // Evaluate population
            ga.evalPopulation(population);
            // Keep track of current generation
            int generationCount = 1;
            System.out.println("Initial count"+generationCount);
            while (ga.isTerminationConditionMet(population) == false && generationCount < 1000) {
                // Print fittest individual from population
                System.out.println("Best solution: " + population.getFittest(0).toString());
                // Apply crossover
                population = ga.crossoverPopulation(population);
                // Apply mutation
                population = ga.mutatePopulation(population);
                // Evaluate population
                ga.evalPopulation(population);
                // Increment the current generation
                generationCount++;
            }
            System.out.println("Found solution in " + generationCount + "generations");
            System.out.println("Best solution: " + population.getFittest(0).toString());
            double fittestValue = ga.calcFitness(population.getFittest(0));
//            assertEquals(population.getFittest(0).toString(), solution);
            assertEquals(fittestValue, optVal,2.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSolveKnapSack4() {
        try {
            KnapSack ks = new KnapSack();
            int wt[] = new int[]{31 ,10 ,20 ,19 , 4 , 3 , 6};
            int val[] = new int[]{70 ,20 ,39 ,37 , 7 , 5 ,10};
            double optVal = 107.00;
            ks.setWt(wt);
            ks.setVal(val);
            ks.setKnapSackWeightCapacity(50);
            ks.setOptimumValue(optVal);
            ks.setChromosomeLength(val.length);
            GeneticAlgorithm ga = new GeneticAlgorithm(6, 0.2, 0.1, 4, 4,ks);
            // Initialize population
            Population population = ga.initPopulation(ks.getChromosomeLength());
            // Evaluate population
            ga.evalPopulation(population);
            // Keep track of current generation
            int generationCount = 1;
            while (ga.isTerminationConditionMet(population) == false && generationCount < 1000) {
                // Print fittest individual from population
                System.out.println("Best solution: " + population.getFittest(0).toString());
                // Apply crossover
                population = ga.crossoverPopulation(population);
                // Apply mutation
                population = ga.mutatePopulation(population);
                // Evaluate population
                ga.evalPopulation(population);
                // Increment the current generation
                generationCount++;
            }
            System.out.println("Found solution in " + generationCount + "generations");
            System.out.println("Best solution: " + population.getFittest(0).toString());
            double fittestValue = ga.calcFitness(population.getFittest(0));
//            assertEquals(population.getFittest(0).toString(), solution);
            assertEquals(fittestValue, optVal,2.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSolveKnapSack5() {
        try {
            KnapSack ks = new KnapSack();
            int wt[] = new int[]{25 ,35 ,45 , 5 ,25 , 3 , 2 , 2};
            int val[] = new int[]{350 ,00 ,50 ,20 ,70 , 8 , 5 , 5};
            double optVal = 500.00;
            ks.setWt(wt);
            ks.setVal(val);
            ks.setKnapSackWeightCapacity(104);
            ks.setOptimumValue(optVal);
            ks.setChromosomeLength(val.length);
            GeneticAlgorithm ga = new GeneticAlgorithm(6, 0.2, 0.1, 4, 4,ks);
            // Initialize population
            Population population = ga.initPopulation(ks.getChromosomeLength());
            // Evaluate population
            ga.evalPopulation(population);
            // Keep track of current generation
            int generationCount = 1;
            while (ga.isTerminationConditionMet(population) == false && generationCount < 1000) {
                // Print fittest individual from population
                System.out.println("Best solution: " + population.getFittest(0).toString());
                // Apply crossover
                population = ga.crossoverPopulation(population);
                // Apply mutation
                population = ga.mutatePopulation(population);
                // Evaluate population
                ga.evalPopulation(population);
                // Increment the current generation
                generationCount++;
            }
            System.out.println("Found solution in " + generationCount + "generations");
            System.out.println("Best solution: " + population.getFittest(0).toString());
            double fittestValue = ga.calcFitness(population.getFittest(0));
//            assertEquals(population.getFittest(0).toString(), solution);
            assertEquals(fittestValue, optVal,2.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSolveKnapSack6() {
        try {
            KnapSack ks = new KnapSack();
            int wt[] = new int[]{41 ,50 ,49 ,59 ,55 ,57 ,60};
            int val[] = new int[]{442 ,525 ,511 ,593 ,546 ,564 ,617};
            double optVal = 1735.00;
            ks.setWt(wt);
            ks.setVal(val);
            ks.setKnapSackWeightCapacity(170);
            ks.setOptimumValue(optVal);
            ks.setChromosomeLength(val.length);
            GeneticAlgorithm ga = new GeneticAlgorithm(6, 0.2, 0.1, 4, 4,ks);
            // Initialize population
            Population population = ga.initPopulation(ks.getChromosomeLength());
            // Evaluate population
            ga.evalPopulation(population);
            // Keep track of current generation
            int generationCount = 1;
            while (ga.isTerminationConditionMet(population) == false && generationCount < 1000) {
                // Print fittest individual from population
                System.out.println("Best solution: " + population.getFittest(0).toString());
                // Apply crossover
                population = ga.crossoverPopulation(population);
                // Apply mutation
                population = ga.mutatePopulation(population);
                // Evaluate population
                ga.evalPopulation(population);
                // Increment the current generation
                generationCount++;
            }
            System.out.println("Found solution in " + generationCount + "generations");
            System.out.println("Best solution: " + population.getFittest(0).toString());
            double fittestValue = ga.calcFitness(population.getFittest(0));
//            assertEquals(population.getFittest(0).toString(), solution);
            assertEquals(fittestValue, optVal,30.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSolveKnapSack7() {
        try {
            KnapSack ks = new KnapSack();
            int wt[] = new int[]{70 , 73 , 77 , 80 , 82 , 87 , 90 , 94 , 98 ,106 ,110 ,113 ,115 ,118 ,120};
            int val[] = new int[]{135 ,139 ,149 ,150 ,156 ,163 ,173 ,184 ,192 ,201 ,210 ,214 ,221 ,229 ,240};
            double optVal = 1458.00;
            ks.setWt(wt);
            ks.setVal(val);
            ks.setKnapSackWeightCapacity(750);
            ks.setOptimumValue(optVal);
            ks.setChromosomeLength(val.length);
            GeneticAlgorithm ga = new GeneticAlgorithm(6, 0.2, 0.1, 4, 4,ks);
            // Initialize population
            Population population = ga.initPopulation(ks.getChromosomeLength());
            // Evaluate population
            ga.evalPopulation(population);
            // Keep track of current generation
            int generationCount = 1;
            while (ga.isTerminationConditionMet(population) == false && generationCount < 1000) {
                // Print fittest individual from population
                System.out.println("Best solution: " + population.getFittest(0).toString());
                // Apply crossover
                population = ga.crossoverPopulation(population);
                // Apply mutation
                population = ga.mutatePopulation(population);
                // Evaluate population
                ga.evalPopulation(population);
                // Increment the current generation
                generationCount++;
            }
            System.out.println("Found solution in " + generationCount + "generations");
            System.out.println("Best solution: " + population.getFittest(0).toString());
            double fittestValue = ga.calcFitness(population.getFittest(0));
//            assertEquals(population.getFittest(0).toString(), solution);
            assertEquals(fittestValue, optVal,30.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSolveKnapSack8() {
        try {
            KnapSack ks = new KnapSack();
            int wt[] = new int[]{1, 2, 13, 4, 5, 6, 7, 8, 9, 10, 12, 11, 14, 3, 15};
            int val[] = new int[]{15, 1, 10, 6, 3, 9, 11, 8, 13, 14, 4, 7, 12, 5, 2};
            double optVal = 60.00;
            ks.setWt(wt);
            ks.setVal(val);
            ks.setKnapSackWeightCapacity(32);
            ks.setOptimumValue(optVal);
            ks.setChromosomeLength(val.length);
            GeneticAlgorithm ga = new GeneticAlgorithm(6, 0.2, 0.1, 4, 4,ks);
            // Initialize population
            Population population = ga.initPopulation(ks.getChromosomeLength());
            // Evaluate population
            ga.evalPopulation(population);
            // Keep track of current generation
            int generationCount = 1;
            while (ga.isTerminationConditionMet(population) == false && generationCount < 10000) {
                // Print fittest individual from population
                System.out.println("Best solution: " + population.getFittest(0).toString());
                // Apply crossover
                population = ga.crossoverPopulation(population);
                // Apply mutation
                population = ga.mutatePopulation(population);
                // Evaluate population
                ga.evalPopulation(population);
                // Increment the current generation
                generationCount++;
            }
            System.out.println("Found solution in " + generationCount + "generations");
            System.out.println("Best solution: " + population.getFittest(0).toString());
            double fittestValue = ga.calcFitness(population.getFittest(0));
//            assertEquals(population.getFittest(0).toString(), solution);
            assertEquals(fittestValue, optVal,30.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
