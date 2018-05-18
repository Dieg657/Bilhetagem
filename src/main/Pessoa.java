package main;

/**
 *
 * @author diego
 */
public abstract class Pessoa {
    private String _nome;
    private long _cpf;
    private String _rg;
    private long _telefone;
    private long _celular;

    public String getNome() {
        return _nome;
    }

    public void setNome(String _nome) {
        this._nome = _nome;
    }

    public long getCpf() {
        return _cpf;
    }

    public void setCpf(long _cpf) {
        this._cpf = _cpf;
    }

    public String getRg() {
        return _rg;
    }

    public void setRg(String _rg) {
        this._rg = _rg;
    }

    public long getTelefone() {
        return _telefone;
    }

    public void setTelefone(long _telefone) {
        this._telefone = _telefone;
    }

    public long getCelular() {
        return _celular;
    }

    public void setCelular(long _celular) {
        this._celular = _celular;
    }
    
    public abstract void setSexo(String _sexo);
    public abstract String getSexo();
}

final class Mulher extends Pessoa{
   
    private String _sexo;
        
    @Override
    public void setSexo(String _sexo) {
        this._sexo = _sexo;
    }

    @Override
    public String getSexo() {
        return this._sexo;
    }
    
     public Mulher(String nome, String sexo){
        setSexo(sexo);
        setNome(nome);
    }
}

final class Homem extends Pessoa{
    private String _sexo;
    
    public Homem(String nome, String sexo){
        setSexo(sexo);
        setNome(nome);
    }
         
    @Override
    public void setSexo(String _sexo) {
        this._sexo = _sexo;
    }

    @Override
    public String getSexo() {
        return this._sexo;
    }
}
