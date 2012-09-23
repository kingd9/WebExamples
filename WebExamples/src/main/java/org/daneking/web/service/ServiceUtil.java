package org.daneking.web.service;

import java.io.IOException;
import java.util.List;

import org.htmlcleaner.XPatherException;

public class ServiceUtil {
	public static void main(String[] args) throws IOException, XPatherException {
		WebContentService service = new WebContentService();
		String baseUrl = "http://www.dispatch.com";
		List<String> urls = service.getUrls(baseUrl);
		for (String link : urls) {
			if (link.endsWith(".html")) {
				if (link.startsWith("/content/stories") || link.startsWith("http")) {
					link = baseUrl.concat(link);
					System.out.println(link);
					List<String> content = service.getContent(link);
					for (String txt : content) {
						System.out.println(txt);
					}
				}
			}
		}

	}
}
