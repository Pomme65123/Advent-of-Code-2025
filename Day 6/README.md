# Day 6: Vertical Math Expression Evaluator

## Problem Description

Evaluate mathematical expressions written vertically with numbers read from columns.

### Part 1: Single Column Math
**Problem**: Evaluate mathematical expressions written vertically with numbers read from top to bottom

- **Input Format**: Grid of characters where numbers are written vertically in columns
- **Number Reading**: Each column forms a number by reading digits from top to bottom
- **Operator**: Located in the last row (`+` for addition, `*` for multiplication)
- **Processing Direction**: Read columns from right to left for evaluation
- **Goal**: Calculate the result of the vertical mathematical expression

### Part 2: Multiple Expression Solver
**Problem**: Process multiple vertical math expressions separated by blank columns

- **Multi-Expression Format**: Input contains multiple expressions separated by columns of spaces
- **Problem Segmentation**: Identify individual expressions by finding space-column boundaries
- **Individual Processing**: Each expression is solved using the same vertical math logic as Part 1
- **Accumulation**: Sum the results from all expressions in the input
- **Goal**: Calculate the total sum of all vertical mathematical expressions

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

Both programs read character grids from `input.txt`, identify vertical number patterns and operators, process the mathematical expressions according to their respective rules, and output the calculated results.