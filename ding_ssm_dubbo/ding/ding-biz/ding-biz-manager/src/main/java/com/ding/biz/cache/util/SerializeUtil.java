package com.ding.biz.cache.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	 * @param obj
	 * @return byte[]
	 */
	public static byte[] serialize(Object obj){
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		
		try {
			baos = new ByteArrayOutputStream();
			oos= new ObjectOutputStream(baos);
			oos.writeObject(obj);
			byte[] byteArray = baos.toByteArray();
			return byteArray;
		} catch (IOException e) {
				
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 反序列化
	 * 
	 * byte数组装换为对象
	 * @param bytes
	 * @return
	 */
	public static Object unSerialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			bais=new ByteArrayInputStream(bytes);
			ObjectInputStream inputStream = new ObjectInputStream(bais);
			return inputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
