package bit.mycar.service;


import bit.mycar.data.MycarDto;
import bit.mycar.repository.MycarDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyCarService {

    private MycarDao mycarDao;

    public List<MycarDto> getAllDatas(){

        return mycarDao.getAllDatas();
    }

    public void insertMycar(MycarDto dto){
        mycarDao.insertMycar(dto);
    }
    public void deleteMycar(Long num){
        mycarDao.deleteMycar(num);

    }
    public MycarDto getData(Long num){
        return mycarDao.getData(num);
    }

    public void updateMycar(MycarDto dto){
        mycarDao.updateMycar(dto);
    }
}
