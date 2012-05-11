package me.willynilly.argparse.utils;

/**
 * Utility to help an application with its own identity
 */
public class Identity {
	
	public static String getJarName() {
		try {
			Class<?> mainClass = Class.forName(getMain());
			String fullJarName = mainClass.getProtectionDomain().getCodeSource().getLocation().toString();
			return fullJarName.replaceAll("[\\w:]*\\/", "");
		} catch(Throwable cause) {
			return "<unknown>";
		}
	}
	
	public static String getMain() {                                                                                                                  
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();                                                                               
		StackTraceElement main = stack[stack.length - 1];                                                                                                     
		return main.getClassName();                                                                                                                           
	}           

}
