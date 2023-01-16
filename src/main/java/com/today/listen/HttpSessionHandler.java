package com.today.listen;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.ServletComponentScan;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class HttpSessionHandler implements HttpSessionListener 
{
	public static Map<String, HttpSession> map =
			new HashMap<>();
	
	@Override
	public void sessionCreated(HttpSessionEvent se)
	{
		HttpSession s = se.getSession();
		map.put(s.getId(), s);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se)
	{
		HttpSession s = se.getSession();
		map.remove(s.getId());
	}
}