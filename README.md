# Grade Management System

A comprehensive Java-based Grade Management System that stores student marks in arrays and calculates averages with grade categories.

## Features

- **Student Management**: Add new students to the system
- **Marks Entry**: Enter marks for multiple subjects per student
- **Grade Calculation**: Automatically calculate averages and assign grades
- **Reporting**: View individual student reports and class statistics
- **Grade Distribution**: Analyze grade distribution across the class
- **Array-based Storage**: Uses arrays for efficient data storage

## Subject Codes

The system manages marks for the following subjects:
- **DAA** - Design and Analysis of Algorithms
- **CC** - Competitive Coding
- **OS** - Operating Systems
- **PBLJ** - Project Based Learning in Java
- **FS** - Full Stack Development

## Grading System

| Grade | Marks Range | Category    |
|-------|-------------|-------------|
| A     | ≥ 25        | Excellent   |
| B     | > 24        | Very Good   |
| C     | > 20        | Good        |
| D     | ≥ 15        | Satisfactory|
| F     | < 15        | Fail        |

## Menu Options

1. **Add Student** - Register new students with name and ID
2. **Enter Marks** - Input marks for all subjects for a specific student
3. **Display All Students** - View complete class report with averages and grades
4. **Display Student Details** - Get detailed report for individual student
5. **Display Class Statistics** - View class average and total student count
6. **Display Grade Distribution** - See how many students got each grade
7. **Exit** - Close the application

## How to Use

1. Compile the Java file:
   ```bash
   javac GradeManagementSystem.java
