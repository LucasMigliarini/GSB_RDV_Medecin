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
import java.awt.Checkbox;
import java.awt.Button;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class newCRV extends JFrame {

	private JPanel contentPane;
	private JTextField txt_date;
	private JTextField txt_heure;
	private JTextField txt_desc;
	private JButton btnRetour;
	private JButton btnValider;
	private JComboBox comboBox_cat;
	private JTable table;
	private JButton btnAjouter;
	private JComboBox comboBox_prod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newCRV frame = new newCRV();
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
	public newCRV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNouvelleFiche = new JLabel("Nouvelle fiche");
		lblNouvelleFiche.setBounds(205, 12, 139, 15);
		contentPane.add(lblNouvelleFiche);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(40, 58, 70, 15);
		contentPane.add(lblDate);
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setBounds(40, 103, 70, 15);
		contentPane.add(lblHeure);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(40, 145, 106, 15);
		contentPane.add(lblDescription);
		
		JLabel lblMedecin = new JLabel("Medecin");
		lblMedecin.setBounds(40, 189, 70, 15);
		contentPane.add(lblMedecin);
		
		JLabel lblDatevisiteur = new JLabel("Visiteur");
		lblDatevisiteur.setBounds(40, 232, 70, 15);
		contentPane.add(lblDatevisiteur);
		
		btnRetour = new JButton("Retour");
		btnRetour.setName("retour");
		btnRetour.setBounds(12, 430, 117, 25);
		contentPane.add(btnRetour);
		
		btnValider = new JButton("Valider");
		btnValider.setName("valider");
		btnValider.setBounds(636, 430, 117, 25);
		contentPane.add(btnValider);
		
		txt_date = new JTextField();
		txt_date.setBounds(146, 56, 114, 19);
		contentPane.add(txt_date);
		txt_date.setColumns(10);
		
		txt_heure = new JTextField();
		txt_heure.setColumns(10);
		txt_heure.setBounds(146, 101, 114, 19);
		contentPane.add(txt_heure);
		
		txt_desc = new JTextField();
		txt_desc.setColumns(10);
		txt_desc.setBounds(146, 143, 114, 19);
		contentPane.add(txt_desc);
		
		JLabel lblDatemedicament = new JLabel("Produit(s) sélectionné(s)");
		lblDatemedicament.setBounds(415, 103, 175, 15);
		contentPane.add(lblDatemedicament);
		
		JLabel lblCategorie = new JLabel("Categories:");
		lblCategorie.setBounds(338, 23, 114, 15);
		contentPane.add(lblCategorie);
		
		comboBox_cat = new JComboBox();
		comboBox_cat.setName("selectionner");
		comboBox_cat.setBounds(320, 53, 149, 24);
		contentPane.add(comboBox_cat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 130, 371, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JComboBox comboBox_cat_1 = new JComboBox();
		comboBox_cat_1.setBounds(146, 184, 114, 24);
		contentPane.add(comboBox_cat_1);
		
		JComboBox comboBox_cat_2 = new JComboBox();
		comboBox_cat_2.setBounds(146, 227, 114, 24);
		contentPane.add(comboBox_cat_2);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setName("ajouter");
		btnAjouter.setBounds(636, 53, 117, 25);
		contentPane.add(btnAjouter);
		
		comboBox_prod = new JComboBox();
		comboBox_prod.setBounds(475, 53, 149, 24);
		contentPane.add(comboBox_prod);
		
		JLabel lblProduits = new JLabel("Produit(s):");
		lblProduits.setBounds(498, 23, 114, 15);
		contentPane.add(lblProduits);
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
	public JTextField getTxt_desc() {
		return txt_desc;
	}
	public JComboBox getComboBox_cat() {
		return comboBox_cat;
	}

	public JTable getTable() {
		return table;
	}
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	public JComboBox getComboBox_prod() {
		return comboBox_prod;
	}
}
