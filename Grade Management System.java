import java.util.Scanner;

public class GradeManagementSystem {
    private String[] studentNames;
    private int[] studentIDs;
    private double[][] marks;
    private double[] averages;
    private char[] grades;
    private int studentCount;
    private int subjectCount;
    
    private static final String[] SUBJECTS = {"DAA", "CC", "OS", "PBLJ", "FS"};
    private static final int MAX_STUDENTS = 100;
    private static final int MAX_SUBJECTS = 5;
    
    public GradeManagementSystem() {
        studentNames = new String[MAX_STUDENTS];
        studentIDs = new int[MAX_STUDENTS];
        marks = new double[MAX_STUDENTS][MAX_SUBJECTS];
        averages = new double[MAX_STUDENTS];
        grades = new char[MAX_STUDENTS];
        studentCount = 0;
        subjectCount = SUBJECTS.length;
    }
    
    public void addStudent(String name, int id) {
        if (studentCount < MAX_STUDENTS) {
            studentNames[studentCount] = name;
            studentIDs[studentCount] = id;
            studentCount++;
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Maximum student capacity reached!");
        }
    }
    
    public void enterMarks(int studentIndex, double[] studentMarks) {
        if (studentIndex >= 0 && studentIndex < studentCount) {
            for (int i = 0; i < subjectCount && i < studentMarks.length; i++) {
                marks[studentIndex][i] = studentMarks[i];
            }
            calculateStudentPerformance(studentIndex);
            System.out.println("Marks entered successfully!");
        } else {
            System.out.println("Invalid student index!");
        }
    }
    
    private void calculateStudentPerformance(int studentIndex) {
        double total = 0;
        int validSubjects = 0;
        
        for (int i = 0; i < subjectCount; i++) {
            if (marks[studentIndex][i] > 0) {
                total += marks[studentIndex][i];
                validSubjects++;
            }
        }
        
        if (validSubjects > 0) {
            averages[studentIndex] = total / validSubjects;
            grades[studentIndex] = calculateGrade(averages[studentIndex]);
        } else {
            averages[studentIndex] = 0;
            grades[studentIndex] = 'F';
        }
    }
    
    private char calculateGrade(double average) {
        if (average >= 25) return 'A';
        else if (average > 24) return 'B';
        else if (average > 20) return 'C';
        else if (average >= 15 ) return 'D';
        else return 'F';
    }
    
    private String getGradeCategory(char grade) {
        switch (grade) {
            case 'A': return "Excellent";
            case 'B': return "Very Good";
            case 'C': return "Good";
            case 'D': return "Satisfactory";
            case 'F': return "Fail";
            default: return "Unknown";
        }
    }
    
    public void displayAllStudents() {
        System.out.println("\n=== ALL STUDENTS GRADE REPORT ===");
        System.out.printf("%-5s %-15s %-8s %-10s %-12s%n", 
                         "ID", "Name", "Average", "Grade", "Category");
        System.out.println("------------------------------------------------");
        
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-5d %-15s %-8.2f %-10c %-12s%n",
                            studentIDs[i], studentNames[i], averages[i], 
                            grades[i], getGradeCategory(grades[i]));
        }
    }
    
    public void displayStudentDetails(int studentIndex) {
        if (studentIndex >= 0 && studentIndex < studentCount) {
            System.out.println("\n=== STUDENT DETAILED REPORT ===");
            System.out.println("Student ID: " + studentIDs[studentIndex]);
            System.out.println("Student Name: " + studentNames[studentIndex]);
            System.out.println("\nSubject-wise Marks:");
            System.out.println("-------------------");
            
            for (int i = 0; i < subjectCount; i++) {
                System.out.printf("%-10s: %.2f%n", SUBJECTS[i], marks[studentIndex][i]);
            }
            
            System.out.println("\nOverall Performance:");
            System.out.println("Average: " + String.format("%.2f", averages[studentIndex]));
            System.out.println("Grade: " + grades[studentIndex]);
            System.out.println("Category: " + getGradeCategory(grades[studentIndex]));
        } else {
            System.out.println("Invalid student index!");
        }
    }
    
    public int findStudentByID(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (studentIDs[i] == id) {
                return i;
            }
        }
        return -1;
    }
    
    public double calculateClassAverage() {
        if (studentCount == 0) return 0;
        
        double total = 0;
        for (int i = 0; i < studentCount; i++) {
            total += averages[i];
        }
        return total / studentCount;
    }
    
    public void displayGradeDistribution() {
        int[] gradeCount = new int[5];
        
        for (int i = 0; i < studentCount; i++) {
            switch (grades[i]) {
                case 'A': gradeCount[0]++; break;
                case 'B': gradeCount[1]++; break;
                case 'C': gradeCount[2]++; break;
                case 'D': gradeCount[3]++; break;
                case 'F': gradeCount[4]++; break;
            }
        }
        
        System.out.println("\n=== GRADE DISTRIBUTION ===");
        System.out.println("A (Excellent): " + gradeCount[0] + " students");
        System.out.println("B (Very Good): " + gradeCount[1] + " students");
        System.out.println("C (Good): " + gradeCount[2] + " students");
        System.out.println("D (Satisfactory): " + gradeCount[3] + " students");
        System.out.println("F (Fail): " + gradeCount[4] + " students");
    }
    
    public static void main(String[] args) {
        GradeManagementSystem system = new GradeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n=== GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. Enter Marks");
            System.out.println("3. Display All Students");
            System.out.println("4. Display Student Details");
            System.out.println("5. Display Class Statistics");
            System.out.println("6. Display Grade Distribution");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    system.addStudent(name, id);
                    break;
                    
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    int index = system.findStudentByID(studentID);
                    
                    if (index != -1) {
                        double[] studentMarks = new double[system.subjectCount];
                        System.out.println("Enter marks for " + system.studentNames[index] + ":");
                        for (int i = 0; i < system.subjectCount; i++) {
                            System.out.print(SUBJECTS[i] + ": ");
                            studentMarks[i] = scanner.nextDouble();
                        }
                        system.enterMarks(index, studentMarks);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                    
                case 3:
                    system.displayAllStudents();
                    break;
                    
                case 4:
                    System.out.print("Enter student ID: ");
                    int detailID = scanner.nextInt();
                    int detailIndex = system.findStudentByID(detailID);
                    if (detailIndex != -1) {
                        system.displayStudentDetails(detailIndex);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                    
                case 5:
                    System.out.println("\n=== CLASS STATISTICS ===");
                    System.out.println("Total Students: " + system.studentCount);
                    System.out.printf("Class Average: %.2f%n", system.calculateClassAverage());
                    break;
                    
                case 6:
                    system.displayGradeDistribution();
                    break;
                    
                case 7:
                    System.out.println("Thank you for using Grade Management System!");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
        
        scanner.close();
    }
} 
