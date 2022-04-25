package com.sliit.mtit.osgi.hotelroomcartconsumer;

import org.osgi.framework.BundleContext;

public interface RoomCartServiceConsumer {

	 String cartMenu(double price);

	void start(BundleContext context);
}
   