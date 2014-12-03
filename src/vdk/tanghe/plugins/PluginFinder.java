package vdk.tanghe.plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

import vdk.tanghe.listeners.PluginListener;

/**
 * The <code>PluginFinder</code> class looks for the new files stored in the
 * plugins directory and perform them.
 * To launch the surveillance of the directory, you must call the <code>start()</code>
 * method.
 */
public class PluginFinder {
	
	protected List<String> memory;
	protected File dir;
	protected Timer timer;
	protected List<PluginListener> listeners;
	protected PluginFilter filter;
	
	/**
	 * Constructor
	 * @param dirName the directory which will be explored to look for changes
	 */
	public PluginFinder(String dirName) {
		
		dir = new File(dirName);
		filter = new PluginFilter();
		
		memory = new ArrayList<String>();
		listeners = new ArrayList<PluginListener>();
		
		TimerActionListener al = new TimerActionListener();
		
		timer = new Timer(100, al);
		
	}
	
	/**
	 * Launches the surveillance of the directory.
	 */
	public void start() {
		
		timer.start();
		
	}
	
	/**
	 * Stops the surveillance of the directory
	 */
	public void stop() {
		
		timer.stop();
		
	}
	
	/**
	 * @return a list of the class files available in the directory.
	 */
	public List<String> getClassFiles() {

		List<String> classFiles = new ArrayList<String>();
		
		for(String fileName : memory) {
			
			if(filter.accept(dir, fileName))
				classFiles.add(fileName);
			
		}
		
		return classFiles;
		
	}
	
	/**
	 * Adds <code>l</code> to a list of plugins to listen
	 * @param l the plugin to listen
	 */
	public void addPluginListener(PluginListener l) {
		
	}
	
	/**
	 * Removes <code>l</code> from the list of plugins to listen
	 * @param l the plugin to remove
	 */
	public void removePluginListener(PluginListener l) {
		
	}
	
	/**
	 * This method is fired when a plugin is added to the directory
	 * @param name
	 */
	protected void firePluginAdded(String name) {
		
	}

	/**
	 * This method is fired when a plugin is removed from the directory
	 * @param name
	 */
	protected void firePluginRemoved(String name) {
		
	}
	
	protected class TimerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			List<String> plugins = PluginFinder.this.getClassFiles();
			
			// Checking new files
			for(String p : plugins) {
				
				if(!memory.contains(p)) {
					
					// New file, adding to the memory
					memory.add(p);
					firePluginAdded(p);
					
				}
				
			}
			
			// Checking disappearing files 
			for(String p : memory) {
				
				if(!plugins.contains(p)) {
					
					// File removed, removing it from the memory
					memory.remove(p);
					firePluginRemoved(p);
					
				}
				
			}
			
		}
		
	}
	
}
