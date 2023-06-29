/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.actividad6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Ventana extends JFrame {
    private JButton createButton, readButton, updateButton, deleteButton;

    public Ventana() {
        // Configuración básica del marco
        setTitle("Operaciones de archivos");
        setSize(320, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los botones
        createButton = new JButton("Crear");
        readButton = new JButton("Leer");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Borrar");

        // Agregar los botones al panel
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(createButton);
        buttonBox.add(readButton);
        buttonBox.add(updateButton);
        buttonBox.add(deleteButton);

        // Agregar el panel al marco
        add(buttonBox);

        // Agregar los manejadores de eventos a los botones
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createFile();
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readFile();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFile();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });
    }

    private void createFile() {
        // Solicitar al usuario el nombre del archivo a crear
        String fileName = JOptionPane.showInputDialog(this, "Ingrese el nombre del archivo:", "Crear archivo", JOptionPane.PLAIN_MESSAGE);
        if (fileName != null && !fileName.isEmpty()) {
            try {
                // Crear el archivo
                File file = new File(fileName + ".txt");
                if (file.createNewFile()) {
                    JOptionPane.showMessageDialog(this, "Archivo creado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El archivo ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "El archivo no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void readFile() {
        // Solicitar al usuario el nombre del archivo a leer
        String fileName = JOptionPane.showInputDialog(this, "Ingrese el nombre del archivo:", "Leer archivo", JOptionPane.PLAIN_MESSAGE);
        if (fileName != null && !fileName.isEmpty()) {
            try {
                // Leer el contenido del archivo
                File file = new File(fileName + ".txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
                br.close();
                JOptionPane.showMessageDialog(this, "Contenido del archivo:\n" + content.toString(), "Archivo leído", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateFile() {
        // Solicitar al usuario el nombre del archivo a actualizar
        String fileName = JOptionPane.showInputDialog(this, "Ingrese el nombre del archivo:", "Actualizar archivo", JOptionPane.PLAIN_MESSAGE);
        if (fileName != null && !fileName.isEmpty()) {
            try {
                // Actualizar el contenido del archivo
                File file = new File(fileName + ".txt");
                if (file.exists()) {
                    FileWriter fw = new FileWriter(file, true);
                    String content = JOptionPane.showInputDialog(this, "Ingrese el contenido a agregar:", "Actualizar archivo", JOptionPane.PLAIN_MESSAGE);
                    fw.write(content + "\n");
                    fw.close();
                    JOptionPane.showMessageDialog(this, "Archivo actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El archivo no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al actualizar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteFile() {
        // Solicitar al usuario el nombre del archivo a borrar
        String fileName = JOptionPane.showInputDialog(this, "Ingrese el nombre del archivo:", "Borrar archivo", JOptionPane.PLAIN_MESSAGE);
        if (fileName != null && !fileName.isEmpty()) {
            // Verificar si el archivo existe
            File file = new File(fileName + ".txt");
            if (file.exists()) {
                // Solicitar confirmación para borrar el archivo
                int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea borrar el archivo?", "Confirmación de borrado", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Borrar el archivo
                    if (file.delete()) {
                        JOptionPane.showMessageDialog(this, "Archivo borrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al borrar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "El archivo no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
