package com.oa.demo.qsy;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

public class MapAndObject {
	
	/**
	 * Introspector内省
	 * @param param
	 * @param beanClass
	 * @return
	 * @throws Exception
	 * @throws IllegalAccessException
	 * 
	 * Introspector 是一个专门处理bean的工具类.用来获取Bean体系里的 propertiesDescriptor,methodDescriptor.
	 */
	public static Object mapToObject(Map<String, Object> param,Class<?> beanClass) throws Exception {
		if(param==null){
			return null;
		}
		Object instance = beanClass.newInstance();
		BeanInfo beanInfo = Introspector.getBeanInfo(instance.getClass());
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : descriptors) {
			Method setter = property.getWriteMethod();
			if(setter!=null) {
				if(param.get(property.getName())!=null&&!"".equals(param.get(property.getName()))) {
					setter.invoke(instance, param.get(property.getName()));
				}
			}
		}
		return instance;
		
	}
}
