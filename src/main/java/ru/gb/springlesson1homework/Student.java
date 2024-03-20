package ru.gb.springlesson1homework;

import lombok.Data;

@Data
public class Student {
    private static long curId = 0;
    private final long id;
    private final String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.id = curId++;
        this.name = name;
        this.groupName = groupName;
    }
}
