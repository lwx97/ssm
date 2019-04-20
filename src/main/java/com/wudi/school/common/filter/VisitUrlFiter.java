package com.wudi.school.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wudi.school.common.constant.GlobalConstant;



@WebFilter(urlPatterns = {"/html/student/*","/html/admin/*","/html/teacher/*"})
public class VisitUrlFiter implements Filter {

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse)response;
		String path = req.getServletPath();
		HttpSession session = req.getSession();
//		String account = (String) session.getAttribute("account");
		String role = (String) session.getAttribute("role");
		if(role==null){
			res.sendRedirect(req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+GlobalConstant.INDEX_PATH);
			return;
		}else if(path.contains(GlobalConstant.STU_URL) && GlobalConstant.STU_VALUE.equals(role)){
			//满足路径和角色统一则通过。		学生
		}else if(path.contains(GlobalConstant.TEA_URL) && GlobalConstant.TEA_VALUE.equals(role)){
			//满足路径和角色统一则通过。		教师
		}else if(path.contains(GlobalConstant.ADMIN_URL) && GlobalConstant.ADMIN_VALUE.equals(role)){
			//满足路径和角色统一则通过。		超管
		}else{
			res.sendRedirect(req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+GlobalConstant.INDEX_PATH);
			return;
		}
		chain.doFilter(request, response);
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
