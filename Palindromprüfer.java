import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Insets;

public class Palindromprüfer extends JFrame{
    
    MyStack letter = new MyStack<String>();
    
    JLabel label;
    JLabel labelW;
    JButton bCheck;
    JTextField textField;
    JTextArea textArea;
    int counter = 0;
    
    
    public Palindromprüfer(){
        setBounds(100,100,500,300);        
        setTitle("Palindromprüfer");
        setLayout(null);
        
        label = new JLabel("Du möchtest herausfinden ob dein Wort ein Palindrom ist?");
        label.setBounds(10,10,490,10);
        add(label);
        
        labelW = new JLabel("Wort");
        labelW.setBounds(130,40,60,25);
        add(labelW);
        
        textField = new JTextField();
        textField.setBounds(175,40,150,25);
        add(textField);
        
        bCheck = new JButton("Prüfen");
        bCheck.setBounds(340,40,100,25);
        bCheck.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               buttonAction();
           }
        });
        add(bCheck);
        
        
        
        JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
                
        textArea = new JTextArea();
        textArea.setBounds(0,200,500,100);
        textArea.setFont(new Font("Airal", Font.BOLD, 15));
        textArea.setEditable(false);
        textArea.setMargin( new Insets(0,10,0,10) );
        add(textArea);
        
        add(scroll);                           
                                   
        setVisible(true);
    }
    
    public static void main(String[] a){
        new Palindromprüfer();
    }
    
    public void buttonAction() {
        String input = textField.getText();
        if (!input.isBlank()) {
            if (check(input)) {
                textArea.insert(input + " ist ein Palindrom! \n", 0);
            } else {
                textArea.insert(input + " ist kein Palindrom! \n", 0);
            }
        }else {
            textArea.setText("Error bitte gib ein Wort ein! \n");
        }
        textField.setText("");
    }
    
    public boolean check (String word) {
        if (counter >= 3) {
            textArea.setText("");
            counter = 0;
        }
        counter++;
        String[] palindrom = new String[word.length()];
        for(int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
