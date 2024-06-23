/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bodega;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jose
 */
public class Bodega_C extends javax.swing.JInternalFrame {
    private TableRowSorter trsFiltro;
    DefaultTableModel model;
    Conexion.conexion conexion = new Conexion.conexion();
    Connection cn = conexion.connect();
    Statement sent;
    /**
     * Creates new form Bodega_C
     */
    public Bodega_C() {
        initComponents();
        llenar_tablaoc();
        llenar_tablaad();
        llenar_tablamer();  
        llenar_tablaperd();
    }
    
    void llenar_tablaoc() {
        try {
            cn = conexion.connect();
            String [] titulos = {"C° OC","Descripcion","Comentario","URL","Fecha","Gasto","Proveedor", "T° Docto", "Precio"};
            String sql = "SELECT * FROM orden_compra";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [9];
            while (rs.next()){
                fila[0]=rs.getString("codigo_oc");
                fila[1]=rs.getString("descripcion");
                fila[2]=rs.getString("comentario");
                fila[3]=rs.getString("URL");
                fila[4]=rs.getString("fecha_req");
                fila[5]=rs.getString("gasto");
                fila[6]=rs.getString("proveedor");
                fila[7]=rs.getString("docto_rec");
                fila[8]=rs.getString("precio");
            model.addRow(fila);
            }
            jtbl_ordencom.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_tablaad() {
        try {
            cn = conexion.connect();
            String [] titulos = {"C° AD","C° OC","Descripcion","Seccion","Categoria","Tipo Docto","Num. Docto", "Estado", "Fecha","Vida Util","Forma Pago","N° Cheque","N° Cuenta","N° Trans","Valor Total"};
            String sql = "SELECT * FROM adquisiciones";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [15];
            while (rs.next()){
                fila[0]=rs.getString("codigo_ad");
                fila[1]=rs.getString("codigo_oc");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("seccion");
                fila[4]=rs.getString("categoria");
                fila[5]=rs.getString("tipo_doc");
                fila[6]=rs.getString("num_doc");
                fila[7]=rs.getString("estado");
                fila[8]=rs.getString("fecha");
                fila[9]=rs.getString("vida_util");
                fila[10]=rs.getString("forma_pago");
                fila[11]=rs.getString("num_cheque");
                fila[12]=rs.getString("num_cuenta");
                fila[13]=rs.getString("num_trans");
                fila[14]=rs.getString("valor_total");
            model.addRow(fila);
            }
            jtbl_adquisiciones.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_tablamer() {
        try {
            cn = conexion.connect();
            String [] titulos = {"C° Prod","C° OC","Fecha","Tipo Docto","Num. Docto","Lote","Descripcion", "Cantidad", "Valor_total","Forma de Pago","N° Cheque","N° Cuenta","N° Trans"};
            String sql = "SELECT * FROM libro_compras";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [13];
            while (rs.next()){
                fila[0]=rs.getString("codigo_prod");
                fila[1]=rs.getString("codigo_oc");
                fila[2]=rs.getString("fecha");
                fila[3]=rs.getString("tipo_doc");
                fila[4]=rs.getString("num_doc");
                fila[5]=rs.getString("lote");
                fila[6]=rs.getString("descripcion");
                fila[7]=rs.getString("cantidad");
                fila[8]=rs.getString("valor_total");
                fila[9]=rs.getString("forma_pago");
                fila[10]=rs.getString("num_cheque");
                fila[11]=rs.getString("num_cuenta");
                fila[12]=rs.getString("num_trans");
            model.addRow(fila);
            }
            jtbl_mercancia.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_tablaperd() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Codigo","Num. Docto","Cod. Producto","Producto","Fecha","Cantidad","Motivo", "Monto"};
            String sql = "SELECT * FROM perdidas";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [8];
            while (rs.next()){
                fila[0]=rs.getString("codigo");
                fila[1]=rs.getString("num_doc");
                fila[2]=rs.getString("codigo_prod");
                fila[3]=rs.getString("producto");
                fila[4]=rs.getString("fecha");
                fila[5]=rs.getString("cantidad");
                fila[6]=rs.getString("motivo");
                fila[7]=rs.getString("monto");
            model.addRow(fila);
            }
            jtbl_perdidas.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void filtro_oc() {
        
        int columnaABuscar = 0;
        if (jcbx_ordencom.getSelectedItem() == "C° OC") {
            columnaABuscar = 0;
        }
        if (jcbx_ordencom.getSelectedItem() == "Descripcion") {
            columnaABuscar = 1;
        }
        if (jcbx_ordencom.getSelectedItem() == "Comentario") {
            columnaABuscar = 2;
        }
        if (jcbx_ordencom.getSelectedItem() == "Gasto") {
            columnaABuscar = 5;
        }
        if (jcbx_ordencom.getSelectedItem() == "Proveedor") {
            columnaABuscar = 6;
        }
        if (jcbx_ordencom.getSelectedItem() == "T° Docto") {
            columnaABuscar = 7;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_ordencom.getText(), columnaABuscar));
    }
    
    public void filtro_ad() {
        
        int columnaABuscar = 0;
        if (jcbx_adquisiciones.getSelectedItem() == "Codigo AD") {
            columnaABuscar = 0;
        }
        if (jcbx_adquisiciones.getSelectedItem() == "Codigo OC") {
            columnaABuscar = 1;
        }
        if (jcbx_adquisiciones.getSelectedItem().toString() == "Descripcion") {
            columnaABuscar = 2;
        }
        if (jcbx_adquisiciones.getSelectedItem().toString() == "Forma Pago") {
            columnaABuscar = 10;
        }
        if (jcbx_adquisiciones.getSelectedItem().toString() == "Seccion") {
            columnaABuscar = 3;
        }
        if (jcbx_adquisiciones.getSelectedItem().toString() == "Cateogoria") {
            columnaABuscar = 4;
        }
        if (jcbx_adquisiciones.getSelectedItem().toString() == "T° Docto") {
            columnaABuscar = 5;
        }
        if (jcbx_adquisiciones.getSelectedItem().toString() == "N° Docto") {
            columnaABuscar = 6;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_adquisiciones.getText(), columnaABuscar));
    }
    
    public void filtro_mer() {
        
        int columnaABuscar = 1;
        if (jcbx_mercancia.getSelectedItem() == "Codigo Prod") {
            columnaABuscar = 1;
        }
        if (jcbx_mercancia.getSelectedItem() == "Codigo OC") {
            columnaABuscar = 0;
        }
        if (jcbx_mercancia.getSelectedItem().toString() == "T° Docto") {
            columnaABuscar = 3;
        }
        if (jcbx_mercancia.getSelectedItem().toString() == "N° Docto") {
            columnaABuscar = 4;
        }
        if (jcbx_mercancia.getSelectedItem().toString() == "Lote") {
            columnaABuscar = 5;
        }
        if (jcbx_mercancia.getSelectedItem().toString() == "Descripcion") {
            columnaABuscar = 6;
        }
        if (jcbx_mercancia.getSelectedItem().toString() == "Forma Pago") {
            columnaABuscar = 9;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_mercancia.getText(), columnaABuscar));
    }

    public void filtro_perd() {
        
        int columnaABuscar = 0;
        if (jcbx_perdidas.getSelectedItem() == "Codigo Perd") {
            columnaABuscar = 0;
        }
        if (jcbx_perdidas.getSelectedItem() == "N° Docto") {
            columnaABuscar = 1;
        }
        if (jcbx_perdidas.getSelectedItem().toString() == "C° Prod") {
            columnaABuscar = 2;
        }
        if (jcbx_perdidas.getSelectedItem().toString() == "Producto") {
            columnaABuscar = 3;
        }
        if (jcbx_perdidas.getSelectedItem().toString() == "Motivo") {
            columnaABuscar = 6;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_perdidas.getText(), columnaABuscar));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_ordencom = new javax.swing.JTextField();
        jcbx_ordencom = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_ordencom = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_adquisiciones = new javax.swing.JTextField();
        jcbx_adquisiciones = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_adquisiciones = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_mercancia = new javax.swing.JTextField();
        jcbx_mercancia = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbl_mercancia = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_perdidas = new javax.swing.JTextField();
        jcbx_perdidas = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbl_perdidas = new javax.swing.JTable();

        setBackground(java.awt.SystemColor.activeCaption);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de Bodega");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        jLabel1.setBackground(java.awt.SystemColor.activeCaption);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/bodegas.png"))); // NOI18N
        jLabel1.setText("Consulta de Bodega");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        jPanel7.setBackground(java.awt.SystemColor.activeCaption);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("BUSQUEDA:");

        txt_ordencom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_ordencom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ordencomKeyTyped(evt);
            }
        });

        jcbx_ordencom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_ordencom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo OC", "Descripcion", "Comentario", "Gasto", "Proveedor", "T° Docto" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jcbx_ordencom, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_ordencom, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ordencom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_ordencom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_ordencom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_ordencom.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtbl_ordencom);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 350, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta Orden de Compras", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        jPanel8.setBackground(java.awt.SystemColor.activeCaption);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("BUSQUEDA:");

        txt_adquisiciones.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_adquisiciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_adquisicionesKeyTyped(evt);
            }
        });

        jcbx_adquisiciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_adquisiciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo AD", "Codigo OC", "Descripcion", "Forma Pago", "Seccion", "Categoria", "T° Docto", "N° Docto" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jcbx_adquisiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_adquisiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_adquisiciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_adquisiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_adquisiciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_adquisiciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jtbl_adquisiciones);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 345, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta Adquisiciones", jPanel4);

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);

        jPanel9.setBackground(java.awt.SystemColor.activeCaption);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("BUSQUEDA:");

        txt_mercancia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_mercancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mercanciaKeyTyped(evt);
            }
        });

        jcbx_mercancia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_mercancia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo Prod", "Codigo OC", "T° Docto", "N° Docto", "Lote", "Descripcion", "Forma Pago" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jcbx_mercancia, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_mercancia, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_mercancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_mercancia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_mercancia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_mercancia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jtbl_mercancia);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 350, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta Mercaderia", jPanel5);

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);

        jPanel10.setBackground(java.awt.SystemColor.activeCaption);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("BUSQUEDA:");

        txt_perdidas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_perdidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_perdidasKeyTyped(evt);
            }
        });

        jcbx_perdidas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_perdidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo Perd", "N° Docto", "C° Prod", "Producto", "Motivo" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jcbx_perdidas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_perdidas, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_perdidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_perdidas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_perdidas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_perdidas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jtbl_perdidas);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 350, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta Perdidas", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ordencomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ordencomKeyTyped
        // TODO add your handling code here:
        txt_ordencom.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_ordencom.getText());
                txt_ordencom.setText(cadena);
                repaint();
                filtro_oc();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_ordencom.getModel());
        jtbl_ordencom.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_ordencomKeyTyped

    private void txt_adquisicionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_adquisicionesKeyTyped
        // TODO add your handling code here:
        txt_adquisiciones.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_adquisiciones.getText());
                txt_adquisiciones.setText(cadena);
                repaint();
                filtro_ad();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_adquisiciones.getModel());
        jtbl_adquisiciones.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_adquisicionesKeyTyped

    private void txt_mercanciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mercanciaKeyTyped
        // TODO add your handling code here:
        txt_mercancia.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_mercancia.getText());
                txt_mercancia.setText(cadena);
                repaint();
                filtro_mer();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_mercancia.getModel());
        jtbl_mercancia.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_mercanciaKeyTyped

    private void txt_perdidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_perdidasKeyTyped
        // TODO add your handling code here:
        txt_perdidas.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_perdidas.getText());
                txt_perdidas.setText(cadena);
                repaint();
                filtro_perd();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_perdidas.getModel());
        jtbl_perdidas.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_perdidasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbx_adquisiciones;
    private javax.swing.JComboBox<String> jcbx_mercancia;
    private javax.swing.JComboBox<String> jcbx_ordencom;
    private javax.swing.JComboBox<String> jcbx_perdidas;
    private javax.swing.JTable jtbl_adquisiciones;
    private javax.swing.JTable jtbl_mercancia;
    private javax.swing.JTable jtbl_ordencom;
    private javax.swing.JTable jtbl_perdidas;
    private javax.swing.JTextField txt_adquisiciones;
    private javax.swing.JTextField txt_mercancia;
    private javax.swing.JTextField txt_ordencom;
    private javax.swing.JTextField txt_perdidas;
    // End of variables declaration//GEN-END:variables
}
