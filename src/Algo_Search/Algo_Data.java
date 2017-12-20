package Algo_Search;

public class Algo_Data {

	double weight1,
	weight2,weight3,weightsum,
	wlat1,wlat2,wlat3,wlatsum,
	wlon1,wlon2,wlon3,wlonsum,
	walt1,walt2,walt3,waltsum;


	public Algo_Data() {

		this.weight1 = 0;
		this.weight2 = 0;
		this.weight3 = 0;
		this.weightsum = 0;
		this.wlat1 = 0;
		this.wlat2 = 0;
		this.wlat3 = 0;
		this.wlatsum = 0;
		this.wlon1 = 0;
		this.wlon2 = 0;
		this.wlon3 = 0;
		this.wlonsum = 0;
		this.walt1 = 0;
		this.walt2 = 0;
		this.walt3 = 0;
		this.waltsum = 0;

	}


	public double getWeight1() {
		return weight1;
	}


	public void setWeight1(double weight) {
		this.weight1 = weight;
	}


	public double getWeight2() {
		return weight2;
	}


	public void setWeight2(double weight2) {
		this.weight2 = weight2;
	}


	public double getWeight3() {
		return weight3;
	}


	public void setWeight3(double weight3) {
		this.weight3 = weight3;
	}


	public double getWeightsum() {
		return weightsum;
	}


	public void setWeightsum() {
		this.weightsum = weight1+weight2+weight3;
	}


	public double getWlat1() {
		return wlat1;
	}


	public void setWlat1(double wlat1) {
		this.wlat1 = wlat1;
	}


	public double getWlat2() {
		return wlat2;
	}


	public void setWlat2(double wlat2) {
		this.wlat2 = wlat2;
	}


	public double getWlat3() {
		return wlat3;
	}


	public void setWlat3(double wlat3) {
		this.wlat3 = wlat3;
	}


	public double getWlatsum() {
		return wlatsum;
	}


	public void setWlatsum() {
		this.wlatsum = wlat1+wlat2+wlat3;
	}


	public double getWlon1() {
		return wlon1;
	}


	public void setWlon1(double wlon1) {
		this.wlon1 = wlon1;
	}


	public double getWlon2() {
		return wlon2;
	}


	public void setWlon2(double wlon2) {
		this.wlon2 = wlon2;
	}


	public double getWlon3() {
		return wlon3;
	}


	public void setWlon3(double wlon3) {
		this.wlon3 = wlon3;
	}


	public double getWlonsum() {
		return wlonsum;
	}


	public void setWlonsum() {
		this.wlonsum = wlon1+wlon2+wlon3;
	}


	public double getWalt1() {
		return walt1;
	}


	public void setWalt1(double walt1) {
		this.walt1 = walt1;
	}


	public double getWalt2() {
		return walt2;
	}


	public void setWalt2(double walt2) {
		this.walt2 = walt2;
	}


	public double getWalt3() {
		return walt3;
	}


	public void setWalt3(double walt3) {
		this.walt3 = walt3;
	}


	public double getWaltsum() {
		return waltsum;
	}


	public void setWaltsum() {
		this.waltsum = walt1+walt2+walt3;
	}
}
