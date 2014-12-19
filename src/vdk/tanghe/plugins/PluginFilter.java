package vdk.tanghe.plugins;
import java.io.File;
import java.lang.reflect.Constructor;

import plugins.Plugin;

public class PluginFilter implements java.io.FilenameFilter {
	
	private static PluginFilter pluginFilter;
	
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
		if(pluginFilter == null)
			pluginFilter = new PluginFilter();
		
		return pluginFilter;
	}

	/**Method used to check extension's files.
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File arg0, String name) {
		
		boolean isADotClass = name.endsWith(".class");
				
		if(isADotClass) {
			
			try {
				
				Class<?> plugClass = getClassFromFile(name);
				
				return accept(plugClass);
				
				
			} catch (ClassNotFoundException e) {
				
				// The file does not contain a class
				return false;
				
			} catch (SecurityException e) {
				
				return false;
				
			}
			
		}
		else return false;
		
	}
	
	public boolean accept(Class<?> theClass) {
				
		try {
			
			Constructor<?> c;
			c = theClass.getConstructor();
			
			Class<?>[] cParameter = c.getParameterTypes();
			
			if(cParameter.length!=0)
				return false;
			
			if(Plugin.class.isAssignableFrom(theClass))
				return true;
			
			else return false;
			
		} catch (SecurityException e) {
			
			return false;
			
		} catch (NoSuchMethodException e) {
			
			return false;
			
		}
		
	}
	
	public static Class<? extends Plugin> getClassFromFile(String name) throws ClassNotFoundException {
		
		@SuppressWarnings("unchecked")
		Class<? extends Plugin> plugClass = (Class<? extends Plugin>) Class.forName("plugin."+name.substring(0, name.length()-".class".length()));
		
		return plugClass;
		
	}

}
