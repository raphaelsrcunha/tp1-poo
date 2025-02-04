import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import config.DatabaseInitializer;
import service.DepartementService;
import service.EtudiantService;
import service.EvaluationService;
import service.MatiereService;
import service.NoteService;
import view.EtudiantViewPanel;
import view.NoteViewPanel;

public class Main2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
        	try {
                // Criação da base de dados e das tabelas
                DatabaseInitializer dbIni = new DatabaseInitializer();
                dbIni.initializeDatabase();

                if (dbIni.areTablesEmpty()) {
                    dbIni.populateTables();
                }

                // Instanciação dos serviços
                DepartementService departementService = new DepartementService();
                EtudiantService etudiantService = new EtudiantService();
                EvaluationService evaluationService = new EvaluationService();
                MatiereService matiereService = new MatiereService();
                NoteService noteService = new NoteService();

                // Criação da janela principal
                JFrame frame = new JFrame("Application");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setLayout(new CardLayout());

                // Criação dos painéis
                JPanel noteViewPanel = new NoteViewPanel(noteService, etudiantService, evaluationService);
                JPanel etudiantViewPanel = new EtudiantViewPanel(etudiantService, departementService);
                // Adicione outros painéis aqui

                // Adicionando os painéis ao frame
                frame.add(noteViewPanel, "NoteView");
                frame.add(etudiantViewPanel, "EtudiantView");
                // Adicione outros painéis ao frame aqui

                // Exibindo a janela principal
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
