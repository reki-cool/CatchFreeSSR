package cc.duyanhan.catchfreessr.entity;
/** 
* @author duyanhan
* @version 创建时间：2018年9月22日 下午10:38:38 
* 要获取的代理信息实体
*/
public class ProxyEntity {
	/**
	 * IP地址
	 */
	private String ip;
	/**
	 * 端口号
	 */
	private String port;
	/**
	 * 匿名度（分为透明、匿名、高匿）
	 */
	private String level;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 国家
	 */
	private String state;
	/**
	 * 省市
	 */
	private String city;
	/**
	 * 运营商
	 */
	private String operator;
	/**
	 * 响应速度
	 */
	private String responseSpeed;
	/**
	 * 最后验证时间
	 */
	private String finalVerificationTime;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getResponseSpeed() {
		return responseSpeed;
	}
	public void setResponseSpeed(String responseSpeed) {
		this.responseSpeed = responseSpeed;
	}
	public String getFinalVerificationTime() {
		return finalVerificationTime;
	}
	public void setFinalVerificationTime(String finalVerificationTime) {
		this.finalVerificationTime = finalVerificationTime;
	}
	
	
}
