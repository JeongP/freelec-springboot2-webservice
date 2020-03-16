package com.jojoldu.book.springboot.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// 롬복의 어노테이션들은 테이블설계(여기선 entity 설계)가 빈번하게 변경되는 상황에 코드 변경량을 최소화해줌.
@Getter
@NoArgsConstructor // 기본 생성자 자동 추가. == public Posts() {}
@Entity // 테이블과 링크될 클래스.
public class Posts {
    @Id // 해당 테이블의 PK필드를 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙
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
}
