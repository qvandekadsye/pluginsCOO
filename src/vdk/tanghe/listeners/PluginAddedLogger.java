package vdk.tanghe.listeners;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to create a log.
 * @author Quentin Van de Kadsye and Jerome Tanghe.
 * 
 *
 */
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
		if(isKnown(e))
			pluginsList.remove(e);
		
	}
	
	public boolean isKnown(PluginEvent e) {
		
		return pluginsList.contains(e);
		
	}

}
