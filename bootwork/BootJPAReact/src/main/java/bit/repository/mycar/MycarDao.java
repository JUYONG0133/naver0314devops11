package bit.repository.mycar;


import bit.data.mycar.MycarDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MycarDao {

    private MyCarDaoInter myCarDaoInter;

    public List<MycarDto> getAllDatas(){
        return myCarDaoInter.findAll(Sort.by(Sort.Direction.DESC,"num"));   //  번호의 내림차순임
    }

    public void insertMycar(MycarDto dto){
        myCarDaoInter.save(dto);
    }

    public void deleteMycar(Long num){
        myCarDaoInter.deleteById(num);
    }
    public MycarDto getData(Long num){
        return myCarDaoInter.getReferenceById(num);
    }
    public void updateMycar(MycarDto dto){
        myCarDaoInter.save(dto);
    }
}
