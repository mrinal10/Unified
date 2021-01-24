package com.cars24.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cars24.demo.model.ResponseData;

@Service
public class FundService {
	

	public List<ResponseData> getFundData(String fundId, String horizon, String periodOfInvestement) {
		return null;
	}

	private List<ResponseData> calculateReturns(Map<String, String> mapdata, String horizon, String periodOfInvestement) {
		if (Integer.parseInt(periodOfInvestement) <= 0 || Integer.parseInt(horizon) <= 0) {
			return null;
		}
		String startDate = getPrevDate(getCurrentDate());

		Integer endYear = Integer.parseInt(startDate.substring(6, 10));

		Integer startYear = endYear - Integer.parseInt(horizon);
		Integer startDay = Integer.parseInt(startDate.substring(0, 2));
		Integer startMonth = Integer.parseInt(startDate.substring(3, 5));

		Integer endDay = startDay;
		Integer endMonth = startMonth;

		int month = startMonth+1;
		int year = startYear;
		List<ResponseData> responseList = new ArrayList<ResponseData>();
		
		while (year <= endYear) {
			ResponseData responseData = new ResponseData();
			String sDate = startDay + "-" + month + "-" + year;
			String eDate = endDay + "-" + month + "-" + (year - Integer.parseInt(periodOfInvestement));
			if (month < 10) {
				sDate = startDay + "-0" + month + "-" + year;
				eDate = endDay + "-0" + month + "-" + (year - Integer.parseInt(periodOfInvestement));
			}

			String endNav = getNav(mapdata, eDate);
			String startNav = getNav(mapdata, sDate);
			
			String returnPercentage = calculateReturn(Float.parseFloat(startNav), Float.parseFloat(endNav),
					Integer.parseInt(horizon));
			responseData.setMonth(month+"-"+year);
			responseData.setCalculation("from:"+eDate+ ", to:"+sDate);
			responseData.setReturnPercentage(returnPercentage);
			responseList.add(responseData);
			month += 1;
			if (month > 12) {
				month = 1;
				year++;
			}
			if(year>=endYear && month>endMonth) {
				break;
			}
		}

		return responseList;
	}

	private String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	private String calculateReturn(float startNav, float endNav, int years) {
		float flt = (startNav / endNav);
		float pw = 1.000F / ((float) years);
		float d = (float) (Math.pow(flt, pw)) - 1;
		d *= 100;
		String ret = String.valueOf(d);
		ret += "000";
		ret = ret.substring(0, ret.indexOf(".") + 3);
		return ret;
	}

	private String getNav(Map<String, String> mapdata, String date) {
		if (mapdata.containsKey(date)) {
			return mapdata.get(date);
		}
		int tries = 30;
		while (tries-- > 0) {
			date = getNextDate(date);
			if (mapdata.containsKey(date)) {
				return mapdata.get(date);
			}
		}
		return "0.0";
	}

	private String getNextDate(String curDate) {
		final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = format.parse(curDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return format.format(calendar.getTime());
	}
	
	private String getPrevDate(String curDate) {
		final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = format.parse(curDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return format.format(calendar.getTime());
	}
}