# Day 2: Invalid ID Validator

## Problem Description

Find and sum invalid IDs based on specific patterns.

### Part 1: Split Half Pattern
**Problem**: Find and sum invalid IDs where first half equals second half

- **Invalid ID Definition**: Numbers with even digit count where first half equals second half
- **Input Format**: Comma-separated ranges (e.g., "1233-1772,2-15")
- **Goal**: Sum all invalid IDs across all ranges

### Part 2: Repeated Pattern
**Problem**: Find and sum invalid IDs made of repeated digit sequences

- **Invalid ID Definition**: Numbers consisting of some sequence repeated at least twice (e.g., 123123, 1212, 99)
- **Input Format**: Same comma-separated ranges as Part 1
- **Goal**: Sum all invalid IDs using the new repeated pattern criteria

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

Both programs process range data from `input.txt` and output the sum of all invalid IDs found using their respective validation criteria.