package Algorithms;

public class Algorithm_Data {

	double weightsum,wlatsum,wlonsum,waltsum,weight;

	public Algorithm_Data() {
		this.weight = 0;
		this.weightsum = 0;
		this.wlatsum = 0;
		this.wlonsum = 0;
		this.waltsum = 0;
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
}
