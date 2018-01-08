package Filtering;

public class ChooseBetweenFilter {

	private Position_Filter p_f;
	private ID_Filter i_f;
	private Time_Filter t_f;
	
	public ChooseBetweenFilter(Position_Filter p_f,ID_Filter i_f,Time_Filter t_f)
	{
		this.p_f=p_f;
		this.i_f=i_f;
		this.t_f=t_f;
	}
	
	public void or(Position_Filter p_f,ID_Filter i_f,Time_Filter t_f)
	{
		
	}
}
