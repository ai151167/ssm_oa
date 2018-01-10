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
	
	public static int stringToInt(String str) {
		if (str!=null&&!"".equals(str)) {
			return Integer.parseInt(str);
		}
		return 0;
	}
	
	public static short stringToShort(String str) {
		if(str!=null&&!"".equals(str)) {
			return Short.parseShort(str);
		}
		return 0;
	}
	
	public static Long stringToLong(String str) {
		if(str!=null&&!"".equals(str)) {
			return Long.parseLong(str);
		}
		return (long) 0;
	}
}
