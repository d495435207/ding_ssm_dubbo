package com.ding.biz.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import net.sf.json.JSONObject;

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
    public static String serializeForCache(Object obj) {
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
        	LoggerUtils.fmtError(CLAZZ,e, "serialize error %s", JSONObject.fromObject(obj));
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

static final Class<?> CLAZZ = SerializeUtil.class;
	
    public static byte[] serialize(Object value) {
        if (value == null) { 
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (Exception e) {
        	LoggerUtils.fmtError(CLAZZ,e, "serialize error %s", JSONObject.fromObject(value));
        } finally {
            close(os);
            close(bos);
        }
        return rv;
    }

    
	public static Object deserialize(byte[] in) {
        return deserialize(in, Object.class);
    }

    public static <T> T deserialize(byte[] in, Class<T>...requiredType) {
        Object rv = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                rv = is.readObject();
            }
        } catch (Exception e) {
        	 LoggerUtils.fmtError(CLAZZ,e, "serialize error %s", in);
        } finally {
            close(is);
            close(bis);
        }
        return (T) rv;
    }

    private static void close(Closeable closeable) {
        if (closeable != null)
            try {
                closeable.close();
            } catch (IOException e) {
            	 LoggerUtils.fmtError(CLAZZ, "close stream error");
            }
    }
    
}
