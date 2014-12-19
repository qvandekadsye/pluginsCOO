package vdk.tanghe.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vdk.tanghe.listeners.PluginEvent;
import vdk.tanghe.listeners.PluginListener;

public class PluginFinderTest {

	@Test
	public void testStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testStop() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClassFiles() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPluginListener() {
		List<PluginListener> listenersTest=new ArrayList<PluginListener>();
		assertEquals(0,listenersTest.size());
		listenersTest.add(new PluginListener() {
			
			@Override
			public void pluginRemoved(PluginEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void pluginAdded(PluginEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isKnown(PluginEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		assertEquals(1,listenersTest.size());
	}

	@Test
	public void testRemovePluginListener() {
		fail("Not yet implemented");
	}

	@Test
	public void testFirePluginAdded() {
		fail("Not yet implemented");
	}

	@Test
	public void testFirePluginRemoved() {
		fail("Not yet implemented");
	}

}
