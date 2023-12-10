public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SocieteArrayList societe = new SocieteArrayList();
        Employe e1 = new Employe(1, 454, "ahmed", "IT", "info");
        Employe e2 = new Employe(2, 549, "mourad", "erlk", "eco");
        Employe e3 = new Employe(3, 5449, "monji", "IT", "gestion");

        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);

        System.out.println("Before sorting:");
        societe.displayEmploye();
        System.out.println("After sorting by id:");
        societe.trierEmployeParId();
        societe.displayEmploye();
        System.out.println("After sorting by depName and grade:");
        societe.trierEmployeParNomDepartementEtGrade();
        societe.displayEmploye();
    }
}