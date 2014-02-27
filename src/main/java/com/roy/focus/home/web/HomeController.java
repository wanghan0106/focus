package com.roy.focus.home.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roy.core.web.Params;
import com.roy.core.web.QueryResult;
import com.roy.core.web.annotation.AfterQuery;
import com.roy.core.web.annotation.BeforeQuery;
import com.roy.focus.user.model.User;
import com.roy.focus.user.service.UserService;

@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/home")
	@BeforeQuery
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/home/list")
	@ResponseBody
	@AfterQuery
	public QueryResult list(Params params) {
		List<User> userList = userService.query(params.getCond(),params.getPager(),params.getSorter());
		return new QueryResult(params.getPager().getTotalCount(),userList);
	}
	
	@RequestMapping(value = "/detail")
	public String detail() {
		return "detail";
	}
	
	@RequestMapping(value = "/404")
	public String notfound() {
		return "404";
	}
	
	@RequestMapping(value = "/500")
	public String error() {
		return "500";
	}
}
