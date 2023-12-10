package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        // TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s
        long nbr = teachers.stream().filter(t -> t.getName().startsWith("s")).count();
        System.out.println("Number of teachers whose name starts with 's': " + nbr);

        // TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter
        long sum = teachers.stream().filter(t -> t.getSubject() == Subject.FLUTTER)
                .mapToLong(Teacher::getSalary).sum();
        System.out.println("Sum of salaries of Flutter teachers: " + sum);

        // TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a
        double average = teachers.stream().filter(t -> t.getName().startsWith("a"))
                .mapToDouble(Teacher::getSalary).average().orElse(Double.NaN);
        System.out.println("Average salary of teachers whose name starts with 'a': " + average);

        // TO DO 4: Retourner la liste des enseignants dont le nom commence par f
        List<Teacher> teachers1 = teachers.stream().filter(t -> t.getName().startsWith("f")).toList();
        System.out.println("Teachers whose name starts with 'f': " + teachers1);

        // TO DO 5: Retourner la liste des enseignants dont le nom commence par s
        List<Teacher> teachers2 = teachers.stream().filter(t -> t.getName().startsWith("s")).toList();
        System.out.println("Teachers whose name starts with 's': " + teachers2);

        // TO DO 6: Retourner true si il y a au moins un enseignant dont le salaire > 100000, false sinon
        boolean test = teachers.stream().anyMatch(t -> t.getSalary() > 100000);
        System.out.println("Is there any teacher with a salary greater than 100000? " + test);

        // TO DO 7: Afficher le premier enseignant Unity le nom commence avec g avec 2 manières différentes
        /* First way */
        teachers.stream().filter(t -> t.getSubject() == Subject.UNITY && t.getName().startsWith("g"))
                .findFirst().ifPresent(System.out::println);

        /* Second way */
        teachers.stream().filter(t -> t.getSubject() == Subject.UNITY && t.getName().startsWith("g"))
                .limit(1).forEach(System.out::println);

        // TO DO 8: Afficher le deuxième enseignant dont le nom commence avec s
        teachers.stream().filter(t -> t.getName().startsWith("s")).skip(1).findFirst().ifPresent(System.out::println);
    }
}
