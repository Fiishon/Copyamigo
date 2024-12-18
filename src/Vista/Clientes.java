
package Vista;

import Modelo.Clientesclass;
import Conexion.Conexion;
import Modelo.Filtronumeros;
import Modelo.Letraseditor;
import Modelo.Numeroseditor;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Clientes extends javax.swing.JPanel {

    // Modelo de tabla para mostrar datos de clientes
    private DefaultTableModel modelo;

    public Clientes() {
        // Inicializa los componentes de la interfaz gráfica
        initComponents();
        
        // Crea el modelo de tabla y define las columnas para los datos de clientes
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");        // Columna para el nombre del cliente
        modelo.addColumn("Apellidos");     // Columna para los apellidos del cliente
        modelo.addColumn("Celular");       // Columna para el número de celular
        modelo.addColumn("RFC");           // Columna para el RFC
        modelo.addColumn("Correo");        // Columna para el correo electrónico
        
        // Asigna el modelo de tabla a la tabla Tablaclientes
        Tablaclientes.setModel(modelo);
        
        // Llama al método para llenar la tabla con datos de clientes
        llenarTabla();
        
        // Llama al método para personalizar el diseño de la tabla
        tabladiseño();
    }

    private void tabladiseño() {
        // Asigna editores personalizados a las columnas para restringir el tipo de entrada
        Tablaclientes.getColumnModel().getColumn(0).setCellEditor(new Letraseditor()); // Solo letras en columna Nombre
        Tablaclientes.getColumnModel().getColumn(1).setCellEditor(new Letraseditor()); // Solo letras en columna Apellidos
        Tablaclientes.getColumnModel().getColumn(2).setCellEditor(new Numeroseditor()); // Solo números en columna Celular

        // Ajusta el ancho máximo de cada columna para mejorar la presentación
        if (Tablaclientes.getColumnModel().getColumnCount() > 0) {
            Tablaclientes.getColumnModel().getColumn(0).setMaxWidth(110); // Máximo ancho para Nombre
            Tablaclientes.getColumnModel().getColumn(1).setMaxWidth(150); // Máximo ancho para Apellidos
            Tablaclientes.getColumnModel().getColumn(2).setMaxWidth(120); // Máximo ancho para Celular
            Tablaclientes.getColumnModel().getColumn(3).setMaxWidth(160); // Máximo ancho para RFC
            Tablaclientes.getColumnModel().getColumn(4).setMaxWidth(220); // Máximo ancho para Correo
            
            // Ajusta la altura de cada fila para una visualización más clara
            Tablaclientes.setRowHeight(30);
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tablaclientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtregclicelularbusqueda = new javax.swing.JTextField();
        BtnNuevo = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        Btnactualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(54, 170, 219));

        Tablaclientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
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
        Tablaclientes.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(Tablaclientes);
        Tablaclientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (Tablaclientes.getColumnModel().getColumnCount() > 0) {
            Tablaclientes.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        jLabel1.setText("Registro de Clientes");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtregclicelularbusqueda.setBackground(new java.awt.Color(204, 255, 255));
        txtregclicelularbusqueda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtregclicelularbusqueda.setText("Numero a buscar");
        txtregclicelularbusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtregclicelularbusquedaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtregclicelularbusquedaFocusLost(evt);
            }
        });

        BtnNuevo.setBackground(new java.awt.Color(204, 255, 204));
        BtnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnModificar.setBackground(new java.awt.Color(255, 255, 153));
        BtnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnModificar.setForeground(new java.awt.Color(0, 0, 0));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        BtnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        Btnactualizar.setBackground(new java.awt.Color(153, 255, 204));
        Btnactualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btnactualizar.setForeground(new java.awt.Color(0, 0, 0));
        Btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar-flecha.png"))); // NOI18N
        Btnactualizar.setText("Actualizar");
        Btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnactualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(Btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(txtregclicelularbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtregclicelularbusqueda)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        txtregclicelularbusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTablabus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTablabus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTablabus();
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
       // Obtiene la fila seleccionada en la tabla Tablaclientes
        int selectedRow = Tablaclientes.getSelectedRow();
        if (selectedRow != -1) {  // Extrae los datos del cliente de la fila seleccionada
            String nombre = (String) modelo.getValueAt(selectedRow, 0);
            String apellidos = (String) modelo.getValueAt(selectedRow, 1);
            String celular = (String) modelo.getValueAt(selectedRow, 2);
            String rfc = (String) modelo.getValueAt(selectedRow, 3);
            String correo = (String) modelo.getValueAt(selectedRow, 4);
            
            // Crea una instancia de Clientesclass para almacenar los datos del cliente
            Clientesclass cliente = new Clientesclass();
            cliente.setNombre(nombre);
            cliente.setApellidos(apellidos);
            cliente.setCelular(celular);
            cliente.setRfc(rfc);
            cliente.setCorreo(correo);

           
        // Llama al método para actualizar el cliente en la base de datos
        actualizarClienteBD(cliente);
    } else {
        // Muestra un mensaje si no hay una fila seleccionada
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.");
        }
        
        
    }//GEN-LAST:event_BtnModificarActionPerformed
    
    public void actualizarClienteBD(Clientesclass cliente) {
    // Crea una conexión a la base de datos
    Conexion conex = new Conexion();
    
    // Consulta SQL para actualizar el registro de un cliente en la base de datos
    String consulta = "UPDATE Cliente SET Nombre = ?, Apellidos = ?, RFC = ?, Correo = ? WHERE Celular = ?";
    
    try (
        // Prepara la consulta para su ejecución
        PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
        
        // Establece los parámetros de la consulta con los datos del cliente
        pst.setString(1, cliente.getNombre());
        pst.setString(2, cliente.getApellidos());
        pst.setString(3, cliente.getRfc());
        pst.setString(4, cliente.getCorreo());
        pst.setString(5, cliente.getCelular());
        
        // Ejecuta la actualización en la base de datos
        pst.executeUpdate();
        
        // Muestra un mensaje de éxito al usuario
        JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito !!!");
    } catch (SQLException e) {
        // Muestra un mensaje de error en caso de fallo
        JOptionPane.showMessageDialog(null, "Error al modificar cliente: " + e.toString());
    }
}

    
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
       // Obtiene la fila seleccionada en la tabla Tablaclientes
    int selectedRow = Tablaclientes.getSelectedRow();

    if (selectedRow != -1) { // Verifica si hay una fila seleccionada
        // Obtiene el número de celular del cliente seleccionado para identificar el registro en la base de datos
        String celular = (String) modelo.getValueAt(selectedRow, 2);

        // Llama al método para eliminar el cliente de la base de datos usando el celular como identificador
        eliminarClienteBD(celular);

        // Elimina la fila de la tabla en la interfaz gráfica
        modelo.removeRow(selectedRow);
    } else {
        // Muestra un mensaje si no hay una fila seleccionada
        JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
    }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
         
    // Se abre la venta de Registro Cleintes   
     RegistroClientes  regi = new RegistroClientes();
     
     regi.setVisible(true);
     
     
    }//GEN-LAST:event_BtnNuevoActionPerformed

    /**
 * Evento que se ejecuta cuando el campo de texto txtregclicelularbusqueda gana el foco.
 * Si el texto es el valor por defecto "Numero a buscar", lo limpia y cambia el color de texto a negro.
 * También aplica un filtro para restringir la entrada a solo números.
 * 
 * @param evt Evento de foco ganado.
 */
    private void txtregclicelularbusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregclicelularbusquedaFocusGained
        if (txtregclicelularbusqueda.getText().equals("Numero a buscar")){
        txtregclicelularbusqueda.setText("");
        txtregclicelularbusqueda.setForeground(Color.black);
        
        PlainDocument doc = (PlainDocument)  txtregclicelularbusqueda.getDocument();
        doc.setDocumentFilter(new Filtronumeros());
       }
    }//GEN-LAST:event_txtregclicelularbusquedaFocusGained

    /**
 * Evento que se ejecuta cuando el campo de texto txtregclicelularbusqueda pierde el foco.
 * Si el campo está vacío, restaura el texto por defecto "Numero a buscar" y cambia el color a gris.
 * 
 * @param evt Evento de foco perdido.
 */
    private void txtregclicelularbusquedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregclicelularbusquedaFocusLost
         if (txtregclicelularbusqueda.getText().isEmpty()){
        txtregclicelularbusqueda.setForeground(new Color(204, 204, 204));
        txtregclicelularbusqueda.setText("Numero a buscar");
        }
    }//GEN-LAST:event_txtregclicelularbusquedaFocusLost

    /**
 * Acción ejecutada al hacer clic en el botón Btnactualizar.
 * Llama al método actualizarTabla para recargar los datos en la tabla.
 * 
 * @param evt Evento de acción sobre el botón.
 */
    private void BtnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnactualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_BtnactualizarActionPerformed
    
     /**
 * Llena la tabla de clientes con datos obtenidos desde la base de datos.
 * Recorre la lista de clientes y agrega una fila en la tabla para cada cliente.
 */
private void llenarTabla() {
    Clientesclass clientee = new Clientesclass();
    List<Clientesclass> clientes = clientee.obtenerClientes();
    
    for (Clientesclass cliente : clientes) {
        Object[] fila = new Object[5];
        fila[0] = cliente.getNombre();
        fila[1] = cliente.getApellidos();
        fila[2] = cliente.getCelular();
        fila[3] = cliente.getRfc();
        fila[4] = cliente.getCorreo();
        modelo.addRow(fila);
    }
}

/**
 * Elimina un cliente de la base de datos usando su número de celular como identificador.
 * 
 * @param celular Número de celular del cliente a eliminar.
 */
private void eliminarClienteBD(String celular) {
    Conexion conex = new Conexion();
    String consulta = "DELETE FROM Cliente WHERE Celular = ?";
    try (PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
        pst.setString(1, celular);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Cliente Eliminado Con Exito !!!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.toString());
    }
}

/**
 * Actualiza la tabla de clientes. Borra los datos actuales y rellena la tabla con información actualizada desde la base de datos.
 */
public void actualizarTabla() {
    modelo.setRowCount(0); // Limpiar la tabla
    
    Clientesclass clientee = new Clientesclass();
    List<Clientesclass> clientes = clientee.obtenerClientes();
    
    for (Clientesclass cliente : clientes) {
        Object[] fila = new Object[5];
        fila[0] = cliente.getNombre();
        fila[1] = cliente.getApellidos();
        fila[2] = cliente.getCelular();
        fila[3] = cliente.getRfc();
        fila[4] = cliente.getCorreo();
        modelo.addRow(fila);
    }
}

/**
 * Actualiza la tabla de clientes según el texto de búsqueda ingresado.
 * Filtra clientes en la base de datos que coincidan con el número ingresado en txtregclicelularbusqueda y actualiza la tabla.
 */
private void actualizarTablabus() {
    String textoBusqueda = txtregclicelularbusqueda.getText();
    modelo.setRowCount(0); // Limpia la tabla
    
    Clientesclass clientee = new Clientesclass();
    List<Clientesclass> clientes = clientee.obtenerClientesPorNumero(textoBusqueda);
    
    for (Clientesclass cliente : clientes) {
        Object[] fila = new Object[5];
        fila[0] = cliente.getNombre();
        fila[1] = cliente.getApellidos();
        fila[2] = cliente.getCelular();
        fila[3] = cliente.getRfc();
        fila[4] = cliente.getCorreo();
        modelo.addRow(fila);
    }
}

/**
 * Ajusta la interfaz de usuario según el rol del usuario.
 * Si el rol es "Estandar", desactiva los botones de modificación y eliminación de clientes.
 * Si el rol es otro, habilita estos botones.
 * 
 * @param rol El rol del usuario actual.
 */
public void ajustarInterfazSegunRol(String rol) {
    if ("Estandar".equals(rol)) {
        BtnModificar.setEnabled(false);
        BtnEliminar.setEnabled(false);
    } else {
        BtnModificar.setEnabled(true);
        BtnEliminar.setEnabled(true);
    }
}
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnEliminar;
    public javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton Btnactualizar;
    private javax.swing.JTable Tablaclientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtregclicelularbusqueda;
    // End of variables declaration//GEN-END:variables
}
