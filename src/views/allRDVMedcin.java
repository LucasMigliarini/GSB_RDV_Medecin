package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class allRDVMedcin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox_med;
	private JButton btnVoir;
	private JButton btnNewRDV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allRDVMedcin frame = new allRDVMedcin();
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
	public allRDVMedcin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 12, 725, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		comboBox_med = new JComboBox();
		comboBox_med.setBounds(23, 300, 114, 24);
		contentPane.add(comboBox_med);
		
		btnVoir = new JButton("Voir");
		btnVoir.setName("voir");
		btnVoir.setBounds(159, 300, 117, 25);
		contentPane.add(btnVoir);
		
		btnNewRDV = new JButton("Ajouter un créneau");
		btnNewRDV.setName("newRDV");
		btnNewRDV.setBounds(529, 300, 183, 25);
		contentPane.add(btnNewRDV);
	}
	public JComboBox getComboBox_med() {
		return comboBox_med;
	}
	public JButton getBtnVoir() {
		return btnVoir;
	}
	public JButton getBtnNewRDV() {
		return btnNewRDV;
	}
	public JTable getTable() {
		return table;
	}
}
