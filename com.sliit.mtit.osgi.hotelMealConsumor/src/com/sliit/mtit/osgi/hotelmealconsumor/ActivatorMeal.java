package com.sliit.mtit.osgi.hotelmealconsumor;

import com.sliit.mtit.osgi.mealplanproducer.MealDetails;
import com.sliit.mtit.osgi.mealplanproducer.MealPlanPublish;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class ActivatorMeal implements BundleActivator,MealPlanConsumor {

	private static BundleContext context;
	MealPlanPublish mealPlan;
	
	ServiceReference<?> serviceReference3;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) {
		serviceReference3 = bundleContext.getServiceReference(MealPlanPublish.class.getName());
		mealPlan = (MealPlanPublish) bundleContext.getService(serviceReference3);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		ActivatorMeal.context = null;
	}

	@Override
	public MealDetails displyMeals(BundleContext context) {
		// TODO Auto-generated method stub
		MealDetails respons= mealPlan.displayMeals();
		
		return respons;
	}

}
