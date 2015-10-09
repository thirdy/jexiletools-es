/*
 * Copyright (C) 2015 thirdy
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package io.jexiletools.es;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import io.jexiletools.es.model.ExileToolsHit;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.http.JestHttpClient;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;

/**
 * @author thirdy
 *
 */
public class ExileToolsESClient {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private final JestHttpClient client;
	private final String apiKey;
	
	public ExileToolsESClient() {
		this("http://api.exiletools.com/index", "DEVELOPMENT-Indexer");
	}

	public ExileToolsESClient(String url, String apiKey) {
		this.apiKey = apiKey;
		// Construct a new Jest client according to configuration via factory
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder(url).multiThreaded(true).build());
		client = (JestHttpClient) factory.getObject();
		logger.debug("~~~~~~~~~~~~~~~~~~ Successfully started ExileToolsESClient ~~~~~~~~~~~~~~~~~~~~");
	}
	
	public SearchResult execute(String json) throws IOException {
		 logger.debug("~~~~ Executing search: {}{}", System.lineSeparator(), json);

		 ExileToolsSearchAction search = new ExileToolsSearchAction.Builder(json)
		                                 .setHeader("Authorization", apiKey)
		                                 .build();
		 
		 SearchResult result = client.execute(search);
		 
//		 logger.debug(result.getJsonString());
		return result;
	}
	
	public void shutdown() {
		client.shutdownClient();
	}
}
