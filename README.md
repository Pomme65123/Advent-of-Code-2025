# Advent of Code 2025 Solutions

This repository contains my solutions for [Advent of Code 2025](https://adventofcode.com/2025), a series of programming puzzles released daily in December.

## Structure

Each day's solution is organized in its own folder:

```
Advent of Coding/
├── Day 1/
│   ├── Main.java
│   └── input.txt
├── Day 2 Part 1/
│   ├── Main.java
│   └── input.txt
├── Day 2 Part 2/
│   ├── Main.java
│   └── input.txt
├── Day 3/
│   ├── Main.java
│   └── input.txt
└── README.md (this file)
```

## Solutions

### Day 1: Circular Track Position Counter

**Problem**: Track position on a circular track and count visits to position 0

- **Starting Position**: 50
- **Track Size**: 100 positions (0-99), wrapping around
- **Instructions**: `R` (right) and `L` (left) followed by distance
- **Goal**: Count how many times position 0 is reached

#### Quick Start (Day 1)
```bash
cd "Day 1"
javac Main.java
java Main
```

The program processes movement instructions from `input.txt`, updates position with wraparound logic, and displays each move before outputting the final zero count.

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

**Problem**: Find maximum joltage from battery banks by selecting optimal battery pairs

- **Battery Banks**: Each line represents a bank of batteries with joltage ratings 1-9
- **Selection Rule**: Turn on exactly two batteries per bank (cannot rearrange)
- **Joltage Calculation**: Two-digit number formed by selected batteries in order
- **Goal**: Find maximum possible joltage from each bank and sum them

#### Quick Start (Day 3)
```bash
cd "Day 3"
javac Main.java
java Main
```

The program reads battery bank data from `input.txt`, tries all possible pairs of batteries in each bank while maintaining their order, finds the maximum 2-digit joltage for each bank, and outputs the total joltage sum.

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
