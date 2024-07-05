package mycar.repository;

import jakarta.transaction.Transactional;
import mycar.data.MycarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MyCarDaoInter extends JpaRepository<MycarDto,Long> {

    //사진을 선택 안했을경우 사진하고 구입날짜는 빼고 수정하는걸로 sql 작성
    @Query(value = """
            update mycar set carname=:carname, carprice=:carprice,carcolor=:carcolor where num=:num
            """,nativeQuery = true)
    @Modifying
    @Transactional
    public void updateMycarNoPhoto(@Param("num") Long num,@Param("carname")String carname,@Param("carprice")int carprice,@Param("carcolor")String carcolor);

    @Query(value = """
            update mycar set carname=:#{#dto.carname}, carprice=:#{#dto.carprice},carcolor=:#{#dto.carcolor} where num=:#{#dto.num}
            """,nativeQuery = true)
    @Modifying
    @Transactional
    public void updateMycarNoPhoto(@Param("dto") MycarDto dto);
}
