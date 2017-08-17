package com.game.pages;

import com.sun.net.httpserver.HttpExchange;
import com.templatesrv.base.Data;
import com.templatesrv.base.HTTPResponse;
import com.templatesrv.base.Page;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.base.URLMatch;

public class NewGame implements Page {

	@Override
	public HTTPResponse renderResponse(TemplateServer server, HttpExchange exchange, URLMatch match) {
		Data html = server.readHTML("newGame.html");
		HTTPResponse response = new HTTPResponse(html);
		response.setHeader("TEST", "VAL");
		return response;
	}

}
