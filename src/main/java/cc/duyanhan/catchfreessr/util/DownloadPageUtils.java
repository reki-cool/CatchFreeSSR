package cc.duyanhan.catchfreessr.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/** 
* @author duyanhan
* @version 创建时间：2018年9月22日 下午10:22:16 
* 页面下载工具类
*/
public class DownloadPageUtils {

	public static String getPageHtml(String url) {
		HttpClientBuilder builder = HttpClientBuilder.create();
		CloseableHttpClient client = builder.build();
		HttpGet get = new HttpGet(url);
		try {
			CloseableHttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
			    return EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
}
