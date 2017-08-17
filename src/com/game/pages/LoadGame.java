package com.game.pages;

import com.sun.net.httpserver.HttpExchange;
import com.templatesrv.base.HTTPResponse;
import com.templatesrv.base.Page;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.base.URLMatch;

public class LoadGame implements Page {

	@Override
	public HTTPResponse renderResponse(TemplateServer server, HttpExchange exchange, URLMatch match) {
		HTTPResponse response = HTTPResponse.redirect("/");
		return response;
	}

}
