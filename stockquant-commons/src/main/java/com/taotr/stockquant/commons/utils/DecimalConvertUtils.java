package com.taotr.stockquant.commons.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DecimalConvertUtils {
    public static final char[] array =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd',
                    'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',
                    'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D',
                    'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    public static Map<Character, Integer> charValueMap = new HashMap<Character, Integer>();

    //初始化map
    static {
        for (int i = 0; i < array.length; i++) charValueMap.put(array[i], i);
    }

    public static void main(String[] args) {
        /* for (int i = 0; i < 100; i++) { */
        long number = new Date().getTime();
        String decimalStr = numberConvertToDecimal(number, 62);
        System.out.println(number + " 转换成 " + decimalStr);
        long toNumber = decimalConvertToNumber(decimalStr, 62);
        System.out.println(decimalStr + " 转换成 " + toNumber);
        /*		}*/
    }

    /**
     * 把数字转换成相对应的进制,目前支持(2-62)进制
     *
     * @param number
     * @param decimal
     * @return
     */
    public static String numberConvertToDecimal(long number, int decimal) {
        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            builder.append(array[(int) (number - (number / decimal) * decimal)]);
            number /= decimal;
        }
        return builder.reverse().toString();
    }

    /**
     * 把进制字符串转换成相应的数字
     *
     * @param decimalStr
     * @param decimal
     * @return
     */
    public static long decimalConvertToNumber(String decimalStr, int decimal) {
        long sum = 0;
        long multiple = 1;
        char[] chars = decimalStr.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            sum += charValueMap.get(c) * multiple;
            multiple *= decimal;
        }
        return sum;
    }

    /**
     * 元转分（乘以100）
     * @param amount 金额 分（支持大数字，16位以上）
     * @return
     */
    public static String changeY2F(String amount){
        return new BigDecimal(amount).multiply(new BigDecimal(100)).toString();
    }

    /**
     * 分转元，转换为bigDecimal在toString
     *
     * @return
     */
    public static String changeF2Y(int price) {
        return BigDecimal.valueOf(Long.valueOf(price)).divide(new BigDecimal(100)).toString();
    }
}
