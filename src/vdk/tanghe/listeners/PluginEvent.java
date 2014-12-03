package vdk.tanghe.listeners;

public class PluginEvent {
	protected String source, name;
	
	public PluginEvent(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}

}
