# Day 5: Fresh Ingredient Detector

## Problem Description

Determine ingredient freshness based on ID ranges and availability.

### Part 1: Range-Based Freshness Check
**Problem**: Determine which ingredient IDs are fresh based on ID ranges

- **Input Format**: Fresh ingredient ID ranges (inclusive), blank line separator, then available ingredient IDs
- **Range Format**: Each range is "start-end" (e.g., "3-5" includes IDs 3, 4, and 5)
- **Overlap Handling**: Ranges can overlap; an ingredient is fresh if it falls within ANY range
- **Goal**: Count how many of the available ingredient IDs are fresh

### Part 2: Total Fresh Range Count
**Problem**: Count all ingredient IDs that fall within any fresh range (ignore available IDs section)

- **Range Overlap**: Multiple ranges can overlap; ingredient IDs should not be double-counted
- **Approach**: Merge overlapping ranges, then calculate total IDs in merged ranges
- **Efficiency**: Uses range merging algorithm instead of iterating through billions of individual IDs
- **Goal**: Count total number of ingredient IDs considered fresh by the ranges

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

The programs parse the database file to handle fresh ingredient ranges and determine freshness counts using their respective approaches.