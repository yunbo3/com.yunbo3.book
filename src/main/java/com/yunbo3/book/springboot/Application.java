package com.yunbo3.book.springboot;

import com.yunbo3.book.springboot.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication//스프링 부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정, @SpringBootApplicatino이 있는 위치부터 설정을 읽어가기떄문에 이 클래스는 항상 프로젝트의 최상단에 위치해야한다.
@Import(SecurityConfig.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
