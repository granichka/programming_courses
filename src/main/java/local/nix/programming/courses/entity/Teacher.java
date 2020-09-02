package local.nix.programming.courses.entity;

import local.nix.programming.courses.entity.abstr.AbstractEntity;
import local.nix.programming.courses.entity.embeddable.PersonalDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "teachers")
public class Teacher extends AbstractEntity {

    @Embedded
    private PersonalDetails personalDetails;

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Group> groups;

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
