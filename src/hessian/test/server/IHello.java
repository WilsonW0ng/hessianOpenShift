package hessian.test.server;

import java.util.ArrayList;

public interface IHello {

	String sayHello(String msg);   
    
	void sayHello2(int bean);
	
	void print(String msg);  
    
	HelloBean getData(HelloBean bean);
	
	ArrayList<HelloBean> getBeanList();
	
	ComplexData getComplexData();
    
}
