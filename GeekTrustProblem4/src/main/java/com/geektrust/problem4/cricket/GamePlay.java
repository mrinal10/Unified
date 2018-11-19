package com.geektrust.problem4.cricket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.geektrust.problem4.bean.BatsMan;
import com.geektrust.problem4.bean.Match;

@Component
@Repository
@Scope("request")
public class GamePlay {
	@Value("${battingTeam}")
	private String teamBatting;
	@Value("${ballingTeam}")
	private String teamBalling;
	@Value("${runsRequired}")
	private int targetRun;
	@Value("${wicketRemaining}")
	private int wicketsRemaining;
	@Value("${ballRemaining}")
	private int ballsRemaining;
	

	private String draW = "draw";

	@Autowired 
	Match match;

	@Autowired 
	Match match1stHalf;

	@Autowired 
	Match match2ndHalf;

	/**
	 * @return void
	 * @param none
	 *            this method exceutes each match
	 */
	private void init(Match match, String teamBalling, String teamBatting,int ballsRemaining, 
			int targetRun, int wicketsRemaining){
		match.setBallingTeam(teamBalling);
		match.setBattingTeam(teamBatting);
		match.setBallsRemaining(ballsRemaining);
		match.setTargetRun(targetRun);
		match.setWicketRemaining(wicketsRemaining);
		match.setBallCount(0);
		match.setLastBatsManCameToGround(1);
	}
	
	private String printCommentary(Match match){
		StringBuilder scoreCard = new StringBuilder("");
		for (int i = 0; i < match.getBallByBallCommentary().getPerBallCommentary().size(); i++) {
			scoreCard.append(match.getBallByBallCommentary().getPerBallCommentary().get(i)+"\r\n");
		}
		return scoreCard.toString();
	}
	
	private String printScoreCard(Match match) {
		StringBuilder scoreCard = new StringBuilder("");
		for (int i = 0; i < match.getBattingLineUp().getPlayerList().size(); i++) {
			BatsMan batsman = match.getBattingLineUp().getPlayerList().get(i);
			if(!batsman.isBatted()){
				scoreCard.append(batsman.getPlayerName() + " - DNB"+"\r\n");
			}else if(!batsman.isOut()){
				scoreCard.append(batsman.getPlayerName() + " - " + batsman.getRunsScored()+"* ("
					+ batsman.getNoOfBallsFaced() + " balls)"+"\r\n");
			}else{
				scoreCard.append(batsman.getPlayerName() + " - " + batsman.getRunsScored() + " ("
						+ batsman.getNoOfBallsFaced() + " balls)"+"\r\n");
			}
		}
		return scoreCard.toString();
	}
	
	private String printMatchResult(Match match){
		return(match.getMatchConclusionSingleLiner()+"\r\n");
	}
	
	public String playGame() {
		StringBuilder fullCommentary = new StringBuilder("");
		init(match, teamBalling, teamBatting, ballsRemaining, targetRun, wicketsRemaining);
		match.executeGame();
		fullCommentary.append(teamBatting+" requires "+targetRun+" runs in "+ballsRemaining+" balls, "+wicketsRemaining+" wickets in hand \n");
		fullCommentary.append("\n");
		fullCommentary.append(printCommentary(match)+"\n");
		fullCommentary.append(printScoreCard(match)+"\n");
		fullCommentary.append(printMatchResult(match)+"\n");
		if(match.getTotalRunScored() == targetRun){ // that means its a draw
			init(match1stHalf, draW+teamBalling, draW+teamBatting, 6, Integer.MAX_VALUE, 1);
			match1stHalf.executeGame();
			fullCommentary.append(printCommentary(match1stHalf)+"\n");
			int runScoredinfirstHalf = match1stHalf.getTotalRunScored();
			init(match2ndHalf, draW+teamBatting, draW+teamBalling, 6, runScoredinfirstHalf, 1);
			match2ndHalf.executeGame();
			fullCommentary.append(printCommentary(match2ndHalf)+"\n");
			fullCommentary.append(printScoreCard(match1stHalf)+"\n");
			fullCommentary.append(printScoreCard(match2ndHalf)+"\n");
			fullCommentary.append(printMatchResult(match2ndHalf)+"\n");
		}
		return fullCommentary.toString();
	}
}
