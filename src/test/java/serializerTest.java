import static org.junit.Assert.*;

import org.junit.Test;

import com.eulogix.cool.bridge.serializer;


public class serializerTest {

	@Test
	public void test() {
		serializer s = new serializer();
		Object o = s.deserializeBase64String("rO0ABXNyABdqYXZhLnV0aWwuTGlua2VkSGFzaE1hcDTATlwQbMD7AgABWgALYWNjZXNzT3JkZXJ4cgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwgAAAAQAAAABXQACHVzZXJuYW1ldAAFYWRtaW50AAhwYXNzd29yZHQAD0FkbWluaXN0cmF0b3I0MHQAB3NjaGVtYXNzcQB+AAA/QAAAAAAADHcIAAAAEAAAAAN0AARjb3Jlc3EAfgAAP0AAAAAAAAx3CAAAABAAAAAEdAAOY3VycmVudF9zY2hlbWF0AARjb3JldAAMYXVkaXRfc2NoZW1hdAAKY29yZV9hdWRpdHQAB2luc3RhbnRwdAAEbmFtZXQABGNvcmV4AHQABGhhbXNzcQB+AAA/QAAAAAAADHcIAAAAEAAAAARxAH4AC3QADGhhbXNfZXNfdGVzdHEAfgANdAASaGFtc19lc190ZXN0X2F1ZGl0cQB+AA9wcQB+ABB0AARoYW1zeAB0AAtoYW1zX3NoYXJlZHNxAH4AAD9AAAAAAAAMdwgAAAAQAAAABHEAfgALdAALaGFtc19zaGFyZWRxAH4ADXQAEWhhbXNfc2hhcmVkX2F1ZGl0cQB+AA9wcQB+ABB0AAtoYW1zX3NoYXJlZHgAeAB0AAtsb2dnZWRfdXNlcnNxAH4AAD9AAAAAAAAYdwgAAAAgAAAADXQACmFjY291bnRfaWRzcgARamF2YS5sYW5nLkludGVnZXIS4qCk94GHOAIAAUkABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhwAAADY3QACmxvZ2luX25hbWV0AAl0Z29uemFsZXp0AAR0eXBlcHQACmZpcnN0X25hbWV0AA9UYWJhdGEgR29uemFsZXp0AAlsYXN0X25hbWVwdAADc2V4cHQABWVtYWlsdAAVdGdvbnphbGV6QGhpcG9nZXMuY29tdAAJdGVsZXBob25ldAAEMjE0NnQABm1vYmlsZXB0AA5kZWZhdWx0X2xvY2FsZXB0AAxjb21wYW55X25hbWVwdAAIdmFsaWRpdHlwdAAFcm9sZXN0ABB7Uk9MRV9IQU1TX1VTRVJ9eAB0AAhiYXNlX3VybHQAEWh0dHA6Ly9oYW1zLmRldmVseAA=");
		assertTrue(true);
	}

}
