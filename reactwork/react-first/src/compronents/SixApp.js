import React, {useState} from 'react';
import car1 from "../car10.png";
import car2 from "../car9.png";
import car3 from "../car8.png";

const SixApp = () => {
    const [show,setShow]=useState(true);
    const [number,setNumber]=useState(200);
    const [name,setName]=useState('리액트 문제 다풀면 복습 100% 보장');
    const [photo,setPhoto]=useState(car1);
    const [layout,setLayout]=useState("solid");

    return (
        <div>
            <h1>오늘의 문제</h1>
            <hr/>
            <label>
                <input type="checkbox" defaultValue={show}
                       onClick={() => setShow(!show)}/>사진 숨기기
            </label>
            <div>
                <button type="button" className="btn btn-danger btn-sm"
                        style={{marginLeft: '60px'}} onClick={() => {
                    setNumber(number - 50);
                }}
                >
                    점점 작게
                </button>
                <button type="button" className="btn btn-success btn-sm"
                        style={{marginLeft: '10px'}} onClick={() => {
                    setNumber(number + 50);
                }}>
                    점점 크게
                </button>
            </div>
            <div>
                {
                    show &&
                    <img alt='car' src={photo} width={number} style={{border:`10px ${layout} hotpink`}}/>
                }
            </div>
            <input type="text" className="form-control" style={{width: '400px'}}
                   value={name}
                   onChange={(e) => setName(e.target.value)}
            />
            <div width={500} className="alert alert-info" style={{fontSize:"30px",fontFamily:"Gaegu"}}>{name}</div>


            <select className='form-select' style={{width: '120px'}}
                    onChange={(e) => setPhoto(e.target.value)}
            >
                <option selected value={car1}>카이엔</option>
                <option value={car2}>넥소</option>
                <option value={car3}>코나</option>
            </select>
            <select className='form-select' style={{width: '120px'}}
                    onChange={(e) => setLayout(e.target.value)}
            >
                <option selected value="solid">solid</option>
                <option value="double">double</option>
                <option value="dotted">dotted</option>
                <option value="dashed">dashed</option>
            </select>


        </div>
    );
};

export default SixApp;