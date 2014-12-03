package vdk.tanghe.listeners;

public class PluginAddedLogger implements PluginListener {

	/**Print message in console, for more informations :
	 * @see vdk.tanghe.listeners.PluginListener#pluginAdded(vdk.tanghe.listeners.PluginEvent)
	 */
	@Override
	public void pluginAdded(PluginEvent e) {
		System.out.println(e.getName()+" added !");
		
	}

	/** /**Print message in console, for more informations :
	 * @see vdk.tanghe.listeners.PluginListener#pluginRemoved(vdk.tanghe.listeners.PluginEvent)
	 */
	@Override
	public void pluginRemoved(PluginEvent e) {
		System.out.println(e.getName()+" removed !");
		
	}

}
