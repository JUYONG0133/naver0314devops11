import React, { useEffect, useState } from 'react';
import Axios from "axios";
import { Alert, Button } from "@mui/material";
import MyCarRowItem from "./MyCarRowItem";
import MyCarWriteForm from "./MyCarWriteForm";

const MycarList = () => {
    const [list, setList] = useState([]);
    const [show, setShow] = useState(true);

    const myCarList = () => {
        Axios.get("/mycar/list")
            .then(res => setList(res.data));
    }
    // 처음 시작 시 목록 가져오기
    useEffect(() => {
        myCarList();
    }, []);

    const addMycarEvent = (data) => {
        Axios.post("/mycar/insert", data)
            .then(res => {
                myCarList();
            });
    }

    const deleteMycarEvent = (num) => {
        Axios.delete("/mycar/delete?num="+num)
            .then(res => {
                myCarList();
            });
        console.log(num);
    }

    const updateMycar=(data)=>{
        Axios.post("/mycar/update",data)
            .then(res=>{
               myCarList();
            });
    }

    return (
        <div>
            <Button variant='contained' color='info' onClick={() => setShow(!show)}>자동차 등록</Button>
            {
                show &&
                <MyCarWriteForm onSave={addMycarEvent} />
            }
            <Alert severity='success' style={{ fontSize: '15px', width: '500px' }}>
                <b>
                    총 {list.length}개 있음
                </b>
            </Alert>
            <table className='table table-bordered' >
                <thead>
                <tr className='table-danger'>
                    <th style={{ width: '140px' }}>자동차명</th>
                    <th style={{ width: '100px' }}>가격</th>
                    <th style={{ width: '100px' }}>색상</th>
                    <th style={{ width: '100px' }}>구입일</th>
                    <th style={{ width: '100px' }}>등록일</th>
                </tr>
                </thead>
                <tbody>
                {
                    list.map((row, idx) =>
                        <MyCarRowItem key={idx} idx={idx} row={row} onDel={deleteMycarEvent} onUpDate={updateMycar}/>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default MycarList;
