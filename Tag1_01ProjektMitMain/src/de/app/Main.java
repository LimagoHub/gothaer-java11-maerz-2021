package de.app;



import de.dep.Dependency;
import de.utils.StringUtil;



public class Main {

	public static void main(String[] args) {
		
		StringUtil util = new StringUtil();
		System.out.println(util.toUpperCase("Hallo"));
	
		
		Dependency dep = Dependency.create();
		
		dep.drucken();
		
		
//		Dependency dep = DependencyFactory.create();
//		dep.drucken();
	}

}
