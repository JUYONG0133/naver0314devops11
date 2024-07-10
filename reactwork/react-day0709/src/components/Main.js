// Main에 각종 컴포넌트를 배치
// 이번에는 함수형으로 만들어봄

import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import SixApp from "./SixApp";
import SevenApp from "./SevenApp";
import EigthApp from "./EigthApp";
import {useState} from "react";

const Main=()=>{
    const [idx,setIdx]=useState(8);
    return(

        <div>
            <h1 >24/07/09 react 수업</h1>
            <hr style={{color:"darkblue"}}/>
            <select className="form-select" style={{width:'400px'}}
                    onChange={(e)=>setIdx(Number(e.target.value))}>
                <option  value={1}>1번 styled-components</option>
                <option  value={2}>2번 이미지 불러오기</option>
                <option  value={3}>3번 show/hide</option>
                <option  value={4}>4번 mui의 card</option>
                <option  value={5}>5번 useEffect </option>
                <option  value={6}>6번 map-반복문</option>
                <option  value={7}>7번 </option>
                <option selected value={8}>8번 오늘 문제</option>
            </select>
            <br/>
            {
                idx===1?<OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>:idx===4?<FourApp/>:idx===5?<FiveApp/>:idx===6?<SixApp/>:idx===7?<SevenApp/>:<EigthApp/>
            }
        </div>
    )
}

export default Main; //export 는 항상 줘야함 잊지말고,