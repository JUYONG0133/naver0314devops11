package study.ex2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class student {
    private String schoolName;
    @NonNull
    Myinfo myinfo;

//    public student(Myinfo info) {
//        myinfo = info;
//    }
//
//
//    public void setSchoolName(String schoolName) {
//        this.schoolName = schoolName;
//    }

    public void show(){
        System.out.println(myinfo);
        System.out.println("학교명 : "+schoolName);
    }


}
