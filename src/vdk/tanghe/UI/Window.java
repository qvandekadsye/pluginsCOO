package vdk.tanghe.UI;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import vdk.tanghe.listeners.*;

public class Window implements PluginListener {
	JFrame frame;
	JMenuBar menuBar;
	JMenu pluginMenu;
	JPanel panel;
	JTextPane textpane;
	
	public Window()
	{
		this.frame=new JFrame();
		this.setMenu();
		this.setwindow();
		
		
	}

	private void setMenu() 
	{
		this.menuBar=new JMenuBar();
		this.frame.setJMenuBar(menuBar);
		this.pluginMenu=new JMenu("Plug-in");
		this.menuBar.add(pluginMenu);
		
	}

	private void setwindow() 
	{
		this.frame.setTitle("TP Plugin");
		this.frame.setSize(640, 360);
		this.frame.setVisible(true);
		
	}

	@Override
	public void pluginAdded(PluginEvent e) {
		this.pluginMenu.add(new JMenuItem(e.getName()));
		
	}

	@Override
	public void pluginRemoved(PluginEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isKnown(PluginEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}
