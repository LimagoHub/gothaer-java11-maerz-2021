package de.dep.impl;

import de.dep.Dependency;

public class DEpendencyImpl2 implements Dependency{

	@Override
	public void drucken() {
		System.out.println("Hier druckt 2");
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "B";
	}

}
