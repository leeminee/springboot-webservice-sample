package com.wendy.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @SpringBootApplication
   : 스프링부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정.
   : 이 어노케이션이 있는 위치부터 설정을 읽기때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야함.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /* SpringApplication.run()
           : 내장 WAS(Web Application Server)를 실행
           내장 WAS란 ? 별도로 외부에 WAS를 두지않고 애플리케이션을 실행할때 내부에서 WAS를 실행하는것.
           이렇게하면 항상 서버에 톰캣을 설치할 필요가없고, 스프링 부트로 만들어진 JAR파일로 실행하면됨.
           내장 WAS사용 권장이유
           : 언제 어디서나 같은 환경에서 스프링 부트를 배포 가능
         */
        SpringApplication.run(Application.class, args);
    }
}
