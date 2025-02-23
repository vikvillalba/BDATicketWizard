package itson.ticketwizard.presentacion;
import itson.ticketwizard.control.ControlIniciarSesion;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import javax.swing.JFrame;

/**
 *
 * @author victoria
 */
public class FrmInicioSesion extends JFrame {
     private final ControlIniciarSesion controlInicioSesion;

     
     
    /**
     * Creates new form FrmInicioSesion
     */
    public FrmInicioSesion(ControlIniciarSesion controlInicioSesion) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controlInicioSesion = controlInicioSesion;
    }
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        pnl2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCrearCuenta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl1.setBackground(new java.awt.Color(223, 218, 255));
        pnl1.setLayout(null);

        pnl2.setBackground(new java.awt.Color(57, 57, 57));
        pnl2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Galvji", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicio de Sesión");
        pnl2.add(jLabel1);
        jLabel1.setBounds(120, 60, 300, 43);

        txtUsuario.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        pnl2.add(txtUsuario);
        txtUsuario.setBounds(200, 160, 230, 30);

        txtContrasenia.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        pnl2.add(txtContrasenia);
        txtContrasenia.setBounds(200, 210, 230, 30);

        jLabel2.setFont(new java.awt.Font("Galvji", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");
        pnl2.add(jLabel2);
        jLabel2.setBounds(90, 160, 100, 29);

        jLabel3.setFont(new java.awt.Font("Galvji", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña");
        pnl2.add(jLabel3);
        jLabel3.setBounds(50, 210, 140, 29);

        btnIngresar.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setFocusPainted(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        pnl2.add(btnIngresar);
        btnIngresar.setBounds(160, 320, 190, 40);

        pnl1.add(pnl2);
        pnl2.setBounds(390, 50, 500, 400);

        jLabel4.setFont(new java.awt.Font("Galvji", 0, 24)); // NOI18N
        jLabel4.setText("¿No tienes una cuenta? ");
        pnl1.add(jLabel4);
        jLabel4.setBounds(490, 480, 290, 30);

        btnCrearCuenta.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        btnCrearCuenta.setForeground(new java.awt.Color(51, 0, 102));
        btnCrearCuenta.setText("Crear una cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });
        pnl1.add(btnCrearCuenta);
        btnCrearCuenta.setBounds(540, 530, 190, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoChikito.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        pnl1.add(jLabel5);
        jLabel5.setBounds(10, 110, 370, 350);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // crear dto y enviarlo al control
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        
        UsuarioRegistradoDTO usuarioRegistradoDTO = new UsuarioRegistradoDTO(null, usuario, contrasenia, null);
        this.controlInicioSesion.iniciarSesion(usuarioRegistradoDTO);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        this.controlInicioSesion.mostrarPantallaCrearCuenta();
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

            
            
            
            


}
