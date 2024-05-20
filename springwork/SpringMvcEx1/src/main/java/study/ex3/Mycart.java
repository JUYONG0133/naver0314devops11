package study.ex3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class Mycart {
    Person person;
    @NonNull
    private String sangpum;
    @NonNull
    private int price;

//    public Mycart(String sangpum,int price){
//        this.sangpum=sangpum;
//        this.price=price;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

    public void showInfo(){
        System.out.println("쇼핑한사람 이름 : "+person.getName());
        System.out.println("쇼핑한사람 핸드폰번호 : "+person.getPhone());
        System.out.println("상품명 : "+sangpum);
        System.out.println("가격 : "+price);
    }
}
