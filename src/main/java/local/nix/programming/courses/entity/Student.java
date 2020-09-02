package local.nix.programming.courses.entity;

import local.nix.programming.courses.entity.abstr.AbstractEntity;
import local.nix.programming.courses.entity.embeddable.PersonalDetails;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends AbstractEntity {

    @Embedded
    private PersonalDetails personalDetails;

    @ManyToOne
    @JoinColumn(nullable = false, name = "group_id")
    private Group group;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Grade> grades;


    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
