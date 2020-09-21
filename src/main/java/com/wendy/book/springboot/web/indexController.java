package com.wendy.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때
   앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨.
   앞의경로 : src/main/resources/templates
   뒤의 확장자 : .mustache
   즉 여기서는 "index"를 반환하므로
   src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리하게됨.
 */
@RequiredArgsConstructor
@Controller
public class indexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
