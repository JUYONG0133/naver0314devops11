package day0520.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodDto {

    //폼태그의 name과 같아야한다,
    private String foodname;
    private String foodphoto;
    private int price;
    private int cnt;

}
