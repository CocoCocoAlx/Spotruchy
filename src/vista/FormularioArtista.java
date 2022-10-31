package vista;

import modelo.Album;
import modelo.Artista;
import modelo.Spotruchy;

public class FormularioArtista extends javax.swing.JInternalFrame {

    private Spotruchy s = null;

    public FormularioArtista(Spotruchy s) {
        this.s = s;
        initComponents();
        this.listaArtista.setListData(this.s.getArtistas().toArray());
        limpiar();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listaArtista = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextArea();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblAlbumes = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Panel de artista");

        listaArtista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaArtista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaArtistaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaArtista);

        jLabel1.setText("Nombre");

        txtNombre.setColumns(20);
        txtNombre.setRows(5);
        jScrollPane3.setViewportView(txtNombre);

        btnNuevo.setText("Crear");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Borrar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAlbumes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAlbumes, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //se crean los métodos para crear y/o modificar un artista en/de la lista]
        if (this.listaArtista.isSelectionEmpty()){
            this.s.crearArtista(this.txtNombre.getText());
        } else {
            Artista a = (Artista) this.listaArtista.getSelectedValue();
            //para realizar la modificación, se toma el valor de la caja de texto y se guarda
            this.s.modificarArtista(a, this.txtNombre.getText());
        }
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void listaArtistaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaArtistaValueChanged
        if (!this.listaArtista.isSelectionEmpty()){
            Artista a = (Artista) this.listaArtista.getSelectedValue();
            this.txtNombre.setText(a.getNombre());
            //mostrar un listado (en formato HTML) de los álbumes de cada artista
            String albumes = "<html>ALBUMES:<ul>";
            for (Album al : a.getAlbumes())
                albumes += "<li>"+al.getNombre()+"</li>";
            albumes += "</ul></html>";
            this.lblAlbumes.setText(albumes);
                
        }

    }//GEN-LAST:event_listaArtistaValueChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //se crean los métodos para crear y/o modificar un artista en/de la lista]
        if (!this.listaArtista.isSelectionEmpty()){
            Artista a = (Artista) this.listaArtista.getSelectedValue();
            //para realizar la modificación, se toma el valor de la caja de texto y se guarda
            this.s.eliminarArtista(a);
        }
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAlbumes;
    private javax.swing.JList listaArtista;
    private javax.swing.JTextArea txtNombre;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        this.txtNombre.setText("");
        System.out.println("Actualizando...");
        Spotruchy.getPersistencia().refrescar(this.s);
        System.out.println("Actualizado");
        this.listaArtista.setListData(this.s.getArtistas().toArray());
        this.listaArtista.clearSelection();
    }

}
