package org.daneking.web.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

public class WebContentService {

	private HtmlCleaner cleaner = new HtmlCleaner();

	public List<String> getUrls(String location) throws IOException,
			XPatherException {

		TagNode node = getTagNode(location);
		// nodes.getevaluateXPath(;
		List<String> urls = addLinks(node);
		return urls;
	}

	public List<String> getContent(String location) throws IOException,
			XPatherException {
		URL myURL = getConnection(location);
		Reader reader = new InputStreamReader(myURL.openStream());
		TagNode node = cleaner.clean(reader);
		Object[] nodes = node
				.evaluateXPath("//div[@id='content']");
		List<String> content = new ArrayList<String>();
		
		for (Object tagNode : nodes) {
			TagNode tNode = (TagNode) tagNode;
			content.add(tNode.getText().toString());
		}
		return content;
	}

	private List<String> addLinks(TagNode node) throws XPatherException {
		Object[] nodes = node.evaluateXPath("//a[@href]");
		List<String> urls = new ArrayList<String>();
		for (Object tagNode : nodes) {
			TagNode tNode = (TagNode) tagNode;
			String link = tNode.getAttributeByName("href");
			urls.add(link);
		}
		return urls;
	}

	private TagNode getTagNode(String location) throws MalformedURLException,
			IOException {
		URL myURL = getConnection(location);

		CleanerProperties props = cleaner.getProperties();
		Reader reader = new InputStreamReader(myURL.openStream());

		return cleaner.clean(reader);
	}

	private URL getConnection(String location) throws IOException {
		URL myURL = new URL(location);
		URLConnection myURLConnection = myURL.openConnection();
		myURLConnection.connect();
		return myURL;
	}
}
