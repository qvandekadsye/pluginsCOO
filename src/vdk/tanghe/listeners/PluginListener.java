package vdk.tanghe.listeners;

/**
 * Interface in order to manage behaviors when a plugin is added or removed.
 *
 */
public interface PluginListener {
	
	/**
	 * Behavior when a plugin is added.
	 * @param e The plugin.
	 */
	public void pluginAdded(PluginEvent e);
	
	/**
	 * Behavior when the plugin is removed.
	 * @param e The plugin.
	 */
	public void pluginRemoved(PluginEvent e);
	
	public boolean isKnown(PluginEvent e);

}
