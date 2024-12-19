/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Clase EditarTarea que permite editar una tarea existente en el sistema.
 * Proporciona una interfaz gráfica para modificar los detalles de una tarea.
 * 
 * @author MI EQUIPO
 */
public class EditarTarea extends javax.swing.JFrame {
    private jPanelListaTareas panelListaTareas; // Referencia al panel
    private String nombreUsuario;
    private String nombreTarea;
    private String descripcion;
    private String prioridad;
    private String estado;
    /**
     * Crea una nueva instancia de EditarTarea con configuración inicial.
     */
    public EditarTarea() {
        initComponents();
        setLocationRelativeTo(null);
    }
    /**
     * Constructor que inicializa los datos de la tarea a editar.
     *
     * @param panelListaTareas Panel principal que muestra la lista de tareas.
     * @param nombreUsuario Nombre del usuario asignado a la tarea.
     * @param nombreTarea Nombre de la tarea a editar.
     * @param descripcion Descripción de la tarea.
     * @param prioridad Prioridad asignada a la tarea.
     * @param estado Estado actual de la tarea.
     * @param fechaInicio Fecha de inicio de la tarea.
     * @param fechaFin Fecha de finalización de la tarea.
     */
public EditarTarea(jPanelListaTareas panelListaTareas, String nombreUsuario, String nombreTarea, 
                   String descripcion, String prioridad, String estado, 
                   String fechaInicio, String fechaFin) {
    initComponents();
    setLocationRelativeTo(null);
    this.panelListaTareas = panelListaTareas;  // Asignamos la referencia del panel
    this.nombreUsuario = nombreUsuario;
    this.nombreTarea = nombreTarea;
    this.descripcion = descripcion;
    this.prioridad = prioridad;
    this.estado = estado;

    // Llamamos a cargar los usuarios en el comboBox
    cargarUsuariosEnComboBox();

    // Rellenar los campos con los valores recibidos
    cmbUsuariosEditarTarea.setSelectedItem(nombreUsuario);
    txtNombreEditarTarea.setText(nombreTarea);
    txtDescripcionEditarTarea.setText(descripcion);
    boxPrioridadEditarTarea.setSelectedItem(prioridad);
    boxEstadoEditarTarea.setSelectedItem(estado);
    
    // Rellenar los nuevos campos de fecha
    txtFechaInicioEditarTarea.setText(fechaInicio);
    txtFechaFinEditarTarea.setText(fechaFin);
    }
    /**
     * Carga los usuarios registrados en el archivo en el ComboBox.
     */
    private void cargarUsuariosEnComboBox() {
        // Leer los usuarios desde el archivo y obtener la lista de usuarios
        List<String> listaUsuarios = obtenerUsuariosDesdeArchivo();
        
        // Limpiar el ComboBox y agregar los usuarios
        cmbUsuariosEditarTarea.removeAllItems();
        for (String usuario : listaUsuarios) {
            cmbUsuariosEditarTarea.addItem(usuario);
        }
    }

    /**
     * Lee el archivo de tareas y devuelve una lista de usuarios únicos.
     * 
     * @return Lista de usuarios registrados en el archivo.
     */
    private List<String> obtenerUsuariosDesdeArchivo() {
        List<String> usuarios = new ArrayList<>();
        String rutaArchivo = "C:\\Users\\hp\\Documents\\2024\\SEGUNDO SEMESTRE\\METODOS Y TALLER DE PROGRAMACION\\Proyecto Netbeans\\Gestion de Tareas\\tareas.txt";  // Ruta de tu archivo
        
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Se supone que el archivo tiene un formato: usuario;nombreTarea;descripcion;prioridad;estado
                String[] datosTarea = linea.split(";");
                String usuario = datosTarea[0];  // El primer campo es el usuario
                if (!usuarios.contains(usuario)) {  // Evitar duplicados
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage());
        }
        return usuarios;
    }
    
    /**
     * Configura el panel principal que contiene la lista de tareas.
     * 
     * @param panelListaTareas Panel principal a establecer.
     */
         
    public void setPanelListaTareas(jPanelListaTareas panelListaTareas) {
    this.panelListaTareas = panelListaTareas;
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
        jLabel6 = new javax.swing.JLabel();
        cmbUsuariosEditarTarea = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxPrioridadEditarTarea = new javax.swing.JComboBox<>();
        txtNombreEditarTarea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        boxEstadoEditarTarea = new javax.swing.JComboBox<>();
        btnEditarTarea = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSalirCrearTarea = new javax.swing.JButton();
        txtDescripcionEditarTarea = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFechaInicioEditarTarea = new javax.swing.JTextField();
        txtFechaFinEditarTarea = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Estado:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 511, 87, 27));

        jPanel1.add(cmbUsuariosEditarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 186, 147, 34));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Usuario:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 155, 77, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Nombre de la tarea:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 226, -1, 26));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Editar Tarea");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 35, -1, 37));

        boxPrioridadEditarTarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baja", "Media", "Alta" }));
        jPanel1.add(boxPrioridadEditarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 544, 84, 33));

        txtNombreEditarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEditarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreEditarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 264, 468, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Datos de la tarea");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 90, -1, 36));

        boxEstadoEditarTarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por Hacer", "En Proceso", "Terminado" }));
        jPanel1.add(boxEstadoEditarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 544, -1, 32));

        btnEditarTarea.setBackground(new java.awt.Color(0, 0, 102));
        btnEditarTarea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditarTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarTarea.setText("Editar Tarea");
        btnEditarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 615, 165, 47));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Descripción:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 312, 131, -1));

        btnSalirCrearTarea.setBackground(new java.awt.Color(0, 0, 102));
        btnSalirCrearTarea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalirCrearTarea.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirCrearTarea.setText("Salir");
        btnSalirCrearTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirCrearTareaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalirCrearTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 617, 98, 47));
        jPanel1.add(txtDescripcionEditarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 343, 299, 150));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Prioridad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 511, 84, 27));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Fecha Inicio:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 358, -1, -1));

        txtFechaInicioEditarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioEditarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaInicioEditarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 401, 96, -1));
        jPanel1.add(txtFechaFinEditarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 401, 86, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("Fecha Fin:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 358, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreEditarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEditarTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEditarTareaActionPerformed
    
    /**
     * Evento que gestiona el botón para editar una tarea.
     * Verifica los datos ingresados, actualiza el archivo y la tabla.
     * 
     * @param evt Evento de acción.
     */
    private void btnEditarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTareaActionPerformed
  // Obtener los nuevos datos desde los campos
    String nuevoUsuario = (String) cmbUsuariosEditarTarea.getSelectedItem();
    String nuevoNombreTarea = txtNombreEditarTarea.getText();
    String nuevaDescripcion = txtDescripcionEditarTarea.getText();
    String nuevaPrioridad = (String) boxPrioridadEditarTarea.getSelectedItem();
    String nuevoEstado = (String) boxEstadoEditarTarea.getSelectedItem();
    String nuevaFechaInicio = txtFechaInicioEditarTarea.getText(); // Nuevo campo
    String nuevaFechaFin = txtFechaFinEditarTarea.getText();       // Nuevo campo

    // Verifica que todos los campos estén completos
    if (nuevoUsuario.isEmpty() || nuevoNombreTarea.isEmpty() || nuevaDescripcion.isEmpty() || nuevaFechaInicio.isEmpty() || nuevaFechaFin.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        return;
    }

    // Ruta al archivo de tareas
    String rutaArchivo = "C:\\Users\\hp\\Documents\\2024\\SEGUNDO SEMESTRE\\METODOS Y TALLER DE PROGRAMACION\\Proyecto Netbeans\\Gestion de Tareas\\tareas.txt";
    File archivo = new File(rutaArchivo);
    StringBuilder nuevoContenido = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String linea;
        boolean tareaEditada = false;

        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(";");

            // Comparar con los valores originales (nombreUsuario y nombreTarea)
            if (datos.length >= 7 && datos[0].equals(this.nombreUsuario) && datos[1].equals(this.nombreTarea)) {
                // Reemplaza la línea con los nuevos datos
                nuevoContenido.append(nuevoUsuario).append(";")
                        .append(nuevoNombreTarea).append(";")
                        .append(nuevaDescripcion).append(";")
                        .append(nuevaPrioridad).append(";")
                        .append(nuevoEstado).append(";")
                        .append(nuevaFechaInicio).append(";") // Nueva fecha inicio
                        .append(nuevaFechaFin).append("\n");  // Nueva fecha fin
                tareaEditada = true;
            } else {
                nuevoContenido.append(linea).append("\n");  // Escribe las líneas sin cambios
            }
        }

        // Verifica si se encontró la tarea para editar
        if (!tareaEditada) {
            JOptionPane.showMessageDialog(this, "Tarea no encontrada.");
            return;
        }

        // Sobrescribir el archivo original con el nuevo contenido
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(nuevoContenido.toString());
        }

        // Actualiza la tabla en jPanelListaTareas
        SwingUtilities.invokeLater(() -> {
            panelListaTareas.cargarTareasEnTabla(); // Actualiza la tabla
        });

        // Cierra la ventana de edición
        this.dispose();
        JOptionPane.showMessageDialog(this, "Tarea editada con éxito.");

    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al editar la tarea: " + e.getMessage());
    }
    }//GEN-LAST:event_btnEditarTareaActionPerformed

    private void btnSalirCrearTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirCrearTareaActionPerformed
        this.dispose(); // Cierra la ventana de CrearUsuario
    }//GEN-LAST:event_btnSalirCrearTareaActionPerformed

    private void txtFechaInicioEditarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioEditarTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioEditarTareaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxEstadoEditarTarea;
    private javax.swing.JComboBox<String> boxPrioridadEditarTarea;
    private javax.swing.JButton btnEditarTarea;
    private javax.swing.JButton btnSalirCrearTarea;
    private javax.swing.JComboBox<String> cmbUsuariosEditarTarea;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescripcionEditarTarea;
    private javax.swing.JTextField txtFechaFinEditarTarea;
    private javax.swing.JTextField txtFechaInicioEditarTarea;
    private javax.swing.JTextField txtNombreEditarTarea;
    // End of variables declaration//GEN-END:variables
}
