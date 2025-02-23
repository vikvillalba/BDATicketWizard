package itson.ticketwizard.presentacion;

import itson.ticketwizard.control.ControlException;
import itson.ticketwizard.control.ControlRegistrarReventa;
import itson.ticketwizard.dtos.BoletoReventaDTO;
import itson.ticketwizard.dtos.BoletoUsuarioDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victoria
 */
public class FrmHistorialReventas extends javax.swing.JFrame {
    private final ControlRegistrarReventa control;
    private int pagina = 1;
    private final int LIMITE = 5;
    private UsuarioRegistradoDTO usuarioRegistradoDTO;

    /**
     * Creates new form FrmHistorialBoletos
     */
    public FrmHistorialReventas(ControlRegistrarReventa control, UsuarioRegistradoDTO usuarioRegistradoDTO) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.control = control;
        this.usuarioRegistradoDTO = usuarioRegistradoDTO;
        this.cargarMetodosIniciales();
    }
    public void cargarMetodosIniciales() {
        this.cargarBoletosEnTabla();
        this.estadoPagina();
    }
    
    private void llenarTablaBoletos(List<BoletoReventaDTO> listaBoletos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblBoletos.getModel();

       

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaBoletos != null) {
            listaBoletos.forEach(row
                    -> {
                Object[] fila = new Object[8];
                fila[0] = row.getNumeroTransaccion();
                fila[1] = row.getFechaTransaccion();
                fila[2] = row.getPrecioReventa(); //
                fila[3] = row.getFechaLimiteReventa();
                fila[4] = row.getNombreEvento();
                fila[5] = row.getRecinto();
                fila[6] = row.getAsiento();
                fila[7] = row.getNumeroSerie();

                modeloTabla.addRow(fila);

            });
        }

    }

    public void cargarBoletosEnTabla() {

        try {
            List<BoletoReventaDTO> listaBoletos = this.control.obtenerBoletosReventa(LIMITE, pagina, usuarioRegistradoDTO);
            this.llenarTablaBoletos(listaBoletos);
        } catch (ControlException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
            pagina--;
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
        btnVolverMenu = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(223, 218, 255));

        jLabel1.setFont(new java.awt.Font("Galvji", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(95, 84, 163));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mis Reventas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlResultadosBoletos.setBackground(new java.awt.Color(223, 218, 255));

        tblBoletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero Transaccion", "FechaHora compra", "Precio Venta", "Fecha Limite Venta", "Evento", "Recinto", "Asiento", "Codigo Boleto"
            }
        ));
        pnlResultadosBoletos.setViewportView(tblBoletos);

        jPanel1.add(pnlResultadosBoletos, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(223, 218, 255));

        btnVolverMenu.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        btnVolverMenu.setText("Regresar al menú");
        btnVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuActionPerformed(evt);
            }
        });

        btnAtras.setText("Anterior");

        btnSiguiente.setText("Siguiente");

        lblPagina.setText("página 1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(495, 495, 495)
                .addComponent(btnVolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addGap(18, 18, 18)
                .addComponent(lblPagina)
                .addGap(18, 18, 18)
                .addComponent(btnSiguiente)
                .addGap(57, 57, 57))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnVolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAtras)
                            .addComponent(btnSiguiente)
                            .addComponent(lblPagina))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estadoPagina() {
        String numPagina = String.valueOf(pagina);
        lblPagina.setText("Pagina " + numPagina);
        estatusBotonAtras();
        estatusBotonSiguiente();
    }

    private void estatusBotonAtras() {
        if (this.pagina > 1) {
            btnAtras.setEnabled(true);
            return;
        }
        btnAtras.setEnabled(false);
    }

    private void estatusBotonSiguiente() {

        try {
            btnSiguiente.setEnabled(true);
            if (this.control.obtenerBoletosPaginados(this.LIMITE, this.pagina + 1, usuarioRegistradoDTO) == null) {
                btnSiguiente.setEnabled(false);
            }
        } catch (ControlException ex) {
            System.out.println(ex);
        }

    }
    
    
    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverMenuActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JScrollPane pnlResultadosBoletos;
    private javax.swing.JTable tblBoletos;
    // End of variables declaration//GEN-END:variables
}
