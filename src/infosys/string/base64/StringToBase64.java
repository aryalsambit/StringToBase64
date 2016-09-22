package infosys.string.base64;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.bind.DatatypeConverter;


public class StringToBase64 extends JPanel{
   
	private static final long serialVersionUID = -6150663570623329203L;

	public void run() {
        final JFrame base64Frame = new JFrame("Encode/Decode application");
        final JTextField inputString = new JTextField();
        JButton encodeBtn = new JButton("Encode");
        JButton decodeBtn = new JButton("Decode");
        JLabel label = new JLabel("Enter String", JLabel.RIGHT);
        inputString.setColumns(10); 
        label.setLabelFor(inputString);
          
         
       
        JPanel base64Form = new JPanel();
        base64Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base64Frame.getContentPane().add(base64Form, BorderLayout.NORTH);
        JPanel base64Panel = new JPanel();
        base64Panel.add(label);
        base64Panel.add(inputString);
         
        final JTextArea resultArea = new JTextArea(50,50);
        resultArea.setEditable(false);
        encodeBtn.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
            	 if(inputString.getText().toString() != null && inputString.getText().toString().length() > 0){
            		 try {
						resultArea.setText(encode(inputString.getText().toString()));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
            	 }
              }
         });
         decodeBtn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) { 
            	 if(resultArea.getText().toString() != null && resultArea.getText().toString().length() > 0){
            		 try {
						resultArea.setText(decode(resultArea.getText().toString()));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
            	 }
	           	  

             }
         });
         base64Panel.add(encodeBtn);
         base64Panel.add(decodeBtn);
         base64Panel.add(resultArea);
         base64Frame.getContentPane().add(base64Panel, BorderLayout.SOUTH);
         base64Frame.pack();
         base64Frame.setVisible(true);
    }
	
	public static String encode(String value) throws Exception {
	      return  DatatypeConverter.printBase64Binary
	          (value.getBytes(StandardCharsets.UTF_8));
	}

   public static String decode(String value) throws Exception {
      byte[] decodedValue = DatatypeConverter.parseBase64Binary(value);
      return new String(decodedValue, StandardCharsets.UTF_8);
   }
}
