/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import DAO.ClassesDB.Estado;
import DAO.ClassesDB.Status;
import DAO.SelectDAO;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author diego
 */
public class FormUtils{
    private SelectDAO slctDAO;
   
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
        ItemStatus st = null;
        st = new ItemStatus(1, "Masculino");
        cmb.addItem(st);
        st = new ItemStatus(2, "Feminino");
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
}
