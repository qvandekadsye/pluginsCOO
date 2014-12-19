package vdk.tanghe.UI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import plugins.Plugin;

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
		this.textpane=new JTextPane();
		this.textpane.setSize(600,300);
		this.frame.add(this.textpane);
		
		
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
		Class<? extends Plugin> plugClass=e.getSource();
				
		try {
			
			
			
			final Plugin pluginObject = getPluginAsObject(plugClass);
			String label = pluginObject.getLabel();
			JMenuItem plugitem = new JMenuItem(label);
			plugitem.setName(e.getName());
			
			plugitem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					String textTransformed = pluginObject.transform(Window.this.textpane.getText());
					
					Window.this.textpane.setText(textTransformed);
					
				}
			});
			
			this.pluginMenu.add(plugitem);
			
			
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private Plugin getPluginAsObject(Class<? extends Plugin> plugClass) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		return plugClass.getConstructor((Class<?>[]) null).newInstance((Object[]) null);
		
	}

	@Override
	public void pluginRemoved(PluginEvent e) {
				
		for(int i = 0; i < this.pluginMenu.getItemCount(); i++) {
			
			JMenuItem menuItem = this.pluginMenu.getItem(i);
			
			if(menuItem.getName().equals(e.getName())) {
				
				this.pluginMenu.remove(i);
				System.out.println("		Removed from the menu.");
				
			}
			
		}
		
	}

}
