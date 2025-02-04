package view;

import javax.swing.*;

import model.Etudiant;
import service.DepartementService;
import service.EtudiantService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EtudiantViewPanel extends JPanel {
    private EtudiantService etudiantService;
    private DepartementService departementService;

    private JTextField nomField;
    private JTextField prenomField;
    private JTextField matriculeField;
    private JTextField niveauField;
    private JTextField departementIdField;
    private JTextArea etudiantsArea;

    public EtudiantViewPanel(EtudiantService etudiantService, DepartementService departementService) {
        this.etudiantService = etudiantService;
        this.departementService = departementService;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Panel for buttons and input fields
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Nom:"));
        nomField = new JTextField();
        inputPanel.add(nomField);

        inputPanel.add(new JLabel("Prénom:"));
        prenomField = new JTextField();
        inputPanel.add(prenomField);

        inputPanel.add(new JLabel("Matricule:"));
        matriculeField = new JTextField();
        inputPanel.add(matriculeField);

        inputPanel.add(new JLabel("Niveau:"));
        niveauField = new JTextField();
        inputPanel.add(niveauField);

        inputPanel.add(new JLabel("ID du Département:"));
        departementIdField = new JTextField();
        inputPanel.add(departementIdField);

        JButton addEtudiantButton = new JButton("Ajouter Étudiant");
        addEtudiantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String matricule = matriculeField.getText();
                String niveau = niveauField.getText();
                int idDepartement = Integer.parseInt(departementIdField.getText());
                etudiantService.createEtudiant(nom, prenom, matricule, niveau, idDepartement);
                updateEtudiantsArea();
            }
        });
        inputPanel.add(addEtudiantButton);

        // Panel for displaying students
        etudiantsArea = new JTextArea(10, 30);
        etudiantsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(etudiantsArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateEtudiantsArea() {
        StringBuilder sb = new StringBuilder();
        for (Etudiant etudiant : etudiantService.getAllEtudiants()) {
            sb.append(etudiant.toString()).append("\n");
        }
        etudiantsArea.setText(sb.toString());
    }
}
