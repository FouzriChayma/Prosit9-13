import java.util.*;

public class AffectationHashMap {
    Map<Employee, Dep> affectationMap = new HashMap<>();

    public void ajouterEmployeDepartement(Employee e, Dep d){
        this.affectationMap.put(e, d);
    }

    public void displayAffectation(){
        for (Map.Entry<Employee, Dep> entry : this.affectationMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public void supprimerEmploye(Employee e){
        this.affectationMap.remove(e);
    }

    public boolean supprimerEmployeEtDepartement (Employee e,Dep d){
        return this.affectationMap.remove(e,d);
    }

    public Set<Employee> getAllEmploye(){
        return this.affectationMap.keySet();
    }

    public Collection<Dep> afficherDepartements(){
        return this.affectationMap.values();
    }

    public boolean rechercherEmploye (Employee e){
        return this.affectationMap.containsKey(e);
    }

    public boolean rechercherDepartement (Dep d){
        return this.affectationMap.containsValue(d);
    }

    public TreeMap<Employee, Dep> trierMap(){
        Comparator<Employee> nameEmpComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        return new TreeMap<>(nameEmpComparator);
    }
}