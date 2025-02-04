package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class HomeViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public HomeViewPanel() {
		setLayout(null);
		
		JLabel lblTitle = new JLabel("TP POO - Bibliothèque");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTitle.setBounds(210, 23, 190, 21);
		
		add(lblTitle);
		
		JLabel lblDevelopedBy = new JLabel("Developed by: Raphael Cunha");
		lblDevelopedBy.setBounds(252, 446, 146, 14);
		add(lblDevelopedBy);
		
		JLabel lblSelectionnezModule = new JLabel("Sélectionnez le module auquel vous souhaitez accéder");
		lblSelectionnezModule.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectionnezModule.setBounds(127, 55, 357, 21);
		add(lblSelectionnezModule);
		
		JButton btnDepartement = new JButton("Departement");
		btnDepartement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDepartement.setBounds(235, 87, 140, 52);
		add(btnDepartement);
		
		JButton btnMatiere = new JButton("Matière");
		btnMatiere.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMatiere.setBounds(235, 147, 140, 52);
		add(btnMatiere);
		
		JButton btnEvaluation = new JButton("Evaluation");
		btnEvaluation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEvaluation.setBounds(236, 210, 140, 52);
		add(btnEvaluation);
		
		JButton btnEtudiant = new JButton("Étudiant");
		btnEtudiant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEtudiant.setBounds(237, 269, 140, 52);
		add(btnEtudiant);
		
		JButton btnNote = new JButton("Note");
		btnNote.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNote.setBounds(237, 328, 140, 52);
		add(btnNote);
		
	
	}
}
