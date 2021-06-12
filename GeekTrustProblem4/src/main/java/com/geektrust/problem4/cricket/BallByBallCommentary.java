package com.geektrust.problem4.cricket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BallByBallCommentary {
	private List<String> perBallCommentary = new ArrayList<String>();

	public List<String> getPerBallCommentary() {
		return perBallCommentary;
	}
	
	public void addCommentary(String ballWiseCommentary) {
		perBallCommentary.add(ballWiseCommentary);
	}
}
