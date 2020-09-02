package local.nix.programming.courses.entity.embeddable;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LessonStudentId implements Serializable {

    private Long lesson_id;

    private Long student_id;


    public Long getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Long lesson_id) {
        this.lesson_id = lesson_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonStudentId that = (LessonStudentId) o;
        return Objects.equals(lesson_id, that.lesson_id) &&
                Objects.equals(student_id, that.student_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lesson_id, student_id);
    }
}
