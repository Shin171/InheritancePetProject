package com.mycompany.handsonactivity;

import java.util.Scanner;

class Person {
    private String name;
    private String contactNum;

    public Person(String name, String contactNum) {
        this.name = name;
        this.contactNum = contactNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getName() {
        return name;
    }

    public String getContactNum() {
        return contactNum;
    }
}

class Employee extends Person {
    private double salary;
    private String department;

    public Employee(String name, String contactNum, double salary, String department) {
        super(name, contactNum);
        this.salary = salary;
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}

class Student extends Person {
    private String program;
    private int yearLevel;

    public Student(String name, String contactNum, String program, int yearLevel) {
        super(name, contactNum);
        this.program = program;
        this.yearLevel = yearLevel;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getProgram() {
        return program;
    }

    public int getYearLevel() {
        return yearLevel;
    }
}

class Faculty extends Person {
    private boolean isRegular;

    public Faculty(String name, String contactNum, boolean isRegular) {
        super(name, contactNum);
        this.isRegular = isRegular;
    }

    public void setIsRegular(boolean isRegular) {
        this.isRegular = isRegular;
    }

    public boolean isRegular() {
        return isRegular;
    }
}

public class CollegeList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Press E for Employee, F for Faculty, or S for Student:");
        char personType = sc.next().charAt(0);
        sc.nextLine();

        String role;
        switch (personType) {
            case 'E', 'e' -> role = "Employee's";
            case 'F', 'f' -> role = "Faculty member's";
            case 'S', 's' -> role = "Student's";
            default -> {
                System.out.println("Invalid input. Please select E, F, or S.");
                sc.close();
                return; 
            }
        }

        System.out.println("Type " + role + " name and contact number:");
         System.out.println("Press Enter after every input.");
        String name = sc.nextLine();
        String contactNum = sc.nextLine();

        switch (personType) {
            case 'E', 'e' -> {
                System.out.println("Type employee's salary and department(Ex. Registrar):");
                double salary = sc.nextDouble();
                sc.nextLine();
                String department = sc.nextLine();

                Employee employee = new Employee(name, contactNum, salary, department);

                System.out.println("-----------------------------");
                System.out.println("Name: " + employee.getName());
                System.out.println("Contact Number: " + employee.getContactNum());
                System.out.println("Salary: " + employee.getSalary());
                System.out.println("Department: " + employee.getDepartment());
            }
            case 'F', 'f' -> {
                System.out.println("Is the faculty member regular? (Y/N)");
                char isRegularInput = sc.next().charAt(0);
                boolean isRegular = (isRegularInput == 'Y' || isRegularInput == 'y');

                Faculty faculty = new Faculty(name, contactNum, isRegular);

                System.out.println("-----------------------------");
                System.out.println("Name: " + faculty.getName());
                System.out.println("Contact Number: " + faculty.getContactNum());
                System.out.println("Status: " + (faculty.isRegular() ? "Regular" : "Not Regular"));
            }
            case 'S', 's' -> {
                System.out.println("Type student's enrolled program(Ex. BSIT, BSTM) and year level:");
                String program = sc.nextLine();
                int yearLevel = sc.nextInt();

                Student student = new Student(name, contactNum, program, yearLevel);

                System.out.println("-----------------------------");
                System.out.println("Name: " + student.getName());
                System.out.println("Contact Number: " + student.getContactNum());
                System.out.println("Program: " + student.getProgram());
                System.out.println("Year Level: " + student.getYearLevel());
            }
        }

        sc.close();
    }
}
