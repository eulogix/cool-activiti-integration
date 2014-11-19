import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

import com.pragma_sc.*;
import com.pragma_sc.cool.activiti.tasks.callREST;

public class test {
	
	public static void main(String[] args) {
		callREST r = new callREST();
		String result = r.callService("http://www.google.it", "");
		System.out.println(result);
	}
	
}