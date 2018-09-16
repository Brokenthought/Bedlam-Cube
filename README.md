# Bedlam-Cube
Bedlam Cube Solver
This was my second year java project, I decided to see if I could write a program to solve the bedlam cube puzzle: https://en.wikipedia.org/wiki/Bedlam_cube
One of which had sat on my shelf unsolved for 5 years. The program was capable of finding many solutions though each solution took multiple hours to compute.

The program works by representing the cube as a 4x4x4 3 dimensional boolean array.
Each piece of the puzzle is represented in the array according to its shape, the elements that that shape occupies are set to true, when every element in the array is true the cube is solved. 

Each solution requires a seed to begin, so that it knows which piece to try and place first, the seed is some ordering of the pieces, of which there are 13, e.g. 7c23456089ab1.
There are 13! possible seeds, disregarding symmetries, so it’s a good thing there are multiple solutions!

To save time, before the program tries to generate a solution, a table for each piece is generated. This table contains every possible valid position and orientation. 
When trying to place a piece the program will then iterate through this table until it either finds a way to fit the piece into the puzzle, or it exhausts the table.

If the later happens the program will discard that solution and try another.

To start the program open the Cube.java and press run, there is a good deal of luck involved depending on the seed, so finding a solution may take some time. This is a valid solution if you don't want to wait: 9c562a043817b
