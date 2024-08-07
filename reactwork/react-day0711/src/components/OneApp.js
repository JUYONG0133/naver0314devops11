import React, {useState} from 'react';
import {Alert, Button} from "@mui/material";
import OneSubApp from "./OneSubApp";

const OneApp = () => {
    const [inputArray,setInputArray]=useState([
        {sname:'신상슈즈',scolor:'red',sprice:23000,sphoto:'15.jpg'}
    ]);
    const [inputs,setInputs]=useState({
        sname:'',
        sphoto:'14.jpg',
        sprice:0,
        scolor:'#ffccff'
    });
    //각 입력태그에서 호출할 이벤트
    const changeDataEvent =(e)=>{
        let {name,value}=e.target;

        setInputs(
            {
                ...inputs, //나머지 값들은 그대로 유지
                [name]:value //같은 name을 찾아서 value값 넣기
            }
        )
    }

    //상품추가버튼 이벤트
    const addSangpumEvent=()=>{
        setInputArray(inputArray.concat(inputs))
    }
    //입력값 초기화 버튼 이벤트
    const initDataEvent=()=>{
        setInputs({
            sname:'',
            sphoto:'',
            sprice:0,
            scolor:'#ffccff'
        });

    }

    //삭제 함수
    const deleteSangpum = (idx)=>{
        setInputArray(inputArray.filter((d,i)=>i!==idx));
    }
    return (
        <div>
            <Alert>OneApp -모든 입력값 하나의 변수에 넣기</Alert>
            <table className='table table-bordered' style={{width:'300px'}}>
                <tbody>
                <tr>
                    <th style={{backgroundColor: '#ccf', width: '100px'}}>상품명</th>
                    <td>
                        <input type='text' className='form-control'
                               value={inputs.sname} name="sname" onChange={changeDataEvent}/>
                    </td>
                </tr>
                <tr>
                    <th style={{backgroundColor: "#ccf", width: "100px"}}>색상</th>
                    <td><input type="color" className="form-control"  value={inputs.scolor}
                               name="scolor" onChange={changeDataEvent}/></td>
                </tr>
                <tr>
                    <th style={{backgroundColor: '#ccf', width: '100px'}}>가격</th>
                    <td>
                        <input type='text' className='form-control'
                               value={inputs.sprice} name="sprice" onChange={changeDataEvent}/>
                    </td>
                </tr>
                <tr>
                    <th style={{backgroundColor: '#ccf', width: '100px'}}>사진</th>
                    <td>
                        <select className='form-select' name="sphoto" onChange={changeDataEvent}>
                            <option selected value={'14.jpg'}>플랫슈즈</option>
                            <option value={'23.jpg'}>여름용모자</option>
                            <option value={'30.jpg'}>보석머리띠</option>
                            <option value={'32.jpg'}>투피스</option>
                            <option value={'31.jpg'}>자켓</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td colSpan={2} align='center'>
                        <Button variant='contained' color='success' onClick={addSangpumEvent}>상품 추가</Button>&nbsp;
                        <Button variant='contained' color='info' size="small" onClick={initDataEvent}>초기화</Button>&nbsp;
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} align='center'>
                        <h4>
                            상품명 : {inputs.sname}<br/>
                            색 상 : {inputs.scolor}<br/>
                            가 격 : {inputs.sprice}<br/>
                            사 진 : {inputs.sphoto}<br/>
                        </h4>
                    </td>
                </tr>
                </tbody>
            </table>
            <h4>총 {inputArray.length}개의 배열 데이타가 있습니다</h4>
            <table className='table table-bordered' style={{width:'400px'}}>
                <tbody>
                {
                    inputArray.map((item,idx)=>
                        <OneSubApp key={idx} idx={idx} item={item} deleteSangpum={deleteSangpum}/>)
                }
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;