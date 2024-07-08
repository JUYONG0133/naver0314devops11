// 첫 컴포넌트는 class 형태로

//hooks 문법이 추가된 이후는 class 형태보단 function 형태로 씀

import {Component} from "react";
import car1 from '../car8.png';
import car2 from '../car9.png';
import car3 from '../car10.png';
import './MyStyle.css';


class OneApp extends Component{
    render() {

        return(
            <div>
                <h1 className="alert alert-danger">One App--class 형태</h1>
                <h5>public 의 사진 가져오기</h5>
                <img src="./8.jpg" alt="사진1" width={200}/>
                <img src="./7.jpg" alt="사진2"
                     style={{width: '200px', border: '5px solid green', borderRadius: '50px 20px 100px 10px'}}/>
                <br/><br/>
                <h5>src 의 사진 가져오기</h5>
                <img src={car1} alt="car1" className="photo line1"/>
                <img src={car2} alt="car2" className="photo line2"/>
                <img src={car3} alt="car3" className="photo line3" />
            </div>
        )
    }
}

export default OneApp; //default 는 단 한번만 사용가능;
                        // import 시에 마음대로 이름 지정가능
// export {OneApp} //이 경우에느느 default 로 하지 않았기 때문에 import시 정확한 이름으로 해야함
