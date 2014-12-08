package vdk.tanghe.listeners;

public class PluginEvent {
	protected String source, name;
	
	/**
	 * Constructor
	 * @param name name of the plugin.
	 */
	public PluginEvent(String name)
	{
		this.name = name;
		this.source = "";
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getSource() {
		
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
