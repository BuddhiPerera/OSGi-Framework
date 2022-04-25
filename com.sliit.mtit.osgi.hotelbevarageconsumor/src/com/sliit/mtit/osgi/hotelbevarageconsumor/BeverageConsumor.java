package com.sliit.mtit.osgi.hotelbevarageconsumor;

import java.util.ArrayList;

import org.osgi.framework.BundleContext;

import package_com.sliit.mtit.osgi.hotelbeveragepulisher.BevarageDetails;

public interface BeverageConsumor {
	ArrayList<BevarageDetails> displyBev(BundleContext context);

	void start(BundleContext context);
}
 
 