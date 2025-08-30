package gui;
import javax.swing.*;
import java.awt.*;

public class LoginDialog extends JDialog{
    private final JTextField tfUser = new JTextField();
    private final JPasswordField pfPass = new JPasswordField();
    private boolean success = false;
    private String username;
    
    public LoginDialog(JFrame owner){
        super(owner, "Login", true);
        setSize(320,180);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(8,8));
        
        JPanel form = new JPanel(new GridLayout(2,2,8,8));
        form.setBorder(BorderFactory.createEmptyBorder(12,12,0,12));
        form.add(new JLabel("Username:"));
        form.add(tfUser);
        form.add(new JLabel("Password:"));
        form.add(pfPass);
        add(form, BorderLayout.CENTER);
        
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton ok = new JButton("Login");
        JButton cancel = new JButton("Cancel");
        buttons.add(cancel);
        buttons.add(ok);
        add(buttons, BorderLayout.SOUTH);
        
        ok.addActionListener(e ->{
            String u = tfUser.getText().trim();
            String p = new String(pfPass.getPassword());
            
            if(auth.AuthService.getInstance().login(u,p)){
                success = true; username = u; dispose();
            }
            else{
            JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        });
        cancel.addActionListener(e -> dispose());
    }
   public boolean isSuccess(){
       return success;
   }
   public String getUsername(){
       return username;
   }
   }
