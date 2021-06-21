package springbootex;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class HelloWorldRunner implements ApplicationRunner {

	public void run(ApplicationArguments args) throws Exception {
		System.out.println("hello world");

	}

}
