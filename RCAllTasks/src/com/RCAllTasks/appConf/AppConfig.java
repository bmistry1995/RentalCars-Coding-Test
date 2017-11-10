package com.RCAllTasks.appConf;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
	
	public AppConfig()
	{
		packages("com.RCAllTasks.get");
	}

}
