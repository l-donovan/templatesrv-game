package com.game.pages;

import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.templatesrv.base.Data;
import com.templatesrv.base.HTTPResponse;
import com.templatesrv.base.HTTPStatusCode;
import com.templatesrv.base.Page;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.base.URLMatch;

public class FourOhFour implements Page {
	public Map<String, Object> TAGS;

	@Override
	public HTTPResponse renderResponse(TemplateServer server, HttpExchange exchange, URLMatch match) {
		Data html = server.readHTML("404.html");
		html.replaceTag("Path", exchange.getRequestURI().getPath());
		HTTPResponse response = new HTTPResponse(html);
		response.setStatus(HTTPStatusCode.NOT_FOUND);
		return response;
	}

}
