/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import DAO.ClassesDB.Estado;
import DAO.ClassesDB.Status;
import DAO.ClassesDB.Voo;
import DAO.ClassesDB.VooPoltrona;
import DAO.SelectDAO;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author diego
 */
public class FormUtils{
    private SelectDAO slctDAO;
    private VooTableModel model;
    private Voo voo;
   
    public void carregaComboBoxEstado(JComboBox cmb){
        slctDAO = new SelectDAO();
        cmb.removeAllItems();
        ItemEstado uf = null;
        List<Estado> lst = slctDAO.getEstadoAll();
        for (Estado estado : lst) {
            uf = new ItemEstado(estado.getIdEstado(), estado.getEstado());
            cmb.addItem(uf);
        }
    }
    
    public void carregaComboBoxUF(JComboBox cmb){
        slctDAO = new SelectDAO();
        cmb.removeAllItems();
        ItemUF uf = null;
        List<Estado> lst;
        lst = slctDAO.getEstadoAll();
        for (Estado estado : lst) {
            uf = new ItemUF(estado.getIdEstado(), estado.getUf());
            cmb.addItem(uf);
        }
    }
    
    public void carregaComboBoxStatus(JComboBox cmb){
        slctDAO = new SelectDAO();
        cmb.removeAllItems();
        ItemStatus st = null;
        List<Status> lst;
        lst = slctDAO.getStatusAll();
        for (Status status : lst) {
            st = new ItemStatus(status.getIdStatus(), status.getStatus());
            cmb.addItem(st);
        }        
    }
    
    public void carregaComboBoxSexo(JComboBox cmb){
        cmb.removeAllItems();
        Item st = null;
        st = new Item(1, "Masculino");
        cmb.addItem(st);
        st = new Item(2, "Feminino");
        cmb.addItem(st);
    }
    
    public String getTextNumber(String text){
        try {
            Long.parseLong(text);
            return text;
        } catch (NumberFormatException|NullPointerException ex) {
            System.out.println(ex.getMessage() + "\nInsira um número válido");
        }
        return null;
    }
   
    public void carregaListaVoos(JTable tbl, String origem, String destino, JXDatePicker dtPartida){
        // Remove o modelo antigo
        tbl.removeAll();
        // Seta os parametros de busca
        voo = new Voo();
        voo.setOrigem(origem);
        voo.setDestino(destino);
        voo.setDtPartida(dtPartida.getDate());
        slctDAO = new SelectDAO();
        model = new VooTableModel(slctDAO.getVooComParametros(voo));
        tbl.setModel(model);     
    }
    
    public void carregaComboBoxPoltrona(JComboBox cmb, Voo voo){
        cmb.removeAllItems();
        List<VooPoltrona> lstPoltrona;
        slctDAO = new SelectDAO();
        VooPoltrona poltrona = new VooPoltrona();
        poltrona.setVooTag(voo);
        lstPoltrona = slctDAO.getVooPoltronaParametros(poltrona);
        for (VooPoltrona item : lstPoltrona) {
            cmb.addItem(new Item(item.getIdtbVooPoltrona(), Integer.toString(item.getPoltrona())));
        }
    }
    public FormUtils(){
        
    }
    
    public class ItemUF{
        public ItemUF (int id, String desc){
            this.ID = id;
            this.descricao = desc;
        }
        
        public int ID;
        public String descricao;
        
        @Override
        public String toString(){
           return this.descricao; 
        }
    }
    
    public class ItemEstado{
         public ItemEstado (int id, String desc){
            this.ID = id;
            this.descricao = desc;
        }
        
        public int ID;
        public String descricao;
        
        @Override
        public String toString(){
           return this.descricao; 
        }
    }
    
    public class ItemStatus{
        
         public ItemStatus (int id, String desc){
            this.ID = id;
            this.descricao = desc;
        }
        
        public int ID;
        public String descricao;
        
        @Override
        public String toString(){
           return this.descricao; 
        }
    }
    
    public class Item{
        
         public Item (int id, String desc){
            this.ID = id;
            this.descricao = desc;
        }
        
        public int ID;
        public String descricao;
               
        @Override
        public String toString(){
           return this.descricao; 
        }
    }
}
