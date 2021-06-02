package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class allRDV extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox_visi;
	private JButton btnVoir;
	private JButton btnRetour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allRDV frame = new allRDV();
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
	public allRDV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 43, 725, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date", "Heure", "Medecin"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblVoirRendezvous = new JLabel("Voir Rendez-vous");
		lblVoirRendezvous.setBounds(292, 12, 175, 15);
		contentPane.add(lblVoirRendezvous);
		
		comboBox_visi = new JComboBox();
		comboBox_visi.setBounds(26, 331, 114, 24);
		contentPane.add(comboBox_visi);
		
		btnVoir = new JButton("Voir");
		btnVoir.setName("voir");
		btnVoir.setBounds(162, 331, 117, 25);
		contentPane.add(btnVoir);
		
		btnRetour = new JButton("Retour");
		btnRetour.setName("retour");
		btnRetour.setBounds(26, 426, 117, 25);
		contentPane.add(btnRetour);
	}
	public JTable getTable() {
		return table;
	}
	public JComboBox getComboBox_visi() {
		return comboBox_visi;
	}
	public JButton getBtnVoir() {
		return btnVoir;
	}
	public JButton getBtnRetour() {
		return btnRetour;
	}
}
