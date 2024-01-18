package ru.fsv67;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>();

    {
        students.add(new Student("Alex", "Tester"));
        students.add(new Student("Semen", "Tester"));
        students.add(new Student("Andrey", "Programmer"));
        students.add(new Student("Mihail", "Web Designer"));
        students.add(new Student("Aleksandra", "Web Designer"));
        students.add(new Student("Veronika", "Programmer"));
        students.add(new Student("Petr", "IT"));
        students.add(new Student("Sergey", "IT"));
        students.add(new Student("Valentin", "Team leader"));
        students.add(new Student("Igor", "IT"));
    }

    //GET /student/{id}
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable long id) {
        List<Student> newListStudent = List.copyOf(students);
        return newListStudent.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    //GET /student
    @GetMapping("/student")
    public List<Student> getAllStudents() {
        List<Student> newListStudent = List.copyOf(students);
        return newListStudent;
    }

    //GET /student/search?name='studentName'
    @GetMapping("/student/search")
    public Student getStudentByName(@RequestParam String studentName) {
        List<Student> newListStudent = List.copyOf(students);
        return newListStudent.stream()
                .filter(it -> Objects.equals(it.getStudentName(), studentName))
                .findFirst()
                .orElse(null);
    }

    //GET /group/{groupName}/student
    @GetMapping("/group/{groupName}/student")
    public List<Student> getStudentByNameGroup(@PathVariable String groupName) {
        List<Student> newListStudent = List.copyOf(students);
        return newListStudent.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName)).toList();
    }

    //POST /student
    @PostMapping("/student")
    public Student setStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    //DELETE /student/{id}
    @DeleteMapping("/student/{id}")
    public Student deleteStudentById(@PathVariable long id) {
        return students.remove(
                students.indexOf(
                        students.stream()
                                .filter(it -> Objects.equals(it.getId(), id))
                                .findFirst()
                                .orElse(null)
                )
        );
    }
}
