# Advent of Code 2025 Solutions

This repository contains my solutions for [Advent of Code 2025](https://adventofcode.com/2025), a series of programming puzzles released daily in December.

## Structure

Each day's solution is organized in its own folder:

```
Advent of Coding/
├── Day 1 Part 1/
│   ├── Main.java
│   └── input.txt
├── Day 1 Part 2/
│   ├── Main.java
│   └── input.txt
├── Day 2 Part 1/
│   ├── Main.java
│   └── input.txt
├── Day 2 Part 2/
│   ├── Main.java
│   └── input.txt
├── Day 3 Part 1/
│   ├── Main.java
│   └── input.txt
├── Day 3 Part 2/
│   ├── Main.java
│   └── input.txt
├── Day 4 Part 1/
│   ├── Main.java
│   └── input.txt
├── Day 4 Part 2/
│   ├── Main.java
│   └── input.txt
├── Day 5 Part 1/
│   ├── Main.java
│   └── input.txt
├── Day 5 Part 2/
│   ├── Main.java
│   └── input.txt
├── Day 6 Part 1/
│   ├── Main.java
│   └── input.txt
├── Day 6 Part 2/
│   ├── Main.java
│   └── input.txt
└── README.md (this file)
```

## Solutions

### Day 1: Circular Track Position Counter

#### Part 1: End Position Zero Count
**Problem**: Track position on a circular track and count visits to position 0 at rotation end

- **Starting Position**: 50
- **Track Size**: 100 positions (0-99), wrapping around
- **Instructions**: `R` (right) and `L` (left) followed by distance
- **Goal**: Count how many times position 0 is reached at the end of rotations

#### Quick Start (Day 1 Part 1)
```bash
cd "Day 1 Part 1"
javac Main.java
java Main
```

The program processes movement instructions from `input.txt`, updates position with wraparound logic, and counts only when rotations end at position 0.

#### Part 2: All Zero Crossings Count  
**Problem**: Count every time the dial points at 0 during any part of rotations

- **Enhanced Counting**: Counts 0 crossings during rotation movement, not just end positions
- **Method 0x434C49434B**: Security protocol requiring all zero crossings to be counted
- **Step-by-Step Tracking**: Simulates each step of rotation to detect all 0 crossings
- **Goal**: Count total number of times dial points at 0 during entire process

#### Quick Start (Day 1 Part 2)
```bash
cd "Day 1 Part 2"
javac Main.java
java Main
```

The program simulates each rotation step-by-step, counting every time the dial crosses or lands on position 0 during the movement, providing the total count for the enhanced security protocol.

### Day 2: Invalid ID Validator

#### Part 1: Split Half Pattern
**Problem**: Find and sum invalid IDs where first half equals second half

- **Invalid ID Definition**: Numbers with even digit count where first half equals second half
- **Input Format**: Comma-separated ranges (e.g., "1233-1772,2-15")
- **Goal**: Sum all invalid IDs across all ranges

#### Quick Start (Day 2 Part 1)
```bash
cd "Day 2 Part 1"
javac Main.java
java Main
```

#### Part 2: Repeated Pattern
**Problem**: Find and sum invalid IDs made of repeated digit sequences

- **Invalid ID Definition**: Numbers consisting of some sequence repeated at least twice (e.g., 123123, 1212, 99)
- **Input Format**: Same comma-separated ranges as Part 1
- **Goal**: Sum all invalid IDs using the new repeated pattern criteria

#### Quick Start (Day 2 Part 2)
```bash
cd "Day 2 Part 2"
javac Main.java
java Main
```

Both programs process range data from `input.txt` and output the sum of all invalid IDs found using their respective validation criteria.

### Day 3: Battery Joltage Calculator

#### Part 1: Two-Battery Selection
**Problem**: Find maximum joltage from battery banks by selecting optimal battery pairs

- **Battery Banks**: Each line represents a bank of batteries with joltage ratings 1-9
- **Selection Rule**: Turn on exactly two batteries per bank (cannot rearrange)
- **Joltage Calculation**: Two-digit number formed by selected batteries in order
- **Goal**: Find maximum possible joltage from each bank and sum them

#### Quick Start (Day 3 Part 1)
```bash
cd "Day 3 Part 1"
javac Main.java
java Main
```

The program reads battery bank data from `input.txt`, tries all possible pairs of batteries in each bank while maintaining their order, finds the maximum 2-digit joltage for each bank, and outputs the total joltage sum.

#### Part 2: Twelve-Battery Selection
**Problem**: Find maximum joltage by selecting exactly twelve batteries per bank

- **Battery Banks**: Same format as Part 1, but banks are much longer
- **Selection Rule**: Turn on exactly twelve batteries per bank (cannot rearrange)
- **Joltage Calculation**: Twelve-digit number formed by selected batteries in order
- **Algorithm**: Uses greedy approach to find lexicographically largest subsequence of length 12
- **Goal**: Find maximum possible 12-digit joltage from each bank and sum them

#### Quick Start (Day 3 Part 2)
```bash
cd "Day 3 Part 2"
javac Main.java
java Main
```

The program reads extended battery bank data from `input.txt`, uses a greedy subsequence selection algorithm to find the maximum 12-digit number from each bank while maintaining battery order, and outputs the total joltage sum.

### Day 4: Paper Roll Accessibility Counter

#### Part 1: Static Accessibility Count
**Problem**: Count accessible paper rolls in a storage grid

- **Grid Format**: Each cell contains either a paper roll (`@`) or empty space
- **Accessibility Rule**: A paper roll is accessible if it has fewer than 4 adjacent rolls (including diagonals)
- **Adjacent Check**: Examines all 8 surrounding positions (top-left, top, top-right, left, right, bottom-left, bottom, bottom-right)
- **Goal**: Count the total number of accessible paper rolls in the grid

#### Quick Start (Day 4 Part 1)
```bash
cd "Day 4 Part 1"
javac Main.java
java Main
```

The program reads the storage grid from `input.txt`, checks each paper roll's surroundings using 8-directional adjacency, counts those with fewer than 4 adjacent rolls, and outputs the total count of accessible rolls.

#### Part 2: Cascading Paper Roll Removal
**Problem**: Simulate removing accessible paper rolls until no more can be removed

- **Cascading Effect**: Once accessible rolls are removed, previously inaccessible rolls may become accessible
- **Removal Process**: Keep finding and removing all accessible rolls in each iteration
- **Termination**: Stop when no more rolls can be accessed by forklifts
- **Goal**: Count the total number of paper rolls that can be removed through this cascading process

#### Quick Start (Day 4 Part 2)
```bash
cd "Day 4 Part 2"
javac Main.java
java Main
```

The program simulates the iterative removal process: finds all currently accessible rolls, removes them from the grid, then repeats until no more rolls are accessible, finally outputting the total count of removed rolls.

### Day 5: Fresh Ingredient Detector

#### Part 1: Range-Based Freshness Check
**Problem**: Determine which ingredient IDs are fresh based on ID ranges

- **Input Format**: Fresh ingredient ID ranges (inclusive), blank line separator, then available ingredient IDs
- **Range Format**: Each range is "start-end" (e.g., "3-5" includes IDs 3, 4, and 5)
- **Overlap Handling**: Ranges can overlap; an ingredient is fresh if it falls within ANY range
- **Goal**: Count how many of the available ingredient IDs are fresh

#### Quick Start (Day 5 Part 1)
```bash
cd "Day 5 Part 1"
javac Main.java
java Main
```

The program parses the database file to extract fresh ID ranges and available ingredient IDs, then checks each available ID against all ranges to determine freshness, finally outputting the total count of fresh ingredients.

#### Part 2: Total Fresh Range Count
**Problem**: Count all ingredient IDs that fall within any fresh range (ignore available IDs section)

- **Range Overlap**: Multiple ranges can overlap; ingredient IDs should not be double-counted
- **Approach**: Merge overlapping ranges, then calculate total IDs in merged ranges
- **Efficiency**: Uses range merging algorithm instead of iterating through billions of individual IDs
- **Goal**: Count total number of ingredient IDs considered fresh by the ranges

#### Quick Start (Day 5 Part 2)
```bash
cd "Day 5 Part 2"
javac Main.java
java Main
```

The program reads only the fresh ingredient ranges (ignores available IDs), sorts and merges overlapping ranges to avoid double-counting, then calculates the total count of ingredient IDs covered by the merged ranges.

### Day 6: Vertical Math Expression Evaluator

#### Part 1: Single Column Math
**Problem**: Evaluate mathematical expressions written vertically with numbers read from top to bottom

- **Input Format**: Grid of characters where numbers are written vertically in columns
- **Number Reading**: Each column forms a number by reading digits from top to bottom
- **Operator**: Located in the last row (`+` for addition, `*` for multiplication)
- **Processing Direction**: Read columns from right to left for evaluation
- **Goal**: Calculate the result of the vertical mathematical expression

#### Quick Start (Day 6 Part 1)
```bash
cd "Day 6 Part 1"
javac Main.java
java Main
```

#### Part 2: Multiple Expression Solver
**Problem**: Process multiple vertical math expressions separated by blank columns

- **Multi-Expression Format**: Input contains multiple expressions separated by columns of spaces
- **Problem Segmentation**: Identify individual expressions by finding space-column boundaries
- **Individual Processing**: Each expression is solved using the same vertical math logic as Part 1
- **Accumulation**: Sum the results from all expressions in the input
- **Goal**: Calculate the total sum of all vertical mathematical expressions

#### Quick Start (Day 6 Part 2)
```bash
cd "Day 6 Part 2"
javac Main.java
java Main
```

Both programs read character grids from `input.txt`, identify vertical number patterns and operators, process the mathematical expressions according to their respective rules, and output the calculated results.


## General Setup

### Input File Requirements
**Important**: Each solution expects its input data to be named `input.txt` and placed in the respective day's folder. Make sure to:
1. Download your personal input from [Advent of Code](https://adventofcode.com/2025)
2. Save it as `input.txt` in the corresponding day folder
3. Input files are personal to each participant and are excluded from version control

### Running Solutions
1. Navigate to the specific day's folder
2. Ensure your puzzle input is saved as `input.txt`
3. Compile the source file (e.g., `javac Main.java`)
4. Run the compiled program (e.g., `java Main`)

*Advent of Code is an annual event created by [Eric Wastl](https://twitter.com/ericwastl)*
