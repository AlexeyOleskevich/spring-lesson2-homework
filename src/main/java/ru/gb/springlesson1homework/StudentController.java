package ru.gb.springlesson1homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class StudentController {

    private final StudentRepository repository;

    @Autowired // в данном случае эта аннотация не обязательна. Используется, когда конструкторов несколько.
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("student")
    public List<Student> getAll() {
        return repository.getAll();
    }

    @GetMapping("student/{id}")
    public Student getById(@PathVariable long id) {
        return repository.getById(id);
    }

    @GetMapping("student/search")
    public Student getByName(@RequestParam String name) {
        return repository.getByName(name);
    }

    @GetMapping("/group/{groupName}/student")
    public List<Student> getAllByGroupName(@PathVariable String groupName) {
        return repository.getByGroupName(groupName);
    }


}
