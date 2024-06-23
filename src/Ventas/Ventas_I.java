/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

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
public class Ventas_I extends javax.swing.JInternalFrame {
    DefaultTableModel model;    
    Conexion.conexion conexion = new Conexion.conexion();
    Connection cn = conexion.connect();
    Statement sent;
    /**
     * Creates new form Ventas_I
     */
    public Ventas_I() {
        initComponents();
        limpiar_ov();
        limpiar_bol();
        limpiar_fact();
        deshabilitar_ov();
        deshabilitar_bol();
        deshabilitar_fact();
    }
    
    void limpiar_ov() {
        txt_ov.setText("");
        txt_codprodov.setText("");
        txt_descripcionov.setText("");
        jdt_fechaov.setDate(null);
        txt_precioov.setText("");
        jlbl_ivaov.setText("");
        jlbl_totalov.setText("");
    }
    
    void limpiar_bol() {
        txt_ingresobol.setText("");
        txt_codprodbol.setText("");
        txt_numdocbol.setText("");
        txt_descripcionbol.setText("");
        jdt_fechabol.setDate(null);
        txt_cantidadbol.setText("");
        txt_netobol.setText("");
        txt_doctobol.setText("");
        txt_cuentabol.setText("");
        txt_transbol.setText("");
    }
    
    void limpiar_fact() {
        txt_ingresof.setText("");
        txt_codprodf.setText("");
        txt_ndoctofact.setText("");
        txt_clientefact.setText("");
        txt_direccionfact.setText("");
        txt_rutfact.setText("");
        jdt_fechafact.setDate(null);
        txt_ciudadfact.setText("");
        txt_provinciafact.setText("");
        txt_girofact.setText("");
        txt_fonofact.setText("");
        txt_descripcionfact.setText("");
        txt_cantidadfact.setText("");
        txt_netofact.setText("");
        txt_doctofact.setText("");
        txt_cuentafact.setText("");
        txt_transfact.setText("");
    }
    
    void habilitar_ov() {
        txt_codprodov.setEnabled(true);
        txt_descripcionov.setEnabled(true);
        jdt_fechaov.setEnabled(true);
        txt_precioov.setEnabled(true);
        btn_guardar_ov.setEnabled(true);
        btn_modificar_ov.setEnabled(false);
        btn_eliminar_ov.setEnabled(false);
        btn_actualizar_ov.setEnabled(true);
    }
    
    void habilitar_bol() {
        txt_codprodbol.setEnabled(true);
        jcbx_tipodocbol.setEnabled(true);
        txt_numdocbol.setEnabled(true);
        txt_descripcionbol.setEnabled(true);
        jdt_fechabol.setEnabled(true);
        txt_cantidadbol.setEnabled(true);
        txt_netobol.setEnabled(true);
        jcbx_formapbol.setEnabled(true);
        btn_guardar_bol.setEnabled(true);
        btn_mod_bol.setEnabled(false);
        btn_eliminar_bol.setEnabled(false);
        btn_actualizar_bol.setEnabled(true);
    }
    
    void habilitar_fact() {
        txt_codprodf.setEnabled(true);
        jcbx_tipodocfact.setEnabled(true);
        txt_ndoctofact.setEnabled(true);
        txt_clientefact.setEnabled(true);
        txt_direccionfact.setEnabled(true);
        txt_rutfact.setEnabled(true);
        jdt_fechafact.setEnabled(true);
        txt_ciudadfact.setEnabled(true);
        txt_provinciafact.setEnabled(true);
        txt_girofact.setEnabled(true);
        txt_fonofact.setEnabled(true);
        jcbx_despachofact.setEnabled(true);
        txt_descripcionfact.setEnabled(true);
        txt_cantidadfact.setEnabled(true);
        txt_netofact.setEnabled(true);
        jcbx_formapfact.setEnabled(true);
        btn_guardar_fact.setEnabled(true);
        btn_modificar_fact.setEnabled(false);
        btn_eliminar_fact.setEnabled(false);
        btn_actualizar_fact.setEnabled(true);
    }
    
    void deshabilitar_fact() {
        txt_ingresof.setEnabled(false);
        txt_codprodf.setEnabled(false);
        jcbx_tipodocfact.setEnabled(false);
        txt_ndoctofact.setEnabled(false);
        txt_clientefact.setEnabled(false);
        txt_direccionfact.setEnabled(false);
        txt_rutfact.setEnabled(false);
        jdt_fechafact.setEnabled(false);
        txt_ciudadfact.setEnabled(false);
        txt_provinciafact.setEnabled(false);
        txt_girofact.setEnabled(false);
        txt_fonofact.setEnabled(false);
        jcbx_despachofact.setEnabled(false);
        txt_descripcionfact.setEnabled(false);
        txt_cantidadfact.setEnabled(false);
        txt_netofact.setEnabled(false);
        jcbx_formapfact.setEnabled(false);
        txt_doctofact.setEnabled(false);
        txt_cuentafact.setEnabled(false);
        txt_transfact.setEnabled(false);
        btn_guardar_fact.setEnabled(false);
        btn_modificar_fact.setEnabled(false);
        btn_eliminar_fact.setEnabled(false);
        btn_actualizar_fact.setEnabled(false);
    }
    
    void deshabilitar_ov() {
        txt_ov.setEnabled(false);
        txt_codprodov.setEnabled(false);
        txt_descripcionov.setEnabled(false);
        jdt_fechaov.setEnabled(false);
        txt_precioov.setEnabled(false);
        btn_guardar_ov.setEnabled(false);
        btn_modificar_ov.setEnabled(false);
        btn_eliminar_ov.setEnabled(false);
        btn_actualizar_ov.setEnabled(false);
    }
    
    void deshabilitar_bol() {
        txt_ingresobol.setEnabled(false);
        txt_codprodbol.setEnabled(false);
        jcbx_tipodocbol.setEnabled(false);
        txt_numdocbol.setEnabled(false);
        txt_descripcionbol.setEnabled(false);
        jdt_fechabol.setEnabled(false);
        txt_cantidadbol.setEnabled(false);
        txt_netobol.setEnabled(false);
        jcbx_formapbol.setEnabled(false);
        txt_doctobol.setEnabled(false);
        txt_cuentabol.setEnabled(false);
        txt_transbol.setEnabled(false);
        btn_guardar_bol.setEnabled(false);
        btn_mod_bol.setEnabled(false);
        btn_eliminar_bol.setEnabled(false);
        btn_actualizar_bol.setEnabled(false);
    }
    
    void llenar_prodov() {
        //ORDEN DE VENTA
        try {
            cn = conexion.connect();
            String [] titulos = {"#","Codigo Prod","Descripción","Lote","Cantidad","Fecha","Valor Compra","Valor Venta"};
            String sql = "SELECT id, codigo_prod, descripcion, lote, cantidad, fecha, valor_compra, valor_venta FROM productos";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [8];
            while (rs.next()){
                fila[0]=rs.getString("id");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("lote");
                fila[4]=rs.getString("cantidad");
                fila[5]=rs.getString("fecha");
                fila[6]=rs.getString("valor_compra");
                fila[7]=rs.getString("valor_venta");                
            model.addRow(fila);
            }
            jtbl_productos.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_oc_bol() {
        //BOLETA
        try {
            cn = conexion.connect();
            String [] titulos = {"C° OV","Codigo Prod","Descripción","Fecha","Neto","Valor Total"};
            String sql = "SELECT * FROM orden_venta";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [6];
            while (rs.next()){
                fila[0]=rs.getString("codigo_ov");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("fecha");
                
                Double v_venta = Double.parseDouble(rs.getString("precio"));
                Double v_neto = v_venta/1.19;
                Integer v_neto1 = (int) Math.round(v_neto);
                String neto = Integer.toString(v_neto1);
                fila[4]=(neto);
                fila[5]=rs.getString("precio");             
            model.addRow(fila);
            }
            jtbl_oc_bol.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_ordenventa() {
        //ORDEN DE VENTA
        try {
            cn = conexion.connect();
            String [] titulos = {"Codigo OV","Codigo Prod","Descripción","Fecha","Precio Venta"};
            String sql = "SELECT codigo_ov, codigo_prod, descripcion, fecha, precio FROM orden_venta";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [5];
            while (rs.next()){
                fila[0]=rs.getString("codigo_ov");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("fecha");
                fila[4]=rs.getString("precio");           
            model.addRow(fila);
            }
            jtbl_ordenventa.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_prodbol() {
        //BOLETA
        try {
            cn = conexion.connect();
            String [] titulos = {"#","Codigo Prod","Descripción","Cantidad","Valor Compra","Neto Venta","Venta Total"};
            String sql = "SELECT id, codigo_prod, descripcion, lote, cantidad, fecha, valor_compra, valor_venta FROM productos";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [7];
            while (rs.next()){
                fila[0]=rs.getString("id");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("cantidad");
                fila[4]=rs.getString("valor_compra");
                
                Integer v_venta = Integer.parseInt(rs.getString("valor_venta"));
                Integer valor_porcentaje = v_venta*19/100;
                Integer valor_venta1 = v_venta + valor_porcentaje;
                String valor_ventap = Integer.toString(valor_venta1);
                fila[5]=rs.getString("valor_venta");
                fila[6]=(valor_ventap);                
            model.addRow(fila);
            }
            jtbl_prod_bol.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_boleta() {
        //BOLETA
        try {
            cn = conexion.connect();
            String [] titulos = {"N° Ingreso","Codigo Prod","Tipo Docto","N° Docto","Descripción","Fecha","Cantidad","Neto Venta","Venta Total","Forma Pago","N° Docto","N° Cuenta","N° Transferencia"};
            String sql = "SELECT * FROM detalleb";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [13];
            while (rs.next()){
                fila[0]=rs.getString("num_ingreso");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("tipo_doc");
                fila[3]=rs.getString("num_doc");
                fila[4]=rs.getString("descripcion");
                fila[5]=rs.getString("fecha");
                fila[6]=rs.getString("cantidad");
                fila[7]=rs.getString("neto");
                
                Integer v_venta = Integer.parseInt(rs.getString("neto"));
                Integer valor_porcentaje = v_venta*19/100;
                Integer valor_venta1 = v_venta + valor_porcentaje;
                String valor_ventap = Integer.toString(valor_venta1);
                fila[8]=(valor_ventap);
                fila[9]=rs.getString("forma_pago");
                fila[10]=rs.getString("num_doctob");
                fila[11]=rs.getString("num_cuentab");
                fila[12]=rs.getString("num_transb");
            model.addRow(fila);
            }
            jtbl_boletas.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_prodfact() {
        //ORDEN DE VENTA FACTURA
        try {
            cn = conexion.connect();
            String [] titulos = {"#","Codigo Prod","Descripción","Cantidad","Valor Compra","Valor Venta"};
            String sql = "SELECT id, codigo_prod, descripcion, cantidad, valor_compra, valor_venta FROM productos";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [6];
            while (rs.next()){
                fila[0]=rs.getString("id");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("cantidad");
                fila[4]=rs.getString("valor_compra");
                fila[5]=rs.getString("valor_venta");                
            model.addRow(fila);
            }
            jtbl_producto_fact.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_oc_fact() {
        //FACTURA
        try {
            cn = conexion.connect();
            String [] titulos = {"C° OV","Codigo Prod","Descripción","Fecha","Neto","Valor Total"};
            String sql = "SELECT * FROM orden_venta";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [6];
            while (rs.next()){
                fila[0]=rs.getString("codigo_ov");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("fecha");
                
                Double v_venta = Double.parseDouble(rs.getString("precio"));
                Double v_neto = v_venta/1.19;
                Integer v_neto1 = (int) Math.round(v_neto);
                String neto = Integer.toString(v_neto1);
                fila[4]=(neto);
                fila[5]=rs.getString("precio");             
            model.addRow(fila);
            }
            jtbl_oc_fact.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_factura() {
        //FACTURA
        try {
            cn = conexion.connect();
            String [] titulos = {"N° Ingreso","Codigo Prod","Tipo Docto","N° Docto","Cliente","Dirección","Rut","Ciudad","Provincia","Giro","Fono","Despacho","Descripción","Fecha","Cantidad","Neto Venta","Venta Total","Forma Pago","N° Docto","N° Cuenta","N° Transferencia"};
            String sql = "SELECT * FROM detallef";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [21];
            while (rs.next()){
                fila[0]=rs.getString("num_ingreso");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("tipo_doc");
                fila[3]=rs.getString("num_doc");
                fila[4]=rs.getString("cliente");
                fila[5]=rs.getString("direccion");
                fila[6]=rs.getString("rut");
                fila[7]=rs.getString("ciudad");
                fila[8]=rs.getString("provincia");
                fila[9]=rs.getString("giro");
                fila[10]=rs.getString("fono");
                fila[11]=rs.getString("despacho");
                fila[12]=rs.getString("descripcion");
                fila[13]=rs.getString("fecha");
                fila[14]=rs.getString("cantidad");
                fila[15]=rs.getString("neto");
                
                Integer v_venta = Integer.parseInt(rs.getString("neto"));
                Integer valor_porcentaje = v_venta*19/100;
                Integer valor_venta1 = v_venta + valor_porcentaje;
                String valor_ventap = Integer.toString(valor_venta1);
                fila[16]=(valor_ventap);
                fila[17]=rs.getString("forma_pago");
                fila[18]=rs.getString("num_doctof");
                fila[19]=rs.getString("num_cuentaf");
                fila[20]=rs.getString("num_transf");
            model.addRow(fila);
            }
            jtbl_factura.setModel(model);
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
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_codprodov = new javax.swing.JTextField();
        txt_ov = new javax.swing.JTextField();
        txt_descripcionov = new javax.swing.JTextField();
        jdt_fechaov = new com.toedter.calendar.JDateChooser();
        txt_precioov = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlbl_ivaov = new javax.swing.JLabel();
        jlbl_totalov = new javax.swing.JLabel();
        btn_nuevo_ov = new javax.swing.JButton();
        btn_guardar_ov = new javax.swing.JButton();
        btn_modificar_ov = new javax.swing.JButton();
        btn_eliminar_ov = new javax.swing.JButton();
        btn_actualizar_ov = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_productos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_ordenventa = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_codprodbol = new javax.swing.JTextField();
        txt_ingresobol = new javax.swing.JTextField();
        jcbx_tipodocbol = new javax.swing.JComboBox<>();
        txt_numdocbol = new javax.swing.JTextField();
        txt_descripcionbol = new javax.swing.JTextField();
        jdt_fechabol = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jcbx_formapbol = new javax.swing.JComboBox<>();
        txt_cantidadbol = new javax.swing.JTextField();
        txt_netobol = new javax.swing.JTextField();
        txt_doctobol = new javax.swing.JTextField();
        txt_cuentabol = new javax.swing.JTextField();
        txt_transbol = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbl_oc_bol = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbl_prod_bol = new javax.swing.JTable();
        btn_nuevo_bol = new javax.swing.JButton();
        btn_guardar_bol = new javax.swing.JButton();
        btn_trans_bol = new javax.swing.JButton();
        btn_eliminar_bol = new javax.swing.JButton();
        btn_actualizar_bol = new javax.swing.JButton();
        btn_mod_bol = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbl_boletas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_codprodf = new javax.swing.JTextField();
        txt_ingresof = new javax.swing.JTextField();
        txt_clientefact = new javax.swing.JTextField();
        jcbx_tipodocfact = new javax.swing.JComboBox<>();
        txt_ndoctofact = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jdt_fechafact = new com.toedter.calendar.JDateChooser();
        txt_direccionfact = new javax.swing.JTextField();
        txt_rutfact = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_provinciafact = new javax.swing.JTextField();
        txt_ciudadfact = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_girofact = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_fonofact = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jcbx_formapfact = new javax.swing.JComboBox<>();
        txt_cantidadfact = new javax.swing.JTextField();
        txt_descripcionfact = new javax.swing.JTextField();
        jcbx_despachofact = new javax.swing.JComboBox<>();
        txt_doctofact = new javax.swing.JTextField();
        txt_cuentafact = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txt_transfact = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txt_netofact = new javax.swing.JTextField();
        btn_nuevo_fact = new javax.swing.JButton();
        btn_guardar_fact = new javax.swing.JButton();
        btn_modificar_fact = new javax.swing.JButton();
        btn_eliminar_fact = new javax.swing.JButton();
        btn_transacc_fact = new javax.swing.JButton();
        btn_actualizar_fact = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtbl_oc_fact = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtbl_producto_fact = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtbl_factura = new javax.swing.JTable();
        jtbr_actividad = new javax.swing.JToolBar();
        jLabel7 = new javax.swing.JLabel();
        jlbl_actividad = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingreso de Ventas");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(java.awt.SystemColor.activeCaption);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/ventas1.png"))); // NOI18N
        jLabel1.setText("Ingreso de Ventas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 772, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jTabbedPane1.setBackground(java.awt.SystemColor.activeCaption);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel2.setText("Codigo OV:");

        jLabel3.setText("Codigo Prod:");

        jLabel4.setText("Descripción:");

        jLabel5.setText("Fecha:");

        jLabel6.setText("Precio Neto:");

        jdt_fechaov.setBackground(java.awt.SystemColor.activeCaption);
        jdt_fechaov.setDateFormatString("yyyy-MM-dd");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Iva:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Total:");

        jlbl_ivaov.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_ivaov.setForeground(new java.awt.Color(255, 0, 0));

        jlbl_totalov.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_totalov.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_descripcionov)
                    .addComponent(txt_ov)
                    .addComponent(txt_codprodov)
                    .addComponent(jdt_fechaov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_precioov, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbl_ivaov, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(jlbl_totalov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbl_ivaov, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_ov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jlbl_totalov, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_codprodov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(21, 21, 21)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_descripcionov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jdt_fechaov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_precioov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        btn_nuevo_ov.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_ov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_ov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_ovActionPerformed(evt);
            }
        });

        btn_guardar_ov.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_ov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_ov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_ovActionPerformed(evt);
            }
        });

        btn_modificar_ov.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_ov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_ov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_ovActionPerformed(evt);
            }
        });

        btn_eliminar_ov.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_ov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_ov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_ovActionPerformed(evt);
            }
        });

        btn_actualizar_ov.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_ov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_ov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_ovActionPerformed(evt);
            }
        });

        jtbl_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Codigo Prod", "Descripción", "Lote", "Cantidad", "Fecha", "Valor Compra", "Valor Venta"
            }
        ));
        jtbl_productos.setToolTipText("Tablas Productos para Llenado de Campos");
        jtbl_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_productos);

        jtbl_ordenventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo OV", "Codigo Prod", "Descripción", "Fecha", "Precio Venta"
            }
        ));
        jtbl_ordenventa.setToolTipText("Tabla Orden Ventas [Almacenado]");
        jtbl_ordenventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_ordenventaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_ordenventa);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_nuevo_ov, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_guardar_ov, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificar_ov, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar_ov, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_actualizar_ov, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(927, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_nuevo_ov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar_ov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificar_ov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar_ov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar_ov))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Orden de Ventas", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        jPanel7.setBackground(java.awt.SystemColor.activeCaption);
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel10.setText("N° Ingreso:");

        jLabel11.setText("Codigo Prod:");

        jLabel12.setText("Tipo Docto:");

        jLabel18.setText("N° Docto:");

        jLabel19.setText("Descripcion:");

        jLabel20.setText("Fecha:");

        jcbx_tipodocbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Documento" }));

        jdt_fechabol.setDateFormatString("yyyy-MM-dd");

        jLabel21.setText("Cantidad:");

        jLabel22.setText("Neto:");

        jLabel23.setText("Forma Pago:");

        jLabel24.setText("N° Docto:");

        jLabel25.setText("N° Cuenta:");

        jLabel26.setText("N° Trans:");

        jcbx_formapbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Cheque", "Transferencia", "Tarjeta Credito", "Cuenta Corriente" }));
        jcbx_formapbol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbx_formapbolItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codprodbol)
                    .addComponent(txt_ingresobol)
                    .addComponent(jcbx_tipodocbol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_numdocbol)
                    .addComponent(txt_descripcionbol)
                    .addComponent(jdt_fechabol, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_cantidadbol)
                    .addComponent(jcbx_formapbol, 0, 1, Short.MAX_VALUE)
                    .addComponent(txt_netobol)
                    .addComponent(txt_doctobol)
                    .addComponent(txt_cuentabol)
                    .addComponent(txt_transbol, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_ingresobol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txt_cantidadbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_codprodbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txt_netobol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jcbx_tipodocbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jcbx_formapbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_numdocbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txt_doctobol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_descripcionbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txt_cuentabol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel20)
                        .addComponent(jdt_fechabol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txt_transbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbl_oc_bol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "C° OV", "Codigo Prod", "Descripción", "Fecha", "Neto", "Valor Total"
            }
        ));
        jtbl_oc_bol.setToolTipText("Datos Orden de Ventas para Llenado de Campos");
        jtbl_oc_bol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_oc_bolMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtbl_oc_bol);

        jtbl_prod_bol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Codigo Prod", "Descripción", "Cantidad", "Valor Compra", "Neto Venta", "Venta Total"
            }
        ));
        jtbl_prod_bol.setToolTipText("Datos Productos para Llenado de Campos");
        jtbl_prod_bol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_prod_bolMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtbl_prod_bol);

        btn_nuevo_bol.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_bol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_bol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_bolActionPerformed(evt);
            }
        });

        btn_guardar_bol.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_bol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_bol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_bolActionPerformed(evt);
            }
        });

        btn_trans_bol.setBackground(java.awt.SystemColor.activeCaption);
        btn_trans_bol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/1.png"))); // NOI18N
        btn_trans_bol.setToolTipText("Aplicar a Resta a Stock \"Transferencia\"");
        btn_trans_bol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trans_bolActionPerformed(evt);
            }
        });

        btn_eliminar_bol.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_bol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_bol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_bolActionPerformed(evt);
            }
        });

        btn_actualizar_bol.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_bol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_bol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_bolActionPerformed(evt);
            }
        });

        btn_mod_bol.setBackground(java.awt.SystemColor.activeCaption);
        btn_mod_bol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_mod_bol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mod_bolActionPerformed(evt);
            }
        });

        jtbl_boletas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° Ingreso", "Codigo Prod", "Tipo Docto", "N° Docto", "Descripción", "Fecha", "Cantidad", "Neto Venta", "Venta Total", "Forma Pago", "N° Docto", "N° Cuenta", "N° Transferencia"
            }
        ));
        jtbl_boletas.setToolTipText("Datos Detalle Facturas para Modificacion o Transferencia Hacia Tabla Productos");
        jtbl_boletas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_boletasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtbl_boletas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_nuevo_bol, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_guardar_bol, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_mod_bol, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_eliminar_bol, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_actualizar_bol, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_trans_bol, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nuevo_bol)
                    .addComponent(btn_guardar_bol)
                    .addComponent(btn_eliminar_bol)
                    .addComponent(btn_actualizar_bol)
                    .addComponent(btn_mod_bol)
                    .addComponent(btn_trans_bol))
                .addGap(69, 69, 69))
        );

        jTabbedPane1.addTab("Ingreso de Boletas", jPanel4);

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);

        jPanel8.setBackground(java.awt.SystemColor.activeCaption);
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel13.setText("N° Ingreso:");

        jLabel14.setText("Codigo Prod:");

        jLabel15.setText("Tipo Docto:");

        jLabel16.setText("N° Docto:");

        jLabel17.setText("Cliente:");

        jcbx_tipodocfact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Documento" }));

        jLabel27.setText("Direccion:");

        jLabel28.setText("Rut:");

        jLabel29.setText("Fecha:");

        jdt_fechafact.setDateFormatString("yyyy-MM-dd");

        jLabel30.setText("Ciudad:");

        jLabel31.setText("Provincia:");

        jLabel32.setText("Giro:");

        jLabel33.setText("Fono:");

        jLabel34.setText("Despacho:");

        jLabel35.setText("Descripcion:");

        jLabel36.setText("Cantidad:");

        jLabel37.setText("Forma Pago:");

        jLabel38.setText("N° Docto:");

        jLabel39.setText("N° Cuenta:");

        jcbx_formapfact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Cheque", "Transferencia", "Tarjeta Credito", "Cuenta Corriente" }));
        jcbx_formapfact.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbx_formapfactItemStateChanged(evt);
            }
        });

        jcbx_despachofact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel40.setText("N° Trans:");

        jLabel41.setText("Neto:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ingresof)
                    .addComponent(txt_codprodf)
                    .addComponent(txt_clientefact)
                    .addComponent(jcbx_tipodocfact, 0, 103, Short.MAX_VALUE)
                    .addComponent(txt_ndoctofact)
                    .addComponent(txt_direccionfact))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdt_fechafact, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(txt_rutfact)
                            .addComponent(txt_ciudadfact)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_provinciafact)
                            .addComponent(txt_girofact)
                            .addComponent(txt_fonofact))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbx_formapfact, 0, 105, Short.MAX_VALUE)
                            .addComponent(txt_cantidadfact)
                            .addComponent(jcbx_despachofact, 0, 105, Short.MAX_VALUE)
                            .addComponent(txt_doctofact)
                            .addComponent(txt_descripcionfact))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txt_transfact, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txt_cuentafact)
                                .addContainerGap())))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txt_netofact)
                        .addGap(191, 191, 191))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txt_ingresof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)
                        .addComponent(txt_rutfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34)
                        .addComponent(jcbx_despachofact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel39)
                    .addComponent(txt_cuentafact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_codprodf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addComponent(jdt_fechafact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(txt_descripcionfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40)
                        .addComponent(txt_transfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jcbx_tipodocfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txt_ciudadfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(txt_cantidadfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txt_ndoctofact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31)
                        .addComponent(txt_provinciafact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41))
                    .addComponent(txt_netofact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_clientefact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(txt_girofact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txt_direccionfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(txt_fonofact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jcbx_formapfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txt_doctofact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_nuevo_fact.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_fact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_factActionPerformed(evt);
            }
        });

        btn_guardar_fact.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_fact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_factActionPerformed(evt);
            }
        });

        btn_modificar_fact.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_fact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_factActionPerformed(evt);
            }
        });

        btn_eliminar_fact.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_fact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_factActionPerformed(evt);
            }
        });

        btn_transacc_fact.setBackground(java.awt.SystemColor.activeCaption);
        btn_transacc_fact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/1.png"))); // NOI18N
        btn_transacc_fact.setToolTipText("Aplicar a Resta a Stock \"Transferencia\"");
        btn_transacc_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transacc_factActionPerformed(evt);
            }
        });

        btn_actualizar_fact.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_fact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_factActionPerformed(evt);
            }
        });

        jtbl_oc_fact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "C° OV", "Codigo Prod", "Descripción", "Fecha", "Neto", "Valor Total"
            }
        ));
        jtbl_oc_fact.setToolTipText("Datos Orden de Ventas para Llenado de Campos");
        jtbl_oc_fact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_oc_factMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtbl_oc_fact);

        jtbl_producto_fact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Codigo Prod", "Descripción", "Cantidad", "Valor Compra", "Valor Venta"
            }
        ));
        jtbl_producto_fact.setToolTipText("Datos Productos para Llenado de Campos");
        jtbl_producto_fact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_producto_factMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jtbl_producto_fact);

        jtbl_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° Ingreso", "Codigo Prod", "Tipo Docto", "N° Docto", "Cliente", "Dirección", "Rut", "Ciudad", "Provincia", "Giro", "Fono", "Despacho", "Descripción", "Fecha", "Cantidad", "Neto Venta", "Venta Total"
            }
        ));
        jtbl_factura.setToolTipText("Datos Detalle Facturas para Modificacion o Transferencia Hacia Tabla Productos");
        jtbl_factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_facturaMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jtbl_factura);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                            .addComponent(jScrollPane7)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_nuevo_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guardar_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_modificar_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminar_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_transacc_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_nuevo_fact)
                            .addComponent(btn_guardar_fact)
                            .addComponent(btn_modificar_fact)
                            .addComponent(btn_eliminar_fact)
                            .addComponent(btn_transacc_fact)
                            .addComponent(btn_actualizar_fact))
                        .addGap(19, 19, 19))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Ingreso de Facturas", jPanel5);

        jtbr_actividad.setBackground(java.awt.SystemColor.activeCaption);
        jtbr_actividad.setRollover(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Actividad: ");
        jtbr_actividad.add(jLabel7);

        jlbl_actividad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_actividad.setForeground(new java.awt.Color(255, 0, 0));
        jtbr_actividad.add(jlbl_actividad);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jtbr_actividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jtbr_actividad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevo_ovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_ovActionPerformed
        // TODO add your handling code here:
        limpiar_ov();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(date);
        txt_ov.setText("OV"+dateString);
        habilitar_ov();
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_ovActionPerformed

    private void btn_guardar_ovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_ovActionPerformed
        // TODO add your handling code here:
        if (txt_ov.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Codigo de la Orden de Venta");
        }
        else if (txt_codprodov.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Codigo Producto");
        }
        else if (txt_descripcionov.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa la Descripción del Producto");
        }
        else if (jdt_fechaov.getDate() == null) {
            jlbl_actividad.setText("Ingresa la Fecha de Ingreso de la Orden");
        }
        else if (txt_precioov.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Proveedor de la Orden de Compras");
        }
        else {
            if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                try {
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO orden_venta (codigo_ov, codigo_prod, descripcion, fecha, precio) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    pps.setString(1, txt_ov.getText());
                    pps.setString(2, txt_codprodov.getText());
                    pps.setString(3, txt_descripcionov.getText());
                    pps.setString(4, ((JTextField)jdt_fechaov.getDateEditor().getUiComponent()).getText());
                    pps.setString(5, jlbl_totalov.getText());
                    pps.executeUpdate();
                    jlbl_actividad.setText("Datos Guardados");
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }        
    }//GEN-LAST:event_btn_guardar_ovActionPerformed

    private void btn_modificar_ovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_ovActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE orden_venta SET codigo_ov=?, codigo_prod=?, descripcion=?, fecha=?, precio=?"+"Where codigo_ov=?";
            int fila = jtbl_ordenventa.getSelectedRow();
            String dao = (String)jtbl_ordenventa.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_ov.getText());
            ps.setString(2, txt_codprodov.getText());
            ps.setString(3, txt_descripcionov.getText());
            ps.setString(4, ((JTextField)jdt_fechaov.getDateEditor().getUiComponent()).getText());
            ps.setString(5, jlbl_totalov.getText());
            ps.setString(6, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }//GEN-LAST:event_btn_modificar_ovActionPerformed

    private void btn_eliminar_ovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_ovActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_ordenventa.getSelectedRow();
            String sql = "DELETE FROM orden_venta WHERE codigo_ov='"+jtbl_ordenventa.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_ovActionPerformed

    private void btn_actualizar_ovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_ovActionPerformed
        // TODO add your handling code here:
        llenar_prodov();
        llenar_ordenventa();
        jlbl_actividad.setText("Datos de la tabla 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_ovActionPerformed

    private void jtbl_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_productosMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_productos.getSelectedRow();
            try{
                habilitar_ov();
                limpiar_ov();
                
                //Calculo de Neto
                Double neto = Double.parseDouble(jtbl_productos.getValueAt(fila, 7).toString());
                Double factor = 1.19;
                Double rtotal = (neto * factor);
                Integer total1 = Integer.valueOf(rtotal.intValue());
                String total = total1.toString();
                
                //Calculo de IVA
                Double neto2 = Double.parseDouble(jtbl_productos.getValueAt(fila, 7).toString());
                Double factor2 = 0.19;
                Double riva = (neto2*factor2);
                Integer iva2 = Integer.valueOf(riva.intValue());
                String iva = iva2.toString();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
                String dateString = formatter.format(date);
                txt_ov.setText("OV"+dateString);
                
                txt_codprodov.setText(jtbl_productos.getValueAt(fila, 1).toString());
                txt_descripcionov.setText(jtbl_productos.getValueAt(fila, 2).toString());
                txt_precioov.setText(jtbl_productos.getValueAt(fila, 7).toString());
                jlbl_ivaov.setText(iva);
                jlbl_totalov.setText(total);
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }//GEN-LAST:event_jtbl_productosMouseClicked

    private void jtbl_ordenventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_ordenventaMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_ordenventa.getSelectedRow();
            try{
                limpiar_ov();
                btn_modificar_ov.setEnabled(true);
                btn_eliminar_ov.setEnabled(true);
                btn_guardar_ov.setEnabled(false);
                
                Double total = Double.parseDouble(jtbl_ordenventa.getValueAt(fila, 4).toString());
                Double factor = 1.19;
                Double rtotal = (total / factor);
                Double riva = total - rtotal;
                Integer iva1 = (int) Math.round(riva);
                Integer neto1 = (int) Math.round(rtotal);
                String iva = Integer.toString(iva1);
                String neto = Integer.toString(neto1);
                
                txt_ov.setText(jtbl_ordenventa.getValueAt(fila, 0).toString());
                txt_codprodov.setText(jtbl_ordenventa.getValueAt(fila, 1).toString());
                txt_descripcionov.setText(jtbl_ordenventa.getValueAt(fila, 2).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_ordenventa.getValueAt(fila, 3).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_fechaov.setDate(fecha);
                
                txt_precioov.setText(neto);
                
                jlbl_ivaov.setText(iva);
                jlbl_totalov.setText(jtbl_ordenventa.getValueAt(fila, 4).toString());

                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }//GEN-LAST:event_jtbl_ordenventaMouseClicked

    private void jtbl_oc_bolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_oc_bolMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_oc_bol.getSelectedRow();
            try{
                habilitar_bol();
                limpiar_bol();                
                txt_ingresobol.setText(jtbl_oc_bol.getValueAt(fila, 0).toString());
                txt_codprodbol.setText(jtbl_oc_bol.getValueAt(fila, 1).toString());
                txt_descripcionbol.setText(jtbl_oc_bol.getValueAt(fila, 2).toString());
                txt_netobol.setText(jtbl_oc_bol.getValueAt(fila, 4).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }  
    }//GEN-LAST:event_jtbl_oc_bolMouseClicked

    private void jtbl_prod_bolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_prod_bolMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_prod_bol.getSelectedRow();
            try{
                habilitar_bol();
                limpiar_bol();      
                
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
                String dateString = formatter.format(date);
                txt_ingresobol.setText("INGB"+dateString);

                txt_codprodbol.setText(jtbl_prod_bol.getValueAt(fila, 1).toString());
                txt_descripcionbol.setText(jtbl_prod_bol.getValueAt(fila, 2).toString());
                txt_netobol.setText(jtbl_prod_bol.getValueAt(fila, 5).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }  
    }//GEN-LAST:event_jtbl_prod_bolMouseClicked

    private void btn_nuevo_bolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_bolActionPerformed
        // TODO add your handling code here:
        limpiar_bol();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(date);
        txt_ingresobol.setText("INGB"+dateString);
        habilitar_bol();
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_bolActionPerformed

    private void btn_guardar_bolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_bolActionPerformed
        // TODO add your handling code here:
        if (jcbx_formapbol.getSelectedItem().equals("Efectivo")) {
            if (txt_ingresobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Venta");
            }
            else if (txt_codprodbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_numdocbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Boleta");
            }
            else if (jdt_fechabol.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Boleta");
            }
            else if (txt_descripcionbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detalleb (num_ingreso, codigo_prod, tipo_doc, num_doc, descripcion, fecha, cantidad, neto, forma_pago, num_doctob, num_cuentab, num_transb) values (?,?,?,?,?,?,?,?,?,0,0,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresobol.getText());
                        pps.setString(2, txt_codprodbol.getText());
                        pps.setString(3, jcbx_tipodocbol.getSelectedItem().toString());
                        pps.setString(4, txt_numdocbol.getText());
                        pps.setString(5, txt_descripcionbol.getText());
                        pps.setString(6, ((JTextField)jdt_fechabol.getDateEditor().getUiComponent()).getText());
                        pps.setString(7, txt_cantidadbol.getText());
                        pps.setString(8, txt_netobol.getText());
                        pps.setString(9, jcbx_formapbol.getSelectedItem().toString());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
        if (jcbx_formapbol.getSelectedItem().equals("Cheque")) {
            if (txt_ingresobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Venta");
            }
            else if (txt_codprodbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_numdocbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Boleta");
            }
            else if (jdt_fechabol.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Boleta");
            }
            else if (txt_descripcionbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else if (txt_doctobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el N° Documento Bancario");
            }
            else if (txt_cuentabol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Cuenta Bancario");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detalleb (num_ingreso, codigo_prod, tipo_doc, num_doc, descripcion, fecha, cantidad, neto, forma_pago, num_doctob, num_cuentab, num_transb) values (?,?,?,?,?,?,?,?,?,?,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresobol.getText());
                        pps.setString(2, txt_codprodbol.getText());
                        pps.setString(3, jcbx_tipodocbol.getSelectedItem().toString());
                        pps.setString(4, txt_numdocbol.getText());
                        pps.setString(5, txt_descripcionbol.getText());
                        pps.setString(6, ((JTextField)jdt_fechabol.getDateEditor().getUiComponent()).getText());
                        pps.setString(7, txt_cantidadbol.getText());
                        pps.setString(8, txt_netobol.getText());
                        pps.setString(9, jcbx_formapbol.getSelectedItem().toString());
                        pps.setString(10, txt_doctobol.getText());
                        pps.setString(11, txt_cuentabol.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
        if (jcbx_formapbol.getSelectedItem().equals("Transferencia")) {
            if (txt_ingresobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Venta");
            }
            else if (txt_codprodbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_numdocbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Boleta");
            }
            else if (jdt_fechabol.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Boleta");
            }
            else if (txt_descripcionbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else if (txt_cuentabol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Cuenta Bancario");
            }
            else if (txt_transbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Transferencia Bancario");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detalleb (num_ingreso, codigo_prod, tipo_doc, num_doc, descripcion, fecha, cantidad, neto, forma_pago, num_doctob, num_cuentab, num_transb) values (?,?,?,?,?,?,?,?,?,0,?,?)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresobol.getText());
                        pps.setString(2, txt_codprodbol.getText());
                        pps.setString(3, jcbx_tipodocbol.getSelectedItem().toString());
                        pps.setString(4, txt_numdocbol.getText());
                        pps.setString(5, txt_descripcionbol.getText());
                        pps.setString(6, ((JTextField)jdt_fechabol.getDateEditor().getUiComponent()).getText());
                        pps.setString(7, txt_cantidadbol.getText());
                        pps.setString(8, txt_netobol.getText());
                        pps.setString(9, jcbx_formapbol.getSelectedItem().toString());
                        pps.setString(10, txt_cuentabol.getText());
                        pps.setString(11, txt_transbol.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
        
        if (jcbx_formapbol.getSelectedItem().equals("Tarjeta Credito")) {
            if (txt_ingresobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Venta");
            }
            else if (txt_codprodbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_numdocbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Boleta");
            }
            else if (jdt_fechabol.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Boleta");
            }
            else if (txt_descripcionbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else if (txt_cuentabol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de la Tarjeta Credito");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detalleb (num_ingreso, codigo_prod, tipo_doc, num_doc, descripcion, fecha, cantidad, neto, forma_pago, num_doctob, num_cuentab, num_transb) values (?,?,?,?,?,?,?,?,?,0,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresobol.getText());
                        pps.setString(2, txt_codprodbol.getText());
                        pps.setString(3, jcbx_tipodocbol.getSelectedItem().toString());
                        pps.setString(4, txt_numdocbol.getText());
                        pps.setString(5, txt_descripcionbol.getText());
                        pps.setString(6, ((JTextField)jdt_fechabol.getDateEditor().getUiComponent()).getText());
                        pps.setString(7, txt_cantidadbol.getText());
                        pps.setString(8, txt_netobol.getText());
                        pps.setString(9, jcbx_formapbol.getSelectedItem().toString());
                        pps.setString(10, txt_cuentabol.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
        if (jcbx_formapbol.getSelectedItem().equals("Cuenta Corriente")) {
            if (txt_ingresobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Venta");
            }
            else if (txt_codprodbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_numdocbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Boleta");
            }
            else if (jdt_fechabol.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Boleta");
            }
            else if (txt_descripcionbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadbol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netobol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else if (txt_cuentabol.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de la Cuenta Corriente");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detalleb (num_ingreso, codigo_prod, tipo_doc, num_doc, descripcion, fecha, cantidad, neto, forma_pago, num_doctob, num_cuentab, num_transb) values (?,?,?,?,?,?,?,?,?,0,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresobol.getText());
                        pps.setString(2, txt_codprodbol.getText());
                        pps.setString(3, jcbx_tipodocbol.getSelectedItem().toString());
                        pps.setString(4, txt_numdocbol.getText());
                        pps.setString(5, txt_descripcionbol.getText());
                        pps.setString(6, ((JTextField)jdt_fechabol.getDateEditor().getUiComponent()).getText());
                        pps.setString(7, txt_cantidadbol.getText());
                        pps.setString(8, txt_netobol.getText());
                        pps.setString(9, jcbx_formapbol.getSelectedItem().toString());
                        pps.setString(10, txt_cuentabol.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_bolActionPerformed

    private void btn_trans_bolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trans_bolActionPerformed
        // TODO add your handling code here:
    try {
        int codigo_prodb;
        codigo_prodb = 0;
        int codigo_prodp;
        codigo_prodp = 0;
        
        PreparedStatement ps = (PreparedStatement) cn.prepareStatement("SELECT bol.codigo_prod FROM detalleb bol");
        PreparedStatement pss = (PreparedStatement) cn.prepareStatement("SELECT prod.codigo_prod FROM productos prod"); 
        ResultSet rs = ps.executeQuery();
        ResultSet rs1 = pss.executeQuery();
        while (rs.next()) {
        codigo_prodb = rs.getInt("codigo_prod");
        }
        while (rs1.next()) {
        codigo_prodp = rs1.getInt("codigo_prod");
        }
        ps.close();
        pss.close();
        rs.close();
        rs1.close();
        if (codigo_prodp >= 0 || codigo_prodp == codigo_prodb) {
                try {
                    String sql = "UPDATE productos SET cantidad=cantidad-?"+"Where codigo_prod=?";
                    int fila = jtbl_boletas.getSelectedRow();
                    String dao = (String)jtbl_boletas.getValueAt(fila, 1);
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement(sql);
                    pps.setString(1, txt_cantidadbol.getText());
                    pps.setString(2, dao);
                    int n = pps.executeUpdate();
                    if (n>0) {
                        jlbl_actividad.setText("Datos en Stock Modificados");
                    }
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
                }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    finally{};         
    }//GEN-LAST:event_btn_trans_bolActionPerformed

    private void btn_eliminar_bolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_bolActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_boletas.getSelectedRow();
            String sql = "DELETE FROM detalleb WHERE num_ingreso='"+jtbl_boletas.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_bolActionPerformed

    private void btn_actualizar_bolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_bolActionPerformed
        // TODO add your handling code here:
        llenar_oc_bol();
        llenar_prodbol();
        llenar_boleta();
    }//GEN-LAST:event_btn_actualizar_bolActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jcbx_formapbolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbx_formapbolItemStateChanged
        // TODO add your handling code here:
        if (jcbx_formapbol.getSelectedItem().equals("Efectivo")) {
            txt_doctobol.setText("");
            txt_cuentabol.setText("");
            txt_transbol.setText("");
            
            txt_doctobol.setEnabled(false);
            txt_cuentabol.setEnabled(false);
            txt_transbol.setEnabled(false);
        }if (jcbx_formapbol.getSelectedItem().equals("Cheque")) {
            txt_doctobol.setText("");
            
            txt_doctobol.setEnabled(true);
            txt_cuentabol.setEnabled(true);
            txt_transbol.setEnabled(false);   
        } if (jcbx_formapbol.getSelectedItem().equals("Transferencia")) {
            txt_doctobol.setText("");
            
            txt_doctobol.setEnabled(false);
            txt_cuentabol.setEnabled(true);
            txt_transbol.setEnabled(true);   
        } if (jcbx_formapbol.getSelectedItem().equals("Tarjeta Credito")) {
            txt_doctobol.setText("");
            
            txt_doctobol.setEnabled(false);
            txt_cuentabol.setEnabled(true);
            txt_transbol.setEnabled(false);   
        } if (jcbx_formapbol.getSelectedItem().equals("Cuenta Corriente")) {
            txt_doctobol.setText("");
            
            txt_doctobol.setEnabled(false);
            txt_cuentabol.setEnabled(true);
            txt_transbol.setEnabled(false);   
        }
    }//GEN-LAST:event_jcbx_formapbolItemStateChanged

    private void btn_mod_bolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mod_bolActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE detalleb SET num_ingreso=?, codigo_prod=?, tipo_doc=?, num_doc=?, descripcion=?, fecha=?, cantidad=?, neto=?, forma_pago=?, num_doctob=?, num_cuentab=?, num_transb=?"+"Where num_ingreso=?";
            int fila = jtbl_boletas.getSelectedRow();
            String dao = (String)jtbl_boletas.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_ingresobol.getText());
            ps.setString(2, txt_codprodbol.getText());
            ps.setString(3, jcbx_tipodocbol.getSelectedItem().toString());
            ps.setString(4, txt_numdocbol.getText());
            ps.setString(5, txt_descripcionbol.getText());
            ps.setString(6, ((JTextField)jdt_fechabol.getDateEditor().getUiComponent()).getText());
            ps.setString(7, txt_cantidadbol.getText());
            ps.setString(8, txt_netobol.getText());
            ps.setString(9, jcbx_formapbol.getSelectedItem().toString());
            ps.setString(10, txt_doctobol.getText());
            ps.setString(11, txt_cuentabol.getText());
            ps.setString(12, txt_transbol.getText());
            ps.setString(13, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }        
    }//GEN-LAST:event_btn_mod_bolActionPerformed

    private void jtbl_boletasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_boletasMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_boletas.getSelectedRow();
            try{
                limpiar_bol();
                habilitar_bol();
                btn_mod_bol.setEnabled(true);
                btn_eliminar_bol.setEnabled(true);
                btn_guardar_bol.setEnabled(false);   
                
                txt_ingresobol.setText(jtbl_boletas.getValueAt(fila, 0).toString());
                txt_codprodbol.setText(jtbl_boletas.getValueAt(fila, 1).toString());
                jcbx_tipodocbol.setSelectedItem(jtbl_boletas.getValueAt(fila, 2).toString());
                txt_numdocbol.setText(jtbl_boletas.getValueAt(fila, 3).toString());
                txt_descripcionbol.setText(jtbl_boletas.getValueAt(fila, 4).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_boletas.getValueAt(fila,5).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_fechabol.setDate(fecha);
                
                txt_cantidadbol.setText(jtbl_boletas.getValueAt(fila, 6).toString());
                txt_netobol.setText(jtbl_boletas.getValueAt(fila, 7).toString());
                jcbx_formapbol.setSelectedItem(jtbl_boletas.getValueAt(fila, 9).toString());
                txt_doctobol.setText(jtbl_boletas.getValueAt(fila, 10).toString());
                txt_cuentabol.setText(jtbl_boletas.getValueAt(fila, 11).toString());
                txt_transbol.setText(jtbl_boletas.getValueAt(fila, 12).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }  
    }//GEN-LAST:event_jtbl_boletasMouseClicked

    private void btn_nuevo_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_factActionPerformed
        // TODO add your handling code here:
        limpiar_fact();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(date);
        txt_ingresof.setText("INGF"+dateString);
        habilitar_fact();
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_factActionPerformed

    private void jtbl_oc_factMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_oc_factMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_oc_fact.getSelectedRow();
            try{
                habilitar_fact();
                limpiar_fact();                
                txt_ingresof.setText(jtbl_oc_fact.getValueAt(fila, 0).toString());
                txt_codprodf.setText(jtbl_oc_fact.getValueAt(fila, 1).toString());
                txt_descripcionfact.setText(jtbl_oc_fact.getValueAt(fila, 2).toString());
                txt_netofact.setText(jtbl_oc_fact.getValueAt(fila, 4).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        } 
    }//GEN-LAST:event_jtbl_oc_factMouseClicked

    private void jtbl_producto_factMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_producto_factMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_producto_fact.getSelectedRow();
            try{
                habilitar_fact();
                limpiar_fact();      
                
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
                String dateString = formatter.format(date);
                txt_ingresof.setText("INGF"+dateString);

                txt_codprodf.setText(jtbl_producto_fact.getValueAt(fila, 1).toString());
                txt_descripcionfact.setText(jtbl_producto_fact.getValueAt(fila, 2).toString());
                txt_netofact.setText(jtbl_producto_fact.getValueAt(fila, 5).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        } 
    }//GEN-LAST:event_jtbl_producto_factMouseClicked

    private void jcbx_formapfactItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbx_formapfactItemStateChanged
        // TODO add your handling code here:
        if (jcbx_formapfact.getSelectedItem().equals("Efectivo")) {
            txt_doctofact.setText("");
            txt_cuentafact.setText("");
            txt_transfact.setText("");
            
            txt_doctofact.setEnabled(false);
            txt_cuentafact.setEnabled(false);
            txt_transfact.setEnabled(false);
        }if (jcbx_formapfact.getSelectedItem().equals("Cheque")) {
            txt_doctofact.setText("");
            
            txt_doctofact.setEnabled(true);
            txt_cuentafact.setEnabled(true);
            txt_transfact.setEnabled(false);   
        } if (jcbx_formapfact.getSelectedItem().equals("Transferencia")) {
            txt_doctofact.setText("");
            
            txt_doctofact.setEnabled(false);
            txt_cuentafact.setEnabled(true);
            txt_transfact.setEnabled(true);   
        } if (jcbx_formapfact.getSelectedItem().equals("Tarjeta Credito")) {
            txt_doctofact.setText("");
            
            txt_doctofact.setEnabled(false);
            txt_cuentafact.setEnabled(true);
            txt_transfact.setEnabled(false);   
        } if (jcbx_formapfact.getSelectedItem().equals("Cuenta Corriente")) {
            txt_doctofact.setText("");
            
            txt_doctofact.setEnabled(false);
            txt_cuentafact.setEnabled(true);
            txt_transfact.setEnabled(false);   
        }
    }//GEN-LAST:event_jcbx_formapfactItemStateChanged

    private void btn_actualizar_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_factActionPerformed
        // TODO add your handling code here:
        habilitar_fact();
        limpiar_fact();
        llenar_factura();
        llenar_oc_fact();
        llenar_prodfact();
    }//GEN-LAST:event_btn_actualizar_factActionPerformed

    private void jtbl_facturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_facturaMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_factura.getSelectedRow();
            try{
                limpiar_fact();     
                habilitar_fact();
                btn_modificar_fact.setEnabled(true);
                btn_eliminar_fact.setEnabled(true);
                btn_guardar_fact.setEnabled(false);

                txt_ingresof.setText(jtbl_factura.getValueAt(fila, 0).toString());
                txt_codprodf.setText(jtbl_factura.getValueAt(fila, 1).toString());
                jcbx_tipodocfact.setSelectedItem(jtbl_factura.getValueAt(fila, 2).toString());
                txt_ndoctofact.setText(jtbl_factura.getValueAt(fila, 3).toString());
                txt_clientefact.setText(jtbl_factura.getValueAt(fila, 4).toString());
                txt_direccionfact.setText(jtbl_factura.getValueAt(fila, 5).toString());
                txt_rutfact.setText(jtbl_factura.getValueAt(fila, 6).toString());
                txt_ciudadfact.setText(jtbl_factura.getValueAt(fila, 7).toString());
                txt_provinciafact.setText(jtbl_factura.getValueAt(fila, 8).toString());
                txt_girofact.setText(jtbl_factura.getValueAt(fila, 9).toString());
                txt_fonofact.setText(jtbl_factura.getValueAt(fila, 10).toString());
                jcbx_despachofact.setSelectedItem(jtbl_factura.getValueAt(fila, 11).toString());
                txt_descripcionfact.setText(jtbl_factura.getValueAt(fila, 12).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_factura.getValueAt(fila,13).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_fechafact.setDate(fecha);
                
                txt_cantidadfact.setText(jtbl_factura.getValueAt(fila, 14).toString());
                txt_netofact.setText(jtbl_factura.getValueAt(fila, 15).toString());
                jcbx_formapfact.setSelectedItem(jtbl_factura.getValueAt(fila, 17).toString());
                txt_doctofact.setText(jtbl_factura.getValueAt(fila, 18).toString());
                txt_cuentafact.setText(jtbl_factura.getValueAt(fila, 19).toString());
                txt_transfact.setText(jtbl_factura.getValueAt(fila, 20).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }      
    }//GEN-LAST:event_jtbl_facturaMouseClicked

    private void btn_eliminar_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_factActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_factura.getSelectedRow();
            String sql = "DELETE FROM detallef WHERE num_ingreso='"+jtbl_factura.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_factActionPerformed

    private void btn_modificar_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_factActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE detallef SET num_ingreso=?, codigo_prod=?, tipo_doc=?, num_doc=?, cliente=?, direccion=?, rut=?, fecha=?, ciudad=?, provincia=?, giro=?, fono=?, despacho=?, descripcion=?, cantidad=?, neto=?, forma_pago=?, num_doctof=?, num_cuentaf=?, num_transf=?"+"Where num_ingreso=?";
            int fila = jtbl_factura.getSelectedRow();
            String dao = (String)jtbl_factura.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_ingresof.getText());
            ps.setString(2, txt_codprodf.getText());
            ps.setString(3, jcbx_tipodocfact.getSelectedItem().toString());
            ps.setString(4, txt_ndoctofact.getText());
            ps.setString(5, txt_clientefact.getText());
            ps.setString(6, txt_direccionfact.getText());
            ps.setString(7, txt_rutfact.getText());
            ps.setString(8, ((JTextField)jdt_fechafact.getDateEditor().getUiComponent()).getText());
            ps.setString(9, txt_ciudadfact.getText());
            ps.setString(10, txt_provinciafact.getText());
            ps.setString(11, txt_girofact.getText());
            ps.setString(12, txt_fonofact.getText());
            ps.setString(13, jcbx_despachofact.getSelectedItem().toString());
            ps.setString(14, txt_descripcionfact.getText());
            ps.setString(15, txt_cantidadfact.getText());
            ps.setString(16, txt_netofact.getText());
            ps.setString(17, jcbx_formapfact.getSelectedItem().toString());
            ps.setString(18, txt_doctofact.getText());
            ps.setString(19, txt_cuentafact.getText());
            ps.setString(20, txt_transfact.getText());
            ps.setString(21, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }        
    }//GEN-LAST:event_btn_modificar_factActionPerformed

    private void btn_guardar_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_factActionPerformed
        // TODO add your handling code here:
        if (jcbx_formapfact.getSelectedItem().equals("Efectivo")) {
            if (txt_ingresof.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Ingreso de la Factura");
            }
            else if (txt_codprodf.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_ndoctofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Factura");
            }
            else if (txt_clientefact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Nombre del Cliente");
            }
            else if (txt_direccionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Dirección del Cliente");
            }
            else if (txt_rutfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Rut del Cliente");
            }
            else if (jdt_fechafact.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Factura");
            }
            else if (txt_ciudadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Ciudad del Cliente");
            }
            else if (txt_provinciafact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Provincia del Cliente");
            }
            else if (txt_fonofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Telefono del Cliente");
            }
            else if (txt_girofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Giro del Cliente");
            }
            else if (txt_descripcionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detallef (num_ingreso, codigo_prod, tipo_doc, num_doc, cliente, direccion, rut, fecha, ciudad, provincia, giro, fono, despacho, descripcion, cantidad, neto, forma_pago, num_doctof, num_cuentaf, num_transf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresof.getText());
                        pps.setString(2, txt_codprodf.getText());
                        pps.setString(3, jcbx_tipodocfact.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctofact.getText());
                        pps.setString(5, txt_clientefact.getText());
                        pps.setString(6, txt_direccionfact.getText());
                        pps.setString(7, txt_rutfact.getText());
                        pps.setString(8, ((JTextField)jdt_fechafact.getDateEditor().getUiComponent()).getText());
                        pps.setString(9, txt_ciudadfact.getText());
                        pps.setString(10, txt_provinciafact.getText());
                        pps.setString(11, txt_girofact.getText());
                        pps.setString(12, txt_fonofact.getText());
                        pps.setString(13, jcbx_despachofact.getSelectedItem().toString());
                        pps.setString(14, txt_descripcionfact.getText());
                        pps.setString(15, txt_cantidadfact.getText());
                        pps.setString(16, txt_netofact.getText());
                        pps.setString(17, jcbx_formapfact.getSelectedItem().toString());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
        if (jcbx_formapfact.getSelectedItem().equals("Cheque")) {
            if (txt_ingresof.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Ingreso de la Factura");
            }
            else if (txt_codprodf.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_ndoctofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Factura");
            }
            else if (txt_clientefact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Nombre del Cliente");
            }
            else if (txt_direccionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Dirección del Cliente");
            }
            else if (txt_rutfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Rut del Cliente");
            }
            else if (jdt_fechafact.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Factura");
            }
            else if (txt_ciudadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Ciudad del Cliente");
            }
            else if (txt_provinciafact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Provincia del Cliente");
            }
            else if (txt_fonofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Telefono del Cliente");
            }
            else if (txt_girofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Giro del Cliente");
            }
            else if (txt_descripcionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else if (txt_doctofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el N° Docto Bancario");
            }
            else if (txt_cuentafact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el N° de Cuenta Bancario");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detallef (num_ingreso, codigo_prod, tipo_doc, num_doc, cliente, direccion, rut, fecha, ciudad, provincia, giro, fono, despacho, descripcion, cantidad, neto, forma_pago, num_doctof, num_cuentaf, num_transf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresof.getText());
                        pps.setString(2, txt_codprodf.getText());
                        pps.setString(3, jcbx_tipodocfact.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctofact.getText());
                        pps.setString(5, txt_clientefact.getText());
                        pps.setString(6, txt_direccionfact.getText());
                        pps.setString(7, txt_rutfact.getText());
                        pps.setString(8, ((JTextField)jdt_fechafact.getDateEditor().getUiComponent()).getText());
                        pps.setString(9, txt_ciudadfact.getText());
                        pps.setString(10, txt_provinciafact.getText());
                        pps.setString(11, txt_girofact.getText());
                        pps.setString(12, txt_fonofact.getText());
                        pps.setString(13, jcbx_despachofact.getSelectedItem().toString());
                        pps.setString(14, txt_descripcionfact.getText());
                        pps.setString(15, txt_cantidadfact.getText());
                        pps.setString(16, txt_netofact.getText());
                        pps.setString(17, jcbx_formapfact.getSelectedItem().toString());
                        pps.setString(18, txt_doctofact.getText());
                        pps.setString(19, txt_cuentafact.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
        if (jcbx_formapfact.getSelectedItem().equals("Transferencia")) {
            if (txt_ingresof.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Ingreso de la Factura");
            }
            else if (txt_codprodf.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_ndoctofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Factura");
            }
            else if (txt_clientefact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Nombre del Cliente");
            }
            else if (txt_direccionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Dirección del Cliente");
            }
            else if (txt_rutfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Rut del Cliente");
            }
            else if (jdt_fechafact.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Factura");
            }
            else if (txt_ciudadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Ciudad del Cliente");
            }
            else if (txt_provinciafact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Provincia del Cliente");
            }
            else if (txt_fonofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Telefono del Cliente");
            }
            else if (txt_girofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Giro del Cliente");
            }
            else if (txt_descripcionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else if (txt_cuentafact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el N° Cuenta Bancario");
            }
            else if (txt_transfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el N° de Transaccion Bancario");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detallef (num_ingreso, codigo_prod, tipo_doc, num_doc, cliente, direccion, rut, fecha, ciudad, provincia, giro, fono, despacho, descripcion, cantidad, neto, forma_pago, num_doctof, num_cuentaf, num_transf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,?,?)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresof.getText());
                        pps.setString(2, txt_codprodf.getText());
                        pps.setString(3, jcbx_tipodocfact.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctofact.getText());
                        pps.setString(5, txt_clientefact.getText());
                        pps.setString(6, txt_direccionfact.getText());
                        pps.setString(7, txt_rutfact.getText());
                        pps.setString(8, ((JTextField)jdt_fechafact.getDateEditor().getUiComponent()).getText());
                        pps.setString(9, txt_ciudadfact.getText());
                        pps.setString(10, txt_provinciafact.getText());
                        pps.setString(11, txt_girofact.getText());
                        pps.setString(12, txt_fonofact.getText());
                        pps.setString(13, jcbx_despachofact.getSelectedItem().toString());
                        pps.setString(14, txt_descripcionfact.getText());
                        pps.setString(15, txt_cantidadfact.getText());
                        pps.setString(16, txt_netofact.getText());
                        pps.setString(17, jcbx_formapfact.getSelectedItem().toString());
                        pps.setString(18, txt_cuentafact.getText());
                        pps.setString(19, txt_transfact.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
        
        if (jcbx_formapfact.getSelectedItem().equals("Tarjeta Credito")) {
            if (txt_ingresof.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Ingreso de la Factura");
            }
            else if (txt_codprodf.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_ndoctofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Factura");
            }
            else if (txt_clientefact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Nombre del Cliente");
            }
            else if (txt_direccionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Dirección del Cliente");
            }
            else if (txt_rutfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Rut del Cliente");
            }
            else if (jdt_fechafact.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Factura");
            }
            else if (txt_ciudadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Ciudad del Cliente");
            }
            else if (txt_provinciafact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Provincia del Cliente");
            }
            else if (txt_fonofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Telefono del Cliente");
            }
            else if (txt_girofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Giro del Cliente");
            }
            else if (txt_descripcionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else if (txt_cuentafact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el N° Cuenta Tarjeta Credito");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detallef (num_ingreso, codigo_prod, tipo_doc, num_doc, cliente, direccion, rut, fecha, ciudad, provincia, giro, fono, despacho, descripcion, cantidad, neto, forma_pago, num_doctof, num_cuentaf, num_transf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresof.getText());
                        pps.setString(2, txt_codprodf.getText());
                        pps.setString(3, jcbx_tipodocfact.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctofact.getText());
                        pps.setString(5, txt_clientefact.getText());
                        pps.setString(6, txt_direccionfact.getText());
                        pps.setString(7, txt_rutfact.getText());
                        pps.setString(8, ((JTextField)jdt_fechafact.getDateEditor().getUiComponent()).getText());
                        pps.setString(9, txt_ciudadfact.getText());
                        pps.setString(10, txt_provinciafact.getText());
                        pps.setString(11, txt_girofact.getText());
                        pps.setString(12, txt_fonofact.getText());
                        pps.setString(13, jcbx_despachofact.getSelectedItem().toString());
                        pps.setString(14, txt_descripcionfact.getText());
                        pps.setString(15, txt_cantidadfact.getText());
                        pps.setString(16, txt_netofact.getText());
                        pps.setString(17, jcbx_formapfact.getSelectedItem().toString());
                        pps.setString(18, txt_cuentafact.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
        if (jcbx_formapbol.getSelectedItem().equals("Cuenta Corriente")) {
            if (txt_ingresof.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Ingreso de la Factura");
            }
            else if (txt_codprodf.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo Producto");
            }
            else if (txt_ndoctofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento Factura");
            }
            else if (txt_clientefact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Nombre del Cliente");
            }
            else if (txt_direccionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Dirección del Cliente");
            }
            else if (txt_rutfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Rut del Cliente");
            }
            else if (jdt_fechafact.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de la Factura");
            }
            else if (txt_ciudadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Ciudad del Cliente");
            }
            else if (txt_provinciafact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Provincia del Cliente");
            }
            else if (txt_fonofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Telefono del Cliente");
            }
            else if (txt_girofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Giro del Cliente");
            }
            else if (txt_descripcionfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Poducto");
            }
            else if (txt_cantidadfact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad");
            }
            else if (txt_netofact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Neto");
            }
            else if (txt_cuentafact.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el N° Cuenta Tarjeta Credito");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO detallef (num_ingreso, codigo_prod, tipo_doc, num_doc, cliente, direccion, rut, fecha, ciudad, provincia, giro, fono, despacho, descripcion, cantidad, neto, forma_pago, num_doctof, num_cuentaf, num_transf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_ingresof.getText());
                        pps.setString(2, txt_codprodf.getText());
                        pps.setString(3, jcbx_tipodocfact.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctofact.getText());
                        pps.setString(5, txt_clientefact.getText());
                        pps.setString(6, txt_direccionfact.getText());
                        pps.setString(7, txt_rutfact.getText());
                        pps.setString(8, ((JTextField)jdt_fechafact.getDateEditor().getUiComponent()).getText());
                        pps.setString(9, txt_ciudadfact.getText());
                        pps.setString(10, txt_provinciafact.getText());
                        pps.setString(11, txt_girofact.getText());
                        pps.setString(12, txt_fonofact.getText());
                        pps.setString(13, jcbx_despachofact.getSelectedItem().toString());
                        pps.setString(14, txt_descripcionfact.getText());
                        pps.setString(15, txt_cantidadfact.getText());
                        pps.setString(16, txt_netofact.getText());
                        pps.setString(17, jcbx_formapfact.getSelectedItem().toString());
                        pps.setString(18, txt_cuentafact.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_factActionPerformed

    private void btn_transacc_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transacc_factActionPerformed
        // TODO add your handling code here:
    try {
        int codigo_prodf;
        codigo_prodf = 0;
        int codigo_prodp;
        codigo_prodp = 0;
        
        PreparedStatement ps = (PreparedStatement) cn.prepareStatement("SELECT fact.codigo_prod FROM detallef fact");
        PreparedStatement pss = (PreparedStatement) cn.prepareStatement("SELECT prod.codigo_prod FROM productos prod"); 
        ResultSet rs = ps.executeQuery();
        ResultSet rs1 = pss.executeQuery();
        while (rs.next()) {
        codigo_prodf = rs.getInt("codigo_prod");
        }
        while (rs1.next()) {
        codigo_prodp = rs1.getInt("codigo_prod");
        }
        ps.close();
        pss.close();
        rs.close();
        rs1.close();
        if (codigo_prodp >= 0 || codigo_prodp == codigo_prodf) {
                try {
                    String sql = "UPDATE productos SET cantidad=cantidad-?"+"Where codigo_prod=?";
                    int fila = jtbl_factura.getSelectedRow();
                    String dao = (String)jtbl_factura.getValueAt(fila, 1);
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement(sql);
                    pps.setString(1, txt_cantidadfact.getText());
                    pps.setString(2, dao);
                    int n = pps.executeUpdate();
                    if (n>0) {
                        jlbl_actividad.setText("Datos en Stock Modificados");
                    }
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
                }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    finally{}; 
    }//GEN-LAST:event_btn_transacc_factActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar_bol;
    private javax.swing.JButton btn_actualizar_fact;
    private javax.swing.JButton btn_actualizar_ov;
    private javax.swing.JButton btn_eliminar_bol;
    private javax.swing.JButton btn_eliminar_fact;
    private javax.swing.JButton btn_eliminar_ov;
    private javax.swing.JButton btn_guardar_bol;
    private javax.swing.JButton btn_guardar_fact;
    private javax.swing.JButton btn_guardar_ov;
    private javax.swing.JButton btn_mod_bol;
    private javax.swing.JButton btn_modificar_fact;
    private javax.swing.JButton btn_modificar_ov;
    private javax.swing.JButton btn_nuevo_bol;
    private javax.swing.JButton btn_nuevo_fact;
    private javax.swing.JButton btn_nuevo_ov;
    private javax.swing.JButton btn_trans_bol;
    private javax.swing.JButton btn_transacc_fact;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbx_despachofact;
    private javax.swing.JComboBox<String> jcbx_formapbol;
    private javax.swing.JComboBox<String> jcbx_formapfact;
    private javax.swing.JComboBox<String> jcbx_tipodocbol;
    private javax.swing.JComboBox<String> jcbx_tipodocfact;
    private com.toedter.calendar.JDateChooser jdt_fechabol;
    private com.toedter.calendar.JDateChooser jdt_fechafact;
    private com.toedter.calendar.JDateChooser jdt_fechaov;
    private javax.swing.JLabel jlbl_actividad;
    private javax.swing.JLabel jlbl_ivaov;
    private javax.swing.JLabel jlbl_totalov;
    private javax.swing.JTable jtbl_boletas;
    private javax.swing.JTable jtbl_factura;
    private javax.swing.JTable jtbl_oc_bol;
    private javax.swing.JTable jtbl_oc_fact;
    private javax.swing.JTable jtbl_ordenventa;
    private javax.swing.JTable jtbl_prod_bol;
    private javax.swing.JTable jtbl_producto_fact;
    private javax.swing.JTable jtbl_productos;
    private javax.swing.JToolBar jtbr_actividad;
    private javax.swing.JTextField txt_cantidadbol;
    private javax.swing.JTextField txt_cantidadfact;
    private javax.swing.JTextField txt_ciudadfact;
    private javax.swing.JTextField txt_clientefact;
    private javax.swing.JTextField txt_codprodbol;
    private javax.swing.JTextField txt_codprodf;
    private javax.swing.JTextField txt_codprodov;
    private javax.swing.JTextField txt_cuentabol;
    private javax.swing.JTextField txt_cuentafact;
    private javax.swing.JTextField txt_descripcionbol;
    private javax.swing.JTextField txt_descripcionfact;
    private javax.swing.JTextField txt_descripcionov;
    private javax.swing.JTextField txt_direccionfact;
    private javax.swing.JTextField txt_doctobol;
    private javax.swing.JTextField txt_doctofact;
    private javax.swing.JTextField txt_fonofact;
    private javax.swing.JTextField txt_girofact;
    private javax.swing.JTextField txt_ingresobol;
    private javax.swing.JTextField txt_ingresof;
    private javax.swing.JTextField txt_ndoctofact;
    private javax.swing.JTextField txt_netobol;
    private javax.swing.JTextField txt_netofact;
    private javax.swing.JTextField txt_numdocbol;
    private javax.swing.JTextField txt_ov;
    private javax.swing.JTextField txt_precioov;
    private javax.swing.JTextField txt_provinciafact;
    private javax.swing.JTextField txt_rutfact;
    private javax.swing.JTextField txt_transbol;
    private javax.swing.JTextField txt_transfact;
    // End of variables declaration//GEN-END:variables
}