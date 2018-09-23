# CatchFreeSSR

抓取目标：https://doub.io等

新的问题：https://doub.io等网站本身就已经被墙了

解决思路：利用免费的国外代理对目标站点的共享ssr账号进行抓取

免费代理提供：http://www.data5u.com/free/gwpt/index.shtml

编程语言：Java

项目参考：https://github.com/zc-zh-001/ShadowSocks-Share

依赖解决：HttpCore、HttpClient、HttpMime、Gson、selenium、pantomjs、

## 问题1：
无论代理网站还是ssr账号网站，都有ajax异步加载的信息，单独使用httpClient无法完成获取
## 解决方案：
通过selenium+pantomjs模拟真实浏览器完成异步加载信息的获取

## 问题2：
不同的系统，依赖的浏览器不同
## 解决方案：
java编程判断当前系统类型，调用相应的可执行文件，windows下的bat文件，linux下的shell脚本，执行远程下载可用的浏览器，并解压安装至指定目录

## 问题3：
抓取目标的网站域名什么的可能会更换
## 解决方案：
设置信息可配置