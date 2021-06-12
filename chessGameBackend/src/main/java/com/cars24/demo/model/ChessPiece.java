package com.cars24.demo.model;

import com.cars24.demo.utilenum.ChessPieceEnum;
import com.cars24.demo.utilenum.PieceColour;

public class ChessPiece {
	
	private ChessPieceEnum type;
	private PieceColour colour;
	private int serialNumber;
	
	
	public ChessPieceEnum getType() {
		return type;
	}
	public PieceColour getColour() {
		return colour;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setType(ChessPieceEnum type) {
		this.type = type;
	}
	public void setColour(PieceColour colour) {
		this.colour = colour;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
}
