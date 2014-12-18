package vdk.tanghe.UI;


import java.awt.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
		
		List<Method> allMethods = new ArrayList<Method>();
		
		try {
			
			allMethods.add(plugClass.getMethod("getLabel", (Class<?>) null));
			allMethods.add(plugClass.getMethod("transform", String.class));
			allMethods.add(plugClass.getMethod("helpMessage", (Class<?>) null));
			
			Plugin pluginObject = getPluginAsObject(plugClass);
			
			pluginObject.
			
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
		
		return plugClass.getConstructor(null).newInstance(null);
		
	}

	@Override
	public void pluginRemoved(PluginEvent e) {
		Component[] tabMI;
		tabMI=this.pluginMenu.getComponents();
		System.out.println(tabMI.length);
		/*test git*/
		
	}

	@Override
	public boolean isKnown(PluginEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}
