/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;
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
public class Ventas_C extends javax.swing.JInternalFrame {
    private TableRowSorter trsFiltro;
    DefaultTableModel model;
    Conexion.conexion conexion = new Conexion.conexion();
    Connection cn = conexion.connect();
    Statement sent;
    /**
     * Creates new form Ventas_C
     */
    public Ventas_C() {
        initComponents();
        llenar_ordenventas();
        llenar_boletas();
        llenar_factura();
    }
    
    void llenar_ordenventas() {
        try {
            cn = conexion.connect();
            String [] titulos = {"C° OV","C° Producto","Descripción","Fecha","Neto","IVA","Precio Total"};
            String sql = "SELECT codigo_ov, codigo_prod, descripcion, fecha, precio FROM orden_venta";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [7];
            while (rs.next()){
                fila[0]=rs.getString("codigo_ov");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("descripcion");
                fila[3]=rs.getString("fecha");
                
                //Calculos de Neto
                Integer precio_total = Integer.parseInt(rs.getString("precio"));
                Double neto1 =  precio_total/1.19;
                Integer neto2 = Integer.valueOf(neto1.intValue());
                String neto = Integer.toString(neto2);
                
                //Calculos de IVA
                Double IVA1 = neto1 * 0.19;
                Integer IVA2 = Integer.valueOf(IVA1.intValue());
                String IVA = Integer.toString(IVA2);
                
                fila[4]=(neto);
                fila[5]=(IVA);
                fila[6]=rs.getString("precio");
            model.addRow(fila);
            }
            jtbl_ordenventas.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_boletas() {
        try {
            cn = conexion.connect();
            String [] titulos = {"N° Ingreso","C° Producto","T° Docto","N° Docto","Descripcion","Fecha","Cantidad","Neto","IVA","Precio Total","Forma Pago"};
            String sql = "SELECT num_ingreso, codigo_prod, tipo_doc, num_doc, descripcion, fecha, cantidad, neto, forma_pago FROM detalleb";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [11];
            while (rs.next()){
                fila[0]=rs.getString("num_ingreso");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("tipo_doc");
                fila[3]=rs.getString("num_doc");
                fila[4]=rs.getString("descripcion");
                fila[5]=rs.getString("fecha");
                fila[6]=rs.getString("cantidad");
                
                //Calculos de Neto
                Integer precio_total = Integer.parseInt(rs.getString("neto"));
                Double iva =  precio_total*1.19;
                Integer total_iva = Integer.valueOf(iva.intValue());
                String total = Integer.toString(total_iva);
                
                //Calculos de IVA
                Double IVA1 = iva * 0.19;
                Integer IVA2 = Integer.valueOf(IVA1.intValue());
                String IVA = Integer.toString(IVA2);
                
                fila[7]=(total);
                fila[8]=(IVA);
                fila[9]=rs.getString("neto");
                fila[10]=rs.getString("forma_pago");
            model.addRow(fila);
            }
            jtbl_boletas.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_factura() {
        try {
            cn = conexion.connect();
            String [] titulos = {"N° Ingreso","C° Producto","T° Docto","N° Docto","Cliente","Rut","Direccion","Ciudad","Provincia","Giro","Telefono","Despacho","Descripcion","Fecha","Cantidad","Neto","IVA","Precio Total","Forma Pago"};
            String sql = "SELECT num_ingreso, codigo_prod, tipo_doc, num_doc, cliente, rut, direccion, ciudad, provincia, giro, fono, despacho, descripcion, fecha, cantidad, neto, forma_pago FROM detallef";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [19];
            while (rs.next()){
                fila[0]=rs.getString("num_ingreso");
                fila[1]=rs.getString("codigo_prod");
                fila[2]=rs.getString("tipo_doc");
                fila[3]=rs.getString("num_doc");
                fila[4]=rs.getString("cliente");
                fila[5]=rs.getString("rut");
                fila[6]=rs.getString("direccion");
                fila[7]=rs.getString("ciudad");
                fila[8]=rs.getString("provincia");
                fila[9]=rs.getString("giro");
                fila[10]=rs.getString("fono");
                fila[11]=rs.getString("despacho");
                fila[12]=rs.getString("descripcion");
                fila[13]=rs.getString("fecha");
                fila[14]=rs.getString("cantidad");
                
                //Calculos de Neto
                Integer precio_total = Integer.parseInt(rs.getString("neto"));
                Double iva =  precio_total*1.19;
                Integer total_iva = Integer.valueOf(iva.intValue());
                String total = Integer.toString(total_iva);
                
                //Calculos de IVA
                Double IVA1 = iva * 0.19;
                Integer IVA2 = Integer.valueOf(IVA1.intValue());
                String IVA = Integer.toString(IVA2);
                
                fila[15]=(total);
                fila[16]=(IVA);
                fila[17]=rs.getString("neto");
                fila[18]=rs.getString("forma_pago");
            model.addRow(fila);
            }
            jtbl_facturas.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }              
    }
    
    public void filtro_ov() {
        
        int columnaABuscar = 0;
        if (jcbx_ordenventas.getSelectedItem() == "C° OV") {
            columnaABuscar = 0;
        }
        if (jcbx_ordenventas.getSelectedItem() == "C° Producto") {
            columnaABuscar = 1;
        }
        if (jcbx_ordenventas.getSelectedItem() == "Descripcion") {
            columnaABuscar = 2;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_ordenventas.getText(), columnaABuscar));
    }
        
    public void filtro_bol() {
        
        int columnaABuscar = 0;
        if (jcbx_boletas.getSelectedItem() == "N° Ingreso") {
            columnaABuscar = 0;
        }
        if (jcbx_boletas.getSelectedItem() == "C° Producto") {
            columnaABuscar = 1;
        }
        if (jcbx_boletas.getSelectedItem() == "T° Docto") {
            columnaABuscar = 2;
        }
        if (jcbx_boletas.getSelectedItem() == "N° Docto") {
            columnaABuscar = 3;
        }
        if (jcbx_boletas.getSelectedItem() == "Descripcion") {
            columnaABuscar = 4;
        }
        if (jcbx_boletas.getSelectedItem() == "Fecha") {
            columnaABuscar = 5;
        }
        if (jcbx_boletas.getSelectedItem() == "Forma Pago") {
            columnaABuscar = 10;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_boletas.getText(), columnaABuscar));
    }
    
    public void filtro_fact() {
        
        int columnaABuscar = 0;
        if (jcbx_facturas.getSelectedItem() == "N° Ingreso") {
            columnaABuscar = 0;
        }
        if (jcbx_facturas.getSelectedItem() == "C° Producto") {
            columnaABuscar = 1;
        }
        if (jcbx_facturas.getSelectedItem() == "T° Docto") {
            columnaABuscar = 2;
        }
        if (jcbx_facturas.getSelectedItem() == "N° Docto") {
            columnaABuscar = 3;
        }
        if (jcbx_facturas.getSelectedItem() == "Cliente") {
            columnaABuscar = 4;
        }
        if (jcbx_facturas.getSelectedItem() == "Rut") {
            columnaABuscar = 5;
        }
        if (jcbx_facturas.getSelectedItem() == "Direccion") {
            columnaABuscar = 6;
        }
        if (jcbx_facturas.getSelectedItem() == "Ciudad") {
            columnaABuscar = 7;
        }
        if (jcbx_facturas.getSelectedItem() == "Provincia") {
            columnaABuscar = 8;
        }
        if (jcbx_facturas.getSelectedItem() == "Giro") {
            columnaABuscar = 9;
        }
        if (jcbx_facturas.getSelectedItem() == "Despacho") {
            columnaABuscar = 11;
        }
        if (jcbx_facturas.getSelectedItem() == "Descripcion") {
            columnaABuscar = 12;
        }
        if (jcbx_facturas.getSelectedItem() == "Fecha") {
            columnaABuscar = 13;
        }
        if (jcbx_facturas.getSelectedItem() == "Forma Pago") {
            columnaABuscar = 18;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_facturas.getText(), columnaABuscar));
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
        txt_ordenventas = new javax.swing.JTextField();
        jcbx_ordenventas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_ordenventas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_boletas = new javax.swing.JTextField();
        jcbx_boletas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_boletas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_facturas = new javax.swing.JTextField();
        jcbx_facturas = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_facturas = new javax.swing.JTable();

        setBackground(java.awt.SystemColor.activeCaption);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de Ventas");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/ventas1.png"))); // NOI18N
        jLabel1.setText("Consulta de Ventas");

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

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("BUSQUEDA:");

        txt_ordenventas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_ordenventas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ordenventasKeyTyped(evt);
            }
        });

        jcbx_ordenventas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_ordenventas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C° OV", "C° Producto", "Descripcion" }));
        jcbx_ordenventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbx_ordenventasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcbx_ordenventas, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_ordenventas, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ordenventas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_ordenventas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_ordenventas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_ordenventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_ordenventas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta Orden de Ventas", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        jPanel7.setBackground(java.awt.SystemColor.activeCaption);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("BUSQUEDA:");

        txt_boletas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_boletas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_boletasKeyTyped(evt);
            }
        });

        jcbx_boletas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_boletas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N° Ingreso", "C° Producto", "T° Docto", "N° Docto", "Descripcion", "Fecha", "Forma Pago" }));
        jcbx_boletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbx_boletasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jcbx_boletas, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_boletas, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_boletas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_boletas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_boletas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_boletas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtbl_boletas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta Boletas", jPanel4);

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);

        jPanel8.setBackground(java.awt.SystemColor.activeCaption);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("BUSQUEDA:");

        txt_facturas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_facturas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_facturasKeyTyped(evt);
            }
        });

        jcbx_facturas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_facturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N° Ingreso", "C° Producto", "T° Docto", "N° Docto", "Cliente", "Rut", "Direccion", "Ciudad", "Provincia", "Giro", "Despacho", "Descripcion", "Fecha", "Forma Pago" }));
        jcbx_facturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbx_facturasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jcbx_facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_facturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_facturas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_facturas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jtbl_facturas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta Facturas", jPanel5);

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

    private void txt_ordenventasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ordenventasKeyTyped
        // TODO add your handling code here:
        txt_ordenventas.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_ordenventas.getText());
                txt_ordenventas.setText(cadena);
                repaint();
                filtro_ov();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_ordenventas.getModel());
        jtbl_ordenventas.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_ordenventasKeyTyped

    private void jcbx_ordenventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbx_ordenventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbx_ordenventasActionPerformed

    private void txt_boletasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_boletasKeyTyped
        // TODO add your handling code here:
        txt_boletas.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_boletas.getText());
                txt_boletas.setText(cadena);
                repaint();
                filtro_bol();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_boletas.getModel());
        jtbl_boletas.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_boletasKeyTyped

    private void jcbx_boletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbx_boletasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbx_boletasActionPerformed

    private void txt_facturasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_facturasKeyTyped
        // TODO add your handling code here:
        txt_facturas.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_facturas.getText());
                txt_facturas.setText(cadena);
                repaint();
                filtro_fact();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_facturas.getModel());
        jtbl_facturas.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_facturasKeyTyped

    private void jcbx_facturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbx_facturasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbx_facturasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbx_boletas;
    private javax.swing.JComboBox<String> jcbx_facturas;
    private javax.swing.JComboBox<String> jcbx_ordenventas;
    private javax.swing.JTable jtbl_boletas;
    private javax.swing.JTable jtbl_facturas;
    private javax.swing.JTable jtbl_ordenventas;
    private javax.swing.JTextField txt_boletas;
    private javax.swing.JTextField txt_facturas;
    private javax.swing.JTextField txt_ordenventas;
    // End of variables declaration//GEN-END:variables
}
