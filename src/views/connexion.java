package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import DAO.DAOGeneric;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class connexion extends JFrame {

	private JPanel contentPane;
	private JTextField textField_user;
	private JTextField textField_mdp;
	private JButton btnConnexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion frame = new connexion();
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
	public connexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur");
		lblUtilisateur.setBounds(33, 71, 102, 15);
		contentPane.add(lblUtilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(33, 98, 102, 15);
		contentPane.add(lblMotDePasse);
		
		textField_user = new JTextField();
		textField_user.setBounds(171, 69, 114, 19);
		contentPane.add(textField_user);
		textField_user.setColumns(10);
		
		textField_mdp = new JTextField();
		textField_mdp.setBounds(171, 96, 114, 19);
		contentPane.add(textField_mdp);
		textField_mdp.setColumns(10);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setName("Connexion");
		btnConnexion.setBounds(109, 177, 117, 25);
		contentPane.add(btnConnexion);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(33, 125, 70, 15);
		contentPane.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Medecin"}));
		comboBox.setBounds(171, 120, 114, 24);
		contentPane.add(comboBox);
	}

	public JTextField getTextField_mdp() {
		return textField_mdp;
	}
	public JTextField getTextField_user() {
		return textField_user;
	}
	public JButton getBtnConnexion() {
		return btnConnexion;
	}
}
