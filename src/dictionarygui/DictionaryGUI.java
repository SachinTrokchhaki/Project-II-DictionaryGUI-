package dictionarygui;
import gui.MainFrame;

public class DictionaryGUI {
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(()-> new MainFrame().setVisible(true));
    }
    
}
