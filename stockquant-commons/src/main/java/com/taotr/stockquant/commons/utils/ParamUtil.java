package com.taotr.stockquant.commons.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能说明: 审核字段分割函数<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author yejg<br>
 * 开发时间: 2012-03-28<br>
 */
public class ParamUtil {

	private final static Logger logger = LoggerFactory.getLogger(ParamUtil.class);

	public static final int SPLIT_BYTE = 2048;

	public static final String SPLIT_PATTERN = "(\\d+)";

	/**
	 * 将制定字符串切片
	 * @param key 切片名称
	 * @param value 完整字符串
	 * @return 切片的字符串集合
	 */
	public static Map<String, String> splitParam(String key, String value) {
		if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(value)) {
			Map<String, String> smap = new HashMap<String, String>();
			if (value.length() > SPLIT_BYTE) {
				String[] splitStr = splitStr(value, SPLIT_BYTE);
				if (splitStr.length > 1) {
					for (int i = 0; i < splitStr.length; i++) {
						if (i == 0) {
							smap.put(key, splitStr[i]);
						} else {
							smap.put(key + i, splitStr[i]);
						}
					}
				}
			} else {
				smap.put(key, value);
			}
			return smap;
		}
		return null;
	}

	/**
	 * 对制定字符按照指定的字符字节数进行分割
	 * @param str 需要进行分割的字符串
	 * @param bytes 多少字符个数进行分割
	 * @return 分割后的数组
	 */
	private static String[] splitStr(String str, int bytes) {
		int loopCount;
		loopCount = (str.length() % bytes == 0) ? (str.length() / bytes) : (str.length() / bytes + 1);
		String result[] = new String[loopCount];
		for (int i = 1; i <= loopCount; i++) {
			if (i == loopCount) {
				logger.debug(String.format("%s:%s", str, (str.substring((i - 1) * bytes, str.length()))));
				result[i - 1] = str.substring((i - 1) * bytes, str.length());
			} else {
				logger.debug(String.format("%s:%s", str, (str.substring((i - 1) * bytes, (i * bytes)))));
				result[i - 1] = str.substring((i - 1) * bytes, (i * bytes));
			}
		}
		return result;
	}

	/**
	 * 将切片的字符串集合进行合并输出
	 * @param name 切片名称
	 * @param params 各个切片字符串
	 * @return 合并后的字符串
	 */
	public static String mergeParam(String name, Map<String, String> params) {
		Pattern namePattern = Pattern.compile(name + ParamUtil.SPLIT_PATTERN);

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Iterator<String> it = params.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			String value = params.get(key);
			Matcher matcher = namePattern.matcher(key);
			if (name.equals(key)) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("index", "0");
				map.put("value", value);
				list.add(map);
			} else if (matcher.matches()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("index", matcher.group(1));
				map.put("value", value);
				list.add(map);
			}
		}
		Collections.sort(list, new Comparator<Map<String, String>>() {

			@Override
			public int compare(Map<String, String> m1, Map<String, String> m2) {
				return m1.get("index").compareTo(m2.get("index"));
			}
		});
		StringBuffer result = new StringBuffer();
		for (Map<String, String> map : list) {
			result.append(map.get("value"));
		}
		return result.toString();
	}
	
	/**
	 * 按照编码方式不同截取指定长度字节
	 * @param str 待截取字符串
	 * @param length 需要截取的字节长度
	 * @param charset 编码方式
	 * @return
	 */
	public static String substring(String str,int length,String charset){
		String result = null;
		try {
			if(StringUtils.isBlank(str)){
				return str;
			}
			//判断str的长度是否超过length，超过了就先直接截取length
			if(str.length() > length){
				str = str.substring(0, length);
			}
			//从length处倒序处理
			while(true){
				//判断str的字节数是否<=length，如果小于则直接返回
				int str_bytes_length = str.getBytes(charset).length;
				if("unicode".equalsIgnoreCase(charset)){
					str_bytes_length = str_bytes_length - 2;
				}
				if(str_bytes_length > length){
					str = str.substring(0, str.length()-1);
					continue;
				}
				result = str;
				break;
			}
		} catch (UnsupportedEncodingException e) {
			//logger.error("切片异常", e);
		}
		return result;
	}
	
	/**
	 * 将字符串按照指定编码切片
	 * @param str 待切片字符串
	 * @param length 每片的长度
	 * @param charset 编码方式
	 * @return
	 */
	public static List<String> slice(String str,int length,String charset){
        List<String> result = new ArrayList<String>();
        if(StringUtils.isBlank(str)){
            return null;
        }
        while(true){
            String tmp = substring(str,length,charset);
            if(StringUtils.isNotBlank(tmp)){
                result.add(tmp);
                str = str.substring(tmp.length());
            }else{
                break;
            }
        }
        return result;
    }
	
	public static void main(String[] args) throws IOException {
		// String token = Base64.encodeBase64String(FileUtils.readFileToByteArray(new File("D:\\Hundsun\\启动参数.txt")));
		// System.out.println(token);
		// Map<String, String> userMap = splitParam("token", token);
		// mergeParam(userMap);
		// System.out.println(userMap);
	}

}
