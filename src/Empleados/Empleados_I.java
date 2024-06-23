/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class Empleados_I extends javax.swing.JInternalFrame {
    DefaultTableModel model;
    Conexion.conexion conexion = new Conexion.conexion();
    Connection cn = conexion.connect();
    Statement sent;
    /**
     * Creates new form Empleados_I
     */
    public Empleados_I() {
        initComponents();
        deshabilitar_empleado();
        deshabilitar_sueldo();
        limpiar_empleado();
        limpiar_sueldo();
    }
    
    void habilitar_empleado() {
        txt_rut_em.setEnabled(true);
        jdt_ingreso_em.setEnabled(true);
        txt_nombres.setEnabled(true);
        txt_apellidos.setEnabled(true);
        jcbx_sexo.setEnabled(true);
        jcbx_estado.setEnabled(true);
        txt_direccion.setEnabled(true);
        txt_ciudad.setEnabled(true);
        txt_telefono.setEnabled(true);
        txt_email.setEnabled(true);
        txt_salud.setEnabled(true);
        txt_afp.setEnabled(true);
        jcbx_cargo.setEnabled(true);
        txt_sueldobruto.setEnabled(true);
        jdt_vencimiento.setEnabled(true);
        btn_guardar_em.setEnabled(true);
        btn_modificar_em.setEnabled(false);
        btn_eliminar_em.setEnabled(false);
        btn_actualizar_em.setEnabled(true);
    }
    
    void habilitar_sueldo() {
        jcbx_mes_su.setEnabled(true);
        jcbx_ano_su.setEnabled(true);
        txt_afp_su.setEnabled(true);
        txt_salud_su.setEnabled(true);
        txt_HEO_su.setEnabled(true);
        txt_HNT_su.setEnabled(true);
        txt_bonos_su.setEnabled(true);
        txt_locos_su.setEnabled(true);
        txt_anti_su.setEnabled(true);
        btn_guardar_su.setEnabled(true);
        btn_modificar_su.setEnabled(false);
        btn_eliminar_su.setEnabled(false);
        btn_actualizar_su.setEnabled(true);
    }
    
    void limpiar_empleado() {
        txt_rut_em.setText("");
        jdt_ingreso_em.setCalendar(null);
        txt_nombres.setText("");
        txt_apellidos.setText("");
        txt_direccion.setText("");
        txt_ciudad.setText("");
        txt_telefono.setText("");
        txt_email.setText("");
        txt_salud.setText("");
        txt_afp.setText("");
        txt_sueldobruto.setText("");
        jdt_vencimiento.setCalendar(null);
    }
    
    void limpiar_sueldo() {
        txt_afp_su.setText("");
        txt_salud_su.setText("");
        txt_HEO_su.setText("");
        txt_HNT_su.setText("");
        txt_bonos_su.setText("");
        txt_locos_su.setText("");
        txt_anti_su.setText("");    
    }
    
    void deshabilitar_empleado() {
        txt_rut_em.setEnabled(false);
        jdt_ingreso_em.setEnabled(false);
        txt_nombres.setEnabled(false);
        txt_apellidos.setEnabled(false);
        jcbx_sexo.setEnabled(false);
        jcbx_estado.setEnabled(false);
        txt_direccion.setEnabled(false);
        txt_ciudad.setEnabled(false);
        txt_telefono.setEnabled(false);
        txt_email.setEnabled(false);
        txt_salud.setEnabled(false);
        txt_afp.setEnabled(false);
        jcbx_cargo.setEnabled(false);
        txt_sueldobruto.setEnabled(false);
        jdt_vencimiento.setEnabled(false);
        btn_guardar_em.setEnabled(false);
        btn_modificar_em.setEnabled(false);
        btn_eliminar_em.setEnabled(false);
        btn_actualizar_em.setEnabled(false);
    }
    
    void deshabilitar_sueldo() {
        txt_folio_su.setEnabled(false);
        txt_rut_su.setEnabled(false);
        jcbx_mes_su.setEnabled(false);
        jcbx_ano_su.setEnabled(false);
        txt_afp_su.setEnabled(false);
        txt_salud_su.setEnabled(false);
        txt_HEO_su.setEnabled(false);
        txt_HNT_su.setEnabled(false);
        txt_bonos_su.setEnabled(false);
        txt_locos_su.setEnabled(false);
        txt_sb_su.setEnabled(false);
        txt_anti_su.setEnabled(false);
        btn_guardar_su.setEnabled(false);
        btn_modificar_su.setEnabled(false);
        btn_eliminar_su.setEnabled(false);
        btn_actualizar_su.setEnabled(false);
    }
    
    void llenar_empleados() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Rut","Fecha Ingreso","Nombres","Apellidos","Sexo","Estado Civil","Direccion","Ciudad","Telefono","E-mail","Salud","AFP","Cargo","Sueldo Bruto","V° Contrato"};
            String sql = "select rut, fecha_ingreso, nombres, apellidos, sexo, estado_civil, direccion, ciudad, telefono, mail, salud, afp, cargo, sueldo_bruto, venc_contra from empleado";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [15];
            while (rs.next()){
                //fila[0]=rs.getString("id");
                fila[0]=rs.getString("rut");
                fila[1]=rs.getString("fecha_ingreso");
                fila[2]=rs.getString("nombres");
                fila[3]=rs.getString("apellidos");
                fila[4]=rs.getString("sexo");
                fila[5]=rs.getString("estado_civil");
                fila[6]=rs.getString("direccion");
                fila[7]=rs.getString("ciudad");
                fila[8]=rs.getString("telefono");
                fila[9]=rs.getString("mail");
                fila[10]=rs.getString("salud");
                fila[11]=rs.getString("afp");
                fila[12]=rs.getString("cargo");
                fila[13]=rs.getString("sueldo_bruto");
                fila[14]=rs.getString("venc_contra");
                
            model.addRow(fila);
            }
            jtbl_empleados.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_empleadosu() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Rut","Nombres","Apellidos","AFP","Salud","Sueldo Bruto"};
            String sql = "select rut, nombres, apellidos, afp, salud, sueldo_bruto from empleado";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [6];
            while (rs.next()){
                //fila[0]=rs.getString("id");
                fila[0]=rs.getString("rut");
                fila[1]=rs.getString("nombres");
                fila[2]=rs.getString("apellidos");
                fila[3]=rs.getString("afp");
                fila[4]=rs.getString("salud");
                fila[5]=rs.getString("sueldo_bruto");
                
            model.addRow(fila);
            }
            jtbl_empleado_su.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_sueldo(){
        try {
            cn = conexion.connect();
            String [] titulos = {"#","Rut","Mes","Año","AFP","Salud","HEO","HNT","Bonificación","Locomoción","Anticipos","Sueldo_Bruto"};
            String sql = "SELECT cod_folio, rut, mes, año, afp, salud, heo, hnt, bonificacion, locomocion, anticipos, sueldo_bruto FROM sueldo";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [12];
            while (rs.next()){
                fila[0]=rs.getString("cod_folio");
                fila[1]=rs.getString("rut");
                fila[2]=rs.getString("mes");
                fila[3]=rs.getString("año");
                fila[4]=rs.getString("afp");
                fila[5]=rs.getString("salud");
                fila[6]=rs.getString("heo");
                fila[7]=rs.getString("hnt");
                fila[8]=rs.getString("bonificacion");
                fila[9]=rs.getString("locomocion");
                fila[10]=rs.getString("anticipos");
                fila[11]=rs.getString("sueldo_bruto");
                
            model.addRow(fila);
            }
            jtbl_sueldo.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdt_ingreso_em = new com.toedter.calendar.JDateChooser();
        txt_rut_em = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_ciudad = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_afp = new javax.swing.JTextField();
        txt_salud = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_sueldobruto = new javax.swing.JTextField();
        jdt_vencimiento = new com.toedter.calendar.JDateChooser();
        jcbx_cargo = new javax.swing.JComboBox<>();
        jcbx_estado = new javax.swing.JComboBox<>();
        jcbx_sexo = new javax.swing.JComboBox<>();
        btn_nuevo_em = new javax.swing.JButton();
        btn_guardar_em = new javax.swing.JButton();
        btn_modificar_em = new javax.swing.JButton();
        btn_eliminar_em = new javax.swing.JButton();
        btn_actualizar_em = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_empleados = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_folio_su = new javax.swing.JTextField();
        txt_HEO_su = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_HNT_su = new javax.swing.JTextField();
        txt_anti_su = new javax.swing.JTextField();
        txt_locos_su = new javax.swing.JTextField();
        txt_bonos_su = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_rut_su = new javax.swing.JTextField();
        jcbx_mes_su = new javax.swing.JComboBox<>();
        jcbx_ano_su = new javax.swing.JComboBox<>();
        txt_afp_su = new javax.swing.JTextField();
        txt_salud_su = new javax.swing.JTextField();
        txt_sb_su = new javax.swing.JTextField();
        btn_nuevo_su = new javax.swing.JButton();
        btn_guardar_su = new javax.swing.JButton();
        btn_modificar_su = new javax.swing.JButton();
        btn_eliminar_su = new javax.swing.JButton();
        btn_actualizar_su = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_empleado_su = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_sueldo = new javax.swing.JTable();
        btn_transaccion = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel9 = new javax.swing.JLabel();
        jlbl_actividad = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingreso de Empleados");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(java.awt.SystemColor.activeCaption);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/empleado.png"))); // NOI18N
        jLabel1.setText("Ingreso de Empleados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel2.setText("Rut:");

        jLabel3.setText("Fecha Ingreso:");

        jLabel4.setText("Nombres:");

        jLabel5.setText("Apellidos:");

        jLabel6.setText("Sexo:");

        jLabel7.setText("Estado Civil:");

        jLabel8.setText("Direccion:");

        jdt_ingreso_em.setBackground(java.awt.SystemColor.activeCaption);
        jdt_ingreso_em.setDateFormatString("yyyy-MM-dd");

        jLabel10.setText("Ciudad:");

        jLabel11.setText("Telefono:");

        jLabel12.setText("E-Mail:");

        jLabel13.setText("Salud:");

        jLabel14.setText("AFP:");

        jLabel15.setText("Cargo:");

        jLabel16.setText("Sueldo Bruto:");

        jLabel17.setText("Vencimiento Cont:");

        jdt_vencimiento.setBackground(java.awt.SystemColor.activeCaption);
        jdt_vencimiento.setDateFormatString("yyyy-MM-dd");

        jcbx_cargo.setBackground(java.awt.SystemColor.activeCaption);
        jcbx_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Logistica", "Secretaria", "Administracion", "Gerencia" }));

        jcbx_estado.setBackground(java.awt.SystemColor.activeCaption);
        jcbx_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado" }));

        jcbx_sexo.setBackground(java.awt.SystemColor.activeCaption);
        jcbx_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdt_ingreso_em, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(txt_rut_em, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbx_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbx_sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_salud, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_afp, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_sueldobruto)
                            .addComponent(jdt_vencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbx_cargo, 0, 105, Short.MAX_VALUE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_rut_em, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jdt_ingreso_em, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcbx_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcbx_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jcbx_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(txt_sueldobruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)))
                            .addComponent(jdt_vencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_salud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_afp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_nuevo_em.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_em.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_emActionPerformed(evt);
            }
        });

        btn_guardar_em.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_em.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_emActionPerformed(evt);
            }
        });

        btn_modificar_em.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_em.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_emActionPerformed(evt);
            }
        });

        btn_eliminar_em.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_em.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_emActionPerformed(evt);
            }
        });

        btn_actualizar_em.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_em.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_emActionPerformed(evt);
            }
        });

        jtbl_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Rut", "Fecha", "Nombre", "Apellido", "Sexo", "Estado", "Dirección", "Ciudad", "Telefono", "E-mail", "Salud", "AFP", "Cargo", "Sueldo Bruto", "V° Contrato"
            }
        ));
        jtbl_empleados.setToolTipText("Tabla Empleados [Almacenado]");
        jtbl_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_empleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_empleados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btn_nuevo_em, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_em, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_em, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_em, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_em, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_nuevo_em, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar_em, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificar_em, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar_em, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar_em))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ingreso Empleados", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        jPanel7.setBackground(java.awt.SystemColor.activeCaption);
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel18.setText("# Folio:");

        jLabel19.setText("Rut:");

        jLabel20.setText("Mes:");

        jLabel21.setText("Año:");

        jLabel22.setText("AFP:");

        jLabel23.setText("Salud:");

        jLabel24.setText("HEO:");

        jLabel25.setText("HNT:");

        jLabel27.setText("Bonificación:");

        jLabel28.setText("Locomoción:");

        jLabel29.setText("Anticipos:");

        jLabel30.setText("Sueldo Bruto:");

        jcbx_mes_su.setBackground(java.awt.SystemColor.activeCaption);
        jcbx_mes_su.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jcbx_ano_su.setBackground(java.awt.SystemColor.activeCaption);
        jcbx_ano_su.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065" }));
        jcbx_ano_su.setSelectedIndex(36);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_folio_su, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_rut_su)
                    .addComponent(jcbx_mes_su, 0, 105, Short.MAX_VALUE)
                    .addComponent(jcbx_ano_su, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_afp_su)
                    .addComponent(txt_salud_su))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_anti_su, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_locos_su, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_bonos_su, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_HNT_su, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_HEO_su, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(txt_sb_su, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_folio_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txt_rut_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jcbx_mes_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jcbx_ano_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txt_afp_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txt_HEO_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txt_HNT_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_salud_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30)
                                    .addComponent(txt_sb_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(txt_bonos_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(txt_locos_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(txt_anti_su, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_nuevo_su.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_su.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_su.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_suActionPerformed(evt);
            }
        });

        btn_guardar_su.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_su.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_su.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_suActionPerformed(evt);
            }
        });

        btn_modificar_su.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_su.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_su.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_suActionPerformed(evt);
            }
        });

        btn_eliminar_su.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_su.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_su.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_suActionPerformed(evt);
            }
        });

        btn_actualizar_su.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_su.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_su.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_suActionPerformed(evt);
            }
        });

        jtbl_empleado_su.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Rut", "Nombres", "Apellidos", "AFP", "Salud", "Sueldo Bruto"
            }
        ));
        jtbl_empleado_su.setToolTipText("Tabla Empleados para Llenado de Campos");
        jtbl_empleado_su.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_empleado_suMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_empleado_su);

        jtbl_sueldo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Rut", "Mes", "Año", "AFP", "Salud", "HEO", "HNT", "Bonificación", "Locomoción", "Anticipos", "Sueldo Bruto"
            }
        ));
        jtbl_sueldo.setToolTipText("Tabla Detalle Sueldo para Impresión de Sueldos");
        jtbl_sueldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_sueldoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbl_sueldo);

        btn_transaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/1.png"))); // NOI18N
        btn_transaccion.setToolTipText("Traspaso a Libro de Sueldos");
        btn_transaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_nuevo_su, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_su, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_su, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_su, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_su, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_transaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_nuevo_su, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar_su, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificar_su, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar_su, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar_su, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_transaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ingreso de Sueldo", jPanel4);

        jToolBar1.setBackground(java.awt.SystemColor.activeCaption);
        jToolBar1.setRollover(true);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Actividad: ");
        jToolBar1.add(jLabel9);

        jlbl_actividad.setBackground(new java.awt.Color(255, 0, 0));
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevo_emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_emActionPerformed
        // TODO add your handling code here:
        habilitar_empleado();
        limpiar_empleado();
        btn_guardar_em.setEnabled(true);
        btn_actualizar_em.setEnabled(true);
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_emActionPerformed

    private void btn_actualizar_emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_emActionPerformed
        // TODO add your handling code here:
        llenar_empleados();
        jlbl_actividad.setText("Datos de la tabla 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_emActionPerformed

    private void btn_guardar_emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_emActionPerformed
        // TODO add your handling code here:
        if (txt_rut_em.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese el Rut del Empleado");
        }
        else if (jdt_ingreso_em.getDate() == null) {
            jlbl_actividad.setText("Ingrese la Fecha de inicio de Contrato");
        }
        else if (txt_nombres.getText().isEmpty()){
            jlbl_actividad.setText("Ingrese los Nombres del Empleado");
        }
        else if (txt_apellidos.getText().isEmpty()){
            jlbl_actividad.setText("Ingrese los Apellidos del Empleado");
        }
        else if (txt_direccion.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese la direccion del Empleado");
        }
        else if (txt_ciudad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese la Ciudad del Empleado");
        }
        else if (txt_telefono.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese el Telefono del Empleado");
        }
        else if (txt_email.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese el Email del Empleado");
        }
        else if (txt_salud.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese la entidad Salud del Empleado");
        }
        else if (txt_afp.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese la entidad AFP del Empleado");
        }
        else if (txt_sueldobruto.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese el Sueldo del Empleado");
        }
        else if (jdt_vencimiento.getDate() == null) {
            jlbl_actividad.setText("Ingrese la Fecha de Termino del contrato");
        }
        else {
            if (JOptionPane.showConfirmDialog(null,"Revise sus datos", "Confirmar",1)==0){
                try {
                    com.mysql.jdbc.PreparedStatement pps = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("INSERT INTO empleado (rut, fecha_ingreso, nombres, apellidos, sexo, estado_civil, direccion, ciudad, telefono, mail, salud, afp, cargo, sueldo_bruto, venc_contra) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pps.setString(1, txt_rut_em.getText());
                    pps.setString(2, ((JTextField)jdt_ingreso_em.getDateEditor().getUiComponent()).getText());
                    pps.setString(3, txt_nombres.getText());
                    pps.setString(4, txt_apellidos.getText());
                    pps.setString(5, jcbx_sexo.getSelectedItem().toString());
                    pps.setString(6, jcbx_estado.getSelectedItem().toString());
                    pps.setString(7, txt_direccion.getText());
                    pps.setString(8, txt_ciudad.getText());
                    pps.setString(9, txt_telefono.getText());
                    pps.setString(10, txt_email.getText());
                    pps.setString(11, txt_salud.getText());
                    pps.setString(12, txt_afp.getText());
                    pps.setString(13, jcbx_cargo.getSelectedItem().toString());
                    pps.setString(14, txt_sueldobruto.getText());
                    pps.setString(15, ((JTextField)jdt_vencimiento.getDateEditor().getUiComponent()).getText());
                    
                    pps.executeUpdate();
                    jlbl_actividad.setText("Guardado, Actualize los datos de la tabla");
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_emActionPerformed

    private void btn_modificar_emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_emActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE empleado SET rut=?, fecha_ingreso=?, nombres=?, apellidos=?, sexo=?, estado_civil=?, direccion=?, ciudad=?, telefono=?, mail=?, salud=?, afp=?, cargo=?, sueldo_bruto=?, venc_contra=?"+"WHERE rut=?";
            int fila = jtbl_empleados.getSelectedRow();
            String dao = (String)jtbl_empleados.getValueAt(fila, 0);
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_rut_em.getText());
            ps.setString(2, ((JTextField)jdt_ingreso_em.getDateEditor().getUiComponent()).getText());
            ps.setString(3, txt_nombres.getText());
            ps.setString(4, txt_apellidos.getText());
            ps.setString(5, jcbx_sexo.getSelectedItem().toString());
            ps.setString(6, jcbx_estado.getSelectedItem().toString());
            ps.setString(7, txt_direccion.getText());
            ps.setString(8, txt_ciudad.getText());
            ps.setString(9, txt_telefono.getText());
            ps.setString(10, txt_email.getText());
            ps.setString(11, txt_salud.getText());
            ps.setString(12, txt_afp.getText());
            ps.setString(13, jcbx_cargo.getSelectedItem().toString());
            ps.setString(14, txt_sueldobruto.getText());
            ps.setString(15, ((JTextField)jdt_vencimiento.getDateEditor().getUiComponent()).getText());
            ps.setString(16, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());

        }
    }//GEN-LAST:event_btn_modificar_emActionPerformed

    private void jtbl_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_empleadosMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_empleados.getSelectedRow();
            try{
                
                btn_guardar_em.setEnabled(false);
                btn_modificar_em.setEnabled(true);
                btn_eliminar_em.setEnabled(true);

                txt_rut_em.setText(jtbl_empleados.getValueAt(fila, 0).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_empleados.getValueAt(fila,1).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_ingreso_em.setDate(fecha);
                
                txt_nombres.setText(jtbl_empleados.getValueAt(fila, 2).toString());
                txt_apellidos.setText(jtbl_empleados.getValueAt(fila, 3).toString());
                jcbx_sexo.setSelectedItem(jtbl_empleados.getValueAt(fila, 4).toString());
                jcbx_estado.setSelectedItem(jtbl_empleados.getValueAt(fila, 5).toString());
                txt_direccion.setText(jtbl_empleados.getValueAt(fila, 6).toString());
                txt_ciudad.setText(jtbl_empleados.getValueAt(fila, 7).toString());
                txt_telefono.setText(jtbl_empleados.getValueAt(fila, 8).toString());
                txt_email.setText(jtbl_empleados.getValueAt(fila, 9).toString());
                txt_salud.setText(jtbl_empleados.getValueAt(fila, 10).toString());
                txt_afp.setText(jtbl_empleados.getValueAt(fila, 11).toString());               
                jcbx_cargo.setSelectedItem(jtbl_empleados.getValueAt(fila, 12).toString());
                txt_sueldobruto.setText(jtbl_empleados.getValueAt(fila, 13).toString());
                
                String strfecha2 = (String) jtbl_empleados.getValueAt(fila,14).toString().trim();
                Date fecha2 = formatoDelTexto.parse(strfecha2);
                jdt_vencimiento.setDate(fecha2);
                jlbl_actividad.setText("Datos Traslados a Campos, modifique y aprete boton Modificar");
            }catch (Exception ex) {
                ex.printStackTrace();

            }

        }
    }//GEN-LAST:event_jtbl_empleadosMouseClicked

    private void btn_eliminar_emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_emActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_empleados.getSelectedRow();
            String sql = "DELETE FROM empleado WHERE rut='"+jtbl_empleados.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_emActionPerformed

    private void btn_nuevo_suActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_suActionPerformed
        // TODO add your handling code here:
        habilitar_sueldo();
        limpiar_sueldo();
        btn_guardar_su.setEnabled(true);
        btn_actualizar_su.setEnabled(true);
        jlbl_actividad.setText("Habilitado y Limpiado");        
    }//GEN-LAST:event_btn_nuevo_suActionPerformed

    private void btn_guardar_suActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_suActionPerformed
        // TODO add your handling code here:
    if (jtbl_sueldo.getRowCount()==0) {
        if (txt_folio_su.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese el Codigo de Folio del Empleado");
        }
        else if (txt_rut_su.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese el Rut del Empleado");
        }
        else if (txt_afp_su.getText().isEmpty()){
            jlbl_actividad.setText("Ingrese la AFP en Numeros (Porcentaje del Empleado)");
        }
        else if (txt_salud_su.getText().isEmpty()){
            jlbl_actividad.setText("Ingrese la Salud en Numeros (Porcentaje) del Empleado");
        }
        else if (txt_HEO_su.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese las Horas Extras Ordinarias en Numeros del Empleado");
        }
        else if (txt_HNT_su.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese las Horas no Trabajadas en Numeros del Empleado");
        }
        else if (txt_bonos_su.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese las Bonificaciones extras del Empleado");
        }
        else if (txt_locos_su.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese el Bono de Locomocion del Empleado");
        }
        else if (txt_sb_su.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese el Sueldo Bruto del Empleado");
        }
        else if (txt_anti_su.getText().isEmpty()) {
            jlbl_actividad.setText("Ingrese el Anticipo del Empleado");
        }
        else {
            if (JOptionPane.showConfirmDialog(null,"Revise sus datos", "Confirmar",1)==0){
                try {
                    com.mysql.jdbc.PreparedStatement pps = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("INSERT INTO sueldo (cod_folio, rut, mes, año, afp, salud, heo, hnt, bonificacion, locomocion, sueldo_bruto, anticipos) values (?,?,?,?,?,?,?,?,?,?,?,?)");
                    pps.setString(1, txt_folio_su.getText());
                    pps.setString(2, txt_rut_su.getText());
                    pps.setString(3, jcbx_mes_su.getSelectedItem().toString());
                    pps.setString(4, jcbx_ano_su.getSelectedItem().toString());
                    pps.setString(5, txt_afp_su.getText());
                    pps.setString(6, txt_salud_su.getText());
                    pps.setString(7, txt_HEO_su.getText());
                    pps.setString(8, txt_HNT_su.getText());
                    pps.setString(9, txt_bonos_su.getText());
                    pps.setString(10, txt_locos_su.getText());
                    pps.setString(11, txt_sb_su.getText());
                    pps.setString(12, txt_anti_su.getText());                    
                    pps.executeUpdate();
                    jlbl_actividad.setText("Guardado, Actualize los datos de la tabla");
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    } else {
        jlbl_actividad.setText("No se puede agregar otra fila. Solo se usa para reporte");
    }
    }//GEN-LAST:event_btn_guardar_suActionPerformed

    private void btn_modificar_suActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_suActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE sueldo SET cod_folio=?, rut=?, mes=?, año=?, afp=?, salud=?, heo=?, hnt=?, bonificacion=?, locomocion=?, sueldo_bruto=?, anticipos=?"+"WHERE cod_folio=?";
            int fila = jtbl_sueldo.getSelectedRow();
            String dao = (String)jtbl_sueldo.getValueAt(fila, 0);
            com.mysql.jdbc.PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_folio_su.getText());
            ps.setString(2, txt_rut_su.getText());
            ps.setString(3, jcbx_mes_su.getSelectedItem().toString());
            ps.setString(4, jcbx_ano_su.getSelectedItem().toString());
            ps.setString(5, txt_afp_su.getText());
            ps.setString(6, txt_salud_su.getText());
            ps.setString(7, txt_HEO_su.getText());
            ps.setString(8, txt_HNT_su.getText());
            ps.setString(9, txt_bonos_su.getText());
            ps.setString(10, txt_locos_su.getText());
            ps.setString(11, txt_sb_su.getText());
            ps.setString(12, txt_anti_su.getText());
            ps.setString(13, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());

        }        
    }//GEN-LAST:event_btn_modificar_suActionPerformed

    private void btn_eliminar_suActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_suActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_sueldo.getSelectedRow();
            String sql = "DELETE FROM sueldo WHERE cod_folio='"+jtbl_sueldo.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }        
    }//GEN-LAST:event_btn_eliminar_suActionPerformed

    private void btn_actualizar_suActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_suActionPerformed
        // TODO add your handling code here:
        llenar_sueldo();
        llenar_empleadosu();
        jlbl_actividad.setText("Datos de la tabla 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_suActionPerformed

    private void jtbl_empleado_suMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_empleado_suMouseClicked
        // TODO add your handling code here:
            if (evt.getButton()==1){
            int fila = jtbl_empleado_su.getSelectedRow();
            try{
                habilitar_sueldo();
                limpiar_sueldo();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
                String dateString = formatter.format(date);
                txt_folio_su.setText("F"+dateString);
                txt_rut_su.setText(jtbl_empleado_su.getValueAt(fila, 0).toString());
                txt_sb_su.setText(jtbl_empleado_su.getValueAt(fila, 5).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, cambielos y aprete boton Modificar");
            }catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_jtbl_empleado_suMouseClicked

    private void jtbl_sueldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_sueldoMouseClicked
        // TODO add your handling code here:
            if (evt.getButton()==1){
            int fila = jtbl_sueldo.getSelectedRow();
            try{
                habilitar_sueldo();
                limpiar_sueldo();
                btn_guardar_su.setEnabled(false);
                btn_modificar_su.setEnabled(true);
                btn_eliminar_su.setEnabled(true);

                txt_rut_su.setText(jtbl_sueldo.getValueAt(fila, 1).toString());
                txt_folio_su.setText(jtbl_sueldo.getValueAt(fila, 0).toString());
                jcbx_mes_su.setSelectedItem(jtbl_sueldo.getValueAt(fila, 2).toString());
                jcbx_ano_su.setSelectedItem(jtbl_sueldo.getValueAt(fila, 3).toString());
                txt_afp_su.setText(jtbl_sueldo.getValueAt(fila, 4).toString());
                txt_salud_su.setText(jtbl_sueldo.getValueAt(fila, 5).toString());
                txt_HEO_su.setText(jtbl_sueldo.getValueAt(fila, 6).toString());
                txt_HNT_su.setText(jtbl_sueldo.getValueAt(fila, 7).toString());
                txt_bonos_su.setText(jtbl_sueldo.getValueAt(fila, 8).toString());
                txt_locos_su.setText(jtbl_sueldo.getValueAt(fila, 9).toString());
                txt_anti_su.setText(jtbl_sueldo.getValueAt(fila, 10).toString());
                txt_sb_su.setText(jtbl_sueldo.getValueAt(fila, 11).toString());
                
                jlbl_actividad.setText("Datos Traslados a Campos, cambielos y aprete boton Modificar");
            }catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_jtbl_sueldoMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btn_transaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaccionActionPerformed
        // TODO add your handling code here:
    if (JOptionPane.showConfirmDialog(null,"Revise sus datos", "Confirmar",1)==0){
                try {
                    com.mysql.jdbc.PreparedStatement pps = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("INSERT INTO libro_sueldo (cod_folio, rut, mes, año, afp, salud, heo, hnt, bonificacion, locomocion, sueldo_bruto, anticipos) values (?,?,?,?,?,?,?,?,?,?,?,?)");
                    pps.setString(1, txt_folio_su.getText());
                    pps.setString(2, txt_rut_su.getText());
                    pps.setString(3, jcbx_mes_su.getSelectedItem().toString());
                    pps.setString(4, jcbx_ano_su.getSelectedItem().toString());
                    pps.setString(5, txt_afp_su.getText());
                    pps.setString(6, txt_salud_su.getText());
                    pps.setString(7, txt_HEO_su.getText());
                    pps.setString(8, txt_HNT_su.getText());
                    pps.setString(9, txt_bonos_su.getText());
                    pps.setString(10, txt_locos_su.getText());
                    pps.setString(11, txt_sb_su.getText());
                    pps.setString(12, txt_anti_su.getText());                    
                    pps.executeUpdate();
                    jlbl_actividad.setText("Guardado, Actualize los datos de la tabla");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                try {
                    PreparedStatement ps = (PreparedStatement) cn.prepareStatement("delete from sueldo");
                    ps.executeUpdate();
                    jlbl_actividad.setText("Datos eliminados de sueldo");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
    llenar_sueldo();
    llenar_empleadosu();
    limpiar_sueldo();
    }
    }//GEN-LAST:event_btn_transaccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar_em;
    private javax.swing.JButton btn_actualizar_su;
    private javax.swing.JButton btn_eliminar_em;
    private javax.swing.JButton btn_eliminar_su;
    private javax.swing.JButton btn_guardar_em;
    private javax.swing.JButton btn_guardar_su;
    private javax.swing.JButton btn_modificar_em;
    private javax.swing.JButton btn_modificar_su;
    private javax.swing.JButton btn_nuevo_em;
    private javax.swing.JButton btn_nuevo_su;
    private javax.swing.JButton btn_transaccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> jcbx_ano_su;
    private javax.swing.JComboBox<String> jcbx_cargo;
    private javax.swing.JComboBox<String> jcbx_estado;
    private javax.swing.JComboBox<String> jcbx_mes_su;
    private javax.swing.JComboBox<String> jcbx_sexo;
    private com.toedter.calendar.JDateChooser jdt_ingreso_em;
    private com.toedter.calendar.JDateChooser jdt_vencimiento;
    private javax.swing.JLabel jlbl_actividad;
    private javax.swing.JTable jtbl_empleado_su;
    private javax.swing.JTable jtbl_empleados;
    private javax.swing.JTable jtbl_sueldo;
    private javax.swing.JTextField txt_HEO_su;
    private javax.swing.JTextField txt_HNT_su;
    private javax.swing.JTextField txt_afp;
    private javax.swing.JTextField txt_afp_su;
    private javax.swing.JTextField txt_anti_su;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_bonos_su;
    private javax.swing.JTextField txt_ciudad;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_folio_su;
    private javax.swing.JTextField txt_locos_su;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_rut_em;
    private javax.swing.JTextField txt_rut_su;
    private javax.swing.JTextField txt_salud;
    private javax.swing.JTextField txt_salud_su;
    private javax.swing.JTextField txt_sb_su;
    private javax.swing.JTextField txt_sueldobruto;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
