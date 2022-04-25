package com.sliit.mtit.osgi.hotelbevarageconsumor;

import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sliit.mtit.osgi.hotelbevarageconsumor.BeverageConsumor;

import package_com.sliit.mtit.osgi.hotelbeveragepulisher.BevarageDetails;
import package_com.sliit.mtit.osgi.hotelbeveragepulisher.BeveragePublish;

public class ActivatorBev implements BundleActivator ,BeverageConsumor {
	
	
	BeveragePublish beveragePublish; 
	
	ServiceReference<?> serviceReference5;



	public void start(BundleContext bundleContext) {
		serviceReference5 = bundleContext.getServiceReference(BeveragePublish.class.getName());
		beveragePublish = (BeveragePublish) bundleContext.getService(serviceReference5);
	}

	public void stop(BundleContext bundleContext) throws Exception {
	
	}
	
	@Override
	public ArrayList<BevarageDetails> displyBev(BundleContext context) {
		// TODO Auto-generated method stub
	
		ArrayList<BevarageDetails> respons= beveragePublish.displayBeverage();
		
		return respons;
	}

}
