package loja2;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    public Connection con;
           
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setIcon();
        
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLLogotipo = new javax.swing.JLabel();
        jLUsuario = new javax.swing.JLabel();
        jTFUsuario = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jPFSenha = new javax.swing.JPasswordField();
        jBEntrar = new javax.swing.JButton();
        jLNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Entrar");
        setResizable(false);

        jLLogotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loja2/LOGO2.png"))); // NOI18N

        jLUsuario.setText("Usuário:");

        jLSenha.setText("Senha:");

        jPFSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPFSenhaKeyPressed(evt);
            }
        });

        jBEntrar.setText("Entrar");
        jBEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrarActionPerformed(evt);
            }
        });

        jLNome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLNome.setForeground(new java.awt.Color(255, 153, 0));
        jLNome.setText("Locadora de Veículos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLLogotipo)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLUsuario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLSenha)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPFSenha)))
                            .addComponent(jBEntrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLNome)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLUsuario)
                            .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLSenha)
                            .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEntrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLLogotipo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNome)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrarActionPerformed
        
          if(jTFUsuario.equals("adminlocadora") && jPFSenha.equals("adminlocadora")){
          
          ConectarDireto();
          PaginaInicial pi = new PaginaInicial();
          pi.setVisible(true);
          
          
          System.out.println("Conectado!");
        }
        else{
            JOptionPane.showMessageDialog(null,"Usuário ou senha incorretos!");
        } 
        
    }//GEN-LAST:event_jBEntrarActionPerformed

    private void jPFSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPFSenhaKeyPressed
        int codigo = evt.getKeyCode();
        
        if(codigo == KeyEvent.VK_ENTER){
        
        if(jTFUsuario.getText().equalsIgnoreCase("adminlocadora") && jPFSenha.getText().equalsIgnoreCase("adminlocadora")){
           
           ConectarDireto(); 
           new PaginaInicial().setVisible(true);
           this.dispose(); 
           
           
        }
        
        else{
            JOptionPane.showMessageDialog(null,"Usuário ou senha incorretos!");
        }        
      }
    }//GEN-LAST:event_jPFSenhaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws Exception {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        
//       try{
//           MongoClient mongoClient = new MongoClient("localhost",27017);
//           DB db = (DB) mongoClient.getDatabase("locadoraveiculos");
//           System.out.println("Conectado com Mondo DB");
//       }catch(Exception e){
//           System.out.println(e);
//       } 
//       
//        System.out.println("Server is ready");
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEntrar;
    private javax.swing.JLabel jLLogotipo;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LOGO1.png")));
    }

}
