/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import DAO.ClassesDB.Empresa;
import DAO.ClassesDB.Voo;
import Utilidades.FormUtils.Item;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author diego.soares
 */
public class GerarDados {
    private static Random random;
    private static List<Item> lstItem;
    private static List<Empresa> lstEmp;
    private static Voo voo;
    private final FormUtils formUtil;
    
    public GerarDados(){
        formUtil = new FormUtils();
    }
    
    public static List<Item> getCidades(){
        lstItem = new ArrayList<>();
        
        for (Vertice item : GerarCidades.getCidadesConectadas()) {
                lstItem.add(new Item(item.getID(), item.getCidade()));
        }
        return lstItem;
    }
    
    public static void geraVoos(){
        random = new Random(LocalTime.now().toSecondOfDay());
        try {
            for (Empresa item : Facade.selectDataDB("select").getEmpresas()) {
                System.out.println("Empresa:" + item.getFantasiaEmp() + ", CNPJ: " + item.getCnpj());
                for (int i = 0; i < 10; i++) {
                    try{
                        voo = new Voo();
                        
                        voo.setVooTag(gerarIDVoo(item.getFantasiaEmp()).toUpperCase());
                        voo.setOrigem(getCidades().get(cidadeAleatoria(26)).descricao);
                        voo.setDestino(getCidades().get(cidadeAleatoria(26)).descricao);
                        voo.setDtPartida(new java.sql.Date(LocalTime.now().toSecondOfDay()));
                        voo.setHrPartida(new java.sql.Time(LocalTime.now().toSecondOfDay() - (random.nextInt(1440)+60)));
                        voo.setCpnjEmp(new Empresa(item.getCnpj()));
                        voo.setVlVoo(precoAleatorio(300, 1500));
                        
                        System.out.println("-----------------------Setando o objeto----------------------");
                        System.out.println("IDVoo: " + voo.getVooTag()); 
                        System.out.println("Origem: " + voo.getOrigem());
                        System.out.println("Destino: " + voo.getDestino());
                        System.out.println("Data: " + voo.getDtPartida());
                        System.out.println("Hora: " + voo.getHrPartida());
                        System.out.println("CNPJ: " + voo.getCpnjEmp().getCnpj());
                        System.out.println("Valor: " + voo.getVlVoo());
                        System.out.println("-----------------------Objeto setado--------------------------");
                        Facade.getInstance().insertDataDB("insert", voo);
                    }catch(UnsupportedEncodingException ex){
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\nNão foi possível obter as empresas!");
        }
    }
    
    private static String gerarIDVoo(String empresa) throws UnsupportedEncodingException{
       byte[] bytes = empresa.getBytes("UTF-8");
       UUID uuid1 = UUID.nameUUIDFromBytes(bytes);
       bytes = Integer.toString(random.nextInt()+1).getBytes();
       UUID uuid2 = UUID.nameUUIDFromBytes(bytes);
       return uuid1.toString().substring(0, 3) +"-"+ uuid2.toString().substring(0, 3);
    }
    
    private static int cidadeAleatoria(int semente){
        return random.nextInt(semente);
    }
    
    private static int precoAleatorio(int minimo, int maximo){
        return random.nextInt(maximo-minimo)+minimo;
    }
}
/*
    Terminar carregamento de Dados
*/