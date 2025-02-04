package view;

import java.util.Scanner;

public class HomeView {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void showHomeView() {
		System.out.println("\n=============================================");
		System.out.println("==============APPLICATION iNotes=============");
		System.out.println("=============================================");
		System.out.println("1. NOTE");
		System.out.println("2. ETUDIANT");
		System.out.println("3. MATIERE");
		System.out.println("4. EVALUATION");
		System.out.println("5. DEPARTEMENT");
		System.out.println("6. MOYENNES");
		System.out.println("7. SORTIR");
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
