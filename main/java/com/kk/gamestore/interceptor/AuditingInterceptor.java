package com.kk.gamestore.interceptor;
import java.text.DateFormat;
import org.apache.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class AuditingInterceptor extends HandlerInterceptorAdapter {
	Logger logger = Logger.getLogger("auditLogger");
	private String user;
	private String gameId;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler) throws Exception {
		if(request.getRequestURI().endsWith("games/add") &&
		request.getMethod().equals("POST")){
			user = request.getRemoteUser();
			gameId = request.getParameterValues("gameId")[0];
		}
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3) throws Exception {
		if(request.getRequestURI().endsWith("games/add") &&
		response.getStatus()==302){
			logger.info(String.format("Nowa gra [%s] dodany przez %s dnia %s", gameId, user, getCurrentTime()));
		}
	}

	private Object getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'o' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
