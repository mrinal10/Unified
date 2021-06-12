package com.cars24.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.cars24.demo.utilenum.ChessPieceEnum;
import com.cars24.demo.utilenum.PieceColour;


public class ChessBoard {
	@Autowired
	private Environment env;
	
	private String boardId;
	private List<String> alphabets;
	private List<ChessBox> wholeBoard;

	public ChessBoard() {
		alphabets = new ArrayList<String>();
		alphabets.add("A");
		alphabets.add("B");
		alphabets.add("C");
		alphabets.add("D");
		alphabets.add("E");
		alphabets.add("F");
		alphabets.add("G");
		alphabets.add("H");

		for (int i = 0; i < alphabets.size(); i++) {
			ChessBox chessBox = new ChessBox();
			for (int j = 1; j <= 8; j++) {
				String boxId = alphabets.get(i) + j;
				chessBox.setBoxId(boxId);
				chessBox.setPiece(getPiece(boxId));
				wholeBoard.add(chessBox);
			}
		}
	}

	public String getBoardId() {
		return boardId;
	}

	public List<String> getAlphabets() {
		return alphabets;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public void setAlphabets(List<String> alphabets) {
		this.alphabets = alphabets;
	}

	private ChessPiece getPiece(String boxId) {
		String configId = "config." + boxId;
		ChessPiece chessPiece = new ChessPiece();
		chessPiece.setSerialNumber(Integer.parseInt(env.getProperty(configId + ".srNo")));
		chessPiece.setColour(PieceColour.valueOf(env.getProperty(configId + ".colour")));
		chessPiece.setType(ChessPieceEnum.valueOf(env.getProperty(configId + ".piece")));
		return chessPiece;
	}

	public List<ChessBox> getWholeBoard() {
		return wholeBoard;
	}

	public void setWholeBoard(List<ChessBox> wholeBoard) {
		this.wholeBoard = wholeBoard;
	}
}
