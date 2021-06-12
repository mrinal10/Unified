package com.geektrust.problem4.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.geektrust.problem4.cricket.BallByBallCommentary;
import com.geektrust.problem4.cricket.Lineup;

@Component
@Scope("prototype")
public class Match {
	private String battingTeam;
	private String ballingTeam;
	private int targetRun;
	private int wicketsRemaining;
	private int ballsRemaining;
	private int totalRunScored;
	private String matchConclusionSingleLiner;
	private int strikerIndex = 0;
	private int nonStrikerIndex = 1;
	private int ballCount = 0;
	private int overCount = 0;
	private int curRun = 0;
	private int lastBatsManCameToGround = 1;

	@Autowired
	private Lineup battingLineUp;
	@Autowired
	private Scorecard scoreCard;
	@Autowired
	private BallByBallCommentary ballByBallCommentary;

	/**
	 * 
	 */
	public void executeGame() {
		wicketsRemaining++;
		battingLineUp.init(battingTeam);
		
		BatsMan striker;
		while ((curRun <= targetRun) && (ballCount < ballsRemaining) 
				&& (lastBatsManCameToGround < wicketsRemaining)) {
			
			striker = battingLineUp.getPlayerList().get(strikerIndex);
			ballCount++;
			int radomNum = (int) (Math.random() * 100);

			striker.setOut(false);
			striker.setBatted(true);
			int runScoredAtthisBall = striker.getListOfOutComes().get(radomNum);

			String playerName = striker.getPlayerName();
			int nthBall = (ballCount % 6);
			nthBall = (nthBall == 0) ? 6 : nthBall;
			int ballFacedTillNow = striker.getNoOfBallsFaced();
			striker.setNoOfBallsFaced(ballFacedTillNow + 1);
			if (runScoredAtthisBall == -1) {
				populateCommentary(overCount + "." + nthBall + " " + playerName + " is OUT");
				striker.setOut(true);
				lastBatsManCameToGround++;
				strikerIndex = lastBatsManCameToGround;
			} else {
				populateCommentary(
						overCount + "." + nthBall + " " + playerName + " scores " + runScoredAtthisBall + " run");
				if ((runScoredAtthisBall % 2) == 1) {
					swapPlayers(striker);
				}
				int strikerScore = striker.getRunsScored();
				strikerScore += runScoredAtthisBall;
				striker.setRunsScored(strikerScore);
				curRun += runScoredAtthisBall;
			}
			if (ballCount % 6 == 0) { // swap Striker-non striker after each
				populateCommentary("\n");			// over
				swapPlayers(striker);
				overCount++;
			}
		}
		totalRunScored = curRun;
		if (ballingTeam.startsWith("draw") && battingTeam.startsWith("draw")) {
			ballingTeam = ballingTeam.substring(4);
			battingTeam = battingTeam.substring(4);
		}
		if (curRun < targetRun) {
			matchConclusionSingleLiner = ballingTeam + " won by " + (targetRun - curRun) + " runs";
		} else if (curRun > targetRun) {
			matchConclusionSingleLiner = battingTeam + " won by " + (wicketsRemaining - lastBatsManCameToGround) + " wickets";
		} else {
			matchConclusionSingleLiner = "<<< Its a Draw >>";
		}
	}

	private void swapPlayers(BatsMan striker) {
		strikerIndex = strikerIndex + nonStrikerIndex;
		nonStrikerIndex = strikerIndex - nonStrikerIndex;
		strikerIndex = strikerIndex - nonStrikerIndex;
		striker = battingLineUp.getPlayerList().get(strikerIndex);
	}

	public Scorecard getScoreCard() {
		return scoreCard;
	}

	public String getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}

	public String getBallingTeam() {
		return ballingTeam;
	}

	public void setBallingTeam(String ballingTeam) {
		this.ballingTeam = ballingTeam;
	}

	public int getTargetRun() {
		return targetRun;
	}

	public void setTargetRun(int targetRun) {
		this.targetRun = targetRun;
	}

	public int getWicketRemaining() {
		return wicketsRemaining;
	}

	public void setWicketRemaining(int wicketRemaining) {
		this.wicketsRemaining = wicketRemaining;
	}

	public int getBallsRemaining() {
		return ballsRemaining;
	}

	public void setBallsRemaining(int ballsRemaining) {
		this.ballsRemaining = ballsRemaining;
	}

	private void populateCommentary(String s){
		ballByBallCommentary.addCommentary(s);
	}

	public int getTotalRunScored() {
		return totalRunScored;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}

	public int getLastBatsManCameToGround() {
		return lastBatsManCameToGround;
	}

	public void setLastBatsManCameToGround(int lastBatsManCameToGround) {
		this.lastBatsManCameToGround = lastBatsManCameToGround;
	}

	public String getMatchConclusionSingleLiner() {
		return matchConclusionSingleLiner;
	}

	public void setMatchConclusionSingleLiner(String matchConclusionSingleLiner) {
		this.matchConclusionSingleLiner = matchConclusionSingleLiner;
	}

	public BallByBallCommentary getBallByBallCommentary() {
		return ballByBallCommentary;
	}

	public void setBallByBallCommentary(BallByBallCommentary ballByBallCommentary) {
		this.ballByBallCommentary = ballByBallCommentary;
	}

	public Lineup getBattingLineUp() {
		return battingLineUp;
	}

	public void setBattingLineUp(Lineup battingLineUp) {
		this.battingLineUp = battingLineUp;
	}

	public void setScoreCard(Scorecard scoreCard) {
		this.scoreCard = scoreCard;
	}

}
