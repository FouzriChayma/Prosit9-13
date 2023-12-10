import com.sun.security.jgss.GSSUtil;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Dep dep1 = new Dep(1, "dep1", 10);
        Dep dep2 = new Dep(2, "dep2", 20);
        Dep dep3 = new Dep(3, "dep3", 30);

        Employee employee1 = new Employee(1, "employee1", "bizerte", 2591997, "amp1@yahoo.com");
        Employee employee2 = new Employee(2, "bbbb", "gafsa", 2591997, "ness@yahoo.com");
        Employee employee3 = new Employee(3, "aaaa", "mednine", 2591997, "mannoo@yahoo.com");

        AffectationHashMap affectationHashMap = new AffectationHashMap();
        affectationHashMap.ajouterEmployeDepartement(employee1, dep1);
        affectationHashMap.ajouterEmployeDepartement(employee2, dep2);
        affectationHashMap.ajouterEmployeDepartement(employee3, dep3);

        affectationHashMap.displayAffectation();
        System.out.println("------------------------------------------------");
        System.out.println(affectationHashMap.supprimerEmployeEtDepartement(employee1,dep1));
        affectationHashMap.displayAffectation();

        System.out.println("--------------------------------------------------");
        Iterator<Employee> iterator = affectationHashMap.getAllEmploye().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("--------------------------------------------------");
        for (Dep dep : affectationHashMap.afficherDepartements()) {
            System.out.println(dep);
        }

        System.out.println(affectationHashMap.rechercherEmploye(employee1));
        System.out.println(affectationHashMap.rechercherDepartement(dep3));

        affectationHashMap.trierMap();
        affectationHashMap.displayAffectation();

    }
}