/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import DAO.ClassesDB.Cliente;
import DAO.ClassesDB.Empresa;
import DAO.ClassesDB.Estado;
import DAO.ClassesDB.Status;
import DAO.ClassesDB.Voo;
import DAO.ClassesDB.VooPoltrona;
import DAO.SelectDAO;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author diego
 */
public class FormUtils{
    private SelectDAO slctDAO;
    private VooTableModel modelVoo;
    private VooPoltronaTableModel modelPoltrona;
    private Voo voo;
    private VooPoltrona poltrona;
    private static boolean isFuncionario = false; 
    public static Cliente cliente;
    public static Empresa empresa;
    public static String cpf;
   
    public void carregaDataAtual(JXDatePicker datePicker){
        datePicker.setDate(Date.from(Instant.now()));
    }
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
   
    
    public void carregaComboBoxEmpresa(JComboBox cmb) throws SQLException{
        slctDAO = new SelectDAO();
        int cont = 0;
        cmb.removeAllItems();
        ItemStatus st = null;
        List<Empresa> lst;
        lst = slctDAO.getEmpresas();
        for (Empresa empresa : lst) {
            st = new ItemStatus(cont, empresa.getFantasiaEmp());
            cmb.addItem(st);
            cont++;
        }    
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
        modelVoo = new VooTableModel(slctDAO.getVooComParametros(voo));
        tbl.setModel(modelVoo);     
    }
    
    public void carregaListaVooPoltrona(JTable tbl, Object obj){
        tbl.removeAll();
        poltrona = new VooPoltrona();
        poltrona.setVooTag(new Voo((String) obj));
        slctDAO = new SelectDAO();
        modelPoltrona = new VooPoltronaTableModel(slctDAO.getVooPoltronaParametros(poltrona));
        tbl.setModel(modelPoltrona);
    }
    
    public void carregaComboBoxPoltrona(JComboBox cmb, Object obj) throws SQLException{
        cmb.removeAllItems();
        try{
             List<VooPoltrona> lstPoltrona;
            slctDAO = new SelectDAO();
            VooPoltrona poltrona = new VooPoltrona();
            poltrona.setVooTag((Voo) obj);
            lstPoltrona = slctDAO.getPoltronaLivre(poltrona);
            for (VooPoltrona item : lstPoltrona) {
                cmb.addItem(new Item(item.getIdtbVooPoltrona(), Integer.toString(item.getPoltrona())));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       
    }
    
    public void carregaCidades(JComboBox cmb){
        cmb.removeAllItems();
        
        List<Item> lstItem = GerarDados.getCidades();
        for (Item item : lstItem) {
            cmb.addItem(item);
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
    
    public void montaFormEditarPoltrona(Object[] obj){
        JLabel lbStatus = (JLabel) obj[0];
        JLabel lbNumPoltrona = (JLabel) obj[1];
        JComboBox cmbStatus = (JComboBox) obj[2];
        poltrona = (VooPoltrona) obj[3];
        
        if(poltrona.getPoltrona() > 0 && poltrona.getPoltrona() < 10)
            lbNumPoltrona.setText("0" + String.valueOf(poltrona.getPoltrona()));
        else
            lbNumPoltrona.setText(String.valueOf(poltrona.getPoltrona()));
        
        cmbStatus.setSelectedIndex((poltrona.getStatus().getIdStatus()-1));
        
        if(poltrona.getLocalizador().getPassLocalizador() == null && cmbStatus.getSelectedIndex() > 0){
            lbStatus.setText("Poltrona indisponível!");
        } else if(cmbStatus.getSelectedIndex() > 0){
            lbStatus.setText("Poltrona indisponível!");
        }else{
            lbStatus.setText("Poltrona disponível");
        }
        
        
    }
    
    public void preencheComboBoxPoltrona(JComboBox cmb, Object obj){
        try {
            voo = (Voo) obj;
            poltrona.setVooTag(voo);
            slctDAO = new SelectDAO();
            List<VooPoltrona> lstPoltronaLivre = slctDAO.getPoltronaLivre(poltrona);
            for (VooPoltrona item : lstPoltronaLivre) {
                cmb.addItem(new Item(item.getPoltrona(), String.valueOf(item.getPoltrona())));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void isFuncionario(boolean s){
        isFuncionario = s;
    }
    
    public static boolean isFuncionario(){
        return isFuncionario;
    }
    
    public FormUtils(){
        
    }
    
    public static class ItemUF{
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
    
    public static class ItemEstado{
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
    
    public static class ItemStatus{
        
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
    
    public static class Item{
        
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
