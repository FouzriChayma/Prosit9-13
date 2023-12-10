package levels;

import models.Teacher;
import models.Subject;

import utils.Data;
import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        // TO DO 1: Retourner une chaîne de caractères qui contient tous les noms des enseignants en majuscule séparés par #
        String names = teachers.stream()
                .map(Teacher::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining("#"));
        System.out.println("Concatenated names in uppercase: " + names);

        // TO DO 2: Retourner un set d'enseignants Java dont le salaire > 80000
        Set<Teacher> javaTeachersWithHighSalary = teachers.stream()
                .filter(t -> t.getSubject() == Subject.JAVA && t.getSalary() > 80000)
                .collect(Collectors.toSet());
        System.out.println("Java teachers with salary > 80000: " + javaTeachersWithHighSalary);

        // TO DO 3: Retourner un TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire)
        TreeSet<Teacher> teachersSortedByNameAndSalary = teachers.stream()
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator
                                .comparing(Teacher::getName)
                                .thenComparingInt(Teacher::getSalary))));
        System.out.println("Teachers TreeSet sorted by name and salary: " + teachersSortedByNameAndSalary);

        // TO DO 4: Retourner une Map qui regroupe les enseignants par module
        Map<Subject, List<Teacher>> teachersGroupedBySubject = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSubject));
        System.out.println("Teachers grouped by subject: " + teachersGroupedBySubject);

        // TO DO 5: Retourner une Map qui regroupe les noms des enseignants par salaire
        Map<Integer, String> namesGroupedBySalary = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSalary,
                        Collectors.mapping(Teacher::getName, Collectors.joining(", "))));
        System.out.println("Names grouped by salary: " + namesGroupedBySalary);
    }
}
