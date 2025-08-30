/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final JButton btnLogin = new JButton("Login");
    private final JButton btnLogout = new JButton("Logout");
    private final JButton btnNewAdd = new JButton("Add Word"); // making hidden only for login users
    private final JLabel lblWelcome = new JLabel("Guess");
    private final JTextField tfSearch = new JTextField();
    private final JButton btnSearch = new JButton("Search");
    private final JTextArea taMeaning = new JTextArea(8,40);
    
    private final data.Dictionary dic = new data.Dictionary();
    
    private boolean isLoggedIn = false;
    
    public MainFrame(){
    setTitle("Dictionary App");
    setSize(500,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
//    setVisible(true); not need as in main file it already included or written

    //for TopBar
    JPanel top = new JPanel(new BorderLayout());
    top.add(lblWelcome, BorderLayout.WEST);
    
    //for login/logout in TopBar
    JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    right.add(btnLogin);    btnLogin.setVisible(true);
    right.add(btnNewAdd);   btnNewAdd.setVisible(false);
    right.add(btnLogout);   btnLogout.setVisible(false);
    
    top.add(right, BorderLayout.EAST); //adding right panel in top panel
    add(top, BorderLayout.NORTH);
    
    
    
    //for Search 
    JPanel searchRow = new JPanel(new BorderLayout(8,0));
    searchRow.add(tfSearch, BorderLayout.CENTER);
    searchRow.add(btnSearch, BorderLayout.EAST);
    
    taMeaning.setEditable(false);
    JScrollPane meaningPane = new JScrollPane(taMeaning);
    
    JPanel center = new JPanel(new BorderLayout(8,0));
    center.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
    center.add(searchRow, BorderLayout.NORTH);
    center.add(meaningPane, BorderLayout.CENTER);
    add(center, BorderLayout.CENTER);
    
    
    
    //actionperformed for search
    btnSearch.addActionListener(e->{
       String w = tfSearch.getText();
       String m = dic.find(w);
       taMeaning.setText(m != null ? m : "Not found.");
    });
    
    tfSearch.addActionListener(btnSearch.getActionListeners()[0]); // while pressed enter it triggers search
    
    //actionperformed for login/logout
    btnLogin.addActionListener(e ->{
        LoginDialog dlg = new LoginDialog(this);
        dlg.setVisible(true);
        if(dlg.isSuccess()){
            isLoggedIn = true;
            lblWelcome.setText("Welcome, " + dlg.getUsername());
            btnLogin.setVisible(false);
            btnLogout.setVisible(true);
            btnNewAdd.setVisible(true);
        }
    });
    
    btnLogout.addActionListener(e->{
        auth.AuthService.getInstance().logout();
        isLoggedIn = false;
        lblWelcome.setText("Guest");
        btnNewAdd.setVisible(false);
        btnLogout.setVisible(false);
        btnLogin.setVisible(true);
    });
    
    //adding new word
    
    btnNewAdd.addActionListener(e->{
        if(!isLoggedIn) return;
        AddWord addWord = new AddWord(this, (w,m) -> dic.add(w,m));
        addWord.setVisible(true);
    });
    
    }
}
