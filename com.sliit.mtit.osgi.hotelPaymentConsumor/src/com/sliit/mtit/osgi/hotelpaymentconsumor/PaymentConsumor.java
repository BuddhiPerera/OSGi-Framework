package com.sliit.mtit.osgi.hotelpaymentconsumor;

import com.sliit.mtit.osgi.paymentproducer.PaymentDetail;
import org.osgi.framework.BundleContext;



public interface PaymentConsumor {
	void start(BundleContext context);

	PaymentDetail displayPayment();
}
