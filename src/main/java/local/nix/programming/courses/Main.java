package local.nix.programming.courses;

import local.nix.programming.courses.repository.StudentRepository;
import local.nix.programming.courses.repository.TeacherRepository;


public class Main {

    public static void main(String[] args) {


        StudentRepository.getInformationAboutNearestLesson(3l);
        TeacherRepository.getInformationAboutTheMostSuccessfulGroup(1l);


    }
}
