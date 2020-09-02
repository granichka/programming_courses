package local.nix.programming.courses.entity;

import local.nix.programming.courses.entity.abstr.AbstractEntity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "courses")
public class Course extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Group> groups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
