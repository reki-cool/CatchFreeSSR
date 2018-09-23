package cc.duyanhan.catchfreessr.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cc.duyanhan.catchfreessr.entity.ProxyPage;
import cc.duyanhan.catchfreessr.service.DownloadService;
import cc.duyanhan.catchfreessr.util.PageDownloadUtils;

/** 
* 类说明：下载业务的HttpClient方式实现
* @author duyanhan
* @version 创建时间：2018年9月22日 下午11:01:23 
*/
@Service
public class HttpClientDownloadService implements DownloadService {
	private static final Logger LOGGER = Logger.getLogger(HttpClientDownloadService.class);
	@Override
	public ProxyPage download(String url) {
		ProxyPage proxyPage = new ProxyPage();
		try {
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			headers.put("Accept-Encoding", "gzip, deflate, br");
			headers.put("Accept-Language", "zh-CN,zh;q=0.9");
			headers.put("Host", "www.data5u.com");
			headers.put("Referer", "http://www.data5u.com/");
			headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36");
			String content = PageDownloadUtils.getPageContentWithHeaders(url, headers);
//			LOGGER.info(content);
			proxyPage.setContent(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proxyPage;
	}

}
