# Day 7: Beam Splitting Simulation

## Problem Description

This challenge involves simulating beams falling through a grid with special splitting mechanics.

### Rules:
1. **Starting Point**: Beams begin at position marked with 'S'
2. **Vertical Movement**: Beams fall straight down through empty spaces ('.')
3. **Beam Splitting**: When a beam hits a '^' character, it splits into two beams:
   - One beam goes diagonally left-down (row+1, col-1)
   - One beam goes diagonally right-down (row+1, col+1)
4. **Beam Accumulation**: When multiple beams reach the same position, their counts are summed
5. **Final Answer**: Count all beams that reach the final (bottom) row of the grid

## Algorithm Overview

### Data Structure
- Uses `HashMap<Beam, Long>` to efficiently track beam counts at each position
- `Beam` class represents coordinates (row, col) with proper `equals()` and `hashCode()` implementation

### Process
1. **Initialization**: Place 1 beam at starting position 'S'
2. **Row-by-Row Processing**: Process each row from start to second-to-last row
3. **Beam Movement Logic**:
   - If current cell is '^': Split beam into left and right diagonal beams
   - Otherwise: Beam continues straight down
4. **Boundary Checking**: Ensure beams don't move outside grid boundaries
5. **Accumulation**: Use `HashMap.merge()` to sum beam counts at same positions
6. **Final Calculation**: Sum all beam counts in the final row

## Key Programming Concepts

- **HashMap with Custom Objects**: Using `Beam` objects as keys
- **Exponential Growth Simulation**: Tracking beam multiplication through splits
- **Boundary Validation**: Ensuring array bounds safety
- **Accumulation Pattern**: Summing values at duplicate positions
- **Row-wise Processing**: Systematic grid traversal

## Solution Files

- `mainPartOne.java`: First part of the challenge
- `mainPartTwo.java`: Complete beam splitting simulation

## Answer
The final answer represents the total number of beam paths that successfully reach the bottom row after all splitting operations.