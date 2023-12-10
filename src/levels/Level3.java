package levels;

import models.Teacher;
import utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner une chaîne de caractères qui contient tous les noms des enseignants en majuscule séparés par # */
        String names = teachers.stream().map(Teacher::getName)
                .map(name -> name == null ? "" : name.toUpperCase())
                .collect(Collectors.joining("#"));
        System.out.println("Concatenated names in uppercase: " + names);

        /* TO DO 2: Retourner un set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream().filter(t ->
                        "Java".equalsIgnoreCase(t.getSubject()) && t.getSalary() != null && t.getSalary() > 80000)
                .collect(Collectors.toSet());
        System.out.println("Java teachers with salary > 80000: " + teachers1);

        /* TO DO 3: Retourner un TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> teachers2 = teachers.stream()
                .filter(t -> t.getName() != null && t.getSalary() != null)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator
                        .comparing(Teacher::getName)
                        .thenComparing(Teacher::getSalary))));
        System.out.println("Teachers TreeSet sorted by name and salary: " + teachers2);

        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<String, List<Teacher>> map = teachers.stream()
                .filter(t -> t.getSubject() != null)
                .collect(Collectors.groupingBy(Teacher::getSubject));
        System.out.println("Teachers grouped by subject: " + map);

        /* TO DO 5: Retourner une Map qui regroupe les noms des enseignants par salaire */
        Map<Double, String> map1 = teachers.stream()
                .filter(t -> t.getName() != null && t.getSalary() != null)
                .collect(Collectors.groupingBy(Teacher::getSalary,
                        Collectors.mapping(Teacher::getName, Collectors.joining(", "))));
        System.out.println("Names grouped by salary: " + map1);
    }
}
