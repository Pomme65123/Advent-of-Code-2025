# Day 3: Battery Joltage Calculator

## Problem Description

Find maximum joltage from battery banks by selecting optimal battery combinations.

### Part 1: Two-Battery Selection
**Problem**: Find maximum joltage from battery banks by selecting optimal battery pairs

- **Battery Banks**: Each line represents a bank of batteries with joltage ratings 1-9
- **Selection Rule**: Turn on exactly two batteries per bank (cannot rearrange)
- **Joltage Calculation**: Two-digit number formed by selected batteries in order
- **Goal**: Find maximum possible joltage from each bank and sum them

### Part 2: Twelve-Battery Selection
**Problem**: Find maximum joltage by selecting exactly twelve batteries per bank

- **Battery Banks**: Same format as Part 1, but banks are much longer
- **Selection Rule**: Turn on exactly twelve batteries per bank (cannot rearrange)
- **Joltage Calculation**: Twelve-digit number formed by selected batteries in order
- **Algorithm**: Uses greedy approach to find lexicographically largest subsequence of length 12
- **Goal**: Find maximum possible 12-digit joltage from each bank and sum them

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

The programs read battery bank data from `input.txt`, find optimal battery selections while maintaining order, and output the total joltage sums.