package com.sliit.mtit.osgi.roomcart;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration<?> publishServiceRegistration;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	public void start(BundleContext context) throws Exception {
		RoomCartServicePublish publisherService = new RoomCartServicePublishImpl();
		publishServiceRegistration = context.registerService(RoomCartServicePublish.class.getName(), publisherService,
				null);
		System.out.println("Start Cart Service");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop Publisher");
		publishServiceRegistration.unregister();
		System.out.println("Stop Cart Service");
	}

}
