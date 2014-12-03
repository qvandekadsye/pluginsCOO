package vdk.tanghe.listeners;

public class PluginEvent {
	protected String source, name;
	
	/**
	 * Constructor
	 * @param name name of the plugin.
	 */
	public PluginEvent(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}

}
