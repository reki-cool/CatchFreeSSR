package cc.duyanhan.catchfreessr.client;


import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.DefaultRoutePlanner;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 客户端浏览器相关
 */
public class ClientBrowser {

    /**
     * 通过GET请求获取HTML页面内容
     * @param url
     * @return
     */
    public String getHtmlContentByGetRequest(String url) {

        // 要返回的HTML内容
        String htmlContent = null;

        // 创建Http客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url);
        // 获取响应
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            System.out.println("响应码" + response.getStatusLine().getStatusCode());
            // 判断响应结果
            if (response.getStatusLine().getStatusCode() == 200) {

                // 获取实体
                HttpEntity entity = response.getEntity();

                // 判断实体是否为空
                if (entity != null) {
                    htmlContent = EntityUtils.toString(entity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return htmlContent;
    }



    public String getHtmlContentByGetRequest2(String url, String proxyIp, Integer proxyPort) {

        // 要返回的HTML内容
        String htmlContent = null;

        // 创建Http客户端
        DefaultRoutePlanner route = createRoute(proxyIp, proxyPort);
        CloseableHttpClient httpClient = createHttpClient(route);
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url);
        // 获取响应
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            // 判断响应结果
            if (response.getStatusLine().getStatusCode() == 200) {

                // 获取实体
                HttpEntity entity = response.getEntity();

                // 判断实体是否为空
                if (entity != null) {
                    htmlContent = EntityUtils.toString(entity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return htmlContent;
    }


    /**
     * 创建代理
     * @param ip
     * @param port
     * @return
     */
    public DefaultRoutePlanner createRoute(String ip, Integer port) {
        HttpHost proxy = new HttpHost(ip, port);
        return new DefaultProxyRoutePlanner(proxy);
    }

    /**
     * 根据代理服务器创建Http客户端
     * @param route
     * @return
     */
    public CloseableHttpClient createHttpClient(DefaultRoutePlanner route) {

        // 如果route为空，则创建默认Http客户端
        if (route == null)
            return  HttpClients.createDefault();
        // 否则按照指定代理创建Http客户端
        return HttpClients.custom().setRoutePlanner(route).build();
    }


    public static void main(String[] args) {
        String url = "https://doub.io";
        String proxyIp = "192.140.0.65";
        Integer proxyPort = 53281;
//        String res = new ClientBrowser().getHtmlContentByGetRequest2(url, proxyIp, proxyPort);
//        System.out.println(res);
        String res2 = new ClientBrowser().getHtmlContentByGetRequest("http://www.data5u.com/free/gwpt/index.shtml");
        System.out.println(res2);
    }
}

