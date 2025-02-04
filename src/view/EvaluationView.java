package view;

import java.util.List;
import java.util.Scanner;

import model.Evaluation;

public class EvaluationView {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void showEvaluationView() {
		System.out.println("=============================================");
		System.out.println("==================EVALUATION=================");
		System.out.println("=============================================");
		System.out.println("1. AJOUTER UNE EVALUATION");
		System.out.println("2. SUPPRIMER UNE EVALUATION");
		System.out.println("3. METTRE À JOUR INFO D'UNE EVALUATION");
		System.out.println("4. AFFICHER TOUTES LES EVALUATIONS");
		System.out.println("5. SORTIR");
		System.out.println("\nChoisissez une option: ");
	}
	
	public static void printEvaluationsTable(List<Evaluation> evaluations) {
        String format = "%-15s %-20s %-15s %-15s%n";
        System.out.printf(format, "ID", "Type", "Coefficient", "ID Matiere");
        System.out.println(new String(new char[65]).replace("\0", "-")); 

        for (Evaluation evaluation : evaluations) {
            System.out.printf(format,
                evaluation.getIdEvaluation(),
                evaluation.getType(),
                evaluation.getCoefficient(),
                evaluation.getIdMatiere()
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
