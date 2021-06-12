package com.geektrust.problem4.cricket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geektrust.problem4.Problem4GeekTApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Problem4GeekTApplication.class)
public class GamePlayTest {
	
	GamePlay gamePlay = new GamePlay();
	
	@Test
	public void playGameTest(){
		System.out.println();
		System.out.println(gamePlay.playGame());
	}
}
