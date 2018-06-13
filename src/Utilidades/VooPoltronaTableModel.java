/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import DAO.ClassesDB.Passagem;
import DAO.ClassesDB.Voo;
import DAO.ClassesDB.VooPoltrona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class VooPoltronaTableModel extends AbstractTableModel{
    private final List<VooPoltrona> linhas;
    private final String[] colunas = new String[] { "Voo", "Poltrona", "Localizador", "Status" };
    private static final int VOO = 0;
    private static final int POLTRONA = 1;
    private static final int LOCALIZADOR = 2;
    private static final int STATUS = 3;
    
    public VooPoltronaTableModel() {
        linhas = new ArrayList<>();
    }
 
    // Cria um VooPoltronaTableModel contendo a lista recebida por parâmetro
    public VooPoltronaTableModel(List<VooPoltrona> listaPassageiros) {
        linhas = new ArrayList<>(listaPassageiros);
    }
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case VOO:
            return VooPoltrona.class;
        case POLTRONA:
            return VooPoltrona.class;
        case LOCALIZADOR:
            return VooPoltrona.class;
        case STATUS:
            return VooPoltrona.class;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        VooPoltrona passageiro = linhas.get(rowIndex);

        switch (columnIndex) {
         case VOO:
            return passageiro.getVooTag().getVooTag();
        case POLTRONA:
            return passageiro.getPoltrona();
        case LOCALIZADOR:
            return passageiro.getLocalizador().getPassLocalizador();
        case STATUS:
            return passageiro.getStatus().getStatus();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        VooPoltrona passageiro = linhas.get(rowIndex);

        switch (columnIndex) {
            case VOO:
                passageiro.setVooTag((Voo) aValue);
                break;
            case POLTRONA:
                passageiro.setPoltrona((Integer) aValue);
                break;
            case LOCALIZADOR:
                passageiro.setLocalizador((Passagem) aValue);
                break;
            case STATUS:
                passageiro.setVooTag((Voo) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public VooPoltrona getVooPoltrona(int indiceLinha) {
        return linhas.get(indiceLinha);
    }


    public void addVooPoltrona(VooPoltrona poltrona) {
        // Adiciona o registro.
        linhas.add(poltrona);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    // Remove o sócio da linha especificada.
    public void removeVooPoltrona(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeVooPoltrona(List<VooPoltrona> poltrona) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(poltrona);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + poltrona.size());
    }

    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        fireTableDataChanged();
    }
}
