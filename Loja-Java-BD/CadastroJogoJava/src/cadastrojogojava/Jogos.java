package cadastrojogojava;

import java.io.Serializable;


public class Jogos implements Serializable {
    String jogos;
    int precos;
    int cont;
    int id;

    public int getPrecos() {
        return precos;
    }

    public void setPrecos(int precos) {
        this.precos = precos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCont() {
        return cont;
    }
    public void setQuantidade(int cont){
        this.cont = cont;
    }
    public void incrementaQuantidade(){
        this.cont++;
    }
    

    
    public Jogos(){}

    public String getJogos() {
        return jogos;
    }

    public void setJogos(String jogos) {
        this.jogos = jogos;
    }

    public int getPreco() {
        return precos;
    }

    public void setPreco(int preco) {
        this.precos = preco;
    }
    
    
}
