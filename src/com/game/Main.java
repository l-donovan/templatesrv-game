package com.game;

import java.util.ArrayList;

import com.templatesrv.base.Code;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.utils.Global;
import com.templatesrv.utils.LogMessage;

public class Main {
	public static void main(String args[]) {
		TemplateServer server = new TemplateServer(8000);

		server.start();
		server.commandLoop();
		server.stop(Code.EXIT_OK);

		System.out.println("\nLOG DUMP");
		ArrayList<LogMessage> logs = Global.LOGGER.getLogs();
		for (int i = 0; i < logs.size(); i++)
			System.out.printf("%d)\t%s\n", i + 1, logs.get(i).getMessage());
	}
}
