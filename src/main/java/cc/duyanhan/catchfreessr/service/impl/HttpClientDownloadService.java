package cc.duyanhan.catchfreessr.service.impl;

import org.springframework.stereotype.Service;

import cc.duyanhan.catchfreessr.entity.ProxyPage;
import cc.duyanhan.catchfreessr.service.DownloadService;
import cc.duyanhan.catchfreessr.util.PageDownloadUtils;

/** 
* @author duyanhan
* @version 创建时间：2018年9月22日 下午11:01:23 
* 
*/
@Service
public class HttpClientDownloadService implements DownloadService {

	@Override
	public ProxyPage download(String url) {
		ProxyPage proxyPage = new ProxyPage();
		proxyPage.setContent(PageDownloadUtils.getPageContent(url));
		return proxyPage;
	}

}
