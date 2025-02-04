package view;

import javax.swing.*;
import model.Note;
import service.EtudiantService;
import service.EvaluationService;
import service.NoteService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteViewPanel extends JPanel {
	
    private NoteService noteService;
    private EtudiantService etudiantService;
    private EvaluationService evaluationService;
    
    private JTextField valeurField;
    private JTextField idEtudiantField;
    private JTextField idEvaluationField;
    private JTextArea notesArea;

    public NoteViewPanel(NoteService noteService, EtudiantService etudiantService, EvaluationService evaluationService) {
        this.noteService = noteService;
        this.etudiantService = etudiantService;
        this.evaluationService = evaluationService;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Panel for buttons and input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Valeur de la note:"));
        valeurField = new JTextField();
        inputPanel.add(valeurField);
        
        inputPanel.add(new JLabel("ID de l'étudiant:"));
        idEtudiantField = new JTextField();
        inputPanel.add(idEtudiantField);

        inputPanel.add(new JLabel("ID de l'évaluation:"));
        idEvaluationField = new JTextField();
        inputPanel.add(idEvaluationField);

        JButton addNoteButton = new JButton("Ajouter Note");
        addNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valeur = Double.parseDouble(valeurField.getText());
                int idEtudiant = Integer.parseInt(idEtudiantField.getText());
                int idEvaluation = Integer.parseInt(idEvaluationField.getText());
                noteService.createNote(valeur, idEtudiant, idEvaluation);
                updateNotesArea();
            }
        });
        inputPanel.add(addNoteButton);

        // Panel for displaying notes
        notesArea = new JTextArea(10, 30);
        notesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(notesArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateNotesArea() {
        StringBuilder sb = new StringBuilder();
        for (Note note : noteService.getAllNotes()) {
            sb.append(note.toString()).append("\n");
        }
        notesArea.setText(sb.toString());
    }
}
