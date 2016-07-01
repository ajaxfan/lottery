package com.xpyz.lotter.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xpyz.lotter.models.LotterRecord;

@RestController
@RequestMapping(method = RequestMethod.GET)
public class LotterRecordController {
	/**
	 * 列出最近的所有开奖信息
	 * 
	 * @param date
	 * @return
	 */
	@RequestMapping("/lastLotterDatas")
	public List<LotterRecord> listAllLotterData(@RequestParam(required = false, defaultValue = "300") int amount) {
		List<LotterRecord> list = new ArrayList<LotterRecord>();
		LotterRecord obj = new LotterRecord();
		obj.setLotterNo("wwerwer");
		obj.setLotterResult("werwer");
		obj.setLotterDate("234");
		
		list.add(obj);
		
		return list;
	}
}
