package vdk.tanghe.listeners;

public class PluginAddedLogger implements PluginListener {

	@Override
	public void pluginAdded(PluginEvent e) {
		System.out.println(e.getName()+" added !");
		
	}

	@Override
	public void pluginRemoved(PluginEvent e) {
		System.out.println(e.getName()+" removed !");
		
	}

}
