{\rtf1\ansi\ansicpg1252\cocoartf2822
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 # Cycling Data Analysis Project\
\
## Overview\
This project analyzes a dataset of GPS cycling track points collected over multiple days. Each record contains information such as timestamp, speed, power output, distance, and location. The goal of this project was to apply advanced computing concepts, specifically sorting and searching algorithms, to extract meaningful insights from the data.\
\
---\
\
## Problem Formulation\
\
### Problem 1: Sorting (Power Output)\
How can we rank all GPS track points to find the top 10 highest power output moments?\
\
Power (watts) is one of the most important performance metrics in cycling. By sorting all track points based on power, we can identify the rider\'92s peak efforts during the week.\
\
---\
\
### Problem 2: Searching (Speed Threshold)\
Given a target speed (8 m/s), how can we efficiently find all timestamps where the cyclist exceeded this speed?\
\
Speed is another key metric, and this problem helps identify high-intensity riding segments. By organizing the data and applying a searching algorithm, we can efficiently locate these moments.\
\
---\
\
## Algorithms Used\
\
### Merge Sort\
Merge Sort was implemented from scratch to sort the dataset by power output and speed.\
\
- Time Complexity: **O(n log n)**\
- Space Complexity: **O(n)**\
\
Merge Sort was chosen because it is efficient for large datasets and guarantees consistent performance.\
\
---\
\
### Binary Search\
Binary Search was used after sorting the dataset by speed to quickly find the first instance where the speed exceeds the target value.\
\
- Time Complexity: **O(log n)**\
\
This allows for efficient searching compared to scanning the entire dataset.\
\
---\
\
## Results\
\
- The dataset contained a large number of track points across multiple days.\
- The highest power outputs were found to be approximately **200\'96265 watts**, representing peak performance moments.\
- The cyclist exceeded **8 m/s (~18 mph)** multiple times, indicating high-speed segments throughout the ride.\
- These results demonstrate how sorting and searching algorithms can be used to extract meaningful insights from raw data.\
\
---\
\
## How to Run\
\
1. Place the following files in the same folder:\
   - `CyclingAnalysis.java`\
   - `day1.json`\
   - `day2.json`\
   - `day3.json`\
   - `day4.json`\
\
2. Open the folder in VS Code or terminal\
\
3. Compile and run:\
   ```bash\
   javac CyclingAnalysis.java\
   java CyclingAnalysis}