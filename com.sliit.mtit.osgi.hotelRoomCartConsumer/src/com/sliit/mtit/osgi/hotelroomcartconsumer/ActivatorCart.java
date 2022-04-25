package com.sliit.mtit.osgi.hotelroomcartconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sliit.mtit.osgi.roomcart.RoomCartServicePublish;

public class ActivatorCart implements BundleActivator, RoomCartServiceConsumer {

	ServiceReference<?> serviceReference2;

	RoomCartServicePublish cartServicePublisher;

	public void start(BundleContext bundleContext) {
		serviceReference2 = bundleContext.getServiceReference(RoomCartServicePublish.class.getName());
		cartServicePublisher = (RoomCartServicePublish) bundleContext.getService(serviceReference2);
	}

	public void stop(BundleContext bundleContext) throws Exception {
	}

	public String cartMenu(double price) {

		String cartRes = cartServicePublisher.cartMenu(price); // Call Method cartMenu to confirm Book
		return cartRes;
	}

}
