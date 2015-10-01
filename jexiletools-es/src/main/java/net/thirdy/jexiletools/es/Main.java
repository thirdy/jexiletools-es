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
package net.thirdy.jexiletools.es;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import io.searchbox.action.AbstractAction;
import io.searchbox.action.AbstractMultiTypeActionBuilder;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.http.JestHttpClient;
import io.searchbox.core.SearchResult;
import io.searchbox.core.search.sort.Sort;
import io.searchbox.params.Parameters;
import io.searchbox.params.SearchType;
/**
 * @author thirdy
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		 // Construct a new Jest client according to configuration via factory
		 JestClientFactory factory = new JestClientFactory();
		 factory.setHttpClientConfig(new HttpClientConfig
		                        .Builder("http://api.exiletools.com/index")
		                        .multiThreaded(true)
		                        .build());
		 JestHttpClient client = (JestHttpClient) factory.getObject();
		 SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		 searchSourceBuilder.query(QueryBuilders.matchQuery("info.name", "Tabula Rasa"));
		 searchSourceBuilder.size(1);

		 System.out.println(searchSourceBuilder.toString());

		 ExileToolsSearch search = new ExileToolsSearch.Builder(searchSourceBuilder.toString())
		                                 .setHeader("Authorization", "DEVELOPMENT-Indexer")
		                                 .build();
		 
		 SearchResult result = client.execute(search);
		 
		 // TODO make marshalling work
//		 List<String> articles = result.getSourceAsObjectList(String.class);
//		 
//		 System.out.println(articles);
		 System.out.println(result.getPathToResult());
		 System.out.println(result.getJsonString());
		 client.shutdownClient();
	}
	
	public static class ExileToolsSearch extends AbstractAction<SearchResult> {

	    private String query;
	    private List<Sort> sortList = new LinkedList<Sort>();

	    private ExileToolsSearch(ExileToolsSearch.Builder builder) {
	        super(builder);

	        this.query = builder.query;
	        this.sortList = builder.sortList;
	        setURI(buildURI());
	    }

	    public SearchResult createNewElasticSearchResult(String responseBody, int statusCode, String reasonPhrase, Gson gson) {
	        return createNewElasticSearchResult(new SearchResult(gson), responseBody, statusCode, reasonPhrase, gson);
	    }

	    public String getIndex() {
	        return this.indexName;
	    }

	    public String getType() {
	        return this.typeName;
	    }

	    @Override
	    protected String buildURI() {
//	        StringBuilder sb = new StringBuilder();
//	        sb.append(super.buildURI()).append("/_search");
//	        System.out.println(sb.toString());
	        return "/_search?pretty"; // TODO parametarized pretty
	    }

	    @Override
	    public String getPathToResult() {
	        return "hits/hits/_source";
	    }

	    @Override
	    public String getRestMethodName() {
	        return "POST";
	    }

	    @SuppressWarnings("unchecked")
	    @Override
	    public String getData(Gson gson) {
	        String data;
	        if (sortList.isEmpty()) {
	            data = query;
	        } else {
	            List<Map<String, Object>> sortMaps = new ArrayList<Map<String, Object>>(sortList.size());
	            for (Sort sort : sortList) {
	                sortMaps.add(sort.toMap());
	            }

	            Map rootJson = gson.fromJson(query, Map.class);
	            rootJson.put("sort", sortMaps);
	            data = gson.toJson(rootJson);
	        }
	        return data;
	    }

	    @Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	                .appendSuper(super.hashCode())
	                .append(query)
	                .toHashCode();
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }
	        if (obj == this) {
	            return true;
	        }
	        if (obj.getClass() != getClass()) {
	            return false;
	        }

	        ExileToolsSearch rhs = (ExileToolsSearch) obj;
	        return new EqualsBuilder()
	                .appendSuper(super.equals(obj))
	                .append(query, rhs.query)
	                .append(sortList, rhs.sortList)
	                .isEquals();
	    }
	    
	    @Override
	    protected JsonObject parseResponseBody(String responseBody) {
	        if (responseBody != null && !responseBody.trim().isEmpty()) {
	        		JsonReader jsonReader = new JsonReader(new StringReader(responseBody));
	        		jsonReader.setLenient(true);
	                return new JsonParser().parse(jsonReader).getAsJsonObject();
	        }
	        return new JsonObject();
	    }

	    public static class Builder extends AbstractMultiTypeActionBuilder<ExileToolsSearch, Builder> {
	        private String query;
	        private List<Sort> sortList = new LinkedList<Sort>();

	        public Builder(String query) {
	            this.query = query;
	        }

	        public Builder setSearchType(SearchType searchType) {
	            return setParameter(Parameters.SEARCH_TYPE, searchType);
	        }

	        public Builder addSort(Sort sort) {
	            sortList.add(sort);
	            return this;
	        }

	        public Builder addSort(Collection<Sort> sorts) {
	            sortList.addAll(sorts);
	            return this;
	        }

	        @Override
	        public ExileToolsSearch build() {
	            return new ExileToolsSearch(this);
	        }
	    }
	}

}
