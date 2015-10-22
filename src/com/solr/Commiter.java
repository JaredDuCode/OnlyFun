package com.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class Commiter {

	final String serverUrl = "http://localhost:8080/local-solr/mycore";
	SolrServer solrServer;
	
	
	public Commiter(){
		solrServer = new HttpSolrServer(serverUrl); 
	}
	
	public  void Index(List<SolrInputDocument> docs) throws SolrServerException, IOException{
		for(SolrInputDocument doc : docs)
			solrServer.add(doc);
	}
	
	public void Commit() throws SolrServerException, IOException{
		solrServer.commit(true,true);
	}
	
	public  void query(String queryStr) throws SolrServerException{
		SolrQuery solrQuery = new SolrQuery(queryStr);  
		solrQuery.setRows(5);  
        QueryResponse resp = solrServer.query(solrQuery);  
        SolrDocumentList hits = resp.getResults();  
        
        for(SolrDocument doc : hits){  
            System.out.println(doc.getFieldValue("id") + " : " + doc.getFieldValue("url"));  
        } 
        
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		Commiter commiter = new Commiter();
		
		
		SolrInputDocument doc1 = new SolrInputDocument();
		doc1.setField("id", "F8V7067-APL-KIT");
		doc1.setField("name", "dujiacheng");
		
		
		List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
		docs.add(doc1);

		commiter.Index(docs);
		
		commiter.Commit();
		
	}
	
	

}
