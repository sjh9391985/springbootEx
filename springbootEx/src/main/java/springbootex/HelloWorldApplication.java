package springbootex;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*  
 * Bootstrap Class
 * 1. 스프링 부트 애플리케이션 Bootstrapping (준비작업)
 * 2. 설정 클래스 역할( Configuration Class )
 */

/*
 * @SpringBootApplication 
 * == (@SpringBootConfiguration(alias for @Configuration) + @ComponentScan + @EnableAutoConfiguration) <-- 원래 붙이는 것.(메타 anotaion)
 * --> 결론은 @SpringBootApplication 만 붙이면 된다.
 */
@SpringBootApplication(scanBasePackages = {})
public class HelloWorldApplication {
	@Bean
	public ApplicationRunner applicationRunner() {
		// 1. 작성된 구현 클래스를 사용
		//return new HelloWorldRunner();
		
		// 2. Anonymouse class 사용
		//	return new ApplicationRunner() {
		//		public void run(ApplicationArguments args) throws Exception {	
		//		System.out.println("Hello World");
		//		}
		//};
		
		// 3. 함수형(람다 표현식)
		return (ApplicationArguments args) -> {	
			System.out.println("Hello World!");
	};
}

	public static void main(String[] args) {
		/*
		 * 1. Application Context(container) 생성
		 * 2. Application type 결정 (Web App 경우만 해당 - Servlet, Reactive)
		 * 3. anotation scanning을 통한 빈 생성 및 등록작업
		 * 4. Web Application의 경우 (WEB)
		 *    - 내장서버(embedded) 서버(TomcatEmbeddedServletContainer) 인스턴스 생성
		 * 	  - 서버 인스턴스에 웹 어플리케이션을 배포
		 *    - 서버 인스턴스 실행
		 * 5. 인터페이스 ApplicationRunner 구현 빈의 run() 실행   
		 */
		SpringApplication.run(HelloWorldApplication.class, args);
						//-> 여기서 작업을 한다.
	}

}
