/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checklist;

import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class Checklist_I extends javax.swing.JInternalFrame {
    private DefaultComboBoxModel modelcomborut;
    private DefaultComboBoxModel modelcomboptte;
    private DefaultComboBoxModel modelcomborutch;
    DefaultTableModel model;    
    Conexion.conexion conexion = new Conexion.conexion();
    Connection cn = conexion.connect();
    Statement sent;
    /**
     * Creates new form Checklist_I
     */
    public Checklist_I() {
        modelcomborut = new DefaultComboBoxModel(new String [] {});
        modelcomboptte = new DefaultComboBoxModel(new String [] {});
        modelcomborutch = new DefaultComboBoxModel(new String [] {});
        initComponents();
        deshabilitar_asignacion();
        deshabilitar_checklist();
        limpiar_asignacion();
        limpiar_checklist();
        llenar_comboptte();
        llenar_comborut();
        llenar_comborutch();
        llenar_asignacion();
        llenar_checklist();
    }
    
    void llenar_comborut() {
        try { 
        String sql = "SELECT rut FROM empleado";
        PreparedStatement verUsuarios = (PreparedStatement) cn.prepareStatement(sql);
        ResultSet ver = verUsuarios.executeQuery();
        while(ver.next()){ 
        modelcomborut.addElement(ver.getString(1));
             }
         } catch (SQLException ex) {Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    void llenar_comboptte() {
        try {
        String sql = "select patente from maquinas";
        PreparedStatement verUsuarios = (PreparedStatement) cn.prepareStatement(sql);
        ResultSet ver = verUsuarios.executeQuery();
        while(ver.next()){ 
        modelcomboptte.addElement(ver.getString(1));
             }
         } catch (SQLException ex) {Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    void llenar_comborutch() {
        try { 
        String sql = "SELECT rut FROM operario";
        PreparedStatement verUsuarios1 = (PreparedStatement) cn.prepareStatement(sql);
        ResultSet ver = verUsuarios1.executeQuery();
        while(ver.next()){ 
        modelcomborutch.addElement(ver.getString(1));
             }
         } catch (SQLException ex) {Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    void llenar_asignacion() {
        try {
            cn = conexion.connect();
            String [] titulos = {"C° Asign ","Rut","Patente","Fecha","Nombres","Apellidos","Direccion","Telefono","Email"};
            String sql = "SELECT op.cod_asign, op.rut, op.patente, op.fecha_asign, fi.nombres, fi.apellidos, fi.direccion, fi.telefono, fi.mail FROM empleado fi, operario op WHERE op.rut = fi.rut";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [9];
            while (rs.next()){
                fila[0]=rs.getString("op.cod_asign");
                fila[1]=rs.getString("op.rut");
                fila[2]=rs.getString("op.patente");
                fila[3]=rs.getString("op.fecha_asign");
                fila[4]=rs.getString("fi.nombres");
                fila[5]=rs.getString("fi.apellidos");
                fila[6]=rs.getString("fi.direccion");
                fila[7]=rs.getString("fi.telefono");
                fila[8]=rs.getString("fi.mail");
            model.addRow(fila);
            }
            jtbl_operario.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void limpiar_asignacion() {
        jdt_fecha_as.setCalendar(null);
    }
    
    void llenar_checklist() {
        try {
            cn = conexion.connect();
            String [] titulos = {"C° Check","Rut","Patente","1° Nombre","1° Apellido","Cod Check","Fecha","Km Actual","Km Anterior","Prox Revisión","Prox Mantención"};
            String sql = "SELECT chl.cod_check, op.rut, op.patente, fi.nombres, fi.apellidos, chl.fecha, chl.km_actual, chl.km_total, chl.proxima_rev, chl.proxima_man FROM checklist chl, operario op, empleado fi WHERE op.rut = chl.rut and op.rut = fi.rut";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [10];
            while (rs.next()){
                fila[0]=rs.getString("chl.cod_check");
                fila[1]=rs.getString("op.rut");
                fila[2]=rs.getString("op.patente");
                fila[3]=rs.getString("fi.nombres");
                fila[4]=rs.getString("fi.apellidos");
                fila[5]=rs.getString("chl.fecha");
                fila[6]=rs.getString("chl.km_actual");
                fila[7]=rs.getString("chl.km_total");
                fila[8]=rs.getString("chl.proxima_rev");
                fila[9]=rs.getString("chl.proxima_man");              
                
            model.addRow(fila);
            }
            jtbl_checklist.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void limpiar_checklist() {
        jdt_fecha_ch.setCalendar(null);
        txt_actual_ch.setText("");
        txt_anterior_ch.setText("");
        jdt_man_ch.setCalendar(null);
        jdt_proxrev_ch.setCalendar(null);
    }
    
    void habilitar_asignacion() {
        jcbx_rut_as.setEnabled(true);
        jcbx_patente_as.setEnabled(true);
        jdt_fecha_as.setEnabled(true);
        btn_guardar_as.setEnabled(true);
        btn_modificar_as.setEnabled(false);
        btn_eliminar_as.setEnabled(false);
        btn_actualizar_as.setEnabled(true);
    }
    
    void habilitar_checklist() {
        jcbx_rut_ch.setEnabled(true);
        jdt_fecha_ch.setEnabled(true);
        txt_actual_ch.setEnabled(true);
        txt_anterior_ch.setEnabled(true);
        jdt_man_ch.setEnabled(true);
        jdt_proxrev_ch.setEnabled(true);
        btn_guardar_ch.setEnabled(true);
        btn_modificar_ch.setEnabled(false);
        btn_eliminar_ch.setEnabled(false);
        btn_actualizar_ch.setEnabled(true);
    }
    
    void deshabilitar_asignacion() {
        txt_cod_as.setEnabled(false);
        jcbx_rut_as.setEnabled(false);
        jcbx_patente_as.setEnabled(false);
        jdt_fecha_as.setEnabled(false);   
        btn_guardar_as.setEnabled(false);
        btn_modificar_as.setEnabled(false);
        btn_eliminar_as.setEnabled(false);
        btn_actualizar_as.setEnabled(false);
    }
    
    void deshabilitar_checklist() {
        txt_codcheck.setEnabled(false);
        jcbx_rut_ch.setEnabled(false);
        txt_patente_ch.setEnabled(false);
        jdt_fecha_ch.setEnabled(false);
        txt_actual_ch.setEnabled(false);
        txt_anterior_ch.setEnabled(false);
        jdt_man_ch.setEnabled(false);
        jdt_proxrev_ch.setEnabled(false);
        btn_guardar_ch.setEnabled(false);
        btn_modificar_ch.setEnabled(false);
        btn_eliminar_ch.setEnabled(false);
        btn_actualizar_ch.setEnabled(false);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdt_fecha_as = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txt_cod_as = new javax.swing.JTextField();
        jcbx_rut_as = new javax.swing.JComboBox<>();
        jcbx_patente_as = new javax.swing.JComboBox<>();
        btn_nuevo_as = new javax.swing.JButton();
        btn_guardar_as = new javax.swing.JButton();
        btn_modificar_as = new javax.swing.JButton();
        btn_eliminar_as = new javax.swing.JButton();
        btn_actualizar_as = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_operario = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdt_fecha_ch = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txt_codcheck = new javax.swing.JTextField();
        jcbx_rut_ch = new javax.swing.JComboBox<>();
        txt_patente_ch = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_actual_ch = new javax.swing.JTextField();
        txt_anterior_ch = new javax.swing.JTextField();
        jdt_proxrev_ch = new com.toedter.calendar.JDateChooser();
        jdt_man_ch = new com.toedter.calendar.JDateChooser();
        btn_nuevo_ch = new javax.swing.JButton();
        btn_guardar_ch = new javax.swing.JButton();
        btn_modificar_ch = new javax.swing.JButton();
        btn_eliminar_ch = new javax.swing.JButton();
        btn_actualizar_ch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_checklist = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel10 = new javax.swing.JLabel();
        jlbl_actividad = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingreso de Checklist");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(java.awt.SystemColor.activeCaption);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/check.png"))); // NOI18N
        jLabel1.setText("Ingreso de CheckList");

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

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel2.setText("Asignación Rut:");

        jLabel3.setText("Asignación Patente:");

        jLabel4.setText("Fecha Asignación:");

        jdt_fecha_as.setDateFormatString("yyyy-MM-dd");

        jLabel5.setText("Cod. Asignación:");

        jcbx_rut_as.setModel(modelcomborut);
        jcbx_rut_as.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbx_rut_asItemStateChanged(evt);
            }
        });

        jcbx_patente_as.setModel(modelcomboptte);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jdt_fecha_as, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cod_as)
                            .addComponent(jcbx_rut_as, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbx_patente_as, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_cod_as, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbx_rut_as, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbx_patente_as, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdt_fecha_as, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        btn_nuevo_as.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_as.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_asActionPerformed(evt);
            }
        });

        btn_guardar_as.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_as.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_asActionPerformed(evt);
            }
        });

        btn_modificar_as.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_as.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_asActionPerformed(evt);
            }
        });

        btn_eliminar_as.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_as.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_asActionPerformed(evt);
            }
        });

        btn_actualizar_as.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_as.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_asActionPerformed(evt);
            }
        });

        jtbl_operario.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbl_operario.setToolTipText("Tabla Asignación [Almacenado]");
        jtbl_operario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_operarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_operario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_nuevo_as, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_as, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_as, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_as, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_as, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_nuevo_as, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar_as, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificar_as, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar_as, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar_as))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Asignación Maquinas - Empleado", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel6.setText("Rut:");

        jLabel7.setText("Patente:");

        jLabel8.setText("Fecha:");

        jdt_fecha_ch.setDateFormatString("yyyy-MM-dd");

        jLabel9.setText("Cod. Check:");

        jcbx_rut_ch.setModel(modelcomborutch);
        jcbx_rut_ch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbx_rut_chItemStateChanged(evt);
            }
        });
        jcbx_rut_ch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbx_rut_chMouseClicked(evt);
            }
        });

        jLabel11.setText("Km. Actual:");

        jLabel12.setText("Km. Anterior:");

        jLabel13.setText("Prox. Revisión:");

        jLabel14.setText("Prox. Mantención:");

        jdt_proxrev_ch.setDateFormatString("yyyy-MM-dd");

        jdt_man_ch.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_codcheck)
                        .addComponent(jcbx_rut_ch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_patente_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdt_fecha_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(42, 42, 42)
                        .addComponent(txt_anterior_ch))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11))
                                .addGap(15, 15, 15))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_actual_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdt_proxrev_ch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdt_man_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_codcheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_actual_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcbx_rut_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txt_anterior_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txt_patente_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(jdt_proxrev_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jdt_fecha_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jdt_man_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_nuevo_ch.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_ch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_chActionPerformed(evt);
            }
        });

        btn_guardar_ch.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_ch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_chActionPerformed(evt);
            }
        });

        btn_modificar_ch.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_ch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_chActionPerformed(evt);
            }
        });

        btn_eliminar_ch.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_ch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_chActionPerformed(evt);
            }
        });

        btn_actualizar_ch.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_ch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_chActionPerformed(evt);
            }
        });

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
        jtbl_checklist.setToolTipText("Tabla Checklist [Almacenado]");
        jtbl_checklist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_checklistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_checklist);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btn_nuevo_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_nuevo_ch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar_ch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificar_ch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_eliminar_ch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_actualizar_ch))
                        .addGap(24, 24, 24))))
        );

        jTabbedPane1.addTab("Checklist", jPanel4);

        jToolBar1.setBackground(java.awt.SystemColor.activeCaption);
        jToolBar1.setRollover(true);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Actividad: ");
        jToolBar1.add(jLabel10);

        jlbl_actividad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_actividad.setForeground(new java.awt.Color(255, 0, 0));
        jToolBar1.add(jlbl_actividad);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevo_asActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_asActionPerformed
        // TODO add your handling code here:
        habilitar_asignacion();
        limpiar_asignacion();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(date);
        txt_cod_as.setText("AS"+dateString);
        btn_guardar_as.setEnabled(true);
        btn_actualizar_as.setEnabled(true);
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_asActionPerformed

    private void btn_guardar_asActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_asActionPerformed
        // TODO add your handling code here:
        if (jdt_fecha_as.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la Fecha de Asignacion", "error",JOptionPane.ERROR_MESSAGE);
        }
        else {
        if (JOptionPane.showConfirmDialog(null,"Revise sus datos", "Confirmar",1)==0){
                try {
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO operario (cod_asign, rut, patente, fecha_asign) values (?,?,?,?)");
                    pps.setString(1, txt_cod_as.getText().toString());
                    String value10 = jcbx_rut_as.getSelectedItem().toString();
                    pps.setString(2, value10);
                    String value11 = jcbx_patente_as.getSelectedItem().toString();
                    pps.setString(3, value11);
                    pps.setString(4, ((JTextField)jdt_fecha_as.getDateEditor().getUiComponent()).getText());
                    pps.executeUpdate();
                    jlbl_actividad.setText("Datos Guardados");
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
        }
        }
    }//GEN-LAST:event_btn_guardar_asActionPerformed

    private void btn_modificar_asActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_asActionPerformed
        // TODO add your handling code here:
            try {
            String sql = "UPDATE operario SET cod_asign=?, rut=?, patente=?, fecha_asign=?"+"Where cod_asign=?";
            int fila = jtbl_operario.getSelectedRow();
            String dao = (String)jtbl_operario.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_cod_as.getText().toString());
            String value50 = jcbx_rut_as.getSelectedItem().toString();
            ps.setString(2, value50);
            String value51 = jcbx_patente_as.getSelectedItem().toString();
            ps.setString(3, value51);
            ps.setString(4, ((JTextField)jdt_fecha_as.getDateEditor().getUiComponent()).getText());
            ps.setString(5, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());

        }
    }//GEN-LAST:event_btn_modificar_asActionPerformed

    private void btn_eliminar_asActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_asActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_operario.getSelectedRow();
            String sql = "DELETE FROM operario WHERE cod_asign='"+jtbl_operario.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_asActionPerformed

    private void btn_actualizar_asActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_asActionPerformed
        // TODO add your handling code here:
        llenar_asignacion();
        jlbl_actividad.setText("Datos de la tabla 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_asActionPerformed

    private void btn_nuevo_chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_chActionPerformed
        // TODO add your handling code here:
        habilitar_checklist();
        limpiar_checklist();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(date);
        txt_codcheck.setText("CHL"+dateString);
        btn_guardar_ch.setEnabled(true);
        btn_actualizar_ch.setEnabled(true);
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_chActionPerformed

    private void btn_guardar_chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_chActionPerformed
        // TODO add your handling code here:
        if (jdt_fecha_ch.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la Fecha que se realizo Checklist", "error",JOptionPane.ERROR_MESSAGE);
        }
        else if (txt_actual_ch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingrese el Kilometro Actual", "error",JOptionPane.ERROR_MESSAGE);
        }
        else if (txt_anterior_ch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingresa el Killometro Anterior", "error",JOptionPane.ERROR_MESSAGE);
        }
        else if (jdt_proxrev_ch.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingresa le fecha de la Proxima Revision", "error",JOptionPane.ERROR_MESSAGE);
        }
        else if (jdt_man_ch.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingresa la fecha de la Proxima Mantencion", "error",JOptionPane.ERROR_MESSAGE);
        }
        else {
            if (JOptionPane.showConfirmDialog(null,"Revise sus datos", "Confirmar",1)==0){
                try {
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO checklist (cod_check, rut, patente, fecha, km_actual, km_total, proxima_rev, proxima_man) values (?,?,?,?,?,?,?,?)");
                    pps.setString(1, txt_codcheck.getText());
                    String value20 = jcbx_rut_ch.getSelectedItem().toString();
                    pps.setString(2, value20);
                    pps.setString(3, txt_patente_ch.getText());
                    pps.setString(4, ((JTextField)jdt_fecha_ch.getDateEditor().getUiComponent()).getText());
                    pps.setString(5, txt_actual_ch.getText());
                    pps.setString(6, txt_anterior_ch.getText());
                    pps.setString(7, ((JTextField)jdt_proxrev_ch.getDateEditor().getUiComponent()).getText());
                    pps.setString(8, ((JTextField)jdt_man_ch.getDateEditor().getUiComponent()).getText());
                    pps.executeUpdate();
                    jlbl_actividad.setText("Datos Guardados");
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_chActionPerformed

    private void btn_modificar_chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_chActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "update checklist set cod_check=?, rut=?, patente=?, fecha=?, km_actual=?, km_total=?, proxima_rev=?, proxima_man=?"+"Where cod_check=?";
            int fila = jtbl_checklist.getSelectedRow();
            String dao = (String)jtbl_checklist.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_codcheck.getText());
            String value60 = jcbx_rut_ch.getSelectedItem().toString();
            ps.setString(2, value60);
            ps.setString(3, txt_patente_ch.getText());
            ps.setString(4, ((JTextField)jdt_fecha_ch.getDateEditor().getUiComponent()).getText());
            ps.setString(5, txt_actual_ch.getText());
            ps.setString(6, txt_anterior_ch.getText());   
            ps.setString(7, ((JTextField)jdt_proxrev_ch.getDateEditor().getUiComponent()).getText());
            ps.setString(8, ((JTextField)jdt_man_ch.getDateEditor().getUiComponent()).getText());
            ps.setString(9, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());

        }
    }//GEN-LAST:event_btn_modificar_chActionPerformed

    private void btn_eliminar_chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_chActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_checklist.getSelectedRow();
            String sql = "DELETE FROM checklist WHERE cod_check='"+jtbl_checklist.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_chActionPerformed

    private void btn_actualizar_chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_chActionPerformed
        // TODO add your handling code here:
        llenar_checklist();
        jlbl_actividad.setText("Datos de la tabla 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_chActionPerformed

    private void jcbx_rut_chItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbx_rut_chItemStateChanged
        // TODO add your handling code here:
    if (evt.getStateChange() == ItemEvent.SELECTED) {
        int fila = jcbx_rut_ch.getSelectedIndex();
        try{
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
            String dateString = formatter.format(date);
            txt_codcheck.setText("CH"+dateString);
            String sql = "select patente from operario WHERE rut='"+modelcomborutch.getSelectedItem()+"'";
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            rs.next();
            txt_patente_ch.setText(rs.getString("patente"));
        }catch (Exception ex) {
            ex.printStackTrace();

            }
    }
    }//GEN-LAST:event_jcbx_rut_chItemStateChanged

    private void jcbx_rut_asItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbx_rut_asItemStateChanged
        // TODO add your handling code here:
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
                String dateString = formatter.format(date);
                txt_cod_as.setText("AS"+dateString);
    }//GEN-LAST:event_jcbx_rut_asItemStateChanged

    private void jtbl_operarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_operarioMouseClicked
        // TODO add your handling code here:
            if (evt.getButton()==1){
            int fila = jtbl_operario.getSelectedRow();
            try{
                btn_guardar_as.setEnabled(false);
                btn_modificar_as.setEnabled(true);
                btn_eliminar_as.setEnabled(true);

                txt_cod_as.setText(jtbl_operario.getValueAt(fila, 0).toString());
                jcbx_rut_as.setSelectedItem(jtbl_operario.getValueAt(fila, 1).toString());
                jcbx_patente_as.setSelectedItem(jtbl_operario.getValueAt(fila, 2).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_operario.getValueAt(fila,3).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);                
                jdt_fecha_as.setDate(fecha);
                
                jlbl_actividad.setText("Datos Traslados a Campos, modifique y aprete boton Modificar");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }//GEN-LAST:event_jtbl_operarioMouseClicked

    private void jcbx_rut_chMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbx_rut_chMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbx_rut_chMouseClicked

    private void jtbl_checklistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_checklistMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_checklist.getSelectedRow();
            try{
                btn_modificar_ch.setEnabled(true);
                btn_eliminar_ch.setEnabled(true);
                btn_guardar_ch.setEnabled(false);

                txt_codcheck.setText(jtbl_checklist.getValueAt(fila, 0).toString());
                jcbx_rut_ch.setSelectedItem(jtbl_checklist.getValueAt(fila, 1).toString());
                txt_patente_ch.setText(jtbl_checklist.getValueAt(fila, 2).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_checklist.getValueAt(fila,5).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_fecha_ch.setDate(fecha);
                
                txt_actual_ch.setText(jtbl_checklist.getValueAt(fila, 6).toString());
                txt_anterior_ch.setText(jtbl_checklist.getValueAt(fila, 7).toString());
                
                String strfecha2 = (String) jtbl_checklist.getValueAt(fila,8).toString().trim();
                Date fecha2 = formatoDelTexto.parse(strfecha2);
                jdt_proxrev_ch.setDate(fecha2);
                
                String strfecha3 = (String) jtbl_checklist.getValueAt(fila,9).toString().trim();
                Date fecha3 = formatoDelTexto.parse(strfecha3);
                jdt_man_ch.setDate(fecha3);
                
                jlbl_actividad.setText("Datos Traslados a Campos, modifique y aprete boton Modificar");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }//GEN-LAST:event_jtbl_checklistMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar_as;
    private javax.swing.JButton btn_actualizar_ch;
    private javax.swing.JButton btn_eliminar_as;
    private javax.swing.JButton btn_eliminar_ch;
    private javax.swing.JButton btn_guardar_as;
    private javax.swing.JButton btn_guardar_ch;
    private javax.swing.JButton btn_modificar_as;
    private javax.swing.JButton btn_modificar_ch;
    private javax.swing.JButton btn_nuevo_as;
    private javax.swing.JButton btn_nuevo_ch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> jcbx_patente_as;
    private javax.swing.JComboBox<String> jcbx_rut_as;
    private javax.swing.JComboBox<String> jcbx_rut_ch;
    private com.toedter.calendar.JDateChooser jdt_fecha_as;
    private com.toedter.calendar.JDateChooser jdt_fecha_ch;
    private com.toedter.calendar.JDateChooser jdt_man_ch;
    private com.toedter.calendar.JDateChooser jdt_proxrev_ch;
    private javax.swing.JLabel jlbl_actividad;
    private javax.swing.JTable jtbl_checklist;
    private javax.swing.JTable jtbl_operario;
    private javax.swing.JTextField txt_actual_ch;
    private javax.swing.JTextField txt_anterior_ch;
    private javax.swing.JTextField txt_cod_as;
    private javax.swing.JTextField txt_codcheck;
    private javax.swing.JTextField txt_patente_ch;
    // End of variables declaration//GEN-END:variables
}
