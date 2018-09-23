package cc.duyanhan.catchfreessr.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/** 
* @author duyanhan
* @version 创建时间：2018年9月22日 下午10:22:16 
* 页面下载工具类
*/
public class PageDownloadUtils {

	/**
	 * 普通get请求
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String getPageContent(String url) throws Exception{
		CloseableHttpClient httpclient = HttpClients.custom().build();
		String content = null;
		try {
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = null;
			try {
				response = httpclient.execute(httpGet);
				HttpEntity entity = response.getEntity();
				content = EntityUtils.toString(entity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return content;
	}
	
	/**
	 * 设置请求头的get请求
	 * @param url
	 * @param headers
	 * @return
	 * @throws Exception
	 */
	public static String getPageContentWithHeaders(String url, Map<String, String> headers) throws Exception{
		CloseableHttpClient httpclient = HttpClients.custom().build();
		String content = null;
		try {
			HttpGet httpGet = new HttpGet(url);
			if (headers != null && headers.size() > 0) {
				Set<Entry<String, String>> headerSet = headers.entrySet();
				for (Entry<String, String> header : headerSet) {
					httpGet.setHeader(header.getKey(), header.getValue());
				}
			}
			CloseableHttpResponse response = null;
			try {
				response = httpclient.execute(httpGet);
				HttpEntity entity = response.getEntity();
				content = EntityUtils.toString(entity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return content;
	}
}
