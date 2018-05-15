/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author diego
 */
public abstract class CompanhiaVoo {
 
    private String _idVoo;
    private int _horaVOo;
    private String _destino;
    private String _origem;
    

    public String getIdVoo() {
        return _idVoo;
    }

    public void setIdVoo(String _idVoo) {
        this._idVoo = _idVoo;
    }

    public int getHoraVOo() {
        return _horaVOo;
    }


    public void setHoraVOo(int _horaVOo) {
        this._horaVOo = _horaVOo;
    }

    public String getDestino() {
        return _destino;
    }

    public void setDestino(String _destino) {
        this._destino = _destino;
    }


    public String getOrigem() {
        return _origem;
    }

    public void setOrigem(String _origem) {
        this._origem = _origem;
    }
    
}
