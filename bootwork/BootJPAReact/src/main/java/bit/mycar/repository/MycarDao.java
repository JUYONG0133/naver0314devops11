package bit.mycar.repository;


import bit.mycar.data.MycarDto;
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

}