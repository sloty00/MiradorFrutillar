/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maquinaria;
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
public class Maquinaria_C extends javax.swing.JInternalFrame {
    private TableRowSorter trsFiltro;
    DefaultTableModel model;
    Conexion.conexion conexion = new Conexion.conexion();
    Connection cn = conexion.connect();
    Statement sent;
    /**
     * Creates new form Maquinaria_C
     */
    public Maquinaria_C() {
        initComponents();
        llenar_rentamaq();
        llenar_adquisicionmaq();
    }
    
    void llenar_rentamaq() {
        try {
            cn = conexion.connect();
            String [] titulos = {"N° Folio","T° Vehiculo","Marca","Modelo","Año","Patente","N° Chasis", "Nombre", "Giro","Direccion","Ciudad","Telefono","E-mail","Desde","Hasta","Tipo","Precio Arriendo"};
            String sql = "SELECT num_folio, patente, giro, nombre, direccion, ciudad, telefono, email, desde, hasta, precio_arriendo, tipo_vehiculo, marca, modelo, año, num_chasis, tipo FROM `maquinas` where tipo = \"Arriendo\"";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [17];
            while (rs.next()){
                fila[0]=rs.getString("num_folio");
                fila[1]=rs.getString("tipo_vehiculo");
                fila[2]=rs.getString("marca");
                fila[3]=rs.getString("modelo");
                fila[4]=rs.getString("año");
                fila[5]=rs.getString("patente");
                fila[6]=rs.getString("num_chasis");
                fila[7]=rs.getString("nombre");
                fila[8]=rs.getString("giro");
                fila[9]=rs.getString("direccion");
                fila[10]=rs.getString("ciudad");
                fila[11]=rs.getString("telefono");
                fila[12]=rs.getString("email");
                fila[13]=rs.getString("desde");
                fila[14]=rs.getString("hasta");
                fila[15]=rs.getString("tipo");
                fila[16]=rs.getString("precio_arriendo");
            model.addRow(fila);
            }
            jtbl_maqarriendo.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void llenar_adquisicionmaq() {
        try {
            cn = conexion.connect();
            String [] titulos = {"N° Folio","T° Vehiculo","Marca","Modelo","Año","Patente","N° Chasis","Fecha Adquisicion","Km Inicial","Vida Util","Tipo","Valor"};
            String sql = "SELECT num_folio, patente, tipo_vehiculo, marca, modelo, año, num_chasis, fecha_ad, km_inicial, vida_util, tipo, valor FROM `maquinas` where tipo = \"Adquisicion\"";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String [] fila = new String [12];
            while (rs.next()){
                fila[0]=rs.getString("num_folio");
                fila[1]=rs.getString("tipo_vehiculo");
                fila[2]=rs.getString("marca");
                fila[3]=rs.getString("modelo");
                fila[4]=rs.getString("año");
                fila[5]=rs.getString("patente");
                fila[6]=rs.getString("num_chasis");
                fila[7]=rs.getString("fecha_ad");
                fila[8]=rs.getString("km_inicial");
                fila[9]=rs.getString("vida_util");
                fila[10]=rs.getString("tipo");
                fila[11]=rs.getString("valor");
            model.addRow(fila);
            }
            jtbl_maqadquiridas.setModel(model);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void filtro_adquisi() {
        
        int columnaABuscar = 0;
        if (jcbx_maqadquiridas.getSelectedItem() == "N° Folio") {
            columnaABuscar = 0;
        }
        if (jcbx_maqadquiridas.getSelectedItem().toString() == "T° Vehiculo") {
            columnaABuscar = 1;
        }
        if (jcbx_maqadquiridas.getSelectedItem() == "Marca") {
            columnaABuscar = 2;
        }
        if (jcbx_maqadquiridas.getSelectedItem() == "Modelo") {
            columnaABuscar = 3;
        }
        if (jcbx_maqadquiridas.getSelectedItem() == "Año") {
            columnaABuscar = 4;
        }
        if (jcbx_maqadquiridas.getSelectedItem() == "Patente") {
            columnaABuscar = 5;
        }
        if (jcbx_maqadquiridas.getSelectedItem() == "N° Chasis") {
            columnaABuscar = 6;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_maqadquiridas.getText(), columnaABuscar));
    }
    
    public void filtro_arriendo() {
        
        int columnaABuscar = 0;
        if (jcbx_maqarriendo.getSelectedItem() == "N° Folio") {
            columnaABuscar = 0;
        }
        if (jcbx_maqarriendo.getSelectedItem().toString() == "T° Vehiculo") {
            columnaABuscar = 1;
        }
        if (jcbx_maqarriendo.getSelectedItem() == "Marca") {
            columnaABuscar = 2;
        }
        if (jcbx_maqarriendo.getSelectedItem() == "Modelo") {
            columnaABuscar = 3;
        }
        if (jcbx_maqarriendo.getSelectedItem() == "Año") {
            columnaABuscar = 4;
        }
        if (jcbx_maqarriendo.getSelectedItem() == "Patente") {
            columnaABuscar = 5;
        }
        if (jcbx_maqarriendo.getSelectedItem() == "N° Chasis") {
            columnaABuscar = 6;
        }
        if (jcbx_maqarriendo.getSelectedItem() == "Giro") {
            columnaABuscar = 8;
        }
        if (jcbx_maqarriendo.getSelectedItem() == "Ciudad") {
            columnaABuscar = 10;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txt_maqarriendo.getText(), columnaABuscar));
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
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_maqarriendo = new javax.swing.JTextField();
        jcbx_maqarriendo = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbl_maqarriendo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_maqadquiridas = new javax.swing.JTextField();
        jcbx_maqadquiridas = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbl_maqadquiridas = new javax.swing.JTable();

        setBackground(java.awt.SystemColor.activeCaption);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de Maquinas");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Principal/images/maquinaria1.png"))); // NOI18N
        jLabel1.setText("Consulta de Maquinas");

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

        jPanel10.setBackground(java.awt.SystemColor.activeCaption);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("BUSQUEDA:");

        txt_maqarriendo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_maqarriendo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_maqarriendoKeyTyped(evt);
            }
        });

        jcbx_maqarriendo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_maqarriendo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N° Folio", "T° Vehiculo", "Marca", "Modelo", "Año", "Patente", "N° Chasis", "Giro", "Ciudad" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jcbx_maqarriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_maqarriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_maqarriendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_maqarriendo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_maqarriendo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_maqarriendo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jtbl_maqarriendo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 199, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Maquinas en Arriendo", jPanel3);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);

        jPanel11.setBackground(java.awt.SystemColor.activeCaption);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("BUSQUEDA:");

        txt_maqadquiridas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_maqadquiridas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_maqadquiridasKeyTyped(evt);
            }
        });

        jcbx_maqadquiridas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbx_maqadquiridas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N° Folio", "T° Vehiculo", "Marca", "Modelo", "Año", "Patente", "N° Chasis" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jcbx_maqadquiridas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_maqadquiridas, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_maqadquiridas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbx_maqadquiridas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jtbl_maqadquiridas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtbl_maqadquiridas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jtbl_maqadquiridas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 199, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Maquinas Adquiridas", jPanel4);

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

    private void txt_maqarriendoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_maqarriendoKeyTyped
        // TODO add your handling code here:
        txt_maqarriendo.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_maqarriendo.getText());
                txt_maqarriendo.setText(cadena);
                repaint();
                filtro_arriendo();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_maqarriendo.getModel());
        jtbl_maqarriendo.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txt_maqarriendoKeyTyped

    private void txt_maqadquiridasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_maqadquiridasKeyTyped
        // TODO add your handling code here:
        txt_maqadquiridas.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txt_maqadquiridas.getText());
                txt_maqadquiridas.setText(cadena);
                repaint();
                filtro_adquisi();
            }
        });
        trsFiltro = new TableRowSorter(jtbl_maqadquiridas.getModel());
        jtbl_maqadquiridas.setRowSorter(trsFiltro);        
    }//GEN-LAST:event_txt_maqadquiridasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbx_maqadquiridas;
    private javax.swing.JComboBox<String> jcbx_maqarriendo;
    private javax.swing.JTable jtbl_maqadquiridas;
    private javax.swing.JTable jtbl_maqarriendo;
    private javax.swing.JTextField txt_maqadquiridas;
    private javax.swing.JTextField txt_maqarriendo;
    // End of variables declaration//GEN-END:variables
}
