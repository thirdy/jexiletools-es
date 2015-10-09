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

import static org.junit.Assert.*;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jexiletools.es.ExileToolsESClient;
import io.jexiletools.es.model.ExileToolsHit;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;

/**
 * @author thirdy
 *
 */
public class ExileToolsESClientTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	static ExileToolsESClient client;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		client = new ExileToolsESClient();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		client.shutdown();
	}

	@Test
	public void testExecuteMjolner() throws Exception {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		 searchSourceBuilder.query(QueryBuilders.matchQuery("info.name", "Mjolner"));
		 searchSourceBuilder.size(1);
		
		SearchResult result = client.execute(searchSourceBuilder.toString());
		List<Hit<ExileToolsHit, Void>> hits = result.getHits(ExileToolsHit.class);
		for (Hit<ExileToolsHit, Void> hit : hits) {
			logger.info(hit.source.toString());
		}
	}
	
	@Test
	public void testExecuteTabula() throws Exception {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchQuery("info.name", "Tabula Rasa"));
		searchSourceBuilder.size(1);
		
		SearchResult result = client.execute(searchSourceBuilder.toString());
		List<Hit<ExileToolsHit, Void>> hits = result.getHits(ExileToolsHit.class);
		for (Hit<ExileToolsHit, Void> hit : hits) {
			logger.info(hit.source.toString());
		}
	}
	
	@Test
	public void testShops() throws Exception {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery()
				.must(QueryBuilders.matchQuery("attributes.league", "Flashback Event (IC001)"))
				.mustNot(QueryBuilders.matchQuery("attributes.league", "Flashback Event (IC001)")));
		searchSourceBuilder.size(1);
		
		SearchResult result = client.execute(searchSourceBuilder.toString());
		List<Hit<ExileToolsHit, Void>> hits = result.getHits(ExileToolsHit.class);
		for (Hit<ExileToolsHit, Void> hit : hits) {
			logger.info(hit.source.toString());
		}
	}
	
	@Test
	public void testGetLeagues() throws Exception {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.aggregation(AggregationBuilders
				.terms("leagues")
				.field("attributes.league"));
//		searchSourceBuilder.size(0);
		
		SearchResult result = client.execute(searchSourceBuilder.toString());
		List<Hit<ExileToolsHit, Void>> hits = result.getHits(ExileToolsHit.class);
		for (Hit<ExileToolsHit, Void> hit : hits) {
			logger.info(hit.source.toString());
		}
	}

}
