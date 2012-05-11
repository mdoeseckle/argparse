package me.willynilly.argparse;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import me.willynilly.argparse.utils.Identity;
import me.willynilly.argparse.utils.Joiner;
import me.willynilly.argparse.utils.Triplet;

final class HelpFlag implements Flag {
	private final boolean isJar;
	private final String description;
	
	private final List<Triplet<String, String, String>> argumentHelp = new LinkedList<Triplet<String, String, String>>();
	
	public HelpFlag(boolean isJar, String description) {
		this.isJar = isJar;
		this.description = description;
		
		argumentHelp.add(Triplet.create("[-h]", "-h, --help", "show this help message and exit"));
	}

	@Override
	public int invoke(String[] arguments, int head, Map<String, Object> results) {
		printUsage();
		
		if(description != null && !description.isEmpty()) {
			System.out.println(String.format("\n\n%s", description));
		}		
		
		printArgumentHelp();
		
		System.exit(0);
		return 0;
	}
	
	public void addHelp(String usageFlag, String argumentFlags, String argumentDescription) {
		argumentHelp.add(Triplet.create(usageFlag, argumentFlags, argumentDescription));
	}
	
	private void printUsage() {
		List<String> usageFlags = new LinkedList<String>();
		for(Triplet<String, String, String> element : argumentHelp) {
			usageFlags.add(element.first());
		}
		
		String usage = isJar
				? String.format("usage: java -jar %s %s", Identity.getJarName(), Joiner.on(" ").join(usageFlags))
				: String.format("usage: java %s %s", Identity.getMain(), Joiner.on(" ").join(usageFlags));
				
		System.out.println(usage);
	}
	
	private void printArgumentHelp() {
		if(!argumentHelp.isEmpty()) {
			System.out.println(String.format("\narguments:"));
			
			int maxlen = 0;
			for(Triplet<String, String, String> entry : argumentHelp) {
				maxlen = Math.max(maxlen, entry.second().length());
			}
			
			String argFormat = String.format("  %%-%ds  %%s", maxlen);
			
			for(Triplet<String, String, String> entry : argumentHelp) {
				System.out.println(String.format(argFormat, entry.second(), entry.third()));
			}
		}
	}

}
