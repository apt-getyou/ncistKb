package cn.edu.ncist.kb.controllers;

import cn.edu.ncist.kb.bean.ScheduleBean;
import cn.edu.ncist.kb.exceptions.FileIsEmptyException;
import cn.edu.ncist.kb.param.ScheduleParam;
import cn.edu.ncist.kb.result.WebResult;
import cn.edu.ncist.kb.service.ScheduleService;
import cn.edu.ncist.kb.utils.ExcelImportXLSXUtil;

import java.util.List;

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
	public WebResult getSchedule(@RequestParam("file") MultipartFile file, ScheduleParam param) {
		List<String[]> listOb;
		if (file.isEmpty()) {
			throw new FileIsEmptyException();
		}
		try {
			listOb = ExcelImportXLSXUtil.readerExcel(file.getInputStream(), "Sheet1", 14);
		} catch (Exception e) {
			throw new FileIsEmptyException();
		}
		if (listOb == null || listOb.size() == 0) {
			throw new FileIsEmptyException();
		}
		List<String> xhs = scheduleService.getXhsFormExcel(listOb);
		WebResult result = new WebResult();
		result.addDataMap("schedule", scheduleService.getSchedule(xhs, param.initBean(new ScheduleBean())));
		return result;
	}
}

