package com.ding.web.common.config;

public class WebConfig  extends PublicConfig{
	    private WebConfig() {
	    }

	    /** 网站公共资源脚本路径 */
	    public static String getPublicJsPath() {
	        return getWebStaticPath() + "/public/" + getWebStaticVersion() + "/js";
	    }

	    /** 网站公共资源CSS路径 */
	    public static String getPublicCssPath() {
	        return getWebStaticPath() + "/public/" + getWebStaticVersion() + "/css";
	    }

	    /** 网站公共资源图片路径 */
	    public static String getPublicImgPath() {
	        return getWebStaticPath() + "/public/" + getWebStaticVersion() + "/images";
	    }

	    /** 网站本地资源脚本路径 */
	    public static String getWebJsPath() {
	        return getWebStaticPath() + "/www/" + getWebStaticVersion() + "/js";
	    }

	    /** 网站本地资源CSS路径 */
	    public static String getWebCssPath() {
	        return getWebStaticPath() + "/www/" + getWebStaticVersion() + "/css";
	    }

	    /** 网站本地资源图片路径 */
	    public static String getWebImgPath() {
	        return getWebStaticPath() + "/www/" + getWebStaticVersion() + "/images";
	    }



}
