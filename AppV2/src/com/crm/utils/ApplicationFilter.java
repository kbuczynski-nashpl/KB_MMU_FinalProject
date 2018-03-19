package com.crm.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApplicationFilter implements Filter {

	private ArrayList<String> resources = new ArrayList<String>();

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String ipAddress = request.getRemoteAddr();
		System.out.println("IP " + ipAddress + ", Time " + new Date().toString());
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession _SESSION = req.getSession();

		String path = ((HttpServletRequest) request).getRequestURI();
		String baseURL = path.substring(0, path.length() - ((HttpServletRequest) request).getRequestURI().length())
				+ ((HttpServletRequest) request).getContextPath() + "/";
		System.out.println("Validating for page: " + path);

		for (String extension : this.resources) {
			if (path.endsWith(extension)) {
				chain.doFilter(request, response);
				return;
			}
		}
		boolean loggedIn = false;
		if (_SESSION != null) {
			if (_SESSION.getAttribute("CLIENT") != null) {
				loggedIn = true;
			}
		}

		if (loggedIn) {
			_SESSION.setAttribute("REDIRECT", path);
			chain.doFilter(req, res);
			return;
		} else {
			if (_SESSION == null) {
				_SESSION = req.getSession();
			}
			_SESSION.setAttribute("REDIRECT", path);
			res.sendRedirect(baseURL + "login");
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Adding extension to exclude");
		this.resources.add(".css");
		this.resources.add(".js");
		this.resources.add(".jpeg");
		this.resources.add(".png");
		this.resources.add(".html");
		this.resources.add("login");
	}
}
