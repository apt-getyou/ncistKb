package cn.edu.ncist.kb.controllers;

import cn.edu.ncist.kb.param.ScheduleParam;
import cn.edu.ncist.kb.service.ScheduleService;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 19:41
 */
@Controller
public class HomeController {
	@Resource
	private ScheduleService scheduleService;

	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "getSchedule", method = RequestMethod.POST)
	@ResponseBody
	public String getSchedule(@RequestParam("file") MultipartFile file, ScheduleParam param) {
		scheduleService.getSchedule();
		return "123";
	}
}

