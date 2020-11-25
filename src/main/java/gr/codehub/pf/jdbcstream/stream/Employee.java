package gr.codehub.pf.jdbcstream.stream;

import java.time.LocalDate;

public class Employee {

    private String name;
    private double salary;
    private int age;
    private LocalDate hiringDate;

    public Employee(String name, double salary, int age, LocalDate hiringDate) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.hiringDate = hiringDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", hiringDate=" + hiringDate +
                '}';
    }
}
