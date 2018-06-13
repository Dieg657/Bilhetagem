/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import DAO.ClassesDB.Cliente;
import DAO.ClassesDB.Empresa;
import DAO.ClassesDB.Estado;
import DAO.ClassesDB.Passagem;
import DAO.ClassesDB.Status;
import DAO.ClassesDB.Voo;
import DAO.ClassesDB.VooPoltrona;
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
    private static List<Cliente> lstCliente;
    private static List<Voo> lstVoo;
    private static List<VooPoltrona> lstPoltrona;
    private static Voo voo;
    private static Cliente cliente;
    private static Passagem passagem;
    private static VooPoltrona poltrona;
    private final  FormUtils formUtil;
    private static List<Passagem> lstPassagem;
    
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
    
    /*
        Ordem de inserção
        
        Empresa
        Voos
        Clientes
        Passagens
        V
    */
    
    public static void geraVoos() throws Exception{
        random = new Random(LocalTime.now().toSecondOfDay());
        lstVoo = new ArrayList<>();
        try {
            for (Empresa item : Facade.selectDataDB("select").getEmpresas()) {
                System.out.println("Empresa:" + item.getFantasiaEmp() + ", CNPJ: " + item.getCnpj());
                for (int i = 0; i < 10; i++) {
                    voo = new Voo();
                        
                        voo.setVooTag(gerarIDVoo(item.getFantasiaEmp()).toUpperCase());
                        voo.setOrigem(getCidades().get(cidadeAleatoria(26)).descricao);
                        voo.setDestino(getCidades().get(cidadeAleatoria(26)).descricao);
                        voo.setDtPartida(new java.sql.Date(LocalTime.now().toSecondOfDay()));
                        voo.setHrPartida(new java.sql.Time(LocalTime.now().toSecondOfDay() - (random.nextInt()+60)));
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
                        lstVoo.add(voo);
                    
                        
                }
            }
            for (Voo itemVoo : lstVoo) {       
                Facade.getInstance().insertDataDB("insert", itemVoo);    
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
    
    public static String gerarLocalizador(String idVoo) throws UnsupportedEncodingException{
       byte[] bytes = idVoo.getBytes("UTF-8");
       UUID uuid1 = UUID.nameUUIDFromBytes(bytes);
       bytes = Integer.toString(random.nextInt()+1).getBytes();
       UUID uuid2 = UUID.nameUUIDFromBytes(bytes);
       return uuid1.toString().substring(0, 3) +"-"+ uuid2.toString().substring(0, 3);
    }
    
    public static void gerarCliente() throws UnsupportedEncodingException{
        
        random = new Random(LocalTime.now().toSecondOfDay());
        lstCliente = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            cliente = new Cliente(String.valueOf(cpfAleatorio(11111111, 999999999)));
            cliente.setNmCli(nomesAleatorios() + " " + sobrenomesAleatorios());
            cliente.setIdufCli(new Estado(numeroAleatório(0, 26)));
            cliente.setIdestCli(new Estado(numeroAleatório(0, 26)));
            cliente.setDtnascCli(new java.sql.Date(LocalDate.now().toEpochDay()));
            lstCliente.add(cliente);
        }
        
        for (Cliente item : lstCliente) {
            Facade.getInstance().insertDataDB("insert", item);
        }
    }
    
    public static void gerarPassagens() throws UnsupportedEncodingException, Exception{
        lstPassagem = new ArrayList<>();
        lstPoltrona = new ArrayList<>();
        for (Voo itemVoo : lstVoo) {
            for (int i = 0; i < 54; i++) {
                passagem = new Passagem(gerarLocalizador(itemVoo.getVooTag()));
                passagem.setCpfPassageiro(lstCliente.get(numeroAleatório(0, lstCliente.size())));
                passagem.setPassBagagem(numeroAleatório(1, 60));
                lstPassagem.add(passagem);
                
                poltrona = new VooPoltrona(0);
                poltrona.setLocalizador(passagem);
                poltrona.setStatus(new Status(2));
                poltrona.setVooTag(itemVoo);
                poltrona.setPoltrona(i+1);
                lstPoltrona.add(poltrona);
                
            }
        }
                
        try {
            for (Passagem item : lstPassagem) {
                Facade.getInstance().insertDataDB("insert", item);
            }
            for (VooPoltrona item : lstPoltrona) {
                Facade.getInstance().updateDataDB("update", item);
                System.out.println("ID Voo: " + item.getVooTag().getVooTag());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    private static int cidadeAleatoria(int semente){
        return random.nextInt(semente);
    }
    
    private static int precoAleatorio(int minimo, int maximo){
        return random.nextInt(maximo-minimo)+minimo;
    }
    
    private static int numeroAleatório(int minimo, int maximo){
        return random.nextInt(maximo-minimo)+minimo;
    }
    
    private static long cpfAleatorio(int minimo, int maximo){
        return random.nextInt(maximo-minimo)+minimo;
    }
    
    private static String nomesAleatorios(){
        List<String> lstNomes = new ArrayList<>();
        lstNomes.add("João"); lstNomes.add("Milton"); lstNomes.add("Zlatan");
        lstNomes.add("Thiago"); lstNomes.add("Neymar"); lstNomes.add("Edison");
        lstNomes.add("Fábio"); lstNomes.add("Mario Jorge"); lstNomes.add("Robert");
        return lstNomes.get(numeroAleatório(0, 8));
    }
    
    private static String sobrenomesAleatorios(){
        List<String> lstSobrenome = new ArrayList<>();
        lstSobrenome.add("da Silva"); lstSobrenome.add("Nascimento"); lstSobrenome.add("Lewandowski");
        lstSobrenome.add("Santos"); lstSobrenome.add("Cavani"); lstSobrenome.add("Silva");
        lstSobrenome.add("Lobo Zagallo"); lstSobrenome.add("Ibrahimovic"); lstSobrenome.add("Robert");
        return lstSobrenome.get(numeroAleatório(0, 8));
    }
    
}
/*
    Terminar carregamento de Dados
*/