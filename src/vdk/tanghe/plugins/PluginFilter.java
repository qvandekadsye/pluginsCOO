package vdk.tanghe.plugins;
import java.io.File;

public class PluginFilter implements java.io.FilenameFilter{
	
	/**
	 * Private constructor of PluginFilter
	 */
	private PluginFilter()
	{
		
	}
	
	/**
	 * @return An instance of PluginFilter.
	 */
	public static PluginFilter getInstance()
	{
		return new PluginFilter();
	}

	/**Method used to check extension's files.
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File arg0, String name) {
		
		
		return name.endsWith(".class");
	}
	

}
