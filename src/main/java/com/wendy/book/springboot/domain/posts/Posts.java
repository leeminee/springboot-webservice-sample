package com.wendy.book.springboot.domain.posts;

import com.wendy.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/* @Entity
   : 테이블과 링크될 클래스임을 나타냄.
   : 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭함.
   ex) SalesManager.java -> sales_manager table
   @Id
   : 해당 테이블의 PK 필드를 나타냄.
   @GeneratedValue
   : PK 생성규칙
   : 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨.
   @Column
   : 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이됨.
   : 사용하는 이유 : 기본값외에 추가로 변경이 필요한 옵션이 있으면 사용.
   : 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나,
     타입을 TEXT로 변경하고 싶거나 등의 경우에 사용됨.
   @Builder
   : 해당 클래스의 빌더 패턴 클래스를 생성
   : 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
 */
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
