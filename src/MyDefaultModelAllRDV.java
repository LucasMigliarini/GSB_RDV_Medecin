import java.util.HashSet;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.CompteRenduVisite;
import model.Creneaux;
import model.Medecin;
import model.Produit;
import model.Visiteur;

public class MyDefaultModelAllRDV extends DefaultTableModel{
	List<Creneaux> CompteRV;
	String [] ColumNames = {
			"Date",
			"Heure",
			"Medecin"
	};
	
	HashSet<Creneaux> modified = new HashSet<>();

	public MyDefaultModelAllRDV(List<Creneaux> compteRV) {

		CompteRV = compteRV;
	}

	
	HashSet<Creneaux > getModifiedCRV(){
		return modified;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> type =null;
		switch (columnIndex) {
		case 0:
			type = String.class;
			break;
		case 1:
			type = String.class;
			break;
		case 2:
			type = String.class;
			break;
		default:
			break;
		}
		return type;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return ColumNames[column];
	}

	@Override
	public int getRowCount() {
		return CompteRV == null ? 0 : CompteRV.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Object value=null;	
		Creneaux crv = CompteRV.get(row);
		switch (column) {
		case 0:
			value=crv.getCreDate();
			break;
		case 1:
			value=crv.getCreHeure();
			break;
		case 2:
			Medecin med =crv.getMedecin();		
			String nameMed = med.getMedecinNom();
			value = nameMed;
			break;
		default:
		}
		return value;
		
	}

	@Override
	public boolean isCellEditable(int row, int column) {

		return false;
		
	}


	

}
