package com.game.pages.admin;

import com.sun.net.httpserver.HttpExchange;
import com.templatesrv.base.DOMElement;
import com.templatesrv.base.Data;
import com.templatesrv.base.HTTPResponse;
import com.templatesrv.base.Page;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.base.URLMatch;
import com.templatesrv.utils.Global;
import com.templatesrv.utils.LogMessage;

public class AdminPage implements Page {

	@Override
	public HTTPResponse renderResponse(TemplateServer server, HttpExchange exchange, URLMatch match) {
		Data html = server.readHTML("admin.html");
		html.replaceTag("Title", "Admin");
		
		String settingsHTML = "";
		for (String setting : server.getSettingsList()) {
			String value = server.getSettingOrDefault(setting, "UNDEFINED");
			
			DOMElement key = new DOMElement("span"),
					   val = new DOMElement(String.format("input type=\"text\" name=\"%s\" value=\"%s\"", setting, value)),
					   dot = new DOMElement("span");
			
			key.addClass("settingslist_key");
			key.setBody(setting);

			dot.addClass("settingslist_dot");
			dot.setBody("&#8226;");
			
			val.addClass("settingslist_val");
			
			String htmlSnippet = "<tr><td>" + key.toString() + "</td><td>" + val.toString() + "</td></tr>\n";
			settingsHTML += htmlSnippet;
		}
		html.replaceTag("SettingsList", settingsHTML);
		
		String logsHTML = "";
		for (LogMessage m : Global.LOGGER.getLogs())
			logsHTML += String.format("[%-5s@ %d] %s\n", m.getLogLevel().name(), m.getTime(), m.getMessage());
		html.replaceTag("LogDump", logsHTML);
		
		HTTPResponse response = new HTTPResponse(html);
		return response;
	}

}
