package com.ding.biz.manager;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class UtilsTest {

    public static void main(String args[]) {
//        UserDO user =new UserDO();
//        user.setId(12);
//        user.setName("dinglh");
//        user.setPassword("lskjdflsj");
//        String serialize = SerializeUtil.serializeForCache(user);
//        Object unSerialize = SerializeUtil.unSerialize(serialize);
//        UserDO serUser = null;
//        if(unSerialize instanceof UserDO) {
//            serUser = (UserDO) unSerialize;
//        }
//        System.out.println(JSON.toJSONString(serUser));
    }

    public ArrayList<String> getArrayList(byte[] bt) {
        ArrayList<String> list = new ArrayList<String>();
        ObjectInputStream objIps;

        // 注意这里，ObjectInputStream 对以前使用 ObjectOutputStream
        // 写入的基本数据和对象进行反序列化。问题就在这里，你是直接将byte[]数组传递过来，而这个byte数组不是使用ObjectOutputStream类写入的。所以问题解决的办法就是：用输出流得到byte[]数组。
        try {
            objIps = new ObjectInputStream(new ByteArrayInputStream(bt));
            list = (ArrayList<String>) objIps.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
