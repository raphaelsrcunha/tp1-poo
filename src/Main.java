import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import config.DatabaseInitializer;
import model.Note;
import service.DepartementService;
import service.EtudiantService;
import service.EvaluationService;
import service.MatiereService;
import service.NoteService;
import view.DepartementView;
import view.EtudiantView;
import view.EvaluationView;
import view.HomeView;
import view.MatiereView;
import view.MoyenneView;
import view.NoteView;

public class Main {

	public static void main(String[] args) throws SQLException {
/*
		// Création de la base de données et des tables, si elle n’a pas été créée
		DatabaseInitializer dbIni = new DatabaseInitializer();
		dbIni.initializeDatabase();
		
		if(dbIni.areTablesEmpty()) {
			try {
				dbIni.populateTables();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Instanciage de toutes les classes Services
		DepartementService departementService = new DepartementService();
		EtudiantService etudiantService = new EtudiantService();
		EvaluationService evaluationService = new EvaluationService();
		MatiereService matiereService = new MatiereService();
		NoteService noteService = new NoteService();
		
		// Instanciage du Scanner pour lire les entrées
		final Scanner scanner = new Scanner(System.in);
		
		// Pour démarrer l'application dans le boucle
		boolean running = true;
		
		while(running) {
			HomeView.showHomeView();
			int choice = HomeView.getUserChoice();
			
			switch (choice) {
				case 1:
					NoteView.showNoteView();
					int choiceNote = NoteView.getUserChoice();
					
					switch(choiceNote) {
					
						case 1:
							System.out.println("Entrez le VALEUR de cette note: ");
							double valeur = scanner.nextDouble();
							EtudiantView.printEtudiantsTable(etudiantService.getAllEtudiants());
							System.out.println("Entrez le ID du étudiant: ");
							int id_etudiant = scanner.nextInt();
							EvaluationView.printEvaluationsTable(evaluationService.getAllEvaluations());
							System.out.println("Entrez le ID de l'évaluation: ");
							int id_evaluation = scanner.nextInt();
							noteService.createNote(valeur, id_etudiant, id_evaluation);
							break;
						
						case 2:
							NoteView.printNotesTable(noteService.getAllNotes());
							System.out.println("Entrez le ID de la note que vous souhaitez supprimer: ");
							int idNote = scanner.nextInt();
							noteService.deleteNote(idNote);
							break;
						
						case 3:
							NoteView.printNotesTable(noteService.getAllNotes());
							System.out.println("Entrez le ID de la note que vous souhaitez mettre à jour: ");
							idNote = scanner.nextInt();
							System.out.println("Entrez le VALEUR de la note pour mettre à jour: ");
							valeur = scanner.nextDouble();
							System.out.println("Entrez le ID du ETUDIANT pour mettre à jour: ");
							int idEtudiant = scanner.nextInt();
							System.out.println("Entrez le ID de la EVALUATION pour mettre à jour: ");
							int idEvaluation = scanner.nextInt();
							noteService.updateNote(valeur, idEtudiant, idEvaluation, idNote);
							break;
							
						case 4:
							NoteView.printNotesTable(noteService.getAllNotes());							
							break;
					}
					break;
				
				case 2:
					EtudiantView.showEtudiantView();
					int choiceEtudiant = EtudiantView.getUserChoice();
					
					switch(choiceEtudiant) {
					
					case 1:
						System.out.println("Entrez le NOM de cet étudiant: ");
						String nom = scanner.next();
						System.out.println("Entrez le PRENOM de cet étudiant: ");
						String prenom = scanner.next();
						System.out.println("Entrez la MATRICULE de cet étudiant: ");
						String matricule = scanner.next();
						System.out.println("Entrez le NIVEAU de cet étudiant: ");
						String niveau = scanner.next();
						DepartementView.printDepartementsTable(departementService.getAllDepartements());
						System.out.println("Entrez le ID du département de cet étudiant: ");
						int id_departement = scanner.nextInt();
						etudiantService.createEtudiant(nom, prenom, matricule, niveau, id_departement);
						break;
					
					case 2:
						EtudiantView.printEtudiantsTable(etudiantService.getAllEtudiants());
						System.out.println("Entrez le ID du etudiant que vous souhaitez supprimer: ");
						int idEtudiant = scanner.nextInt();
						etudiantService.deleteEtudiant(idEtudiant);
						break;
					
					case 3:
						EtudiantView.printEtudiantsTable(etudiantService.getAllEtudiants());
						System.out.println("Entrez le ID du etudiant que vous souhaitez mettre à jour: ");
						idEtudiant = scanner.nextInt();
						System.out.println("Entrez le NOM du etudiant pour mettre à jour: ");
						String nomEtudiant = scanner.next();
						System.out.println("Entrez le PRENOM du etudiant pour mettre à jour: ");
						String prenomEtudiant = scanner.next();
						System.out.println("Entrez le MATRICULE du etudiant pour mettre à jour: ");
						String matriculeEtudiant = scanner.next();
						System.out.println("Entrez le NIVEAU du etudiant pour mettre à jour: ");
						String niveauEtudiant = scanner.next();
						System.out.println("Entrez le ID du DEPARTEMENT du etudiant pour mettre à jour: ");
						int idDepartement = scanner.nextInt();
						etudiantService.updateEtudiant(nomEtudiant, prenomEtudiant, matriculeEtudiant, niveauEtudiant, idDepartement, idEtudiant);
						break;
					case 4:
						EtudiantView.printEtudiantsTable(etudiantService.getAllEtudiants());
						break;
				}
				break;
					
				case 3:
					MatiereView.showMatiereView();
					int choiceMatiere = MatiereView.getUserChoice();
					
					switch(choiceMatiere) {
					
					case 1:
						System.out.println("Entrez le NOM de cette matière: ");
						String nom = scanner.next();
						DepartementView.printDepartementsTable(departementService.getAllDepartements());
						System.out.println("Entrez le ID du département de cette matière: ");
						int id_departement = scanner.nextInt();
						matiereService.createMatiere(nom, id_departement);
						break;
					
					case 2:
						MatiereView.printMatieresTable(matiereService.getAllMatieres());
						System.out.println("Entrez le ID de la matière que vous souhaitez supprimer: ");
						int idMatiere = scanner.nextInt();
						matiereService.deleteMatiere(idMatiere);
						break;
					
					case 3:
						MatiereView.printMatieresTable(matiereService.getAllMatieres());
						System.out.println("Entrez le ID de la matière que vous souhaitez mettre à jour: ");
						idMatiere = scanner.nextInt();
						System.out.println("Entrez le NOUVEAU NOM de la matière pour mettre à jour: ");
						String nomMatiere = scanner.next();
						matiereService.updateMatiere(nomMatiere, idMatiere);
					case 4:
						MatiereView.printMatieresTable(matiereService.getAllMatieres());
						break;
				}
				break;
					
				case 4:
					EvaluationView.showEvaluationView();
					int choiceEvaluation = EvaluationView.getUserChoice();
					
					switch(choiceEvaluation) {
					
					case 1:
						System.out.println("Entrez le TYPE de cette évaluation: ");
						String type = scanner.next();
						System.out.println("Entrez le COEFFICIENT de cette évaluation: ");
						double coefficient = scanner.nextDouble();
						MatiereView.printMatieresTable(matiereService.getAllMatieres());
						System.out.println("Entrez le ID de la matière de cette évaluation: ");
						int id_matiere = scanner.nextInt();
						evaluationService.createEvaluation(type, coefficient, id_matiere);
						break;
					
					case 2:
						EvaluationView.printEvaluationsTable(evaluationService.getAllEvaluations());
						System.out.println("Entrez le ID de la evaluation que vous souhaitez supprimer: ");
						int idEvaluation = scanner.nextInt();
						evaluationService.deleteEvaluation(idEvaluation);
						break;
					
					case 3:
						EvaluationView.printEvaluationsTable(evaluationService.getAllEvaluations());
						System.out.println("Entrez le ID de la evaluation que vous souhaitez mettre à jour: ");
						idEvaluation = scanner.nextInt();
						System.out.println("Entrez le TYPE de la evaluation pour mettre à jour: ");
						type = scanner.next();
						System.out.println("Entrez le COEFFICIENT de la evaluation pour supprimer: ");
						coefficient = scanner.nextDouble();
						System.out.println("Entrez le ID de la matiere de la evaluation pour mettre à jour: ");
						int idMatiere= scanner.nextInt();
						evaluationService.updateEvaluation(type, coefficient, idMatiere, idEvaluation);
						break;
						
					case 4:
						EvaluationView.printEvaluationsTable(evaluationService.getAllEvaluations());
						break;
					}
				break;
					
				case 5:
					DepartementView.showDepartementView();
					int choiceDepartement = DepartementView.getUserChoice();
					
					switch(choiceDepartement) {
					
					case 1:
						System.out.println("Entrez le NOM du département: ");
						String nom = scanner.next();
						departementService.createDepartement(nom);
						break;
					
					case 2:
						DepartementView.printDepartementsTable(departementService.getAllDepartements());
						System.out.println("Entrez le ID du departement que vous souhaitez supprimer: ");
						int idDepartement = scanner.nextInt();
						departementService.deleteDepartement(idDepartement);
						break;
					
					case 3:
						DepartementView.printDepartementsTable(departementService.getAllDepartements());
						System.out.println("Entrez le ID du departement que vous souhaitez mettre à jour: ");
						idDepartement = scanner.nextInt();
						System.out.println("Entrez le NOUVEAU NOM du departement pour mettre à jour: ");
						String nomDepartement = scanner.next();
						departementService.updateDepartement(nomDepartement, idDepartement);
						break;
					case 4:
						DepartementView.printDepartementsTable(departementService.getAllDepartements());
						break;
					}
					break;
				case 6:
					MoyenneView.showMoyenneView();
					int choiceMoyenne = MoyenneView.getUserChoice();
					
					switch(choiceMoyenne) {
					
					case 1:
						EtudiantView.printEtudiantsTable(etudiantService.getAllEtudiants());
						System.out.println("Entrez le PRENOM du etudiant: ");
						String nomEtudiant = scanner.next();
						MatiereView.printMatieresTable(matiereService.getAllMatieres());
						System.out.println("Entrez le NOM de la matière: ");
						String nomMatiere = scanner.next();
						System.out.println("La moyenne du etudiant " + nomEtudiant + " dans la matiere " + nomMatiere + " est égal a " + noteService.getAverageNoteByEtudiantAndMatiere(nomEtudiant, nomMatiere));
						break;
					case 2:
						EvaluationView.printEvaluationsTable(evaluationService.getAllEvaluations());
						System.out.println("Entrez le ID de la evaluation: ");
						int idEvaluation = scanner.nextInt();
						System.out.println("La moyenne est égal a: " + noteService.getAverageNoteByEvaluationId(idEvaluation));
						break;
					case 3:
						EvaluationView.printEvaluationsTable(evaluationService.getAllEvaluations());
						System.out.println("Entrez le TYPE de la evaluation: ");
						String typeEvaluation = scanner.next();
						System.out.println("La moyenne est égal a: " + noteService.getAverageNoteByEvaluationType(typeEvaluation));
						break;
					case 4:
						EtudiantView.printEtudiantsTable(etudiantService.getAllEtudiants());
						System.out.println("Entrez le PRENOM du etudiant: ");
						String prenomEtudiant = scanner.next();
						System.out.println("La moyenne est égal a: " + noteService.getAverageNoteByEtudiantPrenom(prenomEtudiant));
						break;
					case 5:
						EtudiantView.printEtudiantsTable(etudiantService.getAllEtudiants());
						System.out.println("Entrez le NOM du etudiant: ");
						nomEtudiant = scanner.next();
						System.out.println("La moyenne est égal a: " + noteService.getAverageNoteByEtudiantNom(nomEtudiant));
						break;
					case 6:
						EtudiantView.printEtudiantsTable(etudiantService.getAllEtudiants());
						System.out.println("Entrez le MATRICULE du etudiant: ");
						String matriculeEtudiant = scanner.next();
						System.out.println("La moyenne est égal a: " + noteService.getAverageNoteByEtudiantMatricule(matriculeEtudiant));
						break;
					case 7:
						EtudiantView.printEtudiantsTable(etudiantService.getAllEtudiants());
						System.out.println("Entrez le NIVEAU du etudiant: ");
						String niveauEtudiant = scanner.next();
						System.out.println("La moyenne est égal a: " + noteService.getAverageNoteByEtudiantNiveau(niveauEtudiant));
						break;
					case 8:
						MatiereView.printMatieresTable(matiereService.getAllMatieres());
						System.out.println("Entrez le NOM de la matiere: ");
						nomMatiere = scanner.next();
						System.out.println("La moyenne est égal a: " + noteService.getAverageNoteByMatiereNom(nomMatiere));
						break;
					case 9:
						DepartementView.printDepartementsTable(departementService.getAllDepartements());
						System.out.println("Entrez le NOM du departement: ");
						String nomDepartement = scanner.next();
						System.out.println("La moyenne est égal a: " + noteService.getAverageNoteByDepartementNom(nomDepartement));
						break;
					case 10:
						break;
					}
					break;
				case 7:
	                System.out.println("Merci beaucoup! À la prochaine!");
	                running = false;
	                scanner.close();
	                break;
				default:
		            System.out.println("Choix invalide. Essayez encore.");
		            break;	
			}			
		}*/
	}
	
}