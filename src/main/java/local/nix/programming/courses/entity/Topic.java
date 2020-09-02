package local.nix.programming.courses.entity;

import local.nix.programming.courses.entity.abstr.AbstractEntity;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="topics")
public class Topic extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "topic",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Lesson> lessons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
