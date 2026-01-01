# Day 1: Circular Track Position Counter

## Problem Description

Track position on a circular track and count specific position visits.

### Part 1: End Position Zero Count
**Problem**: Track position on a circular track and count visits to position 0 at rotation end

- **Starting Position**: 50
- **Track Size**: 100 positions (0-99), wrapping around
- **Instructions**: `R` (right) and `L` (left) followed by distance
- **Goal**: Count how many times position 0 is reached at the end of rotations

### Part 2: All Zero Crossings Count  
**Problem**: Count every time the dial points at 0 during any part of rotations

- **Enhanced Counting**: Counts 0 crossings during rotation movement, not just end positions
- **Method 0x434C49434B**: Security protocol requiring all zero crossings to be counted
- **Step-by-Step Tracking**: Simulates each step of rotation to detect all 0 crossings
- **Goal**: Count total number of times dial points at 0 during entire process

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

The programs process movement instructions from `input.txt` and output the respective counts based on their criteria.