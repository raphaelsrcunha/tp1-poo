package view;

import java.util.List;
import java.util.Scanner;

import model.Matiere;

public class MoyenneView {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void showMoyenneView() {
		System.out.println("=============================================");
		System.out.println("====================MOYENNE==================");
		System.out.println("=============================================");
		System.out.println("1. MOYENNE PAR NOM ETUDIANT ET NOM MATIERE");
		System.out.println("2. MOYENNE PAR EVALUATION ID");
		System.out.println("3. MOYENNE PAR EVALUATION TYPE");
		System.out.println("4. MOYENNE PAR PRENOM DU ETUDIANT");
		System.out.println("5. MOYENNE PAR NOM DU ETUDIANT");
		System.out.println("6. MOYENNE PAR MATRICULE DU ETUDIANT");
		System.out.println("7. MOYENNE PAR NIVEAU DU ETUDIANT");
		System.out.println("8. MOYENNE PAR NOM DE LA MATIERE");
		System.out.println("9. MOYENNE PAR NOM DU DEPARTEMENT");
		System.out.println("10. SORTIR");
		System.out.println("\nChoisissez une option: ");
	}
	
	
	public static int getUserChoice() {
		while (!scanner.hasNextInt()) {
			System.out.println("Entrée invalide. Veuillez saisir un numéro");
			scanner.next();
	}
		return scanner.nextInt();
	} 
}
