package hessian.test.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComplexData implements Serializable{

	private static final long serialVersionUID = 1L;

	private ArrayList<HelloBean> helloBeans;
	
	//private Map<String, HelloBean> helloBeanMap;
	
	private int number;
	
	public int getNumber(){
		return number;
	}
	
	public ArrayList<HelloBean> getHelloBeans(){
		return helloBeans;
	}
	
	public void setData(ArrayList<HelloBean> beans, int num){
		this.number = num;
		this.helloBeans = beans;
//		helloBeanMap = new HashMap<String, HelloBean>();
//		for (HelloBean helloBean : beans) {
//			if(!helloBeanMap.containsKey(helloBean.getName()))
//			{
//				helloBeanMap.put(helloBean.getName(), helloBean);
//			}
//		}
	}
}
