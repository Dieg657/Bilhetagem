/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Utilidades.FormUtils.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author diego.soares
 */
public class GerarDados {
    private static List<Item> lstItem;
    public GerarDados(){
        
    }
    public static List<Item> getCidades(){
        lstItem = new ArrayList<>();
        Item st = null;
        for (Iterator<Vertice> it = GerarCidades.getCidadesConectadas().iterator(); it.hasNext();) {
            Vertice itemVertice = it.next();
            boolean add;
            add = lstItem.add(st);
        }
        return lstItem;
    }    
}
/*
    Terminar carregamento de Dados
*/