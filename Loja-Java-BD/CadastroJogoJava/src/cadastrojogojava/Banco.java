package cadastrojogojava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banco {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
				//Class.forName("com.mysql.jdbc.Driver");
                Class.forName("org.postgresql.Driver");

                String host = "localhost";
                String port = "5432";
                String database = "postgres";
                String user = "postgres";
                String pass = "123";
				//String url = "jdbc:mysql://"+ host +":" + port +"/"+ database;
                String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
                connection = DriverManager.getConnection(url, user, pass);
              }
            catch (ClassNotFoundException e) {
                //TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return connection;   }
   public static void close() {
        if (connection == null){
        throw new RuntimeException("Nenhum conexao aberta");
        }
        else{
            try{
                connection.close();
            }
            catch (SQLException e){
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }
        }
    }
    private static byte[] converterUsuarioParaByte(Usuario u) {
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream ous;
            ous = new ObjectOutputStream(bao);
            ous.writeObject(u);
            return bao.toByteArray();
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    return null;
    }
    private static Usuario converterByteParaUsuario(byte[] UsuarioAsByte) {
        try {
            ByteArrayInputStream bao = new ByteArrayInputStream(UsuarioAsByte);
            ObjectInputStream ous;
            ous = new ObjectInputStream(bao);
            return (Usuario) ous.readObject();
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    return null;
    }
    public static void salvarUsuario(Usuario u) {
        try {
                Connection con = Banco.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO usuario(id, username, objeto) values (?, ?, ?)");
                ps.setInt(1, u.getId());
                ps.setString(2, u.getUsername());
                ps.setBytes(3, converterUsuarioParaByte(u));
                ps.execute();
        } 
        catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    public static Usuario carregarUsuario(int id) {
    try {
      Connection con = Banco.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT usuario FROM usuario WHERE id = ?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      rs.next();
      return converterByteParaUsuario(rs.getBytes(1));

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
   }
    
     public static LinkedList<Usuario> listaUsuarios(){
        LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT objeto FROM usuario");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Usuario u = converterByteParaUsuario(rs.getBytes(1));
                usuarios.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public static void deletaUsuario(int id){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete FROM usuario WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void atualizaBancoUsuario(Usuario usuario){
        deletaUsuario(usuario.getId());
        salvarUsuario(usuario);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        private static byte[] converterJogosParaByte(Jogos j) {
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream ous;
            ous = new ObjectOutputStream(bao);
            ous.writeObject(j);
            return bao.toByteArray();
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    return null;
    }
    private static Jogos converterByteParaJogos(byte[] JogosAsByte) {
        try {
            ByteArrayInputStream bao = new ByteArrayInputStream(JogosAsByte);
            ObjectInputStream ous;
            ous = new ObjectInputStream(bao);
            return (Jogos) ous.readObject();
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    return null;
    }
    public static void salvarJogos(Jogos j) {
        try {
                Connection con = Banco.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO lojinha (id, nome, preço, quantidade, jogos) values (?, ?, ?, ?, ?)");
                ps.setInt(1, j.getId());
                ps.setString(2, j.getJogos());
                ps.setFloat(3, j.getPreco());
                ps.setInt(4, j.getCont());
                ps.setBytes(5, converterJogosParaByte(j));
                ps.execute();
        } 
        catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    public static Jogos carregarJogos(int id) {
    try {
      Connection con = Banco.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT jogos FROM lojinha WHERE id = ?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      rs.next();
      return converterByteParaJogos(rs.getBytes(1));

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
   }
    
     public static LinkedList<Jogos> listaJogos(){
        LinkedList<Jogos> jogos = new LinkedList<Jogos>();
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT jogos FROM lojinha");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Jogos j = converterByteParaJogos(rs.getBytes(1));
                jogos.add(j);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogos;
    }
    public static void deletaJogos(int id){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete FROM lojinha WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void atualizaBancoJogos(Jogos jogos){
        deletaJogos(jogos.getId());
        salvarJogos(jogos);
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        private static byte[] converterComprasParaByte(Compras c) {
            try {
                ByteArrayOutputStream bao = new ByteArrayOutputStream();
                ObjectOutputStream ous;
                ous = new ObjectOutputStream(bao);
                ous.writeObject(c);
                return bao.toByteArray();
            } 
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        return null;
        }
        private static Compras converterByteParaCompras(byte[] ComprasAsByte) {
            try {
                ByteArrayInputStream bao = new ByteArrayInputStream(ComprasAsByte);
                ObjectInputStream ous;
                ous = new ObjectInputStream(bao);
                return (Compras) ous.readObject();
            } 
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        return null;
        }
        public static void salvarCompras(Compras c) {
            try {
                    Connection con = Banco.getConnection();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO compras (id, username, jogo, objeto) values (?, ?, ?, ?)");
                    ps.setInt(1, c.getId());
                    ps.setString(2, c.getUsername());
                    ps.setString(3, c.getJogo());
                    ps.setBytes(4, converterComprasParaByte(c));
                    ps.execute();
            } 
            catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
        public static Compras carregarCompras(int id) {
        try {
          Connection con = Banco.getConnection();
          PreparedStatement ps = con.prepareStatement("SELECT compras FROM compras WHERE id = ?");
          ps.setInt(1, id);
          ResultSet rs = ps.executeQuery();
          rs.next();
          return converterByteParaCompras(rs.getBytes(1));

        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return null;
       }

         public static LinkedList<Compras> listaCompras(){
            LinkedList<Compras> compras = new LinkedList<Compras>();
            try{
                Connection con = Banco.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT objeto FROM compras");
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Compras c = converterByteParaCompras(rs.getBytes(1));
                    compras.add(c);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return compras;
        }
        public static void deletaCompras(int id){
            try{
                Connection con = Banco.getConnection();
                PreparedStatement ps = con.prepareStatement("Delete FROM compras WHERE id = ?");
                ps.setInt(1, id);
                ps.executeUpdate();

                }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void atualizaBancoCompras(Compras compras){
            deletaCompras(compras.getId());
            salvarCompras(compras);
        }
    }

