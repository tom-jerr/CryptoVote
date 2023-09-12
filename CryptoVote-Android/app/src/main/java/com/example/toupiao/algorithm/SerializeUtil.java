package com.example.toupiao.algorithm;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Base64;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.util.Base64;

/**
 * 序列化工具类
 */
public class SerializeUtil {

    /**
     * 字节数组转换为字符串
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String bytesToString(byte[] bytes) {
        //// 字符串、字节数组转换方式很多，可以根据自己的要求，自定义转换方式
        //转换成hex
        //return org.apache.commons.codec.binary.Hex.encodeHexString(bytes);
        //转换成base64
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 字符串转换为字节数组
     * @param str
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static byte[] stringToByte(String str) {
        //// 字符串、字节数组转换方式很多，可以根据自己的要求，自定义转换方式
        //转换成hex
        //return org.apache.commons.codec.binary.Hex.decodeHex(str);
        //转换成base64
        return Base64.getDecoder().decode(str);
    }

    /**
     * 序列化对象（依赖commons-lang3包）
     * @param obj 序列化对象
     * @return  对象序列化之后的字符串
     */
    public static String serialize(Serializable obj) throws Exception{
        if(obj!=null) {
            byte[] bytes = SerializationUtils.serialize(obj);
            return bytesToString(bytes);
        }
        return null;
    }

    /**
     * 反序列化对象（依赖commons-lang3包）
     * @param str   反序列化字符串
     * @return      反序列化之后的对象
     */
    public static <T extends Serializable> T deserialize(String str) throws Exception{
        if(StringUtils.isNotEmpty(str)){
            return SerializationUtils.deserialize(stringToByte(str));
        }
        return null;
    }
}