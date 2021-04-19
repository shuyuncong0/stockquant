package com.taotr.stockquant.commons.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taotr.stockquant.commons.constants.OperationFields;
import com.taotr.stockquant.commons.enums.CommonResultCode;
import com.taotr.stockquant.commons.exception.OperationException;
import com.taotr.stockquant.commons.result.CrhBeanResult;
import com.taotr.stockquant.commons.result.CrhListResult;
import com.taotr.stockquant.commons.result.CrhMapResult;
import com.taotr.stockquant.commons.result.CrhPageResult;
import com.taotr.stockquant.commons.utils.SpringContext;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础业务逻辑
 * @author 高伟星
 * @date 2020-04-08 21:06:33
 *
 */
public class BaseServiceImpl<T> {
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T selectOne(T entity) {
		T result = null;
		String className = entity.getClass().getSimpleName();
		Object mapper = SpringContext.getBean(toLowerCaseFirstOne(className+"Mapper"));
		QueryWrapper<T> wrapper = new QueryWrapper<>(entity);
		Method selectOne = getMethod(mapper, "selectOne");
		
		try {
			result = (T) selectOne.invoke(mapper, wrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 查询List数据
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> selectList(T entity) {
		List<T> result = null;
		String className = entity.getClass().getSimpleName();
		Object mapper = SpringContext.getBean(toLowerCaseFirstOne(className+"Mapper"));
		QueryWrapper<T> wrapper = new QueryWrapper<>(entity);
		Method selectList = getMethod(mapper, "selectList");
		
		try {
			result = (List<T>) selectList.invoke(mapper, wrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 业务逻辑分页查询通用方法(根据泛型获取mapper)
	 * @param entity
	 * @param page_num
	 * @param page_size
	 * @param mapper_name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public CrhPageResult<T> selectPage(T entity, int page_num, int page_size) {
		String className = entity.getClass().getSimpleName();
		Object mapper = SpringContext.getBean(toLowerCaseFirstOne(className+"Mapper"));
		CrhPageResult<T> result = null;
		QueryWrapper<T> wrapper = new QueryWrapper<>(entity);
		CrhPageResult<T> page = new CrhPageResult<T>(page_num, page_size);
		Method selectPage = getMethod(mapper, "selectPage");
		try {
			result = (CrhPageResult<T>) selectPage.invoke(mapper, page, wrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 获取返回成功父类结果集
	 * @return
	 */
	public Map<String, Object> getSuccessResultMap() {
		Map<String, Object> result = new HashMap<>();
        result.put(OperationFields.ERROR_NO, "0");
        result.put(OperationFields.SUCCESS, true);
        result.put(OperationFields.ERROR_INFO, CommonResultCode.SUCCESS.getDesc());
        return result;
	}

	public CrhMapResult getSuccessCrhMapResult() {
		CrhMapResult result = new CrhMapResult();
		result.setSuccess(true);
		result.setError_no("0");
		result.setError_info(CommonResultCode.SUCCESS.getDesc());
		return result;
	}
	
	public CrhBeanResult<Object> getSuccessCrhBeanResult() {
		CrhBeanResult<Object> result = new CrhBeanResult<Object>();
		result.setSuccess(true);
		result.setError_no("0");
		result.setError_info(CommonResultCode.SUCCESS.getDesc());
		return result;
	}
	
	public CrhListResult<T> getSuccessCrhLlistResult() {
		CrhListResult<T> result = new CrhListResult<T>();
		result.setSuccess(true);
		result.setError_no("0");
		result.setError_info(CommonResultCode.SUCCESS.getDesc());
		return result;
	}
	
	
	private Method getMethod(Object obj, String methodName) {
		Method[] methods = obj.getClass().getMethods();
		for (Method method : methods) {
			if (methodName.equals(method.getName())) {
				return method;
			}
		}
		throw new OperationException("not find " + methodName + " in " + obj.getClass().getName());
	}

	
	
	@SuppressWarnings("unchecked")
	public Class<T> getTClass(){
		Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return tClass;
	}
	
	 /**
     * 首字母转小写
     * @param s
     * @return
     */
    private String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}
