package ru.gb.springlesson1homework;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("newBeanName")
@Scope(ConfigurableListableBeanFactory.SCOPE_SINGLETON)
@Primary
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();
        students.add(new Student("Joe", "math"));
        students.add(new Student("Donald", "language"));
        students.add(new Student("Jason", "physics"));
        students.add(new Student("Peter", "biology"));
        students.add(new Student("George", "biology"));
        students.add(new Student("Arnold", "math"));
    }

    public Student getById(long id) {
        return students.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public Student getByName(String name) {
        return students.stream().filter(e -> e.getName().contains(name)).findFirst().orElse(null);
    }

    public List<Student> getByGroupName(String groupName) {
        return students.stream()
                .filter(e -> e.getGroupName().equals(groupName))
                .toList();
    }
}
