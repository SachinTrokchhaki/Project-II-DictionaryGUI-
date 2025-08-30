package gui;
import javax.swing.*;
import java.awt.*;

public class AddWord extends JFrame{
    private final JTextField tfWord = new JTextField();
    private final JTextArea taMeaning = new JTextArea();
    public interface onAdded{
        void added(String w, String m);
    }
    
    public AddWord(JFrame owner, onAdded callback){
        setTitle("Add Word");
        setSize(480,320);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(8,8));
        
        JPanel form = new JPanel(new GridLayout(0,1,8,8));
        form.setBorder(BorderFactory.createEmptyBorder(12,12,0,12));
        form.add(new JLabel("Word"));
        form.add(tfWord);
        form.add(new JLabel("Meaning"));
        form.add(taMeaning);
        taMeaning.setLineWrap(true);
        taMeaning.setWrapStyleWord(true);
        form.add(new JScrollPane(taMeaning));
        add(form, BorderLayout.CENTER);
        
        JButton btnAdd = new JButton("Add");
        JPanel south = new JPanel( new FlowLayout(FlowLayout.RIGHT));
        south.add(btnAdd);
        add(south, BorderLayout.SOUTH);
        
        btnAdd.addActionListener(e->{
            String w = tfWord.getText().trim();
            String m = taMeaning.getText().trim();
            
            if(w.isEmpty() || m.isEmpty()){
                JOptionPane.showMessageDialog(this, "Both Field is required");
                return;
            }
            callback.added(w,m);
            JOptionPane.showMessageDialog(this, "Added!");
            tfWord.setText(""); taMeaning.setText("");
        }); 
        
    }
}
