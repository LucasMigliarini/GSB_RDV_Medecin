import java.util.HashSet;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.CompteRenduVisite;
import model.Medecin;
import model.Produit;
import model.Visiteur;

public class MyDefaultModelCompteRendu extends DefaultTableModel{
	List<CompteRenduVisite> CompteRV;
	String [] ColumNames = {
			"Date",
			"Heure",
			"Description",	
			"Medecin",
			"Visiteur",
			"Medicament"
	};
	
	HashSet<CompteRenduVisite> modified = new HashSet<>();

	public MyDefaultModelCompteRendu(List<CompteRenduVisite> compteRV) {

		CompteRV = compteRV;
	}

	
	HashSet<CompteRenduVisite > getModifiedCRV(){
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
		case 3:
			type = String.class;
			break;
		case 4:
			type = String.class;
			break;
		case 5:
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
		return 6;
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
		CompteRenduVisite crv = CompteRV.get(row);
		switch (column) {
		case 0:
			value=crv.getCRVDate();
			break;
		case 1:
			value=crv.getCRVHeure();
			break;
		case 2:
			value=crv.getCRVDescription();
			break;
		case 3:
			Medecin temp = crv.getMedecin();
			value= temp.getMedecinNom();
			break;
		case 4:
			Visiteur temps = crv.getVisiteur();
			value= temps.getVisiteurNom();
			break;
		case 5:
			List<Produit> tempo = crv.getProduits();
			for (Produit produit : tempo) {
				value= produit.getProduitNom() + "," +value;
			}
			
			break;
		default:
		}
		return value;
		
	}

	@Override
	public boolean isCellEditable(int row, int column) {

		if (column == 4 && column == 5) {
			return false;
		}
		return true;
		
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
	
		CompteRenduVisite crv = CompteRV.get(row);
		switch (column) {
		case 0:
			crv.setCRVDate((String)aValue);
			break;
		case 1:
			crv.setCRVHeure((String)aValue);
			break;
		case 2:
			crv.setCRVDescription((String)aValue);
			break;

		default:
			break;
		}
		modified.add(crv);
	}

	

}
