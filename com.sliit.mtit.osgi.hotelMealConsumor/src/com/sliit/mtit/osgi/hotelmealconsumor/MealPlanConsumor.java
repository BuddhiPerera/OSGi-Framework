package com.sliit.mtit.osgi.hotelmealconsumor;

import org.osgi.framework.BundleContext;

import com.sliit.mtit.osgi.mealplanproducer.MealDetails;

public interface MealPlanConsumor {

	void start(BundleContext context);

	MealDetails displyMeals(BundleContext context);

}
 