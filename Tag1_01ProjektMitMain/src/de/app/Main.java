package de.app;




import java.lang.reflect.Method;

import de.utils.StringUtil;



public class Main {

	public static void main(String[] args) throws Exception{
		
		Object obj = Class.forName("de.dep.Schwein").newInstance();
		Method m = obj.getClass().getDeclaredMethod("setGewicht",int.class);
		m.setAccessible(true);
		m.invoke(obj, -100);
		
		System.out.println(obj);
		
	}

}
