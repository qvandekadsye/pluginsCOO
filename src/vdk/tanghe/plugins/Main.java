package vdk.tanghe.plugins;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dossier à surveiller : ");
		String path = sc.next();
		
		PluginFinder pluginFinder = new PluginFinder(path);
		
		System.out.println("Plugins finder");
		
		System.out.println("Launching the timer...");
		pluginFinder.start();
		
		System.out.println(pluginFinder.getClassFiles().size()+" plugins found:");
		
		for(String s : pluginFinder.getClassFiles())
			System.out.println("  - " + s);

	}

}
