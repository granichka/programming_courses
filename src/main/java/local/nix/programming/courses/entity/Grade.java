package local.nix.programming.courses.entity;

import local.nix.programming.courses.entity.embeddable.LessonStudentId;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {

    @EmbeddedId
    private LessonStudentId lessonStudentId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "lesson_id", insertable = false, updatable = false)
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(nullable = false, name = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column
    private Double value;

    public LessonStudentId getLessonStudentId() {
        return lessonStudentId;
    }

    public void setLessonStudentId(LessonStudentId lessonStudentId) {
        this.lessonStudentId = lessonStudentId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
