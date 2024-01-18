package ru.fsv67;

import lombok.Data;

@Data
public class Student {
    private static long idCounter = 1L;
    private final long id;
    private final String studentName;
    private final String groupName;

    public Student(String studentName, String groupName) {
        this.id = idCounter++;
        this.studentName = studentName;
        this.groupName = groupName;
    }
}
