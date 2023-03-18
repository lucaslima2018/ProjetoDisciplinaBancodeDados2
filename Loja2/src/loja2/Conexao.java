package loja2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {

    public Connection con;
    public Boolean conectado = false;

    public void ConectarFb() {
        String msg = "";
        if (conectado == false) {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
                con = DriverManager.getConnection("jdbc:firebirdsql:localhost:C:/Users/Lucas/Documents/Bancos/LOJA2.FDB",
                        "SYSDBA", "masterkey");
                con.setAutoCommit(true);
                msg = "Conectado Firebird!";
                //JOptionPane.showMessageDialog(null,"Conectado Firebird");
                conectado = true;
            } catch (Exception e) {
                conectado = false;
                msg = "Houve um erro de conexão Firebird: " + e.getMessage();
                //System.out.println(e);
            }
        }
        System.out.println(msg);
    }

    public void DesconectarFb() {

        if (conectado) {
            try {
                con.close();
                JOptionPane.showMessageDialog(null, "Desconectado Firebird");
            } catch (Exception e) {/**/

            }
        }
    }

    public void inserirMarca(String nome) {
        try {

            String query = "INSERT INTO MARCA (NOME)"
                    + "values ('" + nome + "')";
            Statement st = (Statement) con.createStatement();
            int resultado = st.executeUpdate(query);
            if (resultado == 1) {
                System.out.println("Marca cadastrada com sucesso");
                JOptionPane.showMessageDialog(null, "Marca cadastrada com sucesso");
                // JOptionPane.showMessageDialog(this,"Marca cadastrada com sucesso");
            }
            System.out.println(resultado);
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(this, e);}   
        }
    }

    public void inserirTipo(String nome) {
        try {

            String query = "INSERT INTO TIPO (NOME)"
                    + "values ('" + nome + "')";
            Statement st = (Statement) con.createStatement();
            int resultado = st.executeUpdate(query);
            if (resultado == 1) {
                System.out.println("Tipo cadastrado com sucesso");
                JOptionPane.showMessageDialog(null, "Tipo cadastrado com sucesso");
                // JOptionPane.showMessageDialog(this,"Marca cadastrada com sucesso");
            }
            System.out.println(resultado);
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(this, e);}   
        }
    }
}
