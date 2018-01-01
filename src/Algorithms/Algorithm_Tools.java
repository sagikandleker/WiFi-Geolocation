package Algorithms;

public class Algorithm_Tools {

	double weightsum,wlatsum,wlonsum,waltsum,weight;
	
	double sig, diff, w, pi;
	
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
	

	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight =weight;
	}
	
	public double getWeightsum() {
		return weightsum;
	}


	public void setWeightsum(double weightsum) {
		this.weightsum =this.weightsum+weightsum;
	}

	public double getWlatsum() {
		return wlatsum;
	}


	public void setWlatsum(double w) {
		wlatsum = wlatsum+w;
	}


	public double getWlonsum() {
		return wlonsum;
	}


	public void setWlonsum(double wlonsum) {
		this.wlonsum = this.wlonsum+wlonsum;
	}


	public double getWaltsum() {
		return waltsum;
	}


	public void setWaltsum(double waltsum) {
		this.waltsum = this.waltsum+waltsum;
	}

	public double getSig() {
		return sig;
	}

	public void setSig(double sig) {
		this.sig = sig;
	}

	public double getDiff() {
		return diff;
	}

	public void setDiff(double diff) {
		this.diff = diff;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
	}
	
}
