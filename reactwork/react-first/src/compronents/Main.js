// Main에 각종 컴포넌트를 배치
// 이번에는 함수형으로 만들어봄

import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import SixApp from "./SixApp";

const Main=()=>{
    return(

        <div>
            <SixApp/>
            <hr/>
            <FiveApp/>
            <hr/>
            <FourApp/>
            <hr/>
            <ThreeApp/>
            <hr/>
            <TwoApp/>
            <hr/>
            <OneApp />
            <hr />


        </div>
    )
}

export default Main; //export 는 항상 줘야함 잊지말고,