// https://www.hackerrank.com/contests/codewhiz-java-march-2016/challenges/serve-the-students

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
	private int token;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getToken() {
		return token;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        TreeSet<Student> set = new TreeSet<Student>(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if (s1.getCgpa() < s2.getCgpa()) {
                    return -1;
                }
                else if (s1.getCgpa() > s2.getCgpa()) {
                    return 1;
                }
                else if (s1.getFname().compareTo(s2.getFname()) == 0) {
                    return ((Integer) s1.getToken()).compareTo((Integer) s2.getToken());
                }
                else {
                    return -1 * s1.getFname().compareTo(s2.getFname());
                }
            }
        });
        while (totalEvents > 0) {
	        String event = in.next();
            //Complete your code
            if (event.equals("ENTER")) {
                String name = in.next();
                double cgpa = in.nextDouble();
                int token = in.nextInt();
                set.add(new Student(token, name, cgpa));
            }
            else if (!set.isEmpty()){
                set.remove(set.last());
            }
	        totalEvents--;
        }
        if (set.isEmpty()) {
            System.out.println("EMPTY");
        }
        while (!set.isEmpty()) {
            System.out.println(set.last().getFname());
            set.remove(set.last());
        }
    }
}