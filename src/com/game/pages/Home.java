package com.game.pages;

import com.sun.net.httpserver.HttpExchange;
import com.templatesrv.base.Data;
import com.templatesrv.base.HTTPResponse;
import com.templatesrv.base.Page;
import com.templatesrv.base.TemplateServer;
import com.templatesrv.base.URLMatch;

public class Home implements Page {
	private final String TITLE = "Homepage";

	@Override
	public HTTPResponse renderResponse(TemplateServer server, HttpExchange exchange, URLMatch match) {
		Data html = server.readHTML("index.html");
		
		// There are currently three options for tag replacement.
		// If Java had a dictionary-style primitive, or if Map supported
		// direct value initialization, this would be much easier.
		//
		// Option 1 is best for replacing a small number of tags.
		// Option 2 makes more syntactic sense, but is less readable.
		// Option 3 makes less syntactic sense, but is more readable.
		
		// Option 1
		html.replaceTag("Title", TITLE)
			.replaceTag("Test", "Hmmm..."); // Tag replacement is chainable
		
		/* Option 2
		html.replaceTags(new String[]{
				"Title",
				"Test"
		}, new String[]{
				TITLE,
				"Hmmm..."
		});
		*/
		
		/* Option 3
		html.replaceTags(new String[]{
			"Title" , TITLE,
			"Test"  , "Hmmm..."
		});
		 */
		
		HTTPResponse r = new HTTPResponse(html);
		return r;
	}

}
