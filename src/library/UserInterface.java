/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
/* for giving empty inout a window dialog code:
 JOptionPane.showMessageDialog(this, "Pls enter data");
*/
import java.awt.Button;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Exodia
 */
public class UserInterface extends javax.swing.JFrame {
    private UsersList userList;
    public static BooksList bookList;
    List<Book> lista;
   DefaultTableModel tableModel;
    
    
    /**
     * Creates new form UserInterface
     */
    public UserInterface() {
        initComponents();
        bookList = new BooksList();
        Button btn = new Button("egy");
        splitPane.setLeftComponent(btn);
        Button btn2 = new Button("ketto");
        splitPane.setRightComponent(btn2);
        
        tableModel = (DefaultTableModel) jTable1.getModel();
        
        
    // splitpane: https://www.youtube.com/watch?v=BvQiKLWrKh8
        
        
        
        
    }
    
    
    public void addUser(){
        User user1 = new User("Jozsef", new ContactAddress("1@email.com", "123456", "Maros utca 2"), "123456789");
        User user2 = new User("Anita", new ContactAddress("2@email.com", "987654", "Maros utca 4"),"231456789" );
        User user3 = user2;
        user3.setNev("Dani");
        userList.hozzaad(user3);
        userList.hozzaad(user2);
        userList.hozzaad(user1);
    }
    public void addBook(){
        Book konyv1 = new Book("Egri csillagok", "Gardonyi Geza", "Budapest-kiado", 1970, "123456", "1");
        Book konyv2 = new Book("Ember tragediaja", "Madach Imre", "kolozsvar", 2010, "321654", "2");
        bookList.hozzaad(konyv2);
        bookList.hozzaad(konyv1);
        Book konyv3 = konyv2;
        konyv3.setKiado("Kolozsvar");
        bookList.modosit("2", konyv3);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        bookLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        splitPane = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        importAs = new javax.swing.JMenu();
        importAsTxt = new javax.swing.JMenuItem();
        importAsXml = new javax.swing.JMenuItem();
        exportAs = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        Book = new javax.swing.JMenu();
        AddBook = new javax.swing.JMenuItem();
        SearchBook = new javax.swing.JMenuItem();
        DeleteBook = new javax.swing.JMenuItem();
        ListBook = new javax.swing.JMenuItem();
        User = new javax.swing.JMenu();
        AddUser = new javax.swing.JMenuItem();
        SearchUser = new javax.swing.JMenuItem();
        DeleteUser = new javax.swing.JMenuItem();
        ListUser = new javax.swing.JMenuItem();
        kolcsonzes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setText("Library App");

        bookLabel.setText("Book List");

        userLabel.setText("User List");

        splitPane.setDividerLocation(100);
        splitPane.setAutoscrolls(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cim", "Szerzo", "Kiado", "KiadasEve", "ISBN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        File.setText("File");

        importAs.setText("Import as...");

        importAsTxt.setText(".txt");
        importAs.add(importAsTxt);

        importAsXml.setText(".xml");
        importAs.add(importAsXml);

        File.add(importAs);

        exportAs.setText("Export as...");

        jMenuItem4.setText(".txt");
        exportAs.add(jMenuItem4);

        jMenuItem5.setText(".xml");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        exportAs.add(jMenuItem5);

        File.add(exportAs);

        MenuBar.add(File);

        Book.setText("Book");

        AddBook.setText("HozzaAdas");
        AddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookActionPerformed(evt);
            }
        });
        Book.add(AddBook);

        SearchBook.setText("Kereses");
        Book.add(SearchBook);

        DeleteBook.setText("Torles");
        DeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBookActionPerformed(evt);
            }
        });
        Book.add(DeleteBook);

        ListBook.setText("Listazas");
        ListBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListBookActionPerformed(evt);
            }
        });
        Book.add(ListBook);

        MenuBar.add(Book);

        User.setText("User");

        AddUser.setText("HozzaAd");
        AddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserActionPerformed(evt);
            }
        });
        User.add(AddUser);

        SearchUser.setText("Kereses");
        User.add(SearchUser);

        DeleteUser.setText("Delete");
        User.add(DeleteUser);

        ListUser.setText("List");
        User.add(ListUser);

        MenuBar.add(User);

        kolcsonzes.setText("Kolcsonzes");
        MenuBar.add(kolcsonzes);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(bookLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243)
                        .addComponent(userLabel)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(splitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(228, 228, 228))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel))
                .addGap(3, 3, 3)
                .addComponent(bookLabel)
                .addGap(18, 18, 18)
                .addComponent(splitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBookActionPerformed

    private void ListBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListBookActionPerformed
        //System.out.println("Size:" +lista.size());
        if(tableModel.getRowCount() < 1){
            lista = bookList.importBookListXML();
            for(int i=0 ;i < lista.size(); ++i){
              tableModel.insertRow(tableModel.getRowCount(), new Object[]{lista.get(i).getID(), lista.get(i).getCim(), lista.get(i).getSzerzo(),
                                        lista.get(i).getKiado(), lista.get(i).getKiadasEve(), lista.get(i).getISBN() } );
            }
        
        }
    }//GEN-LAST:event_ListBookActionPerformed

    private void AddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AddUserActionPerformed

    private void AddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBookActionPerformed
        JFrame newFrame = new JFrame();
        newFrame.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBookActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddBook;
    private javax.swing.JMenuItem AddUser;
    private javax.swing.JMenu Book;
    private javax.swing.JMenuItem DeleteBook;
    private javax.swing.JMenuItem DeleteUser;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem ListBook;
    private javax.swing.JMenuItem ListUser;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem SearchBook;
    private javax.swing.JMenuItem SearchUser;
    private javax.swing.JMenu User;
    private javax.swing.JLabel bookLabel;
    private javax.swing.JMenu exportAs;
    private javax.swing.JMenu importAs;
    private javax.swing.JMenuItem importAsTxt;
    private javax.swing.JMenuItem importAsXml;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu kolcsonzes;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
   

    
}
