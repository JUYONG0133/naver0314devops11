package mycar.repository;


import lombok.AllArgsConstructor;
import mycar.data.MycarDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MyCarDao{
    private MyCarDaoInter daoInter;

    //db에저장
    public void insertCar(MycarDto dto) {
        daoInter.save(dto);// id타입이 포함되어 있을경우 자동으로 update 실행, 없을경우 insert 실행
    }

    //전체 목록
    public List<MycarDto> getAllCars(){

        return daoInter.findAll(); // 추가된 순서로 반환
//        return daoInter.findAll(Sort.by(Sort.Direction.DESC,"carprice")); //가격이 비싼거부터 출력
//        return daoInter.findAll(Sort.by(Sort.Direction.ASC,"carname")); // 자동차명의 오름차순
    }

    public MycarDto getData(Long num){
        return daoInter.getReferenceById(num);
    }

    public void updateCar(MycarDto dto){
        if(dto.getCarphoto().equals("no")){
            daoInter.updateMycarNoPhoto(dto.getNum(), dto.getCarname(), dto.getCarprice(), dto.getCarcolor());
        }
        else
            daoInter.save(dto);
    }

    public void deleteCar(Long num){
        daoInter.deleteById(num);
    }

    public Long getTotalCount(){
        return daoInter.count();
    }

    public Page<MycarDto> getAllCars(Pageable pageable){

        return daoInter.findAll(pageable);
    }

}
