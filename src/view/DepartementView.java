package view;

import java.util.List;
import java.util.Scanner;

import model.Departement;

public class DepartementView {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void showDepartementView() {
		System.out.println("=============================================");
		System.out.println("==================DEPARTEMENT================");
		System.out.println("=============================================");
		System.out.println("1. AJOUTER UNE DEPARTEMENT");
		System.out.println("2. SUPPRIMER UNE DEPARTEMENT");
		System.out.println("3. METTRE À JOUR INFO D'UNE DEPARTEMENT");
		System.out.println("4. AFFICHER TOUTES LES DEPARTEMENTS");
		System.out.println("5. SORTIR");
		System.out.println("\nChoisissez une option: ");
	}
	
	public static void printDepartementsTable(List<Departement> departements) {
        String format = "%-10s %-20s%n";
        System.out.printf(format, "ID", "Nome");
        System.out.println(new String(new char[30]).replace("\0", "-")); 

        for (Departement departement : departements) {
            System.out.printf(format,
                departement.getIdDepartement(),
                departement.getNom()
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
