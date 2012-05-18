package me.willynilly.argparse;

class ArgumentHelper {
	
	public static String[] parseFlags(String input) {
		String[] flags = input.split(",");
		
		for(int index = 0; index < flags.length; index++) {
			flags[index] = flags[index].trim().replaceFirst("-+", "");
		}
		
		return flags;
	}
	
	/*
	 * Copying behavior from Python's library, which:
	 * 
	 * "generates the value of dest by taking the first long option string and stripping away the initial -- string. 
	 * If no long option strings were supplied, dest will be derived from the first short option string by stripping 
	 * the initial - character. Any internal - characters will be converted to _ characters to make sure the string is 
	 * a valid attribute name."
	 */
	public static String getDest(String[] flags) {
		String dest = null;
		
		for(String flag : flags) {
			if(flag.length() > 1) {
				dest = flag;
				continue;
			}
			
			if(dest == null) {
				dest = flag;
			}
		}
		
		return dest;
	}
	
	public static String getUsage(String flag) {
		return String.format("[%s%s]", flag.length() == 1 ? "-" : "--", flag);
	}
	
	public static String getUsage(String flag, String dest) {
		return String.format("[%s%s %s]", flag.length() == 1 ? "-" : "--", flag, dest);
	}

}
