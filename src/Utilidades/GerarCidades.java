/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
/**
 *
 * @author puc
 */
public class GerarCidades {
    public static int ID = 0;
    public static String[] cidades = new String[27];
    public static ArrayList<Vertice> listaCidades = new ArrayList<>();
    
    public GerarCidades(){        
        criarMapa();
    }
    
    private void criarMapa(){
        populaArray();
        for (String cidade : cidades) {
           listaCidades.add(new Vertice(ID, cidade));
           ID++;
        }    
    }
    
    private void populaArray(){
        
        /* Centro Oeste */
        cidades[0] = "Brasilia";
        cidades[1] = "Goiania";
        cidades[2] = "Campo Grande";
        cidades[3] = "Cuiaba";

        /* Sudeste */
        cidades[4] = "Belo Horizonte";
        cidades[9] = "São Paulo";
        cidades[10] = "Rio de Janeiro";
        cidades[11] = "Vitória";
        
        /* Sul */
        cidades[6] = "Curitiba";
        cidades[7] = "Florianópolis";
        cidades[8] = "Porto Alegre";
        
        /* Nordeste */
        cidades[12] = "Salvador";
        cidades[13] = "Recife";
        cidades[14] = "Maceió";
        cidades[15] = "Fortaleza";
        cidades[16] = "São Luíz";
        cidades[18] = "João Pessoa";
        cidades[19] = "Teresina";
        cidades[21] = "Natal";
        cidades[22] = "Aracajú";
        
        /* Norte */
        cidades[17] = "Belém";
        cidades[5] = "Palmas";
        cidades[23] = "Porto Velho";
        cidades[24] = "Boa Vista";
        cidades[25] = "Macapá";
        cidades[26] = "Manaus";
        cidades[20] = "Rio Branco";        
    }
    
    public void criaConexaoCidades(){
        Random gerador = new Random();
        
        /* Centro Oeste */
        /* Brasilia - 0 */
        listaCidades.get(0).criarConexao(1, listaCidades.get(5));
        listaCidades.get(0).criarConexao(1, listaCidades.get(1));
        listaCidades.get(0).criarConexao(1, listaCidades.get(4));
        listaCidades.get(0).criarConexao(1, listaCidades.get(3));
        /* Goiania - 1 */
        listaCidades.get(1).criarConexao(1, listaCidades.get(0));
        listaCidades.get(1).criarConexao(1, listaCidades.get(9));
        listaCidades.get(1).criarConexao(1, listaCidades.get(2));
        listaCidades.get(1).criarConexao(1, listaCidades.get(3));
        listaCidades.get(1).criarConexao(1, listaCidades.get(4));
        /* Campo Grande - 2 */
        listaCidades.get(2).criarConexao(1, listaCidades.get(6));
        listaCidades.get(2).criarConexao(1, listaCidades.get(9));
        listaCidades.get(2).criarConexao(1, listaCidades.get(1));
        listaCidades.get(2).criarConexao(1, listaCidades.get(3));
        /* Cuiabá - 3 */
        listaCidades.get(3).criarConexao(1, listaCidades.get(1));
        listaCidades.get(3).criarConexao(1, listaCidades.get(5));
        listaCidades.get(3).criarConexao(1, listaCidades.get(2));
        listaCidades.get(3).criarConexao(1, listaCidades.get(23));
        
        /* Sudeste */
        /* Belo Horizonte - 4 */
        listaCidades.get(4).criarConexao(1, listaCidades.get(11));
        listaCidades.get(4).criarConexao(1, listaCidades.get(9));
        listaCidades.get(4).criarConexao(1, listaCidades.get(10));
        listaCidades.get(4).criarConexao(1, listaCidades.get(0));
        
        /* São Paulo - 9 */
        listaCidades.get(9).criarConexao(1, listaCidades.get(10));
        listaCidades.get(9).criarConexao(1, listaCidades.get(4));
        listaCidades.get(9).criarConexao(1, listaCidades.get(6));
        listaCidades.get(9).criarConexao(1, listaCidades.get(2));
        listaCidades.get(9).criarConexao(1, listaCidades.get(1));
        /* Rio de Janeiro - 10 */
        listaCidades.get(10).criarConexao(1, listaCidades.get(4));
        listaCidades.get(10).criarConexao(1, listaCidades.get(9));
        listaCidades.get(10).criarConexao(1, listaCidades.get(11));
        /* Vitória - 11*/
        listaCidades.get(11).criarConexao(1, listaCidades.get(4));
        listaCidades.get(11).criarConexao(1, listaCidades.get(10));
        listaCidades.get(11).criarConexao(1, listaCidades.get(12));
        
        /* Sul */
        /* Curitiba - 6 */
        listaCidades.get(6).criarConexao(1, listaCidades.get(9));
        listaCidades.get(6).criarConexao(1, listaCidades.get(7));
        listaCidades.get(6).criarConexao(1, listaCidades.get(2));
        /* Florianopolis - 7 */
        listaCidades.get(7).criarConexao(1, listaCidades.get(6));
        listaCidades.get(7).criarConexao(1, listaCidades.get(8));
        /* Porto Alegre - 8 */
        listaCidades.get(8).criarConexao(1, listaCidades.get(7));
        
        /* Norte */
        /* Belem - 17 */
        listaCidades.get(17).criarConexao(1, listaCidades.get(16));
        listaCidades.get(17).criarConexao(1, listaCidades.get(25));
        listaCidades.get(17).criarConexao(1, listaCidades.get(5));
        /* Palmas - 5 */
        listaCidades.get(5).criarConexao(1, listaCidades.get(0));
        listaCidades.get(5).criarConexao(1, listaCidades.get(3));
        listaCidades.get(5).criarConexao(1, listaCidades.get(12));
        listaCidades.get(5).criarConexao(1, listaCidades.get(19));
        listaCidades.get(5).criarConexao(1, listaCidades.get(16));
        listaCidades.get(5).criarConexao(1, listaCidades.get(17));
        /* Porto Velho - 23 */
        listaCidades.get(23).criarConexao(1, listaCidades.get(3));
        listaCidades.get(23).criarConexao(1, listaCidades.get(20));
        listaCidades.get(23).criarConexao(1, listaCidades.get(26));
        /* Boa Vista - 24 */ 
        listaCidades.get(24).criarConexao(1, listaCidades.get(26));
        listaCidades.get(24).criarConexao(1, listaCidades.get(25));
        /* Macapá - 25 */ 
        listaCidades.get(25).criarConexao(1, listaCidades.get(26));
        listaCidades.get(25).criarConexao(1, listaCidades.get(17));
        listaCidades.get(25).criarConexao(1, listaCidades.get(24));
        /* Manaus - 26 */
        listaCidades.get(26).criarConexao(1, listaCidades.get(24));
        listaCidades.get(26).criarConexao(1, listaCidades.get(25));
        listaCidades.get(26).criarConexao(1, listaCidades.get(23));
        listaCidades.get(26).criarConexao(1, listaCidades.get(20));
        listaCidades.get(26).criarConexao(1, listaCidades.get(5));
        /* Rio Branco 20 */
        listaCidades.get(20).criarConexao(1, listaCidades.get(26));
        listaCidades.get(20).criarConexao(1, listaCidades.get(23));
        
        /* Nordeste */
        /* Salvador - 12 */
        listaCidades.get(12).criarConexao(1, listaCidades.get(5));
        listaCidades.get(12).criarConexao(1, listaCidades.get(0));
        listaCidades.get(12).criarConexao(1, listaCidades.get(11));
        listaCidades.get(12).criarConexao(1, listaCidades.get(22));
        /* Recife - 13 */
        listaCidades.get(13).criarConexao(1, listaCidades.get(18));
        listaCidades.get(13).criarConexao(1, listaCidades.get(14));
        /* Maceio - 14 */
        listaCidades.get(14).criarConexao(1, listaCidades.get(22));
        listaCidades.get(14).criarConexao(1, listaCidades.get(13));
        /* Fortaleza - 15 */
        listaCidades.get(15).criarConexao(1, listaCidades.get(19));
        listaCidades.get(15).criarConexao(1, listaCidades.get(16));
        listaCidades.get(15).criarConexao(1, listaCidades.get(21));
        /* São Luiz - 16 */
        listaCidades.get(16).criarConexao(1, listaCidades.get(19));
        listaCidades.get(16).criarConexao(1, listaCidades.get(15));
        listaCidades.get(16).criarConexao(1, listaCidades.get(17));
        /* João Pessoa - 18 */
        listaCidades.get(18).criarConexao(1, listaCidades.get(21));
        listaCidades.get(18).criarConexao(1, listaCidades.get(13));
        /* Teresina - 19 */
        listaCidades.get(19).criarConexao(1, listaCidades.get(21));
        listaCidades.get(19).criarConexao(1, listaCidades.get(18));
        listaCidades.get(19).criarConexao(1, listaCidades.get(15));
        listaCidades.get(19).criarConexao(1, listaCidades.get(17));
        /* Natal 21 */
        listaCidades.get(21).criarConexao(1, listaCidades.get(15));
        listaCidades.get(21).criarConexao(1, listaCidades.get(18));
        /* Aracaju - 22 */
        listaCidades.get(22).criarConexao(1, listaCidades.get(14));
        listaCidades.get(22).criarConexao(1, listaCidades.get(12));

        for (int i = 0; i < listaCidades.size(); i++) {
            for (int j = 0; j < listaCidades.size(); j++) {
                if(i != j){
                    if(verificaSeConectado(listaCidades.get(i), listaCidades.get(j))){
                        /* Se já existir conexao ignora */
                    }else{
                        listaCidades.get(i).criarConexao(gerador.nextInt(100), listaCidades.get(j));
                    }
                }
            }
        }
    }
    
    public ArrayList<Vertice> getCidadesConectadas(){
        return listaCidades;
    }
    
    public static ArrayList<Vertice> caminhoMinimo(Vertice origem, Vertice destino){
        
        /* Inicia os vetores de assistencia */
        int[] dist = new int[27];
        int[] antecessor = new int[27];
        
        for (int i = 0; i < 27; i++) {
            dist[i] = Integer.MAX_VALUE;
            antecessor[i] = -1;
        }
        
        /* Inicializa  distancia da origem */       
        dist[origem.getID()] = 0;
  
        
       
        Vertice proxAnalisar = null;
        int pesoAresta;
        LinkedList<Vertice> cidade = new LinkedList<>();
        
        cidade.push(origem);
        while(!cidade.isEmpty()){
            /* Obtém a cidade que está na lista */
            Vertice cidadeAtual = cidade.peekFirst();
            /* Obtém as conexões (arestas) da cidade em análise */
            ArrayList<Aresta> conexao = cidadeAtual.getConexaoDaCidade();
            /* Remove o vertice atual em análise da lista */
            for(int i = 0; i < conexao.size(); i++){
                pesoAresta = dist[cidadeAtual.getID()] + conexao.get(i).getPeso();
                Vertice cidadeDestino = conexao.get(i).getDestino(); 
                if(dist[cidadeDestino.getID()] > pesoAresta){ 
                    dist[cidadeDestino.getID()] = pesoAresta;
                    antecessor[cidadeDestino.getID()] = cidadeAtual.getID();
                    /* Coloca a cidade descoberta para ser análisada */   
                    cidade.add(cidadeDestino);
                }
            }
            cidade.pollFirst();
        }
                
        ArrayList<Vertice> resultado = new ArrayList<>();
        int idxCidade = destino.getID();
        resultado.add(listaCidades.get(destino.getID()));
        
        while(idxCidade != origem.getID()){
            resultado.add(listaCidades.get(antecessor[idxCidade]));
            idxCidade = antecessor[idxCidade];
        } 
        
        for (int i = resultado.size(); i > 0; i--) {
            resultado.get(i-1).imprimirCidade();
        }
       
        return resultado;
    }
    
    public boolean verificaSeConectado(Vertice origem, Vertice destino){
        for (Aresta next : origem.getConexaoDaCidade()) {
            if(next.getDestino().equals(destino))
                return true;
        }
        return false;
    }
}
