package com.game;

import java.util.ArrayList;

import com.templatesrv.base.Code;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.utils.Global;
import com.templatesrv.utils.LogMessage;

public class Main {
	public static void main(String args[]) {
		TemplateServer t = new TemplateServer(8000);

		t.start();
		t.commandLoop();
		t.stop(Code.EXIT_OK);

		System.out.println("\nLOG DUMP");
		ArrayList<LogMessage> l = Global.LOGGER.getLogs();
		for (int i = 0; i < l.size(); i++)
			System.out.println((i + 1) + ")\t" + l.get(i).getMessage());
	}
}
