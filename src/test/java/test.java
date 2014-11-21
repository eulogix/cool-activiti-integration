import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

import com.pragma_sc.*;
import com.pragma_sc.cool.activiti.formTypes.JsonFormType;
import com.pragma_sc.cool.activiti.tasks.callREST;

public class test {
	
	public static void main(String[] args) {
		JsonFormType luigi = new JsonFormType();
		Object desert = luigi.convertFormValueToModelValue("{\"gianni\":\"dsds\", \"ppippo\":[1,2,3,34,\"ds\"]}");
		String asert = luigi.convertModelValueToFormValue(desert);
		
		System.out.println(desert);
		System.out.println(asert);
	}
	
}