package vdk.tanghe.plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

import vdk.tanghe.exception.PluginListenerNotListened;
import vdk.tanghe.listeners.PluginEvent;
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
		filter = PluginFilter.getInstance();
		
		memory = new ArrayList<String>();
		listeners = new ArrayList<PluginListener>();
		
		TimerActionListener al = new TimerActionListener();
		
		timer = new Timer(100, al);
		
	}
	
	/**
	 * Launches the surveillance of the directory.
	 */
	public void start() {
		
		while(true)
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
		
		listeners.add(l);
		
	}
	
	/**
	 * Removes <code>l</code> from the list of plugins to listen
	 * @param l the plugin to remove
	 * @throws PluginListenerNotListened thrown if <code>l</code> was not in the list of the plugins to listen
	 */
	public void removePluginListener(PluginListener l) throws PluginListenerNotListened {
		
		if(!listeners.contains(l))
			throw new PluginListenerNotListened();
		
		listeners.remove(l);
		
	}
	
	/**
	 * This method is fired when a plugin is added to the directory
	 * @param name
	 */
	protected void firePluginAdded(String name) {
		
		for(PluginListener l : listeners) {
			
			l.pluginAdded(new PluginEvent(name));
			
		}
		
	}

	/**
	 * This method is fired when a plugin is removed from the directory
	 * @param name
	 */
	protected void firePluginRemoved(String name) {
		
		for(PluginListener l : listeners)
			l.pluginRemoved(new PluginEvent(name));
		
	}
	
	/**
	 * The listener used by the timer
	 */
	protected class TimerActionListener implements ActionListener {

		/**
		 * Action performed at every timeout.
		 * @param e is an unused parameter. Use <code>NULL</code> value.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			List<String> plugins = PluginFinder.this.getClassFiles();
			List<String> filesInDir = getFilesInDir();
			
			// Checking new files
			for(String p : filesInDir) {
				
				if(!memory.contains(p)) {
					
					// New file, adding to the memory
					System.out.println("   New file found: "+p);
					memory.add(p);
					firePluginAdded(p);
					
				}
				
			}
			
			List<String> instantMemory = new ArrayList<String>(memory);
			
			// Checking disappearing files 
			for(String p : memory) {
				
				if(!filesInDir.contains(p)) {
					
					// File removed, removing it from the memory
					System.out.println("   File "+p+" removed");
					instantMemory.remove(p);
					firePluginRemoved(p);
					
				}
				
			}
			
			memory = new ArrayList<String>(instantMemory);
			
		}

		/**
		 * @return the list of files contained in the directory
		 */
		protected List<String> getFilesInDir() {
			
			List<String> files = new ArrayList<String>();
			
			for(String file : PluginFinder.this.dir.list()) {
				
				files.add(file);
				
			}
			
			return files;
		}
		
	}
	
}
