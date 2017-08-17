package com.game.pages.admin;

import com.sun.net.httpserver.HttpExchange;
import com.templatesrv.base.HTTPResponse;
import com.templatesrv.base.Page;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.base.URLMatch;
import com.templatesrv.utils.Global;
import com.templatesrv.utils.Utils;

public class UpdateSettings implements Page {

	@Override
	public HTTPResponse renderResponse(TemplateServer server, HttpExchange exchange, URLMatch match) {
		String body = Utils.inputStreamToString(exchange.getRequestBody());
		String[][] params = Utils.getURLParameters(body, server.getSettingOrDefault("Encoding", "utf-8"));
		for (String[] pair : params) {
			if (!pair[1].equals(server.getSettingOrDefault(pair[0], null))) {
				Global.LOGGER.info("Registered setting \"%s\" = \"%s\"", pair[0], pair[1]);
				server.setSetting(pair[0], pair[1]);
			}
		}
		String redirectURI = exchange.getRequestHeaders().getFirst("Referer");
		return HTTPResponse.redirect(redirectURI);
	}

}