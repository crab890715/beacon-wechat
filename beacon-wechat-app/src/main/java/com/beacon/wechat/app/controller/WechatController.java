package com.beacon.wechat.app.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beacon.wechat.app.biz.WeixinBiz;
import com.beacon.wechat.app.utils.AppUtils;
@Controller 
@RequestMapping("/wechat")
public class WechatController {
	private Logger log = Logger.getLogger(WechatController.class);
	@Autowired
	WeixinBiz weixinBiz;
//	public WechatController() {
//		System.err.println(AppUtils.request().getParameter("test"));
////		String url = weixinBiz.oauth2buildAuthorizationUrl();
//	}
	@RequestMapping(value="/auth",method=RequestMethod.GET) 
	public String auth(String code) { 
		if(StringUtils.isBlank(code)){
			return "redirect:" + weixinBiz.oauth2buildAuthorizationUrl(AppUtils.request().getRequestURL().toString());
//			return "redirect:" + weixinBiz.oauth2buildAuthorizationUrl("http://www.baidu.com");
		}
		return null;
	}
	
	@RequestMapping(value="/dispatcher",method=RequestMethod.GET) 
	public ModelAndView dispatcher() { 
		
		return null;
	}
}