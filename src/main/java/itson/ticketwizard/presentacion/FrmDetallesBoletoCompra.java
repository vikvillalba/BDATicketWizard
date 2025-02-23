package itson.ticketwizard.presentacion;

import itson.ticketwizard.control.ControlException;
import itson.ticketwizard.control.ControlRegistrarCompra;
import itson.ticketwizard.dtos.BoletoCompraDTO;
import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victoria
 */
public class FrmDetallesBoletoCompra extends javax.swing.JFrame {
    private final ControlRegistrarCompra control;
    private BoletoCompraDTO boletoCompraDTO;
    private UsuarioRegistradoDTO usuarioRegistradoDTO;
    /**
     * Creates new form FrmHistorialBoletos
     */
    public FrmDetallesBoletoCompra(ControlRegistrarCompra control, UsuarioRegistradoDTO usuarioRegistradoDTO, BoletoCompraDTO boletoCompraDTO) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.control = control;
        this.boletoCompraDTO = boletoCompraDTO;
        this.usuarioRegistradoDTO = usuarioRegistradoDTO;
        this.cargarBoletoTabla();
    }
    

    private void mostrarInfoBoleto(BoletoDTO boletoDTO) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblBoletos.getModel();

        Object[] filaTabla = {
            boletoDTO.getNombreEvento(),
            boletoDTO.getFechaEvento(),
            boletoDTO.getRecinto(),
            boletoDTO.getFila(),
            boletoDTO.getAsiento(),
            boletoDTO.getCiudad(),
            boletoDTO.getEstado(),
            boletoDTO.getPrecio()};
                      
        modeloTabla.addRow(filaTabla);

    }
    
    private void cargarBoletoTabla(){
        try {
            BoletoDTO boleto = this.control.obtenerBoletoCompra(boletoCompraDTO);
            this.mostrarInfoBoleto(boleto);
        } catch (ControlException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlResultadosBoletos = new javax.swing.JScrollPane();
        tblBoletos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnComprar = new javax.swing.JButton();
        btnVolverMenu1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(223, 218, 255));

        jLabel1.setFont(new java.awt.Font("Galvji", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(95, 84, 163));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Detalles del Boleto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlResultadosBoletos.setBackground(new java.awt.Color(223, 218, 255));
        pnlResultadosBoletos.setMaximumSize(new java.awt.Dimension(22767, 22767));
        pnlResultadosBoletos.setPreferredSize(new java.awt.Dimension(400, 100));

        tblBoletos.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        tblBoletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Evento", "Fecha", "Recinto", "Fila", "Asiento", "Ciudad", "Estado", "Precio"
            }
        ));
        pnlResultadosBoletos.setViewportView(tblBoletos);

        jPanel1.add(pnlResultadosBoletos, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(223, 218, 255));

        btnComprar.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnVolverMenu1.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        btnVolverMenu1.setText("Cancelar");
        btnVolverMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(btnVolverMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolverMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenu1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverMenu1ActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        try {
            BoletoDTO boleto = this.control.obtenerBoletoCompra(boletoCompraDTO);
            control.comprarBoleto(usuarioRegistradoDTO, boleto);
        } catch (ControlException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnComprarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnVolverMenu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane pnlResultadosBoletos;
    private javax.swing.JTable tblBoletos;
    // End of variables declaration//GEN-END:variables
}
