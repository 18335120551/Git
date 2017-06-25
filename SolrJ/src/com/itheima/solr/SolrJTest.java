package com.itheima.solr;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJTest {

	// 添加或修改
	@Test
	public void testInsert() throws Exception {
		HttpSolrServer solrServer = getSolrServer();
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "KLH");
		doc.addField("name", "彼岸花开");
		solrServer.add(doc, 100);
	}

	// 删除
	@Test
	public void testDelete() throws Exception {
		HttpSolrServer solrServer = this.getSolrServer();
		solrServer.deleteByQuery("*:*", 1000);
		// solrServer.deleteById("KLH");
		solrServer.deleteByQuery("*:*");
	}

	// 查询
	@Test
	public void testSearch() throws Exception {
		HttpSolrServer solrServer = this.getSolrServer();
		SolrQuery solrQuery = new SolrQuery();
		// solrQuery.set("q", "*:*");
		// solrQuery.setQuery("*:*");

		// 查询关键字
		solrQuery.setQuery("神偷奶爸");
		// 过滤条件
		solrQuery.set("fq", "product_catalog_name:幽默杂货");
		// 排序
		solrQuery.addSort("product_price", ORDER.desc);
		// 分页开始
		solrQuery.setStart(0);
		// 分页结束
		solrQuery.setRows(5);
		// 设置默认域
		solrQuery.set("df", "product_name");
		// 设置指定域
		solrQuery.set("fl", "id,product_name");
		// 高亮
		// 打开高亮开关
		solrQuery.setHighlight(true);
		// 指定高亮域
		solrQuery.addHighlightField("product_name");
		// 设置高亮前缀
		solrQuery.setHighlightSimplePre("<span style='color:red'>");
		// 设置高亮后缀
		solrQuery.setHighlightSimplePost("</span>");
		// 执行查询
		QueryResponse response = solrServer.query(solrQuery);
		SolrDocumentList docs = response.getResults();
		// 获取高亮文本
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		// 总条数
		long numFound = docs.getNumFound();
		System.out.println("总条数为:" + numFound);
		for (SolrDocument doc : docs) {
			System.out.println(doc.get("id"));
			System.out.println(doc.get("product_name"));
			System.out.println(doc.get("product_price"));
			System.out.println(doc.get("product_catalog_name"));
			System.out.println("============================================");
			Map<String, List<String>> map = highlighting.get(doc.get("id"));
			List<String> list = map.get("product_name");
			System.out.println(list.get(0));
		}
	}

	private HttpSolrServer getSolrServer() {
		String baseURL = "http://localhost:8081/solr/";
		HttpSolrServer solrServer = new HttpSolrServer(baseURL);
		return solrServer;
	}

}
