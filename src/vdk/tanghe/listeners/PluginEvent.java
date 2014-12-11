package vdk.tanghe.listeners;

import plugins.Plugin;

public class PluginEvent {
	protected String name;
	protected Class<? extends Plugin> source;
	
	/**
	 * Constructor
	 * @param name name of the plugin.
	 */
	public PluginEvent(String name, Class<? extends Plugin> source)
	{
		this.name = name;
		this.source = source;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Class<? extends Plugin> getSource() {
		
		return this.source;
	}
	
	/**
	 * @param e the object to compare to this.
	 * @return whether the object is the same than
	 * the instance on which the method is called.
	 */
	@Override
	public boolean equals(Object o) {
		
		PluginEvent e = (PluginEvent) o;
		
		if(e.getName().equals(this.name) && e.getSource().equals(this.source))
			return true;
		else
			return false;
		
	}

}
