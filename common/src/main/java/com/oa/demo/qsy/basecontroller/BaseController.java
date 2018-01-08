package com.oa.demo.qsy.basecontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {
	
	/**
	 * 把浏览器参数转化放到MAP集合中
	 */
	
	protected Map<String, Object> getParam(HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<>();
		String method = request.getMethod();
		Enumeration<?> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			if(key!=null) {
				if(key instanceof String) {
					String value = request.getParameter(key.toString());
					if("GET".equals(method)) {
						try {
							value = new String(value.getBytes("ISO-8859-1"), "utf-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					resultMap.put(key.toString(), value);
				}
			}
		}
		return resultMap;
	}
	
	protected void flushResponse(HttpServletResponse response,String responseContent) {
		PrintWriter writer = null;
		try {
			response.setCharacterEncoding("GBK");
			response.setHeader("Cache-Control", "no-cache");
			response.setContentType("text/html;charset=UTF-8");
			writer= response.getWriter();
			if(responseContent==null||"".equals(responseContent)||"null".equals(responseContent)) {
				writer.write("");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}finally {
			if(writer !=null) {
				writer.flush();
				writer.close();
			}
		}
	}
	
	/**
	 * 返回列表分页的下角页码
	 */
	
	public ModelAndView getPageNumberInfo(int total,int startIndex,int pageSize,ModelAndView result) {
		int current = (int) Math.ceil((startIndex +1.0)/pageSize);
		result.addObject("start",startIndex);
		result.addObject("limit",pageSize);
		result.addObject("total",total);
		result.addObject("current",current);
		if(total>0) {
			int page = (int) Math.ceil(total/pageSize);
			double totald = total;
			if(totald/pageSize>total/pageSize) {
				page=page+1;
			}
			result.addObject("page",page);
			int startPage = 0;
			int endPage = 0;
			if(page<8) {
				startPage =1;
				endPage = page;
			}else {
				if(current<5) {
					startPage = 1;
					endPage = page>6?6:page;
				}else if (page-current<6) {
					startPage = page-5;
					endPage = page;
				}else {
					startPage = current-2;
					endPage = current+2;
				}
			}
			result.addObject("startPage",startPage);
			result.addObject("endPage",endPage);
		}else {
			result.addObject("page",0);
		}
		return result;
	}
	
	/**
	 * 获取登录模块session对象
	 */
	protected HttpSession getSession() {
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		String id = session.getId();
		if(session!=null&&session.getServletContext().getContext("/login")!=null&&session.getServletContext().getContext("/login").getAttribute("sessionId_"+session.getId())!=null) {
			String sessionId = session.getId();
			session = (HttpSession) session.getServletContext().getContext("/login").getAttribute("sessionId_"+sessionId);
		}
		return session;
	}
	
	/**
	 * 获取登录模块session中的sessionInfo
	 */
	
	@SuppressWarnings("unchecked")
	protected  Map<String, Object> getSessionInfo(){
		HttpSession session = this.getSession();
		Map<String, Object> sMap = null;
		try {
			if(session.getAttribute("sessionInfo")!=null) {
				sMap= (Map<String, Object>) session.getAttribute("sessionInfo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sMap;
	}
}
