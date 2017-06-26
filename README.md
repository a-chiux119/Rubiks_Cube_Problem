# Rubiks_Cube_Problem
My attempt at writing a program that will solve a standard 3x3x3 Rubiks Cube.

My first attempt uses an IDA* algorithm to try to solve the cube.
My simple heuristic is merely finding the percentage of tiles (note: not cubies) that are unsolved. 
It works reasonably well (a solution within 30 seconds) if you're about 4 moves from a solved cube. More than that and
the program will run for a long time. I grew impatient and stopped the program after 3 minutes. After looking at various other programmers' 
reports, it can take hours to days for a program to run to completion.

Please note: I'm working with a cube that has white, green, yellow, blue, red, and orange sides. Not all cubes have the same colors nor necessarily the same side-side relation.
