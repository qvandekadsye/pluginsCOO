package vdk.tanghe.listeners;

import java.util.ArrayList;
import java.util.List;

public class PluginAddedLogger implements PluginListener {

	protected List<PluginEvent> pluginsList;
	
	public PluginAddedLogger() {
		
		pluginsList = new ArrayList<PluginEvent>();
		
	}
	
	/**Print message in console, for more informations :
	 * @see vdk.tanghe.listeners.PluginListener#pluginAdded(vdk.tanghe.listeners.PluginEvent)
	 */
	@Override
	public void pluginAdded(PluginEvent e) {
		System.out.println(e.getName()+" added !");
		pluginsList.add(e);
		
	}

	/** /**Print message in console, for more informations :
	 * @see vdk.tanghe.listeners.PluginListener#pluginRemoved(vdk.tanghe.listeners.PluginEvent)
	 */
	@Override
	public void pluginRemoved(PluginEvent e) {
		System.out.println(e.getName()+" removed !");
		pluginsList.remove(e);
		
	}
	
	@Override
	public boolean isKnown(PluginEvent e) {
		
		System.out.println("IsKnown : "+pluginsList.contains(e));
		System.out.println("Nb: "+pluginsList.size());
		return pluginsList.contains(e);
		
	}

}
