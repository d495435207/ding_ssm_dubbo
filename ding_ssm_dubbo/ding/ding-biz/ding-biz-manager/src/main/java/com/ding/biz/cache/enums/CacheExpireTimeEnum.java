package com.ding.biz.cache.enums;
/**
* @ClassName: CacheExpireTime 
* @Description: 缓存有效期时间枚举 
* @author dinglh
* @date 2017年12月20日 下午6:01:38 
*
 */
public enum CacheExpireTimeEnum {
	ONEMIN("1分钟",60),TENMIN("10分钟",600),ONDAY("一天",86400),ONEMONTH("一个月",2592000);
	
	private CacheExpireTimeEnum(String desc,Integer sec){
		this.desc=desc;
		this.sec=sec;
	}
	private String desc;
	private Integer sec;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getSec() {
		return sec;
	}
	public void setSec(Integer sec) {
		this.sec = sec;
	}
	
	public CacheExpireTimeEnum getEnumBySec(Integer sec){
		if(sec==null || sec<1){
			return null;
		}
		CacheExpireTimeEnum[] values = values();
		for (CacheExpireTimeEnum cacheExpireTimeEnum : values) {
			if(cacheExpireTimeEnum.getSec().equals(sec)){
				return cacheExpireTimeEnum;
			}
		}
		return null;
	}
}
