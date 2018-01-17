package Algorithms;

/**
 * Tools to Algorithm 1 and Algorithm 2.
 *
 */
public class Algorithm_Tools {

	double weightsum,wlatsum,wlonsum,waltsum,weight;
	
	double sig, diff, w, pi;
	
	/**
	 * Empty constructor.
	 */
	public Algorithm_Tools() {
		this.weight = 0;
		this.weightsum = 0;
		this.wlatsum = 0;
		this.wlonsum = 0;
		this.waltsum = 0;
		this.sig = 0;
		this.diff = 0;
		this.w = 0;
		this.pi = 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * 
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight =weight;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getWeightsum() {
		return weightsum;
	}

	/**
	 * 
	 * @param weightsum
	 */
	public void setWeightsum(double weightsum) {
		this.weightsum =this.weightsum+weightsum;
	}

	/**
	 * 
	 * @return
	 */
	public double getWlatsum() {
		return wlatsum;
	}

	/**
	 * 
	 * @param w
	 */
	public void setWlatsum(double w) {
		wlatsum = wlatsum+w;
	}

	/**
	 * 
	 * @return
	 */
	public double getWlonsum() {
		return wlonsum;
	}

	/**
	 * 
	 * @param wlonsum
	 */
	public void setWlonsum(double wlonsum) {
		this.wlonsum = this.wlonsum+wlonsum;
	}

	/**
	 * 
	 * @return
	 */
	public double getWaltsum() {
		return waltsum;
	}

	/**
	 * 
	 * @param waltsum
	 */
	public void setWaltsum(double waltsum) {
		this.waltsum = this.waltsum+waltsum;
	}

	/**
	 * 
	 * @return
	 */
	public double getSig() {
		return sig;
	}

	/**
	 * 
	 * @param sig
	 */
	public void setSig(double sig) {
		this.sig = sig;
	}

	/**
	 * 
	 * @return
	 */
	public double getDiff() {
		return diff;
	}

	/**
	 * 
	 * @param diff
	 */
	public void setDiff(double diff) {
		this.diff = diff;
	}

	/**
	 * 
	 * @return
	 */
	public double getW() {
		return w;
	}

	/**
	 * 
	 * @param w
	 */
	public void setW(double w) {
		this.w = w;
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
		this.pi = pi;
	}
	
}
