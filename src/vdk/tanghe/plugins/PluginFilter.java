package vdk.tanghe.plugins;
import java.io.File;

public class PluginFilter implements java.io.FilenameFilter{
	
	private PluginFilter()
	{
		
	}
	
	public static PluginFilter getInstance()
	{
		return new PluginFilter();
	}

	@Override
	public boolean accept(File arg0, String name) {
		
		
		return name.endsWith(".class");
	}
	

}
