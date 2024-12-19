/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Login;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MI EQUIPO
 */
public class jPanelListaTareas extends javax.swing.JPanel {

 /**
 * Constructor del panel de lista de tareas.
 * 
 * Este constructor inicializa los componentes de la interfaz de usuario 
 * y carga las tareas en la tabla al iniciar el panel. También se encarga 
 * de cargar los usuarios en un combo box, configurar colores según la 
 * prioridad y el estado de las tareas, y personalizar los colores de 
 * selección.
 */

    public jPanelListaTareas() {
        initComponents();
        cargarTareasEnTabla(); // Carga las tareas al iniciar el panel
        cargarUsuariosEnComboBox();
        configurarColoresDePrioridad();
        configurarColoresDeEstado();
        personalizarColoresSeleccion();
         
        
    }
    
    /**
 * Carga tareas desde un archivo en una tabla.
 * 
 * Este método lee un archivo de tareas y carga su contenido en una tabla. 
 * Primero, limpia las filas existentes de la tabla y luego lee el archivo 
 * línea por línea, separando los datos por punto y coma. Si una línea 
 * contiene la cantidad correcta de datos, se añade una nueva fila al modelo 
 * de la tabla, incluyendo un ID autoincrementable. Si ocurre un error 
 * durante la lectura del archivo, se muestra un mensaje de error.
 */

 public void cargarTareasEnTabla() {
    // Ruta del archivo
    String ruta = "C:\\Users\\hp\\Documents\\2024\\SEGUNDO SEMESTRE\\METODOS Y TALLER DE PROGRAMACION\\Proyecto Netbeans\\Gestion de Tareas\\tareas.txt";

    // Modelo de la tabla
    DefaultTableModel modelo = (DefaultTableModel) tblListaTareas.getModel();
    modelo.setRowCount(0); // Limpiar las filas existentes

    int id = 1; // ID autoincrementable inicializado en 1

    // Leer el archivo de tareas
    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
        String linea;

        // Leer cada línea del archivo
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";"); // Separar los datos por ";"

            // Verificar que la línea tenga la cantidad correcta de datos
            if (datos.length == 7) {
                String usuario = datos[0];
                String nombreTarea = datos[1];
                String descripcion = datos[2];
                String prioridad = datos[3];
                String estado = datos[4];
                String fechaInicio = datos[5];
                String fechaFin = datos[6];

                // Añadir la fila al modelo de la tabla, incluyendo el ID autoincrementable
                modelo.addRow(new Object[]{id, usuario, nombreTarea, descripcion, prioridad, estado, fechaInicio, fechaFin});
                id++; // Incrementar el ID para la siguiente fila
            }
        }
    } catch (IOException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar las tareas: " + e.getMessage());
    }
}
 
/**
 * Carga usuarios desde un archivo en un ComboBox.
 * 
 * Este método limpia los elementos actuales del ComboBox y lee un archivo 
 * de usuarios. Para cada línea leída, se separan los datos por punto y 
 * coma, y si el nombre del usuario (columna 2) no está vacío, se añade 
 * al ComboBox. Si ocurre un error durante la lectura del archivo, se 
 * muestra un mensaje de error.
 */

private void cargarUsuariosEnComboBox() {
    boxUsuariosListaTareasP.removeAllItems(); // Limpiar el ComboBox antes de cargar nuevos usuarios
    String ruta = "C:\\Users\\hp\\Documents\\2024\\SEGUNDO SEMESTRE\\METODOS Y TALLER DE PROGRAMACION\\Proyecto Netbeans\\Gestion de Tareas\\usuarioscreados.txt"; // Ruta del archivo de usuarios

    try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
        String linea;

        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(";"); // Divide la línea por ";"
            
            if (datos.length >= 4) { // Asegúrate de que haya al menos 4 campos
                String nombreUsuario = datos[2].trim(); // Suponiendo que el nombre de usuario está en la columna 2
                if (!nombreUsuario.isEmpty()) {
                    boxUsuariosListaTareasP.addItem(nombreUsuario); // Añadir al ComboBox
                }
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los usuarios: " + e.getMessage());
    }
}
/**
 * Configura los colores de la columna de estado en la tabla de tareas.
 * 
 * Este método establece un renderer personalizado para la columna de 
 * estado de la tabla. Dependiendo del valor del estado ("Por Hacer", 
 * "En Proceso" o "Terminado"), se asigna un color de fondo específico 
 * a la celda. Si el valor no coincide con ninguno de estos, se establece 
 * el color de fondo en blanco.
 */
private void configurarColoresDePrioridad() {
    DefaultTableModel modelo = (DefaultTableModel) tblListaTareas.getModel();

    // Establecemos un renderer para la columna de prioridad (asumiendo que es la columna 4)
    tblListaTareas.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Llamamos al renderer base
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Si el valor es "Baja", "Media" o "Alta", cambiamos el color
            if (value != null) {
                String prioridad = value.toString().toLowerCase(); // Convertimos el valor a minúsculas para compararlo

                // Asignar color según la prioridad
                if (prioridad.equals("baja")) {
                    comp.setBackground(new Color(144, 238, 144)); // Verde suave para baja
                } else if (prioridad.equals("media")) {
                    comp.setBackground(new Color(255, 255, 102)); // Amarillo suave para media
                } else if (prioridad.equals("alta")) {
                    comp.setBackground(new Color(255, 102, 102)); // Rojo suave para alta
                } else {
                    comp.setBackground(Color.WHITE); // Blanco por defecto si no coincide con ninguno
                }
            }

            return comp;
        }
    });
}

/**
 * Personaliza los colores de estado en la tabla de tareas.
 * 
 * Este método establece un color de fondo y un color de primer plano 
 * para las filas seleccionadas en la tabla. El fondo se configura 
 * con un color lila suave, mientras que el texto se establece en 
 * color negro para mejorar la visibilidad.
 */
private void configurarColoresDeEstado() {
    DefaultTableModel modelo = (DefaultTableModel) tblListaTareas.getModel();

    // Establecemos un renderer para la columna de estado (asumiendo que es la columna 5)
    tblListaTareas.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Llamamos al renderer base
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Si el valor es "Por Hacer", "En Proceso" o "Terminado", cambiamos el color
            if (value != null) {
                String estado = value.toString().toLowerCase(); // Convertimos el valor a minúsculas para compararlo

                // Asignar color según el estado
                if (estado.equals("por hacer")) {
                    
                    comp.setBackground(new Color(255, 102, 102));// Verde suave para "Por Hacer"
                } else if (estado.equals("en proceso")) {
                    comp.setBackground(new Color(255, 255, 102)); // Amarillo suave para "En Proceso"
                } else if (estado.equals("terminado")) {
                    comp.setBackground(new Color(144, 238, 144)); // Rojo suave para "Terminado"
                } else {
                    comp.setBackground(Color.WHITE); // Blanco por defecto si no coincide con ninguno
                }
            }

            return comp;
        }
    });
}
// Método para configurar el renderer de la tabla y cambiar el color de selección
private void personalizarColoresSeleccion() {
    tblListaTareas.setSelectionBackground(new Color(204, 204, 255)); // Fondo suave para la fila seleccionada (lila suave)
    tblListaTareas.setSelectionForeground(Color.BLACK); // Color de texto cuando se selecciona la fila
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaTareas = new javax.swing.JTable();
        txtBuscarListaTareas = new javax.swing.JTextField();
        btnBuscarListaTareas = new javax.swing.JButton();
        btnEditarListaTareas = new javax.swing.JButton();
        btnEliminarListaTareas = new javax.swing.JButton();
        btnCrearTareaListaTareas = new javax.swing.JButton();
        boxPrioridadListaTareas = new javax.swing.JComboBox<>();
        boxEstadoListaTareas = new javax.swing.JComboBox<>();
        btnPrioridadBuscarListaTareas = new javax.swing.JButton();
        btnBuscarEstadoListaTareas = new javax.swing.JButton();
        btnActualizarListaTareas = new javax.swing.JButton();
        boxUsuariosListaTareasP = new javax.swing.JComboBox<>();
        btnBuscarUsuariosListaTareasP = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Lista de Tareas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 31, -1, 58));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tareas Asignadas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 207, 636, -1));

        tblListaTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre Usuario", "Nombre de Tarea", "Descripcion", "Prioridad", "Estado", "Fecha Inicio", "Fecha Fin"
            }
        ));
        jScrollPane1.setViewportView(tblListaTareas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 271, 636, 301));

        txtBuscarListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarListaTareasActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscarListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 157, 249, 31));

        btnBuscarListaTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoBuscar.png"))); // NOI18N
        btnBuscarListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarListaTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 157, 32, -1));

        btnEditarListaTareas.setBackground(new java.awt.Color(0, 0, 102));
        btnEditarListaTareas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditarListaTareas.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarListaTareas.setText("Editar");
        btnEditarListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarListaTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 327, 94, 35));

        btnEliminarListaTareas.setBackground(new java.awt.Color(0, 0, 102));
        btnEliminarListaTareas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarListaTareas.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarListaTareas.setText("Eliminar");
        btnEliminarListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarListaTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 374, 94, 32));

        btnCrearTareaListaTareas.setBackground(new java.awt.Color(0, 0, 102));
        btnCrearTareaListaTareas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCrearTareaListaTareas.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearTareaListaTareas.setText("Crear Tarea");
        btnCrearTareaListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTareaListaTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearTareaListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 271, -1, 38));

        boxPrioridadListaTareas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baja", "Media", "Alta" }));
        boxPrioridadListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPrioridadListaTareasActionPerformed(evt);
            }
        });
        jPanel1.add(boxPrioridadListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 100, 32));

        boxEstadoListaTareas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por Hacer", "En Proceso", "Terminado" }));
        jPanel1.add(boxEstadoListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, 32));

        btnPrioridadBuscarListaTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoFiltrar.png"))); // NOI18N
        btnPrioridadBuscarListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrioridadBuscarListaTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrioridadBuscarListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 30, -1));

        btnBuscarEstadoListaTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoFiltrar.png"))); // NOI18N
        btnBuscarEstadoListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstadoListaTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarEstadoListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 30, 30));

        btnActualizarListaTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar icon.png"))); // NOI18N
        btnActualizarListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarListaTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 50, 60));

        jPanel1.add(boxUsuariosListaTareasP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 120, 30));

        btnBuscarUsuariosListaTareasP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoFiltrar.png"))); // NOI18N
        btnBuscarUsuariosListaTareasP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuariosListaTareasPActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarUsuariosListaTareasP, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 30, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Usuarios:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Prioridad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 100, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Estado:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 70, 20));

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

    private void btnCrearTareaListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTareaListaTareasActionPerformed
     // Obtén la referencia del MenuPrincipal
    MenuPrincipal menuPrincipal = (MenuPrincipal) SwingUtilities.getWindowAncestor(this);

    // Pasamos la referencia de jPanelListaTareas a CrearTarea
    CrearTarea crearTarea = new CrearTarea(menuPrincipal.getjPanelListaTareas());  // Llamada al constructor con parámetro
    crearTarea.setVisible(true);  // Muestra la ventana CrearTarea
    }//GEN-LAST:event_btnCrearTareaListaTareasActionPerformed

    private void btnEliminarListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarListaTareasActionPerformed
        // Obtener la fila seleccionada
    int selectedRow = tblListaTareas.getSelectedRow();  
    if (selectedRow == -1) {  // Si no se ha seleccionado ninguna fila
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una tarea para eliminar.");
        return;
    }

    // Obtener el nombre de la tarea seleccionada (asumiendo que está en la columna 2)
    String nombreTareaSeleccionada = (String) tblListaTareas.getValueAt(selectedRow, 2);  // Columna 2 es el nombre de la tarea
    
    // Eliminar la fila de la tabla
    DefaultTableModel modelo = (DefaultTableModel) tblListaTareas.getModel();
    modelo.removeRow(selectedRow);
    
    // Eliminar la tarea del archivo
    eliminarTareaDelArchivo(nombreTareaSeleccionada);

    // Volver a cargar las tareas en la tabla después de la eliminación
    cargarTareasEnTabla();  // Recarga la tabla con los datos actualizados del archivo
}
    
    
/**
 * Elimina una tarea del archivo basado en su nombre.
 * 
 * Este método busca una tarea en un archivo especificado y la elimina 
 * si se encuentra. Lee el archivo línea por línea y guarda las líneas 
 * que no corresponden al nombre de tarea proporcionado en una lista. 
 * Luego, reescribe el archivo con las líneas restantes. Si la tarea 
 * es eliminada correctamente, se muestra un mensaje de confirmación; 
 * de lo contrario, se muestra un mensaje de error.
 * 
 * @param nombreTarea El nombre de la tarea que se desea eliminar.
 */
private void eliminarTareaDelArchivo(String nombreTarea) {
    // Ruta completa al archivo
    String ruta = "C:\\Users\\hp\\Documents\\2024\\SEGUNDO SEMESTRE\\METODOS Y TALLER DE PROGRAMACION\\Proyecto Netbeans\\Gestion de Tareas\\tareas.txt";  
    File archivo = new File(ruta);

    // Crear una lista para almacenar las líneas que no se van a eliminar
    List<String> lineasRestantes = new ArrayList<>();
    
    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String linea;
        
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(";");

            // Verificar que la línea tiene al menos 5 elementos (para evitar errores)
            if (datos.length >= 5) {
                if (!datos[1].equals(nombreTarea)) {  // Si el nombre de la tarea no es el que se va a eliminar
                    lineasRestantes.add(linea);  // Agregar la línea a la lista
                }
            }
        }

        // Reescribir el archivo con las líneas restantes
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (String l : lineasRestantes) {
                writer.write(l);
                writer.newLine();
            }
        }

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Tarea eliminada correctamente.");
    } catch (IOException e) {
        // Manejo de errores si ocurre algún problema al leer o escribir en el archivo
        JOptionPane.showMessageDialog(this, "Error al eliminar la tarea: " + e.getMessage());
    }
    }//GEN-LAST:event_btnEliminarListaTareasActionPerformed

    private void btnEditarListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarListaTareasActionPerformed
      // Obtener la fila seleccionada de la tabla
    int filaSeleccionada = tblListaTareas.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una tarea para editar.");
        return; // Si no hay fila seleccionada, no hacer nada
    }

    // Obtener los datos de la fila seleccionada
    String nombreUsuario = (String) tblListaTareas.getValueAt(filaSeleccionada, 1);  // Columna 1: Usuario
    String nombreTarea = (String) tblListaTareas.getValueAt(filaSeleccionada, 2);    // Columna 2: Tarea
    String descripcion = (String) tblListaTareas.getValueAt(filaSeleccionada, 3);    // Columna 3: Descripción
    String prioridad = (String) tblListaTareas.getValueAt(filaSeleccionada, 4);      // Columna 4: Prioridad
    String estado = (String) tblListaTareas.getValueAt(filaSeleccionada, 5);         // Columna 5: Estado
    String fechaInicio = (String) tblListaTareas.getValueAt(filaSeleccionada, 6);    // Columna 6: Fecha Inicio
    String fechaFin = (String) tblListaTareas.getValueAt(filaSeleccionada, 7);       // Columna 7: Fecha Fin

    // Crear y mostrar la ventana EditarTarea con los nuevos parámetros
    EditarTarea editarTarea = new EditarTarea(this, nombreUsuario, nombreTarea, descripcion, prioridad, estado, fechaInicio, fechaFin);
    editarTarea.setVisible(true);
    }//GEN-LAST:event_btnEditarListaTareasActionPerformed

    private void btnBuscarListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarListaTareasActionPerformed
         String textoBusqueda = txtBuscarListaTareas.getText().trim().toLowerCase();

    if (textoBusqueda.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un texto para buscar.");
        return;
    }

    // Obtener el modelo de la tabla
    DefaultTableModel modelo = (DefaultTableModel) tblListaTareas.getModel();
    int totalFilas = modelo.getRowCount();
    boolean encontrado = false;

    // Limpiar selecciones anteriores
    tblListaTareas.clearSelection();

    // Recorrer las filas de la tabla
    for (int i = 0; i < totalFilas; i++) {
        String nombreTarea = modelo.getValueAt(i, 2).toString().toLowerCase(); // Columna del nombre de la tarea
        String descripcion = modelo.getValueAt(i, 3).toString().toLowerCase(); // Columna de la descripción

        // Si el texto de búsqueda coincide con el nombre o la descripción
        if (nombreTarea.contains(textoBusqueda) || descripcion.contains(textoBusqueda)) {
            encontrado = true;
        } else {
            // Ocultar la fila si no coincide con la búsqueda
            modelo.removeRow(i);
            i--; // Ajustamos el índice porque eliminamos una fila
            totalFilas--; // Disminuimos el total de filas
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(this, "No se encontraron tareas con ese criterio de búsqueda.");
    }
    }//GEN-LAST:event_btnBuscarListaTareasActionPerformed

    private void txtBuscarListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarListaTareasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarListaTareasActionPerformed

    private void boxPrioridadListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPrioridadListaTareasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxPrioridadListaTareasActionPerformed

    private void btnPrioridadBuscarListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrioridadBuscarListaTareasActionPerformed
         // Obtén la prioridad seleccionada en la combobox
    String prioridadSeleccionada = (String) boxPrioridadListaTareas.getSelectedItem();

    if (prioridadSeleccionada == null || prioridadSeleccionada.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una prioridad.");
        return;
    }

    // Obtener el modelo de la tabla
    DefaultTableModel modeloOriginal = (DefaultTableModel) tblListaTareas.getModel();

    // Lista temporal para almacenar las filas que cumplen con la prioridad seleccionada
    List<Object[]> filasFiltradas = new ArrayList<>();

    // Recorrer la tabla y guardar las filas coincidentes
    for (int i = 0; i < modeloOriginal.getRowCount(); i++) {
        String prioridad = (String) modeloOriginal.getValueAt(i, 4); // Columna 4 es la de prioridad
        if (prioridad.equalsIgnoreCase(prioridadSeleccionada)) {
            // Agregar la fila completa a la lista temporal
            Object[] fila = new Object[modeloOriginal.getColumnCount()];
            for (int j = 0; j < modeloOriginal.getColumnCount(); j++) {
                fila[j] = modeloOriginal.getValueAt(i, j);
            }
            filasFiltradas.add(fila);
        }
    }

    // Limpiar la tabla antes de mostrar los resultados filtrados
    modeloOriginal.setRowCount(0);

    // Agregar las filas filtradas a la tabla
    for (Object[] fila : filasFiltradas) {
        modeloOriginal.addRow(fila);
    }

    // Mostrar un mensaje si no se encontraron coincidencias
    if (filasFiltradas.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron tareas con la prioridad seleccionada.");
    }
    }//GEN-LAST:event_btnPrioridadBuscarListaTareasActionPerformed

    private void btnBuscarEstadoListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstadoListaTareasActionPerformed
        // Obtén el estado seleccionado en la combobox
    String estadoSeleccionado = (String) boxEstadoListaTareas.getSelectedItem();

    if (estadoSeleccionado == null || estadoSeleccionado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un estado.");
        return;
    }

    // Obtener el modelo de la tabla
    DefaultTableModel modeloOriginal = (DefaultTableModel) tblListaTareas.getModel();

    // Lista temporal para almacenar las filas que cumplen con el estado seleccionado
    List<Object[]> filasFiltradas = new ArrayList<>();

    // Recorrer la tabla y guardar las filas coincidentes
    for (int i = 0; i < modeloOriginal.getRowCount(); i++) {
        String estado = (String) modeloOriginal.getValueAt(i, 5); // Columna 5 es la de estado
        if (estado.equalsIgnoreCase(estadoSeleccionado)) {
            // Agregar la fila completa a la lista temporal
            Object[] fila = new Object[modeloOriginal.getColumnCount()];
            for (int j = 0; j < modeloOriginal.getColumnCount(); j++) {
                fila[j] = modeloOriginal.getValueAt(i, j);
            }
            filasFiltradas.add(fila);
        }
    }

    // Limpiar la tabla antes de mostrar los resultados filtrados
    modeloOriginal.setRowCount(0);

    // Agregar las filas filtradas a la tabla
    for (Object[] fila : filasFiltradas) {
        modeloOriginal.addRow(fila);
    }

    // Mostrar un mensaje si no se encontraron coincidencias
    if (filasFiltradas.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron tareas con el estado seleccionado.");
    }
    }//GEN-LAST:event_btnBuscarEstadoListaTareasActionPerformed

    private void btnActualizarListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarListaTareasActionPerformed
         cargarTareasEnTabla(); // Método que carga todas las tareas desde el archivo
    }//GEN-LAST:event_btnActualizarListaTareasActionPerformed

    private void btnBuscarUsuariosListaTareasPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuariosListaTareasPActionPerformed
        // Obtener el usuario seleccionado
    String usuarioSeleccionado = (String) boxUsuariosListaTareasP.getSelectedItem();

    if (usuarioSeleccionado == null || usuarioSeleccionado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario.");
        return;
    }

    // Obtener el modelo de la tabla
    DefaultTableModel modeloOriginal = (DefaultTableModel) tblListaTareas.getModel();

    // Lista temporal para almacenar las filas que coinciden
    List<Object[]> filasFiltradas = new ArrayList<>();

    // Recorrer las filas de la tabla
    for (int i = 0; i < modeloOriginal.getRowCount(); i++) {
        String usuario = (String) modeloOriginal.getValueAt(i, 1); // Columna 1 es la del usuario
        if (usuario.equalsIgnoreCase(usuarioSeleccionado)) {
            // Agregar la fila a la lista temporal
            Object[] fila = new Object[modeloOriginal.getColumnCount()];
            for (int j = 0; j < modeloOriginal.getColumnCount(); j++) {
                fila[j] = modeloOriginal.getValueAt(i, j);
            }
            filasFiltradas.add(fila);
        }
    }

    // Limpiar la tabla antes de mostrar los resultados
    modeloOriginal.setRowCount(0);

    // Agregar las filas filtradas
    for (Object[] fila : filasFiltradas) {
        modeloOriginal.addRow(fila);
    }

    // Mensaje si no hay coincidencias
    if (filasFiltradas.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron tareas para el usuario seleccionado.");
    }
    }//GEN-LAST:event_btnBuscarUsuariosListaTareasPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxEstadoListaTareas;
    private javax.swing.JComboBox<String> boxPrioridadListaTareas;
    private javax.swing.JComboBox<String> boxUsuariosListaTareasP;
    private javax.swing.JButton btnActualizarListaTareas;
    private javax.swing.JButton btnBuscarEstadoListaTareas;
    private javax.swing.JButton btnBuscarListaTareas;
    private javax.swing.JButton btnBuscarUsuariosListaTareasP;
    private javax.swing.JButton btnCrearTareaListaTareas;
    private javax.swing.JButton btnEditarListaTareas;
    private javax.swing.JButton btnEliminarListaTareas;
    private javax.swing.JButton btnPrioridadBuscarListaTareas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaTareas;
    private javax.swing.JTextField txtBuscarListaTareas;
    // End of variables declaration//GEN-END:variables
}
