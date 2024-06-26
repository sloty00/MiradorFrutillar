/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maquinaria;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class Maquinaria_I extends javax.swing.JInternalFrame {
    DefaultTableModel model;    
    Conexion.conexion conexion = new Conexion.conexion();
    Connection cn = conexion.connect();
    Statement sent;
    /**
     * Creates new form Maquinaria_I
     */
    public Maquinaria_I() {
        initComponents();
        deshabilitar_ar();
        deshabilitar_ad();
        limpiar_ar();
        limpiar_ad();
    }
    
    void llenar_arriendo() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Folio","Patente","T° Vehiculo","Marca","Modelo","Año","Giro", "N° Chasis","Desde", "Hasta", "Precio","Nombre","Direccion","Ciudad","Telefono","Email"};
            String sql = "SELECT num_folio, patente, tipo_vehiculo, marca, modelo, año, giro, num_chasis, desde, hasta, precio_arriendo, nombre, direccion, ciudad, telefono, email, tipo FROM `maquinas` WHERE tipo='Arriendo'";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [16];
            while (rs.next()){
                fila[0]=rs.getString("num_folio");
                fila[1]=rs.getString("patente");
                fila[2]=rs.getString("tipo_vehiculo");
                fila[3]=rs.getString("marca");
                fila[4]=rs.getString("modelo");
                fila[5]=rs.getString("año");
                fila[6]=rs.getString("giro");
                fila[7]=rs.getString("num_chasis");
                fila[8]=rs.getString("desde");
                fila[9]=rs.getString("hasta");
                fila[10]=rs.getString("precio_arriendo");
                fila[11]=rs.getString("nombre");
                fila[12]=rs.getString("direccion");
                fila[13]=rs.getString("ciudad");
                fila[14]=rs.getString("telefono");
                fila[15]=rs.getString("email");
            model.addRow(fila);
            }
            jtbl_maquina_ar.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_adquisicion() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Folio","Patente","T° Vehiculo","Marca","Modelo","Año","N° Chasis","Fecha", "Km Inicial", "Precio","Vida Util"};
            String sql = "SELECT num_folio, patente, tipo_vehiculo, marca, modelo, año, num_chasis, fecha_ad, km_inicial, valor, vida_util, tipo FROM `maquinas` WHERE tipo='Adquisicion'";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [11];
            while (rs.next()){
                fila[0]=rs.getString("num_folio");
                fila[1]=rs.getString("patente");
                fila[2]=rs.getString("tipo_vehiculo");
                fila[3]=rs.getString("marca");
                fila[4]=rs.getString("modelo");
                fila[5]=rs.getString("año");
                fila[6]=rs.getString("num_chasis");
                fila[7]=rs.getString("fecha_ad");
                fila[8]=rs.getString("km_inicial");
                fila[9]=rs.getString("valor");
                fila[10]=rs.getString("vida_util");
            model.addRow(fila);
            }
            jtbl_maquina_ad.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void limpiar_ar(){
        txt_patente_ar.setText("");
        txt_vehiculo_ar.setText("");
        txt_marca_ar.setText("");
        txt_modelo_ar.setText("");
        txt_giro_ar.setText("");
        txt_nombre_ar.setText("");
        txt_direccion_ar.setText("");
        txt_ciudad_ar.setText("");
        txt_telefono_ar.setText("");
        txt_email_ar.setText("");
        txt_chasis_ar.setText("");
        jdt_desde_ar.setCalendar(null);
        jdt_hasta_ar.setCalendar(null);
        txt_precio_ar.setText("");
    }
    
    void limpiar_ad(){
        txt_patente_ad.setText("");
        txt_vehiculo_ad.setText("");
        txt_marca_ad.setText("");
        txt_modelo_ad.setText("");
        txt_chasis_ad.setText("");
        jdt_fecha_ad.setCalendar(null);
        txt_inicial_ad.setText("");
        txt_valor_ad.setText("");
        txt_vidau_ad.setText("");
    }
    
    void habilitar_ar() {
        txt_patente_ar.setEnabled(true);
        txt_vehiculo_ar.setEnabled(true);
        txt_marca_ar.setEnabled(true);
        txt_modelo_ar.setEnabled(true);
        jcbx_ano_ar.setEnabled(true);
        txt_giro_ar.setEnabled(true);
        txt_nombre_ar.setEnabled(true);
        txt_direccion_ar.setEnabled(true);
        txt_ciudad_ar.setEnabled(true);
        txt_telefono_ar.setEnabled(true);
        txt_email_ar.setEnabled(true);
        txt_chasis_ar.setEnabled(true);
        jdt_desde_ar.setEnabled(true);
        jdt_hasta_ar.setEnabled(true);
        txt_precio_ar.setEnabled(true);
        btn_guardar_ar.setEnabled(true);
        btn_modificar_ar.setEnabled(false);
        btn_eliminar_ar.setEnabled(false);
        btn_actualizar_ar.setEnabled(true);
    }
    
    void habilitar_ad() {
        txt_patente_ad.setEnabled(true);
        txt_vehiculo_ad.setEnabled(true);
        txt_marca_ad.setEnabled(true);
        txt_modelo_ad.setEnabled(true);
        jcbx_ano_ad.setEnabled(true);
        txt_chasis_ad.setEnabled(true);
        jdt_fecha_ad.setEnabled(true);
        txt_inicial_ad.setEnabled(true);
        txt_valor_ad.setEnabled(true);
        txt_vidau_ad.setEnabled(true);
        btn_guardar_ad.setEnabled(true);
        btn_modificar_ad.setEnabled(false);
        btn_eliminar_ad.setEnabled(false);
        btn_actualizar_ad.setEnabled(true);
    }
    
    void deshabilitar_ar() {
        txt_folio_ar.setEnabled(false);
        txt_patente_ar.setEnabled(false);
        txt_vehiculo_ar.setEnabled(false);
        txt_marca_ar.setEnabled(false);
        txt_modelo_ar.setEnabled(false);
        jcbx_ano_ar.setEnabled(false);
        txt_giro_ar.setEnabled(false);
        txt_nombre_ar.setEnabled(false);
        txt_direccion_ar.setEnabled(false);
        txt_ciudad_ar.setEnabled(false);
        txt_telefono_ar.setEnabled(false);
        txt_email_ar.setEnabled(false);
        txt_chasis_ar.setEnabled(false);
        jdt_desde_ar.setEnabled(false);
        jdt_hasta_ar.setEnabled(false);
        txt_precio_ar.setEnabled(false);
        btn_guardar_ar.setEnabled(false);
        btn_modificar_ar.setEnabled(false);
        btn_eliminar_ar.setEnabled(false);
        btn_actualizar_ar.setEnabled(false);
    }
    
    void deshabilitar_ad() {
        txt_folio_ad.setEnabled(false);
        txt_patente_ad.setEnabled(false);
        txt_vehiculo_ad.setEnabled(false);
        txt_marca_ad.setEnabled(false);
        txt_modelo_ad.setEnabled(false);
        jcbx_ano_ad.setEnabled(false);
        txt_chasis_ad.setEnabled(false);
        jdt_fecha_ad.setEnabled(false);
        txt_inicial_ad.setEnabled(false);
        txt_valor_ad.setEnabled(false);
        txt_vidau_ad.setEnabled(false);
        btn_guardar_ad.setEnabled(false);
        btn_modificar_ad.setEnabled(false);
        btn_eliminar_ad.setEnabled(false);
        btn_actualizar_ad.setEnabled(false);
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
        txt_vehiculo_ar = new javax.swing.JTextField();
        txt_patente_ar = new javax.swing.JTextField();
        txt_folio_ar = new javax.swing.JTextField();
        txt_marca_ar = new javax.swing.JTextField();
        txt_modelo_ar = new javax.swing.JTextField();
        jcbx_ano_ar = new javax.swing.JComboBox<>();
        txt_giro_ar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_nombre_ar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_direccion_ar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_ciudad_ar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_telefono_ar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_email_ar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_chasis_ar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jdt_desde_ar = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jdt_hasta_ar = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        txt_precio_ar = new javax.swing.JTextField();
        btn_nuevo_ar = new javax.swing.JButton();
        btn_guardar_ar = new javax.swing.JButton();
        btn_modificar_ar = new javax.swing.JButton();
        btn_eliminar_ar = new javax.swing.JButton();
        btn_actualizar_ar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_maquina_ar = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_vehiculo_ad = new javax.swing.JTextField();
        txt_patente_ad = new javax.swing.JTextField();
        txt_folio_ad = new javax.swing.JTextField();
        txt_marca_ad = new javax.swing.JTextField();
        txt_modelo_ad = new javax.swing.JTextField();
        jcbx_ano_ad = new javax.swing.JComboBox<>();
        txt_chasis_ad = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_inicial_ad = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_valor_ad = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_vidau_ad = new javax.swing.JTextField();
        jdt_fecha_ad = new com.toedter.calendar.JDateChooser();
        btn_nuevo_ad = new javax.swing.JButton();
        btn_guardar_ad = new javax.swing.JButton();
        btn_modificar_ad = new javax.swing.JButton();
        btn_eliminar_ad = new javax.swing.JButton();
        btn_actualizar_ad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_maquina_ad = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel30 = new javax.swing.JLabel();
        jlbl_actividad = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingreso de Maquinas");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(java.awt.SystemColor.activeCaption);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/maquinaria1.png"))); // NOI18N
        jLabel1.setText("Ingreso de Maquinas");

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

        jLabel2.setText("N° Folio:");

        jLabel3.setText("Patente:");

        jLabel4.setText("T° Vehiculo:");

        jLabel5.setText("Marca:");

        jLabel6.setText("Modelo:");

        jLabel7.setText("Año:");

        jLabel8.setText("Giro:");

        jcbx_ano_ar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));
        jcbx_ano_ar.setSelectedIndex(36);
        jcbx_ano_ar.setToolTipText("");

        jLabel9.setText("Nombre:");

        jLabel10.setText("Direccion:");

        jLabel11.setText("Ciudad:");

        jLabel12.setText("Telefono:");

        jLabel13.setText("E-mail:");

        jLabel14.setText("N° Chasis:");

        jLabel15.setText("Desde:");

        jdt_desde_ar.setDateFormatString("yyyy-MM-dd");

        jLabel16.setText("Hasta:");

        jdt_hasta_ar.setDateFormatString("yyyy-MM-dd");

        jLabel17.setText("Precio:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jcbx_ano_ar, javax.swing.GroupLayout.Alignment.LEADING, 0, 98, Short.MAX_VALUE)
                    .addComponent(txt_modelo_ar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_marca_ar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_vehiculo_ar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_patente_ar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_folio_ar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_giro_ar))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_direccion_ar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ciudad_ar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_telefono_ar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_email_ar)
                            .addComponent(txt_nombre_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_chasis_ar)
                            .addComponent(jdt_desde_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jdt_hasta_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txt_precio_ar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdt_hasta_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_nombre_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_direccion_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txt_precio_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_ciudad_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_telefono_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_email_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_chasis_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jdt_desde_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_folio_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_patente_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_vehiculo_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_marca_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_modelo_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcbx_ano_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_giro_ar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_nuevo_ar.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_ar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_arActionPerformed(evt);
            }
        });

        btn_guardar_ar.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_ar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_arActionPerformed(evt);
            }
        });

        btn_modificar_ar.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_ar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_arActionPerformed(evt);
            }
        });

        btn_eliminar_ar.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_ar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_arActionPerformed(evt);
            }
        });

        btn_actualizar_ar.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_ar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_ar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_arActionPerformed(evt);
            }
        });

        jtbl_maquina_ar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Folio", "Patente", "T° Vehiculo", "Marca", "Modelo", "Año", "Giro", "N° Chasis", "Desde", "Hasta", "Precio", "Nombre", "Dirección", "Ciudad", "Telefono", "E-mail"
            }
        ));
        jtbl_maquina_ar.setToolTipText("Tabla Arriendo Maquinas [Almacenado]");
        jtbl_maquina_ar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_maquina_arMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_maquina_ar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btn_nuevo_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_guardar_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_modificar_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminar_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_eliminar_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualizar_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_guardar_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_nuevo_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Arriendo de Maquinas", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel18.setText("N° Folio:");

        jLabel19.setText("Patente:");

        jLabel20.setText("T° Vehiculo:");

        jLabel21.setText("Marca:");

        jLabel22.setText("Modelo:");

        jLabel23.setText("Año:");

        jLabel24.setText("N° Chasis:");

        jcbx_ano_ad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));
        jcbx_ano_ad.setSelectedIndex(36);
        jcbx_ano_ad.setToolTipText("");

        jLabel25.setText("Fecha:");

        jLabel26.setText("Km. Inicial:");

        jLabel27.setText("Valor:");

        jLabel28.setText("Vida Util:");

        jdt_fecha_ad.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jcbx_ano_ad, javax.swing.GroupLayout.Alignment.LEADING, 0, 98, Short.MAX_VALUE)
                    .addComponent(txt_modelo_ad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_marca_ad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_vehiculo_ad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_patente_ad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_folio_ad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_chasis_ad))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_inicial_ad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_valor_ad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_vidau_ad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdt_fecha_ad, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jdt_fecha_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txt_inicial_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txt_valor_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txt_vidau_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_folio_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txt_patente_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txt_vehiculo_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txt_marca_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txt_modelo_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jcbx_ano_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txt_chasis_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_nuevo_ad.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_ad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_adActionPerformed(evt);
            }
        });

        btn_guardar_ad.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_ad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_adActionPerformed(evt);
            }
        });

        btn_modificar_ad.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_ad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_adActionPerformed(evt);
            }
        });

        btn_eliminar_ad.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_ad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_adActionPerformed(evt);
            }
        });

        btn_actualizar_ad.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_ad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_adActionPerformed(evt);
            }
        });

        jtbl_maquina_ad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Folio", "Patente", "T° Vehiculo", "Marca", "Modelo", "Año", "N° Chasis", "Fecha", "Km Inicial", "Precio", "Vida Util"
            }
        ));
        jtbl_maquina_ad.setToolTipText("Tabla Aquisiciones Maquinas [Almacenado]");
        jtbl_maquina_ad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_maquina_adMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_maquina_ad);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btn_nuevo_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_nuevo_ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar_ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificar_ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar_ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar_ad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adquisicion de Maquinas", jPanel4);

        jToolBar1.setBackground(java.awt.SystemColor.activeCaption);
        jToolBar1.setRollover(true);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Actividad: ");
        jToolBar1.add(jLabel30);

        jlbl_actividad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_actividad.setForeground(new java.awt.Color(255, 0, 0));
        jToolBar1.add(jlbl_actividad);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevo_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_adActionPerformed
        // TODO add your handling code here:
        limpiar_ad();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(date);
        txt_folio_ad.setText("MAQ"+dateString);
        habilitar_ad();
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_adActionPerformed

    private void btn_guardar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_adActionPerformed
        // TODO add your handling code here:
        if (txt_folio_ad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el N° Folio");
        }
        else if (txt_patente_ad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el N° de Patente");
        }
        else if (txt_vehiculo_ad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el tipo de Vehiculo");
        }
        else if (txt_marca_ad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa la Marca del Vehiculo");
        }
        else if (txt_modelo_ad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Modelo de la Marca del Vehiculo");
        }
        else if (txt_chasis_ad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el N° Chasis de la Maquina que Arrienda");
        }
        else if (jdt_fecha_ad.getDate() == null) {
            jlbl_actividad.setText("Ingresa la Fecha de Adquisicion de la maquina");
        }
        else if (txt_inicial_ad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Km Inicial de la maquina comprada");
        }
        else if (txt_valor_ad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el valor de la maquina comprada");
        }
        else if (txt_vidau_ad.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa la Vida Util (se expresada en años)");
        }
        else {
            if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                try {
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO maquinas (num_folio, patente, giro, nombre, direccion, ciudad, telefono, email, desde, hasta, precio_arriendo, tipo_vehiculo, marca, modelo, año, num_chasis, fecha_ad, km_inicial, valor, vida_util, tipo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    pps.setString(1, txt_folio_ad.getText());
                    pps.setString(2, txt_patente_ad.getText());
                    pps.setString(3, "no_atribuye");
                    pps.setString(4, "no_atribuye");
                    pps.setString(5, "no_atribuye");
                    pps.setString(6, "no_atribuye");
                    pps.setString(7, "0000000");
                    pps.setString(8, "no_atribuye");
                    pps.setString(9, "0001-01-01");
                    pps.setString(10, "0001-01-01");
                    pps.setString(11, "0");
                    pps.setString(12, txt_vehiculo_ad.getText());
                    pps.setString(13, txt_marca_ad.getText());
                    pps.setString(14, txt_modelo_ad.getText());
                    String value1 = jcbx_ano_ad.getSelectedItem().toString();
                    pps.setString(15, value1);
                    pps.setString(16, txt_chasis_ad.getText());
                    pps.setString(17, ((JTextField)jdt_fecha_ad.getDateEditor().getUiComponent()).getText());
                    pps.setString(18, txt_inicial_ad.getText());
                    pps.setString(19, txt_valor_ad.getText());
                    pps.setString(20, txt_vidau_ad.getText());
                    pps.setString(21, "Adquisicion");
                    pps.executeUpdate();
                    jlbl_actividad.setText("Datos Guardados");
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_adActionPerformed

    private void btn_modificar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_adActionPerformed
        // TODO add your handling code here:
            try {
            String sql = "UPDATE maquinas SET num_folio=?, patente=?, giro=?, nombre=?, direccion=?, ciudad=?, telefono=?, email=?, desde=?, hasta=?, precio_arriendo=?, tipo_vehiculo=?, marca=?, modelo=?, año=?, num_chasis=?, fecha_ad=?, km_inicial=?, valor=?, vida_util=?, tipo=?"+"Where num_folio=?";
            int fila = jtbl_maquina_ad.getSelectedRow();
            String dao = (String)jtbl_maquina_ad.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
                    ps.setString(1, txt_folio_ad.getText());
                    ps.setString(2, txt_patente_ad.getText());
                    ps.setString(3, "no_atribuye");
                    ps.setString(4, "no_atribuye");
                    ps.setString(5, "no_atribuye");
                    ps.setString(6, "no_atribuye");
                    ps.setString(7, "0000000");
                    ps.setString(8, "no_atribuye");
                    ps.setString(9, "0001-01-01");
                    ps.setString(10, "0001-01-01");
                    ps.setString(11, "0");
                    ps.setString(12, txt_vehiculo_ad.getText());
                    ps.setString(13, txt_marca_ad.getText());
                    ps.setString(14, txt_modelo_ad.getText());
                    String value1 = jcbx_ano_ad.getSelectedItem().toString();
                    ps.setString(15, value1);
                    ps.setString(16, txt_chasis_ad.getText());
                    ps.setString(17, ((JTextField)jdt_fecha_ad.getDateEditor().getUiComponent()).getText());
                    ps.setString(18, txt_inicial_ad.getText());
                    ps.setString(19, txt_valor_ad.getText());
                    ps.setString(20, txt_vidau_ad.getText());
                    ps.setString(21, "Adquisicion");
                    ps.setString(22, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }//GEN-LAST:event_btn_modificar_adActionPerformed

    private void btn_eliminar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_adActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_maquina_ad.getSelectedRow();
            String sql = "DELETE FROM maquinas WHERE num_folio='"+jtbl_maquina_ad.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_adActionPerformed

    private void btn_actualizar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_adActionPerformed
        // TODO add your handling code here:
        llenar_adquisicion();
        jlbl_actividad.setText("Datos de la tabla 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_adActionPerformed

    private void btn_nuevo_arActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_arActionPerformed
        // TODO add your handling code here:
        limpiar_ar();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(date);
        txt_folio_ar.setText("MAQ"+dateString);
        habilitar_ar();
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_arActionPerformed

    private void btn_guardar_arActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_arActionPerformed
        // TODO add your handling code here:
        if (txt_folio_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el N° Folio");
        }
        else if (txt_patente_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el N° de Patente");
        }
        else if (txt_vehiculo_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el tipo de Vehiculo");
        }
        else if (txt_marca_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa la Marca del Vehiculo");
        }
        else if (txt_modelo_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Modelo de la Marca del Vehiculo");
        }
        else if (txt_giro_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Giro de quien Arrienda la Maquina");
        }
        else if (txt_nombre_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Nombre Fantasia de quien Arrienda la Maquina");
        }
        else if (txt_direccion_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa la Direccion de quien Arrienda la Maquina");
        }
        else if (txt_ciudad_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa la Ciudad de quien Arrienda la Maquina");
        }
        else if (txt_telefono_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Telefono de quien Arrienda la Maquina");
        }
        else if (txt_email_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el E-mail de quien Arrienda la Maquina");
        }
        else if (txt_chasis_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el N° Chasis de la Maquina que Arrienda");
        }
        else if (jdt_desde_ar.getDate() == null) {
            jlbl_actividad.setText("Ingresa la Fecha de Inicio Arriendo");
        }
        else if (jdt_hasta_ar.getDate() == null) {
            jlbl_actividad.setText("Ingresa la Fecha de Termino Arriendo");
        }
        else if (txt_precio_ar.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Precio de Arriendo");
        }
        else {
            if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                try {
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO maquinas (num_folio, patente, giro, nombre, direccion, ciudad, telefono, email, desde, hasta, precio_arriendo, tipo_vehiculo, marca, modelo, año, num_chasis, fecha_ad, km_inicial, valor, vida_util, tipo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    pps.setString(1, txt_folio_ar.getText());
                    pps.setString(2, txt_patente_ar.getText());
                    pps.setString(3, txt_giro_ar.getText());
                    pps.setString(4, txt_nombre_ar.getText());
                    pps.setString(5, txt_direccion_ar.getText());
                    pps.setString(6, txt_ciudad_ar.getText());
                    pps.setString(7, txt_telefono_ar.getText());
                    pps.setString(8, txt_email_ar.getText());
                    pps.setString(9, ((JTextField)jdt_desde_ar.getDateEditor().getUiComponent()).getText());
                    pps.setString(10, ((JTextField)jdt_hasta_ar.getDateEditor().getUiComponent()).getText());
                    pps.setString(11, txt_precio_ar.getText());
                    pps.setString(12, txt_vehiculo_ar.getText());
                    pps.setString(13, txt_marca_ar.getText());
                    pps.setString(14, txt_modelo_ar.getText());
                    String value1 = jcbx_ano_ar.getSelectedItem().toString();
                    pps.setString(15, value1);
                    pps.setString(16, txt_chasis_ar.getText());
                    pps.setString(17, "0001-01-01");
                    pps.setString(18, "000000");
                    pps.setString(19, "000000");
                    pps.setString(20, "0");
                    pps.setString(21, "Arriendo");
                    pps.executeUpdate();
                    jlbl_actividad.setText("Datos Guardados");
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_arActionPerformed

    private void btn_modificar_arActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_arActionPerformed
        // TODO add your handling code here:
            try {
            String sql = "UPDATE maquinas SET num_folio=?, patente=?, giro=?, nombre=?, direccion=?, ciudad=?, telefono=?, email=?, desde=?, hasta=?, precio_arriendo=?, tipo_vehiculo=?, marca=?, modelo=?, año=?, num_chasis=?, fecha_ad=?, km_inicial=?, valor=?, vida_util=?, tipo=?"+"Where num_folio=?";
            int fila = jtbl_maquina_ar.getSelectedRow();
            String dao = (String)jtbl_maquina_ar.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
                    ps.setString(1, txt_folio_ar.getText());
                    ps.setString(2, txt_patente_ar.getText());
                    ps.setString(3, txt_giro_ar.getText());
                    ps.setString(4, txt_nombre_ar.getText());
                    ps.setString(5, txt_direccion_ar.getText());
                    ps.setString(6, txt_ciudad_ar.getText());
                    ps.setString(7, txt_telefono_ar.getText());
                    ps.setString(8, txt_email_ar.getText());
                    ps.setString(9, ((JTextField)jdt_desde_ar.getDateEditor().getUiComponent()).getText());
                    ps.setString(10, ((JTextField)jdt_hasta_ar.getDateEditor().getUiComponent()).getText());
                    ps.setString(11, txt_precio_ar.getText());
                    ps.setString(12, txt_vehiculo_ar.getText());
                    ps.setString(13, txt_marca_ar.getText());
                    ps.setString(14, txt_modelo_ar.getText());
                    String value1 = jcbx_ano_ar.getSelectedItem().toString();
                    ps.setString(15, value1);
                    ps.setString(16, txt_chasis_ar.getText());
                    ps.setString(17, "0001-01-01");
                    ps.setString(18, "000000");
                    ps.setString(19, "000000");
                    ps.setString(20, "0");
                    ps.setString(21, "Arriendo");
                    ps.setString(22, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }//GEN-LAST:event_btn_modificar_arActionPerformed

    private void btn_eliminar_arActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_arActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_maquina_ar.getSelectedRow();
            String sql = "DELETE FROM maquinas WHERE num_folio='"+jtbl_maquina_ar.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_arActionPerformed

    private void btn_actualizar_arActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_arActionPerformed
        // TODO add your handling code here:
        llenar_arriendo();
        jlbl_actividad.setText("Datos de la tabla 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_arActionPerformed

    private void jtbl_maquina_arMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_maquina_arMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_maquina_ar.getSelectedRow();
            try{
                btn_modificar_ar.setEnabled(true);
                btn_eliminar_ar.setEnabled(true);
                btn_guardar_ar.setEnabled(false);
         
                txt_folio_ar.setText(jtbl_maquina_ar.getValueAt(fila, 0).toString());
                txt_patente_ar.setText(jtbl_maquina_ar.getValueAt(fila, 1).toString());
                txt_vehiculo_ar.setText(jtbl_maquina_ar.getValueAt(fila, 2).toString());
                txt_marca_ar.setText(jtbl_maquina_ar.getValueAt(fila, 3).toString());
                txt_modelo_ar.setText(jtbl_maquina_ar.getValueAt(fila, 4).toString());
                jcbx_ano_ar.setSelectedItem(jtbl_maquina_ar.getValueAt(fila, 5).toString());
                txt_giro_ar.setText(jtbl_maquina_ar.getValueAt(fila, 6).toString());
                txt_chasis_ar.setText(jtbl_maquina_ar.getValueAt(fila, 7).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_maquina_ar.getValueAt(fila,8).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_desde_ar.setDate(fecha);
                
                String strfecha2 = (String) jtbl_maquina_ar.getValueAt(fila,9).toString().trim();
                Date fecha2 = formatoDelTexto.parse(strfecha2);
                jdt_hasta_ar.setDate(fecha2);
                
                txt_precio_ar.setText(jtbl_maquina_ar.getValueAt(fila, 10).toString());
                txt_nombre_ar.setText(jtbl_maquina_ar.getValueAt(fila, 11).toString());
                txt_direccion_ar.setText(jtbl_maquina_ar.getValueAt(fila, 12).toString());
                txt_ciudad_ar.setText(jtbl_maquina_ar.getValueAt(fila, 13).toString());
                txt_telefono_ar.setText(jtbl_maquina_ar.getValueAt(fila, 14).toString());
                txt_email_ar.setText(jtbl_maquina_ar.getValueAt(fila, 15).toString());
                
                jlbl_actividad.setText("Datos Traslados a Campos, modifique y aprete boton Modificar");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }        
    }//GEN-LAST:event_jtbl_maquina_arMouseClicked

    private void jtbl_maquina_adMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_maquina_adMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_maquina_ad.getSelectedRow();
            try{
                btn_modificar_ad.setEnabled(true);
                btn_eliminar_ad.setEnabled(true);
                btn_guardar_ad.setEnabled(false);
              
                txt_folio_ad.setText(jtbl_maquina_ad.getValueAt(fila, 0).toString());
                txt_patente_ad.setText(jtbl_maquina_ad.getValueAt(fila, 1).toString());
                txt_vehiculo_ad.setText(jtbl_maquina_ad.getValueAt(fila, 2).toString());
                txt_marca_ad.setText(jtbl_maquina_ad.getValueAt(fila, 3).toString());
                txt_modelo_ad.setText(jtbl_maquina_ad.getValueAt(fila, 4).toString());
                jcbx_ano_ad.setSelectedItem(jtbl_maquina_ad.getValueAt(fila, 5).toString());
                txt_chasis_ad.setText(jtbl_maquina_ad.getValueAt(fila, 6).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_maquina_ad.getValueAt(fila,7).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_fecha_ad.setDate(fecha);
                
                txt_inicial_ad.setText(jtbl_maquina_ad.getValueAt(fila, 8).toString());
                txt_valor_ad.setText(jtbl_maquina_ad.getValueAt(fila, 9).toString());
                txt_vidau_ad.setText(jtbl_maquina_ad.getValueAt(fila, 10).toString());
                
                jlbl_actividad.setText("Datos Traslados a Campos, modifique y aprete boton Modificar");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }        
    }//GEN-LAST:event_jtbl_maquina_adMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar_ad;
    private javax.swing.JButton btn_actualizar_ar;
    private javax.swing.JButton btn_eliminar_ad;
    private javax.swing.JButton btn_eliminar_ar;
    private javax.swing.JButton btn_guardar_ad;
    private javax.swing.JButton btn_guardar_ar;
    private javax.swing.JButton btn_modificar_ad;
    private javax.swing.JButton btn_modificar_ar;
    private javax.swing.JButton btn_nuevo_ad;
    private javax.swing.JButton btn_nuevo_ar;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> jcbx_ano_ad;
    private javax.swing.JComboBox<String> jcbx_ano_ar;
    private com.toedter.calendar.JDateChooser jdt_desde_ar;
    private com.toedter.calendar.JDateChooser jdt_fecha_ad;
    private com.toedter.calendar.JDateChooser jdt_hasta_ar;
    private javax.swing.JLabel jlbl_actividad;
    private javax.swing.JTable jtbl_maquina_ad;
    private javax.swing.JTable jtbl_maquina_ar;
    private javax.swing.JTextField txt_chasis_ad;
    private javax.swing.JTextField txt_chasis_ar;
    private javax.swing.JTextField txt_ciudad_ar;
    private javax.swing.JTextField txt_direccion_ar;
    private javax.swing.JTextField txt_email_ar;
    private javax.swing.JTextField txt_folio_ad;
    private javax.swing.JTextField txt_folio_ar;
    private javax.swing.JTextField txt_giro_ar;
    private javax.swing.JTextField txt_inicial_ad;
    private javax.swing.JTextField txt_marca_ad;
    private javax.swing.JTextField txt_marca_ar;
    private javax.swing.JTextField txt_modelo_ad;
    private javax.swing.JTextField txt_modelo_ar;
    private javax.swing.JTextField txt_nombre_ar;
    private javax.swing.JTextField txt_patente_ad;
    private javax.swing.JTextField txt_patente_ar;
    private javax.swing.JTextField txt_precio_ar;
    private javax.swing.JTextField txt_telefono_ar;
    private javax.swing.JTextField txt_valor_ad;
    private javax.swing.JTextField txt_vehiculo_ad;
    private javax.swing.JTextField txt_vehiculo_ar;
    private javax.swing.JTextField txt_vidau_ad;
    // End of variables declaration//GEN-END:variables
}
