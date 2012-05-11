package me.willynilly.argparse;

import java.util.LinkedList;
import java.util.List;

import me.willynilly.argparse.utils.Identity;
import me.willynilly.argparse.utils.Joiner;

public final class HelpFlag implements Flag {
	private final boolean isJar;
	private final String description;
	
	private List<String> options = new LinkedList<String>();
	
	public HelpFlag(boolean isJar, String description) {
		this.isJar = isJar;
		this.description = description;
		
		options.add("[-h]");
	}

	@Override
	public int invoke(String[] arguments, int head) {
		String usage = isJar
				? String.format("usage: java -jar %s %s", Identity.getJarName(), Joiner.on(" ").join(options))
				: String.format("usage: java %s %s", Identity.getMain(), Joiner.on(" ").join(options));
				
		System.out.println(usage);
		
		if(description != null && !description.isEmpty()) {
			System.out.println(String.format("\n\n%s", description));
		}		
		
		System.exit(0);
		return 0;
	}

}
