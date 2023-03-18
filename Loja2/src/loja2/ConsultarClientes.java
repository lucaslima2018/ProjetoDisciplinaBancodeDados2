/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja2;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUCAS
 */
public class ConsultarClientes extends javax.swing.JFrame {

    public Connection con;
    DefaultTableModel model;
    
    public ConsultarClientes() {
        initComponents();
        ConectarDireto();
        setLocationRelativeTo(null);
        setIcon();
        model = ((DefaultTableModel) jTClientes.getModel());
        consultar();
    }
    
    
    public Boolean conectado = false;
    
    public void ConectarDireto() {
        String msg = "";
        if (conectado == false) {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
                con = DriverManager.getConnection("jdbc:firebirdsql:localhost:C:/Users/LUCAS/Documents/Bancos/LOJA3.FDB",
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLClientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTClientes = new javax.swing.JTable();
        jBVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar Clientes");
        setResizable(false);

        jLClientes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLClientes.setText("Clientes Cadastrados:");

        jTClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data de Nascimento", "Cpf", "Rg", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTClientes);

        jBVoltar.setText("Voltar");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLClientes)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        new PaginaInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    
    public void consultar() {
        String query;
        try {
            query = "SELECT * FROM CLIENTE";

            Statement st = (Statement) con.createStatement();

            ResultSet rs = st.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {

                    
                    String nome = rs.getString("NOME");
                    String datanascimento = rs.getString("DATANASCIMENTO");
                    String datanasc = convertData(datanascimento, '-');
                    String cpf = rs.getString("CPF");
                    String rg = rs.getString("RG");
                    String telefone = rs.getString("TELEFONE");

                    model.addRow(new Object[]{nome, datanasc, cpf, rg, telefone});

                }
            }
        } catch (Exception e) {
        }
    }
    
    
    public String convertData(String data, char simbolo) {
        ArrayList<String> x = new ArrayList<String>();
        //System.out.println(data+"\n");
        if (simbolo == '/') {
            x.addAll(Arrays.asList(data.split("/")));
            //System.out.println(x + "\n");
            data = x.get(2) + "-" + x.get(1) + "-" + x.get(0);//AAAA-MM-DD
            //System.out.println(data);
        } else if (simbolo == '-') {
            x.addAll(Arrays.asList(data.split("-")));
            //System.out.println(x + "\n");
            data = x.get(2) + "/" + x.get(1) + "/" + x.get(0);//DD-MM-AAAA
            //System.out.println(data); 
        } else {
            data = null;
        }
        return data;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTClientes;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LOGO1.png")));
    }
}