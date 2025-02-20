package itson.ticketwizard.presentacion;

import itson.ticketwizard.control.ControlException;
import itson.ticketwizard.control.ControlResultadosBusqueda;
import itson.ticketwizard.dtos.BoletoDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victoria
 */
public class FrmResultadosBusqueda extends javax.swing.JFrame {
    private int pagina=1;
    private final int LIMITE = 7;
    private final ControlResultadosBusqueda control;

    /**
     * Creates new form FrmResultadosBusqueda
     */
    public FrmResultadosBusqueda(ControlResultadosBusqueda control) {
        initComponents();
        this.control = control;
        this.setLocationRelativeTo(null);
        this.cargarMetodosIniciales();
    }
    
      public void cargarMetodosIniciales() {
        //this.cargarConfiguracionInicialPantalla();
        this.cargarAlumnosEnTabla();
        this.estadoPagina();
    }
      
 private void llenarTablaAlumnos(List<BoletoDTO> listaBoletos) {
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
                fila[0] = row.getNombreEvento();
                fila[1] = row.getFechaEvento();
                fila[2] = row.getRecinto();
                fila[3] = row.getFila();
                fila[4] = row.getAsiento();
                fila[5] = row.getCiudad();
                fila[6] = row.getEstado();
                fila[7] = row.getPrecio();

                modeloTabla.addRow(fila);
            });
        }
    }


        public void cargarAlumnosEnTabla() {
        try {
            List<BoletoDTO> listaBoletos = this.control.obtenerBoletosPaginados(LIMITE, pagina);
            this.llenarTablaAlumnos(listaBoletos);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rbFechas = new javax.swing.JRadioButton();
        rbNombre = new javax.swing.JRadioButton();
        txtNombreEvento = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JFormattedTextField();
        txtFechaFin = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoBoleto = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        btnRegresarMenu = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnSiguiente = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();
        pnlResultados = new javax.swing.JScrollPane();
        tblBoletos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(223, 218, 255));

        jLabel1.setFont(new java.awt.Font("Galvji", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(95, 84, 163));
        jLabel1.setText("Resultados de la Búsqueda");

        rbFechas.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        rbFechas.setText("Rango de fechas");

        rbNombre.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        rbNombre.setText("Nombre del evento");

        txtFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yy"))));

        txtFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yy"))));

        btnBuscar.setBackground(new java.awt.Color(95, 84, 163));
        btnBuscar.setFont(new java.awt.Font("Galvji", 1, 16)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jButton1.setText("Reiniciar Búsqueda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbNombre))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(rbFechas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(185, 185, 185))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(223, 218, 255));

        jLabel2.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(95, 84, 163));
        jLabel2.setText("Código del boleto");

        btnSeleccionar.setBackground(new java.awt.Color(95, 84, 163));
        btnSeleccionar.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("Seleccionar");

        btnRegresarMenu.setBackground(new java.awt.Color(119, 118, 126));
        btnRegresarMenu.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        btnRegresarMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresarMenu.setText("Regresar al Menú");
        btnRegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarMenuActionPerformed(evt);
            }
        });

        BtnAtras.setText("Anterior");
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });

        BtnSiguiente.setText("Siguiente");
        BtnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSiguienteActionPerformed(evt);
            }
        });

        lblPagina.setText("página 1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(txtCodigoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addComponent(btnRegresarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(504, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAtras)
                .addGap(12, 12, 12)
                .addComponent(lblPagina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnSiguiente)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAtras)
                            .addComponent(BtnSiguiente)
                            .addComponent(lblPagina))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoBoleto)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        tblBoletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Evento", "Fecha", "Recinto", "Fila", "Asiento", "Ciudad", "Estado", "Precio"
            }
        ));
        pnlResultados.setViewportView(tblBoletos);

        jPanel2.add(pnlResultados, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

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
            BtnAtras.setEnabled(true);
            return;
        }
        BtnAtras.setEnabled(false);
    }

    private void estatusBotonSiguiente() {

        try {
            BtnSiguiente.setEnabled(true);
            if (this.control.obtenerBoletosPaginados(this.LIMITE, this.pagina + 1) == null) {
                BtnSiguiente.setEnabled(false);
            }
        } catch (ControlException ex) {
            System.out.println(ex);
        }

    }
    private void btnRegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarMenuActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarMenuActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        this.pagina = this.pagina - 1;
        this.cargarAlumnosEnTabla();
        this.estadoPagina();
    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void BtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSiguienteActionPerformed
       this.pagina = this.pagina + 1;
        this.cargarAlumnosEnTabla();
        this.estadoPagina();
    }//GEN-LAST:event_BtnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnSiguiente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresarMenu;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JScrollPane pnlResultados;
    private javax.swing.JRadioButton rbFechas;
    private javax.swing.JRadioButton rbNombre;
    private javax.swing.JTable tblBoletos;
    private javax.swing.JTextField txtCodigoBoleto;
    private javax.swing.JFormattedTextField txtFechaFin;
    private javax.swing.JFormattedTextField txtFechaInicio;
    private javax.swing.JTextField txtNombreEvento;
    // End of variables declaration//GEN-END:variables
}
