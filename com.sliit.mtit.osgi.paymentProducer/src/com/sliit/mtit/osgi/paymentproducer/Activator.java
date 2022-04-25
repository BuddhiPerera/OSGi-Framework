package com.sliit.mtit.osgi.paymentproducer;

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
		PaymentServicePublish publisherService = new PaymentServicePublishImpl();
		publishServiceRegistration = context.registerService(PaymentServicePublish.class.getName(), publisherService, null);
		System.out.println("Start Payment Service");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop Publisher");
		publishServiceRegistration.unregister();
		System.out.println("Stop Payment Service");
	}

}