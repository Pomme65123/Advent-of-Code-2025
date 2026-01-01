# Day 4: Paper Roll Accessibility Counter

## Problem Description

Count accessible paper rolls in a storage grid based on adjacency rules.

### Part 1: Static Accessibility Count
**Problem**: Count accessible paper rolls in a storage grid

- **Grid Format**: Each cell contains either a paper roll (`@`) or empty space
- **Accessibility Rule**: A paper roll is accessible if it has fewer than 4 adjacent rolls (including diagonals)
- **Adjacent Check**: Examines all 8 surrounding positions (top-left, top, top-right, left, right, bottom-left, bottom, bottom-right)
- **Goal**: Count the total number of accessible paper rolls in the grid

### Part 2: Cascading Paper Roll Removal
**Problem**: Simulate removing accessible paper rolls until no more can be removed

- **Cascading Effect**: Once accessible rolls are removed, previously inaccessible rolls may become accessible
- **Removal Process**: Keep finding and removing all accessible rolls in each iteration
- **Termination**: Stop when no more rolls can be accessed by forklifts
- **Goal**: Count the total number of paper rolls that can be removed through this cascading process

## Usage

### Part 1
```bash
javac mainPartOne.java
java mainPartOne
```

### Part 2
```bash
javac mainPartTwo.java
java mainPartTwo
```

The programs read storage grids from `input.txt`, apply adjacency rules, and output the respective counts based on their removal criteria.