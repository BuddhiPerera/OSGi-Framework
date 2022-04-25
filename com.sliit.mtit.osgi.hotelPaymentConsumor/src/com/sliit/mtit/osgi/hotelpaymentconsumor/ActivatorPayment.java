package com.sliit.mtit.osgi.hotelpaymentconsumor;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sliit.mtit.osgi.paymentproducer.PaymentDetail;
import com.sliit.mtit.osgi.paymentproducer.PaymentServicePublish;


public class ActivatorPayment implements BundleActivator,PaymentConsumor {
	PaymentServicePublish paymentServicePublish2;

	ServiceReference<?> serviceReference4;


	public void start(BundleContext bundleContext) {
		serviceReference4 = bundleContext.getServiceReference(PaymentServicePublish.class.getName());
		paymentServicePublish2 = (PaymentServicePublish) bundleContext.getService(serviceReference4);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
	}

	

	@Override
	public PaymentDetail displayPayment() {
		PaymentDetail paymentData =paymentServicePublish2.displayPayment();
		return paymentData;
	}

}
