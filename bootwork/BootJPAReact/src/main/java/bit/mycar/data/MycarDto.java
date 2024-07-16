package bit.mycar.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@Entity
@Table(name = "mycar") //테이블명
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MycarDto {
    @Id //시퀀스 (pk)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동증분
    private Long num;

    @Column(name = "carname",length = 30) //name이 변수명이랑 같을 경우 생략가능함
    private String carname;

    private int carprice; // name이 변수명이랑 같을 경우 생략함

    @Column(length = 20) // string형의 크기 지정같은 경우 기본값이 있지만 그냥 지정해줌
    private String carcolor;

    @Column(length = 20,updatable = false)
    private String carguip;

    @Column(length = 100,updatable = false) // 얘는 uuid로 할거같아서 100byte 준듯?
    private String carphoto;



    @CreationTimestamp //현재시간으로 넣을거임   now() 와 비슷
    @Column(updatable = false) //수정시 얘는 제외해서 수정하는거
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp writeday;

    @Transient // 테이블의 컬럼으로는 안만들고 객체에서만 사용가능한 멤버변수
    private int commentcount; //댓글 개수
    @Transient
    private String message; //하고 싶은 말

}
