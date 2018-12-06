Project: Knapsack using Genetic Algorithm

Team- INFO6205_234

Team Member- Karan Karan(001449291), Ritesh Manek(001494692)

1. Introduction

Genetic algorithms (GAs) are stochastic search algorithms that mimic the biological process of evolution enabling thereby users to solve complex optimization problems. They operate based on a population of chromosomes, where a chromosome represents a candidate solution. Genetic operators allow the population to evolve over time and to converge to the optimal solution.
GAs have shown to be well suited for high-quality solutions to larger NP problems and currently they are the most efficient ways for finding an approximately optimal solution for optimization problems. They do not involve extensive search algorithms and do not try to find the best solution, but they simply generate a candidate for a solution, check in polynomial time whether it is a solution or not and how good a solution it is. GAs do not always give the optimal solution, but a solution that is close enough to the optimal one. 
 
2. Problem Statement

The objective of the project is the implementation of the genetic algorithm for solving the knapsack problem. In the report, we mentioned two selection functions, roulette-wheel and tournament selection, but we have implemented tournament selection in the program. Although roulette-wheel function code is also present in code but commented. The results from both of them differed depending on whether we used elitism or not. Elitism significantly improved the performance of the tournament selection function. Moreover, we tested the program with different crossover ratios, mutation rate but the results given were not that different.

3. Implementation

Project source code in the KnapSackGA/src/knapsackga folder.
A detailed report of this project and including basics about genetic algorithms in file named: Project Report- Knapsack using GA.pdf
