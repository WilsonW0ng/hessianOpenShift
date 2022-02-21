package hessian.test.server;

import java.util.ArrayList;

public class HelloImpl implements IHello{
	
	public String sayHello(String msg){
		return "Hello " + msg;
	}
    
	public void sayHello2(int bean){
		System.out.println("Hello " + bean);
	}
	
	public void print(String msg){
		System.out.println(msg);
	}
    
	public HelloBean getData(HelloBean bean){
		HelloBean result = new HelloBean();
        result.setName("lu xiaoxun a new name");
        result.setAge(26);
        
        System.out.print(bean.getName());
        return result;
	}
	
	public ArrayList<HelloBean> getBeanList(){
		ArrayList<HelloBean> beans = new ArrayList<HelloBean>();
		
		HelloBean b1 = new HelloBean();
		b1.setName("lu1");
		b1.setAge(26);
		beans.add(b1);
		
		HelloBean b2 = new HelloBean();
		b2.setName("lu2");
		b2.setAge(27);
		beans.add(b2);
		
		return beans;
	}
	
	public ComplexData getComplexData(){
		ComplexData data = new ComplexData();
		ArrayList<HelloBean> beans = getBeanList();
		data.setData(beans, beans.size());
		
		return data;
	}
}
