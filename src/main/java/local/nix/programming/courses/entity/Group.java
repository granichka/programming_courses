package local.nix.programming.courses.entity;

import local.nix.programming.courses.entity.abstr.AbstractEntity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "groups")
public class Group extends AbstractEntity {

    @ManyToOne
    @JoinColumn(nullable = false, name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;


    @ManyToOne
    @JoinColumn(nullable = false, name = "teacher_id")
    private Teacher teacher;


    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }
}
