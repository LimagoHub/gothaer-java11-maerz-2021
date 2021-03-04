package de.dep.impl;

import de.dep.Dependency;
import de.utils.StringUtil;

public class DependencyImpl implements Dependency {
	
	
	private final StringUtil utils = new StringUtil();
	
	@Override
	public void drucken() {
		System.out.println(utils.toUpperCase(this.getClass().getName()));
	}

	@Override
	public String getName() {
		
		return "A";
	}

}
