package cc.duyanhan.catchfreessr.service;

import cc.duyanhan.catchfreessr.entity.ProxyPage;

/** 
* @author duyanhan
* @version 创建时间：2018年9月22日 下午10:59:17 
* 
*/
public interface DownloadService {
	/**
	 * 代理信息页面下载
	 * @param url
	 * @return
	 */
	ProxyPage download(String url);
}
