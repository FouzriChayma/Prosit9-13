import java.util.*;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Exemple d'utilisation
        List<Student> studentList = Arrays.asList(
                new Student(1, "Alice", 20),
                new Student(2, "Bob", 22),
                new Student(3, "Charlie", 21)
        );

        StudentManagement studentManagement = new StudentManagement();

        // Afficher tous les étudiants
        System.out.println("Afficher tous les étudiants:");
        studentManagement.displayStudents(studentList, System.out::println);

        // Afficher les étudiants filtrés par âge
        System.out.println("\nAfficher les étudiants de plus de 20 ans:");
        studentManagement.displayStudentsByFilter(studentList, student -> student.getAge() > 20, System.out::println);

        // Retourner les noms des étudiants
        System.out.println("\nRetourner les noms des étudiants:");
        String names = studentManagement.returnStudentsNames(studentList, Student::getNom);
        System.out.println(names);

        // Créer un nouvel étudiant
        System.out.println("\nCréer un nouvel étudiant:");
        Student newStudent = studentManagement.createStudent(() -> new Student(4, "David", 23));
        System.out.println(newStudent);

        // Trier les étudiants par ID
        System.out.println("\nTrier les étudiants par ID:");
        List<Student> sortedStudents = studentManagement.sortStudentsById(studentList, Comparator.comparingInt(Student::getId));
        studentManagement.displayStudents(sortedStudents, System.out::println);

        // Convertir la liste d'étudiants en flux
        System.out.println("\nConvertir la liste d'étudiants en flux:");
        Stream<Student> studentStream = studentManagement.convertToStream(studentList);
        studentStream.forEach(System.out::println);
    }
        }
