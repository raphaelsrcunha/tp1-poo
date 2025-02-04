package view;

import java.util.List;
import java.util.Scanner;

import model.Matiere;

public class MatiereView {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void showMatiereView() {
		System.out.println("=============================================");
		System.out.println("====================MATIERE==================");
		System.out.println("=============================================");
		System.out.println("1. AJOUTER UNE MATIERE");
		System.out.println("2. SUPPRIMER UNE MATIERE");
		System.out.println("3. METTRE À JOUR INFO D'UNE MATIERE");
		System.out.println("4. AFFICHER TOUTES LES MATIERES");
		System.out.println("5. SORTIR");
		System.out.println("\nChoisissez une option: ");
	}
	
	 public static void printMatieresTable(List<Matiere> matieres) {
	        String format = "%-5s %-15s%n";
	        System.out.printf(format, "ID", "Nom");
	        System.out.println(new String(new char[20]).replace("\0", "-")); 

	        for (Matiere matiere : matieres) {
	            System.out.printf(format,
	                matiere.getIdMatiere(),
	                matiere.getNom()
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
