package vdk.tanghe.plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

/**
 * The <code>PluginFinder</code> class looks for the new files stored in the
 * plugins directory and perform them.
 */
public class PluginFinder {
	
	protected List<String> memory;
	protected File dir;
	protected Timer timer;
	protected List<PluginListener> listeners;
	
	
	/**
	 * Constructor
	 * @param dirName the directory which will be explored to look for changes
	 */
	public PluginFinder(String dirName) {
		
		dir = new File(dirName);
		
		memory = new ArrayList<String>();
		listeners = new ArrayList<PluginListener>();
		
		TimerActionListener al = new TimerActionListener();
		
		timer = new Timer(100, al);
		
	}
	
	/**
	 * Launches the lookup of the directory.
	 */
	public void start() {
		
	}
	
	public List<String> getClassFiles() {

		List<String> classFiles = new ArrayList<String>();
		
		for(String file : memory) {
			
			if(file.endsWith(".class"))
				classFiles.add(file);
			
		}
		
		return classFiles;
		
	}
	
	public void addPluginListener(PluginListener l) {
		
	}
	
	public void removePluginListener(PluginListener l) {
		
	}
	
	protected void firePluginAdded(String name) {
		
	}

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
