package com.game.pages;

import com.sun.net.httpserver.HttpExchange;
import com.templatesrv.base.HTTPResponse;
import com.templatesrv.base.Page;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.base.URLMatch;
import com.templatesrv.utils.TagUtils;

public class Home implements Page {

	@Override
	public HTTPResponse renderResponse(TemplateServer t, HttpExchange h, URLMatch u) {
		String html = t.readHTML("index.html");
		html = TagUtils.replaceTag(html, "JavaSomething", this.getClass().getCanonicalName());
		HTTPResponse r = new HTTPResponse(html);
		return r;
	}

}
