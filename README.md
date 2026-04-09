# Cycling Data Analysis Project

## Overview
This project analyzes a dataset of GPS cycling track points collected over multiple days. Each record contains information such as timestamp, speed, power output, distance, and location. The goal of this project was to apply advanced computing concepts, specifically sorting and searching algorithms, to extract meaningful insights from the data.

---

## Problem Formulation

### Problem 1: Sorting (Power Output)
How can we rank all GPS track points to find the top 10 highest power output moments?

Power (watts) is one of the most important performance metrics in cycling. By sorting all track points based on power, we can identify the rider’s peak efforts during the week.

---

### Problem 2: Searching (Speed Threshold)
Given a target speed (8 m/s), how can we efficiently find all timestamps where the cyclist exceeded this speed?

Speed is another key metric, and this problem helps identify high-intensity riding segments. By organizing the data and applying a searching algorithm, we can efficiently locate these moments.

---

## Algorithms Used

### Merge Sort
Merge Sort was implemented from scratch to sort the dataset by power output and speed.

- Time Complexity: **O(n log n)**
- Space Complexity: **O(n)**

Merge Sort was chosen because it is efficient for large datasets and guarantees consistent performance.

---

### Binary Search
Binary Search was used after sorting the dataset by speed to quickly find the first instance where the speed exceeds the target value.

- Time Complexity: **O(log n)**

This allows for efficient searching compared to scanning the entire dataset.

---

## Results

- The dataset contained a large number of track points across multiple days.
- The highest power outputs were found to be approximately **200–265 watts**, representing peak performance moments.
- The cyclist exceeded **8 m/s (~18 mph)** multiple times, indicating high-speed segments throughout the ride.
- These results demonstrate how sorting and searching algorithms can be used to extract meaningful insights from raw data.

---

## How to Run

1. Place the following files in the same folder:
   - `CyclingAnalysis.java`
   - `day1.json`
   - `day2.json`
   - `day3.json`
   - `day4.json`

2. Open the folder in VS Code or terminal

3. Compile and run:
   ```bash
   javac CyclingAnalysis.java
   java CyclingAnalysis
