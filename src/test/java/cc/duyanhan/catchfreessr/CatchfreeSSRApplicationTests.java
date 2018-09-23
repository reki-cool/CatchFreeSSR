package cc.duyanhan.catchfreessr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cc.duyanhan.catchfreessr.entity.ProxyPage;
import cc.duyanhan.catchfreessr.service.impl.DATA5UProcess;
import cc.duyanhan.catchfreessr.service.impl.HttpClientDownloadService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatchfreeSSRApplicationTests {

    @Test
    public void contextLoads() {
    	HttpClientDownloadService httpClientDownloadService = new HttpClientDownloadService();
    	ProxyPage page = httpClientDownloadService.download("http://www.data5u.com/free/area/%E9%A6%99%E6%B8%AF/index.html");
    	DATA5UProcess data5uProcess = new DATA5UProcess();
    	data5uProcess.process(page);
    }

}
