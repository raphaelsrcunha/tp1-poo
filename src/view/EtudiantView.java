package view;

import java.util.List;
import java.util.Scanner;

import model.Etudiant;

	public class EtudiantView {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void showEtudiantView() {
		System.out.println("=============================================");
		System.out.println("===================ETUDIANT==================");
		System.out.println("=============================================");
		System.out.println("1. AJOUTER UN ETUDIANT");
		System.out.println("2. SUPPRIMER UN ETUDIANT");
		System.out.println("3. METTRE À JOUR INFO D'UN ETUDIANT");
		System.out.println("4. AFFICHER TOUS LES ETUDIANTS");
		System.out.println("5. SORTIR");
		System.out.println("\nChoisissez une option: ");
	}
	
	public static void printEtudiantsTable(List<Etudiant> etudiants) {
        String format = "%-10s %-20s %-20s %-15s %-15s %-15s%n";
        System.out.printf(format, "ID", "Nom", "Prenom", "Matricule", "Niveau", "ID Departement");
        System.out.println(new String(new char[95]).replace("\0", "-")); 

        for (Etudiant etudiant : etudiants) {
            System.out.printf(format,
                etudiant.getIdEtudiant(),
                etudiant.getNom(),
                etudiant.getPrenom(),
                etudiant.getMatricule(),
                etudiant.getNiveau(),
                etudiant.getIdDepartement()
            );
        }
    }
	
	public static int getUserChoice() {
		while (!scanner.hasNextInt()) {
			System.out.println("Entrée invalide. Veuillez saisir un numéro");
			scanner.next();
	}
		return scanner.nextInt();
	}
}
