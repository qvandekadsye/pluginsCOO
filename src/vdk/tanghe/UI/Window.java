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

/**
 * The main window.
 * @author Quentin Van de Kadsye and Jérôme Tanghe.
 * 
 *
 */
public class Window implements PluginListener {
	JFrame frame;
	/**
	 * This windows will be open when the program will open.
	 */
	JMenuBar menuBar;
	JMenu pluginMenu;
	JPanel panel;
	JTextPane textpane;
	
	/**
	 * Constructor.
	 */
	public Window()
	{
		this.frame=new JFrame();
		this.setMenu();
		this.setwindow();
		this.textpane=new JTextPane();
		this.textpane.setSize(600,300);
		this.frame.add(this.textpane);
		
		
	}

	/**
	 * Setting the window's menu.
	 */
	private void setMenu() 
	{
		this.menuBar=new JMenuBar();
		this.frame.setJMenuBar(menuBar);
		this.pluginMenu=new JMenu("Plug-in");
		this.menuBar.add(pluginMenu);
		
	}

	/**
	 * Setting the window.
	 */
	private void setwindow() 
	{
		this.frame.setTitle("TP Plugin");
		this.frame.setSize(640, 360);
		this.frame.setVisible(true);
		
	}

	/** This function set the window behavior when a new plugin is detected.
	 * @see vdk.tanghe.listeners.PluginListener#pluginAdded(vdk.tanghe.listeners.PluginEvent)
	 **/
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
			
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			
			e1.printStackTrace();
		}
		
	}

	private Plugin getPluginAsObject(Class<? extends Plugin> plugClass) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		return plugClass.getConstructor((Class<?>[]) null).newInstance((Object[]) null);
		
	}

	/**(This function set the window behavior when a plugin is removed.
	 * @see vdk.tanghe.listeners.PluginListener#pluginRemoved(vdk.tanghe.listeners.PluginEvent)
	 */
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
