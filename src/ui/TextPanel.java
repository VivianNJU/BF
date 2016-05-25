package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.*;

import rmi.RemoteHelper;


public class TextPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private MainFrame frame;
	private JTextArea paraText;
	private JLabel resultLabel;
	private Font textFont;
	private JTextArea textArea;
	private JMenuBar menuBar;
	

	TextPanel(MainFrame frame){
		this.frame = frame;
		textFont = new Font("serif",Font.BOLD,20);
		
		frame.setVisible(false);
		frame.setTitle("BF Server");
		frame.setSize(MainFrame.JFRAME_WIDTH,MainFrame.JFRAME_HIGHT);
		
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screen=toolkit.getScreenSize();     
	    frame.setLocation((screen.width -frame.getWidth())/2,(screen.height -frame.getHeight())/2);
	    
	    initialMenu();
		this.setLayout(new GridLayout(2,1));
		
		initialText();
		setSize(MainFrame.JFRAME_WIDTH,MainFrame.JFRAME_HIGHT);
		
		frame.setContentPane(this);
		this.setVisible(true);
		frame.setVisible(true);
	}
	
	void initialText(){
		
		//显示代码
		textArea = new JTextArea();
		textArea.setFont(textFont);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setBackground(Color.WHITE);
		add(textArea);
		
		add(createPar());
		textArea.setBorder(getMyBorder("Code"));
	}
	
	private JPanel createPar(){
		JPanel pane = new JPanel(new GridLayout(1,2,10,0)); 
		//显示变量
		paraText = new JTextArea();
		paraText.setFont(textFont);
		paraText.setMargin(new Insets(10, 10, 10, 10));
		paraText.setOpaque(true);
		paraText.setBorder(getMyBorder("Paramter"));
		pane.add(paraText);

		// 显示结果
		resultLabel = new JLabel();
		resultLabel.setFont(textFont);
		resultLabel.setBackground(Color.white);
		resultLabel.setBorder(getMyBorder("Result"));
		pane.add(resultLabel);
		return pane;
	}
	
	Border getMyBorder(String title){
		Font titleFont = new Font("serif",Font.BOLD,30);
		LineBorder lineBorder = new LineBorder(Color.LIGHT_GRAY,2,false);
		TitledBorder titleBorder = new TitledBorder(lineBorder,title,0,2,titleFont);
		Border margin = new EmptyBorder(20,20,20,20);
		CompoundBorder border = new CompoundBorder(margin,titleBorder);
		return border;
	}
	

	
	
	public void initialMenu(){
		menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(frame.menuFont);
		menuBar.add(fileMenu);
		
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.setFont(frame.menuFont);
		fileMenu.add(newMenuItem);
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.setFont(frame.menuFont);
		fileMenu.add(openMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setFont(frame.menuFont);
		fileMenu.add(saveMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setFont(frame.menuFont);
		fileMenu.add(exitMenuItem);
		
		
		
		JMenu runMenu = new JMenu("Run");
		runMenu.setFont(frame.menuFont);
		menuBar.add(runMenu);
		
		JMenuItem executeMenuItem = new JMenuItem("Execute");
		executeMenuItem.setFont(frame.menuFont);
		runMenu.add(executeMenuItem);
		
		
		frame.setJMenuBar(menuBar);

		newMenuItem.addActionListener(new MenuItemActionListener());
		openMenuItem.addActionListener(new MenuItemActionListener());
		saveMenuItem.addActionListener(new SaveActionListener());
		executeMenuItem.addActionListener(new ExecuteActionListener());
		exitMenuItem.addActionListener(new MenuItemActionListener());
		
		addAccount();

	}
	
	public void addAccount(){
		JMenu accountMenu = new JMenu("Account");
		accountMenu.setFont(frame.menuFont);
		menuBar.add(accountMenu);
		
		JMenuItem loginMenuItem = new JMenuItem("Log In");
		loginMenuItem.setFont(frame.menuFont);
		accountMenu.add(loginMenuItem);
		
		JMenu versionMenuItem = new JMenu("Version");
		versionMenuItem.setFont(frame.menuFont);
		accountMenu.add(versionMenuItem);
		
		JMenuItem logoutMenuItem = new JMenuItem("Log Out");
		logoutMenuItem.setFont(frame.menuFont);
		accountMenu.add(logoutMenuItem);
		
		loginMenuItem.addActionListener(new AccountActionListener());
		logoutMenuItem.addActionListener(new AccountActionListener());
		
		
	}
	


	class MenuItemActionListener implements ActionListener {
		/**
		 * 子菜单响应事件
		 * 		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Open")) {
				textArea.setText("Open");
			} else if (cmd.equals("Save")) {
				textArea.setText("Save");
			} else if (cmd.equals("Exit")){
				System.exit(0);
			}
		}
	}
	
	class AccountActionListener implements ActionListener {
		/**
		 * 子菜单响应事件
		 * 		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Log IN")) {
				//JDialog login = new JDialog();
			} 
		}
	}

	class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String code = textArea.getText();
			try {
				RemoteHelper.getInstance().getIOService().writeFile(code, "admin", "code");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}
	
	class ExecuteActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String code;
			String param = paraText.getText();
			String result;
			try {
				code = RemoteHelper.getInstance().getIOService().readFile("admin", "code");
				System.out.println("code is "+code);
				result = RemoteHelper.getInstance().getExecuteService().execute(code, param);
				resultLabel.setText(result);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}
	
	
}
