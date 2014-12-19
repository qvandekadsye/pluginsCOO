package vdk.tanghe.test;

import static org.junit.Assert.*;

import org.junit.Test;

import plugin.CesarCode;
import plugin.Cucurbitace;
import vdk.tanghe.plugins.PluginFilter;

public class PluginFilterTest {

	@Test
	public void testGetInstance() {
		PluginFilter pf1 = PluginFilter.getInstance(),
				pf2 = PluginFilter.getInstance();
		
		assertTrue(pf1 == pf2);
	}

	@Test
	public void testAccept() throws SecurityException, NoSuchMethodException {
		
		PluginFilter pf = PluginFilter.getInstance();
		
		assertTrue(pf.accept(CesarCode.class));
		assertFalse(pf.accept(Cucurbitace.class));
		
	}
	
}
