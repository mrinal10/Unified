package com.firecompass.lottery.util;

public class ProjectUtil {
	public static final String COMPLETED = "DONE";
	public static final String NOT_COMPLETED = "NAN";
	
	public static Integer getRandomvalue(int limit) {
		return ((int) Math.round(Math.random()*limit))-1;
	}
}
