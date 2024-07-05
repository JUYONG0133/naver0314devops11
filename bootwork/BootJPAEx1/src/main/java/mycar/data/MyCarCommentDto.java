package mycar.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;

@Entity
@Table(name = "mycar_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //오류날경우 추가,불필요한 직렬화를 막기위한 어노테이션
public class MyCarCommentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne
    @JoinColumn(name = "num")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MycarDto mycar;

    @Column(length = 200)
    private String comment;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp writeday;


}
