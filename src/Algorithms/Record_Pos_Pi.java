package Algorithms;

import Data_Setup.Position;

public class Record_Pos_Pi {

	double pi;
	Position p;
	
	public Record_Pos_Pi()
	{
		this.pi = 1;
		this.p = new Position();
	}
	
	public Record_Pos_Pi(double pi, Position p)
	{
		this.pi = pi;
		this.p = p;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = this.pi*pi;
	}

	public Position getP() {
		return p;
	}

	public void setP(Position p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return pi + "," + p;
	}
	
	
	
}
