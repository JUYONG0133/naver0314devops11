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
}
