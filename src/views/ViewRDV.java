package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ViewRDV extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton BtnRetour;
	private JButton BtnValider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRDV frame = new ViewRDV();
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
	public ViewRDV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrnauxDisponible = new JLabel("Crénaux disponible");
		lblCrnauxDisponible.setBounds(273, 0, 136, 15);
		contentPane.add(lblCrnauxDisponible);
		
		BtnRetour = new JButton("Retour");
		BtnRetour.setBounds(12, 314, 209, 25);
		contentPane.add(BtnRetour);
		
		BtnValider = new JButton("Valider");
		BtnValider.setName("valider");
		BtnValider.setBounds(539, 314, 117, 25);
		contentPane.add(BtnValider);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 44, 644, 187);
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
	}
	public JButton getBtnRetour() {
		return BtnRetour;
	}
	public JButton getBtnValider() {
		return BtnValider;
	}
	public JTable getTable() {
		return table;
	}
}
