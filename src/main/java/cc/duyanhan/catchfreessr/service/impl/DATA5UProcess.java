package cc.duyanhan.catchfreessr.service.impl;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import cc.duyanhan.catchfreessr.entity.ProxyPage;
import cc.duyanhan.catchfreessr.service.ProcessService;

/** 
* @author duyanhan
* @version 创建时间：2018年9月23日 下午7:32:38 
* www.data5u.com这个代理网站页面信息的处理实现
*/
public class DATA5UProcess implements ProcessService {

	@Override
	public void process(ProxyPage proxyPage) {
		
		String content = proxyPage.getContent();
		
		HtmlCleaner cleaner = new HtmlCleaner();
		TagNode rootNode = cleaner.clean(content);
		Object[] evaluateXPath;
		try {
			evaluateXPath = rootNode.evaluateXPath("//*[@id=\"m_26659\"]/div/div[2]/div/div/div[2]/div/ul[2]/li[1]/a");
			if (evaluateXPath != null && evaluateXPath.length > 0) {
				TagNode node = (TagNode) evaluateXPath[0];
				System.out.println(node.getText().toString());
			}
		} catch (XPatherException e) {
			e.printStackTrace();
		}
	}

}
