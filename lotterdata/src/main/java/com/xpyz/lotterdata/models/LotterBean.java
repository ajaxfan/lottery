package com.xpyz.lotterdata.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "lotter_reocrd")
public class LotterBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** 期号 */
	private String lotterNo;
	/** 结果 */
	private String lotterResult;
	/** 日期 */
	private String lotterDate;

	public String getLotterNo() {
		return lotterNo;
	}

	public void setLotterNo(String lotterNo) {
		this.lotterNo = lotterNo;
	}

	public String getLotterResult() {
		return lotterResult;
	}

	public void setLotterResult(String lotterResult) {
		this.lotterResult = lotterResult;
	}

	public String getLotterDate() {
		return lotterDate;
	}

	public void setLotterDate(String lotterDate) {
		this.lotterDate = lotterDate;
	}
}
