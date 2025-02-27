package itson.ticketwizard.presentacion;

import itson.ticketwizard.control.ControlException;
import itson.ticketwizard.control.ControlResultadosBusqueda;
import itson.ticketwizard.dtos.BoletoCompraDTO;
import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.BusquedaBoletoFechasDTO;
import itson.ticketwizard.dtos.BusquedaBoletoNombreDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import javax.naming.ldap.Rdn;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victoria
 */
public class FrmResultadosBusqueda extends javax.swing.JFrame {
    private int pagina=1;
    private final int LIMITE = 10;
    private final ControlResultadosBusqueda control;
    private UsuarioRegistradoDTO usuarioRegistradoDTO;

    /**
     * Creates new form FrmResultadosBusqueda
     */
    public FrmResultadosBusqueda(ControlResultadosBusqueda control, UsuarioRegistradoDTO usuarioRegistradoDTO) {
        initComponents();
        this.control = control;
        this.usuarioRegistradoDTO = usuarioRegistradoDTO;
        this.setLocationRelativeTo(null);
        this.cargarMetodosIniciales();
    }
    
      public void cargarMetodosIniciales() {
        this.cargarBoletosEnTabla();
        this.estadoPagina();
    }
      
    private void llenarTablaBoletos(List<BoletoDTO> listaBoletos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblBoletos.getModel();

        if (modeloTabla.getColumnCount() < 9) {
            modeloTabla.addColumn("BoletoDTO");  // Columna oculta que almacenará los objetos BoletoDTO
        }


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

                // Para hacer esto, necesitamos usar un TableRow que almacene la referencia al BoletoDTO
                modeloTabla.setValueAt(row, modeloTabla.getRowCount() - 1, 8); // Establecemos el objeto BoletoDTO en la columna oculta

            });
        }
        this.tblBoletos.getColumnModel().getColumn(8).setMaxWidth(0);
        this.tblBoletos.getColumnModel().getColumn(8).setMinWidth(0);
        this.tblBoletos.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.mostrarCodigoBoleto(modeloTabla);

    }

    private void mostrarCodigoBoleto(DefaultTableModel modeloTabla) {
        this.tblBoletos.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            int filaSeleccionada = tblBoletos.getSelectedRow();
            if (filaSeleccionada != -1) {
                
                BoletoDTO boletoSeleccionado = (BoletoDTO) modeloTabla.getValueAt(filaSeleccionada, 8);  // Columna 8 donde almacenamos el objeto BoletoDTO

                
                if (boletoSeleccionado != null) {
                    txtCodigoBoleto.setText(String.valueOf(boletoSeleccionado.getNumeroSerie()));
                }
            }
        });
    }
        public void cargarBoletosEnTabla() {
           
        try {
            List<BoletoDTO> listaBoletos = this.control.obtenerBoletosPaginados(LIMITE, pagina, usuarioRegistradoDTO);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rbFechas = new javax.swing.JRadioButton();
        rbNombre = new javax.swing.JRadioButton();
        txtNombreEvento = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JFormattedTextField();
        txtFechaFin = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
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

        txtFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        txtFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        btnBuscar.setFont(new java.awt.Font("Galvji", 1, 16)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnReiniciar.setText("Reiniciar Búsqueda");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbNombre)
                                .addGap(91, 91, 91)
                                .addComponent(rbFechas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReiniciar)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
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
                .addComponent(btnReiniciar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(223, 218, 255));

        jLabel2.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(95, 84, 163));
        jLabel2.setText("Código del boleto");

        txtCodigoBoleto.setEditable(false);
        txtCodigoBoleto.setEnabled(false);

        btnSeleccionar.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnRegresarMenu.setFont(new java.awt.Font("Galvji", 1, 18)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCodigoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(BtnAtras)
                .addGap(12, 12, 12)
                .addComponent(lblPagina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnSiguiente)
                .addGap(15, 15, 15))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addComponent(btnRegresarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(532, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAtras)
                            .addComponent(BtnSiguiente)
                            .addComponent(lblPagina)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnRegresarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        tblBoletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Evento", "Fecha", "Recinto", "Fila", "Asiento", "Ciudad", "Estado", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            if (this.control.obtenerBoletosPaginados(this.LIMITE, this.pagina + 1, usuarioRegistradoDTO) == null) {
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
        if(this.rbNombre.isSelected()){
            String nombreEvento = txtNombreEvento.getText();

            if (nombreEvento.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ingrese un nombre de evento para buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return; 
            }
            BusquedaBoletoNombreDTO busquedaBoletoNombreDTO = new BusquedaBoletoNombreDTO(nombreEvento);
            
            try {
                List<BoletoDTO> listaBoletosNombre = this.control.obtenerBoletosPaginadosNombreEvento(LIMITE, pagina, usuarioRegistradoDTO, busquedaBoletoNombreDTO);
                this.llenarTablaBoletos(listaBoletosNombre);
                
            } catch (ControlException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
            pagina--;
            }
        }
        
        if(this.rbFechas.isSelected()){
         
            String fechaInicio = txtFechaInicio.getText();
            String fechaFin = txtFechaFin.getText();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm:ss");
            

            try {
                LocalDateTime fechaInicioRango = LocalDateTime.parse(fechaInicio + "T00:00:00", formatter);
                LocalDateTime fechaFinRango = LocalDateTime.parse(fechaFin + "T23:59:59", formatter);
                BusquedaBoletoFechasDTO busquedaBoletoFechasDTO = new BusquedaBoletoFechasDTO(fechaInicioRango, fechaFinRango);


                try {
                List<BoletoDTO> listaBoletosFechas = this.control.obtenerBoletosPaginadosRangoFechas(LIMITE, pagina, usuarioRegistradoDTO, busquedaBoletoFechasDTO);
                this.llenarTablaBoletos(listaBoletosFechas);
                
            } catch (ControlException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
            pagina--;
            }
                

            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        this.pagina = this.pagina - 1;
        this.cargarBoletosEnTabla();
        this.estadoPagina();
    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void BtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSiguienteActionPerformed
       this.pagina = this.pagina + 1;
        this.cargarBoletosEnTabla();
        this.estadoPagina();
    }//GEN-LAST:event_BtnSiguienteActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        this.txtFechaFin.setText("");
        this.txtFechaInicio.setText("");
        this.txtNombreEvento.setText("");
        this.txtCodigoBoleto.setText("");
        this.rbNombre.setSelected(false);
        this.rbFechas.setSelected(false);
        this.cargarBoletosEnTabla();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        BoletoCompraDTO boletoCompraDTO = new BoletoCompraDTO(txtCodigoBoleto.getText());
        control.mostrarDetallesCompra(usuarioRegistradoDTO, boletoCompraDTO);
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnSiguiente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresarMenu;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSeleccionar;
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
