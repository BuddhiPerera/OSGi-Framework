package com.sliit.mtit.osgi.hotelroomproducer;

import java.util.Dictionary;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration<?> publishServiceRegistrion;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext context) throws Exception {
		RoomServicePublish publisherService = new RoomServicePublishImpl();
		this.publishServiceRegistrion = context.registerService(RoomServicePublish.class.getName(), publisherService,
				(Dictionary<String, ?>) null); 
		System.out.println("Start Room Service");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop Publisher");
		this.publishServiceRegistrion.unregister();
		System.out.println("Stop Room Service");
	}
}
 