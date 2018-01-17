package Algorithms;

import Data_Setup.Position;

/**
 * Record Position and Pi
 *
 */
public class Record_Pos_Pi {

	double pi;
	Position p;
	
	/**
	 * Empty constructor.
	 */
	public Record_Pos_Pi()
	{
		this.pi = 1;
		this.p = new Position();
	}
	
	/**
	 * 
	 * @param p
	 * @param pi
	 */
	public Record_Pos_Pi(Position p, double pi)
	{
		this.pi = pi;
		this.p = p;
	}

	/**
	 * 
	 * @return
	 */
	public double getPi() {
		return pi;
	}

	/**
	 * 
	 * @param pi
	 */
	public void setPi(double pi) {
		this.pi = this.pi*pi;
	}

	/**
	 * 
	 * @return
	 */
	public Position getP() {
		return p;
	}

	/**
	 * 
	 * @param p
	 */
	public void setP(Position p) {
		this.p = p;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return pi + "," + p;
	}
	
}
