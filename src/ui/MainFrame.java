package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.*;

import rmi.RemoteHelper;


public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static final int JFRAME_WIDTH=1024;
	public static final int JFRAME_HIGHT=768;
	
	JMenuBar menuBar;
	JTextArea textArea;
	JLabel resultLabel;
	TextPanel textPanel;
	Font menuFont;
	Font textFont;

	public MainFrame() {
		//´´½¨´°Ìå
		textFont = new Font("serif",Font.BOLD,20);
		menuFont = new Font("SansSerif",Font.PLAIN,20);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(JFRAME_WIDTH, JFRAME_HIGHT);
		
		LoginPanel login = new LoginPanel(this);
		
	}
	
	/*public void setTextArea(JTextArea ta){
		this.textArea = ta;
	}
	
	public void initialMenu(){
		this.setTitle("BF Server");
		
		menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(menuFont);
		menuBar.add(fileMenu);
		
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.setFont(menuFont);
		fileMenu.add(newMenuItem);
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.setFont(menuFont);
		fileMenu.add(openMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setFont(menuFont);
		fileMenu.add(saveMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setFont(menuFont);
		fileMenu.add(exitMenuItem);
		
		
		
		JMenu runMenu = new JMenu("Run");
		runMenu.setFont(menuFont);
		menuBar.add(runMenu);
		
		JMenuItem executeMenuItem = new JMenuItem("Execute");
		executeMenuItem.setFont(menuFont);
		runMenu.add(executeMenuItem);
		
		
		this.setJMenuBar(menuBar);

		newMenuItem.addActionListener(new MenuItemActionListener());
		openMenuItem.addActionListener(new MenuItemActionListener());
		saveMenuItem.addActionListener(new SaveActionListener());
		executeMenuItem.addActionListener(new ExecuteActionListener());
		exitMenuItem.addActionListener(new MenuItemActionListener());
		
		addAccount();

	}
	
	public void addAccount(){
		JMenu accountMenu = new JMenu("Account");
		accountMenu.setFont(menuFont);
		menuBar.add(accountMenu);
		
		JMenuItem loginMenuItem = new JMenuItem("Log In");
		loginMenuItem.setFont(menuFont);
		accountMenu.add(loginMenuItem);
		
		JMenu versionMenuItem = new JMenu("Version");
		versionMenuItem.setFont(menuFont);
		accountMenu.add(versionMenuItem);
		
		JMenuItem logoutMenuItem = new JMenuItem("Log Out");
		logoutMenuItem.setFont(menuFont);
		accountMenu.add(logoutMenuItem);
		
		loginMenuItem.addActionListener(new AccountActionListener());
		logoutMenuItem.addActionListener(new AccountActionListener());
		
		
	}
	


	class MenuItemActionListener implements ActionListener {
		
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
			String param = textPanel.getParam();
			String result;
			try {
				code = RemoteHelper.getInstance().getIOService().readFile("admin", "code");
				System.out.println("code is "+code);
				result = RemoteHelper.getInstance().getExecuteService().execute(code, param);
				textPanel.setResult(result);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}*/
}
