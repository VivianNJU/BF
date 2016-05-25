package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NewAccountPanel extends JPanel{

	private MainFrame frame;
	private JPasswordField passfield;
	private JTextField jtf1;//  用户名
	private JTextField jtf2;//密码第一遍
	private JTextField jtf3;//密码第二遍
	private JTextField jtf4;//保存版本数自定义
	NewAccountPanel(MainFrame frame){
		this.frame = frame;
		//frame.removeAll();
		frame.setVisible(false);
		frame.setTitle("BF Server : New Account");
		frame.setSize(800,500);
		
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
	      JPanel top = new JPanel(new GridLayout(4, 1, 0, frame.getHeight()/15));  
	      pane.add(BorderLayout.NORTH, top);  
	      top.add(createNamePane());  
	      top.add(createPwdPane());
	      top.add(createPwdAgPane());
	      top.add(createPerPane());
	      return pane;  
	  }  

	  private JPanel createNamePane() {  
	      JPanel pane = new JPanel(new BorderLayout(4, 0)); 
	      JLabel nameLabel = new JLabel("Username :         ");
	      nameLabel.setFont(frame.menuFont);
	      pane.add(BorderLayout.WEST,nameLabel); 
	      jtf1 = new JTextField(10);  
	      jtf1.setFont(frame.textFont);
	      pane.add(BorderLayout.CENTER, jtf1);  
	      return pane;  
	  }  

	  private JPanel createPwdPane() {  
	      JPanel pane = new JPanel(new BorderLayout(4, 0)); 
	      
	      JLabel passLabel = new JLabel("Password :         ");
	      passLabel.setFont(frame.menuFont);  
	      pane.add(BorderLayout.WEST,passLabel);
	      
	      
	      jtf2 = new JPasswordField();  
	      pane.add(BorderLayout.CENTER, jtf2);  
	      return pane;  
	  }  
	  
	  private JPanel createPwdAgPane() {  
	      JPanel pane = new JPanel(new BorderLayout(4, 0)); 
	      
	      JLabel passLabel = new JLabel("Password Again :");
	      passLabel.setFont(frame.menuFont);  
	      pane.add(BorderLayout.WEST,passLabel);
	      
	      
	      jtf3 = new JPasswordField();  
	      pane.add(BorderLayout.CENTER, jtf3);  
	      return pane;  
	  }  
	  
	  private JPanel createPerPane() {  
	      JPanel pane = new JPanel(new GridLayout(1,3,30,0)); 
	      
	      JLabel perLabel = new JLabel("Save versions");
	      perLabel.setFont(frame.menuFont);  
	      pane.add(perLabel);
	      
	      ButtonGroup versionNum = new ButtonGroup();
	      pane.add(radioBtwPane(versionNum));
	      pane.add(customPane(versionNum));     
	      return pane;  
	  } 
	  
	  private JPanel radioBtwPane(ButtonGroup versionNum){
		  JPanel pane = new JPanel(new GridLayout(1,2,10,0)); 	  
	      
	      JRadioButton five = new JRadioButton("5    ",true);
	      five.setFont(frame.menuFont);
	      versionNum.add(five);
	      pane.add(five);
	      
	      JRadioButton ten = new JRadioButton("10",false);
	      ten.setFont(frame.menuFont);
	      versionNum.add(ten);
	      pane.add(ten);
	      
	      
	      return pane;
	  }
	  
	  private JPanel customPane(ButtonGroup versionNum){
		  JPanel pane = new JPanel(new BorderLayout());
		  
		  JRadioButton custom = new JRadioButton("custom  ",false);
	      custom.setSize(frame.getWidth()/5,frame.getWidth()/5);
	      custom.setFont(frame.menuFont);
	      versionNum.add(custom);
	      pane.add(BorderLayout.WEST,custom);
	      
	      jtf4 = new JPasswordField(); 
	      pane.add(BorderLayout.CENTER,jtf4);
	      
	      return pane;
	  }


	  private JPanel createBtnPane() {  
		  FlowLayout btLayout = new FlowLayout();
		  btLayout.setHgap(frame.getWidth()/10);
	      JPanel pane = new JPanel(btLayout);  
	      JButton login = new JButton("Finish");  
	      login.setFont(frame.menuFont);
	      login.addActionListener(new ActionListener() {  
	          public void actionPerformed(ActionEvent e) {  
	              /*if (jtf2.getText().equals("123")  
	                      && jtf1.getText().equals("123")) {  
	                  System.out.println("登录 ");  
	              } else {  
	                  System.out.println("登录失败");  
	              }  */
	        	  TextPanel textPanel = new TextPanel(frame);
	        	  
	          }  
	      });  
	      JButton cancel = new JButton(" Back ");
	      cancel.setFont(frame.menuFont);
	      cancel.addActionListener(new ActionListener() {  
	          public void actionPerformed(ActionEvent e) {  
	                LoginPanel lgp = new LoginPanel(frame);
	          }  
	      });  
	      pane.add(login);  
	      pane.add(cancel);  
	      return pane;  
	  }  
	
	
}
