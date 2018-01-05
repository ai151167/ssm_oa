package com.oa.demo.qsy;

import java.util.List;

public class CommonUtils {
		
	public static boolean isNotEmpty(String org) {
		if(org!=null&&!"".equals(org)) {
			return true;
		}
		return false;
	}
	
	public static <T> boolean listIsNotEmpty(List<T> list) {
		if(list!=null&&list.size()>0) {
			return true;
		}
		return false;
	}
}
