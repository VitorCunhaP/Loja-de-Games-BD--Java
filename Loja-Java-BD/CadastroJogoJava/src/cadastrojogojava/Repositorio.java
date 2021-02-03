package cadastrojogojava;


import java.io.Serializable;
import java.util.LinkedList;


public class Repositorio implements Serializable {
    
    int id;
    
    LinkedList<Jogos> lojinha = new LinkedList<Jogos>();
    LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
