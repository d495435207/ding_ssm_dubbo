package com.ding.web.common.config;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 管理整站全局公共properties配置的类,加载 properties 文件的顺序如下:
 * <ol>
 * <li>默认配置文件为 default.properties 的内容</li>
 * <li>自定义配置文件为各网站下的 webconfig.properties</li>
 * <li>自定义配置文件里的属性会覆盖默认配置文件里的同名属性的值</li>
 * <li>自定义配置文件里的属性可以直接使用PublicConfig.getProperty(key)来调用</li>
 * </ol>
 *
 * @author KKBOY
 */
public class PublicConfig {
    private static final Logger logger = LoggerFactory.getLogger(PublicConfig.class);
    private static final String DEFAULT_FILENAME = "default.properties";
    private static final String LOCAL_PROPERTIES = "/webconfig.properties";
    private static Properties properties = new Properties();

    static {

        // 1. load library defaults
        InputStream in = PublicConfig.class.getResourceAsStream(DEFAULT_FILENAME);

        if (in == null) {
            logger.error("{} not found", DEFAULT_FILENAME);
            throw new RuntimeException(DEFAULT_FILENAME + " not found");
        } else {
            if (!(in instanceof BufferedInputStream))
                in = new BufferedInputStream(in);

            try {
                properties.load(in);
                in.close();
                logger.debug("{} loaded", DEFAULT_FILENAME);
            } catch (Exception e) {
                logger.error("Error while processing {}", DEFAULT_FILENAME);
                throw new RuntimeException("Error while processing " + DEFAULT_FILENAME, e);
            }
        }

        // 2. load user defaults if present
        InputStream in2 = PublicConfig.class.getResourceAsStream(LOCAL_PROPERTIES);

        if (in2 == null) {
            logger.info("{} not found", LOCAL_PROPERTIES);
        } else {

            if (!(in2 instanceof BufferedInputStream))
                in2 = new BufferedInputStream(in2);

            try {
                properties.load(in2);
                in2.close();
                logger.debug("{} loaded", LOCAL_PROPERTIES);
            } catch (Exception e) {
                logger.error("Error while processing {}", LOCAL_PROPERTIES);
                throw new RuntimeException("Error while processing " + LOCAL_PROPERTIES, e);
            }

        }
    }

    /**
     * 根据属性名读取一个属性的值
     *
     * @see Properties#getProperty(String)
     */
    public static String getProperty(final String key) {
        return properties.getProperty(key);
    }

    /**
     * 设置一个属性的key,value
     *
     * @see Properties#setProperty(String, String)
     */
    public static void setProperty(final String key, final String value) {
        properties.setProperty(key, value);
    }

    /**
     * 返回 <code>host.api.cart</code> 购物车接口地址
     */
    public static String getHostApiCart() {
        return properties.getProperty("host.api.cart");
    }

    /**
     * 返回 <code>host.api.user</code> 用户模块接口地址
     */
    public static String getHostApiUser() {
        return properties.getProperty("host.api.user");
    }

    /**
     * 返回 <code>host.api.orders</code> 订单接口访问地址
     */
    public static String getHostApiOrders() {
        return properties.getProperty("host.api.orders");
    }

    /**
     * 返回 <code>host.api.product</code> 商品接口访问地址
     */
    public static String getHostApiProduct() {
        return properties.getProperty("host.api.product");
    }

    /**
     * 返回 <code>host.api.health</code> 健康大讲堂接口地址
     */
    public static String getHostApiHealth() {
        return properties.getProperty("host.api.health");
    }

    /**
     * 返回 <code>host.api.coupon</code> 优惠卷购物卡接口
     */
    public static String getHostApiCoupon() {
        return properties.getProperty("host.api.coupon");
    }

    /**
     * 返回 <code>host.api.channel</code> 频道接口(包括药品专题)
     */
    public static String getHostApiChannel() {
        return properties.getProperty("host.api.channel");
    }

    /**
     * 返回 <code>host.api.backstage</code> .NET项目后台地址
     */
    public static String getHostApiBackstage() {
        return properties.getProperty("host.api.backstage");
    }

    /**
     * 返回 <code>host.img.avatar</code> 属性 账户图片地址
     */
    public static String getHostImgAvatar() {
        return properties.getProperty("host.img.avata");
    }

    /**
     * 返回 <code>host.img.product</code> 属性 产品图片地址
     */
    public static String getHostImgProduct() {
        return properties.getProperty("host.img.product");
    }

    /**
     * 返回 <code>host.img.health</code> 属性 健康大讲堂图片地址
     */
    public static String getHostImgHealth() {
        return properties.getProperty("host.img.health");
    }

    /**
     * 返回 <code>host.img.brand</code> 属性
     */
    public static String getHostImgBrand() {
        return properties.getProperty("host.img.brand");
    }

    /**
     * 返回 <code>host.img.special</code> 属性
     */
    public static String getHostImgSpecial() {
        return properties.getProperty("host.img.special");
    }

    /**
     * 返回 <code>host.url.web.wwwUrl</code> 属性 金象网前端网址
     */
    public static String getHostUrlWebWwwurl() {
        return properties.getProperty("host.url.web.wwwUrl");
    }

    /**
     * 返回 <code>host.url.web.loginUrl</code> 属性 登录模块网址
     */
    public static String getHostUrlWebLoginurl() {
        return properties.getProperty("host.url.web.loginUrl");
    }

    /**
     * 返回 <code>host.url.web.shoppingUrl</code> 属性 购物车模块网址
     */
    public static String getHostUrlWebShoppingurl() {
        return properties.getProperty("host.url.web.shoppingUrl");
    }

    /**
     * 返回 <code>host.url.web.homeUrl</code> 属性 会员中心模块网址
     */
    public static String getHostUrlWebHomeUrl() {
        return properties.getProperty("host.url.web.homeUrl");
    }

    /**
     * 返回 <code>host.url.web.payUrl</code> 属性 支付模块网址
     */
    public static String getHostUrlWebPayUrl() {
        return properties.getProperty("host.url.web.payUrl");
    }

    /**
     * 返回 <code>host.url.web.drugsUrl</code> 属性 药品专题模块网址
     */
    public static String getHostUrlWebDrugsUrl() {
        return properties.getProperty("host.url.web.drugsUrl");
    }

    /**
     * 返回 <code>host.url.h5.wwwUrl</code> 属性 金象网H5前端网址
     */
    public static String getHostUrlH5Wwwurl() {
        return properties.getProperty("host.url.h5.wwwUrl");
    }

    /**
     * 返回 <code>host.url.h5.loginUrl</code> 属性 H5登录模块网址
     */
    public static String getHostUrlH5Loginurl() {
        return properties.getProperty("host.url.h5.loginUrl");
    }

    /**
     * 返回 <code>host.url.h5.shoppingUrl</code> 属性 H5购物车模块网址
     */
    public static String getHostUrlH5Shoppingurl() {
        return properties.getProperty("host.url.h5.shoppingUrl");
    }

    /**
     * 返回 <code>host.url.h5.homeUrl</code> 属性 H5会员中心模块网址
     */
    public static String getHostUrlH5HomeUrl() {
        return properties.getProperty("host.url.h5.homeUrl");
    }

    /**
     * 返回 <code>host.url.h5.payUrl</code> 属性 H5支付模块网址
     */
    public static String getHostUrlH5PayUrl() {
        return properties.getProperty("host.url.h5.payUrl");
    }

    /**
     * 返回 <code>web.static.public.version</code> 属性 网站公共静态资源路径
     */
    public static String getWebStaticPublicPath() {
        return properties.getProperty("web.static.public.path");
    }

    /**
     * 返回 <code>web.static.public.path</code> 属性 网站公共静态资源版本
     */
    public static String getWebStaticPublicVersion() {
        return properties.getProperty("web.static.public.version");
    }

    /**
     * 返回 <code>web.static.path</code> 属性 网站静态资源路径
     */
    public static String getWebStaticPath() {
        return properties.getProperty("web.static.path");
    }

    /**
     * 返回 <code>web.static.version</code> 属性 网站静态资源版本
     */
    public static String getWebStaticVersion() {
        return properties.getProperty("web.static.version");
    }

    /**
     * SSO 登录加密参数 ecn
     */
    public static String getSsoEcn() {
        return properties.getProperty("sso.ecn");
    }

    /**
     * SSO 登录加密参数 ccn
     */
    public static String getSsoCcn() {
        return properties.getProperty("sso.ccn");
    }

    /**
     * SSO 登录加密参数 domain
     */
    public static String getSsoDomain() {
        return properties.getProperty("sso.domain");
    }

    /**
     * SSO 登录加密参数 path
     */
    public static String getSsoPath() {
        return properties.getProperty("sso.path");
    }

    /**
     * SSO 登录加密参数 version
     */
    public static String getSsoVersion() {
        return properties.getProperty("sso.ver");
    }

    /**
     * SSO 登录加密参数 pin
     */
    public static String getSsoPin() {
        return properties.getProperty("sso.pin");
    }

    /**
     * SSO 登录加密参数 maxage
     */
    public static Integer getSsoMaxage() {
        return NumberUtils.toInt(properties.getProperty("sso.max_age"), 86400);
    }

    /**
     * SSO 登录加密参数 maxagelogin
     */
    public static Integer getSsoMaxageLogin() {
        return NumberUtils.toInt(properties.getProperty("sso.max_age_login"), 86400);
    }

    /**
     * SSO 登录加密参数 token_pwd
     */
    public static String getSsoTokenpwd() {
        return properties.getProperty("sso.token_pwd");
    }

}
