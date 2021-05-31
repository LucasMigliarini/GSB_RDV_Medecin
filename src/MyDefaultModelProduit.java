import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

import model.CompteRenduVisite;
import model.Medecin;
import model.Produit;
import model.Visiteur;

public class MyDefaultModelProduit extends DefaultTableModel{
	List<Produit> CompteRV;
	String [] ColumNames = {
			"Produit",
			"Selectionner"
	};
	
	HashSet<Produit> modified = new HashSet<>();

	public MyDefaultModelProduit(List<Produit> compteRV) {

		CompteRV = compteRV;
		
	}

	
	HashSet<Produit > getModifiedCRV(){
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
			type = Boolean.class;
			break;
		default:
			break;
		}
		return type;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
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
		Produit crv = CompteRV.get(row);
		switch (column) {
		case 0:
			value=crv.getProduitNom();
			break;
		case 1:
			value = false;
			break;
		default:
		}
		return value;
		
	}

	@Override
	public boolean isCellEditable(int row, int column) {

		
		return true;
		
	}

	/*@Override
	public void setValueAt(Object aValue, int row, int column) {
	
		Produit crv = CompteRV.get(row);
		Boolean checkbox = check.get(row);
		System.out.println(checkbox);
		System.out.println(aValue);
		
		switch (column) {
		case 0:
			crv.setProduitNom((String)aValue);
			break;
		case 1:
			checkbox = (Boolean)aValue;
			break;

		default:
			break;
		}
		modified.add(crv);
		modifiedcheck.add(checkbox);
		
	}*/

	

}
