package view;

import java.util.List;
import java.util.Scanner;

import model.Note;

public class NoteView {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void showNoteView() {
		System.out.println("=============================================");
		System.out.println("=====================NOTE====================");
		System.out.println("=============================================");
		System.out.println("1. AJOUTER UNE NOTE");
		System.out.println("2. SUPPRIMER UNE NOTE");
		System.out.println("3. METTRE À JOUR INFO D'UNE DEPARTEMENT");
		System.out.println("4. AFFICHER TOUTES LES NOTES");
		System.out.println("5. SORTIR");
		System.out.println("\nChoisissez une option: ");
	}
	
	public static void printNotesTable(List<Note> notes) {
        String format = "%-10s %-10s %-15s %-15s%n";
        System.out.printf(format, "ID", "Valeur", "ID Etudiant", "ID Evaluation");
        System.out.println(new String(new char[50]).replace("\0", "-")); 

        for (Note note : notes) {
            System.out.printf(format,
                note.getIdNote(),
                note.getValeur(),
                note.getIdEtudiant(),
                note.getIdEvaluation()
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
