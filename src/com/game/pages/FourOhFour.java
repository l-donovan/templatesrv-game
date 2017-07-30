package com.game.pages;

import com.sun.net.httpserver.HttpExchange;
import com.templatesrv.base.HTTPResponse;
import com.templatesrv.base.Page;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.base.URLMatch;
import com.templatesrv.utils.TagUtils;

public class FourOhFour implements Page {

	@Override
	public HTTPResponse renderResponse(TemplateServer t, HttpExchange h, URLMatch u) {
		String html = t.readHTML("404.html");
		html = TagUtils.replaceTag(html, "Path", h.getRequestURI().getPath());
		return new HTTPResponse(html);
	}

}
