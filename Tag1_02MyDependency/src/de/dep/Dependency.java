package de.dep;

import java.util.ServiceLoader;

public interface Dependency {

	String getName();
	void drucken();
	
	static Dependency create() {

		final ServiceLoader<Dependency> loader = ServiceLoader.load(Dependency.class);
		
		return loader.findFirst().get();
	}

}