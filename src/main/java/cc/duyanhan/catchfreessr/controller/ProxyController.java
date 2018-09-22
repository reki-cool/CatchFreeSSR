package cc.duyanhan.catchfreessr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cc.duyanhan.catchfreessr.entity.ProxyPage;
import cc.duyanhan.catchfreessr.service.DownloadService;

/** 
* @author duyanhan
* @version 创建时间：2018年9月22日 下午11:39:15 
* 代理获取信息页展示
*/
@RestController
@RequestMapping("/proxy")
public class ProxyController {
	
	@Autowired
	private DownloadService httpClientDownloadService;
	
	@RequestMapping(value = "/show/{url:.+}", method = RequestMethod.GET)
	public String showProxyPage(@PathVariable String url) {
		ProxyPage proxyPage = httpClientDownloadService.download("http://" + url);
		System.out.println("http://" + url);
		return proxyPage.getContent();
	}
}
