package vdk.tanghe.plugins;
import java.io.File;
import java.lang.reflect.Constructor;

import plugins.Plugin;

public class PluginFilter implements java.io.FilenameFilter {
	
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
		
		boolean isADotClass = name.endsWith(".class");
				
		if(isADotClass) {
			
			try {
				
				Class<?> plugClass = getClassFromFile(name);
				
				Constructor<?> c = plugClass.getConstructor();
				Class<?>[] cParameter = c.getParameterTypes();
				
				if(cParameter.length!=0)
					return false;
				
				if(plugins.Plugin.class.isAssignableFrom(plugClass))
					return true;
				
				else return false;
				
				
			} catch (ClassNotFoundException e) {
				
				// The file does not contain a class
				return false;
				
			} catch (SecurityException e) {
				
				return false;
				
			} catch (NoSuchMethodException e) {
				
				// Thrown if the constructor does not exist.
				return false;
				
				
				
			}
			
		}
		else return false;
		
	}
	
	public static Class<? extends Plugin> getClassFromFile(String name) throws ClassNotFoundException {
		
		Class<? extends Plugin> plugClass = (Class<? extends Plugin>) Class.forName("plugin."+name.substring(0, name.length()-".class".length()));
		
		return plugClass;
		
	}
	

}
