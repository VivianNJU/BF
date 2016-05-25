package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPanel extends JPanel{

	private MainFrame frame;
	private JPasswordField passfield;
	private JTextField jtf1;  
	private JTextField jtf2;  
	LoginPanel(MainFrame frame){
		this.frame = frame;
		//frame.removeAll();
		frame.setTitle("BF Server : Log In");
		frame.setSize(500,300);
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screen=toolkit.getScreenSize();     
	    frame.setLocation((screen.width -frame.getWidth())/2,(screen.height -frame.getHeight())/2);
		
		this.setSize(frame.getWidth(),frame.getHeight());
		this.setLayout(new BorderLayout(0, 8)); 
	    this.setBorder(new EmptyBorder(12, 12, 12, 12));  
	    this.add(BorderLayout.NORTH, new JLabel("\n", JLabel.CENTER));  
	    this.add(BorderLayout.CENTER, createNamePwdPane());  
	    this.add(BorderLayout.SOUTH, createBtnPane());
	    	
	    
	    frame.setContentPane(this);
	    this.setVisible(true);
	    frame.setVisible(true);
	}
	

	  private JPanel createNamePwdPane() {  
	      JPanel pane = new JPanel(new BorderLayout());  
	      JPanel top = new JPanel(new GridLayout(2, 1, 0, frame.getHeight()/8));  
	      pane.add(BorderLayout.NORTH, top);  
	      top.add(createNamePane());  
	      top.add(createPwdPane());  
	      return pane;  
	  }  

	  private JPanel createNamePane() {  
	      JPanel pane = new JPanel(new BorderLayout(4, 0)); 
	      JLabel nameLabel = new JLabel("Username : ");
	      nameLabel.setFont(frame.menuFont);
	      pane.add(BorderLayout.WEST,nameLabel); 
	      jtf1 = new JTextField(10);  
	      jtf1.setFont(frame.textFont);
	      pane.add(BorderLayout.CENTER, jtf1);  
	      return pane;  
	  }  

	  private JPanel createPwdPane() {  
	      JPanel pane = new JPanel(new BorderLayout(4, 0)); 
	      
	      JLabel nameLabel = new JLabel("Password : ");
	      nameLabel.setFont(frame.menuFont);  
	      pane.add(BorderLayout.WEST,nameLabel);
	      
	      jtf2 = new JPasswordField();  
	      pane.add(BorderLayout.CENTER, jtf2);  
	      return pane;  
	  }  

	  private JPanel createBtnPane() {  
		  FlowLayout btLayout = new FlowLayout();
		  btLayout.setHgap(frame.getWidth()/10);
	      JPanel pane = new JPanel(btLayout);  
	      JButton login = new JButton("Log In");  
	      login.setFont(frame.menuFont);
	      login.addActionListener(new ActionListener() {  
	          public void actionPerformed(ActionEvent e) {  
	              /*if (jtf2.getText().equals("123")  
	                      && jtf1.getText().equals("123")) {  
	                  System.out.println("µÇÂ¼ ");  
	              } else {  
	                  System.out.println("µÇÂ¼Ê§°Ü");  
	              }  */
	        	  TextPanel textPanel = new TextPanel(frame);
	        	  
	          }  
	      });  
	      JButton cancel = new JButton(" New ");
	      cancel.setFont(frame.menuFont);
	      cancel.addActionListener(new ActionListener() {  
	          public void actionPerformed(ActionEvent e) {  
	                NewAccountPanel nap = new NewAccountPanel(frame);
	          }  
	      });  
	      pane.add(login);  
	      pane.add(cancel);  
	      return pane;  
	  }  
	
	
}
