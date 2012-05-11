package me.willynilly.argparse;

import java.util.Map;

public interface Flag {
	
	int invoke(String[] arguments, int head, Map<String, Object> results);

}
