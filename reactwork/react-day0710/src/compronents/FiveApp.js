import React from 'react';
import {Alert} from "@mui/material";
import FiveChildApp from "./FiveChildApp";
import FiveChild2App from "./FiveChild2App";


const FiveApp = () => {
    return (
        <div>
            <Alert>FiveApp-부모자식간의 통신 #1</Alert>
            <h5>FiveChildApp 컴포넌트 호출</h5>
            <FiveChildApp irum={'이영자'} age={23} addr={'서울시'}/>
            <FiveChildApp irum={'강호동'} age={41} addr={'제주도'}/>
            <FiveChildApp irum={'손흥민'} age={33} addr={'부산시'}/>

            <hr/>
            <h5>FiveChild2App 컴포넌트 호출</h5>
            <FiveChild2App irum='이미자' photo={'mycar11.png'} msg="노란색차"/>
            <FiveChild2App irum='강미자' photo={'mycar13.png'} msg="분홍색차"/>


        </div>
    );
};

export default FiveApp;