/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checklist;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jose
 */
public class Checklist_C extends javax.swing.JInternalFrame {
    private TableRowSorter trsFiltro;
    DefaultTableModel model;
    Conexion.conexion conexion = new Conexion.conexion();
    Connection cn = conexion.connect();
    Statement sent;
    /**
     * Creates new form Checklist_C
     */
    public Checklist_C() {
        initComponents();
        llenar_asignacion();
        llenar_checklist();
    }
    
    void llenar_asignacion() {
        try {
            cn = conexion.connect();
            String [] titulos = {"C° Asign","Rut","Nombre","Telefono","E-mail","Patente","Marca", "Modelo", "Fecha Asign"};
            String sql = "SELECT op.cod_asign, op.rut, emp.nombres, emp.apellidos, emp.telefono, emp.mail, op.patente, maq.marca, maq.modelo, op.fecha_asign FROM operario op, maquinas maq, empleado emp where op.rut = emp.rut and op.patente = maq.patente";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [9];
            while (rs.next()){
                fila[0]=rs.getString("cod_asign");
                fila[1]=rs.getString("rut");
                fila[2]=rs.getString("nombres").concat(rs.getString("apellidos"));
                fila[3]=rs.getString("telefono");
                fila[4]=rs.getString("mail");
                fila[5]=rs.getString("patente");
                fila[6]=rs.getString("marca");
                fila[7]=rs.getString("modelo");
                fila[8]=rs.getString("fecha_asign");
            model.addRow(fila);
            }
            jtbl_operarios.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_checklist() {
        try {
            cn = conexion.connect();
            String [] titulos = {"C° Check","Rut","Nombre","Patente","Marca","Modelo","Fecha", "Km Actual", "Km Anterior","Proxima Rev","Proxima Man"};
            String sql = "SELECT ch.cod_check, ch.rut, emp.nombres, emp.apellidos, ch.patente, maq.marca, maq.modelo, ch.fecha, ch.km_actual, ch.km_total, ch.proxima_rev, ch.proxima_man  FROM checklist ch, empleado emp, maquinas maq where ch.rut = emp.rut and ch.patente = maq.patente";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [11];
            while (rs.next()){
                fila[0]=rs.getString("cod_check");
                fila[1]=rs.getString("rut");
                fila[2]=rs.getString("nombres").concat(rs.getString("apellidos"));
                fila[3]=rs.getString("patente");
                fila[4]=rs.getString("marca");
                fila[5]=rs.getString("modelo");
                fila[6]=rs.getString("fecha");
                fila[7]=rs.getString("km_actual");
                fila[8]=rs.getString("km_total");
                fila[9]=rs.getString("proxima_rev");
                fila[10]=rs.getString("proxima_rev");
            model.addRow(fila);
            }
            jtbl_checklist.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void filtro() {
        
        int columnaABuscar = 1;
        if (jcbx_buscarop.getSelectedItem() == "Rut") {
            columnaABuscar = 1;
        }
        if (jcbx_buscarop.getSelectedItem() == "Nombre") {
            columnaABuscar = 2;
        }
        if (jcbx_buscarop.getSelectedItem() == "Patente") {
            columnaABuscar = 5;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_busqueda_op.getText(), columnaABuscar));
    }
    
    public void filtro_ch() {
        
        int columnaABuscar = 0;
        if (jcbx_buscar_ch.getSelectedItem() == "C° Check") {
            columnaABuscar = 0;
        }
        if (jcbx_buscar_ch.getSelectedItem() == "Rut") {
            columnaABuscar = 1;
        }
        if (jcbx_buscar_ch.getSelectedItem() == "Nombres") {
            columnaABuscar = 2;
        }
        if (jcbx_buscar_ch.getSelectedItem() == "Patente") {
            columnaABuscar = 3;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_busqueda_ch.getText(), columnaABuscar));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_busqueda_op = new javax.swing.JTextField();
        jcbx_buscarop = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_operarios = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_busqueda_ch = new javax.swing.JTextField();
        jcbx_buscar_ch = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_checklist = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de Checklist");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/check.png"))); // NOI18N
        jLabel1.setText("Consulta de Checklist");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jTabbedPane1.setBackground(java.awt.SystemColor.activeCaption);

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("BUSQUEDA:");

        txt_busqueda_op.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_busqueda_op.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busqueda_opKeyTyped(evt);
            }
        });

        jcbx_buscarop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_buscarop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rut", "Nombre", "Patente" }));
        jcbx_buscarop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbx_buscaropActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jcbx_buscarop, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_busqueda_op, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_busqueda_op, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_buscarop, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_operarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_operarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbl_operarios);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 371, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta Operario-Maquina", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("BUSQUEDA:");

        txt_busqueda_ch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_busqueda_ch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busqueda_chKeyTyped(evt);
            }
        });

        jcbx_buscar_ch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_buscar_ch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C° Check", "Rut", "Nombres", "Patente" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jcbx_buscar_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_busqueda_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_busqueda_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_buscar_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_checklist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_checklist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtbl_checklist);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 361, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta Checklist", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busqueda_opKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busqueda_opKeyTyped
        // TODO add your handling code here:
        txt_busqueda_op.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_busqueda_op.getText());
                txt_busqueda_op.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_operarios.getModel());
        jtbl_operarios.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_busqueda_opKeyTyped

    private void jcbx_buscaropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbx_buscaropActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbx_buscaropActionPerformed

    private void txt_busqueda_chKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busqueda_chKeyTyped
        // TODO add your handling code here:
        txt_busqueda_ch.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_busqueda_ch.getText());
                txt_busqueda_ch.setText(cadena);
                repaint();
                filtro_ch();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_checklist.getModel());
        jtbl_checklist.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_busqueda_chKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbx_buscar_ch;
    private javax.swing.JComboBox<String> jcbx_buscarop;
    private javax.swing.JTable jtbl_checklist;
    private javax.swing.JTable jtbl_operarios;
    private javax.swing.JTextField txt_busqueda_ch;
    private javax.swing.JTextField txt_busqueda_op;
    // End of variables declaration//GEN-END:variables
}
