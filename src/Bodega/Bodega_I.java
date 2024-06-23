/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bodega;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import static org.codehaus.groovy.ast.tools.GeneralUtils.stmt;

/**
 *
 * @author Jose
 */
public class Bodega_I extends javax.swing.JInternalFrame {
    DefaultTableModel model;    
    Conexion.conexion conexion = new Conexion.conexion();
    Connection cn = conexion.connect();
    Statement sent;
    /**
     * Creates new form Bodega_I
     */
    public Bodega_I() {
        initComponents();
        limpiar_adquisiciones();
        limpiar_mercancia();
        limpiar_oc();
        limpiar_perdidas();
        deshabiitar_oc();
        deshabilitar_adquisiciones();
        deshabilitar_mercancia();
        deshabilitar_perdidas();
    }
    
    void llenar_oc() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Codigo OC","URL","Descripción","Comentario","Fecha","Gasto","Proveedor", "Documento","Precio"};
            String sql = "SELECT codigo_oc, URL, descripcion, comentario, fecha_req, gasto, proveedor, docto_rec, precio FROM orden_compra";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [9];
            while (rs.next()){
                fila[0]=rs.getString("codigo_oc");
                fila[1]=rs.getString("URL");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("comentario");
                fila[4]=rs.getString("fecha_req");
                fila[5]=rs.getString("gasto");
                fila[6]=rs.getString("proveedor");
                fila[7]=rs.getString("docto_rec");
                fila[8]=rs.getString("precio");
            model.addRow(fila);
            }
            jtbl_ordencompra.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_adquisiciones() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Codigo AD","Codigo OC","Tipo Docto","N° Docto","Categoria","Seccion","Estado", "Descripcion","Forma Pago", "Fecha", "Precio", "Vida Util","N° Docto","N° Cuenta","N° Trans"};
            String sql = "SELECT codigo_ad, codigo_oc, tipo_doc, num_doc, categoria, seccion, estado, descripcion, forma_pago, fecha, valor_total, vida_util, num_cheque, num_cuenta, num_trans FROM adquisiciones";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [15];
            while (rs.next()){
                fila[0]=rs.getString("codigo_ad");
                fila[1]=rs.getString("codigo_oc");
                fila[2]=rs.getString("tipo_doc");
                fila[3]=rs.getString("num_doc");
                fila[4]=rs.getString("categoria");
                fila[5]=rs.getString("seccion");
                fila[6]=rs.getString("estado");
                fila[7]=rs.getString("descripcion");
                fila[8]=rs.getString("forma_pago");
                fila[9]=rs.getString("fecha");
                fila[10]=rs.getString("valor_total");
                fila[11]=rs.getString("vida_util");
                fila[12]=rs.getString("num_cheque");
                fila[13]=rs.getString("num_cuenta");
                fila[14]=rs.getString("num_trans");
            model.addRow(fila);
            }
            jtbl_adquiciones.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_adqui_oc() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Codigo OC","URL","Descripción","Comentario","Fecha","Gasto","Proveedor", "Documento","Precio"};
            String sql = "SELECT codigo_oc, URL, descripcion, comentario, fecha_req, gasto, proveedor, docto_rec, precio FROM orden_compra";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [9];
            while (rs.next()){
                fila[0]=rs.getString("codigo_oc");
                fila[1]=rs.getString("URL");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("comentario");
                fila[4]=rs.getString("fecha_req");
                fila[5]=rs.getString("gasto");
                fila[6]=rs.getString("proveedor");
                fila[7]=rs.getString("docto_rec");
                fila[8]=rs.getString("precio");
            model.addRow(fila);
            }
            jtbl_oc_ref.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_mercancia() {
        try {
            cn = conexion.connect();
            String [] titulos = {"C° Prod","C° OC","Fecha","T° Docto","N° Docto","Lote","Descripcion", "Cantidad","Precio", "Forma Pago","N° Cheque","N° Cuenta","N° Trans"};
            String sql = "SELECT codigo_prod, codigo_oc, fecha, tipo_doc, num_doc, lote, descripcion, cantidad, valor_total, forma_pago, num_cheque, num_cuenta, num_trans FROM mercancia";
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
            jtbl_mercaderia.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_mercanoc() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Codigo OC","Descripción","Comentario","Documento","Precio"};
            String sql = "SELECT codigo_oc, descripcion, comentario, docto_rec, precio FROM orden_compra";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [5];
            while (rs.next()){
                fila[0]=rs.getString("codigo_oc");
                fila[1]=rs.getString("descripcion");
                fila[2]=rs.getString("comentario");
                fila[3]=rs.getString("docto_rec");
                fila[4]=rs.getString("precio");
            model.addRow(fila);
            }
            jtbl_oc_mer.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_productos() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Codigo","Codigo Prod","Descripcion","Lote","Cantidad","Fecha","Valor Compra","Valor Venta"};
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
   
    void llenar_perdidas() {
        try {
            cn = conexion.connect();
            String [] titulos = {"Codigo","Codigo Prod","Producto","Fecha","Cantidad","Motivo", "Monto"};
            String sql = "SELECT codigo, codigo_prod, producto, fecha, cantidad, motivo, monto FROM perdidas";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [7];
            while (rs.next()){
                fila[0]=rs.getString("codigo");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("producto");
                fila[3]=rs.getString("fecha");
                fila[4]=rs.getString("cantidad");
                fila[5]=rs.getString("motivo");
                fila[6]=rs.getString("monto");
            model.addRow(fila);
            }
            jtbl_perdidas.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_mer_per() {
        try {
            cn = conexion.connect();
            String [] titulos = {"#","Codigo Prod","Descripcion","Lote","Cantidad","Fecha","Valor Compra","Valor Venta"};
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
            jtbl_mer_perd.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    void limpiar_oc() {
        txt_codigo_oc.setText("");
        txt_comentario.setText("");
        jdt_fecha.setCalendar(null);
        txt_descripcion.setText("");
        txt_precio.setText("");
        txt_proveedor.setText("");
        txt_url.setText("");
        jlbl_ivaoc.setText("");
        jlbl_totaloc.setText("");
    }
    
    void limpiar_adquisiciones() {
        txt_codigoocad.setText("");
        txt_codigoad.setText("");
        txt_ndoctoad.setText("");
        txt_seccionad.setText("");
        txta_descripcionad.setText("");
        txt_numdoctoad.setText("");
        txt_numcuentaad.setText("");
        txt_transaccionad.setText("");
        jdt_fechaad.setCalendar(null);
        txt_totalad.setText("");
        jlbl_ivaad.setText("");
        jlbl_netoad.setText("");
    }
    
    void limpiar_mercancia() {
        txt_codocmer.setText("");
        txt_codprodmer.setText("");
        txt_numdocmer.setText("");
        jdt_mercaderia.setDate(null);
        txta_descripcionmer.setText("");
        txt_cantidadmer.setText("");
        txt_doctbancmer.setText("");
        txt_cuentabancmer.setText("");
        txt_transmer.setText("");
        txt_totalmer.setText("");
        jlbl_ivamer.setText("");
        jlbl_netomer.setText("");
    }
    
    void limpiar_perdidas() {
        txt_codigop.setText("");
        txt_codprodp.setText("");
        txt_productosp.setText("");
        txt_cantidadp.setText("");
        jdt_fechap.setCalendar(null);
        txt_montop.setText("");
    }
    
    void habilitar_oc() {
        txt_codigo_oc.setEnabled(true);
        txt_comentario.setEnabled(true);
        jdt_fecha.setEnabled(true);
        txt_descripcion.setEnabled(true);
        jcbx_gastos.setEnabled(true);
        txt_precio.setEnabled(true);
        txt_proveedor.setEnabled(true);
        txt_url.setEnabled(true);
        jcbx_docto.setEnabled(true);
        btn_guardar_oc.setEnabled(true);
        btn_modificar_oc.setEnabled(false);
        btn_eliminar_oc.setEnabled(false);
        btn_actualizar_oc.setEnabled(true);
    }
    
    void habilitar_adquisiciones(){
        txt_ndoctoad.setEnabled(true);
        txt_seccionad.setEnabled(true);
        txta_descripcionad.setEnabled(true);
        jdt_fechaad.setEnabled(true);
        txt_totalad.setEnabled(true);
        jcbx_doctoad.setEnabled(true);
        jcbx_categoriaad.setEnabled(true);
        jcbx_estadoad.setEnabled(true);
        jcbx_fpagoad.setEnabled(true);
        jcbx_utilad.setEnabled(true);
        btn_guardar_ad.setEnabled(true);
        btn_modificar_ad.setEnabled(false);
        btn_eliminar_ad.setEnabled(false);
        btn_actualizar_ad.setEnabled(true);
        btn_trasladar_ad.setEnabled(true);
    }
    
    void habilitar_mercancia() {
        txt_codprodmer.setEnabled(true);
        txt_numdocmer.setEnabled(true);
        jdt_mercaderia.setEnabled(true);
        txta_descripcionmer.setEnabled(true);
        txt_cantidadmer.setEnabled(true);
        txt_totalmer.setEnabled(true);
        jcbx_tipodocmer.setEnabled(true);
        jcbx_lote.setEnabled(true);
        jcbx_formapagomer.setEnabled(true);
        btn_guardar_mer.setEnabled(true);
        btn_modificar_mer.setEnabled(false);
        btn_eliminar_mer.setEnabled(false);
        btn_actualizar_mer.setEnabled(true);
    }
    
    void habilitar_perdidas() {
        txt_codprodp.setEnabled(true);
        txt_productosp.setEnabled(true);
        jdt_fechap.setEnabled(true);
        txt_montop.setEnabled(true);
        jcbx_motivop.setEnabled(true);
        btn_guardar_oc1.setEnabled(true);
        btn_modificar_oc1.setEnabled(false);
        btn_eliminar_oc1.setEnabled(false);
        btn_actualizar_oc1.setEnabled(true);
    }
    
    void deshabiitar_oc() {
        txt_codigo_oc.setEnabled(false);
        txt_comentario.setEnabled(false);
        jdt_fecha.setEnabled(false);
        txt_descripcion.setEnabled(false);
        jcbx_gastos.setEnabled(false);
        txt_precio.setEnabled(false);
        txt_proveedor.setEnabled(false);
        txt_url.setEnabled(false);
        jcbx_docto.setEnabled(false);
        btn_guardar_oc.setEnabled(false);
        btn_modificar_oc.setEnabled(false);
        btn_eliminar_oc.setEnabled(false);
        btn_actualizar_oc.setEnabled(false);
    }
    
    void deshabilitar_adquisiciones() {
        txt_codigoocad.setEnabled(false);
        txt_codigoad.setEnabled(false);
        txt_ndoctoad.setEnabled(false);
        txt_seccionad.setEnabled(false);
        txta_descripcionad.setEnabled(false);
        txt_numdoctoad.setEnabled(false);
        txt_numcuentaad.setEnabled(false);
        txt_transaccionad.setEnabled(false);
        jdt_fechaad.setEnabled(false);
        txt_totalad.setEnabled(false);
        jcbx_doctoad.setEnabled(false);
        jcbx_categoriaad.setEnabled(false);
        jcbx_estadoad.setEnabled(false);
        jcbx_fpagoad.setEnabled(false);
        jcbx_utilad.setEnabled(false);
        btn_guardar_ad.setEnabled(false);
        btn_modificar_ad.setEnabled(false);
        btn_eliminar_ad.setEnabled(false);
        btn_actualizar_ad.setEnabled(false);
        btn_trasladar_ad.setEnabled(false);
    }
    
    void deshabilitar_mercancia() {
        txt_codocmer.setEnabled(false);
        txt_codprodmer.setEnabled(false);
        txt_numdocmer.setEnabled(false);
        jdt_mercaderia.setEnabled(false);
        txta_descripcionmer.setEnabled(false);
        txt_cantidadmer.setEnabled(false);
        txt_doctbancmer.setEnabled(false);
        txt_cuentabancmer.setEnabled(false);
        txt_transmer.setEnabled(false);
        txt_totalmer.setEnabled(false);
        jcbx_tipodocmer.setEnabled(false);
        jcbx_lote.setEnabled(false);
        jcbx_formapagomer.setEnabled(false);
        btn_guardar_mer.setEnabled(false);
        btn_modificar_mer.setEnabled(false);
        btn_eliminar_mer.setEnabled(false);
        btn_actualizar_mer.setEnabled(false);
        jcbx_venta.setEnabled(false);
        btn_transaccion.setEnabled(false);
        btn_libro_compra.setEnabled(false);
    }
    
    void deshabilitar_perdidas() {
        txt_codigop.setEnabled(false);
        txt_codprodp.setEnabled(false);
        txt_productosp.setEnabled(false);
        jdt_fechap.setEnabled(false);
        txt_montop.setEnabled(false);
        jcbx_motivop.setEnabled(false);
        btn_guardar_oc1.setEnabled(false);
        btn_modificar_oc1.setEnabled(false);
        btn_eliminar_oc1.setEnabled(false);
        btn_actualizar_oc1.setEnabled(false);
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
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_comentario = new javax.swing.JTextField();
        jdt_fecha = new com.toedter.calendar.JDateChooser();
        txt_url = new javax.swing.JTextField();
        txt_codigo_oc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_proveedor = new javax.swing.JTextField();
        jcbx_docto = new javax.swing.JComboBox<>();
        txt_precio = new javax.swing.JTextField();
        jcbx_gastos = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        btn_nuevo_oc = new javax.swing.JButton();
        btn_guardar_oc = new javax.swing.JButton();
        btn_modificar_oc = new javax.swing.JButton();
        btn_eliminar_oc = new javax.swing.JButton();
        btn_actualizar_oc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_ordencompra = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jlbl_ivaoc = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jlbl_totaloc = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_codigoocad = new javax.swing.JTextField();
        txt_codigoad = new javax.swing.JTextField();
        txt_ndoctoad = new javax.swing.JTextField();
        txt_seccionad = new javax.swing.JTextField();
        jcbx_doctoad = new javax.swing.JComboBox<>();
        jcbx_estadoad = new javax.swing.JComboBox<>();
        jcbx_categoriaad = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jcbx_fpagoad = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txta_descripcionad = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_numdoctoad = new javax.swing.JTextField();
        txt_numcuentaad = new javax.swing.JTextField();
        txt_transaccionad = new javax.swing.JTextField();
        jdt_fechaad = new com.toedter.calendar.JDateChooser();
        jcbx_utilad = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        txt_totalad = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jlbl_ivaad = new javax.swing.JLabel();
        jlbl_netoad = new javax.swing.JLabel();
        btn_nuevo_ad = new javax.swing.JButton();
        btn_guardar_ad = new javax.swing.JButton();
        btn_modificar_ad = new javax.swing.JButton();
        btn_eliminar_ad = new javax.swing.JButton();
        btn_actualizar_ad = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbl_oc_ref = new javax.swing.JTable();
        btn_trasladar_ad = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbl_adquiciones = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_codprodmer = new javax.swing.JTextField();
        txt_codocmer = new javax.swing.JTextField();
        jcbx_tipodocmer = new javax.swing.JComboBox<>();
        txt_numdocmer = new javax.swing.JTextField();
        jdt_mercaderia = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        jcbx_lote = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txta_descripcionmer = new javax.swing.JTextArea();
        jLabel39 = new javax.swing.JLabel();
        txt_cantidadmer = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jcbx_formapagomer = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_transmer = new javax.swing.JTextField();
        txt_totalmer = new javax.swing.JTextField();
        txt_doctbancmer = new javax.swing.JTextField();
        txt_cuentabancmer = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jlbl_ivamer = new javax.swing.JLabel();
        jlbl_netomer = new javax.swing.JLabel();
        btn_nuevo_mer = new javax.swing.JButton();
        btn_guardar_mer = new javax.swing.JButton();
        btn_modificar_mer = new javax.swing.JButton();
        btn_eliminar_mer = new javax.swing.JButton();
        btn_actualizar_mer = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtbl_oc_mer = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtbl_mercaderia = new javax.swing.JTable();
        btn_transaccion = new javax.swing.JButton();
        jcbx_venta = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jtbl_productos = new javax.swing.JTable();
        btn_libro_compra = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txt_codprodp = new javax.swing.JTextField();
        txt_codigop = new javax.swing.JTextField();
        txt_productosp = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txt_montop = new javax.swing.JTextField();
        jdt_fechap = new com.toedter.calendar.JDateChooser();
        jcbx_motivop = new javax.swing.JComboBox<>();
        txt_cantidadp = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        btn_nuevo_oc1 = new javax.swing.JButton();
        btn_guardar_oc1 = new javax.swing.JButton();
        btn_modificar_oc1 = new javax.swing.JButton();
        btn_eliminar_oc1 = new javax.swing.JButton();
        btn_actualizar_oc1 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtbl_mer_perd = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtbl_perdidas = new javax.swing.JTable();
        btn_trans_prod = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        jlbl_actividad = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.activeCaption);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingreso de Bodega");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(java.awt.SystemColor.activeCaption);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/bodegas.png"))); // NOI18N
        jLabel1.setText("Ingreso de Bodega");

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        jPanel7.setBackground(java.awt.SystemColor.activeCaption);
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel3.setText("Codigo OC:");

        jLabel4.setText("URL:");

        jLabel5.setText("Descripcion:");

        jLabel6.setText("Comentario:");

        jLabel7.setText("Fecha Req:");

        jLabel8.setText("Gastos:");

        jdt_fecha.setDateFormatString("yyyy-MM-dd");

        jLabel9.setText("Proveedor:");

        jLabel10.setText("Documento:");

        jLabel11.setText("Neto:");

        jcbx_docto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura" }));

        jcbx_gastos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Directo", "Bodega" }));

        txt_descripcion.setColumns(20);
        txt_descripcion.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        txt_descripcion.setLineWrap(true);
        txt_descripcion.setRows(5);
        txt_descripcion.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txt_descripcion);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_codigo_oc, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_url)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_precio)
                                    .addComponent(jcbx_docto, 0, 105, Short.MAX_VALUE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_proveedor)
                                    .addComponent(jcbx_gastos, 0, 105, Short.MAX_VALUE)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_comentario)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jdt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_codigo_oc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jcbx_gastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jcbx_docto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_comentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jdt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_nuevo_oc.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_oc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_oc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_ocActionPerformed(evt);
            }
        });

        btn_guardar_oc.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_oc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_oc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_ocActionPerformed(evt);
            }
        });

        btn_modificar_oc.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_oc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_oc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_ocActionPerformed(evt);
            }
        });

        btn_eliminar_oc.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_oc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_oc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_ocActionPerformed(evt);
            }
        });

        btn_actualizar_oc.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_oc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_oc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_ocActionPerformed(evt);
            }
        });

        jtbl_ordencompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo OC", "URL", "Descripción", "Comentario", "Fecha", "Gasto", "Proveedor", "Documento", "Precio"
            }
        ));
        jtbl_ordencompra.setToolTipText("Tabla Orden Compras [Almacenado]");
        jtbl_ordencompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_ordencompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_ordencompra);

        jLabel30.setText("IVA:");

        jlbl_ivaoc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_ivaoc.setForeground(new java.awt.Color(255, 0, 0));

        jLabel32.setText("Total:");

        jlbl_totaloc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_totaloc.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_nuevo_oc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_oc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_oc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_oc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_oc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlbl_ivaoc))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)
                                .addComponent(jlbl_totaloc)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jlbl_ivaoc))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jlbl_totaloc)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_nuevo_oc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar_oc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificar_oc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_eliminar_oc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_actualizar_oc))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Orden de Compras", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jPanel8.setBackground(java.awt.SystemColor.activeCaption);
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel12.setText("Codigo OC:");

        jLabel13.setText("Codigo AD:");

        jLabel14.setText("Tipo Docto:");

        jLabel15.setText("N° Docto:");

        jLabel16.setText("Categoria:");

        jLabel17.setText("Seccion:");

        jLabel18.setText("Estado:");

        jcbx_doctoad.setBackground(java.awt.SystemColor.activeCaption);
        jcbx_doctoad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Documento" }));

        jcbx_estadoad.setBackground(java.awt.SystemColor.activeCaption);
        jcbx_estadoad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Atribuye", "Nuevo", "Bueno", "Regular", "Malo" }));

        jcbx_categoriaad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terrenos", "Construcciones", "Herramientas", "Muebles", "Electricos", "Materia Prima" }));

        jLabel19.setText("Descripcion:");

        jLabel20.setText("Formas Pago:");

        jcbx_fpagoad.setBackground(java.awt.SystemColor.activeCaption);
        jcbx_fpagoad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Cheque", "Transferencia", "Tarjeta Credito", "Cuenta Corriente" }));
        jcbx_fpagoad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbx_fpagoadItemStateChanged(evt);
            }
        });

        jLabel21.setText("N° Docto:");

        jLabel22.setText("N° Cuenta:");

        txta_descripcionad.setColumns(20);
        txta_descripcionad.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        txta_descripcionad.setLineWrap(true);
        txta_descripcionad.setRows(5);
        txta_descripcionad.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txta_descripcionad);

        jLabel23.setText("N° Transacción:");

        jLabel24.setText("Fecha:");

        jLabel25.setText("Vida Util:");

        jLabel26.setText("Total:");

        jdt_fechaad.setDateFormatString("yyyy-MM-dd");

        jcbx_utilad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));

        jLabel27.setText("Años.");

        jLabel28.setText("IVA:");

        jLabel29.setText("Neto:");

        jlbl_ivaad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_ivaad.setForeground(new java.awt.Color(255, 0, 0));

        jlbl_netoad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_netoad.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txt_codigoocad, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_codigoad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_seccionad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbx_categoriaad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbx_doctoad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ndoctoad, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(30, 30, 30)
                                .addComponent(txt_numcuentaad))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jcbx_fpagoad, 0, 122, Short.MAX_VALUE)
                                    .addComponent(jcbx_estadoad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_numdoctoad))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_totalad)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_transaccionad)
                            .addComponent(jdt_fechaad, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jcbx_utilad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jlbl_ivaad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbl_netoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_codigoocad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jcbx_estadoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txt_transaccionad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_codigoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jcbx_doctoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jdt_fechaad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jcbx_utilad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_ndoctoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jcbx_fpagoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jcbx_categoriaad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txt_numdoctoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(jlbl_ivaad))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_seccionad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(txt_numcuentaad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(jlbl_netoad)))
                    .addComponent(txt_totalad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jtbl_oc_ref.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo OC", "URL", "Descripción", "Comentario", "Fecha", "Gasto", "Proveedor", "Documento", "Precio"
            }
        ));
        jtbl_oc_ref.setToolTipText("Tablas Orden de Compras para Llenado de Campos");
        jtbl_oc_ref.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_oc_refMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtbl_oc_ref);

        btn_trasladar_ad.setBackground(java.awt.SystemColor.activeCaption);
        btn_trasladar_ad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/traspaso1.png"))); // NOI18N
        btn_trasladar_ad.setToolTipText("Trasladar de \"Adquisiciones\" a \"Mercaderia\"");
        btn_trasladar_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trasladar_adActionPerformed(evt);
            }
        });

        jtbl_adquiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo AD", "Codigo OC", "Tipo Docto", "N° Docto", "Categoria", "Seccion", "Estado", "Descripción", "Forma Pago", "Fecha", "Precio", "Vida Util", "N° Docto", "N° Cuenta", "N° Trans"
            }
        ));
        jtbl_adquiciones.setToolTipText("Tabla Adquisiciones [Almacenado]");
        jtbl_adquiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_adquicionesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtbl_adquiciones);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btn_nuevo_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_guardar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_actualizar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_trasladar_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_nuevo_ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar_ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_modificar_ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_eliminar_ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_actualizar_ad))
                    .addComponent(btn_trasladar_ad))
                .addGap(87, 87, 87))
        );

        jTabbedPane1.addTab("Adquisiciones", jPanel4);

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);

        jPanel9.setBackground(java.awt.SystemColor.activeCaption);
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel31.setText("Codigo OC:");

        jLabel33.setText("Codigo Prod:");

        jLabel34.setText("Tipo Docto:");

        jLabel35.setText("N° Docto:");

        jLabel36.setText("Fecha:");

        jcbx_tipodocmer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Documento" }));

        jdt_mercaderia.setDateFormatString("yyyy-MM-dd");

        jLabel37.setText("Lote:");

        jcbx_lote.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Atribuye", "Bodega", "Lote 1", "Lote 2", "Lote 3", "Lote 4", "Lote 5", "Lote 6", "Lote 7", "Lote 8", "Lote 9", "Lote 10", "Lote 11", "Lote 12", "Lote 13", "Lote 14", "Lote 15", "Lote 16", "Lote 17", "Lote 18", "Lote 19", "Lote 20", "Lote 21", "Lote 22", "Lote 23", "Lote 25", "Lote 26", "Lote 27", "Lote 28", "Lote 29", "Lote 30", "Lote 31", "Lote 32", "Lote 33", "Lote 34", "Lote 35", "Lote 36", "Lote 37", "Lote 38", "Lote 39", "Lote 40", "Lote 41", "Lote 42", "Lote 43", "Lote 44", "Lote 45", "Lote 46", "Lote 47", "Lote 48", "Lote 49", "Lote 50", "Lote 51", "Lote 52", "Lote 53", "Lote 54", "Lote 55", "Lote 56", "Lote 57", "Lote 58", "Lote 59", "Lote 60", "Lote 61", "Lote 62", "Lote 63", "Lote 64", "Lote 65", "Lote 66", "Lote 67", "Lote 68", "Lote 69", "Lote 70", "Lote 71", "Lote 72", "Lote 73", "Lote 74", "Lote 75", "Lote 76", "Lote 77", "Lote 78" }));

        jLabel38.setText("Descripción:");

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txta_descripcionmer.setColumns(20);
        txta_descripcionmer.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        txta_descripcionmer.setRows(5);
        jScrollPane6.setViewportView(txta_descripcionmer);

        jLabel39.setText("Cantidad:");

        jLabel40.setText("Forma Pago:");

        jcbx_formapagomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Cheque", "Transferencia", "Tarjeta Credito", "Cuenta Corriente" }));
        jcbx_formapagomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbx_formapagomerItemStateChanged(evt);
            }
        });

        jLabel41.setText("N° Docto:");

        jLabel42.setText("N° Cuenta:");

        jLabel43.setText("N° Trasnsacción:");

        jLabel44.setText("Total:");

        jLabel45.setText("IVA:");

        jLabel46.setText("Neto:");

        jlbl_ivamer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_ivamer.setForeground(new java.awt.Color(255, 0, 0));

        jlbl_netomer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_netomer.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codprodmer)
                    .addComponent(txt_codocmer)
                    .addComponent(jcbx_tipodocmer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_numdocmer)
                    .addComponent(jcbx_lote, 0, 94, Short.MAX_VALUE)
                    .addComponent(jdt_mercaderia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 5, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cuentabancmer, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(txt_doctbancmer)))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel40)
                            .addGap(18, 18, 18)
                            .addComponent(jcbx_formapagomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel38)
                                .addComponent(jLabel39))
                            .addGap(21, 21, 21)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(txt_cantidadmer, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(txt_transmer, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbl_ivamer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbl_netomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(txt_totalmer)))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(txt_codocmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(txt_codprodmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel43)
                                    .addComponent(txt_transmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44)
                                    .addComponent(txt_totalmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jcbx_tipodocmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39)
                        .addComponent(txt_cantidadmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45))
                    .addComponent(jlbl_ivamer, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txt_numdocmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jcbx_formapagomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jlbl_netomer, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jdt_mercaderia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_doctbancmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbx_lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42)
                        .addComponent(txt_cuentabancmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btn_nuevo_mer.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_mer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_mer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_merActionPerformed(evt);
            }
        });

        btn_guardar_mer.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_mer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_mer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_merActionPerformed(evt);
            }
        });

        btn_modificar_mer.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_mer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_mer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_merActionPerformed(evt);
            }
        });

        btn_eliminar_mer.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_mer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_mer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_merActionPerformed(evt);
            }
        });

        btn_actualizar_mer.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_mer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_mer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_merActionPerformed(evt);
            }
        });

        jtbl_oc_mer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo OC", "Descripción", "Comentario", "Documento", "Precio"
            }
        ));
        jtbl_oc_mer.setToolTipText("Tablas Orden de Compras para Llenado de Campos");
        jtbl_oc_mer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_oc_merMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtbl_oc_mer);

        jtbl_mercaderia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "C° Prod", "C° OC", "Fecha", "T° Docto", "N° Docto", "Lote", "Descripción", "Cantidad", "Precio", "Forma Pago", "N° Cheque", "N° Cuenta", "N° Trans"
            }
        ));
        jtbl_mercaderia.setToolTipText("Tabla Mercancia [Almacenado]");
        jtbl_mercaderia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_mercaderiaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jtbl_mercaderia);

        btn_transaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/1.png"))); // NOI18N
        btn_transaccion.setToolTipText("Transaccion de Mercancia a Control Stock.");
        btn_transaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaccionActionPerformed(evt);
            }
        });

        jcbx_venta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100" }));

        jLabel55.setText("% Venta.");

        jtbl_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Codigo Prod", "Descripción", "Lote", "Cantidad", "Fecha", "Valor Compra", "Valor Venta"
            }
        ));
        jtbl_productos.setToolTipText("Tabla Productos [Almacenado]");
        jtbl_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_productosMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jtbl_productos);

        btn_libro_compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/2.png"))); // NOI18N
        btn_libro_compra.setToolTipText("Transaccion de Mercancia a Libro Compra");
        btn_libro_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_libro_compraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_nuevo_mer, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_mer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_mer, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_mer, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_mer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(jcbx_venta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_transaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_libro_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane11)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_nuevo_mer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar_mer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificar_mer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_eliminar_mer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_actualizar_mer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_transaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addGap(7, 7, 7)
                                .addComponent(jcbx_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_libro_compra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mercancia", jPanel5);

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);

        jPanel10.setBackground(java.awt.SystemColor.activeCaption);
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos"));

        jLabel47.setText("Codigo:");

        jLabel49.setText("Codigo Prod:");

        jLabel50.setText("Producto:");

        jLabel51.setText("Cantidad:");

        jLabel52.setText("Motivo:");

        jLabel53.setText("Monto:");

        jdt_fechap.setDateFormatString("yyyy-MM-dd");

        jcbx_motivop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Robo", "Daños", "Perdida" }));

        jLabel54.setText("Fecha:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(44, 44, 44)
                        .addComponent(jcbx_motivop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(43, 43, 43)
                        .addComponent(txt_codigop, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jLabel54))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdt_fechap, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_productosp)
                                .addComponent(txt_codprodp, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_cantidadp, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addGap(18, 18, 18)
                .addComponent(txt_montop, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(txt_montop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel47)
                        .addComponent(txt_codigop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txt_codprodp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txt_productosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txt_cantidadp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdt_fechap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jcbx_motivop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btn_nuevo_oc1.setBackground(java.awt.SystemColor.activeCaption);
        btn_nuevo_oc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/nuevo1.png"))); // NOI18N
        btn_nuevo_oc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_oc1ActionPerformed(evt);
            }
        });

        btn_guardar_oc1.setBackground(java.awt.SystemColor.activeCaption);
        btn_guardar_oc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/guardar2.png"))); // NOI18N
        btn_guardar_oc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_oc1ActionPerformed(evt);
            }
        });

        btn_modificar_oc1.setBackground(java.awt.SystemColor.activeCaption);
        btn_modificar_oc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/modificar1.png"))); // NOI18N
        btn_modificar_oc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_oc1ActionPerformed(evt);
            }
        });

        btn_eliminar_oc1.setBackground(java.awt.SystemColor.activeCaption);
        btn_eliminar_oc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/eliminar1.png"))); // NOI18N
        btn_eliminar_oc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_oc1ActionPerformed(evt);
            }
        });

        btn_actualizar_oc1.setBackground(java.awt.SystemColor.activeCaption);
        btn_actualizar_oc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/actualizar1.png"))); // NOI18N
        btn_actualizar_oc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_oc1ActionPerformed(evt);
            }
        });

        jtbl_mer_perd.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbl_mer_perd.setToolTipText("Tabla Productos para Llenado de Campos");
        jtbl_mer_perd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_mer_perdMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jtbl_mer_perd);

        jtbl_perdidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Codigo Prod", "Producto", "Fecha", "Cantidad", "Motivo", "Monto"
            }
        ));
        jtbl_perdidas.setToolTipText("Tabla Perdidas [Almacenado]");
        jtbl_perdidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_perdidasMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jtbl_perdidas);

        btn_trans_prod.setBackground(java.awt.SystemColor.activeCaption);
        btn_trans_prod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/1.png"))); // NOI18N
        btn_trans_prod.setToolTipText("Aplicar a Productos Stock");
        btn_trans_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trans_prodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_nuevo_oc1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_oc1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_oc1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_oc1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar_oc1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_trans_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                            .addComponent(jScrollPane10))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_nuevo_oc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar_oc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_modificar_oc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_eliminar_oc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_actualizar_oc1))
                    .addComponent(btn_trans_prod))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Perdidas", jPanel6);

        jToolBar1.setBackground(java.awt.SystemColor.activeCaption);
        jToolBar1.setRollover(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Actividad: ");
        jToolBar1.add(jLabel2);

        jlbl_actividad.setBackground(new java.awt.Color(255, 0, 0));
        jlbl_actividad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbl_actividad.setForeground(new java.awt.Color(255, 0, 0));
        jToolBar1.add(jlbl_actividad);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbl_ordencompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_ordencompraMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_ordencompra.getSelectedRow();
            try{
                btn_modificar_oc.setEnabled(true);
                btn_eliminar_oc.setEnabled(true);
                btn_guardar_oc.setEnabled(false);
                
                Double netooc = Double.parseDouble(jtbl_ordencompra.getValueAt(fila, 8).toString());
                Double factoroc = 0.19;
                Double rivaoc = (netooc * factoroc);
                Double rtotaloc = rivaoc + netooc;
                Integer iva1oc = (int) Math.round(rivaoc);
                Integer total1oc = (int) Math.round(rtotaloc);
                String ivaoc = Integer.toString(iva1oc);
                String totaloc = Integer.toString(total1oc);
                
                txt_codigo_oc.setText(jtbl_ordencompra.getValueAt(fila, 0).toString());
                txt_url.setText(jtbl_ordencompra.getValueAt(fila, 1).toString());
                txt_descripcion.setText(jtbl_ordencompra.getValueAt(fila, 2).toString());
                txt_comentario.setText(jtbl_ordencompra.getValueAt(fila, 3).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_ordencompra.getValueAt(fila,4).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_fecha.setDate(fecha);
                
                jcbx_gastos.setSelectedItem(jtbl_ordencompra.getValueAt(fila, 5).toString());
                txt_proveedor.setText(jtbl_ordencompra.getValueAt(fila, 6).toString());
                jcbx_docto.setSelectedItem(jtbl_ordencompra.getValueAt(fila, 7).toString());
                txt_precio.setText(jtbl_ordencompra.getValueAt(fila, 8).toString());
                jlbl_ivaoc.setText(ivaoc);
                jlbl_totaloc.setText(totaloc);

                jlbl_actividad.setText("Datos Traslados a Campos, modifique y aprete boton Modificar");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }//GEN-LAST:event_jtbl_ordencompraMouseClicked

    private void btn_actualizar_ocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_ocActionPerformed
        // TODO add your handling code here:
        llenar_oc();
        jlbl_actividad.setText("Datos de la tabla 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_ocActionPerformed

    private void btn_eliminar_ocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_ocActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_ordencompra.getSelectedRow();
            String sql = "DELETE FROM orden_compra WHERE codigo_oc='"+jtbl_ordencompra.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
                cn.close();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_ocActionPerformed

    private void btn_modificar_ocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_ocActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE orden_compra SET codigo_oc=?, URL=?, descripcion=?, comentario=?, fecha_req=?, gasto=?, proveedor=?, docto_rec=?, precio=?"+"Where codigo_oc=?";
            int fila = jtbl_ordencompra.getSelectedRow();
            String dao = (String)jtbl_ordencompra.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_codigo_oc.getText());
            ps.setString(2, txt_url.getText());
            ps.setString(3, txt_descripcion.getText());
            ps.setString(4, txt_comentario.getText());
            ps.setString(5, ((JTextField)jdt_fecha.getDateEditor().getUiComponent()).getText());
            ps.setString(6, jcbx_gastos.getSelectedItem().toString());
            ps.setString(7, txt_proveedor.getText());
            ps.setString(8, jcbx_docto.getSelectedItem().toString());
            ps.setString(9, txt_precio.getText());
            ps.setString(10, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }//GEN-LAST:event_btn_modificar_ocActionPerformed

    private void btn_guardar_ocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_ocActionPerformed
        // TODO add your handling code here:
        if (txt_codigo_oc.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compra");
        }
        else if (txt_url.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa una imagen URL del producto");
        }
        else if (txt_descripcion.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa la Descripción del Producto");
        }
        else if (txt_comentario.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Comentario del Producto");
        }
        else if (jdt_fecha.getDate() == null) {
            jlbl_actividad.setText("Ingresa la Fecha de Ingreso de la Orden");
        }
        else if (txt_proveedor.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Proveedor de la Orden de Compras");
        }
        else if (txt_precio.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Precio del Producto de la Orden de Compras");
        }
        else {
            if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                try {
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO orden_compra (codigo_oc, URL, descripcion, comentario, fecha_req, gasto, proveedor, docto_rec, precio) values (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    pps.setString(1, txt_codigo_oc.getText());
                    pps.setString(2, txt_url.getText());
                    pps.setString(3, txt_descripcion.getText());
                    pps.setString(4, txt_comentario.getText());
                    pps.setString(5, ((JTextField)jdt_fecha.getDateEditor().getUiComponent()).getText());
                    pps.setString(6, jcbx_gastos.getSelectedItem().toString());
                    pps.setString(7, txt_proveedor.getText());
                    pps.setString(8, jcbx_docto.getSelectedItem().toString());
                    pps.setString(9, txt_precio.getText());
                    pps.executeUpdate();
                    jlbl_actividad.setText("Datos Guardados");
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_ocActionPerformed

    private void btn_nuevo_ocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_ocActionPerformed
        // TODO add your handling code here:
        habilitar_oc();
        limpiar_oc();
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_ocActionPerformed

    private void btn_nuevo_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_adActionPerformed
        // TODO add your handling code here:
        limpiar_adquisiciones();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(date);
        txt_codigoad.setText("AD"+dateString);
        habilitar_adquisiciones();
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_adActionPerformed

    private void btn_guardar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_adActionPerformed
        // TODO add your handling code here:
        if (jcbx_fpagoad.getSelectedItem().equals("Efectivo")) {
            if (txt_codigoocad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compra");
            }
            else if (txt_codigoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Adquisición");
            }
            else if (txt_ndoctoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento");
            }
            else if (txt_seccionad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Sección");
            }
            else if (jdt_fechaad.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso de la Orden");
            }
            else if (txt_totalad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Monto en Total del Producto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO adquisiciones (codigo_ad, codigo_oc, tipo_doc, num_doc, categoria, seccion, estado, descripcion, forma_pago, fecha, valor_total, vida_util, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,?,?,0,0,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codigoad.getText());
                        pps.setString(2, txt_codigoocad.getText());
                        pps.setString(3, jcbx_doctoad.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctoad.getText());
                        pps.setString(5, jcbx_categoriaad.getSelectedItem().toString());
                        pps.setString(6, txt_seccionad.getText());
                        pps.setString(7, jcbx_estadoad.getSelectedItem().toString());
                        pps.setString(8, txta_descripcionad.getText());
                        pps.setString(9, jcbx_fpagoad.getSelectedItem().toString());
                        pps.setString(10, ((JTextField)jdt_fechaad.getDateEditor().getUiComponent()).getText());
                        pps.setString(11, txt_totalad.getText());
                        pps.setString(12, jcbx_utilad.getSelectedItem().toString());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        } else if (jcbx_fpagoad.getSelectedItem().equals("Cheque")) {
            if (txt_codigoocad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compra");
            }
            else if (txt_codigoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Adquisición");
            }
            else if (txt_ndoctoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento");
            }
            else if (txt_seccionad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Sección");
            }
            else if (txt_numdoctoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el numero de Documento Bancario");
            }
            else if (txt_numcuentaad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el numero de Cuenta Bancaria");
            }
            else if (jdt_fechaad.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso de la Orden");
            }
            else if (txt_totalad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Monto en Total del Producto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO adquisiciones (codigo_ad, codigo_oc, tipo_doc, num_doc, categoria, seccion, estado, descripcion, forma_pago, fecha, valor_total, vida_util, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codigoad.getText());
                        pps.setString(2, txt_codigoocad.getText());
                        pps.setString(3, jcbx_doctoad.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctoad.getText());
                        pps.setString(5, jcbx_categoriaad.getSelectedItem().toString());
                        pps.setString(6, txt_seccionad.getText());
                        pps.setString(7, jcbx_estadoad.getSelectedItem().toString());
                        pps.setString(8, txta_descripcionad.getText());
                        pps.setString(9, jcbx_fpagoad.getSelectedItem().toString());
                        pps.setString(10, ((JTextField)jdt_fechaad.getDateEditor().getUiComponent()).getText());
                        pps.setString(11, txt_totalad.getText());
                        pps.setString(12, jcbx_utilad.getSelectedItem().toString());
                        pps.setString(13, txt_numdoctoad.getText());
                        pps.setString(14, txt_numcuentaad.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        } else if (jcbx_fpagoad.getSelectedItem().equals("Transferencia")) {
            if (txt_codigoocad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compra");
            }
            else if (txt_codigoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Adquisición");
            }
            else if (txt_ndoctoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento");
            }
            else if (txt_seccionad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Sección");
            }
            else if (txt_numdoctoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el numero de Documento Bancario");
            }
            else if (txt_numcuentaad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el numero bancario");
            }
            else if (jdt_fechaad.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso de la Orden");
            }
            else if (txt_totalad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Monto en Total del Producto");
            }
            else if (txt_numcuentaad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Cuenta Bancaria");
            }
            else if (txt_transaccionad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el N° de Transaccion Bancaria");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO adquisiciones (codigo_ad, codigo_oc, tipo_doc, num_doc, categoria, seccion, estado, descripcion, forma_pago, fecha, valor_total, vida_util, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,?,?,0,?,?)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codigoad.getText());
                        pps.setString(2, txt_codigoocad.getText());
                        pps.setString(3, jcbx_doctoad.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctoad.getText());
                        pps.setString(5, jcbx_categoriaad.getSelectedItem().toString());
                        pps.setString(6, txt_seccionad.getText());
                        pps.setString(7, jcbx_estadoad.getSelectedItem().toString());
                        pps.setString(8, txta_descripcionad.getText());
                        pps.setString(9, jcbx_fpagoad.getSelectedItem().toString());
                        pps.setString(10, ((JTextField)jdt_fechaad.getDateEditor().getUiComponent()).getText());
                        pps.setString(11, txt_totalad.getText());
                        pps.setString(12, jcbx_utilad.getSelectedItem().toString());
                        pps.setString(13, txt_numcuentaad.getText());
                        pps.setString(14, txt_transaccionad.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        } else if (jcbx_fpagoad.getSelectedItem().equals("Tarjeta Credito")) {
            if (txt_codigoocad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compra");
            }
            else if (txt_codigoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Adquisición");
            }
            else if (txt_ndoctoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento");
            }
            else if (txt_seccionad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Sección");
            }
            else if (txt_numdoctoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el numero de Documento Bancario");
            }
            else if (txt_numcuentaad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el numero de Cuenta Bancaria");
            }
            else if (jdt_fechaad.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso de la Orden");
            }
            else if (txt_totalad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Monto en Total del Producto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO adquisiciones (codigo_ad, codigo_oc, tipo_doc, num_doc, categoria, seccion, estado, descripcion, forma_pago, fecha, valor_total, vida_util, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,?,?,0,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codigoad.getText());
                        pps.setString(2, txt_codigoocad.getText());
                        pps.setString(3, jcbx_doctoad.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctoad.getText());
                        pps.setString(5, jcbx_categoriaad.getSelectedItem().toString());
                        pps.setString(6, txt_seccionad.getText());
                        pps.setString(7, jcbx_estadoad.getSelectedItem().toString());
                        pps.setString(8, txta_descripcionad.getText());
                        pps.setString(9, jcbx_fpagoad.getSelectedItem().toString());
                        pps.setString(10, ((JTextField)jdt_fechaad.getDateEditor().getUiComponent()).getText());
                        pps.setString(11, txt_totalad.getText());
                        pps.setString(12, jcbx_utilad.getSelectedItem().toString());
                        pps.setString(13, txt_numcuentaad.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        } else if (jcbx_fpagoad.getSelectedItem().equals("Cuenta Corriente")) {
            if (txt_codigoocad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compra");
            }
            else if (txt_codigoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Adquisición");
            }
            else if (txt_ndoctoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento");
            }
            else if (txt_seccionad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Sección");
            }
            else if (txt_numdoctoad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el numero de Documento Bancario");
            }
            else if (txt_numcuentaad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el numero de Cuenta Bancaria");
            }
            else if (jdt_fechaad.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso de la Orden");
            }
            else if (txt_totalad.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Monto en Total del Producto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO adquisiciones (codigo_ad, codigo_oc, tipo_doc, num_doc, categoria, seccion, estado, descripcion, forma_pago, fecha, valor_total, vida_util, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,?,?,0,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codigoad.getText());
                        pps.setString(2, txt_codigoocad.getText());
                        pps.setString(3, jcbx_doctoad.getSelectedItem().toString());
                        pps.setString(4, txt_ndoctoad.getText());
                        pps.setString(5, jcbx_categoriaad.getSelectedItem().toString());
                        pps.setString(6, txt_seccionad.getText());
                        pps.setString(7, jcbx_estadoad.getSelectedItem().toString());
                        pps.setString(8, txta_descripcionad.getText());
                        pps.setString(9, jcbx_fpagoad.getSelectedItem().toString());
                        pps.setString(10, ((JTextField)jdt_fechaad.getDateEditor().getUiComponent()).getText());
                        pps.setString(11, txt_totalad.getText());
                        pps.setString(12, jcbx_utilad.getSelectedItem().toString());
                        pps.setString(13, txt_numcuentaad.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_adActionPerformed

    private void btn_modificar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_adActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE adquisiciones SET codigo_ad=?, codigo_oc=?, tipo_doc=?, num_doc=?, categoria=?, seccion=?, estado=?, descripcion=?, forma_pago=?, fecha=?, valor_total=?, vida_util=?, num_cheque=?, num_cuenta=?, num_trans=?"+"Where codigo_ad=?";
            int fila = jtbl_adquiciones.getSelectedRow();
            String dao = (String)jtbl_adquiciones.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_codigoad.getText());
            ps.setString(2, txt_codigoocad.getText());
            ps.setString(3, jcbx_doctoad.getSelectedItem().toString());
            ps.setString(4, txt_ndoctoad.getText());
            ps.setString(5, jcbx_categoriaad.getSelectedItem().toString());
            ps.setString(6, txt_seccionad.getText());
            ps.setString(7, jcbx_estadoad.getSelectedItem().toString());
            ps.setString(8, txta_descripcionad.getText());
            ps.setString(9, jcbx_fpagoad.getSelectedItem().toString());
            ps.setString(10, ((JTextField)jdt_fechaad.getDateEditor().getUiComponent()).getText());
            ps.setString(11, txt_totalad.getText());
            ps.setString(12, jcbx_utilad.getSelectedItem().toString());
            ps.setString(13, txt_numdoctoad.getText());
            ps.setString(14, txt_numcuentaad.getText());
            ps.setString(15, txt_transaccionad.getText());
            ps.setString(16, dao);
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
            int fila = jtbl_adquiciones.getSelectedRow();
            String sql = "DELETE FROM adquisiciones WHERE codigo_ad='"+jtbl_adquiciones.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_adActionPerformed

    private void btn_actualizar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_adActionPerformed
        // TODO add your handling code here:
        llenar_adqui_oc();
        llenar_adquisiciones();
        jlbl_actividad.setText("Datos de las tablas 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_adActionPerformed

    private void jtbl_oc_refMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_oc_refMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_oc_ref.getSelectedRow();
            try{
                limpiar_adquisiciones();
                
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
                String dateString = formatter.format(date);
                txt_codigoad.setText("AD"+dateString);
                
                Double neto = Double.parseDouble(jtbl_oc_ref.getValueAt(fila, 8).toString());
                Double factor = 0.19;
                Double riva = (neto * factor);
                Double rtotal = riva + neto;
                Integer iva1 = (int) Math.round(riva);
                Integer total1 = (int) Math.round(rtotal);
                String iva = Integer.toString(iva1);
                String total = Integer.toString(total1);
                
                txt_codigoocad.setText(jtbl_oc_ref.getValueAt(fila, 0).toString());
                txta_descripcionad.setText(jtbl_oc_ref.getValueAt(fila, 2).toString());
                jcbx_doctoad.setSelectedItem(jtbl_oc_ref.getValueAt(fila, 7).toString());
                txt_totalad.setText(total);
                
                jlbl_ivaad.setText(iva);
                jlbl_netoad.setText(jtbl_oc_ref.getValueAt(fila, 8).toString());

                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }//GEN-LAST:event_jtbl_oc_refMouseClicked

    private void btn_trasladar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trasladar_adActionPerformed
        // TODO add your handling code here:
        habilitar_mercancia();
        
        // TRASPASAR NUMERO DE DOCUMENTO//
        String num_doc = "";
        num_doc = txt_ndoctoad.getText();
        txt_numdocmer.setText(num_doc);
        
        // TRASPASAR CODIGO OC//
        String cbox_oc ="";
        cbox_oc = txt_codigoocad.getText();
        txt_codocmer.setText(cbox_oc);
        
        // TRASPASAR CODIGO PROD//
        String cod_prod ="";
        cod_prod = txt_codigoad.getText();
        txt_codprodmer.setText(cod_prod);
        
        // TRASPASAR CODIGO PROD//
        Date date = jdt_fechaad.getDate();
        jdt_mercaderia.setDate(date);
        
        //TRASPASO DE TIPO DOCUMENTO//
        String tipo_doc ="";
        tipo_doc = jcbx_doctoad.getSelectedItem().toString();
        jcbx_tipodocmer.setSelectedItem(tipo_doc);
        
        //TRASPASO DESCRIPCION//
        String descrip ="";
        descrip = txta_descripcionad.getText();
        txta_descripcionmer.setText(descrip);
        
        //TRASPASO CANTIDAD//
        String cant = "1";
        txt_cantidadmer.setText(cant);
        
        //TRASPASO FORMA PAGO//
        String formap="";
        formap = jcbx_fpagoad.getSelectedItem().toString();
        jcbx_formapagomer.setSelectedItem(formap);
        
        //TRASPASO NETO//
        String neto="";
        neto = txt_totalad.getText();
        txt_totalmer.setText(neto);
        
        //TRASPASO DOCTO//
        String docto="";
        docto = txt_numdoctoad.getText();
        txt_doctbancmer.setText(docto);
        
        //TRASPASO CUENTA//
        String cuenta="";
        cuenta = txt_numcuentaad.getText();
        txt_cuentabancmer.setText(cuenta);
        
        //TRASPASO TRANSACCION//
        String trans="";
        trans = txt_transaccionad.getText();
        txt_transmer.setText(trans);
        
        String IVA="";
        IVA = jlbl_ivaad.getText();
        jlbl_ivamer.setText(IVA);
        
        String total="";
        total = jlbl_netoad.getText();
        jlbl_netomer.setText(total);
    }//GEN-LAST:event_btn_trasladar_adActionPerformed

    private void jtbl_adquicionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_adquicionesMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_adquiciones.getSelectedRow();
            try{
                limpiar_adquisiciones();
                btn_modificar_ad.setEnabled(true);
                btn_eliminar_ad.setEnabled(true);
                btn_guardar_ad.setEnabled(false);
                
                Double total = Double.parseDouble(jtbl_adquiciones.getValueAt(fila, 10).toString());
                Double div = 1.19;
                Double rneto = (total / div);
                Double riva = total - rneto;
                Integer iva1 = (int) Math.round(riva);
                Integer neto1 = (int) Math.round(rneto);
                String iva = Integer.toString(iva1);
                String neto = Integer.toString(neto1);
                
                txt_codigoad.setText(jtbl_adquiciones.getValueAt(fila, 0).toString());
                txt_codigoocad.setText(jtbl_adquiciones.getValueAt(fila, 1).toString());
                jcbx_doctoad.setSelectedItem(jtbl_adquiciones.getValueAt(fila, 2).toString());
                txt_ndoctoad.setText(jtbl_adquiciones.getValueAt(fila, 3).toString());
                jcbx_categoriaad.setSelectedItem(jtbl_adquiciones.getValueAt(fila, 4).toString());
                txt_seccionad.setText(jtbl_adquiciones.getValueAt(fila, 5).toString());
                jcbx_estadoad.setSelectedItem(jtbl_adquiciones.getValueAt(fila, 6).toString());
                txta_descripcionad.setText(jtbl_adquiciones.getValueAt(fila, 7).toString());
                jcbx_fpagoad.setSelectedItem(jtbl_adquiciones.getValueAt(fila, 8).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_adquiciones.getValueAt(fila,9).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_fechaad.setDate(fecha);
                
                txt_totalad.setText(jtbl_adquiciones.getValueAt(fila, 10).toString());
                
                jlbl_ivaad.setText(iva);
                jlbl_netoad.setText(neto);
                
                jcbx_utilad.setSelectedItem(jtbl_adquiciones.getValueAt(fila, 11).toString());
                txt_numdoctoad.setText(jtbl_adquiciones.getValueAt(fila, 12).toString());
                txt_numcuentaad.setText(jtbl_adquiciones.getValueAt(fila, 13).toString());
                txt_transaccionad.setText(jtbl_adquiciones.getValueAt(fila, 14).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jtbl_adquicionesMouseClicked

    private void jcbx_fpagoadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbx_fpagoadItemStateChanged
        // TODO add your handling code here:
        if (jcbx_fpagoad.getSelectedItem().equals("Efectivo")) {
            txt_numdoctoad.setText("");
            txt_numcuentaad.setText("");
            txt_transaccionad.setText("");
            
            txt_numdoctoad.setEnabled(false);
            txt_numcuentaad.setEnabled(false);
            txt_transaccionad.setEnabled(false);
        }if (jcbx_fpagoad.getSelectedItem().equals("Cheque")) {
            txt_numdoctoad.setText("");
            
            txt_numdoctoad.setEnabled(true);
            txt_numcuentaad.setEnabled(true);
            txt_transaccionad.setEnabled(false);   
        } if (jcbx_fpagoad.getSelectedItem().equals("Transferencia")) {
            txt_numdoctoad.setText("");
            
            txt_numdoctoad.setEnabled(false);
            txt_numcuentaad.setEnabled(true);
            txt_transaccionad.setEnabled(true);   
        } if (jcbx_fpagoad.getSelectedItem().equals("Tarjeta Credito")) {
            txt_numdoctoad.setText("");
            
            txt_numdoctoad.setEnabled(false);
            txt_numcuentaad.setEnabled(true);
            txt_transaccionad.setEnabled(false);   
        } if (jcbx_fpagoad.getSelectedItem().equals("Cuenta Corriente")) {
            txt_numdoctoad.setText("");
            
            txt_numdoctoad.setEnabled(false);
            txt_numcuentaad.setEnabled(true);
            txt_transaccionad.setEnabled(false);   
        }
    }//GEN-LAST:event_jcbx_fpagoadItemStateChanged

    private void btn_nuevo_merActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_merActionPerformed
        // TODO add your handling code here:
        limpiar_mercancia();
        habilitar_mercancia();
        jtbl_productos.setEnabled(true);
        jtbl_mercaderia.setEnabled(true);
        jtbl_oc_mer.setEnabled(true);
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_merActionPerformed

    private void btn_guardar_merActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_merActionPerformed
        // TODO add your handling code here:
        if (jcbx_formapagomer.getSelectedItem().equals("Efectivo")) {
            if (txt_codocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compra");
            }
            else if (txt_codprodmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Producto");
            }
            else if (txt_numdocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento");
            }
            else if (txta_descripcionmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion de la Mercancia");
            }
            else if (jdt_mercaderia.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso de la Mercaderia");
            }
            else if (txt_cantidadmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad de la Mercancia");
            }
            else if (txt_totalmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el valor en Total del Producto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO mercancia (codigo_prod, codigo_oc, fecha, tipo_doc, num_doc, lote, descripcion, cantidad, valor_total, forma_pago, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,0,0,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codprodmer.getText());
                        pps.setString(2, txt_codocmer.getText());
                        pps.setString(3, ((JTextField)jdt_mercaderia.getDateEditor().getUiComponent()).getText());
                        pps.setString(4, jcbx_tipodocmer.getSelectedItem().toString());
                        pps.setString(5, txt_numdocmer.getText());
                        pps.setString(6, jcbx_lote.getSelectedItem().toString());
                        pps.setString(7, txta_descripcionmer.getText());
                        pps.setString(8, txt_cantidadmer.getText());
                        pps.setString(9, txt_totalmer.getText());
                        pps.setString(10, jcbx_formapagomer.getSelectedItem().toString());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        } else if (jcbx_formapagomer.getSelectedItem().equals("Cheque")) {
            if (txt_codocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compras");
            }
            else if (txt_codprodmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Producto");
            }
            else if (txt_numdocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento del Producto");
            }
            else if (jdt_mercaderia.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso del Producto");
            }
            else if (txta_descripcionmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Producto");
            }
            else if (txt_cantidadmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad del Producto");
            }
            else if (txt_doctbancmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero del Cheque");
            }
            else if (txt_cuentabancmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Cuenta Bancaria");
            }
            else if (txt_totalmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Valor Total del Producto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO mercancia (codigo_prod, codigo_oc, fecha, tipo_doc, num_doc, lote, descripcion, cantidad, valor_total, forma_pago, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,?,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codprodmer.getText());
                        pps.setString(2, txt_codocmer.getText());
                        pps.setString(3, ((JTextField)jdt_mercaderia.getDateEditor().getUiComponent()).getText());
                        pps.setString(4, jcbx_tipodocmer.getSelectedItem().toString());
                        pps.setString(5, txt_numdocmer.getText());
                        pps.setString(6, jcbx_lote.getSelectedItem().toString());
                        pps.setString(7, txta_descripcionmer.getText());
                        pps.setString(8, txt_cantidadmer.getText());
                        pps.setString(9, txt_totalmer.getText());
                        pps.setString(10, jcbx_formapagomer.getSelectedItem().toString());
                        pps.setString(11, txt_doctbancmer.getText());
                        pps.setString(12, txt_cuentabancmer.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        } else if (jcbx_formapagomer.getSelectedItem().equals("Transferencia")) {
            if (txt_codocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compras");
            }
            else if (txt_codprodmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Producto");
            }
            else if (txt_numdocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento del Producto");
            }
            else if (jdt_mercaderia.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso del Producto");
            }
            else if (txta_descripcionmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Producto");
            }
            else if (txt_cantidadmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad del Producto");
            }
            else if (txt_transmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de la Transferencia");
            }
            else if (txt_totalmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Valor en Total del Producto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO mercancia (codigo_prod, codigo_oc, fecha, tipo_doc, num_doc, lote, descripcion, cantidad, valor_total, forma_pago, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,0,0,?)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codprodmer.getText());
                        pps.setString(2, txt_codocmer.getText());
                        pps.setString(3, ((JTextField)jdt_mercaderia.getDateEditor().getUiComponent()).getText());
                        pps.setString(4, jcbx_tipodocmer.getSelectedItem().toString());
                        pps.setString(5, txt_numdocmer.getText());
                        pps.setString(6, jcbx_lote.getSelectedItem().toString());
                        pps.setString(7, txta_descripcionmer.getText());
                        pps.setString(8, txt_cantidadmer.getText());
                        pps.setString(9, txt_totalmer.getText());
                        pps.setString(10, jcbx_formapagomer.getSelectedItem().toString());
                        pps.setString(11, txt_transmer.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        } else if (jcbx_formapagomer.getSelectedItem().equals("Tarjeta Credito")) {
            if (txt_codocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compras");
            }
            else if (txt_codprodmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Producto");
            }
            else if (txt_numdocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento del Producto");
            }
            else if (jdt_mercaderia.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso del Producto");
            }
            else if (txta_descripcionmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Producto");
            }
            else if (txt_cantidadmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad del Producto");
            }
            else if (txt_transmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de la Transferencia");
            }
            else if (txt_totalmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Valor en Total del Producto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO mercancia (codigo_prod, codigo_oc, fecha, tipo_doc, num_doc, lote, descripcion, cantidad, valor_total, forma_pago, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,0,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codprodmer.getText());
                        pps.setString(2, txt_codocmer.getText());
                        pps.setString(3, ((JTextField)jdt_mercaderia.getDateEditor().getUiComponent()).getText());
                        pps.setString(4, jcbx_tipodocmer.getSelectedItem().toString());
                        pps.setString(5, txt_numdocmer.getText());
                        pps.setString(6, jcbx_lote.getSelectedItem().toString());
                        pps.setString(7, txta_descripcionmer.getText());
                        pps.setString(8, txt_cantidadmer.getText());
                        pps.setString(9, txt_totalmer.getText());
                        pps.setString(10, jcbx_formapagomer.getSelectedItem().toString());
                        pps.setString(11, txt_cuentabancmer.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        } else if (jcbx_fpagoad.getSelectedItem().equals("Cuenta Corriente")) {
            if (txt_codocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de la Orden de Compras");
            }
            else if (txt_codprodmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Codigo de Producto");
            }
            else if (txt_numdocmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de Documento del Producto");
            }
            else if (jdt_mercaderia.getDate() == null) {
                jlbl_actividad.setText("Ingresa la Fecha de Ingreso del Producto");
            }
            else if (txta_descripcionmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Descripcion del Producto");
            }
            else if (txt_cantidadmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa la Cantidad del Producto");
            }
            else if (txt_transmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Numero de la Transferencia");
            }
            else if (txt_totalmer.getText().isEmpty()) {
                jlbl_actividad.setText("Ingresa el Valor en Total del Producto");
            }
            else {
                if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                    try {
                        PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO mercancia (codigo_prod, codigo_oc, fecha, tipo_doc, num_doc, lote, descripcion, cantidad, valor_total, forma_pago, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,0,?,0)", Statement.RETURN_GENERATED_KEYS);
                        pps.setString(1, txt_codprodmer.getText());
                        pps.setString(2, txt_codocmer.getText());
                        pps.setString(3, ((JTextField)jdt_mercaderia.getDateEditor().getUiComponent()).getText());
                        pps.setString(4, jcbx_tipodocmer.getSelectedItem().toString());
                        pps.setString(5, txt_numdocmer.getText());
                        pps.setString(6, jcbx_lote.getSelectedItem().toString());
                        pps.setString(7, txta_descripcionmer.getText());
                        pps.setString(8, txt_cantidadmer.getText());
                        pps.setString(9, txt_totalmer.getText());
                        pps.setString(10, jcbx_formapagomer.getSelectedItem().toString());
                        pps.setString(11, txt_cuentabancmer.getText());
                        pps.executeUpdate();
                        jlbl_actividad.setText("Datos Guardados");
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_merActionPerformed

    private void btn_modificar_merActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_merActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE mercancia SET codigo_prod=?, codigo_oc=?, fecha=?, tipo_doc=?, num_doc=?, lote=?, descripcion=?, cantidad=?, valor_total=?, forma_pago=?, num_cheque=?, num_cuenta=?, num_trans=?"+"Where codigo_prod=?";
            int fila = jtbl_mercaderia.getSelectedRow();
            String dao = (String)jtbl_mercaderia.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_codprodmer.getText());
            ps.setString(2, txt_codocmer.getText());
            ps.setString(3, ((JTextField)jdt_mercaderia.getDateEditor().getUiComponent()).getText());
            ps.setString(4, jcbx_tipodocmer.getSelectedItem().toString());
            ps.setString(5, txt_numdocmer.getText());
            ps.setString(6, jcbx_lote.getSelectedItem().toString());
            ps.setString(7, txta_descripcionmer.getText());
            ps.setString(8, txt_cantidadmer.getText());
            ps.setString(9, txt_totalmer.getText());
            ps.setString(10, jcbx_formapagomer.getSelectedItem().toString());
            ps.setString(11, txt_doctbancmer.getText());
            ps.setString(12, txt_cuentabancmer.getText());
            ps.setString(13, txt_transmer.getText());
            ps.setString(14, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }//GEN-LAST:event_btn_modificar_merActionPerformed

    private void btn_eliminar_merActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_merActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_mercaderia.getSelectedRow();
            String sql = "DELETE FROM mercancia WHERE codigo_prod='"+jtbl_mercaderia.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_merActionPerformed

    
    private void btn_actualizar_merActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_merActionPerformed
        // TODO add your handling code here:
        llenar_mercanoc();
        llenar_mercancia();
        llenar_productos();
        jlbl_actividad.setText("Datos de las tablas 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_merActionPerformed

    private void jtbl_oc_merMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_oc_merMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_oc_mer.getSelectedRow();
            try{
                limpiar_mercancia();
                jtbl_mercaderia.setEnabled(false);
                jcbx_venta.setEnabled(false);
                btn_transaccion.setEnabled(false);
                btn_libro_compra.setEnabled(false);
                Double neto = Double.parseDouble(jtbl_oc_mer.getValueAt(fila, 4).toString());
                Double factor = 0.19;
                Double riva = (neto * factor);
                Double rtotal = riva + neto;
                Integer iva1 = (int) Math.round(riva);
                Integer total1 = (int) Math.round(rtotal);
                String iva = Integer.toString(iva1);
                String total = Integer.toString(total1);
                
                txt_codocmer.setText(jtbl_oc_mer.getValueAt(fila, 0).toString());
                txta_descripcionmer.setText(jtbl_oc_mer.getValueAt(fila, 1).toString());
                jcbx_tipodocmer.setSelectedItem(jtbl_oc_mer.getValueAt(fila, 3).toString());
                txt_totalmer.setText(total);
                
                jlbl_ivamer.setText(iva);
                jlbl_netomer.setText(jtbl_oc_mer.getValueAt(fila, 4).toString());

                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }//GEN-LAST:event_jtbl_oc_merMouseClicked

    private void jtbl_mercaderiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_mercaderiaMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_mercaderia.getSelectedRow();
            try{
                limpiar_mercancia();
                btn_modificar_mer.setEnabled(true);
                btn_eliminar_mer.setEnabled(true);
                btn_guardar_mer.setEnabled(false);
                jcbx_venta.setEnabled(true);
                btn_transaccion.setEnabled(true);
                btn_libro_compra.setEnabled(true);
                jtbl_oc_mer.setEnabled(false);
                Double total = Double.parseDouble(jtbl_mercaderia.getValueAt(fila, 8).toString());
                Double div = 1.19;
                Double rneto = (total / div);
                Double riva = total - rneto;
                Integer iva1 = (int) Math.round(riva);
                Integer neto1 = (int) Math.round(rneto);
                String iva = Integer.toString(iva1);
                String neto = Integer.toString(neto1);
                
                txt_codprodmer.setText(jtbl_mercaderia.getValueAt(fila, 0).toString());
                txt_codocmer.setText(jtbl_mercaderia.getValueAt(fila, 1).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_mercaderia.getValueAt(fila,2).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);                
                jdt_mercaderia.setDate(fecha);
                
                jcbx_tipodocmer.setSelectedItem(jtbl_mercaderia.getValueAt(fila, 3).toString());
                txt_numdocmer.setText(jtbl_mercaderia.getValueAt(fila, 4).toString());
                jcbx_lote.setSelectedItem(jtbl_mercaderia.getValueAt(fila, 5).toString());
                txta_descripcionmer.setText(jtbl_mercaderia.getValueAt(fila, 6).toString());
                txt_cantidadmer.setText(jtbl_mercaderia.getValueAt(fila, 7).toString());
                txt_totalmer.setText(jtbl_mercaderia.getValueAt(fila, 8).toString());
                jcbx_formapagomer.setSelectedItem(jtbl_mercaderia.getValueAt(fila, 9).toString());
                
                jlbl_ivamer.setText(iva);
                jlbl_netomer.setText(neto);
                
                txt_doctbancmer.setText(jtbl_mercaderia.getValueAt(fila, 10).toString());
                txt_cuentabancmer.setText(jtbl_mercaderia.getValueAt(fila, 11).toString());
                txt_transmer.setText(jtbl_mercaderia.getValueAt(fila, 12).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jtbl_mercaderiaMouseClicked

    private void jcbx_formapagomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbx_formapagomerItemStateChanged
        // TODO add your handling code here:
        if (jcbx_formapagomer.getSelectedItem().equals("Efectivo")) {
            txt_doctbancmer.setText("");
            txt_cuentabancmer.setText("");
            txt_transmer.setText("");
            
            txt_doctbancmer.setEnabled(false);
            txt_cuentabancmer.setEnabled(false);
            txt_transmer.setEnabled(false);
        }if (jcbx_formapagomer.getSelectedItem().equals("Cheque")) {
            txt_doctbancmer.setText("");
            
            txt_doctbancmer.setEnabled(true);
            txt_cuentabancmer.setEnabled(true);
            txt_transmer.setEnabled(false);   
        } if (jcbx_formapagomer.getSelectedItem().equals("Transferencia")) {
            txt_doctbancmer.setText("");
            
            txt_doctbancmer.setEnabled(false);
            txt_cuentabancmer.setEnabled(true);
            txt_transmer.setEnabled(true);   
        } if (jcbx_formapagomer.getSelectedItem().equals("Tarjeta Credito")) {
            txt_doctbancmer.setText("");
            
            txt_doctbancmer.setEnabled(false);
            txt_cuentabancmer.setEnabled(true);
            txt_transmer.setEnabled(false);   
        } if (jcbx_formapagomer.getSelectedItem().equals("Cuenta Corriente")) {
            txt_doctbancmer.setText("");
            
            txt_doctbancmer.setEnabled(false);
            txt_cuentabancmer.setEnabled(true);
            txt_transmer.setEnabled(false);   
        }
    }//GEN-LAST:event_jcbx_formapagomerItemStateChanged

    private void btn_nuevo_oc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_oc1ActionPerformed
        // TODO add your handling code here:
        limpiar_perdidas();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(date);
        txt_codigop.setText("PER"+dateString);
        habilitar_perdidas();
        jlbl_actividad.setText("Habilitado y Limpiado");
    }//GEN-LAST:event_btn_nuevo_oc1ActionPerformed

    private void btn_guardar_oc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_oc1ActionPerformed
        // TODO add your handling code here:
        if (txt_codigop.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Codigo para el Producto Perdido");
        }
        else if (txt_codprodp.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa la Descripcion del Producto Perdido");
        }
        else if (jdt_fechap.getDate() == null) {
            jlbl_actividad.setText("Ingresa la Fecha en que se perdio el Producto");
        }
        else if (txt_cantidadp.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa la Cantidad del Producto Perdido");
        }
        else if (txt_montop.getText().isEmpty()) {
            jlbl_actividad.setText("Ingresa el Monto del Producto Perdido");
        }
        else {
            if (JOptionPane.showConfirmDialog(null,"Revise sus Datos", "Confirmar",1)==0){
                try {
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO perdidas (codigo, codigo_prod, producto, fecha, cantidad, motivo, monto) values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    pps.setString(1, txt_codigop.getText());
                    pps.setString(2, txt_codprodp.getText());
                    pps.setString(3, txt_productosp.getText());
                    pps.setString(4, ((JTextField)jdt_fechap.getDateEditor().getUiComponent()).getText());
                    pps.setString(5, txt_cantidadp.getText());
                    pps.setString(6, jcbx_motivop.getSelectedItem().toString());
                    pps.setString(7, txt_montop.getText());
                    pps.executeUpdate();
                    jlbl_actividad.setText("Datos Guardados");
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_guardar_oc1ActionPerformed

    private void btn_modificar_oc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_oc1ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE perdidas SET codigo=?, codigo_prod=?, producto=?, fecha=?, cantidad=?, motivo=?, monto=?"+"Where codigo=?";
            int fila = jtbl_perdidas.getSelectedRow();
            String dao = (String)jtbl_perdidas.getValueAt(fila, 0);
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, txt_codigop.getText());
            ps.setString(2, txt_codprodp.getText());
            ps.setString(3, txt_productosp.getText());
            ps.setString(4, ((JTextField)jdt_fechap.getDateEditor().getUiComponent()).getText());
            ps.setString(5, txt_cantidadp.getText());
            ps.setString(6, jcbx_motivop.getSelectedItem().toString());
            ps.setString(7, txt_montop.getText());
            ps.setString(8, dao);
            int n = ps.executeUpdate();
            if (n>0) {
                jlbl_actividad.setText("Datos Modificados");
            }
            cn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }//GEN-LAST:event_btn_modificar_oc1ActionPerformed

    private void btn_eliminar_oc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_oc1ActionPerformed
        // TODO add your handling code here:
        try {
            int fila = jtbl_perdidas.getSelectedRow();
            String sql = "DELETE FROM perdidas WHERE codigo='"+jtbl_perdidas.getValueAt(fila, 0)+"'";
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n>0) {
                jlbl_actividad.setText("Datos Eliminados");
            }
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_oc1ActionPerformed

    private void btn_actualizar_oc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_oc1ActionPerformed
        // TODO add your handling code here:
        llenar_mer_per();
        llenar_perdidas();
        jlbl_actividad.setText("Datos de las tablas 'Actualizados'");
    }//GEN-LAST:event_btn_actualizar_oc1ActionPerformed

    private void jtbl_mer_perdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_mer_perdMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_mer_perd.getSelectedRow();
            try{
                limpiar_perdidas();
                habilitar_perdidas();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
                String dateString = formatter.format(date);
                txt_codigop.setText("PER"+dateString);
                
                txt_codprodp.setText(jtbl_mer_perd.getValueAt(fila, 1).toString());
                txt_productosp.setText(jtbl_mer_perd.getValueAt(fila, 2).toString());
                txt_montop.setText(jtbl_mer_perd.getValueAt(fila, 7).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }        
    }//GEN-LAST:event_jtbl_mer_perdMouseClicked

    private void jtbl_perdidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_perdidasMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = jtbl_perdidas.getSelectedRow();
            try{
                limpiar_perdidas();
                btn_modificar_oc1.setEnabled(true);
                btn_eliminar_oc1.setEnabled(true);
                btn_guardar_oc1.setEnabled(false);
                
                txt_codigop.setText(jtbl_perdidas.getValueAt(fila, 0).toString());
                txt_codprodp.setText(jtbl_perdidas.getValueAt(fila, 1).toString());
                txt_productosp.setText(jtbl_perdidas.getValueAt(fila, 2).toString());
                
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strfecha = (String) jtbl_perdidas.getValueAt(fila,3).toString().trim();
                Date fecha = formatoDelTexto.parse(strfecha);
                jdt_fechap.setDate(fecha);
                
                txt_cantidadp.setText(jtbl_perdidas.getValueAt(fila, 4).toString());
                jcbx_motivop.setSelectedItem(jtbl_perdidas.getValueAt(fila, 5).toString());
                txt_montop.setText(jtbl_perdidas.getValueAt(fila, 6).toString());
                jlbl_actividad.setText("Datos Traslados a Campos, Rellene y Guarde sus Datos Nuevos");
            }catch (Exception ex) {
                ex.printStackTrace();

            }
        }        
    }//GEN-LAST:event_jtbl_perdidasMouseClicked

    private void btn_transaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaccionActionPerformed
        // TODO add your handling code here
    try {
        int codigo_prodm;
        codigo_prodm = 0;
        int codigo_prodp;
        codigo_prodp = 0;
        PreparedStatement ps = (PreparedStatement) cn.prepareStatement("SELECT codigo_prod FROM mercancia");
        PreparedStatement pss = (PreparedStatement) cn.prepareStatement("SELECT codigo_prod FROM productos"); 
        
        ResultSet rs = ps.executeQuery();
        ResultSet rs1 = pss.executeQuery();
        while (rs.next()) {
        codigo_prodm = rs.getInt("codigo_prod");
        }
        while (rs1.next()) {
        codigo_prodp = rs1.getInt("codigo_prod");
        }
//        ps.close();
//        pss.close();
//        rs.close();
//        rs1.close();
        if (codigo_prodp >= 0) {
            if (codigo_prodm == codigo_prodp) {
//                ps.close();
//                pss.close();
//                rs.close();
//                rs1.close();
                try {
                    String sql = "UPDATE productos SET cantidad=cantidad+?"+"Where codigo_prod=?";
                    int fila = jtbl_mercaderia.getSelectedRow();
                    String dao = (String)jtbl_mercaderia.getValueAt(fila, 1);
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement(sql);
                    pps.setString(1, txt_cantidadmer.getText());
                    pps.setString(2, dao);
                    int n = pps.executeUpdate();
                    if (n>0) {
                        jlbl_actividad.setText("Datos en Stock Modificados");
                    }
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
                }
//                try {
//                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("delete from mercancia");
//                    pps.executeUpdate();
//                    jlbl_actividad.setText("Datos eliminados de mercancia");
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
                
                finally{                
                ps.close();
                pss.close();
                rs.close();
                rs1.close();
                };
                
            } else {
                ps.close();
                pss.close();
                rs.close();
                rs1.close();
                try {

                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO productos (codigo_prod, descripcion, lote, cantidad, fecha, valor_compra, valor_venta) values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    Double Valor_total = Double.parseDouble(txt_totalmer.getText());
                    String factors = jcbx_venta.getSelectedItem().toString();
                    Double Factor = Double.parseDouble(factors);
                    Double valor_iva = (Valor_total * Factor/100);
                    Double valor_ventar = Valor_total + valor_iva;
                    Integer valor_ventai = (int) Math.round(valor_ventar);
                    String valor_venta = Integer.toString(valor_ventai);
                    
                    pps.setString(1, txt_codprodmer.getText());
                    pps.setString(2, txta_descripcionmer.getText());
                    pps.setString(3, jcbx_lote.getSelectedItem().toString());
                    pps.setString(4, txt_cantidadmer.getText());
                    pps.setString(5, ((JTextField)jdt_mercaderia.getDateEditor().getUiComponent()).getText());
                    pps.setString(6, txt_totalmer.getText());
                    pps.setString(7, valor_venta);
                    
                    pps.executeUpdate();
                    jlbl_actividad.setText("Datos Guardados");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
//                try {
//                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("delete from mercancia");
//                    pps.executeUpdate();
//                    jlbl_actividad.setText("Datos eliminados de mercancia");
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
                
                finally{
                ps.close();
                pss.close();
                rs.close();
                rs1.close();
                };
            }
        } else {
//            ps.close();
//            pss.close();
//            rs.close();
//            rs1.close();
            try {
                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO productos (codigo_prod, descripcion, lote, cantidad, fecha, valor_compra, valor_venta) values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                Double Valor_total = Double.parseDouble(txt_totalmer.getText());
                String factors = jcbx_venta.getSelectedItem().toString();
                Double Factor = Double.parseDouble(factors);
                Double valor_iva = (Valor_total * Factor/100);
                Double valor_ventar = Valor_total + valor_iva;
                Integer valor_ventai = (int) Math.round(valor_ventar);
                String valor_venta = Integer.toString(valor_ventai);

                pps.setString(1, txt_codprodmer.getText());
                pps.setString(2, txta_descripcionmer.getText());
                pps.setString(3, jcbx_lote.getSelectedItem().toString());
                pps.setString(4, txt_cantidadmer.getText());
                pps.setString(5, ((JTextField)jdt_mercaderia.getDateEditor().getUiComponent()).getText());
                pps.setString(6, txt_totalmer.getText());
                pps.setString(7, valor_venta);

                pps.executeUpdate();
                jlbl_actividad.setText("Datos Guardados");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
//            try {
//                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("delete from mercancia");
//                pps.executeUpdate();
//                jlbl_actividad.setText("Datos eliminados de mercancia");
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, ex);
//            }
            finally{
                ps.close();
                pss.close();
                rs.close();
                rs1.close();
            };
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_btn_transaccionActionPerformed

    private void jtbl_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_productosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_productosMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btn_trans_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trans_prodActionPerformed
        // TODO add your handling code here:
    try {
        int codigo_prodper;
        codigo_prodper = 0;
        int codigo_prodp;
        codigo_prodp = 0;
        
        PreparedStatement ps = (PreparedStatement) cn.prepareStatement("SELECT bol.codigo_prod FROM detalleb bol");
        PreparedStatement pss = (PreparedStatement) cn.prepareStatement("SELECT prod.codigo_prod FROM productos prod"); 
        ResultSet rs = ps.executeQuery();
        ResultSet rs1 = pss.executeQuery();
        while (rs.next()) {
        codigo_prodper = rs.getInt("codigo_prod");
        }
        while (rs1.next()) {
        codigo_prodp = rs1.getInt("codigo_prod");
        }
        ps.close();
        pss.close();
        rs.close();
        rs1.close();
        if (codigo_prodp >= 0 || codigo_prodp == codigo_prodper) {
                try {
                    String sql = "UPDATE productos SET cantidad=cantidad-?"+"Where codigo_prod=?";
                    int fila = jtbl_perdidas.getSelectedRow();
                    String dao = (String)jtbl_perdidas.getValueAt(fila, 1);
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement(sql);
                    pps.setString(1, txt_cantidadp.getText());
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
    }//GEN-LAST:event_btn_trans_prodActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void btn_libro_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_libro_compraActionPerformed
        // TODO add your handling code here:
                try {
                    PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO libro_compras (codigo_prod, codigo_oc, fecha, tipo_doc, num_doc, lote, descripcion, cantidad, valor_total, forma_pago, num_cheque, num_cuenta, num_trans) values (?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    pps.setString(1, txt_codprodmer.getText());
                    pps.setString(2, txt_codocmer.getText());
                    pps.setString(3, ((JTextField)jdt_mercaderia.getDateEditor().getUiComponent()).getText());
                    pps.setString(4, jcbx_tipodocmer.getSelectedItem().toString());
                    pps.setString(5, txt_numdocmer.getText());
                    pps.setString(6, jcbx_lote.getSelectedItem().toString());
                    pps.setString(7, txta_descripcionmer.getText());
                    pps.setString(8, txt_cantidadmer.getText());
                    pps.setString(9, txt_totalmer.getText());
                    pps.setString(10, jcbx_formapagomer.getSelectedItem().toString());
                    pps.setString(11, txt_doctbancmer.getText());
                    pps.setString(12, txt_cuentabancmer.getText());                    
                    pps.setString(13, txt_transmer.getText());    
                    pps.executeUpdate();
                    limpiar_mercancia();
                    habilitar_mercancia();
                    jlbl_actividad.setText("Trasladado a Libro Compras, Actualize los datos de la tabla");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
    }//GEN-LAST:event_btn_libro_compraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar_ad;
    private javax.swing.JButton btn_actualizar_mer;
    private javax.swing.JButton btn_actualizar_oc;
    private javax.swing.JButton btn_actualizar_oc1;
    private javax.swing.JButton btn_eliminar_ad;
    private javax.swing.JButton btn_eliminar_mer;
    private javax.swing.JButton btn_eliminar_oc;
    private javax.swing.JButton btn_eliminar_oc1;
    private javax.swing.JButton btn_guardar_ad;
    private javax.swing.JButton btn_guardar_mer;
    private javax.swing.JButton btn_guardar_oc;
    private javax.swing.JButton btn_guardar_oc1;
    private javax.swing.JButton btn_libro_compra;
    private javax.swing.JButton btn_modificar_ad;
    private javax.swing.JButton btn_modificar_mer;
    private javax.swing.JButton btn_modificar_oc;
    private javax.swing.JButton btn_modificar_oc1;
    private javax.swing.JButton btn_nuevo_ad;
    private javax.swing.JButton btn_nuevo_mer;
    private javax.swing.JButton btn_nuevo_oc;
    private javax.swing.JButton btn_nuevo_oc1;
    private javax.swing.JButton btn_trans_prod;
    private javax.swing.JButton btn_transaccion;
    private javax.swing.JButton btn_trasladar_ad;
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
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> jcbx_categoriaad;
    private javax.swing.JComboBox<String> jcbx_docto;
    private javax.swing.JComboBox<String> jcbx_doctoad;
    private javax.swing.JComboBox<String> jcbx_estadoad;
    private javax.swing.JComboBox<String> jcbx_formapagomer;
    private javax.swing.JComboBox<String> jcbx_fpagoad;
    private javax.swing.JComboBox<String> jcbx_gastos;
    private javax.swing.JComboBox<String> jcbx_lote;
    private javax.swing.JComboBox<String> jcbx_motivop;
    private javax.swing.JComboBox<String> jcbx_tipodocmer;
    private javax.swing.JComboBox<String> jcbx_utilad;
    private javax.swing.JComboBox<String> jcbx_venta;
    private com.toedter.calendar.JDateChooser jdt_fecha;
    private com.toedter.calendar.JDateChooser jdt_fechaad;
    private com.toedter.calendar.JDateChooser jdt_fechap;
    private com.toedter.calendar.JDateChooser jdt_mercaderia;
    private javax.swing.JLabel jlbl_actividad;
    private javax.swing.JLabel jlbl_ivaad;
    private javax.swing.JLabel jlbl_ivamer;
    private javax.swing.JLabel jlbl_ivaoc;
    private javax.swing.JLabel jlbl_netoad;
    private javax.swing.JLabel jlbl_netomer;
    private javax.swing.JLabel jlbl_totaloc;
    private javax.swing.JTable jtbl_adquiciones;
    private javax.swing.JTable jtbl_mer_perd;
    private javax.swing.JTable jtbl_mercaderia;
    private javax.swing.JTable jtbl_oc_mer;
    private javax.swing.JTable jtbl_oc_ref;
    private javax.swing.JTable jtbl_ordencompra;
    private javax.swing.JTable jtbl_perdidas;
    private javax.swing.JTable jtbl_productos;
    private javax.swing.JTextField txt_cantidadmer;
    private javax.swing.JTextField txt_cantidadp;
    private javax.swing.JTextField txt_codigo_oc;
    private javax.swing.JTextField txt_codigoad;
    private javax.swing.JTextField txt_codigoocad;
    private javax.swing.JTextField txt_codigop;
    private javax.swing.JTextField txt_codocmer;
    private javax.swing.JTextField txt_codprodmer;
    private javax.swing.JTextField txt_codprodp;
    private javax.swing.JTextField txt_comentario;
    private javax.swing.JTextField txt_cuentabancmer;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_doctbancmer;
    private javax.swing.JTextField txt_montop;
    private javax.swing.JTextField txt_ndoctoad;
    private javax.swing.JTextField txt_numcuentaad;
    private javax.swing.JTextField txt_numdocmer;
    private javax.swing.JTextField txt_numdoctoad;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_productosp;
    private javax.swing.JTextField txt_proveedor;
    private javax.swing.JTextField txt_seccionad;
    private javax.swing.JTextField txt_totalad;
    private javax.swing.JTextField txt_totalmer;
    private javax.swing.JTextField txt_transaccionad;
    private javax.swing.JTextField txt_transmer;
    private javax.swing.JTextField txt_url;
    private javax.swing.JTextArea txta_descripcionad;
    private javax.swing.JTextArea txta_descripcionmer;
    // End of variables declaration//GEN-END:variables
}