// https://www.hackerrank.com/challenges/java-priority-queue/problem
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private int id;
    private String name;
    private double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    private PriorityQueue<Student> queue;
    
    public Priorities() {
        queue = new PriorityQueue<Student>(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if (s1.getCGPA() < s2.getCGPA()) {
                    return 1;
                }
                else if (s1.getCGPA() > s2.getCGPA()) {
                    return -1;
                }
                else if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName());
                }
                else if (s1.getID() < s1.getID()) {
                    return 1;
                }
                else if (s1.getID() > s2.getID()) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
    }
    
    public List<Student> getStudents(List<String> events) {
        for (int i = 0; i < events.size(); i++) {
            String[] details = events.get(i).split(" ");
            if (details[0].equals("ENTER")) {
                String name = details[1];
                double cgpa = Double.parseDouble(details[2]);
                int id = Integer.parseInt(details[3]);
                queue.add(new Student(id, name, cgpa));
            }
            else {
                queue.poll();
            }
        }
        
        List<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }
        
        return students;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
