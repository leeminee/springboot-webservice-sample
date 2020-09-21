package com.wendy.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


/* 이 클래스는 모든 Entity의 상위 클래스가 되어
   Entity들의 createDate, modifiedDate를 자동으로 관리하는 역할을한다.
   @MappedSuperclass
   : JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우
    필드들(createdDate,modifiedDate)도 칼럼으로 인식하도록함.
   @EntityListeners(AuditingEntityListener.class)
   : BaseTimeEntity 클래스에 Auditing 기능을 포함시킴.
   @CreatedDate
   : Entity가 생성되어 저장될 때 시간이 자동 저장.
   @LastModifiedDate
   : 조회한 Entity의 값을 변경할 때 시간이 자동 저장.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
