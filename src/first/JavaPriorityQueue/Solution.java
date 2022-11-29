package first.JavaPriorityQueue;

import java.util.*;

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCGPA() {
        return cgpa;
    }

}

class Priorities {
    private static final Comparator<Student> STUDENTS_COMPARATOR = (s1, s2) -> {
        int result = Double.compare(s2.getCGPA(), s1.getCGPA());
        result = result == 0 ? s1.getName().compareTo(s2.getName()) : result;
        return result == 0 ? Integer.compare(s1.getID(), s2.getID()) : result;
    };

    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(events.size(), STUDENTS_COMPARATOR);

        for (String event : events) {
            String[] chunkOfWords = event.split(" ");

            if ("ENTER".equals(chunkOfWords[0])) {
                priorityQueue.add(new Student(Integer.parseInt(chunkOfWords[3]), chunkOfWords[1], Double.parseDouble(chunkOfWords[2])));
            } else if ("SERVED".equals(chunkOfWords[0])) {
                if (!priorityQueue.isEmpty())
                    priorityQueue.remove();
            }
        }

        List<Student> students = new ArrayList<>();

        while (!priorityQueue.isEmpty())
            students.add(priorityQueue.remove());

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
