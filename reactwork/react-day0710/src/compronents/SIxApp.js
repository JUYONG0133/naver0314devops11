import React, {useState} from 'react';
import {Alert} from "@mui/material";
import SixChildApp from "./SixChildApp";

const SIxApp = () => {
    const [count,setCount]=useState(0);

    const countIncre = ()=> setCount(count+1);
    return (
        <div>
            <Alert>SixApp-부모자식간의 통신 #2</Alert>
            <Alert severity='error' style={{fontSize:'20px'}}>회원 방문 횟수 {count} 회</Alert>
            <SixChildApp carname="아반떼" carphoto="mycar8.png" carprice="3500" onIncre={countIncre}/>
            <SixChildApp carname="그랜저" carphoto="mycar1.png" carprice="4500" onIncre={countIncre}/>

        </div>
    );
};

export default SIxApp;