import java.nio.charset.Charset;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

import com.pragma_sc.*;
import com.pragma_sc.cool.activiti.formTypes.JsonFormType;
import com.pragma_sc.cool.activiti.tasks.callREST;
import com.pragma_sc.cool.bridge.serializer;
import com.pragma_sc.*;

import org.apache.commons.io.*;
import org.apache.commons.codec.binary.Base64;

public class test {
	
	public static void main(String[] args) throws Exception {
		
		serializer franco = new serializer();
		Object o = franco.deserializeBase64String("rO0ABXNyABdqYXZhLnV0aWwuTGlua2VkSGFzaE1hcDTATlwQbMD7AgABWgALYWNjZXNzT3JkZXJ4cgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwgAAAAQAAAADHQAE2Rvc3NpZXJfdXNlcl9yZWZfaWRzcgARamF2YS5sYW5nLkludGVnZXIS4qCk94GHOAIAAUkABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhwAAjHHHQACmRvc3NpZXJfaWRzcQB+AAQAACDldAAHdXNlcl9pZHNxAH4ABAAAT810AAh2YWxpZGl0eXQAAygsKXQAFWRvc3NpZXJfYXNzaWdubWVudF9pZHB0AApsb2dpbl9uYW1ldAARaW9udXQuYWJiYXRpY2NoaW90AApmaXJzdF9uYW1ldAAFSW9udXR0AAlsYXN0X25hbWV0AAtBYmJhdGljY2hpb3QABWVtYWlsdAAbaW9udXQuYWJiYXRpY2NoaW9AZW1haWwuY29tdAAJdGVsZXBob25lcHQABm1vYmlsZXB0AAR0eXBldAACdGx4AA==");
		
		System.out.println(franco.toJSON(o));
	}
	
}