public class PluginFinder {
	
	public String[] getClassFiles() {

		return this.dir.list(PluginFilter.getInstance());

	}

}
