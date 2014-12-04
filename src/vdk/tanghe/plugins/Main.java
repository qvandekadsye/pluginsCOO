package vdk.tanghe.plugins;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PluginFinder pluginFinder = new PluginFinder("/home/l3/tanghe/dropins");
		
		System.out.println("Plugins finder");
		
		System.out.println("Launching the timer...");
		pluginFinder.start();
		
		System.out.println(pluginFinder.getClassFiles().size()+" plugins found:");
		
		for(String s : pluginFinder.getClassFiles())
			System.out.println("  - " + s);

	}

}
