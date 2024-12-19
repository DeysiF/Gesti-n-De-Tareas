/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login;

import java.awt.CardLayout;
import javax.swing.SwingUtilities;

/**
 * Clase MenuPrincipal
 * 
 * Esta clase representa la interfaz principal del sistema "TareaNet". Utiliza un CardLayout para
 * mostrar diferentes paneles, como inicio, lista de usuarios, lista de tareas e historial.
 * 
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    
    jPanelInicio panelInicio = new jPanelInicio();
    jPanelListaUsuarios panelListaUsuarios = new jPanelListaUsuarios();
    
    jPanelListaTareas panelListaTareas = new jPanelListaTareas();
    jPanelHistorial panelHistorial = new jPanelHistorial();
    CardLayout vista;
    
    /**
     * Constructor de la clase MenuPrincipal.
     * Inicializa los componentes de la interfaz gráfica, configura el CardLayout
     * y carga los datos iniciales en el panel de inicio.
     */
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        
         jPanelPrincipal.add(panelInicio, "inicio");
        vista = (CardLayout) jPanelPrincipal.getLayout();
        
        panelInicio.cargarUsuariosEnTablaInicio();  
        
        }
    
    /**
     * Devuelve el panel de lista de usuarios.
     * 
     * @return Objeto jPanelListaUsuarios
     */
   public jPanelListaUsuarios getjPanelListaUsuarios() {
    return panelListaUsuarios; // Asegúrate de que sea el nombre de tu instancia
}
   /**
     * Devuelve el panel de lista de tareas.
     * 
     * @return Objeto jPanelListaTareas
     */
   public jPanelListaTareas getjPanelListaTareas() {
    return panelListaTareas;  // Devuelve el panel
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnListaTareas = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnListaUsuarios = new javax.swing.JButton();
        FondoAzul = new javax.swing.JLabel();
        jPanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TareaNet");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 120, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura de pantalla 2024-11-10 154341.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 30, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("-------------------------------");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        btnInicio.setBackground(new java.awt.Color(37, 37, 75));
        btnInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inicio.png"))); // NOI18N
        btnInicio.setText(" Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 60));

        btnListaTareas.setBackground(new java.awt.Color(37, 37, 75));
        btnListaTareas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnListaTareas.setForeground(new java.awt.Color(255, 255, 255));
        btnListaTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ListaTareas.png"))); // NOI18N
        btnListaTareas.setText("Lista de Tareas");
        btnListaTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaTareasActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, 60));

        btnHistorial.setBackground(new java.awt.Color(37, 37, 75));
        btnHistorial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Historial.png"))); // NOI18N
        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        getContentPane().add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, 60));

        btnListaUsuarios.setBackground(new java.awt.Color(37, 37, 75));
        btnListaUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnListaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnListaUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario.png"))); // NOI18N
        btnListaUsuarios.setText("Lista Usuarios");
        btnListaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, 60));

        FondoAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Blue Modern Login Page Desktop Prototype.png"))); // NOI18N
        getContentPane().add(FondoAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 0, 500, 720));

        jPanelPrincipal.setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción del botón "Inicio". Muestra el panel de inicio y actualiza la tabla de usuarios.
     * 
     * @param evt Evento de acción
     */
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        
        jPanelPrincipal.add(panelInicio, "crear");
        vista.show(jPanelPrincipal, "crear");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
         panelInicio.cargarUsuariosEnTablaInicio(); // Cargar los datos en la tabla
    }//GEN-LAST:event_btnInicioActionPerformed

    /**
     * Acción del botón "Lista de Usuarios". Muestra el panel de lista de usuarios y actualiza su tabla.
     * 
     * @param evt Evento de acción
     */
    private void btnListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaUsuariosActionPerformed
        jPanelPrincipal.add(panelListaUsuarios, "crear");
        vista.show(jPanelPrincipal, "crear");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
        // Aquí asegúrate de actualizar la tabla
    panelListaUsuarios.cargarUsuariosEnTabla();
        
    }//GEN-LAST:event_btnListaUsuariosActionPerformed

    /**
     * Acción del botón "Lista de Tareas". Muestra el panel de lista de tareas.
     * 
     * @param evt Evento de acción
     */
    private void btnListaTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaTareasActionPerformed
        jPanelPrincipal.add(panelListaTareas, "crear");
        vista.show(jPanelPrincipal, "crear");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnListaTareasActionPerformed

    /**
     * Acción del botón "Historial". Muestra el panel de historial.
     * 
     * @param evt Evento de acción
     */
    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        jPanelPrincipal.add(panelHistorial, "crear");
        vista.show(jPanelPrincipal, "crear");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
        
    }//GEN-LAST:event_btnHistorialActionPerformed

    /**
     * Método principal para ejecutar la aplicación.
     * 
     * @param args Argumentos de la línea de comandos
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoAzul;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnListaTareas;
    private javax.swing.JButton btnListaUsuarios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables

    

   

    
}
