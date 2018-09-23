package cc.duyanhan.catchfreessr.service.impl;

import java.util.List;

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
			evaluateXPath = rootNode.evaluateXPath("//ul[@class='l2']");
			Integer number;
			if (evaluateXPath != null && (number = evaluateXPath.length) > 0) {
				// 查看代理个数
				for (int i = 0; i < number; i ++) {
					TagNode node = (TagNode) evaluateXPath[i];
					// 获取IP
//					String string = node.getChildren().get(0).getChildren().get(0).getText().toString();
					String string = node.getText().toString();
					System.out.println(string);
				}
			}
		} catch (XPatherException e) {
			e.printStackTrace();
		}
	}

}
