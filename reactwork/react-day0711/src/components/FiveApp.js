import React, {useEffect, useState} from 'react';
import {Alert} from "@mui/material";
import Axios from "axios";
import FiveRowItem from "./FiveRowItem";

const FiveApp = () => {

    const [mycarlist,setMyCarList]=useState([]);

    const list = ()=>{
        Axios.get("/mycar/list")
        .then(res=>{
            setMyCarList(res.data);
        })
    }
    useEffect(() => {
        list();
    }, []);

    return (
        <div>
            <Alert variant='outlined' color='warning'>FiveApp db-axios 데이터가져오기</Alert>
            <Alert severity='info'>총 {mycarlist.length}개의 자동차 정보 있음.</Alert>
            <table className='table table-bordered' style={{width:'300'}}>
                <tbody>
                {
                    mycarlist.map((mycar,idx)=>
                    <FiveRowItem mycar={mycar} key={idx}/>)
                }
                </tbody>
            </table>
        </div>
    );
};

export default FiveApp;