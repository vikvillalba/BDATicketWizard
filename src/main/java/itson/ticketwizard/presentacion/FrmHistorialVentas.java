package itson.ticketwizard.presentacion;

import itson.ticketwizard.control.ControlRegistrarCompra;

/**
 *
 * @author victoria
 */
public class FrmHistorialVentas extends javax.swing.JFrame {
     private final ControlRegistrarCompra control;
    
    /**
     * Creates new form FrmHistorialBoletos
     */
    public FrmHistorialVentas(ControlRegistrarCompra control) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.control = control;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(223, 218, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Galvji", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(95, 84, 163));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mis Ventas");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 410, 90));

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlResultadosBoletos.setBackground(new java.awt.Color(223, 218, 255));

        tblBoletos.setFont(new java.awt.Font("Galvji", 0, 24)); // NOI18N
        tblBoletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero Transaccion", "FechaHora compra", "Ganancia", "Precio Venta", "Fecha Limite Venta", "Evento", "Recinto", "Asiento", "Codigo Boleto"
            }
        ));
        pnlResultadosBoletos.setViewportView(tblBoletos);

        jPanel1.add(pnlResultadosBoletos, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(223, 218, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolverMenu.setBackground(new java.awt.Color(119, 118, 126));
        btnVolverMenu.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        btnVolverMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverMenu.setText("Regresar al menú");
        jPanel3.add(btnVolverMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 200, 50));

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane pnlResultadosBoletos;
    private javax.swing.JTable tblBoletos;
    // End of variables declaration//GEN-END:variables
}
