package com.ding.biz.cache.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import com.alibaba.fastjson.JSON;
import com.ding.biz.dao.user.data.UserDO;

/**
 * @ClassName: SerializeUtil
 * @Description: 序列化反序列化工具类
 * @author dinglh
 * @date 2017年10月13日 下午1:49:18
 * 
 */
public class SerializeUtil {
    /**
     * 序列化
     * 
     * 对象序列化成byte数组
     * 
     * @param obj
     * @return byte[]
     */
    public static String serialize(Object obj) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            byte[] byteArray = baos.toByteArray();
            String encodeToString = Base64.getEncoder().encodeToString(byteArray);
            return encodeToString;
//            return byteArray;
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    /**
     * 反序列化
     * 
     * byte数组装换为对象
     * 
     * @param bytes
     * @return
     */
    public static Object unSerialize(String bytes) {
        // TODO 序列化出错的问题一直没有解决
        ByteArrayInputStream bais = null;
        byte[] decode = Base64.getDecoder().decode(bytes);
        try {
            bais = new ByteArrayInputStream(decode);
            ObjectInputStream inputStream = new ObjectInputStream(bais);
            return inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        UserDO user = new UserDO();
        user.setId(1);
        user.setName("dinglh");
        user.setPassword("dinglh_pass");
        String serialize = serialize(user);
        Object unSerialize = unSerialize(serialize);
        System.out.println(JSON.toJSONString(unSerialize));
    }

}
