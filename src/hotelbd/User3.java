/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbd;
import java.sql.Connection;
/**
 *
 * @author bvc
 */
public class User3 extends javax.swing.JFrame {
    
    private MainFrame restVxod;
    private transient Connection restconn;
    private transient Params paramsClass;
    private transient Utils utilsClass;
    private User3 me;
  
    /**
     * Creates new form user3
     */
    public User3() {
        paramsClass = new Params();
        utilsClass = new Utils();
        initComponents();
    }

      void setMe(User3 RestAdmin){
        me = RestAdmin;
    }
    
    Connection getRestconn(){
        return restconn;
    }
    
    Params getParamsClass(){
          return paramsClass;
      }
    
    javax.swing.JComboBox<String> getrestbox(){
         return restbox;
     }
    
     javax.swing.JTable getresttable(){
         return resttable;
     }
     
      javax.swing.JTable getrestmeal(){
         return restmeal;
     }
      
      javax.swing.JButton getaddmeal(){
             return addmeal;
         }
      
        javax.swing.JTable getrestkategory(){
         return restkategory;
     }
      
      javax.swing.JButton getaddkategory(){
             return addkategory;
         }
      
     javax.swing.JTable getrestmp(){
         return restmp;
     }
      
      javax.swing.JButton getaddmp(){
             return addmp;
         }
      
       javax.swing.JTable getrestp(){
         return restp;
     }
      
      javax.swing.JButton getaddp(){
             return addp;
         }
      
       javax.swing.JTable getrestpn(){
         return restpn;
     }
      
      javax.swing.JButton getaddpn(){
             return addpn;
         }
      
       javax.swing.JTable getrestn(){
         return restn;
     }
      
      javax.swing.JButton getaddn(){
             return addn;
         }
      
       javax.swing.JTextField geteditm(){
         return editm;
     }    
        javax.swing.JButton getjButton2(){
             return jButton2;
         }
        
         javax.swing.JTextField geteditk(){
         return editk;
     }    
        javax.swing.JButton getjButton3(){
             return jButton3;
         }
        
          javax.swing.JTextField geteditp(){
         return editp;
     }    
        javax.swing.JButton getjButton5(){
             return jButton5;
         }
        
            javax.swing.JTextField geteditn(){
         return editn;
     }    
        javax.swing.JButton getjButton7(){
             return jButton7;
         }
             
        javax.swing.JTextField getid1(){
         return id1;
     }    
    javax.swing.JTextField getid2(){
         return id2;
     }    
    javax.swing.JComboBox<String> getdeletebox(){
         return deletebox;
     }    
    javax.swing.JButton getdeleteRest(){
             return deleteRest;
         } 
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resttable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        restbox = new javax.swing.JComboBox<>();
        show = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        restmeal = new javax.swing.JTable();
        addmeal = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        restkategory = new javax.swing.JTable();
        addkategory = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        restmp = new javax.swing.JTable();
        addmp = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        restp = new javax.swing.JTable();
        addp = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        restpn = new javax.swing.JTable();
        addpn = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        restn = new javax.swing.JTable();
        addn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        editm = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        editk = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        editp = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        editn = new javax.swing.JTextField();
        deletebox = new javax.swing.JComboBox<>();
        deleteRest = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        id1 = new javax.swing.JTextField();
        id2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.setText(" Администратор ресторана ");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        resttable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(resttable);

        jButton1.setText("Назад");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        restbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Вывести все блюда", "Вывести все категории", "Вывести блюда- продукты", "Вывести продукты", "Вывести продукты- накладные", "Вывести накладные" }));

        show.setText("Вывести");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        restmeal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "name", "cost", "idkategory"
            }
        ));
        jScrollPane2.setViewportView(restmeal);

        addmeal.setText("Добавить новое блюдо");
        addmeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmealActionPerformed(evt);
            }
        });

        restkategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "kategory name"
            }
        ));
        jScrollPane3.setViewportView(restkategory);

        addkategory.setText("Добавить новую категорию");
        addkategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addkategoryActionPerformed(evt);
            }
        });

        restmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "id блюда", "id продукта", "количество продукта"
            }
        ));
        jScrollPane4.setViewportView(restmp);

        addmp.setText("Занести новые составляющие блюда");
        addmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmpActionPerformed(evt);
            }
        });

        restp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "название", "количество на складе"
            }
        ));
        jScrollPane5.setViewportView(restp);

        addp.setText("Добавить новый продукт");
        addp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpActionPerformed(evt);
            }
        });

        restpn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "id накладной", "id продукта", "количество", "стоимость"
            }
        ));
        restpn.setToolTipText("");
        jScrollPane6.setViewportView(restpn);

        addpn.setText("Добавить");
        addpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpnActionPerformed(evt);
            }
        });

        restn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "дата", "компания"
            }
        ));
        jScrollPane7.setViewportView(restn);

        addn.setText("Добавить");
        addn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnActionPerformed(evt);
            }
        });

        jButton2.setText("Изменить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Изменить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Изменить");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Изменить");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        deletebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Блюд", "Категорий", "Блюда- Продукты", "Продукты", "Продукты- Накладные", "Накладные" }));

        deleteRest.setText("Удалить");
        deleteRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRestActionPerformed(evt);
            }
        });

        jTextField2.setText("Удалить из:");

        id1.setText("id1");
        id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id1ActionPerformed(evt);
            }
        });

        id2.setText("id2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(restbox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(248, 248, 248))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(addp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addComponent(jButton5)
                                .addGap(44, 44, 44)
                                .addComponent(editp))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(addkategory, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(editk))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(addmeal)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(editm, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(addmp, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(deletebox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteRest)))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addn, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(editn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(addpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(170, 170, 170)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(show))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addp)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addmeal)
                                        .addComponent(jButton2)
                                        .addComponent(editm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5))))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addkategory)
                    .addComponent(addpn)
                    .addComponent(jButton3)
                    .addComponent(editk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addmp))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addn)
                            .addComponent(jButton7)
                            .addComponent(editn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deletebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteRest)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         restVxod.setVisible(true);
       restVxod.getRest().setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        // TODO add your handling code here:
        utilsClass.zaprosiRestAdmin(me);
    }//GEN-LAST:event_showActionPerformed

    private void addmealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmealActionPerformed
        // TODO add your handling code here:
   utilsClass.newmealRestAdmin(me);
    }//GEN-LAST:event_addmealActionPerformed

    private void addkategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addkategoryActionPerformed
        // TODO add your handling code here:
        utilsClass.newcategoryRestAdmin(me);
    }//GEN-LAST:event_addkategoryActionPerformed

    private void addmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmpActionPerformed
        // TODO add your handling code here:
        utilsClass.newmpRestAdmin(me);
    }//GEN-LAST:event_addmpActionPerformed

    private void addpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpActionPerformed
        // TODO add your handling code here:
        utilsClass.newpRestAdmin(me);
    }//GEN-LAST:event_addpActionPerformed

    private void addpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpnActionPerformed
        // TODO add your handling code here:
        utilsClass.newpnRestAdmin(me);     
    }//GEN-LAST:event_addpnActionPerformed

    private void addnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnActionPerformed
        // TODO add your handling code here:
        utilsClass.newnRestAdmin(me);   
    }//GEN-LAST:event_addnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       utilsClass.editmealRestAdmin(me);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       utilsClass.editcategoryRestAdmin(me);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        utilsClass.editpRestAdmin(me);
         
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        utilsClass.editnRestAdmin(me);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id1ActionPerformed

    private void deleteRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRestActionPerformed
        // TODO add your handling code here:
        utilsClass.deletesmthRestAdmin(me);
    }//GEN-LAST:event_deleteRestActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    void getmainframe(MainFrame Vxod)
    {
        restVxod = Vxod;
    }
    
    void getconn(Connection conn)
    {
        restconn = conn;
    }
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
            java.util.logging.Logger.getLogger(User3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new User3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addkategory;
    private javax.swing.JButton addmeal;
    private javax.swing.JButton addmp;
    private javax.swing.JButton addn;
    private javax.swing.JButton addp;
    private javax.swing.JButton addpn;
    private javax.swing.JButton deleteRest;
    private javax.swing.JComboBox<String> deletebox;
    private javax.swing.JTextField editk;
    private javax.swing.JTextField editm;
    private javax.swing.JTextField editn;
    private javax.swing.JTextField editp;
    private javax.swing.JTextField id1;
    private javax.swing.JTextField id2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> restbox;
    private javax.swing.JTable restkategory;
    private javax.swing.JTable restmeal;
    private javax.swing.JTable restmp;
    private javax.swing.JTable restn;
    private javax.swing.JTable restp;
    private javax.swing.JTable restpn;
    private javax.swing.JTable resttable;
    private javax.swing.JButton show;
    // End of variables declaration//GEN-END:variables
}
