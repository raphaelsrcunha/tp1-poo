package view;

import javax.swing.*;
import service.DepartementService;
import service.EtudiantService;

public class EtudiantViewJF extends JFrame {
    public EtudiantViewJF(EtudiantService etudiantService, DepartementService departementService) {
        setTitle("Gestion des Étudiants");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Adiciona o EtudiantViewPanel à janela
        EtudiantViewPanel etudiantPanel = new EtudiantViewPanel(etudiantService, departementService);
        add(etudiantPanel);
    }
}
