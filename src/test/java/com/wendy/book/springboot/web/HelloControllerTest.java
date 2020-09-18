package com.wendy.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

/* @RunWith : 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자(SpringRunner)를 실행
            : 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함.
   @WebMvcTest : 여러 스프링 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션
               : @Controller, @ControllerAdvice 등을 사용할 수 있다.
               : @Service, @Component, @Repository 등은 사용할 수 없다.
   @Autowired : 스프링이 관리하는 빈(Bean)을 주입 받는다.
   private MockMvc mvc : 웹 API를  테스트할 때 사용
                       : 스프링 MVC 테스트의 시작점.
                       : 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트 가능
   mvc.perform(get("/hello")) : MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함.
                              : 체이닝이 지원되어 여러 검증기능을 이어서 선언가능.
   .andExpect(status().isOk()) : mvc.perform의 결과를 검증
                               : HTTP Header의 Status를 검증
                               : 우리가 흔히 알고 있는 200,404,500 등의 상태 검증
   .andExpect(content()/string(hello)) : mvc.perform의 결과를 검증
                                       : 응답 본문의 내용을 검증
                                       : Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    /* param : API 테스트할때 사용될 요청 파라미터를 설정
             : 값은 String만 허용(다른건 문자열로 변환해줘야함)
       jsonPath : JSON 응답값을 필드별로 검증가능한 메소드
                : $를 기준으로 필드명을 명시
                :여기서는 name과 amount를 검증하니 $.name, $amount로 검증

     */
    @Test
    public void helloDto가_리턴된다() throws Exception {

        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
