package cc.duyanhan.catchfreessr.client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

/**
 * 客户端请求相关
 */
public class ClientRequest {

    public HttpPost createPostRequest() {
        return new HttpPost();
    }
}
