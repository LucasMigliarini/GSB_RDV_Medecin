package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class NewRDV extends JFrame {

	private JPanel contentPane;
	private JTextField txt_date;
	private JTextField txt_heure;
	private JButton btnRetour;
	private JButton btnValider;
	private JComboBox comboBox_med;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRDV frame = new NewRDV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewRDV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjouterUnCrneaux = new JLabel("Ajouter un créneaux");
		lblAjouterUnCrneaux.setBounds(182, 12, 153, 15);
		contentPane.add(lblAjouterUnCrneaux);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(116, 94, 70, 15);
		contentPane.add(lblDate);
		
		JLabel lblHheure = new JLabel("Heure");
		lblHheure.setBounds(116, 147, 70, 15);
		contentPane.add(lblHheure);
		
		JLabel lblMedecin = new JLabel("Medecin");
		lblMedecin.setBounds(116, 195, 70, 15);
		contentPane.add(lblMedecin);
		
		btnRetour = new JButton("Retour");
		btnRetour.setName("retour");
		btnRetour.setBounds(12, 331, 117, 25);
		contentPane.add(btnRetour);
		
		btnValider = new JButton("Valider");
		btnValider.setName("valider");
		btnValider.setBounds(391, 331, 117, 25);
		contentPane.add(btnValider);
		
		txt_date = new JTextField();
		txt_date.setBounds(231, 92, 114, 19);
		contentPane.add(txt_date);
		txt_date.setColumns(10);
		
		txt_heure = new JTextField();
		txt_heure.setColumns(10);
		txt_heure.setBounds(231, 145, 114, 19);
		contentPane.add(txt_heure);
		
		comboBox_med = new JComboBox();
		comboBox_med.setBounds(231, 190, 117, 24);
		contentPane.add(comboBox_med);
	}
	public JButton getBtnRetour() {
		return btnRetour;
	}
	public JButton getBtnValider() {
		return btnValider;
	}
	public JTextField getTxt_date() {
		return txt_date;
	}
	public JTextField getTxt_heure() {
		return txt_heure;
	}
	public JComboBox getComboBox_med() {
		return comboBox_med;
	}
}
