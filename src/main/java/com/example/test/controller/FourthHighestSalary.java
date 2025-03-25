package com.example.test.controller;

import com.example.test.Entity.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FourthHighestSalary {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "aaa", 90000);
        Employee e2 = new Employee(2, "bbb", 70000);
        Employee e3 = new Employee(3, "ccc", 8000);
        Employee e4 = new Employee(4, "ddd", 60000);
        Employee e5 = new Employee(5, "eee", 100000);

        List<Employee> list = new ArrayList();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);

        double result = list.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(3)
                .findFirst()
                .orElse(null);
        System.out.println(result);
    }
}
