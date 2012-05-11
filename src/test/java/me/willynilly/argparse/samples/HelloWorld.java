package me.willynilly.argparse.samples;

import me.willynilly.argparse.ArgumentParser;
import me.willynilly.argparse.Namespace;
import me.willynilly.argparse.Parameter;
import me.willynilly.argparse.Parameter.Type;

public class HelloWorld {

	public static void main(String[] args) {
		ArgumentParser parser = new ArgumentParser();
		parser.addArgument("-g, --greeting", 
			Parameter.create(Type.HELP, "displays a hello world greeting"), 
			Parameter.create(Type.DEST, "hw"));
		
		parser.addArgument("--foo", 
			Parameter.create(Type.NARGS, 1),
			Parameter.create(Type.HELP, "displays a specified greeting"));
		
		Namespace namespace = parser.parseArgs(args);
		
		if(namespace.containsKey("hw")) {
			System.out.println("hello world!");
		}
		
		if(namespace.containsKey("foo")) {
			System.out.println(namespace.get("foo"));
		}
	}

}
