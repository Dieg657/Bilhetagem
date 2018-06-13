/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import DAO.ClassesDB.Voo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author diego
 */
public class VooTableModel extends AbstractTableModel{
    private final List<Voo> linhas;
    private final String[] colunas = new String[] { "Voo", "Origem", "Destino", "Hora de Partida", "Preço" };
    private static final int VOO = 0;
    private static final int ORIGEM = 1;
    private static final int DESTINO = 2;
    private static final int HORA = 3;
    private static final int PRECO = 4;
    
    public VooTableModel() {
        linhas = new ArrayList<>();
    }
 
    // Cria um VooTableModel contendo a lista recebida por parâmetro
    public VooTableModel(List<Voo> listaDeVoos) {
        linhas = new ArrayList<>(listaDeVoos);
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
            return Voo.class;
        case ORIGEM:
            return Voo.class;
        case DESTINO:
            return Voo.class;
        case HORA:
            return Voo.class;
        case PRECO:
            return Voo.class;
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
        // Pega o sócio referente a linha especificada.
        Voo voo = linhas.get(rowIndex);

        switch (columnIndex) {
         case VOO:
            return voo.getVooTag();
        case ORIGEM:
            return voo.getOrigem();
        case DESTINO:
            return voo.getDestino();
        case HORA:
            return voo.getHrPartida();
        case PRECO:
            return voo.getVlVoo();
        default:
            // Não deve ocorrer, pois só existem 2 colunas
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Voo voo = linhas.get(rowIndex);

        switch (columnIndex) {
            case VOO:
                voo.setVooTag((String) aValue);
                break;
            case ORIGEM:
                voo.setOrigem((String) aValue);
                break;
            case DESTINO:
                voo.setDestino((String) aValue);
                break;
            case HORA:
                voo.setHrPartida((Date) aValue);
                break;
            case PRECO:
                voo.setVlVoo((Integer) aValue);
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    } 
    // Retorna o sócio referente a linha especificada
    public Voo getVoo(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    // Adiciona o sócio especificado ao modelo
    public void addVoo(Voo voo) {
        // Adiciona o registro.
        linhas.add(voo);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    // Remove o sócio da linha especificada.
    public void removeVoo(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    // Adiciona uma lista de sócios no final da lista.
    public void addListaDeVoos(List<Voo> voos) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(voos);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + voos.size());
    }

    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}
