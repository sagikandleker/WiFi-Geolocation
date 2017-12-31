package Data_Setup;

import java.util.ArrayList;
import java.util.Date;


/**
 *  Record combined date, position, wifi list.
 * also have id number and amount of wifi networks in the list.
 */

public class Record {

	private Time date;
	private Position position;
	private ArrayList<Wifi> WifiList;
	private int wifinetworks;
	private ID id;
	
	/**
	 * @param id
	 * @param time
	 * @param position
	 */
	public Record(Time date, Position position) {
		this.date = date;
		this.position = position;
		this.WifiList = new ArrayList<Wifi>();
	}
	
	/**
	 *  addWifi add Wifi to the list.
	 */
	public void addWifi(Wifi wifi){
		WifiList.add(wifi);
	}
	
	/**
	 * 
	 * @param wl
	 * 
	 */
	public void mergeWifiList(ArrayList<Wifi> wl)
	{
		
		for (int i = 0; i < wl.size(); i++)
		{
			
			this.WifiList.add(wl.get(i));
			sort_Signal_Power();
			if(this.WifiList.size() == 11)
			{
				this.WifiList.remove(10);
			}
		}
	}
	
	/**
	 *  sort_Signal_Power sorting the list from the stronger signal to the lower.
	 */
	public void sort_Signal_Power()
	{
		
		for (int i = 0; i < this.WifiList.size(); i++)
		{
			for (int j = 0; j < this.WifiList.size(); j++)
			{
				if(this.WifiList.get(i).getSignal() > this.WifiList.get(j).getSignal())
				{
				
					Wifi temp;
					temp = this.WifiList.get(i);
					this.WifiList.set(i, this.WifiList.get(j));
					this.WifiList.set(j, temp);
				}
			}
		}
	}
	

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date.getTime();
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Time date) {
		this.date = date;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the wifiList
	 */
	public ArrayList<Wifi> getWifiList() {
		return WifiList;
	}

	/**
	 * @param wifiList the wifiList to set
	 */
	public void setWifiList(ArrayList<Wifi> wifiList) {
		WifiList = wifiList;
	}

	/**
	 * compare check if position and time in 2 records are equals.
	 */
	public boolean compare(Record sk)
	{
		if((this.date.compare(sk.date)==true) && (this.position.compare(sk.position)==true))
		{
			return true;
		}
		return false;
	}

	public int getWifinetworks() {
		return wifinetworks;
	}

	public void setWifinetworks(int wifinetworks) {
		this.wifinetworks = wifinetworks;
	}
	
	public String getid() {
		return id.getID();
	}

	public void setid(ID id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return date + "," + id + "," + position + "," + wifinetworks + "," + WifiList ;
	}
	
}
