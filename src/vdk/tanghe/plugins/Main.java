package vdk.tanghe.plugins;

import vdk.tanghe.UI.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length == 0) {
 			System.out.println("Missing argument: please tell me which folder I must look!");
 			System.out.println("Usage: ./plugin.jar <folder>");
 			return;
 		}
		
		Window window = new Window();
 		
		String path = args[0];
		
		PluginFinder pluginFinder = new PluginFinder(path);
		
		pluginFinder.addPluginListener(window);
		
		System.out.println("Plugins finder");
		
		System.out.println("Launching the timer...");
		pluginFinder.start();
		
		System.out.println(pluginFinder.getClassFiles().size()+" plugins found:");
		
		for(String s : pluginFinder.getClassFiles())
			System.out.println("  - " + s); 
			
		
	}

}

