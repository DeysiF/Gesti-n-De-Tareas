/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;




public class jPanelListaUsuarios extends javax.swing.JPanel {
    
 /**
 * Constructor del panel de lista de usuarios.
 * 
 * Este constructor inicializa los componentes de la interfaz de usuario
 * y agrega un listener que se activa cuando el panel se muestra. Al 
 * mostrar el panel, se llama al método {@link #cargarUsuariosEnTabla()} 
 * para actualizar la lista de usuarios.
 */ 

    public jPanelListaUsuarios() {
        initComponents();
        // Aquí asegúrate de actualizar la tabla
     // Agrega el ComponentListener para que se ejecute cuando el panel se muestre
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cargarUsuariosEnTabla(); // Llama al método para cargar usuarios
              }
     });
}
    
    /**
 * Carga usuarios desde un archivo en una tabla.
 * 
 * Este método limpia el contenido actual de la tabla y carga usuarios 
 * desde un archivo especificado. Cada usuario se agrega como una nueva 
 * fila en la tabla, incluyendo su ID, correo y nombre. Si ocurre un 
 * error durante la lectura del archivo, se muestra un mensaje de alerta.
 */ 

    public void cargarUsuariosEnTabla() {
    String ruta = "C:\\Users\\hp\\Documents\\2024\\SEGUNDO SEMESTRE\\METODOS Y TALLER DE PROGRAMACION\\Proyecto Netbeans\\Gestion de Tareas\\usuarioscreados.txt"; // Ruta completa al archivo
    DefaultTableModel modelo = (DefaultTableModel) jTableListaUsuarios.getModel();
    modelo.setRowCount(0); // Limpia la tabla

    try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
        String linea;
        int id = 1; // Para la columna "ID"

        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(";"); // Divide por ";"
            if (datos.length >= 4) { // Verifica que la línea tenga suficientes datos
                modelo.addRow(new Object[]{id++, datos[1], datos[2]}); // Agrega Correo y Usuario
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage());
    }
    // Fuerza la validación y repintado
    jTableListaUsuarios.revalidate();
    jTableListaUsuarios.repaint();
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaUsuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEditarUsuarioListaUsuarios = new javax.swing.JButton();
        btnEliminarListaUsuarios = new javax.swing.JButton();
        btnCrearUsuarioListaUsuarios = new javax.swing.JButton();
        txtBuscarListaUsuario = new javax.swing.JTextField();
        btnBuscarUsuarioListaUsuarios = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Lista de Usuarios");

        jTableListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Correo", "Nombre Usuario"
            }
        ));
        jScrollPane1.setViewportView(jTableListaUsuarios);

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(466, 46));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuarios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEditarUsuarioListaUsuarios.setBackground(new java.awt.Color(0, 0, 102));
        btnEditarUsuarioListaUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarUsuarioListaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarUsuarioListaUsuarios.setText("Editar");
        btnEditarUsuarioListaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioListaUsuariosActionPerformed(evt);
            }
        });

        btnEliminarListaUsuarios.setBackground(new java.awt.Color(0, 0, 102));
        btnEliminarListaUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarListaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarListaUsuarios.setText("Eliminar");
        btnEliminarListaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarListaUsuariosActionPerformed(evt);
            }
        });

        btnCrearUsuarioListaUsuarios.setBackground(new java.awt.Color(0, 0, 102));
        btnCrearUsuarioListaUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearUsuarioListaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUsuarioListaUsuarios.setText("Crear Usuario");
        btnCrearUsuarioListaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioListaUsuariosActionPerformed(evt);
            }
        });

        btnBuscarUsuarioListaUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoBuscar.png"))); // NOI18N
        btnBuscarUsuarioListaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioListaUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscarListaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarUsuarioListaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEditarUsuarioListaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarListaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCrearUsuarioListaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarUsuarioListaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscarListaUsuario))
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btnCrearUsuarioListaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarUsuarioListaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarListaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearUsuarioListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioListaUsuariosActionPerformed
            // Obtén la referencia del MenuPrincipal
    MenuPrincipal menuPrincipal = (MenuPrincipal) SwingUtilities.getWindowAncestor(this);
    // Pasamos la referencia de jPanelListaUsuarios a CrearUsuario
    CrearUsuario crearUsuario = new CrearUsuario(menuPrincipal.getjPanelListaUsuarios());
    crearUsuario.setVisible(true);
    }//GEN-LAST:event_btnCrearUsuarioListaUsuariosActionPerformed


    private void btnEliminarListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarListaUsuariosActionPerformed
     int selectedRow = jTableListaUsuarios.getSelectedRow();  // Obtener la fila seleccionada
    if (selectedRow == -1) {  // Si no se ha seleccionado ninguna fila
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para eliminar.");
        return;
    }

    // Obtener el correo del usuario seleccionado (asumiendo que está en la columna 2)
    String correoSeleccionado = (String) jTableListaUsuarios.getValueAt(selectedRow, 1);
    
    // Eliminar la fila de la tabla
    DefaultTableModel modelo = (DefaultTableModel) jTableListaUsuarios.getModel();
    modelo.removeRow(selectedRow);
    
    // Eliminar del archivo
    eliminarUsuarioDelArchivo(correoSeleccionado);
}
   
 /**
 * Elimina un usuario del archivo basado en su correo electrónico.
 * 
 * Este método busca un usuario en un archivo especificado y lo elimina 
 * si se encuentra. Lee el archivo línea por línea y guarda las líneas 
 * que no corresponden al correo electrónico proporcionado en una lista. 
 * Luego, reescribe el archivo con las líneas restantes. Si el usuario 
 * es eliminado correctamente, se muestra un mensaje de confirmación; 
 * de lo contrario, se muestra un mensaje de error.
 * 
 * @param correo El correo electrónico del usuario que se desea eliminar.
*/
private void eliminarUsuarioDelArchivo(String correo) {
    String ruta = "C:\\Users\\hp\\Documents\\2024\\SEGUNDO SEMESTRE\\METODOS Y TALLER DE PROGRAMACION\\Proyecto Netbeans\\Gestion de Tareas\\usuarioscreados.txt";  // Ruta completa al archivo
    File archivo = new File(ruta);
    
    // Crear una lista para almacenar las líneas que no se van a eliminar
    List<String> lineasRestantes = new ArrayList<>();
    
    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String linea;
        
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(";");
            if (!datos[1].equals(correo)) {  // Si el correo no es el que se va a eliminar
                lineasRestantes.add(linea);  // Agregar la línea a la lista
            }
        }
        
        // Reescribir el archivo con las líneas restantes
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (String l : lineasRestantes) {
                writer.write(l);
                writer.newLine();
            }
        }

        JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar el usuario: " + e.getMessage());
    }
    }//GEN-LAST:event_btnEliminarListaUsuariosActionPerformed

    private void btnEditarUsuarioListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioListaUsuariosActionPerformed
     // Obtener la fila seleccionada de la tabla
    int filaSeleccionada = jTableListaUsuarios.getSelectedRow();
    
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario para editar.");
        return; // Si no hay fila seleccionada, no hacer nada
    }

    // Obtiene los datos de la fila seleccionada
    String correo = (String) jTableListaUsuarios.getValueAt(filaSeleccionada, 1);
    String usuario = (String) jTableListaUsuarios.getValueAt(filaSeleccionada, 2);
    
    // Llama a la ventana de EditarUsuario pasándole los datos
    EditarUsuario editarUsuario = new EditarUsuario(this, correo, usuario);
    editarUsuario.setVisible(true);
    }//GEN-LAST:event_btnEditarUsuarioListaUsuariosActionPerformed

    private void btnBuscarUsuarioListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioListaUsuariosActionPerformed
       String textoBusqueda = txtBuscarListaUsuario.getText().trim().toLowerCase();

    if (textoBusqueda.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un texto para buscar.");
        jTableListaUsuarios.clearSelection(); // Quita la selección si no hay texto
        return;
    }

    // Obtener el modelo de la tabla
    DefaultTableModel modelo = (DefaultTableModel) jTableListaUsuarios.getModel();
    int totalFilas = modelo.getRowCount();
    boolean encontrado = false;

    // Limpiar selecciones anteriores
    jTableListaUsuarios.clearSelection();

    // Recorrer las filas de la tabla
    for (int i = 0; i < totalFilas; i++) {
        String nombreUsuario = modelo.getValueAt(i, 2).toString().toLowerCase(); // Columna del nombre de usuario
        String correoUsuario = modelo.getValueAt(i, 1).toString().toLowerCase(); // Columna del correo electrónico

        // Si el texto de búsqueda coincide con el nombre de usuario o el correo
        if (nombreUsuario.contains(textoBusqueda) || correoUsuario.contains(textoBusqueda)) {
            jTableListaUsuarios.addRowSelectionInterval(i, i); // Marcar la fila
            encontrado = true;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(this, "No se encontraron usuarios con ese criterio de búsqueda.");
    }
    }//GEN-LAST:event_btnBuscarUsuarioListaUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarUsuarioListaUsuarios;
    private javax.swing.JButton btnCrearUsuarioListaUsuarios;
    private javax.swing.JButton btnEditarUsuarioListaUsuarios;
    private javax.swing.JButton btnEliminarListaUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaUsuarios;
    private javax.swing.JTextField txtBuscarListaUsuario;
    // End of variables declaration//GEN-END:variables

    
}
