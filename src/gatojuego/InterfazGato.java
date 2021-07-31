
package gatojuego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class InterfazGato extends javax.swing.JFrame implements ActionListener{

    private Gato gato;
    int marcadorX;
    int marcadorY;
    private boolean ganado;
    private JButton[][]tablero;
    public InterfazGato() {
        initComponents();
        this.setLocationRelativeTo(null);
        ganado=false;
        jPanel1.setLayout(null);
        gato=new Gato();
        tablero=new JButton[3][3];
        jPanel2.setLayout(null);
        marcadorX=0;
        marcadorY=0;
        this.setTitle("JUEGO GATO");
        InializarBotones();
    }
    
    private void InializarBotones(){
        int x=0;
        int y=0;
        int j;
        for (int i=0;i<3;i++){
            for (j=0;j<3;j++){
                tablero[i][j]=new JButton("-");
                tablero[i][j].setBounds(x, y, jPanel2.getWidth()/3, jPanel2.getHeight()/3);
                jPanel2.add(tablero[i][j]);
                tablero[i][j].addActionListener(this);
                x=x+tablero[i][j].getWidth();
            }
            j=0;
            x=0;
            y=y+tablero[0][0].getHeight();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (ganado){
            return;
        }
        
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (e.getSource()==tablero[i][j]){
                    if (!gato.Jugada(i, j)){
                        return;
                    }
                }
            }
        }
        
        if (gato.GetJugador()){
            jLabel3.setText("TURNO X");
            jLabel3.setForeground(Color.red);
            jButton3.setText("X");
            jButton3.setBackground(Color.red);
        }
        else{
            jLabel3.setText("TURNO O");
            jLabel3.setForeground(Color.blue);
            jButton3.setText("O");
            jButton3.setBackground(Color.blue);
        }
        
        Colorear();
        
        if (gato.JuegoGanado()){
            if (!gato.GetJugador()){
                JOptionPane.showMessageDialog(this, "GANA EL JUGADOR X");
                marcadorX++;
                jLabel1.setText("JUGADOR X: "+marcadorX);
            }
            else{
                JOptionPane.showMessageDialog(this, "GANA EL JUGADOR O");
                marcadorY++;
                jLabel2.setText("JUGADOR O: "+marcadorY);
            }
            ganado=true;
        }
    }
    
    public void Colorear(){
        int [][] ga=gato.GetTablero();
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (ga[i][j]==-1){
                    tablero[i][j].setBackground(Color.gray);
                    tablero[i][j].setText("-");
                }
                else if (ga[i][j]==0){
                    tablero[i][j].setBackground(Color.red);
                    tablero[i][j].setText("X");
                }
                else{
                    tablero[i][j].setBackground(Color.blue);
                    tablero[i][j].setText("O");
                }
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("JUGADOR X: 0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("JUGADOR O: 0");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );

        jButton1.setText("REINICIAR MARCADOR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("REINICIARJUEGO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("TURNO X");

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setText("X");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        gato.InicializarTablero();
        ganado=false;
        if (gato.GetJugador()){
            jLabel3.setText("TURNO X");
            jLabel3.setForeground(Color.red);
            jButton3.setText("X");
            jButton3.setBackground(Color.red);
        }
        else{
            jLabel3.setText("TURNO O");
            jLabel3.setForeground(Color.blue);
            jButton3.setText("O");
            jButton3.setBackground(Color.blue);
        }
        Colorear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        marcadorX=0;
        marcadorY=0;
        jLabel1.setText("JUGADOR X: "+marcadorX);
        jLabel2.setText("JUGADOR O: "+marcadorY);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazGato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
