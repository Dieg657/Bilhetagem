/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author puc
 */
public final class GerarCidades {
    int ID = 0;
    private final String[] cidades = new String[27];
    private ArrayList<Vertice> listaCidades = new ArrayList<>();
    
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
        cidades[0] = "Brasilia";
        cidades[1] = "Goiania";
        cidades[2] = "Campo Grande";
        cidades[3] = "Cuiaba";
        cidades[4] = "Belo Horizonte";
        cidades[5] = "Palmas";
        cidades[6] = "Curitiba";
        cidades[7] = "Florianópolis";
        cidades[8] = "Porto Alegre";
        cidades[9] = "São Paulo";
        cidades[10] = "Rio de Janeiro";
        cidades[11] = "Vitória";
        cidades[12] = "Salvador";
        cidades[13] = "Recife";
        cidades[14] = "Maceió";
        cidades[15] = "Fortaleza";
        cidades[16] = "São Luíz";
        cidades[17] = "Belém";
        cidades[18] = "João Pessoa";
        cidades[19] = "Teresina";
        cidades[20] = "Rio Branco";
        cidades[21] = "Natal";
        cidades[22] = "Aracajú";
        cidades[23] = "Porto Velho";
        cidades[24] = "Boa Vista";
        cidades[25] = "Macapá";
        cidades[26] = "Manaus";        
    }
    
    public void criaConexaoCidades(){
        for (int i = 0; i < 3/*listaCidades.size()*/; i++) {
            for (int j = 0; j < 3/*listaCidades.size()*/; j++) {
                if(i != j)
                listaCidades.get(i).criarConexao(1, listaCidades.get(j));
            }
        }
    }
    
    public ArrayList<Vertice> getCidadesConectadas(){
        return listaCidades;
    }
    
    public ArrayList<Vertice> caminhoMinimo(Vertice origem, Vertice destino){
        
        /* Inicia os vetores de assistencia */
        int[] dist = new int[27];
        int[] antecessor = new int[27];
        
        for (int i = 0; i < 27; i++) {
            dist[i] = Integer.MAX_VALUE;
            antecessor[i] = -1;
        }
        
        /* Inicializa  distancia da origem */       
        dist[origem.getID()] = 0;
  
        /* Fila de prioridades */
        
        /* Reseta marcador de vertice
           Percorrendo a lista de cidades atraves de um iterador
        */
        for (Iterator<Vertice> iterator = listaCidades.iterator(); iterator.hasNext();) {
            iterator.next().resetaMarcador();
        }
        Vertice aux = origem;
        Vertice proxAnalisar = null;
        int pesoAresta;
        boolean primeiraExec = true;
        while(aux.getMarcador() == false){              
            for (Iterator<Aresta> iterator = aux.getConexaoDaCidade().iterator(); iterator.hasNext();) {          
                if(primeiraExec && iterator.next().getDestino() == destino){
                    System.out.println("Removeu o link direto");
                    primeiraExec = false;
                }else{
                    pesoAresta = dist[aux.getID()] + iterator.next().getPeso();
                    if (pesoAresta < dist[iterator.next().getDestino().getID()]) {
                        dist[iterator.next().getDestino().getID()] = pesoAresta;
                        antecessor[iterator.next().getDestino().getID()] = aux.getID();
                        proxAnalisar = iterator.next().getDestino();
                    }
                }
            }
            aux.ativaMarcador();
            aux = proxAnalisar;
        }
        
        ArrayList<Vertice> resultado = new ArrayList<>();
        int cidade = destino.getID();
        resultado.add(listaCidades.get(destino.getID()));
        while(cidade != -1){
            resultado.add(listaCidades.get(antecessor[cidade]));
            cidade = antecessor[cidade];
        }
        for (int i = resultado.size(); i > 0; i--) {
            resultado.get(i).imprimirCidade();
        }
        return resultado;
    }
    
}

