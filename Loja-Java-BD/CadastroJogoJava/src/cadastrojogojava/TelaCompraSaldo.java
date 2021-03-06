/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrojogojava;

import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class TelaCompraSaldo extends javax.swing.JDialog {
    Usuario logado = new Usuario();
    /**
     * Creates new form TelaCompraSaldo
     */
    public TelaCompraSaldo(java.awt.Frame parent, boolean modal, Usuario logado) {
        super(parent, modal);
        initComponents();
        this.logado = logado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botaoDez = new javax.swing.JButton();
        botaoTrinta = new javax.swing.JButton();
        botaoCinquenta = new javax.swing.JButton();
        botaoCem = new javax.swing.JButton();
        botaoDuzentos = new javax.swing.JButton();
        botao300 = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comprar Saldo");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("COMPRE SALDO");

        botaoDez.setText("10 R$");
        botaoDez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDezActionPerformed(evt);
            }
        });

        botaoTrinta.setText("30 R$");
        botaoTrinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTrintaActionPerformed(evt);
            }
        });

        botaoCinquenta.setText("50 R$");
        botaoCinquenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCinquentaActionPerformed(evt);
            }
        });

        botaoCem.setText("100 R$");
        botaoCem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCemActionPerformed(evt);
            }
        });

        botaoDuzentos.setText("200 R$");
        botaoDuzentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDuzentosActionPerformed(evt);
            }
        });

        botao300.setText("300 R$");
        botao300.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao300ActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoDez)
                    .addComponent(botaoCem))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoDuzentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(botao300))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoTrinta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCinquenta)))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoVoltar)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoDez)
                    .addComponent(botaoTrinta)
                    .addComponent(botaoCinquenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCem)
                    .addComponent(botaoDuzentos)
                    .addComponent(botao300))
                .addGap(18, 18, 18)
                .addComponent(botaoVoltar)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoDezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDezActionPerformed
        int money = AdicionaDinheiro(10);
        logado.setCarteira(money);
        Banco.atualizaBancoUsuario(logado);
        JOptionPane.showMessageDialog(null, "Seu pagamento foi realizado com sucesso");
    }//GEN-LAST:event_botaoDezActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoTrintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTrintaActionPerformed
        int money = AdicionaDinheiro(30);
        logado.setCarteira(money);
        Banco.atualizaBancoUsuario(logado);
        JOptionPane.showMessageDialog(null, "Seu pagamento foi realizado com sucesso");
    }//GEN-LAST:event_botaoTrintaActionPerformed

    private void botaoCinquentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCinquentaActionPerformed
       int money = AdicionaDinheiro(50);
        logado.setCarteira(money);
        Banco.atualizaBancoUsuario(logado);
        JOptionPane.showMessageDialog(null, "Seu pagamento foi realizado com sucesso");
    }//GEN-LAST:event_botaoCinquentaActionPerformed

    private void botaoCemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCemActionPerformed
        int money = AdicionaDinheiro(100);
        logado.setCarteira(money);
        Banco.atualizaBancoUsuario(logado);
        JOptionPane.showMessageDialog(null, "Seu pagamento foi realizado com sucesso");
    }//GEN-LAST:event_botaoCemActionPerformed

    private void botaoDuzentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDuzentosActionPerformed
        int money = AdicionaDinheiro(200);
        logado.setCarteira(money);
        Banco.atualizaBancoUsuario(logado);
        JOptionPane.showMessageDialog(null, "Seu pagamento foi realizado com sucesso");
    }//GEN-LAST:event_botaoDuzentosActionPerformed

    private void botao300ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao300ActionPerformed
        int money = AdicionaDinheiro(300);
        logado.setCarteira(money);
        Banco.atualizaBancoUsuario(logado);
        JOptionPane.showMessageDialog(null, "Seu pagamento foi realizado com sucesso");
    }//GEN-LAST:event_botao300ActionPerformed

    public int AdicionaDinheiro(int saldo){
       int money;
       money = logado.getCarteira() + saldo;
       return money;
    }
    
    public static void abrir(Usuario logado) {
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
            java.util.logging.Logger.getLogger(TelaCompraSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCompraSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCompraSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCompraSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCompraSaldo dialog = new TelaCompraSaldo(new javax.swing.JFrame(), true, logado);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao300;
    private javax.swing.JButton botaoCem;
    private javax.swing.JButton botaoCinquenta;
    private javax.swing.JButton botaoDez;
    private javax.swing.JButton botaoDuzentos;
    private javax.swing.JButton botaoTrinta;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
