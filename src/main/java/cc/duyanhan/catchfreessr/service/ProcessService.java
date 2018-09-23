package cc.duyanhan.catchfreessr.service;

import cc.duyanhan.catchfreessr.entity.ProxyPage;

/** 
* @author duyanhan
* @version 创建时间：2018年9月23日 下午7:24:49 
* 页面解析接口
*/
public interface ProcessService {
	/**
	 * 代理页面信息处理
	 * @param proxyPage
	 */
	public void process(ProxyPage proxyPage);
}
