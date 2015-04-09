import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//import java.lang.Object;

public class printGUI extends Frame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	static JMenuBar menu = new JMenuBar();
	static JMenuItem newPrint, exit;
		
	static Insets insets;
	//static JFrame frame;
	static Container pane;
	static JButton submit;
	
	static JLabel ip;
	static JLabel pName;
	static JTextField ipComp;
	static JTextField printerName;
	
	
	static DefaultListModel model;
	static JList list;
	
	public printGUI(String title) {
		super(title);  // set frame title.
		
		// Arrange to detect window close events
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				int input = JOptionPane.showConfirmDialog(null,
					"Are you sure?"
				);
				if(input==0){
					System.exit(0); 
				}
			}
		});
		
		
		// Create the menubar. Tell the frame about it.
		MenuBar menubar = new MenuBar();
		this.setMenuBar(menubar);
		
		// Create the file menu. Add to menubar.
		Menu file = new Menu("File");
		menubar.add(file);
		
		// Create items for the file menu, setting their label, shortcut,
		// action command and listener.  Add them to File menu.
		// Note that we use the frame itself as the action listener
		MenuItem open = new MenuItem("Open", new MenuShortcut(KeyEvent.VK_O));
		open.setActionCommand("open");
		open.addActionListener(this);
		file.add(open);
		
		MenuItem newP = new MenuItem("New Printer", new MenuShortcut(KeyEvent.VK_N));
		newP.setActionCommand("new");
		newP.addActionListener(this);
		file.add(newP);
		
		MenuItem quit = new MenuItem("Quit", new MenuShortcut(KeyEvent.VK_Q));
		quit.setActionCommand("quit");
		quit.addActionListener(this);
		file.add(quit);
		
		// Create Help menu; add an item; add to menubar
		// Display the help menu in a special reserved place.
		Menu help = new Menu("Help");
		menubar.add(help);
		menubar.setHelpMenu(help);
		
		// Create and add an item to the Help menu
		MenuItem about = new MenuItem("About", new MenuShortcut(KeyEvent.VK_A));
		about.setActionCommand("about");
		about.addActionListener(this);
		help.add(about);
		
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		
		insets = this.getInsets();
		this.setLayout (null);
		model = new DefaultListModel();
		list = new JList(model);
		list.setMinimumSize(new Dimension(250, 150));
		list.setBorder(BorderFactory.createEtchedBorder());
		
		submit = new JButton("Submit");
		ip = new JLabel("131.204.116.");
		pName = new JLabel("Printer Name:");
		ipComp = new JTextField(10);
		printerName = new JTextField(10);
		
		this.add(submit);
		this.add(ip);
		this.add(pName);
		this.add(ipComp);
		this.add(printerName);
		this.add(list);
		submit.addActionListener(new btnSubmitAction());
		
		ip.setBounds (insets.left + 5, insets.top + 25, 85, ip.getPreferredSize().height);
		pName.setBounds (insets.left + 5, insets.top + 40, 85, ip.getPreferredSize().height);
		ipComp.setBounds (ip.getX() + ip.getWidth() + 5, insets.top + 25, ip.getPreferredSize().width, ip.getPreferredSize().height);
		printerName.setBounds(pName.getX() + pName.getWidth() + 5, insets.top + 40, pName.getPreferredSize().width, pName.getPreferredSize().height);
		submit.setBounds (ipComp.getX() + ipComp.getWidth() + 5, insets.top + 25, submit.getPreferredSize().width, submit.getPreferredSize().height);
		list.setBounds(50, 70, 200, 100);	
	}
	

	/** This is the action listener method that the menu items invoke */
	public void actionPerformed(ActionEvent e) {
	    String command = e.getActionCommand();
	    if (command.equals("quit")) {
			Object[] options = {"Yes", "No"};
			int input = JOptionPane.showOptionDialog(this, 
				"Are you sure you want to quit?",
				"Quit",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]
			);
			if(input==0){
				System.exit(0); 
			}
		}
	    else if (command.equals("open")) {
			FileDialog d = new FileDialog(this, "Open File", FileDialog.LOAD);
			d.setVisible(true);  // display the dialog and block until answered
			d.dispose();
	    }
	    else if (command.equals("new")) {
			FileDialog d = new FileDialog(this, "Open File", FileDialog.LOAD);
			d.setVisible(true);  // display the dialog and block until answered
			d.dispose();
	    }
	    else if (command.equals("about")) {  
			InfoDialog d = new InfoDialog(this, "About", "This demo was written by David Flanagan Copyright (c) 1997 O'Reilly & Associates");
			d.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		Frame f = new printGUI("AWT Demo");
		f.setSize(300,400);
		f.setVisible(true);
	}
}
