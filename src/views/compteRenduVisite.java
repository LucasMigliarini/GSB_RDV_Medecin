package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class compteRenduVisite extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btn_update;
	private JButton btn_delete;
	private JButton btn_creerVoirRDV;
	private JButton btn_creerCRD_1;
	private JButton btn_creerCRD_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					compteRenduVisite frame = new compteRenduVisite();
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
	public compteRenduVisite() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComptesRendusDe = new JLabel("Comptes rendus de Visites");
		lblComptesRendusDe.setBounds(260, 12, 227, 15);
		contentPane.add(lblComptesRendusDe);
		
		btn_creerVoirRDV = new JButton("Voir mes rendez-vous");
		btn_creerVoirRDV.setName("voirRDV");
		btn_creerVoirRDV.setBounds(12, 415, 209, 25);
		contentPane.add(btn_creerVoirRDV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 52, 725, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		btn_creerCRD_1 = new JButton("Nouveau compte rendu");
		btn_creerCRD_1.setName("newCRV");
		btn_creerCRD_1.setBounds(479, 415, 269, 25);
		contentPane.add(btn_creerCRD_1);
		
		btn_update = new JButton("Mettre à jour");
		btn_update.setName("update");
		btn_update.setBounds(12, 357, 209, 25);
		contentPane.add(btn_update);
		
		btn_delete = new JButton("Supprimer");
		btn_delete.setName("delete");
		btn_delete.setBounds(539, 357, 209, 25);
		contentPane.add(btn_delete);
		
		btn_creerCRD_2 = new JButton("Prendre un rendez-vous");
		btn_creerCRD_2.setName("takerdv");
		btn_creerCRD_2.setBounds(246, 415, 209, 25);
		contentPane.add(btn_creerCRD_2);
	}
	public JButton getBtn_update() {
		return btn_update;
	}
	public JButton getBtn_delete() {
		return btn_delete;
	}
	public JButton getbtn_creerVoirRDV() {
		return btn_creerVoirRDV;
	}
	public JButton getBtn_creerCRD_1() {
		return btn_creerCRD_1;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getBtn_creerCRD_2() {
		return btn_creerCRD_2;
	}
}
